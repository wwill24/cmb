package f3;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class c implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f14695a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Charset f14696b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f14697c;

    /* renamed from: d  reason: collision with root package name */
    private int f14698d;

    /* renamed from: e  reason: collision with root package name */
    private int f14699e;

    class a extends ByteArrayOutputStream {
        a(int i10) {
            super(i10);
        }

        public String toString() {
            int i10 = this.count;
            if (i10 > 0 && this.buf[i10 - 1] == 13) {
                i10--;
            }
            try {
                return new String(this.buf, 0, i10, c.this.f14696b.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public c(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void b() throws IOException {
        InputStream inputStream = this.f14695a;
        byte[] bArr = this.f14697c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f14698d = 0;
            this.f14699e = read;
            return;
        }
        throw new EOFException();
    }

    public boolean c() {
        return this.f14699e == -1;
    }

    public void close() throws IOException {
        synchronized (this.f14695a) {
            if (this.f14697c != null) {
                this.f14697c = null;
                this.f14695a.close();
            }
        }
    }

    public String e() throws IOException {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.f14695a) {
            if (this.f14697c != null) {
                if (this.f14698d >= this.f14699e) {
                    b();
                }
                for (int i12 = this.f14698d; i12 != this.f14699e; i12++) {
                    byte[] bArr2 = this.f14697c;
                    if (bArr2[i12] == 10) {
                        int i13 = this.f14698d;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] == 13) {
                                String str = new String(bArr2, i13, i11 - i13, this.f14696b.name());
                                this.f14698d = i12 + 1;
                                return str;
                            }
                        }
                        i11 = i12;
                        String str2 = new String(bArr2, i13, i11 - i13, this.f14696b.name());
                        this.f14698d = i12 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f14699e - this.f14698d) + 80);
                loop1:
                while (true) {
                    byte[] bArr3 = this.f14697c;
                    int i14 = this.f14698d;
                    aVar.write(bArr3, i14, this.f14699e - i14);
                    this.f14699e = -1;
                    b();
                    i10 = this.f14698d;
                    while (true) {
                        if (i10 != this.f14699e) {
                            bArr = this.f14697c;
                            if (bArr[i10] == 10) {
                                break loop1;
                            }
                            i10++;
                        }
                    }
                }
                int i15 = this.f14698d;
                if (i10 != i15) {
                    aVar.write(bArr, i15, i10 - i15);
                }
                this.f14698d = i10 + 1;
                String byteArrayOutputStream = aVar.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public c(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i10 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(d.f14701a)) {
            this.f14695a = inputStream;
            this.f14696b = charset;
            this.f14697c = new byte[i10];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
