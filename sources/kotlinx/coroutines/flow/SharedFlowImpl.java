package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.i;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.o;
import kotlinx.coroutines.q;
import kotlinx.coroutines.z0;

@Metadata(bv = {}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u00012B\u001f\u0012\u0006\u0010G\u001a\u00020\u0014\u0012\u0006\u0010I\u001a\u00020\u0014\u0012\u0006\u0010D\u001a\u00020C¢\u0006\u0004\bf\u0010gJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002J9\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00122\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J(\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\u0003H\u0002J\u0010\u0010&\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0003H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010'\u001a\u00020\rH\u0002J\u001b\u0010)\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b)\u0010*J3\u0010-\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010+0\u00122\u0014\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010+0\u0012H\u0002¢\u0006\u0004\b-\u0010.J!\u00102\u001a\u0002012\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/H@ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b4\u0010\nJ\u001b\u00105\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b5\u0010\u001aJ\u000f\u00106\u001a\u00020\rH\u0000¢\u0006\u0004\b6\u00107J%\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010+0\u00122\u0006\u00108\u001a\u00020\rH\u0000¢\u0006\u0004\b9\u0010:J\b\u0010;\u001a\u00020\u0003H\u0014J\u001f\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00122\u0006\u0010<\u001a\u00020\u0014H\u0014¢\u0006\u0004\b=\u0010>J\b\u0010?\u001a\u00020\u000bH\u0016J&\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000E2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u00142\u0006\u0010D\u001a\u00020CH\u0016R\u0014\u0010G\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010\u0011R\u0014\u0010I\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010\u0011R\u0014\u0010D\u001a\u00020C8\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR \u0010M\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010LR\u0016\u0010O\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010-R\u0016\u0010Q\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010-R\u0016\u0010S\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010\u0011R\u0016\u0010U\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010\u0011R\u0014\u0010W\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\bV\u00107R\u0014\u0010Z\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010\\\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010YR\u0014\u0010^\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b]\u00107R\u0014\u0010`\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b_\u00107R\u001a\u0010e\u001a\u00028\u00008DX\u0004¢\u0006\f\u0012\u0004\bc\u0010d\u001a\u0004\ba\u0010b\u0002\u0004\n\u0002\b\u0019¨\u0006h"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/a;", "Lkotlinx/coroutines/flow/n;", "Lkotlinx/coroutines/flow/h;", "", "Lkotlinx/coroutines/flow/internal/i;", "value", "", "S", "(Ljava/lang/Object;)Z", "", "F", "", "newHead", "C", "item", "I", "", "curBuffer", "", "curSize", "newSize", "R", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "H", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/SharedFlowImpl$a;", "emitter", "z", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "W", "A", "slot", "V", "U", "index", "N", "y", "(Lkotlinx/coroutines/flow/n;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/c;", "resumesIn", "J", "([Lkotlin/coroutines/c;)[Lkotlin/coroutines/c;", "Lkotlinx/coroutines/flow/c;", "collector", "", "a", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "e", "c", "Y", "()J", "oldIndex", "X", "(J)[Lkotlin/coroutines/c;", "D", "size", "E", "(I)[Lkotlinx/coroutines/flow/n;", "h", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/b;", "d", "replay", "f", "bufferCapacity", "g", "Lkotlinx/coroutines/channels/BufferOverflow;", "[Ljava/lang/Object;", "buffer", "j", "replayIndex", "k", "minCollectorIndex", "l", "bufferSize", "m", "queueSize", "L", "head", "P", "()I", "replaySize", "Q", "totalSize", "K", "bufferEndIndex", "O", "queueEndIndex", "M", "()Ljava/lang/Object;", "getLastReplayedLocked$annotations", "()V", "lastReplayedLocked", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class SharedFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<n> implements h<T>, b, i<T> {

    /* renamed from: e  reason: collision with root package name */
    private final int f32410e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final int f32411f;

    /* renamed from: g  reason: collision with root package name */
    private final BufferOverflow f32412g;

    /* renamed from: h  reason: collision with root package name */
    private Object[] f32413h;

    /* renamed from: j  reason: collision with root package name */
    private long f32414j;

    /* renamed from: k  reason: collision with root package name */
    private long f32415k;

    /* renamed from: l  reason: collision with root package name */
    private int f32416l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f32417m;

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$a;", "Lkotlinx/coroutines/z0;", "", "dispose", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "a", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "flow", "", "b", "J", "index", "", "c", "Ljava/lang/Object;", "value", "Lkotlin/coroutines/c;", "d", "Lkotlin/coroutines/c;", "cont", "<init>", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class a implements z0 {

        /* renamed from: a  reason: collision with root package name */
        public final SharedFlowImpl<?> f32418a;

        /* renamed from: b  reason: collision with root package name */
        public long f32419b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f32420c;

        /* renamed from: d  reason: collision with root package name */
        public final c<Unit> f32421d;

        public a(SharedFlowImpl<?> sharedFlowImpl, long j10, Object obj, c<? super Unit> cVar) {
            this.f32418a = sharedFlowImpl;
            this.f32419b = j10;
            this.f32420c = obj;
            this.f32421d = cVar;
        }

        public void dispose() {
            this.f32418a.z(this);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32422a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            f32422a = iArr;
        }
    }

    public SharedFlowImpl(int i10, int i11, BufferOverflow bufferOverflow) {
        this.f32410e = i10;
        this.f32411f = i11;
        this.f32412g = bufferOverflow;
    }

    private final void A() {
        if (this.f32411f != 0 || this.f32417m > 1) {
            Object[] objArr = this.f32413h;
            j.d(objArr);
            while (this.f32417m > 0 && m.f(objArr, (L() + ((long) Q())) - 1) == m.f32473a) {
                this.f32417m--;
                m.g(objArr, L() + ((long) Q()), (Object) null);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: kotlinx.coroutines.flow.n} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ab A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bc A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object B(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.c r9, kotlin.coroutines.c r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.SharedFlowImpl$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0075
            if (r2 == r5) goto L_0x005e
            if (r2 == r4) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.s1 r8 = (kotlinx.coroutines.s1) r8
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.flow.n r9 = (kotlinx.coroutines.flow.n) r9
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.c r2 = (kotlinx.coroutines.flow.c) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r5 = (kotlinx.coroutines.flow.SharedFlowImpl) r5
            goto L_0x0054
        L_0x003c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0044:
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.s1 r8 = (kotlinx.coroutines.s1) r8
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.flow.n r9 = (kotlinx.coroutines.flow.n) r9
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.c r2 = (kotlinx.coroutines.flow.c) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r5 = (kotlinx.coroutines.flow.SharedFlowImpl) r5
        L_0x0054:
            gk.g.b(r10)     // Catch:{ all -> 0x005b }
            r10 = r2
            r2 = r8
            r8 = r5
            goto L_0x00a3
        L_0x005b:
            r8 = move-exception
            goto L_0x00da
        L_0x005e:
            java.lang.Object r8 = r0.L$2
            r9 = r8
            kotlinx.coroutines.flow.n r9 = (kotlinx.coroutines.flow.n) r9
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.flow.c r8 = (kotlinx.coroutines.flow.c) r8
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r2 = (kotlinx.coroutines.flow.SharedFlowImpl) r2
            gk.g.b(r10)     // Catch:{ all -> 0x0071 }
            r10 = r8
            r8 = r2
            goto L_0x0097
        L_0x0071:
            r8 = move-exception
            r5 = r2
            goto L_0x00da
        L_0x0075:
            gk.g.b(r10)
            kotlinx.coroutines.flow.internal.c r10 = r8.i()
            kotlinx.coroutines.flow.n r10 = (kotlinx.coroutines.flow.n) r10
            boolean r2 = r9 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x00d6 }
            if (r2 == 0) goto L_0x0094
            r2 = r9
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r2     // Catch:{ all -> 0x00d6 }
            r0.L$0 = r8     // Catch:{ all -> 0x00d6 }
            r0.L$1 = r9     // Catch:{ all -> 0x00d6 }
            r0.L$2 = r10     // Catch:{ all -> 0x00d6 }
            r0.label = r5     // Catch:{ all -> 0x00d6 }
            java.lang.Object r2 = r2.a(r0)     // Catch:{ all -> 0x00d6 }
            if (r2 != r1) goto L_0x0094
            return r1
        L_0x0094:
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0097:
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()     // Catch:{ all -> 0x00d2 }
            kotlinx.coroutines.s1$b r5 = kotlinx.coroutines.s1.f32618v     // Catch:{ all -> 0x00d2 }
            kotlin.coroutines.CoroutineContext$Element r2 = r2.c(r5)     // Catch:{ all -> 0x00d2 }
            kotlinx.coroutines.s1 r2 = (kotlinx.coroutines.s1) r2     // Catch:{ all -> 0x00d2 }
        L_0x00a3:
            java.lang.Object r5 = r8.V(r9)     // Catch:{ all -> 0x00d2 }
            kotlinx.coroutines.internal.f0 r6 = kotlinx.coroutines.flow.m.f32473a     // Catch:{ all -> 0x00d2 }
            if (r5 != r6) goto L_0x00bc
            r0.L$0 = r8     // Catch:{ all -> 0x00d2 }
            r0.L$1 = r10     // Catch:{ all -> 0x00d2 }
            r0.L$2 = r9     // Catch:{ all -> 0x00d2 }
            r0.L$3 = r2     // Catch:{ all -> 0x00d2 }
            r0.label = r4     // Catch:{ all -> 0x00d2 }
            java.lang.Object r5 = r8.y(r9, r0)     // Catch:{ all -> 0x00d2 }
            if (r5 != r1) goto L_0x00a3
            return r1
        L_0x00bc:
            if (r2 == 0) goto L_0x00c1
            kotlinx.coroutines.v1.j(r2)     // Catch:{ all -> 0x00d2 }
        L_0x00c1:
            r0.L$0 = r8     // Catch:{ all -> 0x00d2 }
            r0.L$1 = r10     // Catch:{ all -> 0x00d2 }
            r0.L$2 = r9     // Catch:{ all -> 0x00d2 }
            r0.L$3 = r2     // Catch:{ all -> 0x00d2 }
            r0.label = r3     // Catch:{ all -> 0x00d2 }
            java.lang.Object r5 = r10.c(r5, r0)     // Catch:{ all -> 0x00d2 }
            if (r5 != r1) goto L_0x00a3
            return r1
        L_0x00d2:
            r10 = move-exception
            r5 = r8
            r8 = r10
            goto L_0x00da
        L_0x00d6:
            r9 = move-exception
            r5 = r8
            r8 = r9
            r9 = r10
        L_0x00da:
            r5.l(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.B(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.c, kotlin.coroutines.c):java.lang.Object");
    }

    private final void C(long j10) {
        kotlinx.coroutines.flow.internal.c[] g10;
        if (!(this.f32455b == 0 || (g10 = this.f32454a) == null)) {
            for (kotlinx.coroutines.flow.internal.c cVar : g10) {
                if (cVar != null) {
                    n nVar = (n) cVar;
                    long j11 = nVar.f32474a;
                    if (j11 >= 0 && j11 < j10) {
                        nVar.f32474a = j10;
                    }
                }
            }
        }
        this.f32415k = j10;
    }

    private final void F() {
        Object[] objArr = this.f32413h;
        j.d(objArr);
        m.g(objArr, L(), (Object) null);
        this.f32416l--;
        long L = L() + 1;
        if (this.f32414j < L) {
            this.f32414j = L;
        }
        if (this.f32415k < L) {
            C(L);
        }
    }

    static /* synthetic */ Object G(SharedFlowImpl sharedFlowImpl, Object obj, c cVar) {
        if (sharedFlowImpl.e(obj)) {
            return Unit.f32013a;
        }
        Object H = sharedFlowImpl.H(obj, cVar);
        if (H == b.d()) {
            return H;
        }
        return Unit.f32013a;
    }

    private final Object H(T t10, c<? super Unit> cVar) {
        c<Unit>[] cVarArr;
        a aVar;
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        oVar.y();
        c<Unit>[] cVarArr2 = kotlinx.coroutines.flow.internal.b.f32458a;
        synchronized (this) {
            if (S(t10)) {
                Result.a aVar2 = Result.f32010a;
                oVar.resumeWith(Result.b(Unit.f32013a));
                cVarArr = J(cVarArr2);
                aVar = null;
            } else {
                a aVar3 = new a(this, ((long) Q()) + L(), t10, oVar);
                I(aVar3);
                this.f32417m = this.f32417m + 1;
                if (this.f32411f == 0) {
                    cVarArr2 = J(cVarArr2);
                }
                cVarArr = cVarArr2;
                aVar = aVar3;
            }
        }
        if (aVar != null) {
            q.a(oVar, aVar);
        }
        for (c<Unit> cVar2 : cVarArr) {
            if (cVar2 != null) {
                Result.a aVar4 = Result.f32010a;
                cVar2.resumeWith(Result.b(Unit.f32013a));
            }
        }
        Object v10 = oVar.v();
        if (v10 == b.d()) {
            f.c(cVar);
        }
        if (v10 == b.d()) {
            return v10;
        }
        return Unit.f32013a;
    }

    /* access modifiers changed from: private */
    public final void I(Object obj) {
        int Q = Q();
        Object[] objArr = this.f32413h;
        if (objArr == null) {
            objArr = R((Object[]) null, 0, 2);
        } else if (Q >= objArr.length) {
            objArr = R(objArr, Q, objArr.length * 2);
        }
        m.g(objArr, L() + ((long) Q), obj);
    }

    /* JADX WARNING: type inference failed for: r11v6, types: [java.lang.Object[], java.lang.Object] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r4 = (kotlinx.coroutines.flow.n) r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.coroutines.c<kotlin.Unit>[] J(kotlin.coroutines.c<kotlin.Unit>[] r11) {
        /*
            r10 = this;
            int r0 = r11.length
            int r1 = r10.f32455b
            if (r1 == 0) goto L_0x0047
            kotlinx.coroutines.flow.internal.c[] r1 = r10.f32454a
            if (r1 == 0) goto L_0x0047
            r2 = 0
            int r3 = r1.length
        L_0x000f:
            if (r2 >= r3) goto L_0x0047
            r4 = r1[r2]
            if (r4 == 0) goto L_0x0044
            kotlinx.coroutines.flow.n r4 = (kotlinx.coroutines.flow.n) r4
            kotlin.coroutines.c<? super kotlin.Unit> r5 = r4.f32475b
            if (r5 != 0) goto L_0x001c
            goto L_0x0044
        L_0x001c:
            long r6 = r10.U(r4)
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x0044
            int r6 = r11.length
            if (r0 < r6) goto L_0x0039
            int r6 = r11.length
            r7 = 2
            int r6 = r6 * r7
            int r6 = java.lang.Math.max(r7, r6)
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r6)
            java.lang.String r6 = "copyOf(this, newSize)"
            kotlin.jvm.internal.j.f(r11, r6)
        L_0x0039:
            r6 = r11
            kotlin.coroutines.c[] r6 = (kotlin.coroutines.c[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.f32475b = r0
            r0 = r7
        L_0x0044:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x0047:
            kotlin.coroutines.c[] r11 = (kotlin.coroutines.c[]) r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.J(kotlin.coroutines.c[]):kotlin.coroutines.c[]");
    }

    private final long K() {
        return L() + ((long) this.f32416l);
    }

    /* access modifiers changed from: private */
    public final long L() {
        return Math.min(this.f32415k, this.f32414j);
    }

    private final Object N(long j10) {
        Object[] objArr = this.f32413h;
        j.d(objArr);
        Object c10 = m.f(objArr, j10);
        if (c10 instanceof a) {
            return ((a) c10).f32420c;
        }
        return c10;
    }

    private final long O() {
        return L() + ((long) this.f32416l) + ((long) this.f32417m);
    }

    private final int P() {
        return (int) ((L() + ((long) this.f32416l)) - this.f32414j);
    }

    /* access modifiers changed from: private */
    public final int Q() {
        return this.f32416l + this.f32417m;
    }

    private final Object[] R(Object[] objArr, int i10, int i11) {
        boolean z10;
        if (i11 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            Object[] objArr2 = new Object[i11];
            this.f32413h = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long L = L();
            for (int i12 = 0; i12 < i10; i12++) {
                long j10 = ((long) i12) + L;
                m.g(objArr2, j10, m.f(objArr, j10));
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    /* access modifiers changed from: private */
    public final boolean S(T t10) {
        if (m() == 0) {
            return T(t10);
        }
        if (this.f32416l >= this.f32411f && this.f32415k <= this.f32414j) {
            int i10 = b.f32422a[this.f32412g.ordinal()];
            if (i10 == 1) {
                return false;
            }
            if (i10 == 2) {
                return true;
            }
        }
        I(t10);
        int i11 = this.f32416l + 1;
        this.f32416l = i11;
        if (i11 > this.f32411f) {
            F();
        }
        if (P() > this.f32410e) {
            W(this.f32414j + 1, this.f32415k, K(), O());
        }
        return true;
    }

    private final boolean T(T t10) {
        if (this.f32410e == 0) {
            return true;
        }
        I(t10);
        int i10 = this.f32416l + 1;
        this.f32416l = i10;
        if (i10 > this.f32410e) {
            F();
        }
        this.f32415k = L() + ((long) this.f32416l);
        return true;
    }

    /* access modifiers changed from: private */
    public final long U(n nVar) {
        long j10 = nVar.f32474a;
        if (j10 < K()) {
            return j10;
        }
        if (this.f32411f <= 0 && j10 <= L() && this.f32417m != 0) {
            return j10;
        }
        return -1;
    }

    private final Object V(n nVar) {
        Object obj;
        c<Unit>[] cVarArr = kotlinx.coroutines.flow.internal.b.f32458a;
        synchronized (this) {
            long U = U(nVar);
            if (U < 0) {
                obj = m.f32473a;
            } else {
                long j10 = nVar.f32474a;
                Object N = N(U);
                nVar.f32474a = U + 1;
                Object obj2 = N;
                cVarArr = X(j10);
                obj = obj2;
            }
        }
        for (c<Unit> cVar : cVarArr) {
            if (cVar != null) {
                Result.a aVar = Result.f32010a;
                cVar.resumeWith(Result.b(Unit.f32013a));
            }
        }
        return obj;
    }

    private final void W(long j10, long j11, long j12, long j13) {
        long min = Math.min(j11, j10);
        for (long L = L(); L < min; L++) {
            Object[] objArr = this.f32413h;
            j.d(objArr);
            m.g(objArr, L, (Object) null);
        }
        this.f32414j = j10;
        this.f32415k = j11;
        this.f32416l = (int) (j12 - min);
        this.f32417m = (int) (j13 - j12);
    }

    private final Object y(n nVar, c<? super Unit> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        oVar.y();
        synchronized (this) {
            if (U(nVar) < 0) {
                nVar.f32475b = oVar;
            } else {
                Result.a aVar = Result.f32010a;
                oVar.resumeWith(Result.b(Unit.f32013a));
            }
            Unit unit = Unit.f32013a;
        }
        Object v10 = oVar.v();
        if (v10 == b.d()) {
            f.c(cVar);
        }
        if (v10 == b.d()) {
            return v10;
        }
        return Unit.f32013a;
    }

    /* access modifiers changed from: private */
    public final void z(a aVar) {
        synchronized (this) {
            if (aVar.f32419b >= L()) {
                Object[] objArr = this.f32413h;
                j.d(objArr);
                if (m.f(objArr, aVar.f32419b) == aVar) {
                    m.g(objArr, aVar.f32419b, m.f32473a);
                    A();
                    Unit unit = Unit.f32013a;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public n j() {
        return new n();
    }

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public n[] k(int i10) {
        return new n[i10];
    }

    /* access modifiers changed from: protected */
    public final T M() {
        Object[] objArr = this.f32413h;
        j.d(objArr);
        return m.f(objArr, (this.f32414j + ((long) P())) - 1);
    }

    public final c<Unit>[] X(long j10) {
        int i10;
        long j11;
        long j12;
        long j13;
        boolean z10;
        long j14;
        kotlinx.coroutines.flow.internal.c[] g10;
        if (j10 > this.f32415k) {
            return kotlinx.coroutines.flow.internal.b.f32458a;
        }
        long L = L();
        long j15 = ((long) this.f32416l) + L;
        if (this.f32411f == 0 && this.f32417m > 0) {
            j15++;
        }
        if (!(this.f32455b == 0 || (g10 = this.f32454a) == null)) {
            for (kotlinx.coroutines.flow.internal.c cVar : g10) {
                if (cVar != null) {
                    long j16 = ((n) cVar).f32474a;
                    if (j16 >= 0 && j16 < j15) {
                        j15 = j16;
                    }
                }
            }
        }
        if (j15 <= this.f32415k) {
            return kotlinx.coroutines.flow.internal.b.f32458a;
        }
        long K = K();
        if (m() > 0) {
            i10 = Math.min(this.f32417m, this.f32411f - ((int) (K - j15)));
        } else {
            i10 = this.f32417m;
        }
        c<Unit>[] cVarArr = kotlinx.coroutines.flow.internal.b.f32458a;
        long j17 = ((long) this.f32417m) + K;
        if (i10 > 0) {
            cVarArr = new c[i10];
            Object[] objArr = this.f32413h;
            j.d(objArr);
            long j18 = K;
            int i11 = 0;
            while (true) {
                if (K >= j17) {
                    j12 = j15;
                    j11 = j17;
                    break;
                }
                Object c10 = m.f(objArr, K);
                j12 = j15;
                f0 f0Var = m.f32473a;
                if (c10 == f0Var) {
                    j11 = j17;
                    j14 = 1;
                } else if (c10 != null) {
                    a aVar = (a) c10;
                    int i12 = i11 + 1;
                    j11 = j17;
                    cVarArr[i11] = aVar.f32421d;
                    m.g(objArr, K, f0Var);
                    m.g(objArr, j18, aVar.f32420c);
                    j14 = 1;
                    j18++;
                    if (i12 >= i10) {
                        break;
                    }
                    i11 = i12;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                }
                K += j14;
                j15 = j12;
                j17 = j11;
            }
            K = j18;
        } else {
            j12 = j15;
            j11 = j17;
        }
        int i13 = (int) (K - L);
        if (m() == 0) {
            j13 = K;
        } else {
            j13 = j12;
        }
        long max = Math.max(this.f32414j, K - ((long) Math.min(this.f32410e, i13)));
        if (this.f32411f == 0 && max < j11) {
            Object[] objArr2 = this.f32413h;
            j.d(objArr2);
            if (j.b(m.f(objArr2, max), m.f32473a)) {
                K++;
                max++;
            }
        }
        W(max, j13, K, j11);
        A();
        if (cVarArr.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return J(cVarArr);
        }
        return cVarArr;
    }

    public final long Y() {
        long j10 = this.f32414j;
        if (j10 < this.f32415k) {
            this.f32415k = j10;
        }
        return j10;
    }

    public Object a(c<? super T> cVar, c<?> cVar2) {
        return B(this, cVar, cVar2);
    }

    public Object c(T t10, c<? super Unit> cVar) {
        return G(this, t10, cVar);
    }

    public b<T> d(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        return m.e(this, coroutineContext, i10, bufferOverflow);
    }

    public boolean e(T t10) {
        int i10;
        boolean z10;
        c<Unit>[] cVarArr = kotlinx.coroutines.flow.internal.b.f32458a;
        synchronized (this) {
            if (S(t10)) {
                cVarArr = J(cVarArr);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        for (c<Unit> cVar : cVarArr) {
            if (cVar != null) {
                Result.a aVar = Result.f32010a;
                cVar.resumeWith(Result.b(Unit.f32013a));
            }
        }
        return z10;
    }

    public void h() {
        synchronized (this) {
            W(K(), this.f32415k, K(), O());
            Unit unit = Unit.f32013a;
        }
    }
}
