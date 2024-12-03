package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

class SequencesKt___SequencesKt extends l {

    public static final class a implements Iterable<T>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Sequence f32167a;

        public a(Sequence sequence) {
            this.f32167a = sequence;
        }

        public Iterator<T> iterator() {
            return this.f32167a.iterator();
        }
    }

    public static <T> boolean f(Sequence<? extends T> sequence) {
        j.g(sequence, "<this>");
        return sequence.iterator().hasNext();
    }

    public static <T> Iterable<T> g(Sequence<? extends T> sequence) {
        j.g(sequence, "<this>");
        return new a(sequence);
    }

    public static <T> Sequence<T> h(Sequence<? extends T> sequence, int i10) {
        boolean z10;
        j.g(sequence, "<this>");
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        } else if (i10 == 0) {
            return sequence;
        } else {
            if (sequence instanceof c) {
                return ((c) sequence).a(i10);
            }
            return new b(sequence, i10);
        }
    }

    public static <T> Sequence<T> i(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        j.g(sequence, "<this>");
        j.g(function1, "predicate");
        return new e(sequence, true, function1);
    }

    public static final <T> Sequence<T> j(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        j.g(sequence, "<this>");
        j.g(function1, "predicate");
        return new e(sequence, false, function1);
    }

    public static final <T> Sequence<T> k(Sequence<? extends T> sequence) {
        j.g(sequence, "<this>");
        Sequence<T> j10 = j(sequence, SequencesKt___SequencesKt$filterNotNull$1.f32168a);
        j.e(j10, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return j10;
    }

    public static <T> T l(Sequence<? extends T> sequence) {
        j.g(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static <T> T m(Sequence<? extends T> sequence) {
        j.g(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    public static final <T, A extends Appendable> A n(Sequence<? extends T> sequence, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        j.g(sequence, "<this>");
        j.g(a10, "buffer");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (Object next : sequence) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            k.a(a10, next, function1);
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final <T> String o(Sequence<? extends T> sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        j.g(sequence, "<this>");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        String sb2 = ((StringBuilder) n(sequence, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, function1)).toString();
        j.f(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static /* synthetic */ String p(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i11 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i11 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            function1 = null;
        }
        return o(sequence, charSequence, charSequence6, charSequence5, i12, charSequence7, function1);
    }

    public static <T, R> Sequence<R> q(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        j.g(sequence, "<this>");
        j.g(function1, "transform");
        return new m(sequence, function1);
    }

    public static <T, R> Sequence<R> r(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        j.g(sequence, "<this>");
        j.g(function1, "transform");
        return k(new m(sequence, function1));
    }

    public static final <T, C extends Collection<? super T>> C s(Sequence<? extends T> sequence, C c10) {
        j.g(sequence, "<this>");
        j.g(c10, "destination");
        for (Object add : sequence) {
            c10.add(add);
        }
        return c10;
    }

    public static <T> List<T> t(Sequence<? extends T> sequence) {
        j.g(sequence, "<this>");
        return q.q(u(sequence));
    }

    public static final <T> List<T> u(Sequence<? extends T> sequence) {
        j.g(sequence, "<this>");
        return (List) s(sequence, new ArrayList());
    }

    public static <T> Set<T> v(Sequence<? extends T> sequence) {
        j.g(sequence, "<this>");
        return n0.h((Set) s(sequence, new LinkedHashSet()));
    }
}
