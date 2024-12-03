package kotlin.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.MethodDelegation;
import org.jivesoftware.smackx.mam.element.MamElements;

public final class f<T> implements c<T>, c {

    /* renamed from: b  reason: collision with root package name */
    private static final a f32076b = new a((DefaultConstructorMarker) null);
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<f<?>, Object> f32077c = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, MamElements.MamResultExtension.ELEMENT);

    /* renamed from: a  reason: collision with root package name */
    private final c<T> f32078a;
    private volatile Object result;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(c<? super T> cVar, Object obj) {
        j.g(cVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.f32078a = cVar;
        this.result = obj;
    }

    public final Object b() {
        Object obj = this.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
        if (obj == coroutineSingletons) {
            if (androidx.concurrent.futures.a.a(f32077c, this, coroutineSingletons, b.d())) {
                return b.d();
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.RESUMED) {
            return b.d();
        }
        if (!(obj instanceof Result.Failure)) {
            return obj;
        }
        throw ((Result.Failure) obj).exception;
    }

    public c getCallerFrame() {
        c<T> cVar = this.f32078a;
        if (cVar instanceof c) {
            return (c) cVar;
        }
        return null;
    }

    public CoroutineContext getContext() {
        return this.f32078a.getContext();
    }

    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
            if (obj2 == coroutineSingletons) {
                if (androidx.concurrent.futures.a.a(f32077c, this, coroutineSingletons, obj)) {
                    return;
                }
            } else if (obj2 != b.d()) {
                throw new IllegalStateException("Already resumed");
            } else if (androidx.concurrent.futures.a.a(f32077c, this, b.d(), CoroutineSingletons.RESUMED)) {
                this.f32078a.resumeWith(obj);
                return;
            }
        }
    }

    public String toString() {
        return "SafeContinuation for " + this.f32078a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public f(c<? super T> cVar) {
        this(cVar, CoroutineSingletons.UNDECIDED);
        j.g(cVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
    }
}
