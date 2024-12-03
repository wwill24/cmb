package androidx.camera.camera2.internal;

import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.t;
import androidx.camera.core.CameraControl;
import androidx.camera.core.f0;
import androidx.camera.core.g0;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.r1;
import androidx.camera.core.z1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import n.a;
import r.k;

class g2 {

    /* renamed from: v  reason: collision with root package name */
    private static final MeteringRectangle[] f1757v = new MeteringRectangle[0];

    /* renamed from: a  reason: collision with root package name */
    private final t f1758a;

    /* renamed from: b  reason: collision with root package name */
    final Executor f1759b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f1760c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f1761d = false;

    /* renamed from: e  reason: collision with root package name */
    private volatile Rational f1762e = null;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final k f1763f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1764g = false;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    Integer f1765h = 0;

    /* renamed from: i  reason: collision with root package name */
    private ScheduledFuture<?> f1766i;

    /* renamed from: j  reason: collision with root package name */
    private ScheduledFuture<?> f1767j;

    /* renamed from: k  reason: collision with root package name */
    long f1768k = 0;

    /* renamed from: l  reason: collision with root package name */
    boolean f1769l = false;

    /* renamed from: m  reason: collision with root package name */
    boolean f1770m = false;

    /* renamed from: n  reason: collision with root package name */
    private int f1771n = 1;

    /* renamed from: o  reason: collision with root package name */
    private t.c f1772o = null;

    /* renamed from: p  reason: collision with root package name */
    private t.c f1773p = null;

    /* renamed from: q  reason: collision with root package name */
    private MeteringRectangle[] f1774q;

    /* renamed from: r  reason: collision with root package name */
    private MeteringRectangle[] f1775r;

    /* renamed from: s  reason: collision with root package name */
    private MeteringRectangle[] f1776s;

    /* renamed from: t  reason: collision with root package name */
    CallbackToFutureAdapter.a<g0> f1777t;

    /* renamed from: u  reason: collision with root package name */
    CallbackToFutureAdapter.a<Void> f1778u;

    class a extends n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CallbackToFutureAdapter.a f1779a;

        a(CallbackToFutureAdapter.a aVar) {
            this.f1779a = aVar;
        }

        public void a() {
            CallbackToFutureAdapter.a aVar = this.f1779a;
            if (aVar != null) {
                aVar.f(new CameraControl.OperationCanceledException("Camera is closed"));
            }
        }

        public void b(@NonNull p pVar) {
            CallbackToFutureAdapter.a aVar = this.f1779a;
            if (aVar != null) {
                aVar.c(pVar);
            }
        }

        public void c(@NonNull CameraCaptureFailure cameraCaptureFailure) {
            CallbackToFutureAdapter.a aVar = this.f1779a;
            if (aVar != null) {
                aVar.f(new CameraControlInternal.CameraControlException(cameraCaptureFailure));
            }
        }
    }

    class b extends n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CallbackToFutureAdapter.a f1781a;

        b(CallbackToFutureAdapter.a aVar) {
            this.f1781a = aVar;
        }

        public void a() {
            CallbackToFutureAdapter.a aVar = this.f1781a;
            if (aVar != null) {
                aVar.f(new CameraControl.OperationCanceledException("Camera is closed"));
            }
        }

        public void b(@NonNull p pVar) {
            CallbackToFutureAdapter.a aVar = this.f1781a;
            if (aVar != null) {
                aVar.c(null);
            }
        }

        public void c(@NonNull CameraCaptureFailure cameraCaptureFailure) {
            CallbackToFutureAdapter.a aVar = this.f1781a;
            if (aVar != null) {
                aVar.f(new CameraControlInternal.CameraControlException(cameraCaptureFailure));
            }
        }
    }

    g2(@NonNull t tVar, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Executor executor, @NonNull r1 r1Var) {
        MeteringRectangle[] meteringRectangleArr = f1757v;
        this.f1774q = meteringRectangleArr;
        this.f1775r = meteringRectangleArr;
        this.f1776s = meteringRectangleArr;
        this.f1777t = null;
        this.f1778u = null;
        this.f1758a = tVar;
        this.f1759b = executor;
        this.f1760c = scheduledExecutorService;
        this.f1763f = new k(r1Var);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean A(int i10, long j10, TotalCaptureResult totalCaptureResult) {
        if (((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)).intValue() != i10 || !t.P(totalCaptureResult, j10)) {
            return false;
        }
        o();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean B(boolean z10, long j10, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if (M()) {
            if (!z10 || num == null) {
                this.f1770m = true;
                this.f1769l = true;
            } else if (this.f1765h.intValue() == 3) {
                if (num.intValue() == 4) {
                    this.f1770m = true;
                    this.f1769l = true;
                } else if (num.intValue() == 5) {
                    this.f1770m = false;
                    this.f1769l = true;
                }
            }
        }
        if (!this.f1769l || !t.P(totalCaptureResult, j10)) {
            if (!this.f1765h.equals(num) && num != null) {
                this.f1765h = num;
            }
            return false;
        }
        n(this.f1770m);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(long j10) {
        if (j10 == this.f1768k) {
            this.f1770m = false;
            n(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(long j10) {
        this.f1759b.execute(new z1(this, j10));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(long j10) {
        if (j10 == this.f1768k) {
            l();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(long j10) {
        this.f1759b.execute(new y1(this, j10));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object H(f0 f0Var, long j10, CallbackToFutureAdapter.a aVar) throws Exception {
        this.f1759b.execute(new c2(this, aVar, f0Var, j10));
        return "startFocusAndMetering";
    }

    private static int I(int i10, int i11, int i12) {
        return Math.min(Math.max(i10, i12), i11);
    }

    private boolean M() {
        return this.f1774q.length > 0;
    }

    private void m() {
        ScheduledFuture<?> scheduledFuture = this.f1767j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f1767j = null;
        }
    }

    private void o() {
        CallbackToFutureAdapter.a<Void> aVar = this.f1778u;
        if (aVar != null) {
            aVar.c(null);
            this.f1778u = null;
        }
    }

    private void p() {
        ScheduledFuture<?> scheduledFuture = this.f1766i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f1766i = null;
        }
    }

    private void q(@NonNull MeteringRectangle[] meteringRectangleArr, @NonNull MeteringRectangle[] meteringRectangleArr2, @NonNull MeteringRectangle[] meteringRectangleArr3, f0 f0Var, long j10) {
        long j11;
        this.f1758a.b0(this.f1772o);
        p();
        m();
        this.f1774q = meteringRectangleArr;
        this.f1775r = meteringRectangleArr2;
        this.f1776s = meteringRectangleArr3;
        if (M()) {
            this.f1764g = true;
            this.f1769l = false;
            this.f1770m = false;
            j11 = this.f1758a.l0();
            R((CallbackToFutureAdapter.a<p>) null, true);
        } else {
            this.f1764g = false;
            this.f1769l = true;
            this.f1770m = false;
            j11 = this.f1758a.l0();
        }
        this.f1765h = 0;
        d2 d2Var = new d2(this, y(), j11);
        this.f1772o = d2Var;
        this.f1758a.t(d2Var);
        long j12 = this.f1768k + 1;
        this.f1768k = j12;
        e2 e2Var = new e2(this, j12);
        ScheduledExecutorService scheduledExecutorService = this.f1760c;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f1767j = scheduledExecutorService.schedule(e2Var, j10, timeUnit);
        if (f0Var.e()) {
            this.f1766i = this.f1760c.schedule(new f2(this, j12), f0Var.a(), timeUnit);
        }
    }

    private void r(String str) {
        this.f1758a.b0(this.f1772o);
        CallbackToFutureAdapter.a<g0> aVar = this.f1777t;
        if (aVar != null) {
            aVar.f(new CameraControl.OperationCanceledException(str));
            this.f1777t = null;
        }
    }

    private void s(String str) {
        this.f1758a.b0(this.f1773p);
        CallbackToFutureAdapter.a<Void> aVar = this.f1778u;
        if (aVar != null) {
            aVar.f(new CameraControl.OperationCanceledException(str));
            this.f1778u = null;
        }
    }

    private Rational u() {
        if (this.f1762e != null) {
            return this.f1762e;
        }
        Rect x10 = this.f1758a.x();
        return new Rational(x10.width(), x10.height());
    }

    private static PointF v(@NonNull z1 z1Var, @NonNull Rational rational, @NonNull Rational rational2, int i10, k kVar) {
        if (z1Var.b() != null) {
            rational2 = z1Var.b();
        }
        PointF a10 = kVar.a(z1Var, i10);
        if (!rational2.equals(rational)) {
            if (rational2.compareTo(rational) > 0) {
                float doubleValue = (float) (rational2.doubleValue() / rational.doubleValue());
                a10.y = (((float) ((((double) doubleValue) - 1.0d) / 2.0d)) + a10.y) * (1.0f / doubleValue);
            } else {
                float doubleValue2 = (float) (rational.doubleValue() / rational2.doubleValue());
                a10.x = (((float) ((((double) doubleValue2) - 1.0d) / 2.0d)) + a10.x) * (1.0f / doubleValue2);
            }
        }
        return a10;
    }

    private static MeteringRectangle w(z1 z1Var, PointF pointF, Rect rect) {
        int width = (int) (((float) rect.left) + (pointF.x * ((float) rect.width())));
        int height = (int) (((float) rect.top) + (pointF.y * ((float) rect.height())));
        int a10 = ((int) (z1Var.a() * ((float) rect.width()))) / 2;
        int a11 = ((int) (z1Var.a() * ((float) rect.height()))) / 2;
        Rect rect2 = new Rect(width - a10, height - a11, width + a10, height + a11);
        rect2.left = I(rect2.left, rect.right, rect.left);
        rect2.right = I(rect2.right, rect.right, rect.left);
        rect2.top = I(rect2.top, rect.bottom, rect.top);
        rect2.bottom = I(rect2.bottom, rect.bottom, rect.top);
        return new MeteringRectangle(rect2, 1000);
    }

    @NonNull
    private List<MeteringRectangle> x(@NonNull List<z1> list, int i10, @NonNull Rational rational, @NonNull Rect rect, int i11) {
        if (list.isEmpty() || i10 == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Rational rational2 = new Rational(rect.width(), rect.height());
        for (z1 next : list) {
            if (arrayList.size() == i10) {
                break;
            } else if (z(next)) {
                MeteringRectangle w10 = w(next, v(next, rational2, rational, i11, this.f1763f), rect);
                if (!(w10.getWidth() == 0 || w10.getHeight() == 0)) {
                    arrayList.add(w10);
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private boolean y() {
        return this.f1758a.G(1) == 1;
    }

    private static boolean z(@NonNull z1 z1Var) {
        return z1Var.c() >= 0.0f && z1Var.c() <= 1.0f && z1Var.d() >= 0.0f && z1Var.d() <= 1.0f;
    }

    /* access modifiers changed from: package-private */
    public void J(boolean z10) {
        if (z10 != this.f1761d) {
            this.f1761d = z10;
            if (!this.f1761d) {
                l();
            }
        }
    }

    public void K(Rational rational) {
        this.f1762e = rational;
    }

    /* access modifiers changed from: package-private */
    public void L(int i10) {
        this.f1771n = i10;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public zf.a<g0> N(@NonNull f0 f0Var) {
        return O(f0Var, 5000);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public zf.a<g0> O(@NonNull f0 f0Var, long j10) {
        return CallbackToFutureAdapter.a(new a2(this, f0Var, j10));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: P */
    public void G(@NonNull CallbackToFutureAdapter.a<g0> aVar, @NonNull f0 f0Var, long j10) {
        if (!this.f1761d) {
            aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
            return;
        }
        Rect x10 = this.f1758a.x();
        Rational u10 = u();
        Rational rational = u10;
        Rect rect = x10;
        List<MeteringRectangle> x11 = x(f0Var.c(), this.f1758a.B(), rational, rect, 1);
        List<MeteringRectangle> x12 = x(f0Var.b(), this.f1758a.A(), rational, rect, 2);
        List<MeteringRectangle> x13 = x(f0Var.d(), this.f1758a.C(), rational, rect, 4);
        if (!x11.isEmpty() || !x12.isEmpty() || !x13.isEmpty()) {
            r("Cancelled by another startFocusAndMetering()");
            s("Cancelled by another startFocusAndMetering()");
            p();
            this.f1777t = aVar;
            MeteringRectangle[] meteringRectangleArr = f1757v;
            q((MeteringRectangle[]) x11.toArray(meteringRectangleArr), (MeteringRectangle[]) x12.toArray(meteringRectangleArr), (MeteringRectangle[]) x13.toArray(meteringRectangleArr), f0Var, j10);
            return;
        }
        aVar.f(new IllegalArgumentException("None of the specified AF/AE/AWB MeteringPoints is supported on this camera."));
    }

    /* access modifiers changed from: package-private */
    public void Q(CallbackToFutureAdapter.a<Void> aVar) {
        if (this.f1761d) {
            d0.a aVar2 = new d0.a();
            aVar2.q(this.f1771n);
            aVar2.r(true);
            a.C0174a aVar3 = new a.C0174a();
            aVar3.e(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            aVar2.e(aVar3.c());
            aVar2.c(new b(aVar));
            this.f1758a.i0(Collections.singletonList(aVar2.h()));
        } else if (aVar != null) {
            aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
        }
    }

    /* access modifiers changed from: package-private */
    public void R(CallbackToFutureAdapter.a<p> aVar, boolean z10) {
        if (this.f1761d) {
            d0.a aVar2 = new d0.a();
            aVar2.q(this.f1771n);
            aVar2.r(true);
            a.C0174a aVar3 = new a.C0174a();
            aVar3.e(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            if (z10) {
                aVar3.e(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(this.f1758a.F(1)));
            }
            aVar2.e(aVar3.c());
            aVar2.c(new a(aVar));
            this.f1758a.i0(Collections.singletonList(aVar2.h()));
        } else if (aVar != null) {
            aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
        }
    }

    /* access modifiers changed from: package-private */
    public void i(@NonNull a.C0174a aVar) {
        int i10;
        if (this.f1764g) {
            i10 = 1;
        } else {
            i10 = t();
        }
        aVar.e(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(this.f1758a.G(i10)));
        MeteringRectangle[] meteringRectangleArr = this.f1774q;
        if (meteringRectangleArr.length != 0) {
            aVar.e(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
        }
        MeteringRectangle[] meteringRectangleArr2 = this.f1775r;
        if (meteringRectangleArr2.length != 0) {
            aVar.e(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr2);
        }
        MeteringRectangle[] meteringRectangleArr3 = this.f1776s;
        if (meteringRectangleArr3.length != 0) {
            aVar.e(CaptureRequest.CONTROL_AWB_REGIONS, meteringRectangleArr3);
        }
    }

    /* access modifiers changed from: package-private */
    public void j(boolean z10, boolean z11) {
        if (this.f1761d) {
            d0.a aVar = new d0.a();
            aVar.r(true);
            aVar.q(this.f1771n);
            a.C0174a aVar2 = new a.C0174a();
            if (z10) {
                aVar2.e(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            }
            if (z11) {
                aVar2.e(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
            }
            aVar.e(aVar2.c());
            this.f1758a.i0(Collections.singletonList(aVar.h()));
        }
    }

    /* access modifiers changed from: package-private */
    public void k(CallbackToFutureAdapter.a<Void> aVar) {
        s("Cancelled by another cancelFocusAndMetering()");
        r("Cancelled by cancelFocusAndMetering()");
        this.f1778u = aVar;
        p();
        m();
        if (M()) {
            j(true, false);
        }
        MeteringRectangle[] meteringRectangleArr = f1757v;
        this.f1774q = meteringRectangleArr;
        this.f1775r = meteringRectangleArr;
        this.f1776s = meteringRectangleArr;
        this.f1764g = false;
        long l02 = this.f1758a.l0();
        if (this.f1778u != null) {
            b2 b2Var = new b2(this, this.f1758a.G(t()), l02);
            this.f1773p = b2Var;
            this.f1758a.t(b2Var);
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        k((CallbackToFutureAdapter.a<Void>) null);
    }

    /* access modifiers changed from: package-private */
    public void n(boolean z10) {
        m();
        CallbackToFutureAdapter.a<g0> aVar = this.f1777t;
        if (aVar != null) {
            aVar.c(g0.a(z10));
            this.f1777t = null;
        }
    }

    /* access modifiers changed from: package-private */
    public int t() {
        return this.f1771n != 3 ? 4 : 3;
    }
}
