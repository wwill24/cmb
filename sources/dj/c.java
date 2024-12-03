package dj;

import java.io.File;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final File f29552a;

    public c(File file) {
        j.g(file, "data");
        this.f29552a = file;
    }

    public final File a() {
        return this.f29552a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && j.b(this.f29552a, ((c) obj).f29552a);
    }

    public int hashCode() {
        return this.f29552a.hashCode();
    }

    public String toString() {
        return "DocumentFile(data=" + this.f29552a + PropertyUtils.MAPPED_DELIM2;
    }
}
