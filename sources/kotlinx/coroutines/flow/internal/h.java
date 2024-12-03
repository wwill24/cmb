package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlinx.coroutines.flow.c;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbortFlowException;", "Lkotlinx/coroutines/flow/c;", "owner", "", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class h {
    public static final void a(AbortFlowException abortFlowException, c<?> cVar) {
        if (abortFlowException.f32434a != cVar) {
            throw abortFlowException;
        }
    }
}
