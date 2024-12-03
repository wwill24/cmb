package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.internal.CombineKt;
import pk.n;
import pk.p;

@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/b;", "Lkotlinx/coroutines/flow/c;", "collector", "", "a", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2 implements b<R> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b[] f32404a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f32405b;

    @d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", l = {333, 333}, m = "invokeSuspend")
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/c;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n<c<? super R>, Object[], c<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* renamed from: i */
        public final Object l(c<? super R> cVar, Object[] objArr, c<? super Unit> cVar2) {
            AnonymousClass2 r02 = new AnonymousClass2(cVar2, pVar);
            r02.L$0 = cVar;
            r02.L$1 = objArr;
            return r02.invokeSuspend(Unit.f32013a);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.c} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0022
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                gk.g.b(r11)
                goto L_0x005a
            L_0x0012:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x001a:
                java.lang.Object r1 = r10.L$0
                kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
                gk.g.b(r11)
                goto L_0x004e
            L_0x0022:
                gk.g.b(r11)
                java.lang.Object r11 = r10.L$0
                r1 = r11
                kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
                java.lang.Object r11 = r10.L$1
                java.lang.Object[] r11 = (java.lang.Object[]) r11
                pk.p r4 = r3
                r5 = 0
                r5 = r11[r5]
                r6 = r11[r3]
                r7 = r11[r2]
                r8 = 3
                r8 = r11[r8]
                r10.L$0 = r1
                r10.label = r3
                r11 = 6
                kotlin.jvm.internal.h.c(r11)
                r9 = r10
                java.lang.Object r11 = r4.v(r5, r6, r7, r8, r9)
                r3 = 7
                kotlin.jvm.internal.h.c(r3)
                if (r11 != r0) goto L_0x004e
                return r0
            L_0x004e:
                r3 = 0
                r10.L$0 = r3
                r10.label = r2
                java.lang.Object r11 = r1.c(r11, r10)
                if (r11 != r0) goto L_0x005a
                return r0
            L_0x005a:
                kotlin.Unit r11 = kotlin.Unit.f32013a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2(b[] bVarArr, p pVar) {
        this.f32404a = bVarArr;
        this.f32405b = pVar;
    }

    public Object a(c cVar, c cVar2) {
        b[] bVarArr = this.f32404a;
        Function0 a10 = FlowKt__ZipKt.e();
        final p pVar = this.f32405b;
        Object a11 = CombineKt.a(cVar, bVarArr, a10, new AnonymousClass2((c) null), cVar2);
        if (a11 == b.d()) {
            return a11;
        }
        return Unit.f32013a;
    }
}
