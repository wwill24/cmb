package coil.intercept;

import coil.b;
import coil.intercept.EngineInterceptor;
import coil.request.g;
import coil.request.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import q2.a;

@d(c = "coil.intercept.EngineInterceptor$transform$3", f = "EngineInterceptor.kt", l = {242}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/k0;", "Lcoil/intercept/EngineInterceptor$b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class EngineInterceptor$transform$3 extends SuspendLambda implements Function2<k0, c<? super EngineInterceptor.b>, Object> {
    final /* synthetic */ b $eventListener;
    final /* synthetic */ k $options;
    final /* synthetic */ g $request;
    final /* synthetic */ EngineInterceptor.b $result;
    final /* synthetic */ List<a> $transformations;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EngineInterceptor$transform$3(EngineInterceptor engineInterceptor, EngineInterceptor.b bVar, k kVar, List<? extends a> list, b bVar2, g gVar, c<? super EngineInterceptor$transform$3> cVar) {
        super(2, cVar);
        this.this$0 = engineInterceptor;
        this.$result = bVar;
        this.$options = kVar;
        this.$transformations = list;
        this.$eventListener = bVar2;
        this.$request = gVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        EngineInterceptor$transform$3 engineInterceptor$transform$3 = new EngineInterceptor$transform$3(this.this$0, this.$result, this.$options, this.$transformations, this.$eventListener, this.$request, cVar);
        engineInterceptor$transform$3.L$0 = obj;
        return engineInterceptor$transform$3;
    }

    public final Object invoke(k0 k0Var, c<? super EngineInterceptor.b> cVar) {
        return ((EngineInterceptor$transform$3) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            int r2 = r0.I$1
            int r4 = r0.I$0
            java.lang.Object r5 = r0.L$2
            coil.request.k r5 = (coil.request.k) r5
            java.lang.Object r6 = r0.L$1
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.k0 r7 = (kotlinx.coroutines.k0) r7
            gk.g.b(r20)
            r9 = r0
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r20
            goto L_0x0081
        L_0x0027:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x002f:
            gk.g.b(r20)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.k0 r2 = (kotlinx.coroutines.k0) r2
            coil.intercept.EngineInterceptor r4 = r0.this$0
            coil.intercept.EngineInterceptor$b r5 = r0.$result
            android.graphics.drawable.Drawable r5 = r5.e()
            coil.request.k r6 = r0.$options
            java.util.List<q2.a> r7 = r0.$transformations
            android.graphics.Bitmap r4 = r4.g(r5, r6, r7)
            coil.b r5 = r0.$eventListener
            coil.request.g r6 = r0.$request
            r5.k(r6, r4)
            java.util.List<q2.a> r5 = r0.$transformations
            coil.request.k r6 = r0.$options
            r7 = 0
            int r8 = r5.size()
            r9 = r0
            r17 = r8
            r8 = r2
            r2 = r17
            r18 = r5
            r5 = r4
            r4 = r7
            r7 = r18
        L_0x0062:
            if (r4 >= r2) goto L_0x0088
            java.lang.Object r10 = r7.get(r4)
            q2.a r10 = (q2.a) r10
            coil.size.g r11 = r6.o()
            r9.L$0 = r8
            r9.L$1 = r7
            r9.L$2 = r6
            r9.I$0 = r4
            r9.I$1 = r2
            r9.label = r3
            java.lang.Object r5 = r10.b(r5, r11, r9)
            if (r5 != r1) goto L_0x0081
            return r1
        L_0x0081:
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            kotlinx.coroutines.l0.h(r8)
            int r4 = r4 + r3
            goto L_0x0062
        L_0x0088:
            coil.b r1 = r9.$eventListener
            coil.request.g r2 = r9.$request
            r1.n(r2, r5)
            coil.intercept.EngineInterceptor$b r10 = r9.$result
            coil.request.g r1 = r9.$request
            android.content.Context r1 = r1.l()
            android.content.res.Resources r1 = r1.getResources()
            android.graphics.drawable.BitmapDrawable r11 = new android.graphics.drawable.BitmapDrawable
            r11.<init>(r1, r5)
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 14
            r16 = 0
            coil.intercept.EngineInterceptor$b r1 = coil.intercept.EngineInterceptor.b.b(r10, r11, r12, r13, r14, r15, r16)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor$transform$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
