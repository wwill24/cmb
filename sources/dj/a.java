package dj;

import java.io.Closeable;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.withpersona.sdk2.inquiry.types.collected_data.a> f29549a;

    public a(List<? extends com.withpersona.sdk2.inquiry.types.collected_data.a> list) {
        j.g(list, "stepData");
        this.f29549a = list;
    }

    public void close() {
        for (com.withpersona.sdk2.inquiry.types.collected_data.a close : this.f29549a) {
            close.close();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && j.b(this.f29549a, ((a) obj).f29549a);
    }

    public int hashCode() {
        return this.f29549a.hashCode();
    }

    public String toString() {
        return "CollectedData(stepData=" + this.f29549a + PropertyUtils.MAPPED_DELIM2;
    }
}
