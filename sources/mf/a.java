package mf;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import bf.k;
import tf.g;
import tf.l;
import tf.n;

public class a extends AppCompatImageView implements n {

    /* renamed from: y  reason: collision with root package name */
    private static final int f23636y = k.Widget_MaterialComponents_ShapeableImageView;

    /* renamed from: a  reason: collision with root package name */
    private final l f23637a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final RectF f23638b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f23639c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f23640d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f23641e;

    /* renamed from: f  reason: collision with root package name */
    private final Path f23642f;

    /* renamed from: g  reason: collision with root package name */
    private ColorStateList f23643g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public g f23644h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public tf.k f23645j;

    /* renamed from: k  reason: collision with root package name */
    private float f23646k;

    /* renamed from: l  reason: collision with root package name */
    private Path f23647l;

    /* renamed from: m  reason: collision with root package name */
    private int f23648m;

    /* renamed from: n  reason: collision with root package name */
    private int f23649n;

    /* renamed from: p  reason: collision with root package name */
    private int f23650p;

    /* renamed from: q  reason: collision with root package name */
    private int f23651q;

    /* renamed from: t  reason: collision with root package name */
    private int f23652t;

    /* renamed from: w  reason: collision with root package name */
    private int f23653w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f23654x;

    @TargetApi(21)
    /* renamed from: mf.a$a  reason: collision with other inner class name */
    class C0283a extends ViewOutlineProvider {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f23655a = new Rect();

        C0283a() {
        }

        public void getOutline(View view, Outline outline) {
            if (a.this.f23645j != null) {
                if (a.this.f23644h == null) {
                    g unused = a.this.f23644h = new g(a.this.f23645j);
                }
                a.this.f23638b.round(this.f23655a);
                a.this.f23644h.setBounds(this.f23655a);
                a.this.f23644h.getOutline(outline);
            }
        }
    }

    public a(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private void g(Canvas canvas) {
        if (this.f23643g != null) {
            this.f23640d.setStrokeWidth(this.f23646k);
            int colorForState = this.f23643g.getColorForState(getDrawableState(), this.f23643g.getDefaultColor());
            if (this.f23646k > 0.0f && colorForState != 0) {
                this.f23640d.setColor(colorForState);
                canvas.drawPath(this.f23642f, this.f23640d);
            }
        }
    }

    private boolean h() {
        return (this.f23652t == Integer.MIN_VALUE && this.f23653w == Integer.MIN_VALUE) ? false : true;
    }

    private boolean i() {
        return getLayoutDirection() == 1;
    }

    private void j(int i10, int i11) {
        this.f23638b.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (i10 - getPaddingRight()), (float) (i11 - getPaddingBottom()));
        this.f23637a.d(this.f23645j, 1.0f, this.f23638b, this.f23642f);
        this.f23647l.rewind();
        this.f23647l.addPath(this.f23642f);
        this.f23639c.set(0.0f, 0.0f, (float) i10, (float) i11);
        this.f23647l.addRect(this.f23639c, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.f23651q;
    }

    public final int getContentPaddingEnd() {
        int i10 = this.f23653w;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (i()) {
            return this.f23648m;
        }
        return this.f23650p;
    }

    public int getContentPaddingLeft() {
        int i10;
        int i11;
        if (h()) {
            if (i() && (i11 = this.f23653w) != Integer.MIN_VALUE) {
                return i11;
            }
            if (!i() && (i10 = this.f23652t) != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.f23648m;
    }

    public int getContentPaddingRight() {
        int i10;
        int i11;
        if (h()) {
            if (i() && (i11 = this.f23652t) != Integer.MIN_VALUE) {
                return i11;
            }
            if (!i() && (i10 = this.f23653w) != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.f23650p;
    }

    public final int getContentPaddingStart() {
        int i10 = this.f23652t;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (i()) {
            return this.f23650p;
        }
        return this.f23648m;
    }

    public int getContentPaddingTop() {
        return this.f23649n;
    }

    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @NonNull
    public tf.k getShapeAppearanceModel() {
        return this.f23645j;
    }

    public ColorStateList getStrokeColor() {
        return this.f23643g;
    }

    public float getStrokeWidth() {
        return this.f23646k;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f23647l, this.f23641e);
        g(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (!this.f23654x && isLayoutDirectionResolved()) {
            this.f23654x = true;
            if (isPaddingRelative() || h()) {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            } else {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        j(i10, i11);
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10 + getContentPaddingLeft(), i11 + getContentPaddingTop(), i12 + getContentPaddingRight(), i13 + getContentPaddingBottom());
    }

    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10 + getContentPaddingStart(), i11 + getContentPaddingTop(), i12 + getContentPaddingEnd(), i13 + getContentPaddingBottom());
    }

    public void setShapeAppearanceModel(@NonNull tf.k kVar) {
        this.f23645j = kVar;
        g gVar = this.f23644h;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
        j(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f23643g = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i10) {
        setStrokeColor(e.a.a(getContext(), i10));
    }

    public void setStrokeWidth(float f10) {
        if (this.f23646k != f10) {
            this.f23646k = f10;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i10) {
        setStrokeWidth((float) getResources().getDimensionPixelSize(i10));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r0 = f23636y
            android.content.Context r7 = wf.a.c(r7, r8, r9, r0)
            r6.<init>(r7, r8, r9)
            tf.l r7 = tf.l.k()
            r6.f23637a = r7
            android.graphics.Path r7 = new android.graphics.Path
            r7.<init>()
            r6.f23642f = r7
            r7 = 0
            r6.f23654x = r7
            android.content.Context r1 = r6.getContext()
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r6.f23641e = r2
            r3 = 1
            r2.setAntiAlias(r3)
            r4 = -1
            r2.setColor(r4)
            android.graphics.PorterDuffXfermode r4 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.DST_OUT
            r4.<init>(r5)
            r2.setXfermode(r4)
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.f23638b = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.f23639c = r2
            android.graphics.Path r2 = new android.graphics.Path
            r2.<init>()
            r6.f23647l = r2
            int[] r2 = bf.l.ShapeableImageView
            android.content.res.TypedArray r2 = r1.obtainStyledAttributes(r8, r2, r9, r0)
            r4 = 2
            r5 = 0
            r6.setLayerType(r4, r5)
            int r4 = bf.l.ShapeableImageView_strokeColor
            android.content.res.ColorStateList r4 = qf.c.a(r1, r2, r4)
            r6.f23643g = r4
            int r4 = bf.l.ShapeableImageView_strokeWidth
            int r4 = r2.getDimensionPixelSize(r4, r7)
            float r4 = (float) r4
            r6.f23646k = r4
            int r4 = bf.l.ShapeableImageView_contentPadding
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.f23648m = r7
            r6.f23649n = r7
            r6.f23650p = r7
            r6.f23651q = r7
            int r4 = bf.l.ShapeableImageView_contentPaddingLeft
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f23648m = r4
            int r4 = bf.l.ShapeableImageView_contentPaddingTop
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f23649n = r4
            int r4 = bf.l.ShapeableImageView_contentPaddingRight
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f23650p = r4
            int r4 = bf.l.ShapeableImageView_contentPaddingBottom
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.f23651q = r7
            int r7 = bf.l.ShapeableImageView_contentPaddingStart
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.f23652t = r7
            int r7 = bf.l.ShapeableImageView_contentPaddingEnd
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.f23653w = r7
            r2.recycle()
            android.graphics.Paint r7 = new android.graphics.Paint
            r7.<init>()
            r6.f23640d = r7
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE
            r7.setStyle(r2)
            r7.setAntiAlias(r3)
            tf.k$b r7 = tf.k.e(r1, r8, r9, r0)
            tf.k r7 = r7.m()
            r6.f23645j = r7
            mf.a$a r7 = new mf.a$a
            r7.<init>()
            r6.setOutlineProvider(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mf.a.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
