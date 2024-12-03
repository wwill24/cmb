package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.e;
import kotlinx.coroutines.flow.internal.i;
import kotlinx.coroutines.s1;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a$\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\t\u001a\u00020\b\u001a\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"T", "Lkotlinx/coroutines/flow/b;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "a", "d", "Lkotlin/coroutines/CoroutineContext;", "context", "e", "", "c", "(Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class f {
    public static final <T> b<T> a(b<? extends T> bVar, int i10, BufferOverflow bufferOverflow) {
        boolean z10;
        BufferOverflow bufferOverflow2;
        int i11;
        boolean z11 = true;
        if (i10 >= 0 || i10 == -2 || i10 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i10 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
                z11 = false;
            }
            if (z11) {
                if (i10 == -1) {
                    bufferOverflow2 = BufferOverflow.DROP_OLDEST;
                    i11 = 0;
                } else {
                    i11 = i10;
                    bufferOverflow2 = bufferOverflow;
                }
                if (bVar instanceof i) {
                    return i.a.a((i) bVar, (CoroutineContext) null, i11, bufferOverflow2, 1, (Object) null);
                }
                return new e(bVar, (CoroutineContext) null, i11, bufferOverflow2, 2, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i10).toString());
    }

    public static /* synthetic */ b b(b bVar, int i10, BufferOverflow bufferOverflow, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -2;
        }
        if ((i11 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return d.b(bVar, i10, bufferOverflow);
    }

    private static final void c(CoroutineContext coroutineContext) {
        boolean z10;
        if (coroutineContext.c(s1.f32618v) == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
        }
    }

    public static final <T> b<T> d(b<? extends T> bVar) {
        return b(bVar, -1, (BufferOverflow) null, 2, (Object) null);
    }

    public static final <T> b<T> e(b<? extends T> bVar, CoroutineContext coroutineContext) {
        c(coroutineContext);
        if (j.b(coroutineContext, EmptyCoroutineContext.f32070a)) {
            return bVar;
        }
        if (bVar instanceof i) {
            return i.a.a((i) bVar, coroutineContext, 0, (BufferOverflow) null, 6, (Object) null);
        }
        return new e(bVar, coroutineContext, 0, (BufferOverflow) null, 12, (DefaultConstructorMarker) null);
    }
}
