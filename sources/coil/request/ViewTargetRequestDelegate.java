package coil.request;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import coil.ImageLoader;
import coil.util.Lifecycles;
import coil.util.j;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.s1;
import p2.b;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcoil/request/ViewTargetRequestDelegate;", "Lcoil/request/RequestDelegate;", "", "f", "a", "c", "d", "Landroidx/lifecycle/l;", "owner", "onDestroy", "Lcoil/ImageLoader;", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/request/g;", "b", "Lcoil/request/g;", "initialRequest", "Lp2/b;", "Lp2/b;", "target", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lkotlinx/coroutines/s1;", "e", "Lkotlinx/coroutines/s1;", "job", "<init>", "(Lcoil/ImageLoader;Lcoil/request/g;Lp2/b;Landroidx/lifecycle/Lifecycle;Lkotlinx/coroutines/s1;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class ViewTargetRequestDelegate extends RequestDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final ImageLoader f8261a;

    /* renamed from: b  reason: collision with root package name */
    private final g f8262b;

    /* renamed from: c  reason: collision with root package name */
    private final b<?> f8263c;

    /* renamed from: d  reason: collision with root package name */
    private final Lifecycle f8264d;

    /* renamed from: e  reason: collision with root package name */
    private final s1 f8265e;

    public ViewTargetRequestDelegate(ImageLoader imageLoader, g gVar, b<?> bVar, Lifecycle lifecycle, s1 s1Var) {
        super((DefaultConstructorMarker) null);
        this.f8261a = imageLoader;
        this.f8262b = gVar;
        this.f8263c = bVar;
        this.f8264d = lifecycle;
        this.f8265e = s1Var;
    }

    public void a() {
        if (!this.f8263c.getView().isAttachedToWindow()) {
            j.m(this.f8263c.getView()).c(this);
            throw new CancellationException("'ViewTarget.view' must be attached to a window.");
        }
    }

    public void c() {
        this.f8264d.a(this);
        b<?> bVar = this.f8263c;
        if (bVar instanceof k) {
            Lifecycles.b(this.f8264d, (k) bVar);
        }
        j.m(this.f8263c.getView()).c(this);
    }

    public void d() {
        s1.a.a(this.f8265e, (CancellationException) null, 1, (Object) null);
        b<?> bVar = this.f8263c;
        if (bVar instanceof k) {
            this.f8264d.d((k) bVar);
        }
        this.f8264d.d(this);
    }

    public final void f() {
        this.f8261a.a(this.f8262b);
    }

    public void onDestroy(l lVar) {
        j.m(this.f8263c.getView()).a();
    }
}
