package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;

public final class SlidingWindowKt {
    public static final void a(int i10, int i11) {
        boolean z10;
        String str;
        if (i10 <= 0 || i11 <= 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            if (i10 != i11) {
                str = "Both size " + i10 + " and step " + i11 + " must be greater than zero.";
            } else {
                str = "size " + i10 + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public static final <T> Iterator<List<T>> b(Iterator<? extends T> it, int i10, int i11, boolean z10, boolean z11) {
        j.g(it, "iterator");
        if (!it.hasNext()) {
            return y.f32065a;
        }
        return j.a(new SlidingWindowKt$windowedIterator$1(i10, i11, it, z11, z10, (c<? super SlidingWindowKt$windowedIterator$1>) null));
    }
}
