package xl;

class a {

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f24687a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private int f24688b = 0;

    public void a(CharSequence charSequence) {
        if (this.f24688b != 0) {
            this.f24687a.append(10);
        }
        this.f24687a.append(charSequence);
        this.f24688b++;
    }

    public String b() {
        return this.f24687a.toString();
    }
}
