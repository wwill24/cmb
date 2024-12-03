package j3;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.OutputStream;
import m3.b;

public final class c extends OutputStream {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f15555a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f15556b;

    /* renamed from: c  reason: collision with root package name */
    private b f15557c;

    /* renamed from: d  reason: collision with root package name */
    private int f15558d;

    public c(@NonNull OutputStream outputStream, @NonNull b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void a() throws IOException {
        int i10 = this.f15558d;
        if (i10 > 0) {
            this.f15555a.write(this.f15556b, 0, i10);
            this.f15558d = 0;
        }
    }

    private void b() throws IOException {
        if (this.f15558d == this.f15556b.length) {
            a();
        }
    }

    private void c() {
        byte[] bArr = this.f15556b;
        if (bArr != null) {
            this.f15557c.put(bArr);
            this.f15556b = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void close() throws IOException {
        try {
            flush();
            this.f15555a.close();
            c();
        } catch (Throwable th2) {
            this.f15555a.close();
            throw th2;
        }
    }

    public void flush() throws IOException {
        a();
        this.f15555a.flush();
    }

    public void write(int i10) throws IOException {
        byte[] bArr = this.f15556b;
        int i11 = this.f15558d;
        this.f15558d = i11 + 1;
        bArr[i11] = (byte) i10;
        b();
    }

    c(@NonNull OutputStream outputStream, b bVar, int i10) {
        this.f15555a = outputStream;
        this.f15557c = bVar;
        this.f15556b = (byte[]) bVar.c(i10, byte[].class);
    }

    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(@NonNull byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        do {
            int i13 = i11 - i12;
            int i14 = i10 + i12;
            int i15 = this.f15558d;
            if (i15 != 0 || i13 < this.f15556b.length) {
                int min = Math.min(i13, this.f15556b.length - i15);
                System.arraycopy(bArr, i14, this.f15556b, this.f15558d, min);
                this.f15558d += min;
                i12 += min;
                b();
            } else {
                this.f15555a.write(bArr, i14, i13);
                return;
            }
        } while (i12 < i11);
    }
}
