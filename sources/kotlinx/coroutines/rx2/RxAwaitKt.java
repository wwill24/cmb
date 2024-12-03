package kotlinx.coroutines.rx2;

import gk.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import qj.b0;
import qj.d;
import qj.f;
import qj.z;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a#\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\u000b\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\n\u001a\u00020\tH\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lqj/f;", "", "a", "(Lqj/f;Lkotlin/coroutines/c;)Ljava/lang/Object;", "T", "Lqj/b0;", "b", "(Lqj/b0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/n;", "Ltj/b;", "d", "c", "kotlinx-coroutines-rx2"}, k = 2, mv = {1, 6, 0})
public final class RxAwaitKt {

    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"kotlinx/coroutines/rx2/RxAwaitKt$a", "Lqj/d;", "Ltj/b;", "d", "", "a", "onComplete", "", "e", "onError", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0})
    public static final class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n<Unit> f32613a;

        a(n<? super Unit> nVar) {
            this.f32613a = nVar;
        }

        public void a(tj.b bVar) {
            RxAwaitKt.c(this.f32613a, bVar);
        }

        public void onComplete() {
            n<Unit> nVar = this.f32613a;
            Result.a aVar = Result.f32010a;
            nVar.resumeWith(Result.b(Unit.f32013a));
        }

        public void onError(Throwable th2) {
            n<Unit> nVar = this.f32613a;
            Result.a aVar = Result.f32010a;
            nVar.resumeWith(Result.b(g.a(th2)));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"kotlinx/coroutines/rx2/RxAwaitKt$b", "Lqj/z;", "Ltj/b;", "d", "", "a", "t", "onSuccess", "(Ljava/lang/Object;)V", "", "error", "onError", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0})
    public static final class b implements z<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n<T> f32614a;

        b(n<? super T> nVar) {
            this.f32614a = nVar;
        }

        public void a(tj.b bVar) {
            RxAwaitKt.c(this.f32614a, bVar);
        }

        public void onError(Throwable th2) {
            n<T> nVar = this.f32614a;
            Result.a aVar = Result.f32010a;
            nVar.resumeWith(Result.b(g.a(th2)));
        }

        public void onSuccess(T t10) {
            this.f32614a.resumeWith(Result.b(t10));
        }
    }

    public static final Object a(f fVar, c<? super Unit> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        oVar.y();
        fVar.e(new a(oVar));
        Object v10 = oVar.v();
        if (v10 == b.d()) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        if (v10 == b.d()) {
            return v10;
        }
        return Unit.f32013a;
    }

    public static final <T> Object b(b0<T> b0Var, c<? super T> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        oVar.y();
        b0Var.f(new b(oVar));
        Object v10 = oVar.v();
        if (v10 == b.d()) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return v10;
    }

    public static final void c(n<?> nVar, tj.b bVar) {
        nVar.o(new RxAwaitKt$disposeOnCancellation$1(bVar));
    }
}
