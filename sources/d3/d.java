package d3;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private float f14431a;

    /* renamed from: b  reason: collision with root package name */
    private float f14432b;

    public d(float f10, float f11) {
        this.f14431a = f10;
        this.f14432b = f11;
    }

    public boolean a(float f10, float f11) {
        return this.f14431a == f10 && this.f14432b == f11;
    }

    public float b() {
        return this.f14431a;
    }

    public float c() {
        return this.f14432b;
    }

    public void d(float f10, float f11) {
        this.f14431a = f10;
        this.f14432b = f11;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public d() {
        this(1.0f, 1.0f);
    }
}
