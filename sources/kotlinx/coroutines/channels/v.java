package kotlinx.coroutines.channels;

import gk.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.p;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001a\u0010\u0012\u001a\u00028\u00008\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/channels/v;", "E", "Lkotlinx/coroutines/channels/t;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$c;", "otherOp", "Lkotlinx/coroutines/internal/f0;", "a0", "", "X", "Lkotlinx/coroutines/channels/k;", "closed", "Z", "", "toString", "d", "Ljava/lang/Object;", "Y", "()Ljava/lang/Object;", "pollResult", "Lkotlinx/coroutines/n;", "e", "Lkotlinx/coroutines/n;", "cont", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/n;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class v<E> extends t {

    /* renamed from: d  reason: collision with root package name */
    private final E f32338d;

    /* renamed from: e  reason: collision with root package name */
    public final n<Unit> f32339e;

    public v(E e10, n<? super Unit> nVar) {
        this.f32338d = e10;
        this.f32339e = nVar;
    }

    public void X() {
        this.f32339e.M(p.f32594a);
    }

    public E Y() {
        return this.f32338d;
    }

    public void Z(k<?> kVar) {
        n<Unit> nVar = this.f32339e;
        Result.a aVar = Result.f32010a;
        nVar.resumeWith(Result.b(g.a(kVar.f0())));
    }

    public f0 a0(LockFreeLinkedListNode.c cVar) {
        LockFreeLinkedListNode.a aVar;
        n<Unit> nVar = this.f32339e;
        Unit unit = Unit.f32013a;
        if (cVar != null) {
            aVar = cVar.f32503c;
        } else {
            aVar = null;
        }
        if (nVar.d(unit, aVar) == null) {
            return null;
        }
        if (cVar != null) {
            cVar.d();
        }
        return p.f32594a;
    }

    public String toString() {
        return m0.a(this) + '@' + m0.b(this) + PropertyUtils.MAPPED_DELIM + Y() + PropertyUtils.MAPPED_DELIM2;
    }
}
