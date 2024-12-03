package j$.time.format;

public enum H {
    FULL(0),
    FULL_STANDALONE(0),
    SHORT(1),
    SHORT_STANDALONE(1),
    NARROW(1),
    NARROW_STANDALONE(1);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f42618a;

    private H(int i10) {
        this.f42618a = i10;
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        return this.f42618a;
    }
}
