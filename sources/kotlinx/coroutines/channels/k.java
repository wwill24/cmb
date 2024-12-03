package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.p;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0010\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0010\u001a\u00020\b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006#"}, d2 = {"Lkotlinx/coroutines/channels/k;", "E", "Lkotlinx/coroutines/channels/t;", "Lkotlinx/coroutines/channels/r;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "Lkotlinx/coroutines/internal/f0;", "a0", "", "X", "value", "y", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;)Lkotlinx/coroutines/internal/f0;", "j", "(Ljava/lang/Object;)V", "closed", "Z", "", "toString", "", "d", "Ljava/lang/Throwable;", "closeCause", "f0", "()Ljava/lang/Throwable;", "sendException", "e0", "receiveException", "c0", "()Lkotlinx/coroutines/channels/k;", "offerResult", "d0", "pollResult", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class k<E> extends t implements r<E> {

    /* renamed from: d  reason: collision with root package name */
    public final Throwable f32335d;

    public k(Throwable th2) {
        this.f32335d = th2;
    }

    public void X() {
    }

    public void Z(k<?> kVar) {
    }

    public f0 a0(LockFreeLinkedListNode.c cVar) {
        f0 f0Var = p.f32594a;
        if (cVar != null) {
            cVar.d();
        }
        return f0Var;
    }

    /* renamed from: c0 */
    public k<E> c() {
        return this;
    }

    /* renamed from: d0 */
    public k<E> Y() {
        return this;
    }

    public final Throwable e0() {
        Throwable th2 = this.f32335d;
        return th2 == null ? new ClosedReceiveChannelException("Channel was closed") : th2;
    }

    public final Throwable f0() {
        Throwable th2 = this.f32335d;
        return th2 == null ? new ClosedSendChannelException("Channel was closed") : th2;
    }

    public void j(E e10) {
    }

    public String toString() {
        return "Closed@" + m0.b(this) + '[' + this.f32335d + PropertyUtils.INDEXED_DELIM2;
    }

    public f0 y(E e10, LockFreeLinkedListNode.c cVar) {
        f0 f0Var = p.f32594a;
        if (cVar != null) {
            cVar.d();
        }
        return f0Var;
    }
}
