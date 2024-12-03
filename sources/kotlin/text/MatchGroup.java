package kotlin.text;

import kotlin.jvm.internal.j;
import kotlin.ranges.IntRange;
import org.apache.commons.beanutils.PropertyUtils;

public final class MatchGroup {

    /* renamed from: a  reason: collision with root package name */
    private final String f32196a;

    /* renamed from: b  reason: collision with root package name */
    private final IntRange f32197b;

    public MatchGroup(String str, IntRange intRange) {
        j.g(str, "value");
        j.g(intRange, "range");
        this.f32196a = str;
        this.f32197b = intRange;
    }

    public final String a() {
        return this.f32196a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchGroup)) {
            return false;
        }
        MatchGroup matchGroup = (MatchGroup) obj;
        return j.b(this.f32196a, matchGroup.f32196a) && j.b(this.f32197b, matchGroup.f32197b);
    }

    public int hashCode() {
        return (this.f32196a.hashCode() * 31) + this.f32197b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f32196a + ", range=" + this.f32197b + PropertyUtils.MAPPED_DELIM2;
    }
}
