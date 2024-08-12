package net.swordie.ms.life.movement;

import net.swordie.ms.client.character.Char;
import net.swordie.ms.connection.Encodable;
import net.swordie.ms.connection.InPacket;
import net.swordie.ms.connection.OutPacket;
import net.swordie.ms.life.Life;
import net.swordie.ms.util.Position;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sjonnie
 * Created on 8/16/2018.
 */
public class MovementInfo implements Encodable {
    private static final Logger log = Logger.getLogger(MovementInfo.class);

    private int encodedGatherDuration;
    private Position oldPos;
    private Position oldVPos;
    private List<Movement> movements = new ArrayList<>();
    private byte keyPadState;

    public MovementInfo(Position oldPos, Position oldVPos) {
        this.oldPos = oldPos;
        this.oldVPos = oldVPos;
    }

    public MovementInfo(InPacket inPacket) {
        decode(inPacket);
    }

    public void applyTo(Char chr) {
        for (Movement m : getMovements()) {
            m.applyTo(chr);
        }
    }

    public void applyTo(Life life) {
        for (Movement m : getMovements()) {
            m.applyTo(life);
        }
    }

    public void decode(InPacket inPacket) {
        encodedGatherDuration = inPacket.decodeInt();
        oldPos = inPacket.decodePosition();
        oldVPos = inPacket.decodePosition();
        movements = parseMovement(inPacket);
        keyPadState = inPacket.decodeByte();
    }

    @Override
    public void encode(OutPacket outPacket) {
        outPacket.encodeInt(encodedGatherDuration);
        outPacket.encodePosition(oldPos);
        outPacket.encodePosition(oldVPos);
        outPacket.encodeByte(movements.size());
        for(Movement m : movements) {
            m.encode(outPacket);
        }
        outPacket.encodeByte(keyPadState);
    }

    private static List<Movement> parseMovement(InPacket inPacket) {
        // Taken from mushy when my IDA wasn't able to show this properly
        // Made by Maxcloud
        List<Movement> res = new ArrayList<>();
        byte size = inPacket.decodeByte();
        for (int i = 0; i < size; i++) {
            byte type = inPacket.decodeByte();
            switch (type) {
                case 0:
                case 8:
                case 15:
                case 16:
                case 18:
                case 63:
                case 64:
                case 65:
                    res.add(new MovementNormal(inPacket, type));
                    break;
                case 1:
                case 2:
                case 17:
                case 20:
                case 21:
                case 23:
                case 58:
                case 59:
                case 60:
                case 61:
                    res.add(new MovementJump(inPacket, type));
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 9:
                case 10:
                case 11:
                case 13:
                case 25:
                case 26:
                case 51:
                case 52:
                case 53:
                case 67:
                    res.add(new MovementTeleport(inPacket, type));
                    break;
                case 12:
                    res.add(new MovementStatChange(inPacket, type));
                    break;
                case 14:
                    res.add(new MovementStartFallDown(inPacket, type));
                    break;
                case 22:
                    res.add(new MovementFlyingBlock(inPacket, type));
                    break;
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 56:
                case 57:
                case 70:
                    res.add(new MovementAction(inPacket, type));
                    break;
                case 55:
                case 62:
                    res.add(new MovementAngle(inPacket, type)); // probably not a good name
                    break;
                default:
                    log.warn(String.format("Unhandled move path attribute %s.", type));
                    break;
            }
        }
        return res;
    }

    public byte getKeyPadState() {
        return keyPadState;
    }

    public List<Movement> getMovements() {
        return movements;
    }
}
