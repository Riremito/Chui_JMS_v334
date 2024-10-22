package net.swordie.ms.enums;

/**
 * @author Sjonnie
 * Created on 8/31/2018.
 */
public enum InGameDirectionEventType {
    ForcedAction(0),
    Delay(1),
    EffectPlay(2),
    ForcedInput(3),
    PatternInputRequest(4),
    CameraMove(5),// automated send delay
    CameraOnCharacter(6),
    CameraZoom(7),// automated send delay
    CameraReleaseFromUserPoint(8),
    VansheeMode(9),
    FaceOff(10),
    Monologue(11),
    MonologueScroll(12),
    AvatarLookSet(13),
    RemoveAdditionalEffect(14),
    ForcedMove(15),
    ForcedFlip(16),
    InputUI(17),
    ;

    private final int val;

    InGameDirectionEventType(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
