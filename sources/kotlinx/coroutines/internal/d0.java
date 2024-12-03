package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.internal.c0;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b@\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0014\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u0001\r\u0001\u0004\u0018\u00010\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/internal/d0;", "Lkotlinx/coroutines/internal/c0;", "S", "", "", "c", "(Ljava/lang/Object;)Z", "isClosed", "b", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/c0;", "getSegment$annotations", "()V", "segment", "value", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class d0<S extends c0<S>> {
    public static <S extends c0<S>> Object a(Object obj) {
        return obj;
    }

    public static final S b(Object obj) {
        if (obj == f.f32528a) {
            throw new IllegalStateException("Does not contain segment".toString());
        } else if (obj != null) {
            return (c0) obj;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        }
    }

    public static final boolean c(Object obj) {
        return obj == f.f32528a;
    }
}
