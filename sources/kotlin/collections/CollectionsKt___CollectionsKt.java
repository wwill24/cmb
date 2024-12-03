package kotlin.collections;

import gk.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

class CollectionsKt___CollectionsKt extends x {

    public static final class a implements Sequence<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterable f32015a;

        public a(Iterable iterable) {
            this.f32015a = iterable;
        }

        public Iterator<T> iterator() {
            return this.f32015a.iterator();
        }
    }

    public static <T> Set<T> A0(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        return (Set) v0(iterable, new LinkedHashSet());
    }

    public static <T> Set<T> B0(Iterable<? extends T> iterable) {
        Object obj;
        j.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return n0.h((Set) v0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return n0.e();
        }
        if (size != 1) {
            return (Set) v0(iterable, new LinkedHashSet(g0.e(collection.size())));
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = iterable.iterator().next();
        }
        return m0.d(obj);
    }

    public static <T> List<List<T>> C0(Iterable<? extends T> iterable, int i10, int i11, boolean z10) {
        int i12;
        boolean z11;
        int g10;
        j.g(iterable, "<this>");
        SlidingWindowKt.a(i10, i11);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator<List<T>> b10 = SlidingWindowKt.b(iterable.iterator(), i10, i11, z10, false);
            while (b10.hasNext()) {
                arrayList.add(b10.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        int i13 = size / i11;
        if (size % i11 == 0) {
            i12 = 0;
        } else {
            i12 = 1;
        }
        ArrayList arrayList2 = new ArrayList(i13 + i12);
        int i14 = 0;
        while (true) {
            if (i14 < 0 || i14 >= size) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11 || ((g10 = j.g(i10, size - i14)) < i10 && !z10)) {
                return arrayList2;
            }
            ArrayList arrayList3 = new ArrayList(g10);
            for (int i15 = 0; i15 < g10; i15++) {
                arrayList3.add(list.get(i15 + i14));
            }
            arrayList2.add(arrayList3);
            i14 += i11;
        }
        return arrayList2;
    }

    public static <T> Sequence<T> D(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        return new a(iterable);
    }

    public static <T> Iterable<IndexedValue<T>> D0(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        return new z(new CollectionsKt___CollectionsKt$withIndex$1(iterable));
    }

    public static <T> boolean E(Iterable<? extends T> iterable, T t10) {
        j.g(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t10);
        }
        if (R(iterable, t10) >= 0) {
            return true;
        }
        return false;
    }

    public static <T, R> List<Pair<T, R>> E0(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        j.g(iterable, "<this>");
        j.g(iterable2, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(r.t(iterable, 10), r.t(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(h.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static <T> List<T> F(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        return x0(A0(iterable));
    }

    public static <T> List<T> G(Iterable<? extends T> iterable, int i10) {
        boolean z10;
        ArrayList arrayList;
        j.g(iterable, "<this>");
        int i11 = 0;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        } else if (i10 == 0) {
            return x0(iterable);
        } else {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                int size = collection.size() - i10;
                if (size <= 0) {
                    return q.j();
                }
                if (size == 1) {
                    return p.e(X(iterable));
                }
                arrayList = new ArrayList(size);
                if (iterable instanceof List) {
                    if (iterable instanceof RandomAccess) {
                        int size2 = collection.size();
                        while (i10 < size2) {
                            arrayList.add(((List) iterable).get(i10));
                            i10++;
                        }
                    } else {
                        ListIterator listIterator = ((List) iterable).listIterator(i10);
                        while (listIterator.hasNext()) {
                            arrayList.add(listIterator.next());
                        }
                    }
                    return arrayList;
                }
            } else {
                arrayList = new ArrayList();
            }
            for (Object next : iterable) {
                if (i11 >= i10) {
                    arrayList.add(next);
                } else {
                    i11++;
                }
            }
            return q.q(arrayList);
        }
    }

    public static <T> List<T> H(List<? extends T> list, int i10) {
        boolean z10;
        j.g(list, "<this>");
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return s0(list, j.c(list.size() - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static <T> T I(Iterable<? extends T> iterable, int i10) {
        j.g(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).get(i10);
        }
        return J(iterable, i10, new CollectionsKt___CollectionsKt$elementAt$1(i10));
    }

    public static final <T> T J(Iterable<? extends T> iterable, int i10, Function1<? super Integer, ? extends T> function1) {
        j.g(iterable, "<this>");
        j.g(function1, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (i10 < 0 || i10 > q.l(list)) {
                return function1.invoke(Integer.valueOf(i10));
            }
            return list.get(i10);
        } else if (i10 < 0) {
            return function1.invoke(Integer.valueOf(i10));
        } else {
            int i11 = 0;
            for (T next : iterable) {
                int i12 = i11 + 1;
                if (i10 == i11) {
                    return next;
                }
                i11 = i12;
            }
            return function1.invoke(Integer.valueOf(i10));
        }
    }

    public static <T> List<T> K(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        return (List) L(iterable, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C L(Iterable<? extends T> iterable, C c10) {
        j.g(iterable, "<this>");
        j.g(c10, "destination");
        for (Object next : iterable) {
            if (next != null) {
                c10.add(next);
            }
        }
        return c10;
    }

    public static <T> T M(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        if (iterable instanceof List) {
            return N((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T N(List<? extends T> list) {
        j.g(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T O(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    public static <T> T P(List<? extends T> list) {
        j.g(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T Q(List<? extends T> list, int i10) {
        j.g(list, "<this>");
        if (i10 < 0 || i10 > q.l(list)) {
            return null;
        }
        return list.get(i10);
    }

    public static <T> int R(Iterable<? extends T> iterable, T t10) {
        j.g(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t10);
        }
        int i10 = 0;
        for (Object next : iterable) {
            if (i10 < 0) {
                q.s();
            }
            if (j.b(t10, next)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static <T> int S(List<? extends T> list, T t10) {
        j.g(list, "<this>");
        return list.indexOf(t10);
    }

    public static final <T, A extends Appendable> A T(Iterable<? extends T> iterable, A a10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        j.g(iterable, "<this>");
        j.g(a10, "buffer");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (Object next : iterable) {
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

    public static /* synthetic */ Appendable U(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
        String str = (i11 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i11 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i11 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return T(iterable, appendable, str, charSequence6, charSequence5, (i11 & 16) != 0 ? -1 : i10, (i11 & 32) != 0 ? "..." : charSequence4, (i11 & 64) != 0 ? null : function1);
    }

    public static final <T> String V(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        j.g(iterable, "<this>");
        j.g(charSequence, "separator");
        j.g(charSequence2, "prefix");
        j.g(charSequence3, "postfix");
        j.g(charSequence4, "truncated");
        String sb2 = ((StringBuilder) T(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, function1)).toString();
        j.f(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static /* synthetic */ String W(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, Function1 function1, int i11, Object obj) {
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
        return V(iterable, charSequence, charSequence6, charSequence5, i12, charSequence7, function1);
    }

    public static final <T> T X(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        if (iterable instanceof List) {
            return Y((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T Y(List<? extends T> list) {
        j.g(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(q.l(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T Z(List<? extends T> list) {
        j.g(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Double a0(Iterable<Double> iterable) {
        j.g(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    public static <T extends Comparable<? super T>> T b0(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T t10 = (Comparable) it.next();
            while (it.hasNext()) {
                T t11 = (Comparable) it.next();
                if (t10.compareTo(t11) < 0) {
                    t10 = t11;
                }
            }
            return t10;
        }
        throw new NoSuchElementException();
    }

    public static <T extends Comparable<? super T>> T c0(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t10 = (Comparable) it.next();
        while (it.hasNext()) {
            T t11 = (Comparable) it.next();
            if (t10.compareTo(t11) > 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    public static Double d0(Iterable<Double> iterable) {
        j.g(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    public static <T> List<T> e0(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        j.g(iterable, "<this>");
        j.g(iterable2, "elements");
        Collection<? extends T> z10 = v.z(iterable2);
        if (z10.isEmpty()) {
            return x0(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : iterable) {
            if (!z10.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static <T> List<T> f0(Iterable<? extends T> iterable, T t10) {
        j.g(iterable, "<this>");
        ArrayList arrayList = new ArrayList(r.t(iterable, 10));
        boolean z10 = false;
        for (Object next : iterable) {
            boolean z11 = true;
            if (!z10 && j.b(next, t10)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static <T> List<T> g0(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        j.g(iterable, "<this>");
        j.g(iterable2, "elements");
        if (iterable instanceof Collection) {
            return h0((Collection) iterable, iterable2);
        }
        ArrayList arrayList = new ArrayList();
        boolean unused = v.x(arrayList, iterable);
        boolean unused2 = v.x(arrayList, iterable2);
        return arrayList;
    }

    public static <T> List<T> h0(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        j.g(collection, "<this>");
        j.g(iterable, "elements");
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        boolean unused = v.x(arrayList2, iterable);
        return arrayList2;
    }

    public static <T> List<T> i0(Collection<? extends T> collection, T t10) {
        j.g(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t10);
        return arrayList;
    }

    public static <T> T j0(Collection<? extends T> collection, Random random) {
        j.g(collection, "<this>");
        j.g(random, "random");
        if (!collection.isEmpty()) {
            return I(collection, random.d(collection.size()));
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> List<T> k0(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return x0(iterable);
        }
        List<T> y02 = y0(iterable);
        x.C(y02);
        return y02;
    }

    public static <T> T l0(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        if (iterable instanceof List) {
            return m0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T m0(List<? extends T> list) {
        j.g(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static <T> List<T> n0(List<? extends T> list, IntRange intRange) {
        j.g(list, "<this>");
        j.g(intRange, "indices");
        if (intRange.isEmpty()) {
            return q.j();
        }
        return x0(list.subList(intRange.o().intValue(), intRange.n().intValue() + 1));
    }

    public static <T extends Comparable<? super T>> List<T> o0(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return x0(iterable);
            }
            Object[] array2 = collection.toArray(new Comparable[0]);
            k.o((Comparable[]) array2);
            return k.e(array2);
        }
        List<T> y02 = y0(iterable);
        u.v(y02);
        return y02;
    }

    public static <T extends Comparable<? super T>> List<T> p0(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        return q0(iterable, b.c());
    }

    public static <T> List<T> q0(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        j.g(iterable, "<this>");
        j.g(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return x0(iterable);
            }
            Object[] array2 = collection.toArray(new Object[0]);
            k.p(array2, comparator);
            return k.e(array2);
        }
        List<T> y02 = y0(iterable);
        u.w(y02, comparator);
        return y02;
    }

    public static double r0(Iterable<Double> iterable) {
        j.g(iterable, "<this>");
        double d10 = 0.0d;
        for (Double doubleValue : iterable) {
            d10 += doubleValue.doubleValue();
        }
        return d10;
    }

    public static <T> List<T> s0(Iterable<? extends T> iterable, int i10) {
        boolean z10;
        j.g(iterable, "<this>");
        int i11 = 0;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        } else if (i10 == 0) {
            return q.j();
        } else {
            if (iterable instanceof Collection) {
                if (i10 >= ((Collection) iterable).size()) {
                    return x0(iterable);
                }
                if (i10 == 1) {
                    return p.e(M(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i10);
            for (Object add : iterable) {
                arrayList.add(add);
                i11++;
                if (i11 == i10) {
                    break;
                }
            }
            return q.q(arrayList);
        }
    }

    public static <T> List<T> t0(List<? extends T> list, int i10) {
        boolean z10;
        j.g(list, "<this>");
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        } else if (i10 == 0) {
            return q.j();
        } else {
            int size = list.size();
            if (i10 >= size) {
                return x0(list);
            }
            if (i10 == 1) {
                return p.e(Y(list));
            }
            ArrayList arrayList = new ArrayList(i10);
            if (list instanceof RandomAccess) {
                for (int i11 = size - i10; i11 < size; i11++) {
                    arrayList.add(list.get(i11));
                }
            } else {
                ListIterator<? extends T> listIterator = list.listIterator(size - i10);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
            }
            return arrayList;
        }
    }

    public static byte[] u0(Collection<Byte> collection) {
        j.g(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        int i10 = 0;
        for (Byte byteValue : collection) {
            bArr[i10] = byteValue.byteValue();
            i10++;
        }
        return bArr;
    }

    public static final <T, C extends Collection<? super T>> C v0(Iterable<? extends T> iterable, C c10) {
        j.g(iterable, "<this>");
        j.g(c10, "destination");
        for (Object add : iterable) {
            c10.add(add);
        }
        return c10;
    }

    public static int[] w0(Collection<Integer> collection) {
        j.g(collection, "<this>");
        int[] iArr = new int[collection.size()];
        int i10 = 0;
        for (Integer intValue : collection) {
            iArr[i10] = intValue.intValue();
            i10++;
        }
        return iArr;
    }

    public static <T> List<T> x0(Iterable<? extends T> iterable) {
        Object obj;
        j.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return q.q(y0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return q.j();
        }
        if (size != 1) {
            return z0(collection);
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = iterable.iterator().next();
        }
        return p.e(obj);
    }

    public static final <T> List<T> y0(Iterable<? extends T> iterable) {
        j.g(iterable, "<this>");
        if (iterable instanceof Collection) {
            return z0((Collection) iterable);
        }
        return (List) v0(iterable, new ArrayList());
    }

    public static <T> List<T> z0(Collection<? extends T> collection) {
        j.g(collection, "<this>");
        return new ArrayList(collection);
    }
}
