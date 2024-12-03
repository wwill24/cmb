package kotlin.coroutines;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CombinedContext implements CoroutineContext, Serializable {
    private final CoroutineContext.Element element;
    private final CoroutineContext left;

    private static final class Serialized implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32067a = new a((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 0;
        private final CoroutineContext[] elements;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Serialized(CoroutineContext[] coroutineContextArr) {
            j.g(coroutineContextArr, "elements");
            this.elements = coroutineContextArr;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.elements;
            CoroutineContext coroutineContext = EmptyCoroutineContext.f32070a;
            for (CoroutineContext e02 : coroutineContextArr) {
                coroutineContext = coroutineContext.e0(e02);
            }
            return coroutineContext;
        }
    }

    public CombinedContext(CoroutineContext coroutineContext, CoroutineContext.Element element2) {
        j.g(coroutineContext, ViewHierarchyConstants.DIMENSION_LEFT_KEY);
        j.g(element2, "element");
        this.left = coroutineContext;
        this.element = element2;
    }

    private final boolean d(CoroutineContext.Element element2) {
        return j.b(c(element2.getKey()), element2);
    }

    private final boolean i(CombinedContext combinedContext) {
        while (d(combinedContext.element)) {
            CoroutineContext coroutineContext = combinedContext.left;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                j.e(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return d((CoroutineContext.Element) coroutineContext);
            }
        }
        return false;
    }

    private final int j() {
        int i10 = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.left;
            combinedContext = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return i10;
            }
            i10++;
        }
    }

    private final Object writeReplace() {
        boolean z10;
        int j10 = j();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[j10];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        v0(Unit.f32013a, new CombinedContext$writeReplace$1(coroutineContextArr, ref$IntRef));
        if (ref$IntRef.element == j10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return new Serialized(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public <E extends CoroutineContext.Element> E c(CoroutineContext.a<E> aVar) {
        j.g(aVar, SDKConstants.PARAM_KEY);
        CombinedContext combinedContext = this;
        while (true) {
            E c10 = combinedContext.element.c(aVar);
            if (c10 != null) {
                return c10;
            }
            CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                return coroutineContext.c(aVar);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public CoroutineContext e0(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.a(this, coroutineContext);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.j() != j() || !combinedContext.i(this)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    public String toString() {
        return '[' + ((String) v0("", CombinedContext$toString$1.f32068a)) + PropertyUtils.INDEXED_DELIM2;
    }

    public CoroutineContext u0(CoroutineContext.a<?> aVar) {
        j.g(aVar, SDKConstants.PARAM_KEY);
        if (this.element.c(aVar) != null) {
            return this.left;
        }
        CoroutineContext u02 = this.left.u0(aVar);
        if (u02 == this.left) {
            return this;
        }
        if (u02 == EmptyCoroutineContext.f32070a) {
            return this.element;
        }
        return new CombinedContext(u02, this.element);
    }

    public <R> R v0(R r10, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        j.g(function2, "operation");
        return function2.invoke(this.left.v0(r10, function2), this.element);
    }
}
