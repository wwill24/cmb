package qf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.core.content.res.h;
import bf.l;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f24413a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f24414b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f24415c;

    /* renamed from: d  reason: collision with root package name */
    public final String f24416d;

    /* renamed from: e  reason: collision with root package name */
    public final int f24417e;

    /* renamed from: f  reason: collision with root package name */
    public final int f24418f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f24419g;

    /* renamed from: h  reason: collision with root package name */
    public final float f24420h;

    /* renamed from: i  reason: collision with root package name */
    public final float f24421i;

    /* renamed from: j  reason: collision with root package name */
    public final float f24422j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f24423k;

    /* renamed from: l  reason: collision with root package name */
    public final float f24424l;

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f24425m;

    /* renamed from: n  reason: collision with root package name */
    private float f24426n;

    /* renamed from: o  reason: collision with root package name */
    private final int f24427o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f24428p = false;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public Typeface f24429q;

    class a extends h.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f24430a;

        a(f fVar) {
            this.f24430a = fVar;
        }

        public void h(int i10) {
            boolean unused = d.this.f24428p = true;
            this.f24430a.a(i10);
        }

        public void i(@NonNull Typeface typeface) {
            d dVar = d.this;
            Typeface unused = dVar.f24429q = Typeface.create(typeface, dVar.f24417e);
            boolean unused2 = d.this.f24428p = true;
            this.f24430a.b(d.this.f24429q, false);
        }
    }

    class b extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f24432a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextPaint f24433b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f24434c;

        b(Context context, TextPaint textPaint, f fVar) {
            this.f24432a = context;
            this.f24433b = textPaint;
            this.f24434c = fVar;
        }

        public void a(int i10) {
            this.f24434c.a(i10);
        }

        public void b(@NonNull Typeface typeface, boolean z10) {
            d.this.p(this.f24432a, this.f24433b, typeface);
            this.f24434c.b(typeface, z10);
        }
    }

    public d(@NonNull Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, l.TextAppearance);
        l(obtainStyledAttributes.getDimension(l.TextAppearance_android_textSize, 0.0f));
        k(c.a(context, obtainStyledAttributes, l.TextAppearance_android_textColor));
        this.f24413a = c.a(context, obtainStyledAttributes, l.TextAppearance_android_textColorHint);
        this.f24414b = c.a(context, obtainStyledAttributes, l.TextAppearance_android_textColorLink);
        this.f24417e = obtainStyledAttributes.getInt(l.TextAppearance_android_textStyle, 0);
        this.f24418f = obtainStyledAttributes.getInt(l.TextAppearance_android_typeface, 1);
        int e10 = c.e(obtainStyledAttributes, l.TextAppearance_fontFamily, l.TextAppearance_android_fontFamily);
        this.f24427o = obtainStyledAttributes.getResourceId(e10, 0);
        this.f24416d = obtainStyledAttributes.getString(e10);
        this.f24419g = obtainStyledAttributes.getBoolean(l.TextAppearance_textAllCaps, false);
        this.f24415c = c.a(context, obtainStyledAttributes, l.TextAppearance_android_shadowColor);
        this.f24420h = obtainStyledAttributes.getFloat(l.TextAppearance_android_shadowDx, 0.0f);
        this.f24421i = obtainStyledAttributes.getFloat(l.TextAppearance_android_shadowDy, 0.0f);
        this.f24422j = obtainStyledAttributes.getFloat(l.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i10, l.MaterialTextAppearance);
        int i11 = l.MaterialTextAppearance_android_letterSpacing;
        this.f24423k = obtainStyledAttributes2.hasValue(i11);
        this.f24424l = obtainStyledAttributes2.getFloat(i11, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f24429q == null && (str = this.f24416d) != null) {
            this.f24429q = Typeface.create(str, this.f24417e);
        }
        if (this.f24429q == null) {
            int i10 = this.f24418f;
            if (i10 == 1) {
                this.f24429q = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                this.f24429q = Typeface.SERIF;
            } else if (i10 != 3) {
                this.f24429q = Typeface.DEFAULT;
            } else {
                this.f24429q = Typeface.MONOSPACE;
            }
            this.f24429q = Typeface.create(this.f24429q, this.f24417e);
        }
    }

    private boolean m(Context context) {
        Typeface typeface;
        if (e.a()) {
            return true;
        }
        int i10 = this.f24427o;
        if (i10 != 0) {
            typeface = h.c(context, i10);
        } else {
            typeface = null;
        }
        if (typeface != null) {
            return true;
        }
        return false;
    }

    public Typeface e() {
        d();
        return this.f24429q;
    }

    @NonNull
    public Typeface f(@NonNull Context context) {
        if (this.f24428p) {
            return this.f24429q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface h10 = h.h(context, this.f24427o);
                this.f24429q = h10;
                if (h10 != null) {
                    this.f24429q = Typeface.create(h10, this.f24417e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception unused2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error loading font ");
                sb2.append(this.f24416d);
            }
        }
        d();
        this.f24428p = true;
        return this.f24429q;
    }

    public void g(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, fVar));
    }

    public void h(@NonNull Context context, @NonNull f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i10 = this.f24427o;
        if (i10 == 0) {
            this.f24428p = true;
        }
        if (this.f24428p) {
            fVar.b(this.f24429q, true);
            return;
        }
        try {
            h.j(context, i10, new a(fVar), (Handler) null);
        } catch (Resources.NotFoundException unused) {
            this.f24428p = true;
            fVar.a(1);
        } catch (Exception unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error loading font ");
            sb2.append(this.f24416d);
            this.f24428p = true;
            fVar.a(-3);
        }
    }

    public ColorStateList i() {
        return this.f24425m;
    }

    public float j() {
        return this.f24426n;
    }

    public void k(ColorStateList colorStateList) {
        this.f24425m = colorStateList;
    }

    public void l(float f10) {
        this.f24426n = f10;
    }

    public void n(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        int i10;
        int i11;
        o(context, textPaint, fVar);
        ColorStateList colorStateList = this.f24425m;
        if (colorStateList != null) {
            i10 = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            i10 = -16777216;
        }
        textPaint.setColor(i10);
        float f10 = this.f24422j;
        float f11 = this.f24420h;
        float f12 = this.f24421i;
        ColorStateList colorStateList2 = this.f24415c;
        if (colorStateList2 != null) {
            i11 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            i11 = 0;
        }
        textPaint.setShadowLayer(f10, f11, f12, i11);
    }

    public void o(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void p(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        boolean z10;
        float f10;
        Typeface a10 = h.a(context, typeface);
        if (a10 != null) {
            typeface = a10;
        }
        textPaint.setTypeface(typeface);
        int i10 = this.f24417e & (~typeface.getStyle());
        if ((i10 & 1) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        textPaint.setFakeBoldText(z10);
        if ((i10 & 2) != 0) {
            f10 = -0.25f;
        } else {
            f10 = 0.0f;
        }
        textPaint.setTextSkewX(f10);
        textPaint.setTextSize(this.f24426n);
        if (this.f24423k) {
            textPaint.setLetterSpacing(this.f24424l);
        }
    }
}
