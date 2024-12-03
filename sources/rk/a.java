package rk;

import java.util.Optional;
import kotlin.jvm.internal.j;

public final class a {
    public static final <T> T a(Optional<T> optional) {
        j.g(optional, "<this>");
        return optional.orElse((Object) null);
    }
}
