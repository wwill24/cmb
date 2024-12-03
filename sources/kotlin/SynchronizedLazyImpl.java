package kotlin;

import gk.f;
import gk.o;
import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

final class SynchronizedLazyImpl<T> implements f<T>, Serializable {
    private volatile Object _value;
    private Function0<? extends T> initializer;
    private final Object lock;

    public SynchronizedLazyImpl(Function0<? extends T> function0, Object obj) {
        j.g(function0, "initializer");
        this.initializer = function0;
        this._value = o.f29709a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public T getValue() {
        T t10;
        T t11 = this._value;
        T t12 = o.f29709a;
        if (t11 != t12) {
            return t11;
        }
        synchronized (this.lock) {
            t10 = this._value;
            if (t10 == t12) {
                Function0 function0 = this.initializer;
                j.d(function0);
                t10 = function0.invoke();
                this._value = t10;
                this.initializer = null;
            }
        }
        return t10;
    }

    public boolean isInitialized() {
        return this._value != o.f29709a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SynchronizedLazyImpl(Function0 function0, Object obj, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i10 & 2) != 0 ? null : obj);
    }
}
