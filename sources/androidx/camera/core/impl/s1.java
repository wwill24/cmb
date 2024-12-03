package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import java.util.Set;

public interface s1 extends Config {
    <ValueT> ValueT a(@NonNull Config.a<ValueT> aVar) {
        return getConfig().a(aVar);
    }

    boolean b(@NonNull Config.a<?> aVar) {
        return getConfig().b(aVar);
    }

    void c(@NonNull String str, @NonNull Config.b bVar) {
        getConfig().c(str, bVar);
    }

    <ValueT> ValueT d(@NonNull Config.a<ValueT> aVar, @NonNull Config.OptionPriority optionPriority) {
        return getConfig().d(aVar, optionPriority);
    }

    @NonNull
    Set<Config.a<?>> e() {
        return getConfig().e();
    }

    @NonNull
    Set<Config.OptionPriority> f(@NonNull Config.a<?> aVar) {
        return getConfig().f(aVar);
    }

    <ValueT> ValueT g(@NonNull Config.a<ValueT> aVar, ValueT valuet) {
        return getConfig().g(aVar, valuet);
    }

    @NonNull
    Config getConfig();

    @NonNull
    Config.OptionPriority h(@NonNull Config.a<?> aVar) {
        return getConfig().h(aVar);
    }
}
