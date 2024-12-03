package coil.request;

import android.view.View;
import coil.util.j;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.l1;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0017J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0017R\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcoil/request/ViewTargetRequestManager;", "Landroid/view/View$OnAttachStateChangeListener;", "Lkotlinx/coroutines/p0;", "Lcoil/request/h;", "job", "Lcoil/request/q;", "b", "", "a", "Lcoil/request/ViewTargetRequestDelegate;", "request", "c", "Landroid/view/View;", "v", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Landroid/view/View;", "view", "Lcoil/request/q;", "currentDisposable", "Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/s1;", "pendingClear", "d", "Lcoil/request/ViewTargetRequestDelegate;", "currentRequest", "", "e", "Z", "isRestart", "<init>", "(Landroid/view/View;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class ViewTargetRequestManager implements View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f8266a;

    /* renamed from: b  reason: collision with root package name */
    private q f8267b;

    /* renamed from: c  reason: collision with root package name */
    private s1 f8268c;

    /* renamed from: d  reason: collision with root package name */
    private ViewTargetRequestDelegate f8269d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8270e;

    public ViewTargetRequestManager(View view) {
        this.f8266a = view;
    }

    public final synchronized void a() {
        s1 s1Var = this.f8268c;
        if (s1Var != null) {
            s1.a.a(s1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f8268c = j.d(l1.f32580a, x0.c().Y(), (CoroutineStart) null, new ViewTargetRequestManager$dispose$1(this, (c<? super ViewTargetRequestManager$dispose$1>) null), 2, (Object) null);
        this.f8267b = null;
    }

    public final synchronized q b(p0<? extends h> p0Var) {
        q qVar = this.f8267b;
        if (qVar == null || !j.s() || !this.f8270e) {
            s1 s1Var = this.f8268c;
            if (s1Var != null) {
                s1.a.a(s1Var, (CancellationException) null, 1, (Object) null);
            }
            this.f8268c = null;
            q qVar2 = new q(this.f8266a, p0Var);
            this.f8267b = qVar2;
            return qVar2;
        }
        this.f8270e = false;
        qVar.a(p0Var);
        return qVar;
    }

    public final void c(ViewTargetRequestDelegate viewTargetRequestDelegate) {
        ViewTargetRequestDelegate viewTargetRequestDelegate2 = this.f8269d;
        if (viewTargetRequestDelegate2 != null) {
            viewTargetRequestDelegate2.d();
        }
        this.f8269d = viewTargetRequestDelegate;
    }

    public void onViewAttachedToWindow(View view) {
        ViewTargetRequestDelegate viewTargetRequestDelegate = this.f8269d;
        if (viewTargetRequestDelegate != null) {
            this.f8270e = true;
            viewTargetRequestDelegate.f();
        }
    }

    public void onViewDetachedFromWindow(View view) {
        ViewTargetRequestDelegate viewTargetRequestDelegate = this.f8269d;
        if (viewTargetRequestDelegate != null) {
            viewTargetRequestDelegate.d();
        }
    }
}
