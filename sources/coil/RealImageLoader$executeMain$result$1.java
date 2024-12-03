package coil;

import android.graphics.Bitmap;
import coil.intercept.RealInterceptorChain;
import coil.request.g;
import coil.request.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "coil.RealImageLoader$executeMain$result$1", f = "RealImageLoader.kt", l = {193}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/k0;", "Lcoil/request/h;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class RealImageLoader$executeMain$result$1 extends SuspendLambda implements Function2<k0, c<? super h>, Object> {
    final /* synthetic */ b $eventListener;
    final /* synthetic */ Bitmap $placeholderBitmap;
    final /* synthetic */ g $request;
    final /* synthetic */ coil.size.g $size;
    int label;
    final /* synthetic */ RealImageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealImageLoader$executeMain$result$1(g gVar, RealImageLoader realImageLoader, coil.size.g gVar2, b bVar, Bitmap bitmap, c<? super RealImageLoader$executeMain$result$1> cVar) {
        super(2, cVar);
        this.$request = gVar;
        this.this$0 = realImageLoader;
        this.$size = gVar2;
        this.$eventListener = bVar;
        this.$placeholderBitmap = bitmap;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new RealImageLoader$executeMain$result$1(this.$request, this.this$0, this.$size, this.$eventListener, this.$placeholderBitmap, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super h> cVar) {
        return ((RealImageLoader$executeMain$result$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z10;
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            gk.g.b(obj);
            g gVar = this.$request;
            List d11 = this.this$0.f8047p;
            g gVar2 = this.$request;
            coil.size.g gVar3 = this.$size;
            b bVar = this.$eventListener;
            if (this.$placeholderBitmap != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            RealInterceptorChain realInterceptorChain = new RealInterceptorChain(gVar, d11, 0, gVar2, gVar3, bVar, z10);
            g gVar4 = this.$request;
            this.label = 1;
            obj = realInterceptorChain.g(gVar4, this);
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
