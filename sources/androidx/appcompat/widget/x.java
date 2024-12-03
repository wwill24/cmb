package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.h;
import androidx.core.view.n0;
import d.j;
import java.lang.ref.WeakReference;
import java.util.Locale;

class x {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextView f1476a;

    /* renamed from: b  reason: collision with root package name */
    private f1 f1477b;

    /* renamed from: c  reason: collision with root package name */
    private f1 f1478c;

    /* renamed from: d  reason: collision with root package name */
    private f1 f1479d;

    /* renamed from: e  reason: collision with root package name */
    private f1 f1480e;

    /* renamed from: f  reason: collision with root package name */
    private f1 f1481f;

    /* renamed from: g  reason: collision with root package name */
    private f1 f1482g;

    /* renamed from: h  reason: collision with root package name */
    private f1 f1483h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final e0 f1484i;

    /* renamed from: j  reason: collision with root package name */
    private int f1485j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f1486k = -1;

    /* renamed from: l  reason: collision with root package name */
    private Typeface f1487l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1488m;

    class a extends h.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f1489a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1490b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WeakReference f1491c;

        a(int i10, int i11, WeakReference weakReference) {
            this.f1489a = i10;
            this.f1490b = i11;
            this.f1491c = weakReference;
        }

        public void h(int i10) {
        }

        public void i(@NonNull Typeface typeface) {
            int i10;
            boolean z10;
            if (Build.VERSION.SDK_INT >= 28 && (i10 = this.f1489a) != -1) {
                if ((this.f1490b & 2) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                typeface = f.a(typeface, i10, z10);
            }
            x.this.n(this.f1491c, typeface);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f1493a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Typeface f1494b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f1495c;

        b(TextView textView, Typeface typeface, int i10) {
            this.f1493a = textView;
            this.f1494b = typeface;
            this.f1495c = i10;
        }

        public void run() {
            this.f1493a.setTypeface(this.f1494b, this.f1495c);
        }
    }

    static class c {
        static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    static class d {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    static class e {
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void b(TextView textView, int i10, int i11, int i12, int i13) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        static void c(TextView textView, int[] iArr, int i10) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    static class f {
        static Typeface a(Typeface typeface, int i10, boolean z10) {
            return Typeface.create(typeface, i10, z10);
        }
    }

    x(@NonNull TextView textView) {
        this.f1476a = textView;
        this.f1484i = new e0(textView);
    }

    private void B(int i10, float f10) {
        this.f1484i.t(i10, f10);
    }

    private void C(Context context, h1 h1Var) {
        String o10;
        boolean z10;
        boolean z11;
        this.f1485j = h1Var.k(j.TextAppearance_android_textStyle, this.f1485j);
        int i10 = Build.VERSION.SDK_INT;
        boolean z12 = false;
        if (i10 >= 28) {
            int k10 = h1Var.k(j.TextAppearance_android_textFontWeight, -1);
            this.f1486k = k10;
            if (k10 != -1) {
                this.f1485j = (this.f1485j & 2) | 0;
            }
        }
        int i11 = j.TextAppearance_android_fontFamily;
        if (h1Var.s(i11) || h1Var.s(j.TextAppearance_fontFamily)) {
            this.f1487l = null;
            int i12 = j.TextAppearance_fontFamily;
            if (h1Var.s(i12)) {
                i11 = i12;
            }
            int i13 = this.f1486k;
            int i14 = this.f1485j;
            if (!context.isRestricted()) {
                try {
                    Typeface j10 = h1Var.j(i11, this.f1485j, new a(i13, i14, new WeakReference(this.f1476a)));
                    if (j10 != null) {
                        if (i10 < 28 || this.f1486k == -1) {
                            this.f1487l = j10;
                        } else {
                            Typeface create = Typeface.create(j10, 0);
                            int i15 = this.f1486k;
                            if ((this.f1485j & 2) != 0) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            this.f1487l = f.a(create, i15, z11);
                        }
                    }
                    if (this.f1487l == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f1488m = z10;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f1487l == null && (o10 = h1Var.o(i11)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f1486k == -1) {
                    this.f1487l = Typeface.create(o10, this.f1485j);
                    return;
                }
                Typeface create2 = Typeface.create(o10, 0);
                int i16 = this.f1486k;
                if ((this.f1485j & 2) != 0) {
                    z12 = true;
                }
                this.f1487l = f.a(create2, i16, z12);
                return;
            }
            return;
        }
        int i17 = j.TextAppearance_android_typeface;
        if (h1Var.s(i17)) {
            this.f1488m = false;
            int k11 = h1Var.k(i17, 1);
            if (k11 == 1) {
                this.f1487l = Typeface.SANS_SERIF;
            } else if (k11 == 2) {
                this.f1487l = Typeface.SERIF;
            } else if (k11 == 3) {
                this.f1487l = Typeface.MONOSPACE;
            }
        }
    }

    private void a(Drawable drawable, f1 f1Var) {
        if (drawable != null && f1Var != null) {
            h.i(drawable, f1Var, this.f1476a.getDrawableState());
        }
    }

    private static f1 d(Context context, h hVar, int i10) {
        ColorStateList f10 = hVar.f(context, i10);
        if (f10 == null) {
            return null;
        }
        f1 f1Var = new f1();
        f1Var.f1272d = true;
        f1Var.f1269a = f10;
        return f1Var;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] a10 = c.a(this.f1476a);
            TextView textView = this.f1476a;
            if (drawable5 == null) {
                drawable5 = a10[0];
            }
            if (drawable2 == null) {
                drawable2 = a10[1];
            }
            if (drawable6 == null) {
                drawable6 = a10[2];
            }
            if (drawable4 == null) {
                drawable4 = a10[3];
            }
            c.b(textView, drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            Drawable[] a11 = c.a(this.f1476a);
            Drawable drawable7 = a11[0];
            if (drawable7 == null && a11[2] == null) {
                Drawable[] compoundDrawables = this.f1476a.getCompoundDrawables();
                TextView textView2 = this.f1476a;
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                return;
            }
            TextView textView3 = this.f1476a;
            if (drawable2 == null) {
                drawable2 = a11[1];
            }
            Drawable drawable8 = a11[2];
            if (drawable4 == null) {
                drawable4 = a11[3];
            }
            c.b(textView3, drawable7, drawable2, drawable8, drawable4);
        }
    }

    private void z() {
        f1 f1Var = this.f1483h;
        this.f1477b = f1Var;
        this.f1478c = f1Var;
        this.f1479d = f1Var;
        this.f1480e = f1Var;
        this.f1481f = f1Var;
        this.f1482g = f1Var;
    }

    /* access modifiers changed from: package-private */
    public void A(int i10, float f10) {
        if (!t1.f1448b && !l()) {
            B(i10, f10);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!(this.f1477b == null && this.f1478c == null && this.f1479d == null && this.f1480e == null)) {
            Drawable[] compoundDrawables = this.f1476a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1477b);
            a(compoundDrawables[1], this.f1478c);
            a(compoundDrawables[2], this.f1479d);
            a(compoundDrawables[3], this.f1480e);
        }
        if (this.f1481f != null || this.f1482g != null) {
            Drawable[] a10 = c.a(this.f1476a);
            a(a10[0], this.f1481f);
            a(a10[2], this.f1482g);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f1484i.a();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f1484i.f();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f1484i.g();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f1484i.h();
    }

    /* access modifiers changed from: package-private */
    public int[] h() {
        return this.f1484i.i();
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f1484i.j();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList j() {
        f1 f1Var = this.f1483h;
        if (f1Var != null) {
            return f1Var.f1269a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        f1 f1Var = this.f1483h;
        if (f1Var != null) {
            return f1Var.f1270b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.f1484i.n();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01fb  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m(android.util.AttributeSet r20, int r21) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r9 = r21
            android.widget.TextView r0 = r7.f1476a
            android.content.Context r10 = r0.getContext()
            androidx.appcompat.widget.h r11 = androidx.appcompat.widget.h.b()
            int[] r2 = d.j.AppCompatTextHelper
            r12 = 0
            androidx.appcompat.widget.h1 r13 = androidx.appcompat.widget.h1.v(r10, r8, r2, r9, r12)
            android.widget.TextView r0 = r7.f1476a
            android.content.Context r1 = r0.getContext()
            android.content.res.TypedArray r4 = r13.r()
            r6 = 0
            r3 = r20
            r5 = r21
            androidx.core.view.n0.q0(r0, r1, r2, r3, r4, r5, r6)
            int r0 = d.j.AppCompatTextHelper_android_textAppearance
            r14 = -1
            int r0 = r13.n(r0, r14)
            int r1 = d.j.AppCompatTextHelper_android_drawableLeft
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0042
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.f1 r1 = d(r10, r11, r1)
            r7.f1477b = r1
        L_0x0042:
            int r1 = d.j.AppCompatTextHelper_android_drawableTop
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0054
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.f1 r1 = d(r10, r11, r1)
            r7.f1478c = r1
        L_0x0054:
            int r1 = d.j.AppCompatTextHelper_android_drawableRight
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0066
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.f1 r1 = d(r10, r11, r1)
            r7.f1479d = r1
        L_0x0066:
            int r1 = d.j.AppCompatTextHelper_android_drawableBottom
            boolean r2 = r13.s(r1)
            if (r2 == 0) goto L_0x0078
            int r1 = r13.n(r1, r12)
            androidx.appcompat.widget.f1 r1 = d(r10, r11, r1)
            r7.f1480e = r1
        L_0x0078:
            int r1 = android.os.Build.VERSION.SDK_INT
            int r2 = d.j.AppCompatTextHelper_android_drawableStart
            boolean r3 = r13.s(r2)
            if (r3 == 0) goto L_0x008c
            int r2 = r13.n(r2, r12)
            androidx.appcompat.widget.f1 r2 = d(r10, r11, r2)
            r7.f1481f = r2
        L_0x008c:
            int r2 = d.j.AppCompatTextHelper_android_drawableEnd
            boolean r3 = r13.s(r2)
            if (r3 == 0) goto L_0x009e
            int r2 = r13.n(r2, r12)
            androidx.appcompat.widget.f1 r2 = d(r10, r11, r2)
            r7.f1482g = r2
        L_0x009e:
            r13.w()
            android.widget.TextView r2 = r7.f1476a
            android.text.method.TransformationMethod r2 = r2.getTransformationMethod()
            boolean r2 = r2 instanceof android.text.method.PasswordTransformationMethod
            r3 = 26
            if (r0 == r14) goto L_0x00ea
            int[] r5 = d.j.TextAppearance
            androidx.appcompat.widget.h1 r0 = androidx.appcompat.widget.h1.t(r10, r0, r5)
            if (r2 != 0) goto L_0x00c3
            int r5 = d.j.TextAppearance_textAllCaps
            boolean r6 = r0.s(r5)
            if (r6 == 0) goto L_0x00c3
            boolean r5 = r0.a(r5, r12)
            r6 = 1
            goto L_0x00c5
        L_0x00c3:
            r5 = r12
            r6 = r5
        L_0x00c5:
            r7.C(r10, r0)
            int r15 = d.j.TextAppearance_textLocale
            boolean r16 = r0.s(r15)
            if (r16 == 0) goto L_0x00d5
            java.lang.String r15 = r0.o(r15)
            goto L_0x00d6
        L_0x00d5:
            r15 = 0
        L_0x00d6:
            if (r1 < r3) goto L_0x00e5
            int r4 = d.j.TextAppearance_fontVariationSettings
            boolean r17 = r0.s(r4)
            if (r17 == 0) goto L_0x00e5
            java.lang.String r4 = r0.o(r4)
            goto L_0x00e6
        L_0x00e5:
            r4 = 0
        L_0x00e6:
            r0.w()
            goto L_0x00ee
        L_0x00ea:
            r5 = r12
            r6 = r5
            r4 = 0
            r15 = 0
        L_0x00ee:
            int[] r0 = d.j.TextAppearance
            androidx.appcompat.widget.h1 r0 = androidx.appcompat.widget.h1.v(r10, r8, r0, r9, r12)
            if (r2 != 0) goto L_0x0105
            int r13 = d.j.TextAppearance_textAllCaps
            boolean r18 = r0.s(r13)
            if (r18 == 0) goto L_0x0105
            boolean r5 = r0.a(r13, r12)
            r16 = 1
            goto L_0x0107
        L_0x0105:
            r16 = r6
        L_0x0107:
            int r6 = d.j.TextAppearance_textLocale
            boolean r13 = r0.s(r6)
            if (r13 == 0) goto L_0x0113
            java.lang.String r15 = r0.o(r6)
        L_0x0113:
            if (r1 < r3) goto L_0x0121
            int r3 = d.j.TextAppearance_fontVariationSettings
            boolean r6 = r0.s(r3)
            if (r6 == 0) goto L_0x0121
            java.lang.String r4 = r0.o(r3)
        L_0x0121:
            r3 = 28
            if (r1 < r3) goto L_0x0139
            int r1 = d.j.TextAppearance_android_textSize
            boolean r3 = r0.s(r1)
            if (r3 == 0) goto L_0x0139
            int r1 = r0.f(r1, r14)
            if (r1 != 0) goto L_0x0139
            android.widget.TextView r1 = r7.f1476a
            r3 = 0
            r1.setTextSize(r12, r3)
        L_0x0139:
            r7.C(r10, r0)
            r0.w()
            if (r2 != 0) goto L_0x0146
            if (r16 == 0) goto L_0x0146
            r7.s(r5)
        L_0x0146:
            android.graphics.Typeface r0 = r7.f1487l
            if (r0 == 0) goto L_0x015b
            int r1 = r7.f1486k
            if (r1 != r14) goto L_0x0156
            android.widget.TextView r1 = r7.f1476a
            int r2 = r7.f1485j
            r1.setTypeface(r0, r2)
            goto L_0x015b
        L_0x0156:
            android.widget.TextView r1 = r7.f1476a
            r1.setTypeface(r0)
        L_0x015b:
            if (r4 == 0) goto L_0x0162
            android.widget.TextView r0 = r7.f1476a
            androidx.appcompat.widget.x.e.d(r0, r4)
        L_0x0162:
            if (r15 == 0) goto L_0x016d
            android.widget.TextView r0 = r7.f1476a
            android.os.LocaleList r1 = androidx.appcompat.widget.x.d.a(r15)
            androidx.appcompat.widget.x.d.b(r0, r1)
        L_0x016d:
            androidx.appcompat.widget.e0 r0 = r7.f1484i
            r0.o(r8, r9)
            boolean r0 = androidx.appcompat.widget.t1.f1448b
            if (r0 == 0) goto L_0x01b1
            androidx.appcompat.widget.e0 r0 = r7.f1484i
            int r0 = r0.j()
            if (r0 == 0) goto L_0x01b1
            androidx.appcompat.widget.e0 r0 = r7.f1484i
            int[] r0 = r0.i()
            int r1 = r0.length
            if (r1 <= 0) goto L_0x01b1
            android.widget.TextView r1 = r7.f1476a
            int r1 = androidx.appcompat.widget.x.e.a(r1)
            float r1 = (float) r1
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x01ac
            android.widget.TextView r0 = r7.f1476a
            androidx.appcompat.widget.e0 r1 = r7.f1484i
            int r1 = r1.g()
            androidx.appcompat.widget.e0 r2 = r7.f1484i
            int r2 = r2.f()
            androidx.appcompat.widget.e0 r3 = r7.f1484i
            int r3 = r3.h()
            androidx.appcompat.widget.x.e.b(r0, r1, r2, r3, r12)
            goto L_0x01b1
        L_0x01ac:
            android.widget.TextView r1 = r7.f1476a
            androidx.appcompat.widget.x.e.c(r1, r0, r12)
        L_0x01b1:
            int[] r0 = d.j.AppCompatTextView
            androidx.appcompat.widget.h1 r8 = androidx.appcompat.widget.h1.u(r10, r8, r0)
            int r0 = d.j.AppCompatTextView_drawableLeftCompat
            int r0 = r8.n(r0, r14)
            if (r0 == r14) goto L_0x01c5
            android.graphics.drawable.Drawable r0 = r11.c(r10, r0)
            r1 = r0
            goto L_0x01c6
        L_0x01c5:
            r1 = 0
        L_0x01c6:
            int r0 = d.j.AppCompatTextView_drawableTopCompat
            int r0 = r8.n(r0, r14)
            if (r0 == r14) goto L_0x01d4
            android.graphics.drawable.Drawable r0 = r11.c(r10, r0)
            r2 = r0
            goto L_0x01d5
        L_0x01d4:
            r2 = 0
        L_0x01d5:
            int r0 = d.j.AppCompatTextView_drawableRightCompat
            int r0 = r8.n(r0, r14)
            if (r0 == r14) goto L_0x01e3
            android.graphics.drawable.Drawable r0 = r11.c(r10, r0)
            r3 = r0
            goto L_0x01e4
        L_0x01e3:
            r3 = 0
        L_0x01e4:
            int r0 = d.j.AppCompatTextView_drawableBottomCompat
            int r0 = r8.n(r0, r14)
            if (r0 == r14) goto L_0x01f2
            android.graphics.drawable.Drawable r0 = r11.c(r10, r0)
            r4 = r0
            goto L_0x01f3
        L_0x01f2:
            r4 = 0
        L_0x01f3:
            int r0 = d.j.AppCompatTextView_drawableStartCompat
            int r0 = r8.n(r0, r14)
            if (r0 == r14) goto L_0x0201
            android.graphics.drawable.Drawable r0 = r11.c(r10, r0)
            r5 = r0
            goto L_0x0202
        L_0x0201:
            r5 = 0
        L_0x0202:
            int r0 = d.j.AppCompatTextView_drawableEndCompat
            int r0 = r8.n(r0, r14)
            if (r0 == r14) goto L_0x0210
            android.graphics.drawable.Drawable r0 = r11.c(r10, r0)
            r6 = r0
            goto L_0x0211
        L_0x0210:
            r6 = 0
        L_0x0211:
            r0 = r19
            r0.y(r1, r2, r3, r4, r5, r6)
            int r0 = d.j.AppCompatTextView_drawableTint
            boolean r1 = r8.s(r0)
            if (r1 == 0) goto L_0x0227
            android.content.res.ColorStateList r0 = r8.c(r0)
            android.widget.TextView r1 = r7.f1476a
            androidx.core.widget.l.l(r1, r0)
        L_0x0227:
            int r0 = d.j.AppCompatTextView_drawableTintMode
            boolean r1 = r8.s(r0)
            if (r1 == 0) goto L_0x023d
            int r0 = r8.k(r0, r14)
            r1 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.k0.e(r0, r1)
            android.widget.TextView r1 = r7.f1476a
            androidx.core.widget.l.m(r1, r0)
        L_0x023d:
            int r0 = d.j.AppCompatTextView_firstBaselineToTopHeight
            int r0 = r8.f(r0, r14)
            int r1 = d.j.AppCompatTextView_lastBaselineToBottomHeight
            int r1 = r8.f(r1, r14)
            int r2 = d.j.AppCompatTextView_lineHeight
            int r2 = r8.f(r2, r14)
            r8.w()
            if (r0 == r14) goto L_0x0259
            android.widget.TextView r3 = r7.f1476a
            androidx.core.widget.l.o(r3, r0)
        L_0x0259:
            if (r1 == r14) goto L_0x0260
            android.widget.TextView r0 = r7.f1476a
            androidx.core.widget.l.p(r0, r1)
        L_0x0260:
            if (r2 == r14) goto L_0x0267
            android.widget.TextView r0 = r7.f1476a
            androidx.core.widget.l.q(r0, r2)
        L_0x0267:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.x.m(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f1488m) {
            this.f1487l = typeface;
            TextView textView = weakReference.get();
            if (textView == null) {
                return;
            }
            if (n0.V(textView)) {
                textView.post(new b(textView, typeface, this.f1485j));
            } else {
                textView.setTypeface(typeface, this.f1485j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o(boolean z10, int i10, int i11, int i12, int i13) {
        if (!t1.f1448b) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* access modifiers changed from: package-private */
    public void q(Context context, int i10) {
        String o10;
        h1 t10 = h1.t(context, i10, j.TextAppearance);
        int i11 = j.TextAppearance_textAllCaps;
        if (t10.s(i11)) {
            s(t10.a(i11, false));
        }
        int i12 = Build.VERSION.SDK_INT;
        int i13 = j.TextAppearance_android_textSize;
        if (t10.s(i13) && t10.f(i13, -1) == 0) {
            this.f1476a.setTextSize(0, 0.0f);
        }
        C(context, t10);
        if (i12 >= 26) {
            int i14 = j.TextAppearance_fontVariationSettings;
            if (t10.s(i14) && (o10 = t10.o(i14)) != null) {
                e.d(this.f1476a, o10);
            }
        }
        t10.w();
        Typeface typeface = this.f1487l;
        if (typeface != null) {
            this.f1476a.setTypeface(typeface, this.f1485j);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(@NonNull TextView textView, InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            w0.b.e(editorInfo, textView.getText());
        }
    }

    /* access modifiers changed from: package-private */
    public void s(boolean z10) {
        this.f1476a.setAllCaps(z10);
    }

    /* access modifiers changed from: package-private */
    public void t(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        this.f1484i.p(i10, i11, i12, i13);
    }

    /* access modifiers changed from: package-private */
    public void u(@NonNull int[] iArr, int i10) throws IllegalArgumentException {
        this.f1484i.q(iArr, i10);
    }

    /* access modifiers changed from: package-private */
    public void v(int i10) {
        this.f1484i.r(i10);
    }

    /* access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        boolean z10;
        if (this.f1483h == null) {
            this.f1483h = new f1();
        }
        f1 f1Var = this.f1483h;
        f1Var.f1269a = colorStateList;
        if (colorStateList != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        f1Var.f1272d = z10;
        z();
    }

    /* access modifiers changed from: package-private */
    public void x(PorterDuff.Mode mode) {
        boolean z10;
        if (this.f1483h == null) {
            this.f1483h = new f1();
        }
        f1 f1Var = this.f1483h;
        f1Var.f1270b = mode;
        if (mode != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        f1Var.f1271c = z10;
        z();
    }
}
