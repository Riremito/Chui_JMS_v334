package net.swordie.ms.connection.packet;

import net.swordie.ms.client.Account;
import net.swordie.ms.client.User;
import net.swordie.ms.client.character.Char;
import net.swordie.ms.connection.OutPacket;
import net.swordie.ms.constants.JobConstants;
import net.swordie.ms.ServerConstants;
import net.swordie.ms.enums.LoginType;
import net.swordie.ms.ServerStatus;
import net.swordie.ms.handlers.header.OutHeader;
import net.swordie.ms.util.Position;
import net.swordie.ms.util.container.Tuple;
import net.swordie.ms.world.Channel;
import net.swordie.ms.Server;
import net.swordie.ms.world.World;
import net.swordie.ms.util.FileTime;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Tim on 2/28/2017.
 */
public class Login {

    public static OutPacket sendConnect(byte[] siv, byte[] riv) {
        OutPacket oPacket = new OutPacket();

        // version (short) + MapleString (short + char array size) + local IV (int) + remote IV (int) + locale (byte)
        // 0xE
        oPacket.encodeShort((short) 16);
        oPacket.encodeShort(ServerConstants.VERSION);
        oPacket.encodeString(ServerConstants.MINOR_VERSION);
        oPacket.encodeArr(siv);
        oPacket.encodeArr(riv);
        oPacket.encodeByte(ServerConstants.LOCALE);
        oPacket.encodeByte(false);
        oPacket.encodeByte(0);
        return oPacket;
    }

    public static OutPacket sendAliveReq() {
        return new OutPacket(OutHeader.ALIVE_REQ.getValue());
    }

    public static OutPacket sendAuthServer(boolean useAuthServer) {
        OutPacket outPacket = new OutPacket(OutHeader.AUTH_SERVER.getValue());
        outPacket.encodeByte(useAuthServer);
        return outPacket;
    }

    public static OutPacket setHotFix(boolean incorrectHotFix) {
        OutPacket outPacket = new OutPacket(OutHeader.SET_HOT_FIX.getValue());
        outPacket.encodeByte(incorrectHotFix);
        return outPacket;
    }

    public static OutPacket setHotFix(ArrayList<Byte> encryptedHotFixLen, byte[] dataWzHash, byte[] hotFix) {
        OutPacket outPacket = new OutPacket(OutHeader.SET_HOT_FIX.getValue());
        for(Byte lenByte : encryptedHotFixLen)  {
            outPacket.encodeByte(lenByte);
        }
        outPacket.encodeArr(dataWzHash);
        outPacket.encodeArr(hotFix);
        return outPacket;
    }

    public static OutPacket getLoginBackground() {
        OutPacket outPacket = new OutPacket(OutHeader.MAPLOGIN.getValue());
//        String[] bg = {"MapLogin", "MapLogin1", "MapLogin2"};
        outPacket.encodeString("MapLogin2"/*bg[(int) (Math.random() * bg.length)]*/);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String time = sdf.format(Calendar.getInstance().getTime());
//        final String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        outPacket.encodeInt(Integer.parseInt(new StringBuilder(time.substring(0, 4)).append(time, 5, 7).append(time, 8, 10).append(time, 11, 13).toString()));

        return outPacket;
    }

    public static OutPacket checkPasswordResult(boolean success, LoginType msg, User user) {
        OutPacket outPacket = new OutPacket(OutHeader.CHECK_PASSWORD_RESULT.getValue());

        if (success) {
            outPacket.encodeByte(LoginType.Success.getValue());
            outPacket.encodeByte(0);
            outPacket.encodeInt(user.getId());
            outPacket.encodeByte(user.getGender());
            outPacket.encodeByte(user.getMsg2());
            outPacket.encodeInt(user.getAccountType().getVal());
            outPacket.encodeInt(user.getVipGrade());
            outPacket.encodeInt(user.getAge());
            outPacket.encodeByte(0);
            outPacket.encodeByte(0);
            outPacket.encodeString(user.getName());
            outPacket.encodeString(user.getName());
            outPacket.encodeByte(user.getpBlockReason());
            outPacket.encodeByte(0); // idk
            outPacket.encodeByte(0);
            outPacket.encodeByte(-1); // 第二組密碼 -1=不需要設定 0=需要設定 1=已經有了 需要輸入
            outPacket.encodeByte(1); // 0 = nexon簡單會員
            outPacket.encodeLong(user.getChatUnblockDate());
            outPacket.encodeByte(!user.hasCensoredNxLoginID());
            if (user.hasCensoredNxLoginID()) {
                outPacket.encodeString(user.getCensoredNxLoginID());
            }
            outPacket.encodeByte(0);
            outPacket.encodeString("");
            JobConstants.encode(outPacket);
//            outPacket.encodeByte(user.getGradeCode());
//            outPacket.encodeInt(-1);
//            outPacket.encodeByte(0); // idk
//            outPacket.encodeByte(0); // ^
//            outPacket.encodeFT(user.getCreationDate());
        } else if (msg == LoginType.Blocked) {
            outPacket.encodeByte(msg.getValue());
            outPacket.encodeByte(0);
            outPacket.encodeInt(0);
            outPacket.encodeByte(0); // nReason
            outPacket.encodeFT(user.getBanExpireDate());
        } else {
            outPacket.encodeByte(msg.getValue());
            outPacket.encodeByte(0); // these two aren't in ida, wtf
            outPacket.encodeInt(0);
        }

        return outPacket;
    }

    public static OutPacket checkPasswordResultForBan(User user) {
        OutPacket outPacket = new OutPacket(OutHeader.CHECK_PASSWORD_RESULT);

        outPacket.encodeByte(LoginType.BlockedNexonID.getValue());
        outPacket.encodeByte(0);
        outPacket.encodeInt(0);
        outPacket.encodeByte(0);
        outPacket.encodeFT(user.getBanExpireDate());

        return outPacket;
    }

    public static OutPacket sendAccountInfo(User user) {
        OutPacket outPacket = new OutPacket(OutHeader.ACCOUNT_INFO_RESULT);

        outPacket.encodeByte(0); // succeed
        outPacket.encodeInt(user.getId());
        outPacket.encodeByte(user.getGender());
        outPacket.encodeByte(user.getGradeCode());
        outPacket.encodeInt(user.getAccountType().getVal());
        outPacket.encodeInt(user.getVipGrade());
        outPacket.encodeInt(user.getAge());
        outPacket.encodeByte(user.getPurchaseExp());
        outPacket.encodeByte(user.getnBlockReason());
        outPacket.encodeLong(user.getChatUnblockDate());
        outPacket.encodeString(user.getName());
        outPacket.encodeString(user.getCensoredNxLoginID());
        outPacket.encodeString(""); //v25 = CInPacket::DecodeStr(iPacket_1, &nAge);
        JobConstants.encode(outPacket);
        outPacket.encodeByte(0);

        return outPacket;
    }

    public static OutPacket sendWorldInformation(World world, Set<Tuple<Position, String>> stringInfos) {
        // CLogin::OnWorldInformation
        OutPacket outPacket = new OutPacket(OutHeader.WORLD_INFORMATION.getValue());

        outPacket.encodeByte(world.getWorldId());
        outPacket.encodeString(world.getName());
        outPacket.encodeByte(world.getWorldState());
        outPacket.encodeString(world.getWorldEventDescription());
        outPacket.encodeShort(world.getWorldEventEXP_WSE());
        outPacket.encodeShort(world.getWorldEventDrop_WSE());
//        outPacket.encodeByte(world.isCharCreateBlock());
        outPacket.encodeByte(world.getChannels().size());
        for (Channel c : world.getChannels()) {
            outPacket.encodeString(c.getName());
            outPacket.encodeInt(c.getGaugePx());
            outPacket.encodeByte(c.getWorldId());
            outPacket.encodeByte(c.getChannelId());
            outPacket.encodeByte(c.isAdultChannel());
            outPacket.encodeByte(0);
        }
        if (stringInfos == null) {
            outPacket.encodeShort(0);
        } else {
            outPacket.encodeShort(stringInfos.size());
            for (Tuple<Position, String> stringInfo : stringInfos) {
                outPacket.encodePosition(stringInfo.getLeft());
                outPacket.encodeString(stringInfo.getRight());
            }
        }
        outPacket.encodeInt(0); // some offset
        outPacket.encodeInt(0x0E/*0x01*/); // 這邊是0的話將不能創角色
//        outPacket.encodeByte(false); // connect with star planet stuff, not interested
        return outPacket;
    }

    public static OutPacket sendWorldInformationEnd() {
        OutPacket outPacket = new OutPacket(OutHeader.WORLD_INFORMATION);

        outPacket.encodeByte(-1);
        outPacket.encodeByte(0);
        outPacket.encodeByte(0);
        outPacket.encodeByte(0);

        return outPacket;
    }

    public static OutPacket sendServerStatus(byte worldId) {
        OutPacket outPacket = new OutPacket(OutHeader.SERVER_STATUS.getValue());
        World world = null;
        for (World w : Server.getInstance().getWorlds()) {
            if (w.getWorldId() == worldId) {
                world = w;
            }
        }
        if (world != null && !world.isFull()) {
            outPacket.encodeByte(world.getStatus().getValue());
        } else {
            outPacket.encodeByte(ServerStatus.BUSY.getValue());
        }
        outPacket.encodeByte(0); // ?

        return outPacket;
    }

    public static OutPacket selectWorldResult(User user, Account account, byte code, String specialServer,
                                              boolean burningEventBlock) {
        OutPacket outPacket = new OutPacket(OutHeader.SELECT_WORLD_RESULT);

        outPacket.encodeByte(code);
//        outPacket.encodeString(specialServer);
//        outPacket.encodeInt(account.getTrunk().getSlotCount());
//        outPacket.encodeByte(burningEventBlock); // bBurningEventBlock
        int reserved = 0;
        outPacket.encodeInt(reserved); // Reserved size
        outPacket.encodeFT(FileTime.fromType(FileTime.Type.ZERO_TIME)); //Reserved timestamp
        for (int i = 0; i < reserved; i++) {
            // not really interested in this
            FileTime ft = FileTime.fromType(FileTime.Type.ZERO_TIME);
            outPacket.encodeInt(ft.getLowDateTime());
            ft.encode(outPacket);
        }
        outPacket.encodeString(user.getName());
//        boolean isEdited = false;
//        outPacket.encodeByte(isEdited); // edited characters
        List<Char> chars = new ArrayList<>(account.getCharacters());
        chars.sort(Comparator.comparingInt(Char::getId));
/*        int orderSize = chars.size();
        outPacket.encodeInt(orderSize);
        for (Char chr : chars) {
            // order of chars
            outPacket.encodeInt(chr.getId());
        }*/

        outPacket.encodeByte(chars.size());
        for (Char chr : chars) {
            chr.getAvatarData().encode(outPacket);
            outPacket.encodeByte(false); // family stuff, deprecated (v61 = &v2->m_abOnFamily.a[v59];)
            boolean hasRanking = chr.getRanking() != null && !JobConstants.isGmJob(chr.getJob());
            outPacket.encodeByte(hasRanking);
            if (hasRanking) {
                chr.getRanking().encode(outPacket);
            }
        }
        outPacket.encodeByte(user.getPicStatus().getVal()); // bLoginOpt
//        outPacket.encodeByte(false); // bQuerySSNOnCreateNewCharacter
        outPacket.encodeInt(user.getCharacterSlots());
        outPacket.encodeInt(0); // buying char slots
        outPacket.encodeInt(-1); // nEventNewCharJob
        outPacket.encodeFT(FileTime.fromType(FileTime.Type.ZERO_TIME));
        outPacket.encodeByte(0); // nRenameCount
//        outPacket.encodeByte(0);

        return outPacket;
    }

    public static OutPacket checkDuplicatedIDResult(String name, byte code) {
        OutPacket outPacket = new OutPacket(OutHeader.CHECK_DUPLICATED_ID_RESULT);

        outPacket.encodeString(name);
        outPacket.encodeByte(code);

        return outPacket;
    }

    public static OutPacket createNewCharacterResult(LoginType type, Char c) {
        OutPacket outPacket = new OutPacket(OutHeader.CREATE_NEW_CHARACTER_RESULT);

        outPacket.encodeByte(type.getValue());
        if (type == LoginType.Success) {
            c.getAvatarData().encode(outPacket);
        }

        return outPacket;
    }

    public static OutPacket sendAuthResponse(int response) {
        OutPacket outPacket = new OutPacket(OutHeader.PRIVATE_SERVER_PACKET);

        outPacket.encodeInt(response);

        return outPacket;
    }

    public static OutPacket selectCharacterResult(LoginType loginType, byte errorCode, int port, int characterId) {
        OutPacket outPacket = new OutPacket(OutHeader.SELECT_CHARACTER_RESULT);

        outPacket.encodeByte(loginType.getValue());
        outPacket.encodeByte(errorCode);

        if (loginType == LoginType.Success) {
//            byte[] server = new byte[]{8, 31, 99, ((byte) 141)};
            byte[] server = new byte[]{127, 0, 0, ((byte) 1)};
            outPacket.encodeArr(server);
            outPacket.encodeShort(port);

//            byte[] chatServer = new byte[]{8, 31, 99, ((byte) 133)};
            byte[] chatServer = new byte[]{127, 0, 0, ((byte) 1)};
            // chat stuff
            outPacket.encodeArr(chatServer);
            outPacket.encodeShort(ServerConstants.CHAT_PORT);

            outPacket.encodeInt(characterId);
            outPacket.encodeByte(0);
            outPacket.encodeInt(0); // ulArgument
//            outPacket.encodeByte(0);
//            outPacket.encodeInt(0);
//            outPacket.encodeInt(0);
//            outPacket.encodeByte(0);
        }

        return outPacket;
    }

    public static OutPacket sendDeleteCharacterResult(int charId, LoginType loginType) {
        OutPacket outPacket = new OutPacket(OutHeader.DELETE_CHARACTER_RESULT);

        outPacket.encodeInt(charId);
        outPacket.encodeByte(loginType.getValue());

        return outPacket;
    }

    public static OutPacket sendRecommendWorldMessage(int nWorldID, String nMsg) {
        OutPacket oPacket = new OutPacket(OutHeader.RECOMMENDED_WORLD_MESSAGE);
        oPacket.encodeByte(1);
        oPacket.encodeInt(nWorldID);
        oPacket.encodeString(nMsg);
        return oPacket;
    }

    public static OutPacket changePicResponse(LoginType result) {
        OutPacket outPacket = new OutPacket(OutHeader.CHANGE_SPW_RESULT);
        outPacket.encodeByte(result.getValue());
        return outPacket;
    }
}
