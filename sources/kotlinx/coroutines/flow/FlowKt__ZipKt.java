package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.internal.CombineKt;
import pk.n;
import pk.p;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001al\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032(\u0010\b\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001an\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032(\u0010\b\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005ø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001a¢\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u000e\"\u0004\b\u0004\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00030\u000324\u0010\b\u001a0\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0011ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a#\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00160\u0015\"\u0004\b\u0000\u0010\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/flow/b;", "flow", "Lkotlin/Function3;", "Lkotlin/coroutines/c;", "", "transform", "d", "(Lkotlinx/coroutines/flow/b;Lkotlinx/coroutines/flow/b;Lpk/n;)Lkotlinx/coroutines/flow/b;", "flow2", "c", "T3", "T4", "flow3", "flow4", "Lkotlin/Function5;", "b", "(Lkotlinx/coroutines/flow/b;Lkotlinx/coroutines/flow/b;Lkotlinx/coroutines/flow/b;Lkotlinx/coroutines/flow/b;Lpk/p;)Lkotlinx/coroutines/flow/b;", "T", "Lkotlin/Function0;", "", "e", "()Lkotlin/jvm/functions/Function0;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ZipKt {

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__ZipKt$a", "Lkotlinx/coroutines/flow/b;", "Lkotlinx/coroutines/flow/c;", "collector", "", "a", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class a implements b<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f32406a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f32407b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n f32408c;

        public a(b bVar, b bVar2, n nVar) {
            this.f32406a = bVar;
            this.f32407b = bVar2;
            this.f32408c = nVar;
        }

        public Object a(c<? super R> cVar, c<? super Unit> cVar2) {
            Object a10 = CombineKt.a(cVar, new b[]{this.f32406a, this.f32407b}, FlowKt__ZipKt.e(), new FlowKt__ZipKt$combine$1$1(this.f32408c, (c<? super FlowKt__ZipKt$combine$1$1>) null), cVar2);
            if (a10 == b.d()) {
                return a10;
            }
            return Unit.f32013a;
        }
    }

    public static final <T1, T2, T3, T4, R> b<R> b(b<? extends T1> bVar, b<? extends T2> bVar2, b<? extends T3> bVar3, b<? extends T4> bVar4, p<? super T1, ? super T2, ? super T3, ? super T4, ? super c<? super R>, ? extends Object> pVar) {
        return new FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2(new b[]{bVar, bVar2, bVar3, bVar4}, pVar);
    }

    public static final <T1, T2, R> b<R> c(b<? extends T1> bVar, b<? extends T2> bVar2, n<? super T1, ? super T2, ? super c<? super R>, ? extends Object> nVar) {
        return d.w(bVar, bVar2, nVar);
    }

    public static final <T1, T2, R> b<R> d(b<? extends T1> bVar, b<? extends T2> bVar2, n<? super T1, ? super T2, ? super c<? super R>, ? extends Object> nVar) {
        return new a(bVar, bVar2, nVar);
    }

    /* access modifiers changed from: private */
    public static final <T> Function0<T[]> e() {
        return FlowKt__ZipKt$nullArrayFactory$1.f32409a;
    }
}
