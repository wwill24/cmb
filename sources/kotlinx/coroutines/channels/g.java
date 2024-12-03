package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¨\u0006\n"}, d2 = {"E", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "", "onUndeliveredElement", "Lkotlinx/coroutines/channels/d;", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class g {
    public static final <E> d<E> a(int i10, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        int i11 = 1;
        if (i10 == -2) {
            if (bufferOverflow == BufferOverflow.SUSPEND) {
                i11 = d.A.a();
            }
            return new c(i11, bufferOverflow, function1);
        } else if (i10 == -1) {
            if (bufferOverflow != BufferOverflow.SUSPEND) {
                i11 = 0;
            }
            if (i11 != 0) {
                return new l(function1);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        } else if (i10 != 0) {
            if (i10 == Integer.MAX_VALUE) {
                return new m(function1);
            }
            if (i10 == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) {
                return new l(function1);
            }
            return new c(i10, bufferOverflow, function1);
        } else if (bufferOverflow == BufferOverflow.SUSPEND) {
            return new s(function1);
        } else {
            return new c(1, bufferOverflow, function1);
        }
    }

    public static /* synthetic */ d b(int i10, BufferOverflow bufferOverflow, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i11 & 4) != 0) {
            function1 = null;
        }
        return a(i10, bufferOverflow, function1);
    }
}
