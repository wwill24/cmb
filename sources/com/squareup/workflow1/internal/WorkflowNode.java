package com.squareup.workflow1.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.workflow1.TreeSnapshot;
import com.squareup.workflow1.WorkflowIdentifier;
import com.squareup.workflow1.WorkflowInterceptorKt;
import com.squareup.workflow1.h;
import com.squareup.workflow1.internal.d;
import com.squareup.workflow1.internal.e;
import com.squareup.workflow1.l;
import com.squareup.workflow1.m;
import com.squareup.workflow1.n;
import com.squareup.workflow1.o;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.selects.a;
import kotlinx.coroutines.v1;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0001\u0012\u0006\u00102\u001a\u00020.\u0012\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b\u0012\u0006\u0010]\u001a\u00028\u0000\u0012\b\u0010^\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010_\u001a\u00020>\u0012\u0016\b\u0002\u00106\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001103\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010=\u001a\u00020;\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010`¢\u0006\u0004\bb\u0010cJ7\u0010\u000b\u001a\u00028\u00032\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b2\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\u000f\u001a\u00020\u000e2\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b2\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0015\u001a\u0004\u0018\u00018\u0004\"\b\b\u0004\u0010\u0012*\u00020\u00112\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J>\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\"\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0017H\u0016J3\u0010!\u001a\u00028\u00032\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b2\u0006\u0010 \u001a\u00028\u0000¢\u0006\u0004\b!\u0010\fJ\u001e\u0010#\u001a\u00020\"2\u0016\u0010\t\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\bJ>\u0010$\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\"\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\"\u0010)\u001a\u00020\u000e\"\u0004\b\u0004\u0010\u00122\u0014\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0004\u0018\u00010'0&J\u0018\u0010-\u001a\u00020\u000e2\u0010\b\u0002\u0010,\u001a\n\u0018\u00010*j\u0004\u0018\u0001`+R\u0017\u00102\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b$\u0010/\u001a\u0004\b0\u00101R\"\u00106\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0011038\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001c\u0010:\u001a\u0004\u0018\u00010\u00078\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u00107\u001a\u0004\b8\u00109R\u0014\u0010=\u001a\u00020;8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010<R\u001a\u0010C\u001a\u00020>8\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001a\u0010H\u001a\u00020D8\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010E\u001a\u0004\bF\u0010GR&\u0010K\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020I8\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010JR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001c0L8\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010R\u001a\u00028\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR,\u0010V\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00130S8\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001a\u00028\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010QR\u0014\u0010Z\u001a\u00020X8VX\u0004¢\u0006\u0006\u001a\u0004\bM\u0010YR\u0014\u0010\\\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\bP\u0010[\u0002\u0004\n\u0002\b\u0019¨\u0006d"}, d2 = {"Lcom/squareup/workflow1/internal/WorkflowNode;", "PropsT", "StateT", "OutputT", "RenderingT", "Lkotlinx/coroutines/k0;", "Lcom/squareup/workflow1/internal/e$b;", "Lcom/squareup/workflow1/m$c;", "Lcom/squareup/workflow1/h;", "workflow", "props", "n", "(Lcom/squareup/workflow1/h;Ljava/lang/Object;)Ljava/lang/Object;", "newProps", "", "q", "(Lcom/squareup/workflow1/h;Ljava/lang/Object;)V", "", "T", "Lcom/squareup/workflow1/l;", "action", "c", "(Lcom/squareup/workflow1/l;)Ljava/lang/Object;", "", "key", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "sideEffect", "Lcom/squareup/workflow1/internal/f;", "f", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Lcom/squareup/workflow1/internal/f;", "toString", "input", "m", "Lcom/squareup/workflow1/TreeSnapshot;", "o", "a", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "Lkotlinx/coroutines/selects/a;", "Lcom/squareup/workflow1/n;", "selector", "p", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "d", "Lcom/squareup/workflow1/internal/h;", "Lcom/squareup/workflow1/internal/h;", "g", "()Lcom/squareup/workflow1/internal/h;", "id", "Lkotlin/Function1;", "b", "Lkotlin/jvm/functions/Function1;", "emitOutputToParent", "Lcom/squareup/workflow1/m$c;", "i", "()Lcom/squareup/workflow1/m$c;", "parent", "Lcom/squareup/workflow1/m;", "Lcom/squareup/workflow1/m;", "interceptor", "Lkotlin/coroutines/CoroutineContext;", "e", "Lkotlin/coroutines/CoroutineContext;", "G", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "", "J", "l", "()J", "sessionId", "Lcom/squareup/workflow1/internal/SubtreeManager;", "Lcom/squareup/workflow1/internal/SubtreeManager;", "subtreeManager", "Lcom/squareup/workflow1/internal/a;", "h", "Lcom/squareup/workflow1/internal/a;", "sideEffects", "j", "Ljava/lang/Object;", "lastProps", "Lkotlinx/coroutines/channels/d;", "k", "Lkotlinx/coroutines/channels/d;", "eventActionsChannel", "state", "Lcom/squareup/workflow1/WorkflowIdentifier;", "()Lcom/squareup/workflow1/WorkflowIdentifier;", "identifier", "()Ljava/lang/String;", "renderKey", "initialProps", "snapshot", "baseContext", "Lcom/squareup/workflow1/internal/c;", "idCounter", "<init>", "(Lcom/squareup/workflow1/internal/h;Lcom/squareup/workflow1/h;Ljava/lang/Object;Lcom/squareup/workflow1/TreeSnapshot;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function1;Lcom/squareup/workflow1/m$c;Lcom/squareup/workflow1/m;Lcom/squareup/workflow1/internal/c;)V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public final class WorkflowNode<PropsT, StateT, OutputT, RenderingT> implements k0, e.b, m.c {

    /* renamed from: a  reason: collision with root package name */
    private final h f23102a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<OutputT, Object> f23103b;

    /* renamed from: c  reason: collision with root package name */
    private final m.c f23104c;

    /* renamed from: d  reason: collision with root package name */
    private final m f23105d;

    /* renamed from: e  reason: collision with root package name */
    private final CoroutineContext f23106e;

    /* renamed from: f  reason: collision with root package name */
    private final long f23107f;

    /* renamed from: g  reason: collision with root package name */
    private final SubtreeManager<PropsT, StateT, OutputT> f23108g;

    /* renamed from: h  reason: collision with root package name */
    private final a<f> f23109h;

    /* renamed from: j  reason: collision with root package name */
    private PropsT f23110j;

    /* renamed from: k  reason: collision with root package name */
    private final d<l<PropsT, StateT, OutputT>> f23111k;

    /* renamed from: l  reason: collision with root package name */
    private StateT f23112l;

    /* JADX WARNING: type inference failed for: r15v0, types: [com.squareup.workflow1.h, com.squareup.workflow1.h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkflowNode(com.squareup.workflow1.internal.h r14, com.squareup.workflow1.h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT> r15, PropsT r16, com.squareup.workflow1.TreeSnapshot r17, kotlin.coroutines.CoroutineContext r18, kotlin.jvm.functions.Function1<? super OutputT, ? extends java.lang.Object> r19, com.squareup.workflow1.m.c r20, com.squareup.workflow1.m r21, com.squareup.workflow1.internal.c r22) {
        /*
            r13 = this;
            r7 = r13
            r0 = r14
            r8 = r15
            r9 = r16
            r1 = r18
            r2 = r19
            r10 = r21
            java.lang.String r3 = "id"
            kotlin.jvm.internal.j.g(r14, r3)
            java.lang.String r3 = "workflow"
            kotlin.jvm.internal.j.g(r15, r3)
            java.lang.String r3 = "baseContext"
            kotlin.jvm.internal.j.g(r1, r3)
            java.lang.String r3 = "emitOutputToParent"
            kotlin.jvm.internal.j.g(r2, r3)
            java.lang.String r3 = "interceptor"
            kotlin.jvm.internal.j.g(r10, r3)
            r13.<init>()
            r7.f23102a = r0
            r7.f23103b = r2
            r2 = r20
            r7.f23104c = r2
            r7.f23105d = r10
            kotlinx.coroutines.s1$b r2 = kotlinx.coroutines.s1.f32618v
            kotlin.coroutines.CoroutineContext$Element r2 = r1.c(r2)
            kotlinx.coroutines.s1 r2 = (kotlinx.coroutines.s1) r2
            kotlinx.coroutines.z r2 = kotlinx.coroutines.v1.a(r2)
            kotlin.coroutines.CoroutineContext r1 = r1.e0(r2)
            kotlinx.coroutines.j0 r2 = new kotlinx.coroutines.j0
            java.lang.String r0 = r14.toString()
            r2.<init>(r0)
            kotlin.coroutines.CoroutineContext r0 = r1.e0(r2)
            r7.f23106e = r0
            if (r22 != 0) goto L_0x0055
            r0 = 0
            goto L_0x0059
        L_0x0055:
            long r0 = r22.a()
        L_0x0059:
            r7.f23107f = r0
            com.squareup.workflow1.internal.SubtreeManager r11 = new com.squareup.workflow1.internal.SubtreeManager
            r12 = 0
            if (r17 != 0) goto L_0x0062
            r1 = r12
            goto L_0x0067
        L_0x0062:
            java.util.Map r0 = r17.a()
            r1 = r0
        L_0x0067:
            kotlin.coroutines.CoroutineContext r2 = r13.G()
            com.squareup.workflow1.internal.WorkflowNode$subtreeManager$1 r3 = new com.squareup.workflow1.internal.WorkflowNode$subtreeManager$1
            r3.<init>(r13)
            r0 = r11
            r4 = r13
            r5 = r21
            r6 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.f23108g = r11
            com.squareup.workflow1.internal.a r0 = new com.squareup.workflow1.internal.a
            r0.<init>()
            r7.f23109h = r0
            r7.f23110j = r9
            r0 = 2147483647(0x7fffffff, float:NaN)
            r1 = 6
            kotlinx.coroutines.channels.d r0 = kotlinx.coroutines.channels.g.b(r0, r12, r12, r1, r12)
            r7.f23111k = r0
            r10.d(r13, r13)
            com.squareup.workflow1.h r0 = com.squareup.workflow1.WorkflowInterceptorKt.a(r10, r15, r13)
            if (r17 != 0) goto L_0x0098
            goto L_0x009c
        L_0x0098:
            com.squareup.workflow1.Snapshot r12 = r17.b()
        L_0x009c:
            java.lang.Object r0 = r0.d(r9, r12)
            r7.f23112l = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.internal.WorkflowNode.<init>(com.squareup.workflow1.internal.h, com.squareup.workflow1.h, java.lang.Object, com.squareup.workflow1.TreeSnapshot, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function1, com.squareup.workflow1.m$c, com.squareup.workflow1.m, com.squareup.workflow1.internal.c):void");
    }

    /* access modifiers changed from: private */
    public final <T> T c(l<? super PropsT, StateT, ? extends OutputT> lVar) {
        Pair<StateT, n<? extends OutputT>> h10 = o.h(lVar, this.f23110j, this.f23112l);
        StateT a10 = h10.a();
        n b10 = h10.b();
        this.f23112l = a10;
        if (b10 == null) {
            return null;
        }
        return this.f23103b.invoke(b10.a());
    }

    public static /* synthetic */ void e(WorkflowNode workflowNode, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        workflowNode.d(cancellationException);
    }

    private final f f(String str, Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2) {
        return new f(str, j.d(l0.j(this, new j0("sideEffect[" + str + "] for " + this.f23102a)), (CoroutineContext) null, CoroutineStart.LAZY, function2, 1, (Object) null));
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.squareup.workflow1.h, com.squareup.workflow1.h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final RenderingT n(com.squareup.workflow1.h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT> r5, PropsT r6) {
        /*
            r4 = this;
            r4.q(r5, r6)
            com.squareup.workflow1.internal.e r0 = new com.squareup.workflow1.internal.e
            com.squareup.workflow1.internal.SubtreeManager<PropsT, StateT, OutputT> r1 = r4.f23108g
            kotlinx.coroutines.channels.d<com.squareup.workflow1.l<PropsT, StateT, OutputT>> r2 = r4.f23111k
            r0.<init>(r1, r4, r2)
            com.squareup.workflow1.m r1 = r4.f23105d
            com.squareup.workflow1.h r1 = com.squareup.workflow1.WorkflowInterceptorKt.a(r1, r5, r4)
            StateT r2 = r4.f23112l
            com.squareup.workflow1.h$a r5 = com.squareup.workflow1.o.a(r0, r5)
            java.lang.Object r5 = r1.f(r6, r2, r5)
            r0.f()
            com.squareup.workflow1.internal.SubtreeManager<PropsT, StateT, OutputT> r6 = r4.f23108g
            r6.c()
            com.squareup.workflow1.internal.a<com.squareup.workflow1.internal.f> r6 = r4.f23109h
            com.squareup.workflow1.internal.d r6 = r6.f23120b
            com.squareup.workflow1.internal.d$a r6 = r6.b()
        L_0x002e:
            if (r6 == 0) goto L_0x003f
            r0 = r6
            com.squareup.workflow1.internal.f r0 = (com.squareup.workflow1.internal.f) r0
            kotlinx.coroutines.s1 r0 = r0.c()
            r0.start()
            com.squareup.workflow1.internal.d$a r6 = r6.a()
            goto L_0x002e
        L_0x003f:
            com.squareup.workflow1.internal.a<com.squareup.workflow1.internal.f> r6 = r4.f23109h
            com.squareup.workflow1.internal.d r0 = r6.f23119a
            com.squareup.workflow1.internal.d$a r0 = r0.b()
        L_0x0049:
            if (r0 == 0) goto L_0x005c
            r1 = r0
            com.squareup.workflow1.internal.f r1 = (com.squareup.workflow1.internal.f) r1
            kotlinx.coroutines.s1 r1 = r1.c()
            r2 = 1
            r3 = 0
            kotlinx.coroutines.s1.a.a(r1, r3, r2, r3)
            com.squareup.workflow1.internal.d$a r0 = r0.a()
            goto L_0x0049
        L_0x005c:
            com.squareup.workflow1.internal.d r0 = r6.f23119a
            com.squareup.workflow1.internal.d r1 = r6.f23120b
            r6.f23119a = r1
            r6.f23120b = r0
            com.squareup.workflow1.internal.d r6 = r6.f23120b
            r6.a()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.internal.WorkflowNode.n(com.squareup.workflow1.h, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.squareup.workflow1.h, com.squareup.workflow1.h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void q(com.squareup.workflow1.h<? super PropsT, StateT, ? extends OutputT, ? extends RenderingT> r3, PropsT r4) {
        /*
            r2 = this;
            PropsT r0 = r2.f23110j
            boolean r0 = kotlin.jvm.internal.j.b(r4, r0)
            if (r0 != 0) goto L_0x0018
            com.squareup.workflow1.m r0 = r2.f23105d
            com.squareup.workflow1.h r3 = com.squareup.workflow1.WorkflowInterceptorKt.a(r0, r3, r2)
            PropsT r0 = r2.f23110j
            StateT r1 = r2.f23112l
            java.lang.Object r3 = r3.e(r0, r4, r1)
            r2.f23112l = r3
        L_0x0018:
            r2.f23110j = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.internal.WorkflowNode.q(com.squareup.workflow1.h, java.lang.Object):void");
    }

    public CoroutineContext G() {
        return this.f23106e;
    }

    public void a(String str, Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(function2, "sideEffect");
        d.a b10 = this.f23109h.f23120b.b();
        while (b10 != null) {
            if (!j.b(str, ((f) b10).d())) {
                b10 = b10.a();
            } else {
                throw new IllegalArgumentException(("Expected side effect keys to be unique: \"" + str + '\"').toString());
            }
        }
        a<f> aVar = this.f23109h;
        d a10 = aVar.f23119a;
        d.a b11 = a10.b();
        d.a aVar2 = null;
        d.a aVar3 = null;
        while (true) {
            if (b11 == null) {
                break;
            } else if (j.b(str, ((f) b11).d())) {
                if (aVar3 == null) {
                    a10.e(b11.a());
                } else {
                    aVar3.b(b11.a());
                }
                if (j.b(a10.c(), b11)) {
                    a10.f(aVar3);
                }
                b11.b(null);
                aVar2 = b11;
            } else {
                aVar3 = b11;
                b11 = b11.a();
            }
        }
        if (aVar2 == null) {
            aVar2 = f(str, function2);
        }
        aVar.f23120b.d(aVar2);
    }

    public final void d(CancellationException cancellationException) {
        v1.c(G(), cancellationException);
    }

    public final h g() {
        return this.f23102a;
    }

    public WorkflowIdentifier h() {
        return this.f23102a.a();
    }

    public m.c i() {
        return this.f23104c;
    }

    public String j() {
        return this.f23102a.b();
    }

    public long l() {
        return this.f23107f;
    }

    public final RenderingT m(h<? super PropsT, ?, ? extends OutputT, ? extends RenderingT> hVar, PropsT propst) {
        j.g(hVar, "workflow");
        return n(hVar, propst);
    }

    public final TreeSnapshot o(h<?, ?, ?, ?> hVar) {
        j.g(hVar, "workflow");
        return new TreeSnapshot(WorkflowInterceptorKt.a(this.f23105d, hVar, this).g(this.f23112l), new WorkflowNode$snapshot$1(this.f23108g.f()));
    }

    public final <T> void p(a<? super n<? extends T>> aVar) {
        j.g(aVar, "selector");
        this.f23108g.g(aVar);
        aVar.z(this.f23111k.u(), new WorkflowNode$tick$1$1(this, (c<? super WorkflowNode$tick$1$1>) null));
    }

    public String toString() {
        String str;
        if (i() == null) {
            str = null;
        } else {
            str = "WorkflowInstance(…)";
        }
        return "WorkflowInstance(identifier=" + h() + ", renderKey=" + j() + ", instanceId=" + l() + ", parent=" + str + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WorkflowNode(com.squareup.workflow1.internal.h r13, com.squareup.workflow1.h r14, java.lang.Object r15, com.squareup.workflow1.TreeSnapshot r16, kotlin.coroutines.CoroutineContext r17, kotlin.jvm.functions.Function1 r18, com.squareup.workflow1.m.c r19, com.squareup.workflow1.m r20, com.squareup.workflow1.internal.c r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 32
            if (r1 == 0) goto L_0x000a
            com.squareup.workflow1.internal.WorkflowNode$1 r1 = com.squareup.workflow1.internal.WorkflowNode.AnonymousClass1.f23113a
            r8 = r1
            goto L_0x000c
        L_0x000a:
            r8 = r18
        L_0x000c:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r9 = r2
            goto L_0x0015
        L_0x0013:
            r9 = r19
        L_0x0015:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x001d
            com.squareup.workflow1.d r1 = com.squareup.workflow1.d.f23084a
            r10 = r1
            goto L_0x001f
        L_0x001d:
            r10 = r20
        L_0x001f:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0025
            r11 = r2
            goto L_0x0027
        L_0x0025:
            r11 = r21
        L_0x0027:
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.internal.WorkflowNode.<init>(com.squareup.workflow1.internal.h, com.squareup.workflow1.h, java.lang.Object, com.squareup.workflow1.TreeSnapshot, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function1, com.squareup.workflow1.m$c, com.squareup.workflow1.m, com.squareup.workflow1.internal.c, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
