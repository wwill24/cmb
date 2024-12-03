package fd;

import android.content.Context;
import androidx.annotation.NonNull;
import od.a;

final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f40799a;

    /* renamed from: b  reason: collision with root package name */
    private final a f40800b;

    /* renamed from: c  reason: collision with root package name */
    private final a f40801c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40802d;

    b(Context context, a aVar, a aVar2, String str) {
        if (context != null) {
            this.f40799a = context;
            if (aVar != null) {
                this.f40800b = aVar;
                if (aVar2 != null) {
                    this.f40801c = aVar2;
                    if (str != null) {
                        this.f40802d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public Context b() {
        return this.f40799a;
    }

    @NonNull
    public String c() {
        return this.f40802d;
    }

    public a d() {
        return this.f40801c;
    }

    public a e() {
        return this.f40800b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (!this.f40799a.equals(fVar.b()) || !this.f40800b.equals(fVar.e()) || !this.f40801c.equals(fVar.d()) || !this.f40802d.equals(fVar.c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((this.f40799a.hashCode() ^ 1000003) * 1000003) ^ this.f40800b.hashCode()) * 1000003) ^ this.f40801c.hashCode()) * 1000003) ^ this.f40802d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f40799a + ", wallClock=" + this.f40800b + ", monotonicClock=" + this.f40801c + ", backendName=" + this.f40802d + "}";
    }
}
