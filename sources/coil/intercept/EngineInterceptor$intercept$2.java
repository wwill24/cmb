package coil.intercept;

import android.graphics.drawable.Drawable;
import coil.b;
import coil.decode.DataSource;
import coil.intercept.EngineInterceptor;
import coil.intercept.a;
import coil.memory.MemoryCache;
import coil.request.g;
import coil.request.k;
import coil.request.n;
import coil.util.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "coil.intercept.EngineInterceptor$intercept$2", f = "EngineInterceptor.kt", l = {75}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/k0;", "Lcoil/request/n;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class EngineInterceptor$intercept$2 extends SuspendLambda implements Function2<k0, c<? super n>, Object> {
    final /* synthetic */ MemoryCache.Key $cacheKey;
    final /* synthetic */ a.C0104a $chain;
    final /* synthetic */ b $eventListener;
    final /* synthetic */ Object $mappedData;
    final /* synthetic */ k $options;
    final /* synthetic */ g $request;
    int label;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EngineInterceptor$intercept$2(EngineInterceptor engineInterceptor, g gVar, Object obj, k kVar, b bVar, MemoryCache.Key key, a.C0104a aVar, c<? super EngineInterceptor$intercept$2> cVar) {
        super(2, cVar);
        this.this$0 = engineInterceptor;
        this.$request = gVar;
        this.$mappedData = obj;
        this.$options = kVar;
        this.$eventListener = bVar;
        this.$cacheKey = key;
        this.$chain = aVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new EngineInterceptor$intercept$2(this.this$0, this.$request, this.$mappedData, this.$options, this.$eventListener, this.$cacheKey, this.$chain, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super n> cVar) {
        return ((EngineInterceptor$intercept$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        MemoryCache.Key key;
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            gk.g.b(obj);
            EngineInterceptor engineInterceptor = this.this$0;
            g gVar = this.$request;
            Object obj2 = this.$mappedData;
            k kVar = this.$options;
            b bVar = this.$eventListener;
            this.label = 1;
            obj = engineInterceptor.i(gVar, obj2, kVar, bVar, this);
            if (obj == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            gk.g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        EngineInterceptor.b bVar2 = (EngineInterceptor.b) obj;
        boolean h10 = this.this$0.f8208d.h(this.$cacheKey, this.$request, bVar2);
        Drawable e10 = bVar2.e();
        g gVar2 = this.$request;
        DataSource c10 = bVar2.c();
        MemoryCache.Key key2 = this.$cacheKey;
        if (h10) {
            key = key2;
        } else {
            key = null;
        }
        return new n(e10, gVar2, c10, key, bVar2.d(), bVar2.f(), j.u(this.$chain));
    }
}
