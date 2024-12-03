package com.withpersona.sdk2.inquiry.governmentid.network;

import com.mparticle.kits.ReportingMessage;
import com.withpersona.sdk2.inquiry.governmentid.k0;
import gk.h;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public enum IdClass {
    DriverLicense,
    StateID,
    Keypass,
    MilitaryID,
    MyNumberCard,
    NRIC,
    OFWID,
    Passport,
    PermanentResidentCard,
    ResidencyPermit,
    StudentPermit,
    SocialSecurityID,
    UMID,
    VoterID,
    PassportCard,
    PostalID,
    Visa,
    WorkPermit,
    CitizenshipCertificate,
    ConsularID,
    ForeignerID,
    HealthInsuranceCard,
    LongTermPass,
    NBICertificate,
    PermanentAccountNumber,
    I;
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f25844a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, IdClass> f25845b = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IdClass a(String str) {
            j.g(str, "abbr");
            IdClass idClass = (IdClass) IdClass.f25845b.get(str);
            return idClass == null ? IdClass.I : idClass;
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25864a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|(2:51|52)|53|55) */
        /* JADX WARNING: Can't wrap try/catch for region: R(55:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|55) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00dc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass[] r0 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.DriverLicense     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.StateID     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.Keypass     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.MilitaryID     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.MyNumberCard     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.NRIC     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.OFWID     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.Passport     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.PermanentResidentCard     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.ResidencyPermit     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.StudentPermit     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.SocialSecurityID     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.UMID     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.VoterID     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.PassportCard     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.PostalID     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.Visa     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.WorkPermit     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.CitizenshipCertificate     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.ConsularID     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.ForeignerID     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.HealthInsuranceCard     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.LongTermPass     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.NBICertificate     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.PermanentAccountNumber     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.I     // Catch:{ NoSuchFieldError -> 0x0104 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0104 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0104 }
            L_0x0104:
                f25864a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.network.IdClass.b.<clinit>():void");
        }
    }

    static {
        IdClass idClass;
        IdClass idClass2;
        IdClass idClass3;
        IdClass idClass4;
        IdClass idClass5;
        IdClass idClass6;
        IdClass idClass7;
        IdClass idClass8;
        IdClass idClass9;
        IdClass idClass10;
        IdClass idClass11;
        IdClass idClass12;
        IdClass idClass13;
        IdClass idClass14;
        IdClass idClass15;
        IdClass idClass16;
        IdClass idClass17;
        IdClass idClass18;
        IdClass idClass19;
        IdClass idClass20;
        IdClass idClass21;
        IdClass idClass22;
        IdClass idClass23;
        IdClass idClass24;
        IdClass idClass25;
        f25844a = new a((DefaultConstructorMarker) null);
        f25845b = h0.l(h.a("dl", idClass), h.a("id", idClass2), h.a("keyp", idClass3), h.a("mid", idClass4), h.a("myn", idClass5), h.a("nric", idClass6), h.a("ofw", idClass7), h.a("pp", idClass8), h.a(ReportingMessage.MessageType.PUSH_REGISTRATION, idClass9), h.a("rp", idClass10), h.a("sp", idClass11), h.a("sss", idClass12), h.a("umid", idClass13), h.a("vid", idClass14), h.a("ppc", idClass15), h.a("pid", idClass16), h.a("visa", idClass17), h.a("wp", idClass18), h.a("cct", idClass19), h.a("cid", idClass20), h.a("foid", idClass21), h.a("hic", idClass23), h.a("ltpass", idClass22), h.a("nbi", idClass24), h.a("pan", idClass25));
    }

    public final int c() {
        switch (b.f25864a[ordinal()]) {
            case 1:
                return k0.pi2_governmentid_card;
            case 2:
                return k0.pi2_governmentid_flag;
            case 3:
                return k0.pi2_governmentid_card;
            case 4:
                return k0.pi2_governmentid_card;
            case 5:
                return k0.pi2_governmentid_card;
            case 6:
                return k0.pi2_governmentid_card;
            case 7:
                return k0.pi2_governmentid_card;
            case 8:
                return k0.pi2_governmentid_world;
            case 9:
                return k0.pi2_governmentid_house;
            case 10:
                return k0.pi2_governmentid_house;
            case 11:
                return k0.pi2_governmentid_card;
            case 12:
                return k0.pi2_governmentid_card;
            case 13:
                return k0.pi2_governmentid_card;
            case 14:
                return k0.pi2_governmentid_card;
            case 15:
                return k0.pi2_governmentid_world;
            case 16:
                return k0.pi2_governmentid_card;
            case 17:
                return k0.pi2_governmentid_world;
            case 18:
                return k0.pi2_governmentid_card;
            case 19:
                return k0.pi2_governmentid_card;
            case 20:
                return k0.pi2_governmentid_card;
            case 21:
                return k0.pi2_governmentid_card;
            case 22:
                return k0.pi2_governmentid_card;
            case 23:
                return k0.pi2_governmentid_card;
            case 24:
                return k0.pi2_governmentid_card;
            case 25:
                return k0.pi2_governmentid_card;
            case 26:
                throw new RuntimeException("IdClass is 'UNKNOWN'.");
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
