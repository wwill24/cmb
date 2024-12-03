package coil.intercept;

import coil.a;
import coil.b;
import coil.fetch.h;
import coil.fetch.l;
import coil.intercept.EngineInterceptor;
import coil.request.g;
import coil.request.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.k0;

@d(c = "coil.intercept.EngineInterceptor$execute$executeResult$1", f = "EngineInterceptor.kt", l = {127}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/k0;", "Lcoil/intercept/EngineInterceptor$b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class EngineInterceptor$execute$executeResult$1 extends SuspendLambda implements Function2<k0, c<? super EngineInterceptor.b>, Object> {
    final /* synthetic */ Ref$ObjectRef<a> $components;
    final /* synthetic */ b $eventListener;
    final /* synthetic */ Ref$ObjectRef<h> $fetchResult;
    final /* synthetic */ Object $mappedData;
    final /* synthetic */ Ref$ObjectRef<k> $options;
    final /* synthetic */ g $request;
    int label;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EngineInterceptor$execute$executeResult$1(EngineInterceptor engineInterceptor, Ref$ObjectRef<h> ref$ObjectRef, Ref$ObjectRef<a> ref$ObjectRef2, g gVar, Object obj, Ref$ObjectRef<k> ref$ObjectRef3, b bVar, c<? super EngineInterceptor$execute$executeResult$1> cVar) {
        super(2, cVar);
        this.this$0 = engineInterceptor;
        this.$fetchResult = ref$ObjectRef;
        this.$components = ref$ObjectRef2;
        this.$request = gVar;
        this.$mappedData = obj;
        this.$options = ref$ObjectRef3;
        this.$eventListener = bVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new EngineInterceptor$execute$executeResult$1(this.this$0, this.$fetchResult, this.$components, this.$request, this.$mappedData, this.$options, this.$eventListener, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super EngineInterceptor.b> cVar) {
        return ((EngineInterceptor$execute$executeResult$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            gk.g.b(obj);
            EngineInterceptor engineInterceptor = this.this$0;
            b bVar = this.$eventListener;
            this.label = 1;
            obj = engineInterceptor.h((l) this.$fetchResult.element, (a) this.$components.element, this.$request, this.$mappedData, (k) this.$options.element, bVar, this);
            if (obj == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            gk.g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
