package kotlinx.coroutines.rx2;

import androidx.camera.view.h;
import gk.g;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.o;
import kotlinx.coroutines.channels.u;
import qj.s;
import qj.u;
import tj.b;

@d(c = "kotlinx.coroutines.rx2.RxConvertKt$asFlow$1", f = "RxConvert.kt", l = {95}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H@"}, d2 = {"", "T", "Lkotlinx/coroutines/channels/o;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class RxConvertKt$asFlow$1 extends SuspendLambda implements Function2<o<? super T>, c<? super Unit>, Object> {
    final /* synthetic */ s<T> $this_asFlow;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"kotlinx/coroutines/rx2/RxConvertKt$asFlow$1$a", "Lqj/u;", "", "onComplete", "Ltj/b;", "d", "a", "t", "(Ljava/lang/Object;)V", "", "e", "onError", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0})
    public static final class a implements u<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o<T> f32615a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicReference<b> f32616b;

        a(o<? super T> oVar, AtomicReference<b> atomicReference) {
            this.f32615a = oVar;
            this.f32616b = atomicReference;
        }

        public void a(b bVar) {
            if (!h.a(this.f32616b, (Object) null, bVar)) {
                bVar.dispose();
            }
        }

        public void d(T t10) {
            try {
                i.b(this.f32615a, t10);
            } catch (InterruptedException unused) {
            }
        }

        public void onComplete() {
            u.a.a(this.f32615a, (Throwable) null, 1, (Object) null);
        }

        public void onError(Throwable th2) {
            this.f32615a.F(th2);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RxConvertKt$asFlow$1(s<T> sVar, c<? super RxConvertKt$asFlow$1> cVar) {
        super(2, cVar);
        this.$this_asFlow = sVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        RxConvertKt$asFlow$1 rxConvertKt$asFlow$1 = new RxConvertKt$asFlow$1(this.$this_asFlow, cVar);
        rxConvertKt$asFlow$1.L$0 = obj;
        return rxConvertKt$asFlow$1;
    }

    /* renamed from: i */
    public final Object invoke(o<? super T> oVar, c<? super Unit> cVar) {
        return ((RxConvertKt$asFlow$1) create(oVar, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            o oVar = (o) this.L$0;
            final AtomicReference atomicReference = new AtomicReference();
            this.$this_asFlow.e(new a(oVar, atomicReference));
            AnonymousClass1 r32 = new Function0<Unit>() {
                public final void invoke() {
                    b andSet = atomicReference.getAndSet(io.reactivex.disposables.a.a());
                    if (andSet != null) {
                        andSet.dispose();
                    }
                }
            };
            this.label = 1;
            if (ProduceKt.a(oVar, r32, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
