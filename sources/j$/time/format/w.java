package j$.time.format;

import com.leanplum.internal.Constants;
import j$.time.chrono.g;
import j$.time.temporal.a;
import j$.time.temporal.j;
import j$.time.temporal.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Objects;
import net.bytebuddy.asm.Advice;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.jivesoftware.smackx.xdata.FormField;

public final class w {

    /* renamed from: h  reason: collision with root package name */
    private static final C0523a f42679h = new C0523a();

    /* renamed from: i  reason: collision with root package name */
    private static final HashMap f42680i;

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ int f42681j = 0;

    /* renamed from: a  reason: collision with root package name */
    private w f42682a;

    /* renamed from: b  reason: collision with root package name */
    private final w f42683b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList f42684c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f42685d;

    /* renamed from: e  reason: collision with root package name */
    private int f42686e;

    /* renamed from: f  reason: collision with root package name */
    private char f42687f;

    /* renamed from: g  reason: collision with root package name */
    private int f42688g;

    static {
        HashMap hashMap = new HashMap();
        f42680i = hashMap;
        hashMap.put('G', a.ERA);
        hashMap.put('y', a.YEAR_OF_ERA);
        hashMap.put('u', a.YEAR);
        m mVar = j.f42732a;
        hashMap.put('Q', mVar);
        hashMap.put('q', mVar);
        a aVar = a.MONTH_OF_YEAR;
        hashMap.put('M', aVar);
        hashMap.put(Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_LT), aVar);
        hashMap.put('D', a.DAY_OF_YEAR);
        hashMap.put(Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL), a.DAY_OF_MONTH);
        hashMap.put('F', a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        a aVar2 = a.DAY_OF_WEEK;
        hashMap.put('E', aVar2);
        hashMap.put('c', aVar2);
        hashMap.put('e', aVar2);
        hashMap.put('a', a.AMPM_OF_DAY);
        hashMap.put('H', a.HOUR_OF_DAY);
        hashMap.put('k', a.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', a.HOUR_OF_AMPM);
        hashMap.put('h', a.CLOCK_HOUR_OF_AMPM);
        hashMap.put(Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL), a.MINUTE_OF_HOUR);
        hashMap.put(Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL), a.SECOND_OF_MINUTE);
        a aVar3 = a.NANO_OF_SECOND;
        hashMap.put('S', aVar3);
        hashMap.put('A', a.MILLI_OF_DAY);
        hashMap.put('n', aVar3);
        hashMap.put('N', a.NANO_OF_DAY);
    }

    public w() {
        this.f42682a = this;
        this.f42684c = new ArrayList();
        this.f42688g = -1;
        this.f42683b = null;
        this.f42685d = false;
    }

    private w(w wVar) {
        this.f42682a = this;
        this.f42684c = new ArrayList();
        this.f42688g = -1;
        this.f42683b = wVar;
        this.f42685d = true;
    }

    private int d(C0529g gVar) {
        Objects.requireNonNull(gVar, "pp");
        w wVar = this.f42682a;
        int i10 = wVar.f42686e;
        if (i10 > 0) {
            m mVar = new m(gVar, i10, wVar.f42687f);
            wVar.f42686e = 0;
            wVar.f42687f = 0;
            gVar = mVar;
        }
        wVar.f42684c.add(gVar);
        w wVar2 = this.f42682a;
        wVar2.f42688g = -1;
        return wVar2.f42684c.size() - 1;
    }

    private void k(k kVar) {
        k kVar2;
        w wVar = this.f42682a;
        int i10 = wVar.f42688g;
        if (i10 >= 0) {
            k kVar3 = (k) wVar.f42684c.get(i10);
            if (kVar.f42639b == kVar.f42640c && kVar.f42641d == 4) {
                kVar2 = kVar3.h(kVar.f42640c);
                d(kVar.g());
                this.f42682a.f42688g = i10;
            } else {
                kVar2 = kVar3.g();
                this.f42682a.f42688g = d(kVar);
            }
            this.f42682a.f42684c.set(i10, kVar2);
            return;
        }
        wVar.f42688g = d(kVar);
    }

    private DateTimeFormatter v(Locale locale, F f10, g gVar) {
        Objects.requireNonNull(locale, Constants.Keys.LOCALE);
        while (this.f42682a.f42683b != null) {
            o();
        }
        C0528f fVar = new C0528f(this.f42684c, false);
        D d10 = D.f42599a;
        return new DateTimeFormatter(fVar, locale, f10, gVar);
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        d(dateTimeFormatter.h());
    }

    public final void b(a aVar, int i10, int i11, boolean z10) {
        d(new C0530h(aVar, i10, i11, z10));
    }

    public final void c() {
        d(new C0531i());
    }

    public final void e(char c10) {
        d(new C0527e(c10));
    }

    public final void f(String str) {
        Objects.requireNonNull(str, "literal");
        if (str.length() > 0) {
            d(str.length() == 1 ? new C0527e(str.charAt(0)) : new j(str, 1));
        }
    }

    public final void g(String str, String str2) {
        d(new l(str, str2));
    }

    public final void h() {
        d(l.f42644d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00eb, code lost:
        if (r3 == 1) goto L_0x0203;
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x03d3  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x02b2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x03ec A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.String r2 = "pattern"
            java.util.Objects.requireNonNull(r1, r2)
            r2 = 0
            r3 = r2
        L_0x000b:
            int r4 = r17.length()
            if (r3 >= r4) goto L_0x044d
            char r4 = r1.charAt(r3)
            r5 = 65
            r6 = 122(0x7a, float:1.71E-43)
            r7 = 90
            r8 = 97
            r9 = 1
            if (r4 < r5) goto L_0x0022
            if (r4 <= r7) goto L_0x0026
        L_0x0022:
            if (r4 < r8) goto L_0x03a7
            if (r4 > r6) goto L_0x03a7
        L_0x0026:
            int r10 = r3 + 1
        L_0x0028:
            int r11 = r17.length()
            if (r10 >= r11) goto L_0x0037
            char r11 = r1.charAt(r10)
            if (r11 != r4) goto L_0x0037
            int r10 = r10 + 1
            goto L_0x0028
        L_0x0037:
            int r3 = r10 - r3
            r11 = 112(0x70, float:1.57E-43)
            r12 = -1
            if (r4 != r11) goto L_0x00a6
            int r11 = r17.length()
            if (r10 >= r11) goto L_0x0064
            char r4 = r1.charAt(r10)
            if (r4 < r5) goto L_0x004c
            if (r4 <= r7) goto L_0x0050
        L_0x004c:
            if (r4 < r8) goto L_0x0064
            if (r4 > r6) goto L_0x0064
        L_0x0050:
            int r5 = r10 + 1
        L_0x0052:
            int r11 = r17.length()
            if (r5 >= r11) goto L_0x0061
            char r11 = r1.charAt(r5)
            if (r11 != r4) goto L_0x0061
            int r5 = r5 + 1
            goto L_0x0052
        L_0x0061:
            int r10 = r5 - r10
            goto L_0x0067
        L_0x0064:
            r5 = r10
            r10 = r3
            r3 = r2
        L_0x0067:
            if (r3 == 0) goto L_0x008f
            if (r3 < r9) goto L_0x0078
            j$.time.format.w r11 = r0.f42682a
            r11.f42686e = r3
            r3 = 32
            r11.f42687f = r3
            r11.f42688g = r12
            r3 = r10
            r10 = r5
            goto L_0x00a6
        L_0x0078:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "The pad width must be at least one but was "
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x008f:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Pad letter 'p' must be followed by valid pad pattern: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x00a6:
            java.util.HashMap r5 = f42680i
            java.lang.Character r11 = java.lang.Character.valueOf(r4)
            java.lang.Object r5 = r5.get(r11)
            j$.time.temporal.m r5 = (j$.time.temporal.m) r5
            r11 = 4
            java.lang.String r13 = "Too many pattern letters: "
            r14 = 2
            r15 = 5
            if (r5 == 0) goto L_0x0219
            r6 = 81
            r7 = 3
            r12 = 19
            if (r4 == r6) goto L_0x01aa
            r6 = 83
            if (r4 == r6) goto L_0x01a2
            if (r4 == r8) goto L_0x018a
            r6 = 104(0x68, float:1.46E-43)
            if (r4 == r6) goto L_0x016b
            r6 = 107(0x6b, float:1.5E-43)
            if (r4 == r6) goto L_0x016b
            r6 = 109(0x6d, float:1.53E-43)
            if (r4 == r6) goto L_0x016b
            r6 = 113(0x71, float:1.58E-43)
            if (r4 == r6) goto L_0x0169
            r6 = 115(0x73, float:1.61E-43)
            if (r4 == r6) goto L_0x016b
            r6 = 117(0x75, float:1.64E-43)
            if (r4 == r6) goto L_0x0150
            r6 = 121(0x79, float:1.7E-43)
            if (r4 == r6) goto L_0x0150
            switch(r4) {
                case 68: goto L_0x0129;
                case 69: goto L_0x01aa;
                case 70: goto L_0x0110;
                case 71: goto L_0x00ef;
                case 72: goto L_0x016b;
                default: goto L_0x00e5;
            }
        L_0x00e5:
            switch(r4) {
                case 75: goto L_0x016b;
                case 76: goto L_0x0169;
                case 77: goto L_0x01aa;
                default: goto L_0x00e8;
            }
        L_0x00e8:
            switch(r4) {
                case 99: goto L_0x0145;
                case 100: goto L_0x016b;
                case 101: goto L_0x01aa;
                default: goto L_0x00eb;
            }
        L_0x00eb:
            if (r3 != r9) goto L_0x0171
            goto L_0x0203
        L_0x00ef:
            if (r3 == r9) goto L_0x01ec
            if (r3 == r14) goto L_0x01ec
            if (r3 == r7) goto L_0x01ec
            if (r3 == r11) goto L_0x01d7
            if (r3 != r15) goto L_0x00fb
            goto L_0x01ba
        L_0x00fb:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0110:
            if (r3 != r9) goto L_0x0114
            goto L_0x0203
        L_0x0114:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0129:
            if (r3 != r9) goto L_0x012d
            goto L_0x0203
        L_0x012d:
            if (r3 > r7) goto L_0x0130
            goto L_0x0171
        L_0x0130:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0145:
            if (r3 == r14) goto L_0x0148
            goto L_0x0169
        L_0x0148:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Invalid pattern \"cc\""
            r1.<init>(r2)
            throw r1
        L_0x0150:
            if (r3 != r14) goto L_0x0162
            j$.time.LocalDate r3 = j$.time.format.q.f42661i
            java.lang.String r4 = "baseDate"
            java.util.Objects.requireNonNull(r3, r4)
            j$.time.format.q r4 = new j$.time.format.q
            r4.<init>(r5, r3)
            r0.k(r4)
            goto L_0x01a7
        L_0x0162:
            if (r3 >= r11) goto L_0x0165
            r15 = r9
        L_0x0165:
            r0.m(r5, r3, r12, r15)
            goto L_0x01a7
        L_0x0169:
            r6 = r9
            goto L_0x01ab
        L_0x016b:
            if (r3 != r9) goto L_0x016f
            goto L_0x0203
        L_0x016f:
            if (r3 != r14) goto L_0x0175
        L_0x0171:
            r0.l(r5, r3)
            goto L_0x01a7
        L_0x0175:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x018a:
            if (r3 != r9) goto L_0x018d
            goto L_0x01ec
        L_0x018d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01a2:
            j$.time.temporal.a r4 = j$.time.temporal.a.NANO_OF_SECOND
            r0.b(r4, r3, r3, r2)
        L_0x01a7:
            r3 = -1
            goto L_0x038d
        L_0x01aa:
            r6 = r2
        L_0x01ab:
            if (r3 == r9) goto L_0x01df
            if (r3 == r14) goto L_0x01df
            if (r3 == r7) goto L_0x01da
            if (r3 == r11) goto L_0x01d2
            if (r3 != r15) goto L_0x01bd
            if (r6 == 0) goto L_0x01ba
            j$.time.format.H r3 = j$.time.format.H.NARROW_STANDALONE
            goto L_0x01ee
        L_0x01ba:
            j$.time.format.H r3 = j$.time.format.H.NARROW
            goto L_0x01ee
        L_0x01bd:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01d2:
            if (r6 == 0) goto L_0x01d7
            j$.time.format.H r3 = j$.time.format.H.FULL_STANDALONE
            goto L_0x01ee
        L_0x01d7:
            j$.time.format.H r3 = j$.time.format.H.FULL
            goto L_0x01ee
        L_0x01da:
            if (r6 == 0) goto L_0x01ec
            j$.time.format.H r3 = j$.time.format.H.SHORT_STANDALONE
            goto L_0x01ee
        L_0x01df:
            r6 = 99
            if (r4 == r6) goto L_0x0210
            r6 = 101(0x65, float:1.42E-43)
            if (r4 != r6) goto L_0x01e8
            goto L_0x0210
        L_0x01e8:
            r6 = 69
            if (r4 != r6) goto L_0x0201
        L_0x01ec:
            j$.time.format.H r3 = j$.time.format.H.SHORT
        L_0x01ee:
            java.lang.String r4 = "textStyle"
            java.util.Objects.requireNonNull(r3, r4)
            j$.time.format.s r4 = new j$.time.format.s
            j$.time.format.C r6 = new j$.time.format.C
            r6.<init>()
            r4.<init>(r5, r3, r6)
            r0.d(r4)
            goto L_0x01a7
        L_0x0201:
            if (r3 != r9) goto L_0x020c
        L_0x0203:
            j$.time.format.k r3 = new j$.time.format.k
            r3.<init>(r5, r9, r12, r9)
            r0.k(r3)
            goto L_0x01a7
        L_0x020c:
            r0.l(r5, r14)
            goto L_0x01a7
        L_0x0210:
            j$.time.format.t r5 = new j$.time.format.t
            r5.<init>(r4, r3)
            r0.d(r5)
            goto L_0x01a7
        L_0x0219:
            if (r4 != r6) goto L_0x0243
            if (r3 > r11) goto L_0x022e
            if (r3 != r11) goto L_0x0222
            j$.time.format.H r3 = j$.time.format.H.FULL
            goto L_0x0224
        L_0x0222:
            j$.time.format.H r3 = j$.time.format.H.SHORT
        L_0x0224:
            j$.time.format.v r4 = new j$.time.format.v
            r4.<init>(r3)
            r0.d(r4)
            goto L_0x01a7
        L_0x022e:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0243:
            r5 = 86
            if (r4 != r5) goto L_0x0270
            if (r3 != r14) goto L_0x0259
            j$.time.format.u r3 = new j$.time.format.u
            j$.time.temporal.n r4 = j$.time.temporal.o.g()
            java.lang.String r5 = "ZoneId()"
            r3.<init>(r4, r5)
            r0.d(r3)
            goto L_0x01a7
        L_0x0259:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Pattern letter count must be 2: "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0270:
            java.lang.String r5 = "+0000"
            if (r4 != r7) goto L_0x0297
            if (r3 >= r11) goto L_0x027a
            java.lang.String r3 = "+HHMM"
            goto L_0x0323
        L_0x027a:
            if (r3 != r11) goto L_0x027d
            goto L_0x02a2
        L_0x027d:
            if (r3 != r15) goto L_0x0282
            java.lang.String r3 = "+HH:MM:ss"
            goto L_0x02eb
        L_0x0282:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0297:
            r6 = 79
            if (r4 != r6) goto L_0x02db
            if (r3 != r9) goto L_0x02a0
            j$.time.format.H r3 = j$.time.format.H.SHORT
            goto L_0x02a4
        L_0x02a0:
            if (r3 != r11) goto L_0x02c4
        L_0x02a2:
            j$.time.format.H r3 = j$.time.format.H.FULL
        L_0x02a4:
            java.lang.String r4 = "style"
            java.util.Objects.requireNonNull(r3, r4)
            j$.time.format.H r4 = j$.time.format.H.FULL
            if (r3 == r4) goto L_0x02ba
            j$.time.format.H r4 = j$.time.format.H.SHORT
            if (r3 != r4) goto L_0x02b2
            goto L_0x02ba
        L_0x02b2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Style must be either full or short"
            r1.<init>(r2)
            throw r1
        L_0x02ba:
            j$.time.format.j r4 = new j$.time.format.j
            r4.<init>(r3, r2)
            r0.d(r4)
            goto L_0x01a7
        L_0x02c4:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Pattern letter count must be 1 or 4: "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x02db:
            r6 = 88
            if (r4 != r6) goto L_0x0307
            if (r3 > r15) goto L_0x02f2
            java.lang.String[] r4 = j$.time.format.l.f42643c
            if (r3 != r9) goto L_0x02e7
            r5 = r2
            goto L_0x02e8
        L_0x02e7:
            r5 = r9
        L_0x02e8:
            int r3 = r3 + r5
            r3 = r4[r3]
        L_0x02eb:
            java.lang.String r4 = "Z"
            r0.g(r3, r4)
            goto L_0x01a7
        L_0x02f2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0307:
            r6 = 120(0x78, float:1.68E-43)
            if (r4 != r6) goto L_0x033d
            if (r3 > r15) goto L_0x0328
            if (r3 != r9) goto L_0x0312
            java.lang.String r5 = "+00"
            goto L_0x0319
        L_0x0312:
            int r4 = r3 % 2
            if (r4 != 0) goto L_0x0317
            goto L_0x0319
        L_0x0317:
            java.lang.String r5 = "+00:00"
        L_0x0319:
            java.lang.String[] r4 = j$.time.format.l.f42643c
            if (r3 != r9) goto L_0x031f
            r6 = r2
            goto L_0x0320
        L_0x031f:
            r6 = r9
        L_0x0320:
            int r3 = r3 + r6
            r3 = r4[r3]
        L_0x0323:
            r0.g(r3, r5)
            goto L_0x01a7
        L_0x0328:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x033d:
            r5 = 87
            if (r4 != r5) goto L_0x035e
            if (r3 > r9) goto L_0x0349
            j$.time.format.t r5 = new j$.time.format.t
            r5.<init>(r4, r3)
            goto L_0x0388
        L_0x0349:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x035e:
            r5 = 119(0x77, float:1.67E-43)
            if (r4 != r5) goto L_0x037f
            if (r3 > r14) goto L_0x036a
            j$.time.format.t r5 = new j$.time.format.t
            r5.<init>(r4, r3)
            goto L_0x0388
        L_0x036a:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x037f:
            r5 = 89
            if (r4 != r5) goto L_0x0390
            j$.time.format.t r5 = new j$.time.format.t
            r5.<init>(r4, r3)
        L_0x0388:
            r0.d(r5)
            goto L_0x01a7
        L_0x038d:
            int r3 = r3 + r10
            goto L_0x0430
        L_0x0390:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unknown pattern letter: "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x03a7:
            java.lang.String r5 = "'"
            r6 = 39
            if (r4 != r6) goto L_0x0403
            int r3 = r3 + 1
            r4 = r3
        L_0x03b0:
            int r7 = r17.length()
            if (r4 >= r7) goto L_0x03cd
            char r7 = r1.charAt(r4)
            if (r7 != r6) goto L_0x03cb
            int r7 = r4 + 1
            int r8 = r17.length()
            if (r7 >= r8) goto L_0x03cd
            char r8 = r1.charAt(r7)
            if (r8 != r6) goto L_0x03cd
            r4 = r7
        L_0x03cb:
            int r4 = r4 + r9
            goto L_0x03b0
        L_0x03cd:
            int r7 = r17.length()
            if (r4 >= r7) goto L_0x03ec
            java.lang.String r3 = r1.substring(r3, r4)
            int r7 = r3.length()
            if (r7 != 0) goto L_0x03e1
            r0.e(r6)
            goto L_0x03ea
        L_0x03e1:
            java.lang.String r6 = "''"
            java.lang.String r3 = r3.replace(r6, r5)
            r0.f(r3)
        L_0x03ea:
            r3 = r4
            goto L_0x0430
        L_0x03ec:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Pattern ends with an incomplete string literal: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0403:
            r6 = 91
            if (r4 != r6) goto L_0x040b
            r16.p()
            goto L_0x0430
        L_0x040b:
            r6 = 93
            if (r4 != r6) goto L_0x0421
            j$.time.format.w r4 = r0.f42682a
            j$.time.format.w r4 = r4.f42683b
            if (r4 == 0) goto L_0x0419
            r16.o()
            goto L_0x0430
        L_0x0419:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Pattern invalid as it contains ] without previous ["
            r1.<init>(r2)
            throw r1
        L_0x0421:
            r6 = 123(0x7b, float:1.72E-43)
            if (r4 == r6) goto L_0x0433
            r6 = 125(0x7d, float:1.75E-43)
            if (r4 == r6) goto L_0x0433
            r6 = 35
            if (r4 == r6) goto L_0x0433
            r0.e(r4)
        L_0x0430:
            int r3 = r3 + r9
            goto L_0x000b
        L_0x0433:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Pattern includes reserved character: '"
            r2.append(r3)
            r2.append(r4)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x044d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.w.i(java.lang.String):void");
    }

    public final void j(a aVar, HashMap hashMap) {
        Objects.requireNonNull(aVar, FormField.ELEMENT);
        LinkedHashMap linkedHashMap = new LinkedHashMap(hashMap);
        H h10 = H.FULL;
        d(new s(aVar, h10, new C0524b(new B(Collections.singletonMap(h10, linkedHashMap)))));
    }

    public final void l(m mVar, int i10) {
        Objects.requireNonNull(mVar, FormField.ELEMENT);
        if (i10 < 1 || i10 > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i10);
        }
        k(new k(mVar, i10, i10, 4));
    }

    public final w m(m mVar, int i10, int i11, int i12) {
        if (i10 == i11 && i12 == 4) {
            l(mVar, i11);
            return this;
        }
        Objects.requireNonNull(mVar, FormField.ELEMENT);
        if (i12 == 0) {
            throw new NullPointerException("signStyle");
        } else if (i10 < 1 || i10 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i10);
        } else if (i11 < 1 || i11 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i11);
        } else if (i11 >= i10) {
            k(new k(mVar, i10, i11, i12));
            return this;
        } else {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i11 + " < " + i10);
        }
    }

    public final void n() {
        d(new u(f42679h, "ZoneRegionId()"));
    }

    public final void o() {
        w wVar = this.f42682a;
        if (wVar.f42683b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        } else if (wVar.f42684c.size() > 0) {
            w wVar2 = this.f42682a;
            C0528f fVar = new C0528f(wVar2.f42684c, wVar2.f42685d);
            this.f42682a = this.f42682a.f42683b;
            d(fVar);
        } else {
            this.f42682a = this.f42682a.f42683b;
        }
    }

    public final void p() {
        w wVar = this.f42682a;
        wVar.f42688g = -1;
        this.f42682a = new w(wVar);
    }

    public final void q() {
        d(r.INSENSITIVE);
    }

    public final void r() {
        d(r.SENSITIVE);
    }

    public final void s() {
        d(r.LENIENT);
    }

    public final DateTimeFormatter t() {
        return v(Locale.getDefault(), F.SMART, (g) null);
    }

    /* access modifiers changed from: package-private */
    public final DateTimeFormatter u(F f10, g gVar) {
        return v(Locale.getDefault(), f10, gVar);
    }
}
