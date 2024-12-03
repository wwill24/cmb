package cd;

import androidx.annotation.NonNull;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f34048a;

    private b(@NonNull String str) {
        if (str != null) {
            this.f34048a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public static b b(@NonNull String str) {
        return new b(str);
    }

    public String a() {
        return this.f34048a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f34048a.equals(((b) obj).f34048a);
    }

    public int hashCode() {
        return this.f34048a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return "Encoding{name=\"" + this.f34048a + "\"}";
    }
}
