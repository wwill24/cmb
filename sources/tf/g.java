package tf;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import java.util.BitSet;
import tf.k;
import tf.l;
import tf.m;

public class g extends Drawable implements n {
    private static final String E = g.class.getSimpleName();
    private static final Paint F;
    private int B;
    @NonNull
    private final RectF C;
    private boolean D;

    /* renamed from: a  reason: collision with root package name */
    private c f24499a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final m.g[] f24500b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final m.g[] f24501c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final BitSet f24502d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f24503e;

    /* renamed from: f  reason: collision with root package name */
    private final Matrix f24504f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f24505g;

    /* renamed from: h  reason: collision with root package name */
    private final Path f24506h;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f24507j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f24508k;

    /* renamed from: l  reason: collision with root package name */
    private final Region f24509l;

    /* renamed from: m  reason: collision with root package name */
    private final Region f24510m;

    /* renamed from: n  reason: collision with root package name */
    private k f24511n;

    /* renamed from: p  reason: collision with root package name */
    private final Paint f24512p;

    /* renamed from: q  reason: collision with root package name */
    private final Paint f24513q;

    /* renamed from: t  reason: collision with root package name */
    private final sf.a f24514t;
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    private final l.b f24515w;

    /* renamed from: x  reason: collision with root package name */
    private final l f24516x;

    /* renamed from: y  reason: collision with root package name */
    private PorterDuffColorFilter f24517y;

    /* renamed from: z  reason: collision with root package name */
    private PorterDuffColorFilter f24518z;

    class a implements l.b {
        a() {
        }

        public void a(@NonNull m mVar, Matrix matrix, int i10) {
            g.this.f24502d.set(i10, mVar.e());
            g.this.f24500b[i10] = mVar.f(matrix);
        }

        public void b(@NonNull m mVar, Matrix matrix, int i10) {
            g.this.f24502d.set(i10 + 4, mVar.e());
            g.this.f24501c[i10] = mVar.f(matrix);
        }
    }

    class b implements k.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f24520a;

        b(float f10) {
            this.f24520a = f10;
        }

        @NonNull
        public c a(@NonNull c cVar) {
            if (cVar instanceof i) {
                return cVar;
            }
            return new b(this.f24520a, cVar);
        }
    }

    static {
        Paint paint = new Paint(1);
        F = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    private float G() {
        if (P()) {
            return this.f24513q.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean N() {
        c cVar = this.f24499a;
        int i10 = cVar.f24538q;
        if (i10 == 1 || cVar.f24539r <= 0 || (i10 != 2 && !X())) {
            return false;
        }
        return true;
    }

    private boolean O() {
        Paint.Style style = this.f24499a.f24543v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean P() {
        Paint.Style style = this.f24499a.f24543v;
        if ((style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f24513q.getStrokeWidth() > 0.0f) {
            return true;
        }
        return false;
    }

    private void R() {
        super.invalidateSelf();
    }

    private void U(@NonNull Canvas canvas) {
        if (N()) {
            canvas.save();
            W(canvas);
            if (!this.D) {
                n(canvas);
                canvas.restore();
                return;
            }
            int width = (int) (this.C.width() - ((float) getBounds().width()));
            int height = (int) (this.C.height() - ((float) getBounds().height()));
            if (width < 0 || height < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.C.width()) + (this.f24499a.f24539r * 2) + width, ((int) this.C.height()) + (this.f24499a.f24539r * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f10 = (float) ((getBounds().left - this.f24499a.f24539r) - width);
            float f11 = (float) ((getBounds().top - this.f24499a.f24539r) - height);
            canvas2.translate(-f10, -f11);
            n(canvas2);
            canvas.drawBitmap(createBitmap, f10, f11, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
        }
    }

    private static int V(int i10, int i11) {
        return (i10 * (i11 + (i11 >>> 7))) >>> 8;
    }

    private void W(@NonNull Canvas canvas) {
        canvas.translate((float) B(), (float) C());
    }

    private PorterDuffColorFilter f(@NonNull Paint paint, boolean z10) {
        if (!z10) {
            return null;
        }
        int color = paint.getColor();
        int l10 = l(color);
        this.B = l10;
        if (l10 != color) {
            return new PorterDuffColorFilter(l10, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private void g(@NonNull RectF rectF, @NonNull Path path) {
        h(rectF, path);
        if (this.f24499a.f24531j != 1.0f) {
            this.f24504f.reset();
            Matrix matrix = this.f24504f;
            float f10 = this.f24499a.f24531j;
            matrix.setScale(f10, f10, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f24504f);
        }
        path.computeBounds(this.C, true);
    }

    private void i() {
        k y10 = E().y(new b(-G()));
        this.f24511n = y10;
        this.f24516x.d(y10, this.f24499a.f24532k, v(), this.f24506h);
    }

    @NonNull
    private PorterDuffColorFilter j(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z10) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z10) {
            colorForState = l(colorForState);
        }
        this.B = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    @NonNull
    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, @NonNull Paint paint, boolean z10) {
        if (colorStateList == null || mode == null) {
            return f(paint, z10);
        }
        return j(colorStateList, mode, z10);
    }

    private boolean l0(int[] iArr) {
        boolean z10;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f24499a.f24525d == null || (color2 = this.f24512p.getColor()) == (colorForState2 = this.f24499a.f24525d.getColorForState(iArr, color2))) {
            z10 = false;
        } else {
            this.f24512p.setColor(colorForState2);
            z10 = true;
        }
        if (this.f24499a.f24526e == null || (color = this.f24513q.getColor()) == (colorForState = this.f24499a.f24526e.getColorForState(iArr, color))) {
            return z10;
        }
        this.f24513q.setColor(colorForState);
        return true;
    }

    @NonNull
    public static g m(Context context, float f10) {
        int c10 = hf.a.c(context, bf.b.colorSurface, g.class.getSimpleName());
        g gVar = new g();
        gVar.Q(context);
        gVar.b0(ColorStateList.valueOf(c10));
        gVar.a0(f10);
        return gVar;
    }

    private boolean m0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f24517y;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f24518z;
        c cVar = this.f24499a;
        this.f24517y = k(cVar.f24528g, cVar.f24529h, this.f24512p, true);
        c cVar2 = this.f24499a;
        this.f24518z = k(cVar2.f24527f, cVar2.f24529h, this.f24513q, false);
        c cVar3 = this.f24499a;
        if (cVar3.f24542u) {
            this.f24514t.d(cVar3.f24528g.getColorForState(getState(), 0));
        }
        if (!androidx.core.util.c.a(porterDuffColorFilter, this.f24517y) || !androidx.core.util.c.a(porterDuffColorFilter2, this.f24518z)) {
            return true;
        }
        return false;
    }

    private void n(@NonNull Canvas canvas) {
        this.f24502d.cardinality();
        if (this.f24499a.f24540s != 0) {
            canvas.drawPath(this.f24505g, this.f24514t.c());
        }
        for (int i10 = 0; i10 < 4; i10++) {
            this.f24500b[i10].b(this.f24514t, this.f24499a.f24539r, canvas);
            this.f24501c[i10].b(this.f24514t, this.f24499a.f24539r, canvas);
        }
        if (this.D) {
            int B2 = B();
            int C2 = C();
            canvas.translate((float) (-B2), (float) (-C2));
            canvas.drawPath(this.f24505g, F);
            canvas.translate((float) B2, (float) C2);
        }
    }

    private void n0() {
        float M = M();
        this.f24499a.f24539r = (int) Math.ceil((double) (0.75f * M));
        this.f24499a.f24540s = (int) Math.ceil((double) (M * 0.25f));
        m0();
        R();
    }

    private void o(@NonNull Canvas canvas) {
        q(canvas, this.f24512p, this.f24505g, this.f24499a.f24522a, u());
    }

    private void q(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull k kVar, @NonNull RectF rectF) {
        if (kVar.u(rectF)) {
            float a10 = kVar.t().a(rectF) * this.f24499a.f24532k;
            canvas.drawRoundRect(rectF, a10, a10, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    @NonNull
    private RectF v() {
        this.f24508k.set(u());
        float G = G();
        this.f24508k.inset(G, G);
        return this.f24508k;
    }

    public int A() {
        return this.B;
    }

    public int B() {
        c cVar = this.f24499a;
        return (int) (((double) cVar.f24540s) * Math.sin(Math.toRadians((double) cVar.f24541t)));
    }

    public int C() {
        c cVar = this.f24499a;
        return (int) (((double) cVar.f24540s) * Math.cos(Math.toRadians((double) cVar.f24541t)));
    }

    public int D() {
        return this.f24499a.f24539r;
    }

    @NonNull
    public k E() {
        return this.f24499a.f24522a;
    }

    public ColorStateList F() {
        return this.f24499a.f24526e;
    }

    public float H() {
        return this.f24499a.f24533l;
    }

    public ColorStateList I() {
        return this.f24499a.f24528g;
    }

    public float J() {
        return this.f24499a.f24522a.r().a(u());
    }

    public float K() {
        return this.f24499a.f24522a.t().a(u());
    }

    public float L() {
        return this.f24499a.f24537p;
    }

    public float M() {
        return w() + L();
    }

    public void Q(Context context) {
        this.f24499a.f24523b = new kf.a(context);
        n0();
    }

    public boolean S() {
        kf.a aVar = this.f24499a.f24523b;
        if (aVar == null || !aVar.e()) {
            return false;
        }
        return true;
    }

    public boolean T() {
        return this.f24499a.f24522a.u(u());
    }

    public boolean X() {
        int i10 = Build.VERSION.SDK_INT;
        if (T() || this.f24505g.isConvex() || i10 >= 29) {
            return false;
        }
        return true;
    }

    public void Y(float f10) {
        setShapeAppearanceModel(this.f24499a.f24522a.w(f10));
    }

    public void Z(@NonNull c cVar) {
        setShapeAppearanceModel(this.f24499a.f24522a.x(cVar));
    }

    public void a0(float f10) {
        c cVar = this.f24499a;
        if (cVar.f24536o != f10) {
            cVar.f24536o = f10;
            n0();
        }
    }

    public void b0(ColorStateList colorStateList) {
        c cVar = this.f24499a;
        if (cVar.f24525d != colorStateList) {
            cVar.f24525d = colorStateList;
            onStateChange(getState());
        }
    }

    public void c0(float f10) {
        c cVar = this.f24499a;
        if (cVar.f24532k != f10) {
            cVar.f24532k = f10;
            this.f24503e = true;
            invalidateSelf();
        }
    }

    public void d0(int i10, int i11, int i12, int i13) {
        c cVar = this.f24499a;
        if (cVar.f24530i == null) {
            cVar.f24530i = new Rect();
        }
        this.f24499a.f24530i.set(i10, i11, i12, i13);
        invalidateSelf();
    }

    public void draw(@NonNull Canvas canvas) {
        this.f24512p.setColorFilter(this.f24517y);
        int alpha = this.f24512p.getAlpha();
        this.f24512p.setAlpha(V(alpha, this.f24499a.f24534m));
        this.f24513q.setColorFilter(this.f24518z);
        this.f24513q.setStrokeWidth(this.f24499a.f24533l);
        int alpha2 = this.f24513q.getAlpha();
        this.f24513q.setAlpha(V(alpha2, this.f24499a.f24534m));
        if (this.f24503e) {
            i();
            g(u(), this.f24505g);
            this.f24503e = false;
        }
        U(canvas);
        if (O()) {
            o(canvas);
        }
        if (P()) {
            r(canvas);
        }
        this.f24512p.setAlpha(alpha);
        this.f24513q.setAlpha(alpha2);
    }

    public void e0(float f10) {
        c cVar = this.f24499a;
        if (cVar.f24535n != f10) {
            cVar.f24535n = f10;
            n0();
        }
    }

    public void f0(boolean z10) {
        this.D = z10;
    }

    public void g0(int i10) {
        this.f24514t.d(i10);
        this.f24499a.f24542u = false;
        R();
    }

    public int getAlpha() {
        return this.f24499a.f24534m;
    }

    public Drawable.ConstantState getConstantState() {
        return this.f24499a;
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f24499a.f24538q != 2) {
            if (T()) {
                outline.setRoundRect(getBounds(), J() * this.f24499a.f24532k);
                return;
            }
            g(u(), this.f24505g);
            jf.b.f(outline, this.f24505g);
        }
    }

    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.f24499a.f24530i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Region getTransparentRegion() {
        this.f24509l.set(getBounds());
        g(u(), this.f24505g);
        this.f24510m.setPath(this.f24505g, this.f24509l);
        this.f24509l.op(this.f24510m, Region.Op.DIFFERENCE);
        return this.f24509l;
    }

    /* access modifiers changed from: protected */
    public final void h(@NonNull RectF rectF, @NonNull Path path) {
        l lVar = this.f24516x;
        c cVar = this.f24499a;
        k kVar = cVar.f24522a;
        float f10 = cVar.f24532k;
        lVar.e(kVar, f10, rectF, this.f24515w, path);
    }

    public void h0(float f10, int i10) {
        k0(f10);
        j0(ColorStateList.valueOf(i10));
    }

    public void i0(float f10, ColorStateList colorStateList) {
        k0(f10);
        j0(colorStateList);
    }

    public void invalidateSelf() {
        this.f24503e = true;
        super.invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        if (super.isStateful() || (((colorStateList = this.f24499a.f24528g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f24499a.f24527f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f24499a.f24526e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f24499a.f24525d) != null && colorStateList4.isStateful()))))) {
            return true;
        }
        return false;
    }

    public void j0(ColorStateList colorStateList) {
        c cVar = this.f24499a;
        if (cVar.f24526e != colorStateList) {
            cVar.f24526e = colorStateList;
            onStateChange(getState());
        }
    }

    public void k0(float f10) {
        this.f24499a.f24533l = f10;
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public int l(int i10) {
        float M = M() + z();
        kf.a aVar = this.f24499a.f24523b;
        if (aVar != null) {
            return aVar.c(i10, M);
        }
        return i10;
    }

    @NonNull
    public Drawable mutate() {
        this.f24499a = new c(this.f24499a);
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f24503e = true;
        super.onBoundsChange(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        boolean l02 = l0(iArr);
        boolean m02 = m0();
        if (l02 || m02) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    /* access modifiers changed from: protected */
    public void p(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        q(canvas, paint, path, this.f24499a.f24522a, rectF);
    }

    /* access modifiers changed from: protected */
    public void r(@NonNull Canvas canvas) {
        q(canvas, this.f24513q, this.f24506h, this.f24511n, v());
    }

    public float s() {
        return this.f24499a.f24522a.j().a(u());
    }

    public void setAlpha(int i10) {
        c cVar = this.f24499a;
        if (cVar.f24534m != i10) {
            cVar.f24534m = i10;
            R();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f24499a.f24524c = colorFilter;
        R();
    }

    public void setShapeAppearanceModel(@NonNull k kVar) {
        this.f24499a.f24522a = kVar;
        invalidateSelf();
    }

    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f24499a.f24528g = colorStateList;
        m0();
        R();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f24499a;
        if (cVar.f24529h != mode) {
            cVar.f24529h = mode;
            m0();
            R();
        }
    }

    public float t() {
        return this.f24499a.f24522a.l().a(u());
    }

    /* access modifiers changed from: protected */
    @NonNull
    public RectF u() {
        this.f24507j.set(getBounds());
        return this.f24507j;
    }

    public float w() {
        return this.f24499a.f24536o;
    }

    public ColorStateList x() {
        return this.f24499a.f24525d;
    }

    public float y() {
        return this.f24499a.f24532k;
    }

    public float z() {
        return this.f24499a.f24535n;
    }

    public g() {
        this(new k());
    }

    public g(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        this(k.e(context, attributeSet, i10, i11).m());
    }

    public g(@NonNull k kVar) {
        this(new c(kVar, (kf.a) null));
    }

    private g(@NonNull c cVar) {
        l lVar;
        this.f24500b = new m.g[4];
        this.f24501c = new m.g[4];
        this.f24502d = new BitSet(8);
        this.f24504f = new Matrix();
        this.f24505g = new Path();
        this.f24506h = new Path();
        this.f24507j = new RectF();
        this.f24508k = new RectF();
        this.f24509l = new Region();
        this.f24510m = new Region();
        Paint paint = new Paint(1);
        this.f24512p = paint;
        Paint paint2 = new Paint(1);
        this.f24513q = paint2;
        this.f24514t = new sf.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            lVar = l.k();
        } else {
            lVar = new l();
        }
        this.f24516x = lVar;
        this.C = new RectF();
        this.D = true;
        this.f24499a = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        m0();
        l0(getState());
        this.f24515w = new a();
    }

    static final class c extends Drawable.ConstantState {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public k f24522a;

        /* renamed from: b  reason: collision with root package name */
        public kf.a f24523b;

        /* renamed from: c  reason: collision with root package name */
        public ColorFilter f24524c;

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f24525d = null;

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f24526e = null;

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f24527f = null;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f24528g = null;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f24529h = PorterDuff.Mode.SRC_IN;

        /* renamed from: i  reason: collision with root package name */
        public Rect f24530i = null;

        /* renamed from: j  reason: collision with root package name */
        public float f24531j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f24532k = 1.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f24533l;

        /* renamed from: m  reason: collision with root package name */
        public int f24534m = 255;

        /* renamed from: n  reason: collision with root package name */
        public float f24535n = 0.0f;

        /* renamed from: o  reason: collision with root package name */
        public float f24536o = 0.0f;

        /* renamed from: p  reason: collision with root package name */
        public float f24537p = 0.0f;

        /* renamed from: q  reason: collision with root package name */
        public int f24538q = 0;

        /* renamed from: r  reason: collision with root package name */
        public int f24539r = 0;

        /* renamed from: s  reason: collision with root package name */
        public int f24540s = 0;

        /* renamed from: t  reason: collision with root package name */
        public int f24541t = 0;

        /* renamed from: u  reason: collision with root package name */
        public boolean f24542u = false;

        /* renamed from: v  reason: collision with root package name */
        public Paint.Style f24543v = Paint.Style.FILL_AND_STROKE;

        public c(k kVar, kf.a aVar) {
            this.f24522a = kVar;
            this.f24523b = aVar;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable() {
            g gVar = new g(this, (a) null);
            boolean unused = gVar.f24503e = true;
            return gVar;
        }

        public c(@NonNull c cVar) {
            this.f24522a = cVar.f24522a;
            this.f24523b = cVar.f24523b;
            this.f24533l = cVar.f24533l;
            this.f24524c = cVar.f24524c;
            this.f24525d = cVar.f24525d;
            this.f24526e = cVar.f24526e;
            this.f24529h = cVar.f24529h;
            this.f24528g = cVar.f24528g;
            this.f24534m = cVar.f24534m;
            this.f24531j = cVar.f24531j;
            this.f24540s = cVar.f24540s;
            this.f24538q = cVar.f24538q;
            this.f24542u = cVar.f24542u;
            this.f24532k = cVar.f24532k;
            this.f24535n = cVar.f24535n;
            this.f24536o = cVar.f24536o;
            this.f24537p = cVar.f24537p;
            this.f24539r = cVar.f24539r;
            this.f24541t = cVar.f24541t;
            this.f24527f = cVar.f24527f;
            this.f24543v = cVar.f24543v;
            if (cVar.f24530i != null) {
                this.f24530i = new Rect(cVar.f24530i);
            }
        }
    }
}
