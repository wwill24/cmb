package yn;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.core.view.b0;
import java.lang.ref.WeakReference;
import net.bytebuddy.jar.asm.Opcodes;

public class d implements c, View.OnTouchListener, zn.e, ViewTreeObserver.OnGlobalLayoutListener {
    /* access modifiers changed from: private */
    public static final boolean K = Log.isLoggable("PhotoViewAttacher", 3);
    static final Interpolator L = new AccelerateDecelerateInterpolator();
    static int M = 1;
    private int B;
    private int C;
    private int D;
    private int E;
    private C0521d F;
    private int G;
    private float H;
    private boolean I;
    private ImageView.ScaleType J;

    /* renamed from: a  reason: collision with root package name */
    int f42512a;

    /* renamed from: b  reason: collision with root package name */
    private float f42513b;

    /* renamed from: c  reason: collision with root package name */
    private float f42514c;

    /* renamed from: d  reason: collision with root package name */
    private float f42515d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f42516e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f42517f;

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<ImageView> f42518g;

    /* renamed from: h  reason: collision with root package name */
    private GestureDetector f42519h;

    /* renamed from: j  reason: collision with root package name */
    private zn.d f42520j;

    /* renamed from: k  reason: collision with root package name */
    private final Matrix f42521k;

    /* renamed from: l  reason: collision with root package name */
    private final Matrix f42522l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final Matrix f42523m;

    /* renamed from: n  reason: collision with root package name */
    private final RectF f42524n;

    /* renamed from: p  reason: collision with root package name */
    private final float[] f42525p;

    /* renamed from: q  reason: collision with root package name */
    private e f42526q;

    /* renamed from: t  reason: collision with root package name */
    private f f42527t;

    /* renamed from: w  reason: collision with root package name */
    private i f42528w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public View.OnLongClickListener f42529x;

    /* renamed from: y  reason: collision with root package name */
    private g f42530y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public h f42531z;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            if (d.this.f42531z == null || d.this.y() > 1.0f || b0.a(motionEvent) > d.M || b0.a(motionEvent2) > d.M) {
                return false;
            }
            return d.this.f42531z.onFling(motionEvent, motionEvent2, f10, f11);
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (d.this.f42529x != null) {
                d.this.f42529x.onLongClick(d.this.q());
            }
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f42533a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f42533a = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f42533a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f42533a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f42533a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f42533a     // Catch:{ NoSuchFieldError -> 0x003e }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: yn.d.b.<clinit>():void");
        }
    }

    private class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final float f42534a;

        /* renamed from: b  reason: collision with root package name */
        private final float f42535b;

        /* renamed from: c  reason: collision with root package name */
        private final long f42536c = System.currentTimeMillis();

        /* renamed from: d  reason: collision with root package name */
        private final float f42537d;

        /* renamed from: e  reason: collision with root package name */
        private final float f42538e;

        public c(float f10, float f11, float f12, float f13) {
            this.f42534a = f12;
            this.f42535b = f13;
            this.f42537d = f10;
            this.f42538e = f11;
        }

        private float a() {
            return d.L.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f42536c)) * 1.0f) / ((float) d.this.f42512a)));
        }

        public void run() {
            ImageView q10 = d.this.q();
            if (q10 != null) {
                float a10 = a();
                float f10 = this.f42537d;
                d.this.b((f10 + ((this.f42538e - f10) * a10)) / d.this.y(), this.f42534a, this.f42535b);
                if (a10 < 1.0f) {
                    a.c(q10, this);
                }
            }
        }
    }

    /* renamed from: yn.d$d  reason: collision with other inner class name */
    private class C0521d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final bo.c f42540a;

        /* renamed from: b  reason: collision with root package name */
        private int f42541b;

        /* renamed from: c  reason: collision with root package name */
        private int f42542c;

        public C0521d(Context context) {
            this.f42540a = bo.c.f(context);
        }

        public void a() {
            if (d.K) {
                ao.a.a().a("PhotoViewAttacher", "Cancel Fling");
            }
            this.f42540a.c(true);
        }

        public void b(int i10, int i11, int i12, int i13) {
            int i14;
            int i15;
            int i16;
            int i17;
            RectF n10 = d.this.n();
            if (n10 != null) {
                int round = Math.round(-n10.left);
                float f10 = (float) i10;
                if (f10 < n10.width()) {
                    i14 = Math.round(n10.width() - f10);
                    i15 = 0;
                } else {
                    i15 = round;
                    i14 = i15;
                }
                int round2 = Math.round(-n10.top);
                float f11 = (float) i11;
                if (f11 < n10.height()) {
                    i16 = Math.round(n10.height() - f11);
                    i17 = 0;
                } else {
                    i17 = round2;
                    i16 = i17;
                }
                this.f42541b = round;
                this.f42542c = round2;
                if (d.K) {
                    ao.a.a().a("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i14 + " MaxY:" + i16);
                }
                if (round != i14 || round2 != i16) {
                    this.f42540a.b(round, round2, i12, i13, i15, i14, i17, i16, 0, 0);
                }
            }
        }

        public void run() {
            ImageView q10;
            if (!this.f42540a.g() && (q10 = d.this.q()) != null && this.f42540a.a()) {
                int d10 = this.f42540a.d();
                int e10 = this.f42540a.e();
                if (d.K) {
                    ao.b a10 = ao.a.a();
                    a10.a("PhotoViewAttacher", "fling run(). CurrentX:" + this.f42541b + " CurrentY:" + this.f42542c + " NewX:" + d10 + " NewY:" + e10);
                }
                d.this.f42523m.postTranslate((float) (this.f42541b - d10), (float) (this.f42542c - e10));
                d dVar = d.this;
                dVar.C(dVar.p());
                this.f42541b = d10;
                this.f42542c = e10;
                a.c(q10, this);
            }
        }
    }

    public interface e {
        void a(RectF rectF);
    }

    public interface f {
        void a();

        void b(View view, float f10, float f11);
    }

    public interface g {
        void a(float f10, float f11, float f12);
    }

    public interface h {
        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11);
    }

    public interface i {
        void a(View view, float f10, float f11);
    }

    public d(ImageView imageView) {
        this(imageView, true);
    }

    private static boolean A(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private void B() {
        this.f42523m.reset();
        F(this.H);
        C(p());
        l();
    }

    /* access modifiers changed from: private */
    public void C(Matrix matrix) {
        RectF o10;
        ImageView q10 = q();
        if (q10 != null) {
            k();
            q10.setImageMatrix(matrix);
            if (this.f42526q != null && (o10 = o(matrix)) != null) {
                this.f42526q.a(o10);
            }
        }
    }

    private static void D(ImageView imageView) {
        if (imageView != null && !(imageView instanceof c) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    private void J(Drawable drawable) {
        ImageView q10 = q();
        if (q10 != null && drawable != null) {
            float s10 = (float) s(q10);
            float r10 = (float) r(q10);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.f42521k.reset();
            float f10 = (float) intrinsicWidth;
            float f11 = s10 / f10;
            float f12 = (float) intrinsicHeight;
            float f13 = r10 / f12;
            ImageView.ScaleType scaleType = this.J;
            if (scaleType == ImageView.ScaleType.CENTER) {
                this.f42521k.postTranslate((s10 - f10) / 2.0f, (r10 - f12) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f11, f13);
                this.f42521k.postScale(max, max);
                this.f42521k.postTranslate((s10 - (f10 * max)) / 2.0f, (r10 - (f12 * max)) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f11, f13));
                this.f42521k.postScale(min, min);
                this.f42521k.postTranslate((s10 - (f10 * min)) / 2.0f, (r10 - (f12 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f10, f12);
                RectF rectF2 = new RectF(0.0f, 0.0f, s10, r10);
                if (((int) this.H) % Opcodes.GETFIELD != 0) {
                    rectF = new RectF(0.0f, 0.0f, f12, f10);
                }
                int i10 = b.f42533a[this.J.ordinal()];
                if (i10 == 2) {
                    this.f42521k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i10 == 3) {
                    this.f42521k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i10 == 4) {
                    this.f42521k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                } else if (i10 == 5) {
                    this.f42521k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            }
            B();
        }
    }

    private void i() {
        C0521d dVar = this.F;
        if (dVar != null) {
            dVar.a();
            this.F = null;
        }
    }

    private void j() {
        if (l()) {
            C(p());
        }
    }

    private void k() {
        ImageView q10 = q();
        if (q10 != null && !(q10 instanceof c) && !ImageView.ScaleType.MATRIX.equals(q10.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean l() {
        /*
            r12 = this;
            android.widget.ImageView r0 = r12.q()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.graphics.Matrix r2 = r12.p()
            android.graphics.RectF r2 = r12.o(r2)
            if (r2 != 0) goto L_0x0013
            return r1
        L_0x0013:
            float r3 = r2.height()
            float r4 = r2.width()
            int r5 = r12.r(r0)
            float r5 = (float) r5
            int r6 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r7 = 1073741824(0x40000000, float:2.0)
            r8 = 3
            r9 = 2
            r10 = 0
            if (r6 > 0) goto L_0x0044
            int[] r6 = yn.d.b.f42533a
            android.widget.ImageView$ScaleType r11 = r12.J
            int r11 = r11.ordinal()
            r6 = r6[r11]
            if (r6 == r9) goto L_0x0041
            if (r6 == r8) goto L_0x003c
            float r5 = r5 - r3
            float r5 = r5 / r7
            float r3 = r2.top
            goto L_0x003f
        L_0x003c:
            float r5 = r5 - r3
            float r3 = r2.top
        L_0x003f:
            float r5 = r5 - r3
            goto L_0x0054
        L_0x0041:
            float r3 = r2.top
            goto L_0x004a
        L_0x0044:
            float r3 = r2.top
            int r6 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x004c
        L_0x004a:
            float r5 = -r3
            goto L_0x0054
        L_0x004c:
            float r3 = r2.bottom
            int r6 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r6 >= 0) goto L_0x0053
            goto L_0x003f
        L_0x0053:
            r5 = r10
        L_0x0054:
            int r0 = r12.s(r0)
            float r0 = (float) r0
            int r3 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            r6 = 1
            if (r3 > 0) goto L_0x007d
            int[] r1 = yn.d.b.f42533a
            android.widget.ImageView$ScaleType r3 = r12.J
            int r3 = r3.ordinal()
            r1 = r1[r3]
            if (r1 == r9) goto L_0x0076
            if (r1 == r8) goto L_0x0071
            float r0 = r0 - r4
            float r0 = r0 / r7
            float r1 = r2.left
            goto L_0x0074
        L_0x0071:
            float r0 = r0 - r4
            float r1 = r2.left
        L_0x0074:
            float r0 = r0 - r1
            goto L_0x0079
        L_0x0076:
            float r0 = r2.left
            float r0 = -r0
        L_0x0079:
            r10 = r0
            r12.G = r9
            goto L_0x0095
        L_0x007d:
            float r3 = r2.left
            int r4 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x0087
            r12.G = r1
            float r10 = -r3
            goto L_0x0095
        L_0x0087:
            float r1 = r2.right
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0092
            float r10 = r0 - r1
            r12.G = r6
            goto L_0x0095
        L_0x0092:
            r0 = -1
            r12.G = r0
        L_0x0095:
            android.graphics.Matrix r0 = r12.f42523m
            r0.postTranslate(r10, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: yn.d.l():boolean");
    }

    private RectF o(Matrix matrix) {
        Drawable drawable;
        ImageView q10 = q();
        if (q10 == null || (drawable = q10.getDrawable()) == null) {
            return null;
        }
        this.f42524n.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.f42524n);
        return this.f42524n;
    }

    private int r(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private int s(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float z(Matrix matrix, int i10) {
        matrix.getValues(this.f42525p);
        return this.f42525p[i10];
    }

    public void E(f fVar) {
        this.f42527t = fVar;
    }

    public void F(float f10) {
        this.f42523m.postRotate(f10 % 360.0f);
        j();
    }

    public void G(float f10, float f11, float f12, boolean z10) {
        ImageView q10 = q();
        if (q10 == null) {
            return;
        }
        if (f10 < this.f42513b || f10 > this.f42515d) {
            ao.a.a().b("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
        } else if (z10) {
            q10.post(new c(y(), f10, f11, f12));
        } else {
            this.f42523m.setScale(f10, f10, f11, f12);
            j();
        }
    }

    public void H(boolean z10) {
        this.I = z10;
        I();
    }

    public void I() {
        ImageView q10 = q();
        if (q10 == null) {
            return;
        }
        if (this.I) {
            D(q10);
            J(q10.getDrawable());
            return;
        }
        B();
    }

    public void a(float f10, float f11) {
        if (!this.f42520j.d()) {
            if (K) {
                ao.a.a().a("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[]{Float.valueOf(f10), Float.valueOf(f11)}));
            }
            ImageView q10 = q();
            this.f42523m.postTranslate(f10, f11);
            j();
            ViewParent parent = q10.getParent();
            if (this.f42516e && !this.f42520j.d() && !this.f42517f) {
                int i10 = this.G;
                if ((i10 == 2 || ((i10 == 0 && f10 >= 1.0f) || (i10 == 1 && f10 <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public void b(float f10, float f11, float f12) {
        if (K) {
            ao.a.a().a("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[]{Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12)}));
        }
        if (y() >= this.f42515d && f10 >= 1.0f) {
            return;
        }
        if (y() > this.f42513b || f10 > 1.0f) {
            g gVar = this.f42530y;
            if (gVar != null) {
                gVar.a(f10, f11, f12);
            }
            this.f42523m.postScale(f10, f10, f11, f12);
            j();
        }
    }

    public void c(float f10, float f11, float f12, float f13) {
        if (K) {
            ao.b a10 = ao.a.a();
            a10.a("PhotoViewAttacher", "onFling. sX: " + f10 + " sY: " + f11 + " Vx: " + f12 + " Vy: " + f13);
        }
        ImageView q10 = q();
        C0521d dVar = new C0521d(q10.getContext());
        this.F = dVar;
        dVar.b(s(q10), r(q10), (int) f12, (int) f13);
        q10.post(this.F);
    }

    public void m() {
        WeakReference<ImageView> weakReference = this.f42518g;
        if (weakReference != null) {
            ImageView imageView = weakReference.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener((View.OnTouchListener) null);
                i();
            }
            GestureDetector gestureDetector = this.f42519h;
            if (gestureDetector != null) {
                gestureDetector.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) null);
            }
            this.f42526q = null;
            this.f42527t = null;
            this.f42528w = null;
            this.f42518g = null;
        }
    }

    public RectF n() {
        l();
        return o(p());
    }

    public void onGlobalLayout() {
        ImageView q10 = q();
        if (q10 == null) {
            return;
        }
        if (this.I) {
            int top = q10.getTop();
            int right = q10.getRight();
            int bottom = q10.getBottom();
            int left = q10.getLeft();
            if (top != this.B || bottom != this.D || left != this.E || right != this.C) {
                J(q10.getDrawable());
                this.B = top;
                this.C = right;
                this.D = bottom;
                this.E = left;
                return;
            }
            return;
        }
        J(q10.getDrawable());
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.I
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00a1
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = A(r0)
            if (r0 == 0) goto L_0x00a1
            android.view.ViewParent r0 = r11.getParent()
            int r3 = r12.getAction()
            if (r3 == 0) goto L_0x0049
            if (r3 == r2) goto L_0x001f
            r0 = 3
            if (r3 == r0) goto L_0x001f
            goto L_0x005d
        L_0x001f:
            float r0 = r10.y()
            float r3 = r10.f42513b
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x005d
            android.graphics.RectF r0 = r10.n()
            if (r0 == 0) goto L_0x005d
            yn.d$c r9 = new yn.d$c
            float r5 = r10.y()
            float r6 = r10.f42513b
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            r11 = r2
            goto L_0x005e
        L_0x0049:
            if (r0 == 0) goto L_0x004f
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L_0x005a
        L_0x004f:
            ao.b r11 = ao.a.a()
            java.lang.String r0 = "PhotoViewAttacher"
            java.lang.String r3 = "onTouch getParent() returned null"
            r11.b(r0, r3)
        L_0x005a:
            r10.i()
        L_0x005d:
            r11 = r1
        L_0x005e:
            zn.d r0 = r10.f42520j
            if (r0 == 0) goto L_0x0095
            boolean r11 = r0.d()
            zn.d r0 = r10.f42520j
            boolean r0 = r0.c()
            zn.d r3 = r10.f42520j
            boolean r3 = r3.a(r12)
            if (r11 != 0) goto L_0x007e
            zn.d r11 = r10.f42520j
            boolean r11 = r11.d()
            if (r11 != 0) goto L_0x007e
            r11 = r2
            goto L_0x007f
        L_0x007e:
            r11 = r1
        L_0x007f:
            if (r0 != 0) goto L_0x008b
            zn.d r0 = r10.f42520j
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x008b
            r0 = r2
            goto L_0x008c
        L_0x008b:
            r0 = r1
        L_0x008c:
            if (r11 == 0) goto L_0x0091
            if (r0 == 0) goto L_0x0091
            r1 = r2
        L_0x0091:
            r10.f42517f = r1
            r1 = r3
            goto L_0x0096
        L_0x0095:
            r1 = r11
        L_0x0096:
            android.view.GestureDetector r11 = r10.f42519h
            if (r11 == 0) goto L_0x00a1
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto L_0x00a1
            r1 = r2
        L_0x00a1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: yn.d.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public Matrix p() {
        this.f42522l.set(this.f42521k);
        this.f42522l.postConcat(this.f42523m);
        return this.f42522l;
    }

    public ImageView q() {
        ImageView imageView;
        WeakReference<ImageView> weakReference = this.f42518g;
        if (weakReference != null) {
            imageView = weakReference.get();
        } else {
            imageView = null;
        }
        if (imageView == null) {
            m();
            ao.a.a().b("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float t() {
        return this.f42515d;
    }

    public float u() {
        return this.f42514c;
    }

    public float v() {
        return this.f42513b;
    }

    @Deprecated
    public f w() {
        return this.f42527t;
    }

    @Deprecated
    public i x() {
        return this.f42528w;
    }

    public float y() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) z(this.f42523m, 0), 2.0d)) + ((float) Math.pow((double) z(this.f42523m, 3), 2.0d))));
    }

    public d(ImageView imageView, boolean z10) {
        this.f42512a = 200;
        this.f42513b = 1.0f;
        this.f42514c = 1.75f;
        this.f42515d = 3.0f;
        this.f42516e = true;
        this.f42517f = false;
        this.f42521k = new Matrix();
        this.f42522l = new Matrix();
        this.f42523m = new Matrix();
        this.f42524n = new RectF();
        this.f42525p = new float[9];
        this.G = 2;
        this.J = ImageView.ScaleType.FIT_CENTER;
        this.f42518g = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        D(imageView);
        if (!imageView.isInEditMode()) {
            this.f42520j = zn.f.a(imageView.getContext(), this);
            GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new a());
            this.f42519h = gestureDetector;
            gestureDetector.setOnDoubleTapListener(new b(this));
            this.H = 0.0f;
            H(z10);
        }
    }
}
