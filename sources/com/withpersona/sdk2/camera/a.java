package com.withpersona.sdk2.camera;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import org.apache.commons.beanutils.PropertyUtils;

public final class a {
    /* access modifiers changed from: private */
    public static final Regex A;
    /* access modifiers changed from: private */
    public static final Regex B;

    /* renamed from: o  reason: collision with root package name */
    public static final C0149a f14198o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static final Regex f14199p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final Regex f14200q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static final Regex f14201r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static final Regex f14202s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public static final Regex f14203t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public static final Regex f14204u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public static final Regex f14205v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public static final Regex f14206w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public static final Regex f14207x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public static final Regex f14208y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public static final Regex f14209z;

    /* renamed from: a  reason: collision with root package name */
    private final String f14210a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14211b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14212c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14213d;

    /* renamed from: e  reason: collision with root package name */
    private final String f14214e;

    /* renamed from: f  reason: collision with root package name */
    private final String f14215f;

    /* renamed from: g  reason: collision with root package name */
    private final String f14216g;

    /* renamed from: h  reason: collision with root package name */
    private final String f14217h;

    /* renamed from: i  reason: collision with root package name */
    private final String f14218i;

    /* renamed from: j  reason: collision with root package name */
    private final String f14219j;

    /* renamed from: k  reason: collision with root package name */
    private final Date f14220k;

    /* renamed from: l  reason: collision with root package name */
    private final Date f14221l;

    /* renamed from: m  reason: collision with root package name */
    private final Date f14222m;

    /* renamed from: n  reason: collision with root package name */
    private final String f14223n;

    /* renamed from: com.withpersona.sdk2.camera.a$a  reason: collision with other inner class name */
    public static final class C0149a {
        private C0149a() {
        }

        public /* synthetic */ C0149a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Date b(String str) {
            if (str == null) {
                return null;
            }
            return new SimpleDateFormat("MMddyyyy", Locale.US).parse(str);
        }

        /* access modifiers changed from: private */
        public final Regex c(String str) {
            return new Regex(10 + str + "(.+?)(\n|$)");
        }

        private final String e(String str, Regex regex) {
            List<String> a10;
            MatchResult c10 = Regex.c(regex, str, 0, 2, (Object) null);
            if (c10 == null || (a10 = c10.a()) == null) {
                return null;
            }
            return a10.get(1);
        }

        private final boolean f(String str) {
            if (!new Regex("^@\n\\u001e\r(ANSI |AAMVA)\\d{10}.+", RegexOption.DOT_MATCHES_ALL).e(StringsKt__StringsKt.W0(str).toString()) || e(str, a.f14205v) == null || e(str, a.f14209z) == null) {
                return false;
            }
            return true;
        }

        public final a d(String str) {
            String str2 = str;
            if (str2 != null && f(str)) {
                return new a((String) null, e(str2, a.f14205v), e(str2, a.B), e(str2, a.f14209z), e(str2, a.f14206w), e(str2, a.f14201r), e(str2, a.f14199p), e(str2, a.f14200q), e(str2, a.f14202s), e(str2, a.A), b(e(str2, a.f14207x)), b(e(str2, a.f14204u)), b(e(str2, a.f14203t)), e(str2, a.f14208y), 1, (DefaultConstructorMarker) null);
            }
            return null;
        }
    }

    static {
        C0149a aVar = new C0149a((DefaultConstructorMarker) null);
        f14198o = aVar;
        f14199p = aVar.c("DAI");
        f14200q = aVar.c("DAJ");
        f14201r = aVar.c("DAG");
        f14202s = aVar.c("DAK");
        f14203t = aVar.c("DBB");
        f14204u = aVar.c("DBA");
        f14205v = aVar.c("DAC");
        f14206w = aVar.c("DBC");
        f14207x = aVar.c("DBD");
        f14208y = aVar.c("DCG");
        f14209z = aVar.c("DCS");
        A = aVar.c("DAQ");
        B = aVar.c("DAD");
    }

    public a() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Date) null, (Date) null, (Date) null, (String) null, 16383, (DefaultConstructorMarker) null);
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Date date, Date date2, Date date3, String str11) {
        this.f14210a = str;
        this.f14211b = str2;
        this.f14212c = str3;
        this.f14213d = str4;
        this.f14214e = str5;
        this.f14215f = str6;
        this.f14216g = str7;
        this.f14217h = str8;
        this.f14218i = str9;
        this.f14219j = str10;
        this.f14220k = date;
        this.f14221l = date2;
        this.f14222m = date3;
        this.f14223n = str11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.b(this.f14210a, aVar.f14210a) && j.b(this.f14211b, aVar.f14211b) && j.b(this.f14212c, aVar.f14212c) && j.b(this.f14213d, aVar.f14213d) && j.b(this.f14214e, aVar.f14214e) && j.b(this.f14215f, aVar.f14215f) && j.b(this.f14216g, aVar.f14216g) && j.b(this.f14217h, aVar.f14217h) && j.b(this.f14218i, aVar.f14218i) && j.b(this.f14219j, aVar.f14219j) && j.b(this.f14220k, aVar.f14220k) && j.b(this.f14221l, aVar.f14221l) && j.b(this.f14222m, aVar.f14222m) && j.b(this.f14223n, aVar.f14223n);
    }

    public int hashCode() {
        String str = this.f14210a;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f14211b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f14212c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f14213d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f14214e;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f14215f;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f14216g;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f14217h;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f14218i;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.f14219j;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Date date = this.f14220k;
        int hashCode11 = (hashCode10 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.f14221l;
        int hashCode12 = (hashCode11 + (date2 == null ? 0 : date2.hashCode())) * 31;
        Date date3 = this.f14222m;
        int hashCode13 = (hashCode12 + (date3 == null ? 0 : date3.hashCode())) * 31;
        String str11 = this.f14223n;
        if (str11 != null) {
            i10 = str11.hashCode();
        }
        return hashCode13 + i10;
    }

    public final Date n() {
        return this.f14222m;
    }

    public final Date o() {
        return this.f14221l;
    }

    public String toString() {
        return "AamvaExtraction(idClass=" + this.f14210a + ", nameFirst=" + this.f14211b + ", nameMiddle=" + this.f14212c + ", nameLast=" + this.f14213d + ", sex=" + this.f14214e + ", addressStreet1=" + this.f14215f + ", addressCity=" + this.f14216g + ", addressState=" + this.f14217h + ", addressPostalCode=" + this.f14218i + ", identificationNumber=" + this.f14219j + ", issueDate=" + this.f14220k + ", expirationDate=" + this.f14221l + ", birthdate=" + this.f14222m + ", issuingCountry=" + this.f14223n + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.util.Date r26, java.util.Date r27, java.util.Date r28, java.lang.String r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r17
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r18
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r19
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r20
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r21
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r22
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r23
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r24
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r25
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r26
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r27
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r28
        L_0x006b:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r2 = r29
        L_0x0072:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r2
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.a.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.util.Date, java.util.Date, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
