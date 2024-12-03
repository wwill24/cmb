package ce;

import androidx.annotation.NonNull;

public class a {

    /* renamed from: b  reason: collision with root package name */
    static int f34049b = 31;

    /* renamed from: a  reason: collision with root package name */
    private int f34050a = 1;

    @NonNull
    public a a(Object obj) {
        this.f34050a = (f34049b * this.f34050a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int b() {
        return this.f34050a;
    }

    @NonNull
    public final a c(boolean z10) {
        this.f34050a = (f34049b * this.f34050a) + (z10 ? 1 : 0);
        return this;
    }
}
