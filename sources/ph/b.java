package ph;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f24387a;

    /* renamed from: b  reason: collision with root package name */
    private int f24388b = 0;

    b(int i10) {
        this.f24387a = new byte[i10];
    }

    private void c(int i10, boolean z10) {
        this.f24387a[i10] = z10 ? (byte) 1 : 0;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z10, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = this.f24388b;
            this.f24388b = i12 + 1;
            c(i12, z10);
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] b(int i10) {
        int length = this.f24387a.length * i10;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = this.f24387a[i11 / i10];
        }
        return bArr;
    }
}
