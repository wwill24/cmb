package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

class SequencesKt__SequencesKt extends k {

    public static final class a implements Sequence<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterator f32166a;

        public a(Iterator it) {
            this.f32166a = it;
        }

        public Iterator<T> iterator() {
            return this.f32166a;
        }
    }

    public static <T> Sequence<T> c(Iterator<? extends T> it) {
        j.g(it, "<this>");
        return d(new a(it));
    }

    public static <T> Sequence<T> d(Sequence<? extends T> sequence) {
        j.g(sequence, "<this>");
        return sequence instanceof a ? sequence : new a(sequence);
    }

    public static <T> Sequence<T> e(T t10, Function1<? super T, ? extends T> function1) {
        j.g(function1, "nextFunction");
        if (t10 == null) {
            return d.f32174a;
        }
        return new f(new SequencesKt__SequencesKt$generateSequence$2(t10), function1);
    }
}
