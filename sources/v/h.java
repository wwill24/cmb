package v;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.s1;

public interface h<T> extends s1 {
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    public static final Config.a<String> f18038w = Config.a.a("camerax.core.target.name", String.class);
    @NonNull

    /* renamed from: x  reason: collision with root package name */
    public static final Config.a<Class<?>> f18039x = Config.a.a("camerax.core.target.class", Class.class);

    String s(String str) {
        return (String) g(f18038w, str);
    }
}
