package xk;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.jvm.internal.j;

public final class a {
    public static final <T> List<T> a(Stream<T> stream) {
        j.g(stream, "<this>");
        Object collect = stream.collect(Collectors.toList());
        j.f(collect, "collect(Collectors.toList<T>())");
        return (List) collect;
    }
}
