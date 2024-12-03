package f1;

import java.nio.ByteBuffer;

public class c {

    /* renamed from: a  reason: collision with root package name */
    protected int f14635a;

    /* renamed from: b  reason: collision with root package name */
    protected ByteBuffer f14636b;

    /* renamed from: c  reason: collision with root package name */
    private int f14637c;

    /* renamed from: d  reason: collision with root package name */
    private int f14638d;

    /* renamed from: e  reason: collision with root package name */
    d f14639e = d.a();

    /* access modifiers changed from: protected */
    public int a(int i10) {
        return i10 + this.f14636b.getInt(i10);
    }

    /* access modifiers changed from: protected */
    public int b(int i10) {
        if (i10 < this.f14638d) {
            return this.f14636b.getShort(this.f14637c + i10);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void c(int i10, ByteBuffer byteBuffer) {
        this.f14636b = byteBuffer;
        if (byteBuffer != null) {
            this.f14635a = i10;
            int i11 = i10 - byteBuffer.getInt(i10);
            this.f14637c = i11;
            this.f14638d = this.f14636b.getShort(i11);
            return;
        }
        this.f14635a = 0;
        this.f14637c = 0;
        this.f14638d = 0;
    }

    /* access modifiers changed from: protected */
    public int d(int i10) {
        int i11 = i10 + this.f14635a;
        return i11 + this.f14636b.getInt(i11) + 4;
    }

    /* access modifiers changed from: protected */
    public int e(int i10) {
        int i11 = i10 + this.f14635a;
        return this.f14636b.getInt(i11 + this.f14636b.getInt(i11));
    }
}
