package ij;

import am.r;
import androidx.annotation.NonNull;

public interface j {

    public interface a {
        @NonNull
        <N extends r> a a(@NonNull Class<N> cls, s sVar);

        @NonNull
        j build();
    }

    <N extends r> s get(@NonNull Class<N> cls);
}
