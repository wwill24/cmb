package c3;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private float f7940a;

    /* renamed from: b  reason: collision with root package name */
    private int f7941b;

    public void a(float f10) {
        float f11 = this.f7940a + f10;
        this.f7940a = f11;
        int i10 = this.f7941b + 1;
        this.f7941b = i10;
        if (i10 == Integer.MAX_VALUE) {
            this.f7940a = f11 / 2.0f;
            this.f7941b = i10 / 2;
        }
    }
}
