package ja;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f40987a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f40988b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40989c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40990d;

    /* renamed from: e  reason: collision with root package name */
    private final String f40991e;

    /* renamed from: f  reason: collision with root package name */
    private final int f40992f;

    /* renamed from: g  reason: collision with root package name */
    private final int f40993g;

    /* renamed from: h  reason: collision with root package name */
    private final Integer f40994h;

    /* renamed from: i  reason: collision with root package name */
    private final Integer f40995i;

    /* renamed from: j  reason: collision with root package name */
    private final Integer f40996j;

    /* renamed from: k  reason: collision with root package name */
    private final Integer f40997k;

    /* renamed from: l  reason: collision with root package name */
    private final Integer f40998l;

    /* renamed from: m  reason: collision with root package name */
    private final Integer f40999m;

    public a() {
        this((Integer) null, (Integer) null, (String) null, (String) null, (String) null, 0, 0, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 8191, (DefaultConstructorMarker) null);
    }

    public a(Integer num, Integer num2, String str, String str2, String str3, int i10, int i11, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8) {
        this.f40987a = num;
        this.f40988b = num2;
        this.f40989c = str;
        this.f40990d = str2;
        this.f40991e = str3;
        this.f40992f = i10;
        this.f40993g = i11;
        this.f40994h = num3;
        this.f40995i = num4;
        this.f40996j = num5;
        this.f40997k = num6;
        this.f40998l = num7;
        this.f40999m = num8;
    }

    public final Integer a() {
        return this.f40987a;
    }

    public final Integer b() {
        return this.f40988b;
    }

    public final String c() {
        return this.f40989c;
    }

    public final String d() {
        return this.f40990d;
    }

    public final Integer e() {
        return this.f40998l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.b(this.f40987a, aVar.f40987a) && j.b(this.f40988b, aVar.f40988b) && j.b(this.f40989c, aVar.f40989c) && j.b(this.f40990d, aVar.f40990d) && j.b(this.f40991e, aVar.f40991e) && this.f40992f == aVar.f40992f && this.f40993g == aVar.f40993g && j.b(this.f40994h, aVar.f40994h) && j.b(this.f40995i, aVar.f40995i) && j.b(this.f40996j, aVar.f40996j) && j.b(this.f40997k, aVar.f40997k) && j.b(this.f40998l, aVar.f40998l) && j.b(this.f40999m, aVar.f40999m);
    }

    public final Integer f() {
        return this.f40999m;
    }

    public final Integer g() {
        return this.f40994h;
    }

    public final Integer h() {
        return this.f40995i;
    }

    public int hashCode() {
        Integer num = this.f40987a;
        int i10 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.f40988b;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.f40989c;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f40990d;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f40991e;
        int hashCode5 = (((((hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + Integer.hashCode(this.f40992f)) * 31) + Integer.hashCode(this.f40993g)) * 31;
        Integer num3 = this.f40994h;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f40995i;
        int hashCode7 = (hashCode6 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.f40996j;
        int hashCode8 = (hashCode7 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.f40997k;
        int hashCode9 = (hashCode8 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.f40998l;
        int hashCode10 = (hashCode9 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.f40999m;
        if (num8 != null) {
            i10 = num8.hashCode();
        }
        return hashCode10 + i10;
    }

    public final Integer i() {
        return this.f40996j;
    }

    public final Integer j() {
        return this.f40997k;
    }

    public final int k() {
        return this.f40993g;
    }

    public final int l() {
        return this.f40992f;
    }

    public final String m() {
        return this.f40991e;
    }

    public String toString() {
        return "MyMatchPreference(ageFrom=" + this.f40987a + ", ageTo=" + this.f40988b + ", ethnicity=" + this.f40989c + ", gender=" + this.f40990d + ", religion=" + this.f40991e + ", maxDistanceMiles=" + this.f40992f + ", maxDistanceKm=" + this.f40993g + ", heightFeetFrom=" + this.f40994h + ", heightFeetTo=" + this.f40995i + ", heightInchFrom=" + this.f40996j + ", heightInchTo=" + this.f40997k + ", heightCmFrom=" + this.f40998l + ", heightCmTo=" + this.f40999m + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(java.lang.Integer r14, java.lang.Integer r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, int r19, int r20, java.lang.Integer r21, java.lang.Integer r22, java.lang.Integer r23, java.lang.Integer r24, java.lang.Integer r25, java.lang.Integer r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r13 = this;
            r0 = r27
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            r1 = 18
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x000e
        L_0x000d:
            r1 = r14
        L_0x000e:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0019
            r2 = 99
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x001a
        L_0x0019:
            r2 = r15
        L_0x001a:
            r3 = r0 & 4
            r4 = 0
            if (r3 == 0) goto L_0x0021
            r3 = r4
            goto L_0x0023
        L_0x0021:
            r3 = r16
        L_0x0023:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0029
            r5 = r4
            goto L_0x002b
        L_0x0029:
            r5 = r17
        L_0x002b:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r4 = r18
        L_0x0032:
            r6 = r0 & 32
            r7 = 0
            if (r6 == 0) goto L_0x003c
            int[] r6 = com.coffeemeetsbagel.models.constants.ProfileConstants.POSSIBLE_DISTANCE_VALUES_MILES
            r6 = r6[r7]
            goto L_0x003e
        L_0x003c:
            r6 = r19
        L_0x003e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0047
            int[] r8 = com.coffeemeetsbagel.models.constants.ProfileConstants.POSSIBLE_DISTANCE_VALUES_KM
            r8 = r8[r7]
            goto L_0x0049
        L_0x0047:
            r8 = r20
        L_0x0049:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0053
            r9 = 4
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L_0x0055
        L_0x0053:
            r9 = r21
        L_0x0055:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0060
            r10 = 8
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x0062
        L_0x0060:
            r10 = r22
        L_0x0062:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x006b
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x006d
        L_0x006b:
            r7 = r23
        L_0x006d:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0078
            r11 = 11
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x007a
        L_0x0078:
            r11 = r24
        L_0x007a:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0085
            r12 = 122(0x7a, float:1.71E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0087
        L_0x0085:
            r12 = r25
        L_0x0087:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0092
            r0 = 272(0x110, float:3.81E-43)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0094
        L_0x0092:
            r0 = r26
        L_0x0094:
            r14 = r13
            r15 = r1
            r16 = r2
            r17 = r3
            r18 = r5
            r19 = r4
            r20 = r6
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r7
            r25 = r11
            r26 = r12
            r27 = r0
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ja.a.<init>(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
