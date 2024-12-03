package za;

import com.coffeemeetsbagel.models.dto.Location;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f42188a;

    /* renamed from: b  reason: collision with root package name */
    private final String f42189b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42190c;

    /* renamed from: d  reason: collision with root package name */
    private final String f42191d;

    /* renamed from: e  reason: collision with root package name */
    private final String f42192e;

    /* renamed from: f  reason: collision with root package name */
    private final Integer f42193f;

    /* renamed from: g  reason: collision with root package name */
    private final Float f42194g;

    /* renamed from: h  reason: collision with root package name */
    private final Float f42195h;

    /* renamed from: i  reason: collision with root package name */
    private final Float f42196i;

    /* renamed from: j  reason: collision with root package name */
    private final Location f42197j;

    /* renamed from: k  reason: collision with root package name */
    private final Boolean f42198k;

    /* renamed from: l  reason: collision with root package name */
    private final String f42199l;

    public b(String str, String str2, String str3, String str4, String str5, Integer num, Float f10, Float f11, Float f12, Location location, Boolean bool, String str6) {
        j.g(str, "id");
        j.g(str2, "optionId");
        j.g(str3, "profileId");
        j.g(str4, "questionId");
        j.g(str5, "textValue");
        this.f42188a = str;
        this.f42189b = str2;
        this.f42190c = str3;
        this.f42191d = str4;
        this.f42192e = str5;
        this.f42193f = num;
        this.f42194g = f10;
        this.f42195h = f11;
        this.f42196i = f12;
        this.f42197j = location;
        this.f42198k = bool;
        this.f42199l = str6;
    }

    public final Float a() {
        return this.f42194g;
    }

    public final String b() {
        return this.f42188a;
    }

    public final Integer c() {
        return this.f42193f;
    }

    public final String d() {
        return this.f42199l;
    }

    public final Location e() {
        return this.f42197j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return j.b(this.f42188a, bVar.f42188a) && j.b(this.f42189b, bVar.f42189b) && j.b(this.f42190c, bVar.f42190c) && j.b(this.f42191d, bVar.f42191d) && j.b(this.f42192e, bVar.f42192e) && j.b(this.f42193f, bVar.f42193f) && j.b(this.f42194g, bVar.f42194g) && j.b(this.f42195h, bVar.f42195h) && j.b(this.f42196i, bVar.f42196i) && j.b(this.f42197j, bVar.f42197j) && j.b(this.f42198k, bVar.f42198k) && j.b(this.f42199l, bVar.f42199l);
    }

    public final Float f() {
        return this.f42195h;
    }

    public final Float g() {
        return this.f42196i;
    }

    public final String h() {
        return this.f42189b;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f42188a.hashCode() * 31) + this.f42189b.hashCode()) * 31) + this.f42190c.hashCode()) * 31) + this.f42191d.hashCode()) * 31) + this.f42192e.hashCode()) * 31;
        Integer num = this.f42193f;
        int i10 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Float f10 = this.f42194g;
        int hashCode3 = (hashCode2 + (f10 == null ? 0 : f10.hashCode())) * 31;
        Float f11 = this.f42195h;
        int hashCode4 = (hashCode3 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Float f12 = this.f42196i;
        int hashCode5 = (hashCode4 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Location location = this.f42197j;
        int hashCode6 = (hashCode5 + (location == null ? 0 : location.hashCode())) * 31;
        Boolean bool = this.f42198k;
        int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.f42199l;
        if (str != null) {
            i10 = str.hashCode();
        }
        return hashCode7 + i10;
    }

    public final String i() {
        return this.f42190c;
    }

    public final String j() {
        return this.f42191d;
    }

    public final String k() {
        return this.f42192e;
    }

    public final Boolean l() {
        return this.f42198k;
    }

    public String toString() {
        return "AnswerEntity(id=" + this.f42188a + ", optionId=" + this.f42189b + ", profileId=" + this.f42190c + ", questionId=" + this.f42191d + ", textValue=" + this.f42192e + ", integerValue=" + this.f42193f + ", floatValue=" + this.f42194g + ", maxValue=" + this.f42195h + ", minValue=" + this.f42196i + ", location=" + this.f42197j + ", isDealbreaker=" + this.f42198k + ", jsonType=" + this.f42199l + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.Integer r22, java.lang.Float r23, java.lang.Float r24, java.lang.Float r25, com.coffeemeetsbagel.models.dto.Location r26, java.lang.Boolean r27, java.lang.String r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 2
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r5 = r2
            goto L_0x000c
        L_0x000a:
            r5 = r18
        L_0x000c:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0012
            r8 = r2
            goto L_0x0014
        L_0x0012:
            r8 = r21
        L_0x0014:
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x001b
            r9 = r2
            goto L_0x001d
        L_0x001b:
            r9 = r22
        L_0x001d:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0023
            r10 = r2
            goto L_0x0025
        L_0x0023:
            r10 = r23
        L_0x0025:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x002b
            r11 = r2
            goto L_0x002d
        L_0x002b:
            r11 = r24
        L_0x002d:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0033
            r12 = r2
            goto L_0x0035
        L_0x0033:
            r12 = r25
        L_0x0035:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x003b
            r13 = r2
            goto L_0x003d
        L_0x003b:
            r13 = r26
        L_0x003d:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0045
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r14 = r1
            goto L_0x0047
        L_0x0045:
            r14 = r27
        L_0x0047:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x004d
            r15 = r2
            goto L_0x004f
        L_0x004d:
            r15 = r28
        L_0x004f:
            r3 = r16
            r4 = r17
            r6 = r19
            r7 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: za.b.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Float, java.lang.Float, java.lang.Float, com.coffeemeetsbagel.models.dto.Location, java.lang.Boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
