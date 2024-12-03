package ja;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.entities.IcebreakersEntity;
import j$.time.OffsetDateTime;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f41025a;

    /* renamed from: b  reason: collision with root package name */
    private final String f41026b;

    /* renamed from: c  reason: collision with root package name */
    private final String f41027c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f41028d;

    /* renamed from: e  reason: collision with root package name */
    private final OffsetDateTime f41029e;

    /* renamed from: f  reason: collision with root package name */
    private final long f41030f;

    /* renamed from: g  reason: collision with root package name */
    private final OffsetDateTime f41031g;

    /* renamed from: h  reason: collision with root package name */
    private final a f41032h;

    /* renamed from: i  reason: collision with root package name */
    private final String f41033i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f41034j;

    /* renamed from: k  reason: collision with root package name */
    private final String f41035k;

    /* renamed from: l  reason: collision with root package name */
    private final OffsetDateTime f41036l;

    /* renamed from: m  reason: collision with root package name */
    private final String f41037m;

    /* renamed from: n  reason: collision with root package name */
    private final List<String> f41038n;

    /* renamed from: o  reason: collision with root package name */
    private final String f41039o;

    /* renamed from: p  reason: collision with root package name */
    private final IcebreakersEntity f41040p;

    /* renamed from: q  reason: collision with root package name */
    private final int f41041q;

    /* renamed from: r  reason: collision with root package name */
    private final int f41042r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f41043s;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f41044t;

    /* renamed from: u  reason: collision with root package name */
    private final String f41045u;

    /* renamed from: v  reason: collision with root package name */
    private final int f41046v;

    /* renamed from: w  reason: collision with root package name */
    private final String f41047w;

    /* renamed from: x  reason: collision with root package name */
    private final String f41048x;

    /* renamed from: y  reason: collision with root package name */
    private final boolean f41049y;

    public c(String str, String str2, String str3, boolean z10, OffsetDateTime offsetDateTime, long j10, OffsetDateTime offsetDateTime2, a aVar, String str4, boolean z11, String str5, OffsetDateTime offsetDateTime3, String str6, List<String> list, String str7, IcebreakersEntity icebreakersEntity, int i10, int i11, boolean z12, boolean z13, String str8, int i12, String str9, String str10, boolean z14) {
        a aVar2 = aVar;
        List<String> list2 = list;
        IcebreakersEntity icebreakersEntity2 = icebreakersEntity;
        j.g(str, "profileId");
        j.g(aVar2, "matchPrefs");
        j.g(list2, "viewedCoachMarks");
        j.g(icebreakersEntity2, ProfileConstants.Field.ICEBREAKERS);
        this.f41025a = str;
        this.f41026b = str2;
        this.f41027c = str3;
        this.f41028d = z10;
        this.f41029e = offsetDateTime;
        this.f41030f = j10;
        this.f41031g = offsetDateTime2;
        this.f41032h = aVar2;
        this.f41033i = str4;
        this.f41034j = z11;
        this.f41035k = str5;
        this.f41036l = offsetDateTime3;
        this.f41037m = str6;
        this.f41038n = list2;
        this.f41039o = str7;
        this.f41040p = icebreakersEntity2;
        this.f41041q = i10;
        this.f41042r = i11;
        this.f41043s = z12;
        this.f41044t = z13;
        this.f41045u = str8;
        this.f41046v = i12;
        this.f41047w = str9;
        this.f41048x = str10;
        this.f41049y = z14;
    }

    public final int a() {
        return this.f41042r;
    }

    public final String b() {
        return this.f41026b;
    }

    public final int c() {
        return this.f41041q;
    }

    public final long d() {
        return this.f41030f;
    }

    public final OffsetDateTime e() {
        return this.f41031g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return j.b(this.f41025a, cVar.f41025a) && j.b(this.f41026b, cVar.f41026b) && j.b(this.f41027c, cVar.f41027c) && this.f41028d == cVar.f41028d && j.b(this.f41029e, cVar.f41029e) && this.f41030f == cVar.f41030f && j.b(this.f41031g, cVar.f41031g) && j.b(this.f41032h, cVar.f41032h) && j.b(this.f41033i, cVar.f41033i) && this.f41034j == cVar.f41034j && j.b(this.f41035k, cVar.f41035k) && j.b(this.f41036l, cVar.f41036l) && j.b(this.f41037m, cVar.f41037m) && j.b(this.f41038n, cVar.f41038n) && j.b(this.f41039o, cVar.f41039o) && j.b(this.f41040p, cVar.f41040p) && this.f41041q == cVar.f41041q && this.f41042r == cVar.f41042r && this.f41043s == cVar.f41043s && this.f41044t == cVar.f41044t && j.b(this.f41045u, cVar.f41045u) && this.f41046v == cVar.f41046v && j.b(this.f41047w, cVar.f41047w) && j.b(this.f41048x, cVar.f41048x) && this.f41049y == cVar.f41049y;
    }

    public final String f() {
        return this.f41045u;
    }

    public final OffsetDateTime g() {
        return this.f41036l;
    }

    public final String h() {
        return this.f41035k;
    }

    public int hashCode() {
        int hashCode = this.f41025a.hashCode() * 31;
        String str = this.f41026b;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f41027c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z10 = this.f41028d;
        boolean z11 = true;
        if (z10) {
            z10 = true;
        }
        int i11 = (hashCode3 + (z10 ? 1 : 0)) * 31;
        OffsetDateTime offsetDateTime = this.f41029e;
        int hashCode4 = (((i11 + (offsetDateTime == null ? 0 : offsetDateTime.hashCode())) * 31) + Long.hashCode(this.f41030f)) * 31;
        OffsetDateTime offsetDateTime2 = this.f41031g;
        int hashCode5 = (((hashCode4 + (offsetDateTime2 == null ? 0 : offsetDateTime2.hashCode())) * 31) + this.f41032h.hashCode()) * 31;
        String str3 = this.f41033i;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z12 = this.f41034j;
        if (z12) {
            z12 = true;
        }
        int i12 = (hashCode6 + (z12 ? 1 : 0)) * 31;
        String str4 = this.f41035k;
        int hashCode7 = (i12 + (str4 == null ? 0 : str4.hashCode())) * 31;
        OffsetDateTime offsetDateTime3 = this.f41036l;
        int hashCode8 = (hashCode7 + (offsetDateTime3 == null ? 0 : offsetDateTime3.hashCode())) * 31;
        String str5 = this.f41037m;
        int hashCode9 = (((hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.f41038n.hashCode()) * 31;
        String str6 = this.f41039o;
        int hashCode10 = (((((((hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.f41040p.hashCode()) * 31) + Integer.hashCode(this.f41041q)) * 31) + Integer.hashCode(this.f41042r)) * 31;
        boolean z13 = this.f41043s;
        if (z13) {
            z13 = true;
        }
        int i13 = (hashCode10 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.f41044t;
        if (z14) {
            z14 = true;
        }
        int i14 = (i13 + (z14 ? 1 : 0)) * 31;
        String str7 = this.f41045u;
        int hashCode11 = (((i14 + (str7 == null ? 0 : str7.hashCode())) * 31) + Integer.hashCode(this.f41046v)) * 31;
        String str8 = this.f41047w;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f41048x;
        if (str9 != null) {
            i10 = str9.hashCode();
        }
        int i15 = (hashCode12 + i10) * 31;
        boolean z15 = this.f41049y;
        if (!z15) {
            z11 = z15;
        }
        return i15 + (z11 ? 1 : 0);
    }

    public final String i() {
        return this.f41027c;
    }

    public final boolean j() {
        return this.f41044t;
    }

    public final boolean k() {
        return this.f41043s;
    }

    public final IcebreakersEntity l() {
        return this.f41040p;
    }

    public final String m() {
        return this.f41047w;
    }

    public final String n() {
        return this.f41037m;
    }

    public final a o() {
        return this.f41032h;
    }

    public final String p() {
        return this.f41033i;
    }

    public final int q() {
        return this.f41046v;
    }

    public final boolean r() {
        return this.f41034j;
    }

    public final String s() {
        return this.f41025a;
    }

    public final String t() {
        return this.f41039o;
    }

    public String toString() {
        return "UserEntity(profileId=" + this.f41025a + ", appsFlyerId=" + this.f41026b + ", emailAddress=" + this.f41027c + ", isEligibleForFreeTrial=" + this.f41028d + ", registeredDate=" + this.f41029e + ", beans=" + this.f41030f + ", birthDay=" + this.f41031g + ", matchPrefs=" + this.f41032h + ", matchRegion=" + this.f41033i + ", onHold=" + this.f41034j + ", deactivateReason=" + this.f41035k + ", dateReactivated=" + this.f41036l + ", location=" + this.f41037m + ", viewedCoachMarks=" + this.f41038n + ", referralCode=" + this.f41039o + ", icebreakers=" + this.f41040p + ", badgeCount=" + this.f41041q + ", appLaunchStreak=" + this.f41042r + ", hasPrioritizedLikes=" + this.f41043s + ", hasActiveBoost=" + this.f41044t + ", boostReportId=" + this.f41045u + ", numRisingBagels=" + this.f41046v + ", lastName=" + this.f41047w + ", zipCode=" + this.f41048x + ", usesMetric=" + this.f41049y + PropertyUtils.MAPPED_DELIM2;
    }

    public final OffsetDateTime u() {
        return this.f41029e;
    }

    public final boolean v() {
        return this.f41049y;
    }

    public final List<String> w() {
        return this.f41038n;
    }

    public final String x() {
        return this.f41048x;
    }

    public final boolean y() {
        return this.f41028d;
    }
}
