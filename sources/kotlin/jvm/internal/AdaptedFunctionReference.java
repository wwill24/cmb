package kotlin.jvm.internal;

import java.io.Serializable;

public class AdaptedFunctionReference implements g, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(int i10, Class cls, String str, String str2, int i11) {
        this(i10, CallableReference.NO_RECEIVER, cls, str, str2, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        if (this.isTopLevel != adaptedFunctionReference.isTopLevel || this.arity != adaptedFunctionReference.arity || this.flags != adaptedFunctionReference.flags || !j.b(this.receiver, adaptedFunctionReference.receiver) || !j.b(this.owner, adaptedFunctionReference.owner) || !this.name.equals(adaptedFunctionReference.name) || !this.signature.equals(adaptedFunctionReference.signature)) {
            return false;
        }
        return true;
    }

    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        int i10;
        int i11;
        Object obj = this.receiver;
        int i12 = 0;
        if (obj != null) {
            i10 = obj.hashCode();
        } else {
            i10 = 0;
        }
        int i13 = i10 * 31;
        Class cls = this.owner;
        if (cls != null) {
            i12 = cls.hashCode();
        }
        int hashCode = (((((i13 + i12) * 31) + this.name.hashCode()) * 31) + this.signature.hashCode()) * 31;
        if (this.isTopLevel) {
            i11 = 1231;
        } else {
            i11 = 1237;
        }
        return ((((hashCode + i11) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        return l.i(this);
    }

    public AdaptedFunctionReference(int i10, Object obj, Class cls, String str, String str2, int i11) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = (i11 & 1) == 1;
        this.arity = i10;
        this.flags = i11 >> 1;
    }
}
