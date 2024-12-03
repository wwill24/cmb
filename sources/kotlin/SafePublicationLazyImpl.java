package kotlin;

import gk.f;
import gk.o;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

final class SafePublicationLazyImpl<T> implements f<T>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32011a = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> f32012b = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    private volatile Object _value;

    /* renamed from: final  reason: not valid java name */
    private final Object f2final;
    private volatile Function0<? extends T> initializer;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SafePublicationLazyImpl(Function0<? extends T> function0) {
        j.g(function0, "initializer");
        this.initializer = function0;
        o oVar = o.f29709a;
        this._value = oVar;
        this.f2final = oVar;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public T getValue() {
        T t10 = this._value;
        T t11 = o.f29709a;
        if (t10 != t11) {
            return t10;
        }
        Function0<? extends T> function0 = this.initializer;
        if (function0 != null) {
            T invoke = function0.invoke();
            if (androidx.concurrent.futures.a.a(f32012b, this, t11, invoke)) {
                this.initializer = null;
                return invoke;
            }
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
