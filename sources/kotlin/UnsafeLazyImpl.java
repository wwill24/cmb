package kotlin;

import gk.f;
import gk.o;
import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;

public final class UnsafeLazyImpl<T> implements f<T>, Serializable {
    private Object _value = o.f29709a;
    private Function0<? extends T> initializer;

    public UnsafeLazyImpl(Function0<? extends T> function0) {
        j.g(function0, "initializer");
        this.initializer = function0;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public T getValue() {
        if (this._value == o.f29709a) {
            Function0<? extends T> function0 = this.initializer;
            j.d(function0);
            this._value = function0.invoke();
            this.initializer = null;
        }
        return this._value;
    }

    public boolean isInitialized() {
        return this._value != o.f29709a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
