package tl;

import kotlin.jvm.internal.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Object f33874a;

    public b(Object obj) {
        this.f33874a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && j.b(this.f33874a, ((b) obj).f33874a);
    }

    public int hashCode() {
        Object obj = this.f33874a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        Object obj = this.f33874a;
        return "SingleNestedValue(value=" + obj + ")";
    }
}
