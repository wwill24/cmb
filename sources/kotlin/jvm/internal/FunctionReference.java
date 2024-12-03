package kotlin.jvm.internal;

import net.bytebuddy.description.method.MethodDescription;
import wk.b;
import wk.g;

public class FunctionReference extends CallableReference implements g, g {
    private final int arity;
    private final int flags;

    public FunctionReference(int i10) {
        this(i10, CallableReference.NO_RECEIVER, (Class) null, (String) null, (String) null, 0);
    }

    /* access modifiers changed from: protected */
    public b computeReflected() {
        return l.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            if (!getName().equals(functionReference.getName()) || !getSignature().equals(functionReference.getSignature()) || this.flags != functionReference.flags || this.arity != functionReference.arity || !j.b(getBoundReceiver(), functionReference.getBoundReceiver()) || !j.b(getOwner(), functionReference.getOwner())) {
                return false;
            }
            return true;
        } else if (obj instanceof g) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public boolean isExternal() {
        return getReflected().isExternal();
    }

    public boolean isInfix() {
        return getReflected().isInfix();
    }

    public boolean isInline() {
        return getReflected().isInline();
    }

    public boolean isOperator() {
        return getReflected().isOperator();
    }

    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if (MethodDescription.CONSTRUCTOR_INTERNAL_NAME.equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public FunctionReference(int i10, Object obj) {
        this(i10, obj, (Class) null, (String) null, (String) null, 0);
    }

    /* access modifiers changed from: protected */
    public g getReflected() {
        return (g) super.getReflected();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionReference(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, (i11 & 1) == 1);
        this.arity = i10;
        this.flags = i11 >> 1;
    }
}
