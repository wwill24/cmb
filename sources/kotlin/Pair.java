package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public Pair(A a10, B b10) {
        this.first = a10;
        this.second = b10;
    }

    public final A a() {
        return this.first;
    }

    public final B b() {
        return this.second;
    }

    public final A c() {
        return this.first;
    }

    public final B d() {
        return this.second;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return j.b(this.first, pair.first) && j.b(this.second, pair.second);
    }

    public int hashCode() {
        A a10 = this.first;
        int i10 = 0;
        int hashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.second;
        if (b10 != null) {
            i10 = b10.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return PropertyUtils.MAPPED_DELIM + this.first + ", " + this.second + PropertyUtils.MAPPED_DELIM2;
    }
}
