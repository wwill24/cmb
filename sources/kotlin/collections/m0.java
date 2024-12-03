package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.internal.j;

class m0 {
    public static <E> Set<E> a(Set<E> set) {
        j.g(set, "builder");
        return ((SetBuilder) set).d();
    }

    public static <E> Set<E> b() {
        return new SetBuilder();
    }

    public static <E> Set<E> c(int i10) {
        return new SetBuilder(i10);
    }

    public static <T> Set<T> d(T t10) {
        Set<T> singleton = Collections.singleton(t10);
        j.f(singleton, "singleton(element)");
        return singleton;
    }
}
