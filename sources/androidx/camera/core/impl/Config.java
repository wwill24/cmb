package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.Set;

public interface Config {

    public enum OptionPriority {
        ALWAYS_OVERRIDE,
        REQUIRED,
        OPTIONAL
    }

    public static abstract class a<T> {
        a() {
        }

        @NonNull
        public static <T> a<T> a(@NonNull String str, @NonNull Class<?> cls) {
            return b(str, cls, (Object) null);
        }

        @NonNull
        public static <T> a<T> b(@NonNull String str, @NonNull Class<?> cls, Object obj) {
            return new e(str, cls, obj);
        }

        @NonNull
        public abstract String c();

        public abstract Object d();

        @NonNull
        public abstract Class<T> e();
    }

    public interface b {
        boolean a(@NonNull a<?> aVar);
    }

    @NonNull
    static Config D(Config config, Config config2) {
        i1 i1Var;
        if (config == null && config2 == null) {
            return n1.L();
        }
        if (config2 != null) {
            i1Var = i1.P(config2);
        } else {
            i1Var = i1.O();
        }
        if (config != null) {
            for (a next : config.e()) {
                i1Var.n(next, config.h(next), config.a(next));
            }
        }
        return n1.M(i1Var);
    }

    static boolean v(@NonNull OptionPriority optionPriority, @NonNull OptionPriority optionPriority2) {
        OptionPriority optionPriority3 = OptionPriority.ALWAYS_OVERRIDE;
        if (optionPriority == optionPriority3 && optionPriority2 == optionPriority3) {
            return true;
        }
        OptionPriority optionPriority4 = OptionPriority.REQUIRED;
        if (optionPriority == optionPriority4 && optionPriority2 == optionPriority4) {
            return true;
        }
        return false;
    }

    <ValueT> ValueT a(@NonNull a<ValueT> aVar);

    boolean b(@NonNull a<?> aVar);

    void c(@NonNull String str, @NonNull b bVar);

    <ValueT> ValueT d(@NonNull a<ValueT> aVar, @NonNull OptionPriority optionPriority);

    @NonNull
    Set<a<?>> e();

    @NonNull
    Set<OptionPriority> f(@NonNull a<?> aVar);

    <ValueT> ValueT g(@NonNull a<ValueT> aVar, ValueT valuet);

    @NonNull
    OptionPriority h(@NonNull a<?> aVar);
}
