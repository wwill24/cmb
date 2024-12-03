package kotlin.jvm.internal;

import wk.b;
import wk.l;

public abstract class PropertyReference extends CallableReference implements l {
    public PropertyReference() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public l getReflected() {
        return (l) super.getReflected();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            if (!getOwner().equals(propertyReference.getOwner()) || !getName().equals(propertyReference.getName()) || !getSignature().equals(propertyReference.getSignature()) || !j.b(getBoundReceiver(), propertyReference.getBoundReceiver())) {
                return false;
            }
            return true;
        } else if (obj instanceof l) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PropertyReference(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) != 1 ? false : true);
    }
}
