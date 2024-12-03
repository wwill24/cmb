package com.withpersona.sdk2.camera;

import com.facebook.appevents.AppEventsConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.apache.commons.beanutils.PropertyUtils;

public final class MrzExtraction {

    /* renamed from: p  reason: collision with root package name */
    public static final Companion f14143p = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final Regex f14144q = new Regex("([A|C|I][A-Z0-9<]{1})([A-Z]{3})([A-Z0-9<]{9})([0-9]{1})([A-Z0-9<]{15})");
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static final Regex f14145r = new Regex("([0-9]{6})([0-9]{1})([M|F|X|<]{1})([0-9]{6})([0-9]{1})([A-Z]{3})([A-Z0-9<]{11})([0-9]{1})");
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static final Regex f14146s = new Regex("([A-Z0-9<]+?)<<([A-Z0-9<]+?)<<+");

    /* renamed from: t  reason: collision with root package name */
    private static final Regex f14147t = new Regex("([A|C|I][A-Z0-9<]{1})([A-Z]{3})([A-Z0-9<]{31})");

    /* renamed from: u  reason: collision with root package name */
    private static final Regex f14148u = new Regex("([A-Z0-9<]{9})([0-9]{1})([A-Z]{3})([0-9]{6})([0-9]{1})([M|F|X|<]{1})([0-9]{6})([0-9]{1})([A-Z0-9<]{7})([0-9]{1})");

    /* renamed from: v  reason: collision with root package name */
    private static final Regex f14149v = new Regex("(P[A-Z0-9<]{1})([A-Z]{3})([A-Z0-9<]+?<<+)");
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public static final Regex f14150w = new Regex("(P[A-Z0-9<]{1})([A-Z]{3})([A-Z0-9<]+?)<<([A-Z0-9<]+<<+)");
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public static final Regex f14151x = new Regex("([A-Z0-9<]{9})([0-9]{1})([A-Z]{3})([0-9]{6})([0-9]{1})([M|F|X|<]{1})([0-9]{6})([0-9]{1})?([A-Z0-9<]{14})?([0-9]{1})?([0-9]{1})?");

    /* renamed from: a  reason: collision with root package name */
    private final String f14152a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14153b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14154c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14155d;

    /* renamed from: e  reason: collision with root package name */
    private final String f14156e;

    /* renamed from: f  reason: collision with root package name */
    private final String f14157f;

    /* renamed from: g  reason: collision with root package name */
    private final String f14158g;

    /* renamed from: h  reason: collision with root package name */
    private final String f14159h;

    /* renamed from: i  reason: collision with root package name */
    private final String f14160i;

    /* renamed from: j  reason: collision with root package name */
    private final String f14161j;

    /* renamed from: k  reason: collision with root package name */
    private final String f14162k;

    /* renamed from: l  reason: collision with root package name */
    private final Date f14163l;

    /* renamed from: m  reason: collision with root package name */
    private final Date f14164m;

    /* renamed from: n  reason: collision with root package name */
    private final Date f14165n;

    /* renamed from: o  reason: collision with root package name */
    private final String f14166o;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Date a(String str) {
            if (str == null) {
                return null;
            }
            try {
                return new SimpleDateFormat("yyMMdd", Locale.US).parse(new Regex("G").f(new Regex("S").f(new Regex("O").f(new Regex("D").f(new Regex("L").f(new Regex("I").f(str, AppEventsConstants.EVENT_PARAM_VALUE_YES), AppEventsConstants.EVENT_PARAM_VALUE_YES), "0"), "0"), "5"), "6"));
            } catch (ParseException unused) {
                return null;
            }
        }

        private final String b(String str) {
            if (str == null) {
                return null;
            }
            return StringsKt__StringsKt.W0(r.D(str, "<", " ", false, 4, (Object) null)).toString();
        }

        private final MrzExtraction d(String str) {
            MatchResult c10;
            String str2 = str;
            MatchResult c11 = Regex.c(MrzExtraction.f14144q, str2, 0, 2, (Object) null);
            if (c11 == null || (c10 = Regex.c(MrzExtraction.f14145r, str2, 0, 2, (Object) null)) == null) {
                return null;
            }
            MatchResult c12 = Regex.c(MrzExtraction.f14146s, r.D(r.D(str, c11.getValue(), "", false, 4, (Object) null), c10.getValue(), "", false, 4, (Object) null), 0, 2, (Object) null);
            if (c12 == null) {
                return null;
            }
            MatchResult[] matchResultArr = {c11, c10, c12};
            String str3 = c11.a().get(3);
            Date a10 = a(c10.a().get(1));
            String str4 = c10.a().get(3);
            Date a11 = a(c10.a().get(4));
            return new MrzExtraction(CollectionsKt___CollectionsKt.W(q.m(matchResultArr), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, MrzExtraction$Companion$parseTd1$1.f14167a, 30, (Object) null), (String) null, b(c12.a().get(2)), (String) null, b(c12.a().get(1)), str4, (String) null, (String) null, (String) null, (String) null, str3, (Date) null, a11, a10, c11.a().get(2), 3018, (DefaultConstructorMarker) null);
        }

        private final MrzExtraction e(String str) {
            MatchResult c10;
            String str2 = str;
            MatchResult c11 = Regex.c(MrzExtraction.f14150w, str2, 0, 2, (Object) null);
            if (c11 == null || (c10 = Regex.c(MrzExtraction.f14151x, str2, 0, 2, (Object) null)) == null) {
                return null;
            }
            MatchResult[] matchResultArr = {c11, c10};
            String b10 = b(c11.a().get(4));
            String b11 = b(c11.a().get(3));
            String str3 = c10.a().get(1);
            Date a10 = a(c10.a().get(4));
            return new MrzExtraction(CollectionsKt___CollectionsKt.W(q.m(matchResultArr), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, MrzExtraction$Companion$parseTd3$1.f14168a, 30, (Object) null), (String) null, b10, (String) null, b11, c10.a().get(6), (String) null, (String) null, (String) null, (String) null, str3, (Date) null, a(c10.a().get(7)), a10, c11.a().get(2), 3018, (DefaultConstructorMarker) null);
        }

        public final MrzExtraction c(String str) {
            if (str == null) {
                return null;
            }
            String f10 = new Regex("(\r|\t| )").f(str, "");
            Locale locale = Locale.getDefault();
            j.f(locale, "getDefault()");
            String upperCase = f10.toUpperCase(locale);
            j.f(upperCase, "this as java.lang.String).toUpperCase(locale)");
            MrzExtraction d10 = d(upperCase);
            if (d10 == null) {
                return e(upperCase);
            }
            return d10;
        }
    }

    public MrzExtraction(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Date date, Date date2, Date date3, String str12) {
        j.g(str, "rawText");
        this.f14152a = str;
        this.f14153b = str2;
        this.f14154c = str3;
        this.f14155d = str4;
        this.f14156e = str5;
        this.f14157f = str6;
        this.f14158g = str7;
        this.f14159h = str8;
        this.f14160i = str9;
        this.f14161j = str10;
        this.f14162k = str11;
        this.f14163l = date;
        this.f14164m = date2;
        this.f14165n = date3;
        this.f14166o = str12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MrzExtraction)) {
            return false;
        }
        MrzExtraction mrzExtraction = (MrzExtraction) obj;
        return j.b(this.f14152a, mrzExtraction.f14152a) && j.b(this.f14153b, mrzExtraction.f14153b) && j.b(this.f14154c, mrzExtraction.f14154c) && j.b(this.f14155d, mrzExtraction.f14155d) && j.b(this.f14156e, mrzExtraction.f14156e) && j.b(this.f14157f, mrzExtraction.f14157f) && j.b(this.f14158g, mrzExtraction.f14158g) && j.b(this.f14159h, mrzExtraction.f14159h) && j.b(this.f14160i, mrzExtraction.f14160i) && j.b(this.f14161j, mrzExtraction.f14161j) && j.b(this.f14162k, mrzExtraction.f14162k) && j.b(this.f14163l, mrzExtraction.f14163l) && j.b(this.f14164m, mrzExtraction.f14164m) && j.b(this.f14165n, mrzExtraction.f14165n) && j.b(this.f14166o, mrzExtraction.f14166o);
    }

    public final Date f() {
        return this.f14165n;
    }

    public final Date g() {
        return this.f14164m;
    }

    public final String h() {
        return this.f14162k;
    }

    public int hashCode() {
        int hashCode = this.f14152a.hashCode() * 31;
        String str = this.f14153b;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f14154c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f14155d;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f14156e;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f14157f;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f14158g;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f14159h;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f14160i;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f14161j;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.f14162k;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Date date = this.f14163l;
        int hashCode12 = (hashCode11 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.f14164m;
        int hashCode13 = (hashCode12 + (date2 == null ? 0 : date2.hashCode())) * 31;
        Date date3 = this.f14165n;
        int hashCode14 = (hashCode13 + (date3 == null ? 0 : date3.hashCode())) * 31;
        String str11 = this.f14166o;
        if (str11 != null) {
            i10 = str11.hashCode();
        }
        return hashCode14 + i10;
    }

    public final String i() {
        return this.f14152a;
    }

    public String toString() {
        return "MrzExtraction(rawText=" + this.f14152a + ", idClass=" + this.f14153b + ", nameFirst=" + this.f14154c + ", nameMiddle=" + this.f14155d + ", nameLast=" + this.f14156e + ", sex=" + this.f14157f + ", addressStreet1=" + this.f14158g + ", addressCity=" + this.f14159h + ", addressState=" + this.f14160i + ", addressPostalCode=" + this.f14161j + ", identificationNumber=" + this.f14162k + ", issueDate=" + this.f14163l + ", expirationDate=" + this.f14164m + ", birthdate=" + this.f14165n + ", issuingCountry=" + this.f14166o + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MrzExtraction(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.util.Date r27, java.util.Date r28, java.util.Date r29, java.lang.String r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r15 = this;
            r0 = r31
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r19
        L_0x001b:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r20
        L_0x0023:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r21
        L_0x002b:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r22
        L_0x0033:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r23
        L_0x003b:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r24
        L_0x0043:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r25
        L_0x004b:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r26
        L_0x0053:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r27
        L_0x005b:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r28
        L_0x0063:
            r14 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r29
        L_0x006b:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r2 = r30
        L_0x0072:
            r17 = r15
            r18 = r16
            r19 = r1
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r8
            r26 = r9
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.MrzExtraction.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.util.Date, java.util.Date, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
