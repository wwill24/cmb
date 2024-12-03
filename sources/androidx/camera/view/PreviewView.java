package androidx.camera.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.a2;
import androidx.camera.core.f2;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.p;
import androidx.camera.core.impl.utils.q;
import androidx.camera.core.impl.x;
import androidx.camera.core.k3;
import androidx.camera.core.v1;
import androidx.core.view.n0;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.t;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class PreviewView extends FrameLayout {

    /* renamed from: t  reason: collision with root package name */
    private static final ImplementationMode f3428t = ImplementationMode.PERFORMANCE;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    ImplementationMode f3429a;

    /* renamed from: b  reason: collision with root package name */
    l f3430b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final f f3431c;

    /* renamed from: d  reason: collision with root package name */
    boolean f3432d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    final t<StreamState> f3433e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<e> f3434f;

    /* renamed from: g  reason: collision with root package name */
    d f3435g;

    /* renamed from: h  reason: collision with root package name */
    Executor f3436h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    m f3437j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final ScaleGestureDetector f3438k;

    /* renamed from: l  reason: collision with root package name */
    x f3439l;

    /* renamed from: m  reason: collision with root package name */
    private MotionEvent f3440m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    private final c f3441n;

    /* renamed from: p  reason: collision with root package name */
    private final View.OnLayoutChangeListener f3442p;

    /* renamed from: q  reason: collision with root package name */
    final f2.d f3443q;

    public enum ImplementationMode {
        PERFORMANCE(0),
        COMPATIBLE(1);
        
        private final int mId;

        private ImplementationMode(int i10) {
            this.mId = i10;
        }

        static ImplementationMode a(int i10) {
            for (ImplementationMode implementationMode : values()) {
                if (implementationMode.mId == i10) {
                    return implementationMode;
                }
            }
            throw new IllegalArgumentException("Unknown implementation mode id " + i10);
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.mId;
        }
    }

    public enum ScaleType {
        FILL_START(0),
        FILL_CENTER(1),
        FILL_END(2),
        FIT_START(3),
        FIT_CENTER(4),
        FIT_END(5);
        
        private final int mId;

        private ScaleType(int i10) {
            this.mId = i10;
        }

        static ScaleType a(int i10) {
            for (ScaleType scaleType : values()) {
                if (scaleType.mId == i10) {
                    return scaleType;
                }
            }
            throw new IllegalArgumentException("Unknown scale type id " + i10);
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.mId;
        }
    }

    public enum StreamState {
        IDLE,
        STREAMING
    }

    class a implements f2.d {
        a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(SurfaceRequest surfaceRequest) {
            PreviewView.this.f3443q.a(surfaceRequest);
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0051  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ void f(androidx.camera.core.impl.CameraInternal r4, androidx.camera.core.SurfaceRequest r5, androidx.camera.core.SurfaceRequest.f r6) {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Preview transformation info updated. "
                r0.append(r1)
                r0.append(r6)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "PreviewView"
                androidx.camera.core.v1.a(r1, r0)
                androidx.camera.core.impl.x r4 = r4.l()
                java.lang.Integer r4 = r4.c()
                r0 = 0
                r2 = 1
                if (r4 != 0) goto L_0x0029
                java.lang.String r4 = "The lens facing is null, probably an external."
                androidx.camera.core.v1.l(r1, r4)
            L_0x0027:
                r4 = r2
                goto L_0x0031
            L_0x0029:
                int r4 = r4.intValue()
                if (r4 != 0) goto L_0x0030
                goto L_0x0027
            L_0x0030:
                r4 = r0
            L_0x0031:
                androidx.camera.view.PreviewView r1 = androidx.camera.view.PreviewView.this
                androidx.camera.view.f r1 = r1.f3431c
                android.util.Size r5 = r5.m()
                r1.p(r6, r5, r4)
                int r4 = r6.c()
                r5 = -1
                if (r4 == r5) goto L_0x0051
                androidx.camera.view.PreviewView r4 = androidx.camera.view.PreviewView.this
                androidx.camera.view.l r5 = r4.f3430b
                if (r5 == 0) goto L_0x004e
                boolean r5 = r5 instanceof androidx.camera.view.r
                if (r5 == 0) goto L_0x004e
                goto L_0x0051
            L_0x004e:
                r4.f3432d = r0
                goto L_0x0055
            L_0x0051:
                androidx.camera.view.PreviewView r4 = androidx.camera.view.PreviewView.this
                r4.f3432d = r2
            L_0x0055:
                androidx.camera.view.PreviewView r4 = androidx.camera.view.PreviewView.this
                r4.i()
                androidx.camera.view.PreviewView r4 = androidx.camera.view.PreviewView.this
                r4.e()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.PreviewView.a.f(androidx.camera.core.impl.CameraInternal, androidx.camera.core.SurfaceRequest, androidx.camera.core.SurfaceRequest$f):void");
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(e eVar, CameraInternal cameraInternal) {
            if (h.a(PreviewView.this.f3434f, eVar, (Object) null)) {
                eVar.l(StreamState.IDLE);
            }
            eVar.f();
            cameraInternal.c().d(eVar);
        }

        public void a(@NonNull SurfaceRequest surfaceRequest) {
            l lVar;
            Executor executor;
            if (!p.b()) {
                androidx.core.content.a.getMainExecutor(PreviewView.this.getContext()).execute(new i(this, surfaceRequest));
                return;
            }
            v1.a("PreviewView", "Surface requested by Preview.");
            CameraInternal j10 = surfaceRequest.j();
            PreviewView.this.f3439l = j10.l();
            surfaceRequest.x(androidx.core.content.a.getMainExecutor(PreviewView.this.getContext()), new j(this, j10, surfaceRequest));
            PreviewView previewView = PreviewView.this;
            if (PreviewView.f(surfaceRequest, previewView.f3429a)) {
                PreviewView previewView2 = PreviewView.this;
                lVar = new z(previewView2, previewView2.f3431c);
            } else {
                PreviewView previewView3 = PreviewView.this;
                lVar = new r(previewView3, previewView3.f3431c);
            }
            previewView.f3430b = lVar;
            x l10 = j10.l();
            PreviewView previewView4 = PreviewView.this;
            e eVar = new e(l10, previewView4.f3433e, previewView4.f3430b);
            PreviewView.this.f3434f.set(eVar);
            j10.c().c(androidx.core.content.a.getMainExecutor(PreviewView.this.getContext()), eVar);
            PreviewView.this.f3430b.g(surfaceRequest, new k(this, eVar, j10));
            PreviewView previewView5 = PreviewView.this;
            d dVar = previewView5.f3435g;
            if (dVar != null && (executor = previewView5.f3436h) != null) {
                previewView5.f3430b.i(executor, dVar);
            }
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3458a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3459b;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0059 */
        static {
            /*
                androidx.camera.view.PreviewView$ImplementationMode[] r0 = androidx.camera.view.PreviewView.ImplementationMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3459b = r0
                r1 = 1
                androidx.camera.view.PreviewView$ImplementationMode r2 = androidx.camera.view.PreviewView.ImplementationMode.COMPATIBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f3459b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.view.PreviewView$ImplementationMode r3 = androidx.camera.view.PreviewView.ImplementationMode.PERFORMANCE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                androidx.camera.view.PreviewView$ScaleType[] r2 = androidx.camera.view.PreviewView.ScaleType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f3458a = r2
                androidx.camera.view.PreviewView$ScaleType r3 = androidx.camera.view.PreviewView.ScaleType.FILL_END     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f3458a     // Catch:{ NoSuchFieldError -> 0x0038 }
                androidx.camera.view.PreviewView$ScaleType r2 = androidx.camera.view.PreviewView.ScaleType.FILL_CENTER     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f3458a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FILL_START     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f3458a     // Catch:{ NoSuchFieldError -> 0x004e }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f3458a     // Catch:{ NoSuchFieldError -> 0x0059 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f3458a     // Catch:{ NoSuchFieldError -> 0x0064 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.PreviewView.b.<clinit>():void");
        }
    }

    class c implements DisplayManager.DisplayListener {
        c() {
        }

        public void onDisplayAdded(int i10) {
        }

        public void onDisplayChanged(int i10) {
            Display display = PreviewView.this.getDisplay();
            if (display != null && display.getDisplayId() == i10) {
                PreviewView.this.i();
                PreviewView.this.e();
            }
        }

        public void onDisplayRemoved(int i10) {
        }
    }

    public interface d {
        void a(long j10);
    }

    class e extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        e() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            PreviewView.this.getClass();
            return true;
        }
    }

    public PreviewView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(boolean z10) {
        p.a();
        getDisplay();
        getViewPort();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        boolean z10;
        if (i12 - i10 == i16 - i14 && i13 - i11 == i17 - i15) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            e();
            b(true);
        }
    }

    static boolean f(@NonNull SurfaceRequest surfaceRequest, @NonNull ImplementationMode implementationMode) {
        boolean z10;
        int i10;
        boolean equals = surfaceRequest.j().l().h().equals("androidx.camera.camera2.legacy");
        if (j0.a.a(j0.d.class) == null && j0.a.a(j0.c.class) == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (surfaceRequest.n() || equals || z10 || (i10 = b.f3459b[implementationMode.ordinal()]) == 1) {
            return true;
        }
        if (i10 == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid implementation mode: " + implementationMode);
    }

    private void g() {
        DisplayManager displayManager = getDisplayManager();
        if (displayManager != null) {
            displayManager.registerDisplayListener(this.f3441n, new Handler(Looper.getMainLooper()));
        }
    }

    private DisplayManager getDisplayManager() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return (DisplayManager) context.getApplicationContext().getSystemService("display");
    }

    private int getViewPortScaleType() {
        switch (b.f3458a[getScaleType().ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 0;
            case 4:
            case 5:
            case 6:
                return 3;
            default:
                throw new IllegalStateException("Unexpected scale type: " + getScaleType());
        }
    }

    private void h() {
        DisplayManager displayManager = getDisplayManager();
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.f3441n);
        }
    }

    @SuppressLint({"WrongConstant"})
    public k3 c(int i10) {
        p.a();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        return new k3.a(new Rational(getWidth(), getHeight()), i10).c(getViewPortScaleType()).b(getLayoutDirection()).a();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        p.a();
        l lVar = this.f3430b;
        if (lVar != null) {
            lVar.h();
        }
        this.f3437j.e(new Size(getWidth(), getHeight()), getLayoutDirection());
    }

    public Bitmap getBitmap() {
        p.a();
        l lVar = this.f3430b;
        if (lVar == null) {
            return null;
        }
        return lVar.a();
    }

    public a getController() {
        p.a();
        return null;
    }

    @NonNull
    public ImplementationMode getImplementationMode() {
        p.a();
        return this.f3429a;
    }

    @NonNull
    public a2 getMeteringPointFactory() {
        p.a();
        return this.f3437j;
    }

    public k0.a getOutputTransform() {
        Matrix matrix;
        p.a();
        try {
            matrix = this.f3431c.h(new Size(getWidth(), getHeight()), getLayoutDirection());
        } catch (IllegalStateException unused) {
            matrix = null;
        }
        Rect g10 = this.f3431c.g();
        if (matrix == null || g10 == null) {
            v1.a("PreviewView", "Transform info is not ready");
            return null;
        }
        matrix.preConcat(q.a(g10));
        if (this.f3430b instanceof z) {
            matrix.postConcat(getMatrix());
        } else {
            v1.l("PreviewView", "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
        }
        return new k0.a(matrix, new Size(g10.width(), g10.height()));
    }

    @NonNull
    public LiveData<StreamState> getPreviewStreamState() {
        return this.f3433e;
    }

    @NonNull
    public ScaleType getScaleType() {
        p.a();
        return this.f3431c.f();
    }

    @NonNull
    public f2.d getSurfaceProvider() {
        p.a();
        return this.f3443q;
    }

    public k3 getViewPort() {
        p.a();
        if (getDisplay() == null) {
            return null;
        }
        return c(getDisplay().getRotation());
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Display display;
        x xVar;
        if (this.f3432d && (display = getDisplay()) != null && (xVar = this.f3439l) != null) {
            this.f3431c.m(xVar.i(display.getRotation()), display.getRotation());
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
        g();
        addOnLayoutChangeListener(this.f3442p);
        l lVar = this.f3430b;
        if (lVar != null) {
            lVar.d();
        }
        b(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.f3442p);
        l lVar = this.f3430b;
        if (lVar != null) {
            lVar.e();
        }
        h();
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public boolean performClick() {
        this.f3440m = null;
        return super.performClick();
    }

    public void setController(a aVar) {
        p.a();
        b(false);
    }

    public void setImplementationMode(@NonNull ImplementationMode implementationMode) {
        p.a();
        this.f3429a = implementationMode;
        if (implementationMode == ImplementationMode.PERFORMANCE && this.f3435g != null) {
            throw new IllegalArgumentException("PERFORMANCE mode doesn't support frame update listener");
        }
    }

    public void setScaleType(@NonNull ScaleType scaleType) {
        p.a();
        this.f3431c.o(scaleType);
        e();
        b(false);
    }

    public PreviewView(@NonNull Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    /* JADX INFO: finally extract failed */
    public PreviewView(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        ImplementationMode implementationMode = f3428t;
        this.f3429a = implementationMode;
        f fVar = new f();
        this.f3431c = fVar;
        this.f3432d = true;
        this.f3433e = new t<>(StreamState.IDLE);
        this.f3434f = new AtomicReference<>();
        this.f3437j = new m(fVar);
        this.f3441n = new c();
        this.f3442p = new g(this);
        this.f3443q = new a();
        p.a();
        Resources.Theme theme = context.getTheme();
        int[] iArr = n.PreviewView;
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, i10, i11);
        n0.q0(this, context, iArr, attributeSet, obtainStyledAttributes, i10, i11);
        try {
            setScaleType(ScaleType.a(obtainStyledAttributes.getInteger(n.PreviewView_scaleType, fVar.f().b())));
            setImplementationMode(ImplementationMode.a(obtainStyledAttributes.getInteger(n.PreviewView_implementationMode, implementationMode.b())));
            obtainStyledAttributes.recycle();
            this.f3438k = new ScaleGestureDetector(context, new e());
            if (getBackground() == null) {
                setBackgroundColor(androidx.core.content.a.getColor(getContext(), 17170444));
            }
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
