package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.channels.o;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.m;
import kotlinx.coroutines.l0;
import rn.a;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B3\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\"\u0010#J!\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J!\u0010\u0013\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\bJ!\u0010\u0016\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010!\u001a\u00020\u001c8BX\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lkotlinx/coroutines/reactive/PublisherAsFlow;", "", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/c;", "collector", "", "q", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "injectContext", "p", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "j", "a", "Lkotlinx/coroutines/channels/o;", "scope", "i", "(Lkotlinx/coroutines/channels/o;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lrn/a;", "d", "Lrn/a;", "publisher", "", "r", "()J", "getRequestSize$annotations", "()V", "requestSize", "<init>", "(Lrn/a;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 6, 0})
final class PublisherAsFlow<T> extends ChannelFlow<T> {

    /* renamed from: d  reason: collision with root package name */
    private final a<T> f32605d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PublisherAsFlow(a aVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i11 & 2) != 0 ? EmptyCoroutineContext.f32070a : coroutineContext, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d A[SYNTHETIC, Splitter:B:29:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c1 A[Catch:{ all -> 0x005c }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object p(kotlin.coroutines.CoroutineContext r18, kotlinx.coroutines.flow.c<? super T> r19, kotlin.coroutines.c<? super kotlin.Unit> r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            boolean r2 = r0 instanceof kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1 r2 = (kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1 r2 = new kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.b.d()
            int r4 = r2.label
            r5 = 0
            r7 = 2
            r8 = 1
            if (r4 == 0) goto L_0x005f
            if (r4 == r8) goto L_0x004a
            if (r4 != r7) goto L_0x0042
            long r9 = r2.J$0
            java.lang.Object r4 = r2.L$2
            kotlinx.coroutines.reactive.ReactiveSubscriber r4 = (kotlinx.coroutines.reactive.ReactiveSubscriber) r4
            java.lang.Object r11 = r2.L$1
            kotlinx.coroutines.flow.c r11 = (kotlinx.coroutines.flow.c) r11
            java.lang.Object r12 = r2.L$0
            kotlinx.coroutines.reactive.PublisherAsFlow r12 = (kotlinx.coroutines.reactive.PublisherAsFlow) r12
            gk.g.b(r0)     // Catch:{ all -> 0x005c }
        L_0x003f:
            r0 = r11
            goto L_0x00b5
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004a:
            long r9 = r2.J$0
            java.lang.Object r4 = r2.L$2
            kotlinx.coroutines.reactive.ReactiveSubscriber r4 = (kotlinx.coroutines.reactive.ReactiveSubscriber) r4
            java.lang.Object r11 = r2.L$1
            kotlinx.coroutines.flow.c r11 = (kotlinx.coroutines.flow.c) r11
            java.lang.Object r12 = r2.L$0
            kotlinx.coroutines.reactive.PublisherAsFlow r12 = (kotlinx.coroutines.reactive.PublisherAsFlow) r12
            gk.g.b(r0)     // Catch:{ all -> 0x005c }
            goto L_0x0095
        L_0x005c:
            r0 = move-exception
            goto L_0x00c7
        L_0x005f:
            gk.g.b(r0)
            kotlinx.coroutines.reactive.ReactiveSubscriber r0 = new kotlinx.coroutines.reactive.ReactiveSubscriber
            int r4 = r1.f32436b
            kotlinx.coroutines.channels.BufferOverflow r9 = r1.f32437c
            long r10 = r17.r()
            r0.<init>(r4, r9, r10)
            rn.a<T> r4 = r1.f32605d
            r9 = r18
            rn.a r4 = kotlinx.coroutines.reactive.c.b(r4, r9)
            r4.a(r0)
            r4 = r0
            r9 = r1
            r10 = r5
            r0 = r19
        L_0x007f:
            r2.L$0 = r9     // Catch:{ all -> 0x005c }
            r2.L$1 = r0     // Catch:{ all -> 0x005c }
            r2.L$2 = r4     // Catch:{ all -> 0x005c }
            r2.J$0 = r10     // Catch:{ all -> 0x005c }
            r2.label = r8     // Catch:{ all -> 0x005c }
            java.lang.Object r12 = r4.c(r2)     // Catch:{ all -> 0x005c }
            if (r12 != r3) goto L_0x0090
            return r3
        L_0x0090:
            r15 = r10
            r11 = r0
            r0 = r12
            r12 = r9
            r9 = r15
        L_0x0095:
            if (r0 != 0) goto L_0x009d
            r4.a()
            kotlin.Unit r0 = kotlin.Unit.f32013a
            return r0
        L_0x009d:
            kotlin.coroutines.CoroutineContext r13 = r2.getContext()     // Catch:{ all -> 0x005c }
            kotlinx.coroutines.v1.i(r13)     // Catch:{ all -> 0x005c }
            r2.L$0 = r12     // Catch:{ all -> 0x005c }
            r2.L$1 = r11     // Catch:{ all -> 0x005c }
            r2.L$2 = r4     // Catch:{ all -> 0x005c }
            r2.J$0 = r9     // Catch:{ all -> 0x005c }
            r2.label = r7     // Catch:{ all -> 0x005c }
            java.lang.Object r0 = r11.c(r0, r2)     // Catch:{ all -> 0x005c }
            if (r0 != r3) goto L_0x003f
            return r3
        L_0x00b5:
            r13 = 1
            long r10 = r9 + r13
            long r13 = r12.r()     // Catch:{ all -> 0x005c }
            int r9 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r9 != 0) goto L_0x00c5
            r4.b()     // Catch:{ all -> 0x005c }
            r10 = r5
        L_0x00c5:
            r9 = r12
            goto L_0x007f
        L_0x00c7:
            r4.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.PublisherAsFlow.p(kotlin.coroutines.CoroutineContext, kotlinx.coroutines.flow.c, kotlin.coroutines.c):java.lang.Object");
    }

    private final Object q(c<? super T> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        Object g10 = l0.g(new PublisherAsFlow$collectSlowPath$2(cVar, this, (kotlin.coroutines.c<? super PublisherAsFlow$collectSlowPath$2>) null), cVar2);
        return g10 == b.d() ? g10 : Unit.f32013a;
    }

    private final long r() {
        boolean z10;
        if (this.f32437c == BufferOverflow.SUSPEND) {
            int i10 = this.f32436b;
            if (i10 == -2) {
                return (long) d.A.a();
            }
            if (i10 == 0) {
                return 1;
            }
            if (i10 != Integer.MAX_VALUE) {
                long j10 = (long) i10;
                if (j10 >= 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    return j10;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        return Long.MAX_VALUE;
    }

    public Object a(c<? super T> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        CoroutineContext context = cVar2.getContext();
        CoroutineContext coroutineContext = this.f32435a;
        d.b bVar = kotlin.coroutines.d.f32074s;
        kotlin.coroutines.d dVar = (kotlin.coroutines.d) coroutineContext.c(bVar);
        if (dVar == null || j.b(dVar, context.c(bVar))) {
            Object p10 = p(context.e0(this.f32435a), cVar, cVar2);
            if (p10 == b.d()) {
                return p10;
            }
            return Unit.f32013a;
        }
        Object q10 = q(cVar, cVar2);
        if (q10 == b.d()) {
            return q10;
        }
        return Unit.f32013a;
    }

    /* access modifiers changed from: protected */
    public Object i(o<? super T> oVar, kotlin.coroutines.c<? super Unit> cVar) {
        Object p10 = p(oVar.G(), new m(oVar.k()), cVar);
        return p10 == b.d() ? p10 : Unit.f32013a;
    }

    /* access modifiers changed from: protected */
    public ChannelFlow<T> j(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        return new PublisherAsFlow(this.f32605d, coroutineContext, i10, bufferOverflow);
    }

    public PublisherAsFlow(a<T> aVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        super(coroutineContext, i10, bufferOverflow);
        this.f32605d = aVar;
    }
}
