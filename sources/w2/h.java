package w2;

import androidx.core.util.d;

public class h<T> {

    /* renamed from: a  reason: collision with root package name */
    T f18186a;

    /* renamed from: b  reason: collision with root package name */
    T f18187b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(T t10, T t11) {
        this.f18186a = t10;
        this.f18187b = t11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!a(dVar.f4735a, this.f18186a) || !a(dVar.f4736b, this.f18187b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t10 = this.f18186a;
        int i10 = 0;
        int hashCode = t10 == null ? 0 : t10.hashCode();
        T t11 = this.f18187b;
        if (t11 != null) {
            i10 = t11.hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "Pair{" + this.f18186a + " " + this.f18187b + "}";
    }
}
