package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import l0.b;
import l0.c;
import l0.d;

public class CardView extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f3540h = {16842801};

    /* renamed from: j  reason: collision with root package name */
    private static final c f3541j;

    /* renamed from: a  reason: collision with root package name */
    private boolean f3542a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3543b;

    /* renamed from: c  reason: collision with root package name */
    int f3544c;

    /* renamed from: d  reason: collision with root package name */
    int f3545d;

    /* renamed from: e  reason: collision with root package name */
    final Rect f3546e;

    /* renamed from: f  reason: collision with root package name */
    final Rect f3547f;

    /* renamed from: g  reason: collision with root package name */
    private final b f3548g;

    class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private Drawable f3549a;

        a() {
        }

        public void a(int i10, int i11, int i12, int i13) {
            CardView.this.f3547f.set(i10, i11, i12, i13);
            CardView cardView = CardView.this;
            Rect rect = cardView.f3546e;
            CardView.super.setPadding(i10 + rect.left, i11 + rect.top, i12 + rect.right, i13 + rect.bottom);
        }

        public void b(Drawable drawable) {
            this.f3549a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        public boolean c() {
            return CardView.this.getUseCompatPadding();
        }

        public Drawable d() {
            return this.f3549a;
        }

        public boolean e() {
            return CardView.this.getPreventCornerOverlap();
        }

        public View f() {
            return CardView.this;
        }
    }

    static {
        a aVar = new a();
        f3541j = aVar;
        aVar.l();
    }

    public CardView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public void d(int i10, int i11, int i12, int i13) {
        this.f3546e.set(i10, i11, i12, i13);
        f3541j.k(this.f3548g);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return f3541j.e(this.f3548g);
    }

    public float getCardElevation() {
        return f3541j.i(this.f3548g);
    }

    public int getContentPaddingBottom() {
        return this.f3546e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f3546e.left;
    }

    public int getContentPaddingRight() {
        return this.f3546e.right;
    }

    public int getContentPaddingTop() {
        return this.f3546e.top;
    }

    public float getMaxCardElevation() {
        return f3541j.d(this.f3548g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f3543b;
    }

    public float getRadius() {
        return f3541j.b(this.f3548g);
    }

    public boolean getUseCompatPadding() {
        return this.f3542a;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        c cVar = f3541j;
        if (!(cVar instanceof a)) {
            int mode = View.MeasureSpec.getMode(i10);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) cVar.m(this.f3548g)), View.MeasureSpec.getSize(i10)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i11);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) cVar.f(this.f3548g)), View.MeasureSpec.getSize(i11)), mode2);
            }
            super.onMeasure(i10, i11);
            return;
        }
        super.onMeasure(i10, i11);
    }

    public void setCardBackgroundColor(int i10) {
        f3541j.n(this.f3548g, ColorStateList.valueOf(i10));
    }

    public void setCardElevation(float f10) {
        f3541j.c(this.f3548g, f10);
    }

    public void setMaxCardElevation(float f10) {
        f3541j.o(this.f3548g, f10);
    }

    public void setMinimumHeight(int i10) {
        this.f3545d = i10;
        super.setMinimumHeight(i10);
    }

    public void setMinimumWidth(int i10) {
        this.f3544c = i10;
        super.setMinimumWidth(i10);
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
    }

    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.f3543b) {
            this.f3543b = z10;
            f3541j.g(this.f3548g);
        }
    }

    public void setRadius(float f10) {
        f3541j.a(this.f3548g, f10);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f3542a != z10) {
            this.f3542a = z10;
            f3541j.j(this.f3548g);
        }
    }

    public CardView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, l0.a.cardViewStyle);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f3541j.n(this.f3548g, colorStateList);
    }

    public CardView(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int i11;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f3546e = rect;
        this.f3547f = new Rect();
        a aVar = new a();
        this.f3548g = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.CardView, i10, c.CardView);
        int i12 = d.CardView_cardBackgroundColor;
        if (obtainStyledAttributes.hasValue(i12)) {
            valueOf = obtainStyledAttributes.getColorStateList(i12);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f3540h);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i11 = getResources().getColor(b.cardview_light_background);
            } else {
                i11 = getResources().getColor(b.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(i11);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(d.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(d.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(d.CardView_cardMaxElevation, 0.0f);
        this.f3542a = obtainStyledAttributes.getBoolean(d.CardView_cardUseCompatPadding, false);
        this.f3543b = obtainStyledAttributes.getBoolean(d.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPadding, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(d.CardView_contentPaddingBottom, dimensionPixelSize);
        float f10 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f3544c = obtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minWidth, 0);
        this.f3545d = obtainStyledAttributes.getDimensionPixelSize(d.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f3541j.h(aVar, context, colorStateList, dimension, dimension2, f10);
    }
}
