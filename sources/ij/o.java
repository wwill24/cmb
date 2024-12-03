package ij;

import androidx.annotation.NonNull;

public class o<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f30009a;

    o(@NonNull String str) {
        this.f30009a = str;
    }

    @NonNull
    public static <T> o<T> b(@NonNull String str) {
        return new o<>(str);
    }

    public T a(@NonNull q qVar) {
        return qVar.a(this);
    }

    @NonNull
    public T c(@NonNull q qVar) {
        T a10 = a(qVar);
        if (a10 != null) {
            return a10;
        }
        throw new NullPointerException(this.f30009a);
    }

    public void d(@NonNull q qVar, T t10) {
        qVar.b(this, t10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f30009a.equals(((o) obj).f30009a);
    }

    public int hashCode() {
        return this.f30009a.hashCode();
    }

    public String toString() {
        return "Prop{name='" + this.f30009a + '\'' + '}';
    }
}
