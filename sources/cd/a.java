package cd;

import com.google.android.datatransport.Priority;

final class a<T> extends c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f34045a;

    /* renamed from: b  reason: collision with root package name */
    private final T f34046b;

    /* renamed from: c  reason: collision with root package name */
    private final Priority f34047c;

    a(Integer num, T t10, Priority priority) {
        this.f34045a = num;
        if (t10 != null) {
            this.f34046b = t10;
            if (priority != null) {
                this.f34047c = priority;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public Integer a() {
        return this.f34045a;
    }

    public T b() {
        return this.f34046b;
    }

    public Priority c() {
        return this.f34047c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        Integer num = this.f34045a;
        if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
            if (this.f34046b.equals(cVar.b()) && this.f34047c.equals(cVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        Integer num = this.f34045a;
        if (num == null) {
            i10 = 0;
        } else {
            i10 = num.hashCode();
        }
        return ((((i10 ^ 1000003) * 1000003) ^ this.f34046b.hashCode()) * 1000003) ^ this.f34047c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f34045a + ", payload=" + this.f34046b + ", priority=" + this.f34047c + "}";
    }
}
