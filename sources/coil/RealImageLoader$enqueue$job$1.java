package coil;

import coil.request.g;
import coil.request.h;
import coil.util.s;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "coil.RealImageLoader$enqueue$job$1", f = "RealImageLoader.kt", l = {123}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/k0;", "Lcoil/request/h;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class RealImageLoader$enqueue$job$1 extends SuspendLambda implements Function2<k0, c<? super h>, Object> {
    final /* synthetic */ g $request;
    int label;
    final /* synthetic */ RealImageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealImageLoader$enqueue$job$1(RealImageLoader realImageLoader, g gVar, c<? super RealImageLoader$enqueue$job$1> cVar) {
        super(2, cVar);
        this.this$0 = realImageLoader;
        this.$request = gVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new RealImageLoader$enqueue$job$1(this.this$0, this.$request, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super h> cVar) {
        return ((RealImageLoader$enqueue$job$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        s g10;
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            gk.g.b(obj);
            RealImageLoader realImageLoader = this.this$0;
            g gVar = this.$request;
            this.label = 1;
            obj = realImageLoader.e(gVar, 0, this);
            if (obj == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            gk.g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        RealImageLoader realImageLoader2 = this.this$0;
        h hVar = (h) obj;
        if ((hVar instanceof coil.request.d) && (g10 = realImageLoader2.g()) != null) {
            coil.util.g.a(g10, "RealImageLoader", ((coil.request.d) hVar).c());
        }
        return obj;
    }
}
