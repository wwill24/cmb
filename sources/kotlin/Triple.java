package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class Triple<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public Triple(A a10, B b10, C c10) {
        this.first = a10;
        this.second = b10;
        this.third = c10;
    }

    public final A a() {
        return this.first;
    }

    public final B b() {
        return this.second;
    }

    public final C c() {
        return this.third;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return j.b(this.first, triple.first) && j.b(this.second, triple.second) && j.b(this.third, triple.third);
    }

    public int hashCode() {
        A a10 = this.first;
        int i10 = 0;
        int hashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.second;
        int hashCode2 = (hashCode + (b10 == null ? 0 : b10.hashCode())) * 31;
        C c10 = this.third;
        if (c10 != null) {
            i10 = c10.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return PropertyUtils.MAPPED_DELIM + this.first + ", " + this.second + ", " + this.third + PropertyUtils.MAPPED_DELIM2;
    }
}
