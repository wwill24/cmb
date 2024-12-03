package gh;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f23436a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23437b;

    public int a() {
        return this.f23437b;
    }

    public int b() {
        return this.f23436a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f23436a == aVar.f23436a && this.f23437b == aVar.f23437b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f23436a * 32713) + this.f23437b;
    }

    public String toString() {
        return this.f23436a + "x" + this.f23437b;
    }
}
