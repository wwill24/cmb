package coil.request;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.l;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.s1;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcoil/request/BaseRequestDelegate;", "Lcoil/request/RequestDelegate;", "", "c", "b", "d", "Landroidx/lifecycle/l;", "owner", "onDestroy", "Landroidx/lifecycle/Lifecycle;", "a", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lkotlinx/coroutines/s1;", "Lkotlinx/coroutines/s1;", "job", "<init>", "(Landroidx/lifecycle/Lifecycle;Lkotlinx/coroutines/s1;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class BaseRequestDelegate extends RequestDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final Lifecycle f8254a;

    /* renamed from: b  reason: collision with root package name */
    private final s1 f8255b;

    public BaseRequestDelegate(Lifecycle lifecycle, s1 s1Var) {
        super((DefaultConstructorMarker) null);
        this.f8254a = lifecycle;
        this.f8255b = s1Var;
    }

    public void b() {
        this.f8254a.d(this);
    }

    public void c() {
        this.f8254a.a(this);
    }

    public void d() {
        s1.a.a(this.f8255b, (CancellationException) null, 1, (Object) null);
    }

    public void onDestroy(l lVar) {
        d();
    }
}
