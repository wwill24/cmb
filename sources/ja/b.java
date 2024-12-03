package ja;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.profile.i;
import j$.time.OffsetDateTime;
import java.util.List;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.beanutils.PropertyUtils;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f41000a;

    /* renamed from: b  reason: collision with root package name */
    private final String f41001b;

    /* renamed from: c  reason: collision with root package name */
    private final String f41002c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f41003d;

    /* renamed from: e  reason: collision with root package name */
    private final OffsetDateTime f41004e;

    /* renamed from: f  reason: collision with root package name */
    private final long f41005f;

    /* renamed from: g  reason: collision with root package name */
    private final OffsetDateTime f41006g;

    /* renamed from: h  reason: collision with root package name */
    private final a f41007h;

    /* renamed from: i  reason: collision with root package name */
    private final String f41008i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f41009j;

    /* renamed from: k  reason: collision with root package name */
    private final String f41010k;

    /* renamed from: l  reason: collision with root package name */
    private final OffsetDateTime f41011l;

    /* renamed from: m  reason: collision with root package name */
    private final String f41012m;

    /* renamed from: n  reason: collision with root package name */
    private final List<String> f41013n;

    /* renamed from: o  reason: collision with root package name */
    private final String f41014o;

    /* renamed from: p  reason: collision with root package name */
    private final i f41015p;

    /* renamed from: q  reason: collision with root package name */
    private final int f41016q;

    /* renamed from: r  reason: collision with root package name */
    private final int f41017r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f41018s;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f41019t;

    /* renamed from: u  reason: collision with root package name */
    private final String f41020u;

    /* renamed from: v  reason: collision with root package name */
    private final int f41021v;

    /* renamed from: w  reason: collision with root package name */
    private final String f41022w;

    /* renamed from: x  reason: collision with root package name */
    private final String f41023x;

    /* renamed from: y  reason: collision with root package name */
    private final boolean f41024y;

    public b(String str, String str2, String str3, boolean z10, OffsetDateTime offsetDateTime, long j10, OffsetDateTime offsetDateTime2, a aVar, String str4, boolean z11, String str5, OffsetDateTime offsetDateTime3, String str6, List<String> list, String str7, i iVar, int i10, int i11, boolean z12, boolean z13, String str8, int i12, String str9, String str10, boolean z14) {
        a aVar2 = aVar;
        List<String> list2 = list;
        i iVar2 = iVar;
        j.g(str, "profileId");
        j.g(aVar2, "matchPrefs");
        j.g(list2, "viewedCoachMarks");
        j.g(iVar2, ProfileConstants.Field.ICEBREAKERS);
        this.f41000a = str;
        this.f41001b = str2;
        this.f41002c = str3;
        this.f41003d = z10;
        this.f41004e = offsetDateTime;
        this.f41005f = j10;
        this.f41006g = offsetDateTime2;
        this.f41007h = aVar2;
        this.f41008i = str4;
        this.f41009j = z11;
        this.f41010k = str5;
        this.f41011l = offsetDateTime3;
        this.f41012m = str6;
        this.f41013n = list2;
        this.f41014o = str7;
        this.f41015p = iVar2;
        this.f41016q = i10;
        this.f41017r = i11;
        this.f41018s = z12;
        this.f41019t = z13;
        this.f41020u = str8;
        this.f41021v = i12;
        this.f41022w = str9;
        this.f41023x = str10;
        this.f41024y = z14;
    }

    public static /* synthetic */ b b(b bVar, String str, String str2, String str3, boolean z10, OffsetDateTime offsetDateTime, long j10, OffsetDateTime offsetDateTime2, a aVar, String str4, boolean z11, String str5, OffsetDateTime offsetDateTime3, String str6, List list, String str7, i iVar, int i10, int i11, boolean z12, boolean z13, String str8, int i12, String str9, String str10, boolean z14, int i13, Object obj) {
        b bVar2 = bVar;
        int i14 = i13;
        return bVar.a((i14 & 1) != 0 ? bVar2.f41000a : str, (i14 & 2) != 0 ? bVar2.f41001b : str2, (i14 & 4) != 0 ? bVar2.f41002c : str3, (i14 & 8) != 0 ? bVar2.f41003d : z10, (i14 & 16) != 0 ? bVar2.f41004e : offsetDateTime, (i14 & 32) != 0 ? bVar2.f41005f : j10, (i14 & 64) != 0 ? bVar2.f41006g : offsetDateTime2, (i14 & 128) != 0 ? bVar2.f41007h : aVar, (i14 & 256) != 0 ? bVar2.f41008i : str4, (i14 & 512) != 0 ? bVar2.f41009j : z11, (i14 & 1024) != 0 ? bVar2.f41010k : str5, (i14 & 2048) != 0 ? bVar2.f41011l : offsetDateTime3, (i14 & Opcodes.ACC_SYNTHETIC) != 0 ? bVar2.f41012m : str6, (i14 & 8192) != 0 ? bVar2.f41013n : list, (i14 & Opcodes.ACC_ENUM) != 0 ? bVar2.f41014o : str7, (i14 & 32768) != 0 ? bVar2.f41015p : iVar, (i14 & 65536) != 0 ? bVar2.f41016q : i10, (i14 & Opcodes.ACC_DEPRECATED) != 0 ? bVar2.f41017r : i11, (i14 & Opcodes.ASM4) != 0 ? bVar2.f41018s : z12, (i14 & Opcodes.ASM8) != 0 ? bVar2.f41019t : z13, (i14 & 1048576) != 0 ? bVar2.f41020u : str8, (i14 & 2097152) != 0 ? bVar2.f41021v : i12, (i14 & 4194304) != 0 ? bVar2.f41022w : str9, (i14 & 8388608) != 0 ? bVar2.f41023x : str10, (i14 & 16777216) != 0 ? bVar2.f41024y : z14);
    }

    public final boolean A() {
        return this.f41003d;
    }

    public final b a(String str, String str2, String str3, boolean z10, OffsetDateTime offsetDateTime, long j10, OffsetDateTime offsetDateTime2, a aVar, String str4, boolean z11, String str5, OffsetDateTime offsetDateTime3, String str6, List<String> list, String str7, i iVar, int i10, int i11, boolean z12, boolean z13, String str8, int i12, String str9, String str10, boolean z14) {
        String str11 = str;
        j.g(str11, "profileId");
        j.g(aVar, "matchPrefs");
        j.g(list, "viewedCoachMarks");
        j.g(iVar, ProfileConstants.Field.ICEBREAKERS);
        return new b(str11, str2, str3, z10, offsetDateTime, j10, offsetDateTime2, aVar, str4, z11, str5, offsetDateTime3, str6, list, str7, iVar, i10, i11, z12, z13, str8, i12, str9, str10, z14);
    }

    public final int c() {
        return this.f41017r;
    }

    public final String d() {
        return this.f41001b;
    }

    public final int e() {
        return this.f41016q;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return j.b(this.f41000a, bVar.f41000a) && j.b(this.f41001b, bVar.f41001b) && j.b(this.f41002c, bVar.f41002c) && this.f41003d == bVar.f41003d && j.b(this.f41004e, bVar.f41004e) && this.f41005f == bVar.f41005f && j.b(this.f41006g, bVar.f41006g) && j.b(this.f41007h, bVar.f41007h) && j.b(this.f41008i, bVar.f41008i) && this.f41009j == bVar.f41009j && j.b(this.f41010k, bVar.f41010k) && j.b(this.f41011l, bVar.f41011l) && j.b(this.f41012m, bVar.f41012m) && j.b(this.f41013n, bVar.f41013n) && j.b(this.f41014o, bVar.f41014o) && j.b(this.f41015p, bVar.f41015p) && this.f41016q == bVar.f41016q && this.f41017r == bVar.f41017r && this.f41018s == bVar.f41018s && this.f41019t == bVar.f41019t && j.b(this.f41020u, bVar.f41020u) && this.f41021v == bVar.f41021v && j.b(this.f41022w, bVar.f41022w) && j.b(this.f41023x, bVar.f41023x) && this.f41024y == bVar.f41024y;
    }

    public final long f() {
        return this.f41005f;
    }

    public final OffsetDateTime g() {
        return this.f41006g;
    }

    public final String h() {
        return this.f41020u;
    }

    public int hashCode() {
        int hashCode = this.f41000a.hashCode() * 31;
        String str = this.f41001b;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f41002c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z10 = this.f41003d;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int i11 = (hashCode3 + (z10 ? 1 : 0)) * 31;
        OffsetDateTime offsetDateTime = this.f41004e;
        int hashCode4 = (((i11 + (offsetDateTime == null ? 0 : offsetDateTime.hashCode())) * 31) + Long.hashCode(this.f41005f)) * 31;
        OffsetDateTime offsetDateTime2 = this.f41006g;
        int hashCode5 = (((hashCode4 + (offsetDateTime2 == null ? 0 : offsetDateTime2.hashCode())) * 31) + this.f41007h.hashCode()) * 31;
        String str3 = this.f41008i;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z12 = this.f41009j;
        if (z12) {
            z12 = true;
        }
        int i12 = (hashCode6 + (z12 ? 1 : 0)) * 31;
        String str4 = this.f41010k;
        int hashCode7 = (i12 + (str4 == null ? 0 : str4.hashCode())) * 31;
        OffsetDateTime offsetDateTime3 = this.f41011l;
        int hashCode8 = (hashCode7 + (offsetDateTime3 == null ? 0 : offsetDateTime3.hashCode())) * 31;
        String str5 = this.f41012m;
        int hashCode9 = (((hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.f41013n.hashCode()) * 31;
        String str6 = this.f41014o;
        int hashCode10 = (((((((hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.f41015p.hashCode()) * 31) + Integer.hashCode(this.f41016q)) * 31) + Integer.hashCode(this.f41017r)) * 31;
        boolean z13 = this.f41018s;
        if (z13) {
            z13 = true;
        }
        int i13 = (hashCode10 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.f41019t;
        if (z14) {
            z14 = true;
        }
        int i14 = (i13 + (z14 ? 1 : 0)) * 31;
        String str7 = this.f41020u;
        int hashCode11 = (((i14 + (str7 == null ? 0 : str7.hashCode())) * 31) + Integer.hashCode(this.f41021v)) * 31;
        String str8 = this.f41022w;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f41023x;
        if (str9 != null) {
            i10 = str9.hashCode();
        }
        int i15 = (hashCode12 + i10) * 31;
        boolean z15 = this.f41024y;
        if (!z15) {
            z11 = z15;
        }
        return i15 + (z11 ? 1 : 0);
    }

    public final OffsetDateTime i() {
        return this.f41011l;
    }

    public final String j() {
        return this.f41010k;
    }

    public final String k() {
        return this.f41002c;
    }

    public final boolean l() {
        return this.f41019t;
    }

    public final boolean m() {
        return this.f41018s;
    }

    public final i n() {
        return this.f41015p;
    }

    public final String o() {
        return this.f41022w;
    }

    public final String p() {
        return this.f41012m;
    }

    public final a q() {
        return this.f41007h;
    }

    public final String r() {
        return this.f41008i;
    }

    public final int s() {
        return this.f41021v;
    }

    public final boolean t() {
        return this.f41009j;
    }

    public String toString() {
        return "User(profileId=" + this.f41000a + ", appsFlyerId=" + this.f41001b + ", emailAddress=" + this.f41002c + ", isEligibleForFreeTrial=" + this.f41003d + ", registeredDate=" + this.f41004e + ", beans=" + this.f41005f + ", birthDay=" + this.f41006g + ", matchPrefs=" + this.f41007h + ", matchRegion=" + this.f41008i + ", onHold=" + this.f41009j + ", deactivateReason=" + this.f41010k + ", dateReactivated=" + this.f41011l + ", location=" + this.f41012m + ", viewedCoachMarks=" + this.f41013n + ", referralCode=" + this.f41014o + ", icebreakers=" + this.f41015p + ", badgeCount=" + this.f41016q + ", appLaunchStreak=" + this.f41017r + ", hasPrioritizedLikes=" + this.f41018s + ", hasActiveBoost=" + this.f41019t + ", boostReportId=" + this.f41020u + ", numRisingBagels=" + this.f41021v + ", lastName=" + this.f41022w + ", zipCode=" + this.f41023x + ", usesMetric=" + this.f41024y + PropertyUtils.MAPPED_DELIM2;
    }

    public final String u() {
        return this.f41000a;
    }

    public final String v() {
        return this.f41014o;
    }

    public final OffsetDateTime w() {
        return this.f41004e;
    }

    public final boolean x() {
        return this.f41024y;
    }

    public final List<String> y() {
        return this.f41013n;
    }

    public final String z() {
        return this.f41023x;
    }
}
