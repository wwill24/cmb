package zh;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Integer f24801a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f24802b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f24803c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f24804d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f24805e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f24806f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f24807g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f24808h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24809i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f24810j;

    /* renamed from: k  reason: collision with root package name */
    private final Integer f24811k;

    /* renamed from: l  reason: collision with root package name */
    private final Integer f24812l;

    /* renamed from: m  reason: collision with root package name */
    private final Integer f24813m;

    /* renamed from: n  reason: collision with root package name */
    private Integer f24814n;

    /* renamed from: o  reason: collision with root package name */
    private Integer f24815o;

    /* renamed from: p  reason: collision with root package name */
    private Integer f24816p;

    /* renamed from: q  reason: collision with root package name */
    private Integer f24817q;

    /* renamed from: r  reason: collision with root package name */
    private Integer f24818r;

    public a() {
        this((Integer) null, (Integer) null, (Integer) null, (Integer) null, (Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null, false, (CharSequence) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 262143, (DefaultConstructorMarker) null);
    }

    public a(Integer num, Integer num2, Integer num3, Integer num4, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, boolean z10, CharSequence charSequence, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12) {
        j.g(charSequence, "contentDescription");
        this.f24801a = num;
        this.f24802b = num2;
        this.f24803c = num3;
        this.f24804d = num4;
        this.f24805e = drawable;
        this.f24806f = drawable2;
        this.f24807g = drawable3;
        this.f24808h = drawable4;
        this.f24809i = z10;
        this.f24810j = charSequence;
        this.f24811k = num5;
        this.f24812l = num6;
        this.f24813m = num7;
        this.f24814n = num8;
        this.f24815o = num9;
        this.f24816p = num10;
        this.f24817q = num11;
        this.f24818r = num12;
    }

    public final void A(boolean z10) {
        this.f24809i = z10;
    }

    public final Integer a() {
        return this.f24811k;
    }

    public final Integer b() {
        return this.f24814n;
    }

    public final CharSequence c() {
        return this.f24810j;
    }

    public final Drawable d() {
        return this.f24807g;
    }

    public final Integer e() {
        return this.f24803c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.b(this.f24801a, aVar.f24801a) && j.b(this.f24802b, aVar.f24802b) && j.b(this.f24803c, aVar.f24803c) && j.b(this.f24804d, aVar.f24804d) && j.b(this.f24805e, aVar.f24805e) && j.b(this.f24806f, aVar.f24806f) && j.b(this.f24807g, aVar.f24807g) && j.b(this.f24808h, aVar.f24808h) && this.f24809i == aVar.f24809i && j.b(this.f24810j, aVar.f24810j) && j.b(this.f24811k, aVar.f24811k) && j.b(this.f24812l, aVar.f24812l) && j.b(this.f24813m, aVar.f24813m) && j.b(this.f24814n, aVar.f24814n) && j.b(this.f24815o, aVar.f24815o) && j.b(this.f24816p, aVar.f24816p) && j.b(this.f24817q, aVar.f24817q) && j.b(this.f24818r, aVar.f24818r);
    }

    public final Drawable f() {
        return this.f24806f;
    }

    public final Integer g() {
        return this.f24802b;
    }

    public final Drawable h() {
        return this.f24805e;
    }

    public int hashCode() {
        Integer num = this.f24801a;
        int i10 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.f24802b;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f24803c;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f24804d;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Drawable drawable = this.f24805e;
        int hashCode5 = (hashCode4 + (drawable == null ? 0 : drawable.hashCode())) * 31;
        Drawable drawable2 = this.f24806f;
        int hashCode6 = (hashCode5 + (drawable2 == null ? 0 : drawable2.hashCode())) * 31;
        Drawable drawable3 = this.f24807g;
        int hashCode7 = (hashCode6 + (drawable3 == null ? 0 : drawable3.hashCode())) * 31;
        Drawable drawable4 = this.f24808h;
        int hashCode8 = (hashCode7 + (drawable4 == null ? 0 : drawable4.hashCode())) * 31;
        boolean z10 = this.f24809i;
        if (z10) {
            z10 = true;
        }
        int hashCode9 = (((hashCode8 + (z10 ? 1 : 0)) * 31) + this.f24810j.hashCode()) * 31;
        Integer num5 = this.f24811k;
        int hashCode10 = (hashCode9 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.f24812l;
        int hashCode11 = (hashCode10 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.f24813m;
        int hashCode12 = (hashCode11 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.f24814n;
        int hashCode13 = (hashCode12 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.f24815o;
        int hashCode14 = (hashCode13 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.f24816p;
        int hashCode15 = (hashCode14 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.f24817q;
        int hashCode16 = (hashCode15 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.f24818r;
        if (num12 != null) {
            i10 = num12.hashCode();
        }
        return hashCode16 + i10;
    }

    public final Integer i() {
        return this.f24801a;
    }

    public final Drawable j() {
        return this.f24808h;
    }

    public final Integer k() {
        return this.f24804d;
    }

    public final Integer l() {
        return this.f24817q;
    }

    public final Integer m() {
        return this.f24813m;
    }

    public final Integer n() {
        return this.f24812l;
    }

    public final Integer o() {
        return this.f24818r;
    }

    public final Integer p() {
        return this.f24815o;
    }

    public final Integer q() {
        return this.f24816p;
    }

    public final boolean r() {
        return this.f24809i;
    }

    public final void s(Drawable drawable) {
        this.f24807g = drawable;
    }

    public final void t(Integer num) {
        this.f24803c = num;
    }

    public String toString() {
        return "VectorTextViewParams(drawableStartRes=" + this.f24801a + ", drawableEndRes=" + this.f24802b + ", drawableBottomRes=" + this.f24803c + ", drawableTopRes=" + this.f24804d + ", drawableStart=" + this.f24805e + ", drawableEnd=" + this.f24806f + ", drawableBottom=" + this.f24807g + ", drawableTop=" + this.f24808h + ", isRtlLayout=" + this.f24809i + ", contentDescription=" + this.f24810j + ", compoundDrawablePadding=" + this.f24811k + ", iconWidth=" + this.f24812l + ", iconHeight=" + this.f24813m + ", compoundDrawablePaddingRes=" + this.f24814n + ", tintColor=" + this.f24815o + ", widthRes=" + this.f24816p + ", heightRes=" + this.f24817q + ", squareSizeRes=" + this.f24818r + PropertyUtils.MAPPED_DELIM2;
    }

    public final void u(Drawable drawable) {
        this.f24806f = drawable;
    }

    public final void v(Integer num) {
        this.f24802b = num;
    }

    public final void w(Drawable drawable) {
        this.f24805e = drawable;
    }

    public final void x(Integer num) {
        this.f24801a = num;
    }

    public final void y(Drawable drawable) {
        this.f24808h = drawable;
    }

    public final void z(Integer num) {
        this.f24804d = num;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(java.lang.Integer r20, java.lang.Integer r21, java.lang.Integer r22, java.lang.Integer r23, android.graphics.drawable.Drawable r24, android.graphics.drawable.Drawable r25, android.graphics.drawable.Drawable r26, android.graphics.drawable.Drawable r27, boolean r28, java.lang.CharSequence r29, java.lang.Integer r30, java.lang.Integer r31, java.lang.Integer r32, java.lang.Integer r33, java.lang.Integer r34, java.lang.Integer r35, java.lang.Integer r36, java.lang.Integer r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
        /*
            r19 = this;
            r0 = r38
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r20
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r21
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r22
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r23
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r24
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r25
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r26
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r27
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r28
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0053
            kotlin.jvm.internal.o r11 = kotlin.jvm.internal.o.f32141a
            java.lang.String r11 = ""
            goto L_0x0055
        L_0x0053:
            r11 = r29
        L_0x0055:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005b
            r12 = 0
            goto L_0x005d
        L_0x005b:
            r12 = r30
        L_0x005d:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0063
            r13 = 0
            goto L_0x0065
        L_0x0063:
            r13 = r31
        L_0x0065:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006b
            r14 = 0
            goto L_0x006d
        L_0x006b:
            r14 = r32
        L_0x006d:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0073
            r15 = 0
            goto L_0x0075
        L_0x0073:
            r15 = r33
        L_0x0075:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x007b
            r2 = 0
            goto L_0x007d
        L_0x007b:
            r2 = r34
        L_0x007d:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0087
            r16 = 0
            goto L_0x0089
        L_0x0087:
            r16 = r35
        L_0x0089:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0092
            r17 = 0
            goto L_0x0094
        L_0x0092:
            r17 = r36
        L_0x0094:
            r18 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r18
            if (r0 == 0) goto L_0x009c
            r0 = 0
            goto L_0x009e
        L_0x009c:
            r0 = r37
        L_0x009e:
            r20 = r19
            r21 = r1
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r30 = r11
            r31 = r12
            r32 = r13
            r33 = r14
            r34 = r15
            r35 = r2
            r36 = r16
            r37 = r17
            r38 = r0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zh.a.<init>(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, android.graphics.drawable.Drawable, android.graphics.drawable.Drawable, android.graphics.drawable.Drawable, android.graphics.drawable.Drawable, boolean, java.lang.CharSequence, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
