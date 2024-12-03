package f4;

import androidx.annotation.NonNull;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f14724a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f14725b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f14726c;

    public i() {
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, Class<?> cls3) {
        this.f14724a = cls;
        this.f14725b = cls2;
        this.f14726c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f14724a.equals(iVar.f14724a) && this.f14725b.equals(iVar.f14725b) && k.c(this.f14726c, iVar.f14726c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = ((this.f14724a.hashCode() * 31) + this.f14725b.hashCode()) * 31;
        Class<?> cls = this.f14726c;
        if (cls != null) {
            i10 = cls.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f14724a + ", second=" + this.f14725b + '}';
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
