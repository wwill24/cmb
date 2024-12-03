package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.internal.c0;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/sync/g;", "Lkotlinx/coroutines/internal/c0;", "", "index", "", "q", "(I)V", "", "toString", "()Ljava/lang/String;", "n", "()I", "maxSlots", "", "id", "prev", "pointers", "<init>", "(JLkotlinx/coroutines/sync/g;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class g extends c0<g> {

    /* renamed from: e  reason: collision with root package name */
    /* synthetic */ AtomicReferenceArray f32719e = new AtomicReferenceArray(f.f32718f);

    public g(long j10, g gVar, int i10) {
        super(j10, gVar, i10);
    }

    public int n() {
        return f.f32718f;
    }

    public final void q(int i10) {
        this.f32719e.set(i10, f.f32717e);
        o();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + m() + ", hashCode=" + hashCode() + PropertyUtils.INDEXED_DELIM2;
    }
}
