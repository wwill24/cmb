package kotlin;

import gk.f;
import java.io.Serializable;

public final class InitializedLazyImpl<T> implements f<T>, Serializable {
    private final T value;

    public InitializedLazyImpl(T t10) {
        this.value = t10;
    }

    public T getValue() {
        return this.value;
    }

    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
