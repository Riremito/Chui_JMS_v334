package net.swordie.ms.client.character.skills.temp;

import org.apache.log4j.LogManager;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 1/2/2018.
 */
public enum CharacterTemporaryStat implements Comparator<CharacterTemporaryStat> {
    IndiePAD(0),
    IndieMAD(1),
    IndiePDD(2),
    IndieMDD(3),
    IndieMHP(4),
    IndieMHPR(5),
    IndieMMP(6),
    IndieMMPR(7),

    IndieACC(8),
    IndieEVA(9),
    IndieJump(10),
    IndieSpeed(11),
    IndieAllStat(12),
    IndieDodgeCriticalTime(13),
    IndieEXP(14),
    IndieBooster(15),

    IndieFixedDamageR(16),
    PyramidStunBuff(17),
    PyramidFrozenBuff(18),
    PyramidFireBuff(19),
    PyramidBonusDamageBuff(20),
    IndieRelaxEXP(21),
    IndieSTR(22),
    IndieDEX(23),

    IndieINT(24),
    IndieLUK(25),
    IndieDamR(26),
    IndieScriptBuff(27),
    IndieMDF(28),
    IndieMaxDamageOver(29),
    IndieAsrR(30),
    IndieTerR(31),

    IndieCr(32),
    IndiePDDR(33),
    IndieCrMax(34),
    IndieBDR(35),
    IndieStatR(36),
    IndieStance(37),
    IndieIgnoreMobpdpR(38),
    IndieEmpty(39),

    IndiePADR(40),
    IndieMADR(41),
    IndieCrMaxR(42),
    IndieEVAR(43),
    IndieMDDR(44),
    IndieDrainHP(45),
    IndiePMdR(46),
    IndieMaxDamageOverR(47),

    IndieForceJump(48),
    IndieForceSpeed(49),
    IndieQrPointTerm(50),
    IndieUNK1(51),
    IndieUNK2(52),
    IndieUNK3(53),
    IndieUNK4(54),
    IndieUNK5(55),
    IndieStatCount(56),

    PAD(49),
    PDD(50),
    MAD(51),
    MDD(52),
    ACC(53),
    EVA(54),
    Craft(55),

    Speed(56/*64*/),
    Jump(57/*65*/),
    MagicGuard(58),
    DarkSight(59),
    Booster(60/*68*/), // 68可以讓角色攻擊都變MISS
    PowerGuard(61),
    MaxHP(62),
    MaxMP(63),

    Invincible(64),
    SoulArrow(65),
    Stun(66),
    Poison(67),
    Seal(68),
    Darkness(69),
    ComboCounter(70),
    WeaponCharge(71),

    HolySymbol(72),
    MesoUp(73),
    ShadowPartner(74),
    PickPocket(75),
    MesoGuard(76),
    Thaw(77),
    Weakness(78),
    Curse(79),

    Slow(80),
    Morph(81),
    Regen(82),
    BasicStatUp(83),
    Stance(84),
    SharpEyes(85),
    ManaReflection(86),
    Attract(87),

    NoBulletConsume(88),
    Infinity(89),
    AdvancedBless(90),
    IllusionStep(91),
    Blind(92),
    Concentration(93),
    BanMap(94),
    MaxLevelBuff(95),

    MesoUpByItem(96),
    Ghost(97),
    Barrier(98),
    ReverseInput(99),
    ItemUpByItem(100),
    RespectPImmune(101),
    RespectMImmune(102),

    DefenseAtt(103),
    DefenseState(104),
    DojangBerserk(105),
    DojangInvincible(106),
    DojangShield(107),
    SoulMasterFinal(108),
    WindBreakerFinal(109),
    ElementalReset(110),
    HideAttack(111),

    EventRate(112),
    ComboAbilityBuff(113),
    ComboDrain(114),
    ComboBarrier(115),
    BodyPressure(116),
    RepeatEffect(117),
    ExpBuffRate(118),
    StopPortion(119),
    StopMotion(120),
    Fear(121),
    HiddenPieceOn(122),
    MagicShield(123),
    MagicResistance(124),
    SoulStone(125),
    Flying(126),
    Frozen(127),

    AssistCharge(128),
    Enrage(129),
    DrawBack(130),
    NotDamaged(131),
    FinalCut(132),
    HowlingAttackDamage(133),
    BeastFormDamageUp(134),
    Dance(135),

    EMHP(136),
    EMMP(137),
    EPAD(138),
    EMAD(139),
    EPDD(140),
    EMDD(141),
    Guard(142),
    Cyclone(143),

    HowlingCritical(144),
    HowlingMaxMP(145),
    HowlingDefence(146),
    HowlingEvasion(147),
    Conversion(148),
    Revive(149),
    PinkbeanMinibeenMove(-1),
    Sneak(150),

    Mechanic(151),
    BeastFormMaxHP(152),
    Dice(153),
    BlessingArmor(154),
    DamR(155),
    TeleportMasteryOn(156/*164*/),
    CombatOrders(165),
    Beholder(166),

    DispelItemOption(167),
    Inflation(168),
    OnixDivineProtection(169),
    Web(170),
    Bless(171),
    TimeBomb(172),
    DisOrder(173),
    Thread(174),

    Team(175),
    Explosion(176),
    BuffLimit(177),
    STR(178),
    INT(179),
    DEX(180),
    LUK(181),
    DispelItemOptionByField(182),

    DarkTornado(183), // Cygnus Attack
    PVPDamage(184),
    PvPScoreBonus(185),
    PvPInvincible(186),
    PvPRaceEffect(187),
    WeaknessMdamage(188),
    Frozen2(189),
    PVPDamageSkill(190),

    AmplifyDamage(191),
    IceKnight(192),
    Shock(193),
    InfinityForce(194),
    IncMaxHP(195),
    IncMaxMP(196),
    HolyMagicShell(197),
    KeyDownTimeIgnore(198),

    ArcaneAim(200/*199*/),
    MasterMagicOn(200),
    AsrR(201),
    TerR(202),
    DamAbsorbShield(203),
    DevilishPower(204),
    Roulette(205),
    SpiritLink(206),

    AsrRByItem(207),
    Event(208),
    CriticalBuff(209),
    DropRate(210),
    PlusExpRate(211),
    ItemInvincible(212),
    Awake(213),
    ItemCritical(214),

    ItemEvade(215),
    Event2(216),
    VampiricTouch(217),
    DDR(218),
    IncCriticalDamMin(219),
    IncCriticalDamMax(220),
    IncTerR(221),
    IncAsrR(223),

    DeathMark(223),
    UsefulAdvancedBless(224),
    Lapidification(225),
    VenomSnake(226),
    CarnivalAttack(227),
    CarnivalDefence(228),
    CarnivalExp(229),
    SlowAttack(230),

    PyramidEffect(231),
    KillingPoint(232),
    HollowPointBullet(233),
    KeyDownMoving(234),
    IgnoreTargetDEF(235),
    ReviveOnce(236),
    Invisible(237),
    EnrageCr(238),

    EnrageCrDamMin(239),
    Judgement(240),
    DojangLuckyBonus(241),
    PainMark(242),
    Magnet(243),
    MagnetArea(244),
    VampDeath(245),
    BlessingArmorIncPAD(246),

    KeyDownAreaMoving(247),
    Larkness(248),
    StackBuff(249),
    BlessOfDarkness(250),
    AntiMagicShell(251),
    AntiMagicShellBool(252),
    LifeTidal(253),
    HitCriDamR(254),
    SmashStack(255),

    PartyBarrier(256),
    ReshuffleSwitch(257),
    SpecialAction(258),
    VampDeathSummon(259),
    StopForceAtomInfo(260),
    SoulGazeCriDamR(261),
    SoulRageCount(262),
    PowerTransferGauge(263),

    AffinitySlug(264),
    Trinity(265),
    IncMaxDamage(266),
    BossShield(267),
    MobZoneState(268),
    GiveMeHeal(269),
    TouchMe(270),
    Contagion(271),

    ComboUnlimited(272),
    SoulExalt(273),
    IgnorePCounter(274),
    IgnoreAllCounter(275),
    IgnorePImmune(276),
    IgnoreAllImmune(277),
    FinalJudgement(278),
    IceAura(279),

    FireAura(280),
    VengeanceOfAngel(281),
    HeavensDoor(282),
    Preparation(283),
    BullsEye(284),
    IncEffectHPPotion(285),
    IncEffectMPPotion(283),
    BleedingToxin(287),

    IgnoreMobDamR(288),
    Asura(286/*289*/),
    FlipTheCoin(287/*290*/),
    UnityOfPower(291),
    Stimulate(292),
    ReturnTeleport(293),
    DropRIncrease(294),
    IgnoreMobpdpR(295),

    BdR(296),
    CapDebuff(297),
    Exceed(298),
    DiabolikRecovery(299),
    FinalAttackProp(300),
    ExceedOverload(301),
    OverloadCount(302),
    BuckShot(303),

    FireBomb(304),
    HalfstatByDebuff(305),
    SurplusSupply(306),
    SetBaseDamage(307),
    EVAR(308),
    NewFlying(309),
    AmaranthGenerator(310),
    OnCapsule(311),

    CygnusElementSkill(312),
    StrikerHyperElectric(313),
    EventPointAbsorb(314),
    EventAssemble(315),
    StormBringer(316),
    ACCR(317),
    DEXR(318),
    Albatross(319),

    Translucence(320),
    PoseType(321),
    PoseTypeBool(321),
    LightOfSpirit(322),
    ElementSoul(323),
    GlimmeringTime(324),
    TrueSight(325),
    SoulExplosion(326),
    SoulMP(327),

    FullSoulMP(328),
    SoulSkillDamageUp(329),
    ElementalCharge(330),
    Restoration(331),
    CrossOverChain(332),
    ChargeBuff(333),
    Reincarnation(334),
    KnightsAura(335),

    ChillingStep(335),
    DotBasedBuff(335/*336*/),
    BlessEnsenble(338),
    ComboCostInc(339),
    ExtremeArchery(340),
    NaviFlying(341),
    QuiverCatridge(342),
    AdvancedQuiver(343),

    UserControlMob(344),
    ImmuneBarrier(345),
    ArmorPiercing(346),
    ZeroAuraStr(347),
    ZeroAuraSpd(348),
    CriticalGrowing(349),
    QuickDraw(350),
    BowMasterConcentration(351),

    TimeFastABuff(352),
    TimeFastBBuff(353),
    GatherDropR(354),
    AimBox2D(355),
    IncMonsterBattleCaptureRate(356),
    CursorSniping(357),
    DebuffTolerance(358),
    DotHealHPPerSecond(359),

    SpiritGuard(360),
    PreReviveOnce(361),
    SetBaseDamageByBuff(362),
    LimitMP(363),
    ReflectDamR(364),
    ComboTempest(365),
    MHPCutR(366),
    MMPCutR(367),

    SelfWeakness(368),
    ElementDarkness(369),
    FlareTrick(370),
    Ember(371),
    Dominion(372),
    SiphonVitality(373),
    DarknessAscension(374),
    BossWaitingLinesBuff(375),

    DamageReduce(376),
    ShadowServant(377),
    ShadowIllusion(378),
    KnockBack(379),
    AddAttackCount(380),
    ComplusionSlant(381),
    JaguarSummoned(382),
    JaguarCount(383),

    SSFShootingAttack(384),
    DevilCry(385),
    ShieldAttack(386),
    BMageAura(387),
    DarkLighting(388),
    AttackCountX(389),
    BMageDeath(390),
    BombTime(391),

    NoDebuff(392),
    BattlePvPMikeShield(393),
    BattlePvPMikeBugle(394),
    XenonAegisSystem(395),
    AngelicBursterSoulSeeker(396),
    HiddenPossession(397),
    NightWalkerBat(398),
    NightLordMark(399),

    WizardIgnite(400),
    FireBarrier(401),
    ChangeFoxMan(402),
    BattlePvPHelenaMark(403),
    BattlePvPHelenaWindSpirit(404),
    BattlePvPLangEProtection(405),
    BattlePvPLeeMalNyunScaleUp(406),
    BattlePvPRevive(407),

    PinkbeanAttackBuff(408),
    PinkbeanRelax(409),
    PinkbeanRollingGrade(410),
    PinkbeanYoYoStack(411),
    RandAreaAttack(412),
    NextAttackEnhance(413),
    AranBeyonderDamAbsorb(414),
    AranCombotempastOption(415),

    NautilusFinalAttack(416),
    ViperTimeLeap(417),
    RoyalGuardState(418),
    RoyalGuardPrepare(419),
    MichaelSoulLink(420),
    MichaelStanceLink(421),
    TriflingWhimOnOff(422),
    AddRangeOnOff(423),

    KinesisPsychicPoint(424),
    KinesisPsychicOver(425),
    KinesisPsychicShield(426),
    KinesisIncMastery(427),
    KinesisPsychicEnergeShield(428),
    BladeStance(429),
    DebuffActiveSkillHPCon(430),
    DebuffIncHP(431),

    BowMasterMortalBlow(432),
    AngelicBursterSoulResonance(433),
    Fever(434),
    IgnisRore(435),
    RpSiksin(436),
    TeleportMasteryRange(437),
    FixCoolTime(438),
    IncMobRateDummy(439),

    AdrenalinBoost(440),
    AranSmashSwing(441),
    AranDrain(442),
    AranBoostEndHunt(443),
    HiddenHyperLinkMaximization(444),
    RWCylinder(445),
    RWCombination(446),
    RWMagnumBlow(447),

    RWBarrier(448),
    RWBarrierHeal(449),
    RWMaximizeCannon(450),
    RWOverHeat(451),
    UsingScouter(452),
    RWMovingEvar(453),
    Stigma(454),
    Unk455(455),

    Unk456(456),
    Unk457(457),
    Unk458(458),
    Unk459(459),
    Unk460(460),
    HayatoStance(461),
    HayatoStanceBonus(462),
    EyeForEye(463),

    WillowDodge(464),
    Unk465(465),
    HayatoPAD(466),
    HayatoHPR(467),
    HayatoMPR(468),
    HayatoBooster(469),
    Unk470(470),
    Unk471(471),

    Jinsoku(472),
    HayatoCr(473),
    HakuBlessing(474),
    HayatoBoss(475),
    BattoujutsuAdvance(476),
    Unk477(477),
    Unk478(478),
    BlackHeartedCurse(479),

    BeastMode(480),
    TeamRoar(481),
    Unk482(482),
    Unk483(483),
    Unk484(484),
    Unk485(485),
    Unk486(486),
    Unk487(487),

    Unk488(488),
    Unk489(489),
    Unk490(490),
    Unk491(491),
    EnergyCharged(492),
    DashSpeed(493),
    DashJump(494),
    RideVehicle(495),

    PartyBooster(496),
    GuidedBullet(497),
    Undead(498),
    RideVehicleExpire(499),
    ;

    private int bitPos;
    private final int val;
    private final int pos;
    public static final int length = 13/*17*/;
    private static final org.apache.log4j.Logger log = LogManager.getRootLogger();

    private static final List<CharacterTemporaryStat> ORDER = Arrays.asList(
            STR, INT, DEX, LUK, PAD, PDD, MAD, MDD, ACC, EVA, EVAR, Craft, Speed, Jump, EMHP, EMMP, EPAD, EMAD, EPDD,
            EMDD, MagicGuard, DarkSight, Booster, PowerGuard, Guard, MaxHP, MaxMP, Invincible, SoulArrow, Stun, Shock,
            Poison, Seal, Darkness, ComboCounter, WeaponCharge, ElementalCharge, HolySymbol, MesoUp, ShadowPartner,
            PickPocket, MesoGuard, Thaw, Weakness, WeaknessMdamage, Curse, Slow, TimeBomb, BuffLimit, Team, DisOrder,
            Thread, Morph, Ghost, Regen, BasicStatUp, Stance, SharpEyes, ManaReflection, Attract, Magnet, MagnetArea,
            NoBulletConsume, StackBuff, Trinity, Infinity, AdvancedBless, IllusionStep, Blind, Concentration, BanMap,
            MaxLevelBuff, Barrier, DojangShield, ReverseInput, MesoUpByItem, ItemUpByItem, RespectPImmune,
            RespectMImmune, DefenseAtt, DefenseState, DojangBerserk, DojangInvincible, SoulMasterFinal,
            WindBreakerFinal, ElementalReset, HideAttack, EventRate, ComboAbilityBuff, ComboDrain, ComboBarrier,
            PartyBarrier, BodyPressure, RepeatEffect, ExpBuffRate, StopPortion, StopMotion, Fear, MagicShield,
            MagicResistance, SoulStone, Flying, NewFlying, NaviFlying, Frozen, Frozen2, Web, Enrage, NotDamaged,
            FinalCut, HowlingAttackDamage, BeastFormDamageUp, Dance, Cyclone, OnCapsule, HowlingCritical,
            HowlingMaxMP, HowlingDefence, HowlingEvasion, Conversion, Revive, PinkbeanMinibeenMove, Sneak, Mechanic,
            DrawBack, BeastFormMaxHP, Dice, BlessingArmor, BlessingArmorIncPAD, DamR, TeleportMasteryOn, CombatOrders,
            Beholder, DispelItemOption, DispelItemOptionByField, Inflation, OnixDivineProtection, Bless, Explosion,
            DarkTornado, IncMaxHP, IncMaxMP, PVPDamage, PVPDamageSkill, PvPScoreBonus, PvPInvincible, PvPRaceEffect,
            IceKnight, HolyMagicShell, InfinityForce, AmplifyDamage, KeyDownTimeIgnore, MasterMagicOn, AsrR,
            AsrRByItem, TerR, DamAbsorbShield, Roulette, Event, SpiritLink, CriticalBuff, DropRate, PlusExpRate,
            ItemInvincible, ItemCritical, ItemEvade, Event2, VampiricTouch, DDR, IncCriticalDamMin, IncCriticalDamMax,
            IncTerR, IncAsrR, DeathMark, PainMark, UsefulAdvancedBless, Lapidification, VampDeath, VampDeathSummon,
            VenomSnake, CarnivalAttack, CarnivalDefence, CarnivalExp, SlowAttack, PyramidEffect, HollowPointBullet,
            KeyDownMoving, KeyDownAreaMoving, CygnusElementSkill, IgnoreTargetDEF, Invisible, ReviveOnce,
            AntiMagicShell, EnrageCr, EnrageCrDamMin, BlessOfDarkness, LifeTidal, Judgement, DojangLuckyBonus,
            HitCriDamR, Larkness, SmashStack, ReshuffleSwitch, SpecialAction, ArcaneAim, StopForceAtomInfo,
            SoulGazeCriDamR, SoulRageCount, PowerTransferGauge, AffinitySlug, SoulExalt, HiddenPieceOn,
            BossShield, MobZoneState, GiveMeHeal, TouchMe, Contagion, ComboUnlimited, IgnorePCounter,
            IgnoreAllCounter, IgnorePImmune, IgnoreAllImmune, FinalJudgement, KnightsAura, IceAura, FireAura,
            VengeanceOfAngel, HeavensDoor, Preparation, BullsEye, IncEffectHPPotion, IncEffectMPPotion, SoulMP,
            FullSoulMP, SoulSkillDamageUp, BleedingToxin, IgnoreMobDamR, Asura, FlipTheCoin, UnityOfPower,
            Stimulate, ReturnTeleport, CapDebuff, DropRIncrease, IgnoreMobpdpR, BdR, Exceed, DiabolikRecovery,
            FinalAttackProp, ExceedOverload, DevilishPower, OverloadCount, BuckShot, FireBomb, HalfstatByDebuff,
            SurplusSupply, SetBaseDamage, AmaranthGenerator, StrikerHyperElectric, EventPointAbsorb, EventAssemble,
            StormBringer, ACCR, DEXR, Albatross, Translucence, PoseType, LightOfSpirit, ElementSoul, GlimmeringTime,
            Restoration, ComboCostInc, ChargeBuff, TrueSight, CrossOverChain, ChillingStep, Reincarnation, DotBasedBuff,
            BlessEnsenble, ExtremeArchery, QuiverCatridge, AdvancedQuiver, UserControlMob, ImmuneBarrier, ArmorPiercing,
            ZeroAuraStr, ZeroAuraSpd, CriticalGrowing, QuickDraw, BowMasterConcentration, TimeFastABuff, TimeFastBBuff,
            GatherDropR, AimBox2D, CursorSniping, IncMonsterBattleCaptureRate, DebuffTolerance, DotHealHPPerSecond,
            SpiritGuard, PreReviveOnce, SetBaseDamageByBuff, LimitMP, ReflectDamR, ComboTempest, MHPCutR, MMPCutR,
            SelfWeakness, ElementDarkness, FlareTrick, Ember, Dominion, SiphonVitality, DarknessAscension,
            BossWaitingLinesBuff, DamageReduce, ShadowServant, ShadowIllusion, AddAttackCount, ComplusionSlant,
            JaguarSummoned, JaguarCount, SSFShootingAttack, DevilCry, ShieldAttack, BMageAura, DarkLighting,
            AttackCountX, BMageDeath, BombTime, NoDebuff, XenonAegisSystem, AngelicBursterSoulSeeker, HiddenPossession,
            NightWalkerBat, NightLordMark, WizardIgnite, BattlePvPHelenaMark, BattlePvPHelenaWindSpirit,
            BattlePvPLangEProtection, BattlePvPLeeMalNyunScaleUp, BattlePvPRevive, PinkbeanAttackBuff, RandAreaAttack,
            BattlePvPMikeShield, BattlePvPMikeBugle, PinkbeanRelax, PinkbeanYoYoStack, NextAttackEnhance,
            AranBeyonderDamAbsorb, AranCombotempastOption, NautilusFinalAttack, ViperTimeLeap, RoyalGuardState,
            RoyalGuardPrepare, MichaelSoulLink, MichaelStanceLink, TriflingWhimOnOff, AddRangeOnOff,
            KinesisPsychicPoint, KinesisPsychicOver, KinesisPsychicShield, KinesisIncMastery,
            KinesisPsychicEnergeShield, BladeStance, DebuffActiveSkillHPCon, DebuffIncHP, BowMasterMortalBlow,
            AngelicBursterSoulResonance, Fever, IgnisRore, RpSiksin, TeleportMasteryRange, FireBarrier, ChangeFoxMan,
            FixCoolTime, IncMobRateDummy, AdrenalinBoost, AranSmashSwing, AranDrain, AranBoostEndHunt,
            HiddenHyperLinkMaximization, RWCylinder, RWCombination, RWMagnumBlow, RWBarrier, RWBarrierHeal,
            RWMaximizeCannon, RWOverHeat, RWMovingEvar, Stigma, Unk455, IncMaxDamage, Unk456, Unk457, Unk458, Unk459,
            Unk460, PyramidFireBuff /*not sure*/, HayatoStance, HayatoBooster, HayatoStanceBonus, WillowDodge, Unk465,
            HayatoPAD, HayatoHPR, HayatoMPR, Jinsoku, HayatoCr, HakuBlessing, HayatoBoss, BattoujutsuAdvance, Unk477,
            Unk478, BlackHeartedCurse, EyeForEye, BeastMode, TeamRoar, Unk482, Unk483, Unk487, Unk488, Unk489, Unk490,
            Unk491
    );

    private static final List<CharacterTemporaryStat> REMOTE_ORDER = Arrays.asList(
            Speed, ComboCounter, WeaponCharge, ElementalCharge, Stun, Shock, Darkness, Seal, Weakness, WeaknessMdamage,
            Curse, Slow, PvPRaceEffect, IceKnight, TimeBomb, Team, DisOrder, Thread, Poison, ShadowPartner, Morph,
            Ghost, Attract, Magnet, MagnetArea, NoBulletConsume, BanMap, Barrier, DojangShield, ReverseInput,
            RespectPImmune, RespectMImmune, DefenseAtt, DefenseState, DojangBerserk, RepeatEffect, StopPortion,
            StopMotion, Fear, MagicShield, Frozen, Frozen2, Web, DrawBack, FinalCut, Cyclone, OnCapsule, Mechanic,
            Inflation, Explosion, DarkTornado, AmplifyDamage, HideAttack, DevilishPower, SpiritGuard, Event, Event2,
            DeathMark, PainMark, Lapidification, VampDeath, VampDeathSummon, VenomSnake, PyramidEffect, KillingPoint,
            PinkbeanRollingGrade, IgnoreTargetDEF, Invisible, Judgement, KeyDownAreaMoving, StackBuff, BlessOfDarkness,
            Larkness, ReshuffleSwitch, SpecialAction, StopForceAtomInfo, SoulGazeCriDamR, PowerTransferGauge,
            AffinitySlug, SoulExalt, HiddenPieceOn, SmashStack, MobZoneState, GiveMeHeal, TouchMe, Contagion,
            ComboUnlimited, IgnorePCounter, IgnoreAllCounter, IgnorePImmune, IgnoreAllImmune, FinalJudgement,
            KnightsAura, IceAura, FireAura, HeavensDoor, DamAbsorbShield, AntiMagicShell, NotDamaged, BleedingToxin,
            WindBreakerFinal, IgnoreMobDamR, Asura, UnityOfPower, Stimulate, ReturnTeleport, CapDebuff, OverloadCount,
            FireBomb, SurplusSupply, NewFlying, NaviFlying, AmaranthGenerator, CygnusElementSkill, StrikerHyperElectric,
            EventPointAbsorb, EventAssemble, Albatross, Translucence, PoseType, LightOfSpirit, ElementSoul,
            GlimmeringTime, Reincarnation, Beholder, QuiverCatridge, ArmorPiercing, ZeroAuraStr, ZeroAuraSpd,
            ImmuneBarrier, FullSoulMP, AntiMagicShellBool, Dance, SpiritGuard, ComboTempest, HalfstatByDebuff,
            ComplusionSlant, JaguarSummoned, BMageAura, DarkLighting, AttackCountX, FireBarrier, KeyDownMoving,
            MichaelSoulLink, KinesisPsychicEnergeShield, BladeStance, Fever, AdrenalinBoost, RWBarrier, RWMagnumBlow,
            Stigma, Unk456, BeastMode, TeamRoar, HayatoStance, HayatoBooster, HayatoStanceBonus, HayatoPAD, HayatoHPR,
            HayatoMPR, HayatoCr, HayatoBoss, Stance, BattoujutsuAdvance, Unk478, BlackHeartedCurse, EyeForEye, Unk458,
            Unk483, Unk487, Unk488, Unk489, Unk491, Unk460, PoseTypeBool
    );



    CharacterTemporaryStat(int val, int pos) {
        this.val = val;
        this.pos = pos;
    }

    CharacterTemporaryStat(int bitPos) {
        this.bitPos = bitPos;
        this.val = 1 << (31 - bitPos % 32);
        this.pos = bitPos / 32;
    }

    public static CharacterTemporaryStat getByBitPos(int parseInt) {
        return
                Arrays.asList(values()).stream()
                        .filter(characterTemporaryStat -> characterTemporaryStat.getBitPos() == parseInt)
                        .collect(Collectors.toList()).get(0);
    }

    public boolean isEncodeInt() {
        switch (this) {
            case CarnivalDefence:
            case SpiritLink:
            case DojangLuckyBonus:
            case SoulGazeCriDamR:
            case PowerTransferGauge:
            case ReturnTeleport:
            case ShadowPartner:
            case IncMaxDamage:
            case Unk487:
            case SetBaseDamage:
            case QuiverCatridge:
            case ImmuneBarrier:
            case NaviFlying:
            case Dance:
            case SetBaseDamageByBuff:
            case DotHealHPPerSecond:
            case MagnetArea:
                return true;
            default:
                return false;
        }
    }

    public boolean isIndie() {
        return toString().toLowerCase().contains("indie");
    }

    public boolean isMovingEffectingStat() {
        switch (this) {
            case Speed:
            case Jump:
            case Stun:
            case Weakness:
            case Slow:
            case Morph:
            case Ghost:
            case BasicStatUp:
            case Attract:
            case DashSpeed:
            case DashJump:
            case Flying:
            case Frozen:
            case Frozen2:
            case Lapidification:
            case IndieSpeed:
            case IndieJump:
            case KeyDownMoving:
            case Mechanic:
            case Magnet:
            case MagnetArea:
            case VampDeath:
            case VampDeathSummon:
            case GiveMeHeal:
            case DarkTornado:
            case NewFlying:
            case NaviFlying:
            case UserControlMob:
            case Dance:
            case SelfWeakness:
            case BattlePvPHelenaWindSpirit:
            case BattlePvPLeeMalNyunScaleUp:
            case TouchMe:
            case IndieForceSpeed:
            case IndieForceJump:
            case RideVehicle:
            case RideVehicleExpire:
                return true;
            default:
                return false;
        }
    }

    public int getVal() {
        return val;
    }

    public int getPos() {
        return pos;
    }

    public int getOrder() {
        return ORDER.indexOf(this);
    }

    public int getRemoteOrder() {
        return REMOTE_ORDER.indexOf(this);
    }

    public boolean isRemoteEncode4() {
        switch (this) {
            case NoBulletConsume:
            case RespectPImmune:
            case RespectMImmune:
            case DefenseAtt:
            case DefenseState:
            case MagicShield:
            case PyramidEffect:
            case BlessOfDarkness:
            case ImmuneBarrier:
            case Dance:
            case SpiritGuard:
            case KinesisPsychicEnergeShield:
            case AdrenalinBoost:
            case RWBarrier:
            case RWMagnumBlow:
            case HayatoStance:
            case Unk487:
            case Unk488:
            case Unk489:
                return true;
            default:
                return false;
        }
    }

    public boolean isRemoteEncode1() {
        switch (this) {
            case Speed:
            case Shock:
            case Team:
            case Cyclone:
            case OnCapsule:
            case KillingPoint:
            case PinkbeanRollingGrade:
            case ReturnTeleport:
            case FireBomb:
            case SurplusSupply:
            case Unk460:
                return true;
            default:
                return false;
        }
    }

    public boolean isNotEncodeReason() {
        switch (this) {
            case Speed:
            case ElementalCharge:
            case Shock:
            case Team:
            case Ghost:
            case NoBulletConsume:
            case RespectPImmune:
            case RespectMImmune:
            case DefenseAtt:
            case DefenseState:
            case MagicShield:
            case Cyclone:
            case OnCapsule:
            case PyramidEffect:
            case KillingPoint:
            case PinkbeanRollingGrade:
            case StackBuff:
            case BlessOfDarkness:
            case SurplusSupply:
            case ImmuneBarrier:
            case AdrenalinBoost:
            case RWBarrier:
            case RWMagnumBlow:
            case HayatoStance:
            case Unk488:
            case Unk489:
            case Unk460:
                return true;
            default:
                return false;
        }
    }

    public boolean isNotEncodeAnything() {
        switch (this) {
            case FullSoulMP:
            case AntiMagicShellBool:
            case PoseTypeBool:
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        int a = Stigma.bitPos;
//        int val = 1 << (31 - (a & 0x1f));
//        int pos = a >> 5;
        int val = 0x1000;
        int pos = 0;
        log.debug(String.format("value 0x%04x, pos %d", val, pos));
        for(CharacterTemporaryStat cts : values()) {
            if(cts.getVal() == val && cts.getPos() == pos) {
                log.debug("Corresponds to " + cts);
            }
        }
//        for (CharacterTemporaryStat cts : values()) {
//            val = cts.getVal();
//            for (int i = 0; i < 32; i++) {
//                if (1 << i == val) {
//                    val = 31 - i;
//                }
//            }
//            if (val % 8 == 0) {
//                System.out.println();
//            }
//            System.out.println(String.format("%s(%d),", cts.toString(), (cts.getPos() * 32) + val));
//        }
    }

    @Override
    public int compare(CharacterTemporaryStat o1, CharacterTemporaryStat o2) {
        if (o1.getPos() < o2.getPos()) {
            return -1;
        } else if (o1.getPos() > o2.getPos()) {
            return 1;
        }
        // hacky way to circumvent java not having unsigned ints
        int o1Val = o1.getVal();
        if (o1Val == 0x8000_0000) {
            o1Val = Integer.MAX_VALUE;
        }
        int o2Val = o2.getVal();
        if (o2Val == 0x8000_0000) {
            o2Val = Integer.MAX_VALUE;
        }

        if (o1Val > o2Val) {
            // bigger value = earlier in the int => smaller
            return -1;
        } else if (o1Val < o2Val) {
            return 1;
        }
        return 0;
    }

    public int getBitPos() {
        return bitPos;
    }
}
