package t3;

import androidx.annotation.NonNull;
import f4.j;
import l3.c;

public class b implements c<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f17797a;

    public b(byte[] bArr) {
        this.f17797a = (byte[]) j.d(bArr);
    }

    public void a() {
    }

    @NonNull
    public Class<byte[]> b() {
        return byte[].class;
    }

    @NonNull
    /* renamed from: c */
    public byte[] get() {
        return this.f17797a;
    }

    public int getSize() {
        return this.f17797a.length;
    }
}
