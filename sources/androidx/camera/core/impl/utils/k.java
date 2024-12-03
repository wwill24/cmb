package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.ExifData;
import androidx.core.util.h;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;

public final class k extends FilterOutputStream {

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f2673g = "Exif\u0000\u0000".getBytes(j.f2665e);

    /* renamed from: a  reason: collision with root package name */
    private final ExifData f2674a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f2675b = new byte[1];

    /* renamed from: c  reason: collision with root package name */
    private final ByteBuffer f2676c = ByteBuffer.allocate(4);

    /* renamed from: d  reason: collision with root package name */
    private int f2677d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f2678e;

    /* renamed from: f  reason: collision with root package name */
    private int f2679f;

    static final class a {
        public static boolean a(short s10) {
            return (s10 < -64 || s10 > -49 || s10 == -60 || s10 == -56 || s10 == -52) ? false : true;
        }
    }

    public k(@NonNull OutputStream outputStream, @NonNull ExifData exifData) {
        super(new BufferedOutputStream(outputStream, 65536));
        this.f2674a = exifData;
    }

    private int a(int i10, byte[] bArr, int i11, int i12) {
        int min = Math.min(i12, i10 - this.f2676c.position());
        this.f2676c.put(bArr, i11, min);
        return min;
    }

    private void b(@NonNull b bVar) throws IOException {
        short s10;
        l[][] lVarArr = ExifData.f2592i;
        int[] iArr = new int[lVarArr.length];
        int[] iArr2 = new int[lVarArr.length];
        for (l lVar : ExifData.f2590g) {
            for (int i10 = 0; i10 < ExifData.f2592i.length; i10++) {
                this.f2674a.c(i10).remove(lVar.f2681b);
            }
        }
        if (!this.f2674a.c(1).isEmpty()) {
            this.f2674a.c(0).put(ExifData.f2590g[1].f2681b, j.f(0, this.f2674a.d()));
        }
        if (!this.f2674a.c(2).isEmpty()) {
            this.f2674a.c(0).put(ExifData.f2590g[2].f2681b, j.f(0, this.f2674a.d()));
        }
        if (!this.f2674a.c(3).isEmpty()) {
            this.f2674a.c(1).put(ExifData.f2590g[3].f2681b, j.f(0, this.f2674a.d()));
        }
        for (int i11 = 0; i11 < ExifData.f2592i.length; i11++) {
            int i12 = 0;
            for (Map.Entry<String, j> value : this.f2674a.c(i11).entrySet()) {
                int j10 = ((j) value.getValue()).j();
                if (j10 > 4) {
                    i12 += j10;
                }
            }
            iArr2[i11] = iArr2[i11] + i12;
        }
        int i13 = 8;
        for (int i14 = 0; i14 < ExifData.f2592i.length; i14++) {
            if (!this.f2674a.c(i14).isEmpty()) {
                iArr[i14] = i13;
                i13 += (this.f2674a.c(i14).size() * 12) + 2 + 4 + iArr2[i14];
            }
        }
        int i15 = i13 + 8;
        if (!this.f2674a.c(1).isEmpty()) {
            this.f2674a.c(0).put(ExifData.f2590g[1].f2681b, j.f((long) iArr[1], this.f2674a.d()));
        }
        if (!this.f2674a.c(2).isEmpty()) {
            this.f2674a.c(0).put(ExifData.f2590g[2].f2681b, j.f((long) iArr[2], this.f2674a.d()));
        }
        if (!this.f2674a.c(3).isEmpty()) {
            this.f2674a.c(1).put(ExifData.f2590g[3].f2681b, j.f((long) iArr[3], this.f2674a.d()));
        }
        bVar.g(i15);
        bVar.write(f2673g);
        if (this.f2674a.d() == ByteOrder.BIG_ENDIAN) {
            s10 = 19789;
        } else {
            s10 = 18761;
        }
        bVar.e(s10);
        bVar.a(this.f2674a.d());
        bVar.g(42);
        bVar.f(8);
        for (int i16 = 0; i16 < ExifData.f2592i.length; i16++) {
            if (!this.f2674a.c(i16).isEmpty()) {
                bVar.g(this.f2674a.c(i16).size());
                int size = iArr[i16] + 2 + (this.f2674a.c(i16).size() * 12) + 4;
                for (Map.Entry next : this.f2674a.c(i16).entrySet()) {
                    int i17 = ((l) h.h((l) ExifData.b.f2604f.get(i16).get(next.getKey()), "Tag not supported: " + ((String) next.getKey()) + ". Tag needs to be ported from ExifInterface to ExifData.")).f2680a;
                    j jVar = (j) next.getValue();
                    int j11 = jVar.j();
                    bVar.g(i17);
                    bVar.g(jVar.f2669a);
                    bVar.c(jVar.f2670b);
                    if (j11 > 4) {
                        bVar.f((long) size);
                        size += j11;
                    } else {
                        bVar.write(jVar.f2672d);
                        if (j11 < 4) {
                            while (j11 < 4) {
                                bVar.b(0);
                                j11++;
                            }
                        }
                    }
                }
                bVar.f(0);
                for (Map.Entry<String, j> value2 : this.f2674a.c(i16).entrySet()) {
                    byte[] bArr = ((j) value2.getValue()).f2672d;
                    if (bArr.length > 4) {
                        bVar.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        bVar.a(ByteOrder.BIG_ENDIAN);
    }

    public void write(@NonNull byte[] bArr, int i10, int i11) throws IOException {
        while (true) {
            int i12 = this.f2678e;
            if ((i12 > 0 || this.f2679f > 0 || this.f2677d != 2) && i11 > 0) {
                if (i12 > 0) {
                    int min = Math.min(i11, i12);
                    i11 -= min;
                    this.f2678e -= min;
                    i10 += min;
                }
                int i13 = this.f2679f;
                if (i13 > 0) {
                    int min2 = Math.min(i11, i13);
                    this.out.write(bArr, i10, min2);
                    i11 -= min2;
                    this.f2679f -= min2;
                    i10 += min2;
                }
                if (i11 != 0) {
                    int i14 = this.f2677d;
                    if (i14 == 0) {
                        int a10 = a(2, bArr, i10, i11);
                        i10 += a10;
                        i11 -= a10;
                        if (this.f2676c.position() >= 2) {
                            this.f2676c.rewind();
                            if (this.f2676c.getShort() == -40) {
                                this.out.write(this.f2676c.array(), 0, 2);
                                this.f2677d = 1;
                                this.f2676c.rewind();
                                b bVar = new b(this.out, ByteOrder.BIG_ENDIAN);
                                bVar.e(-31);
                                b(bVar);
                            } else {
                                throw new IOException("Not a valid jpeg image, cannot write exif");
                            }
                        } else {
                            return;
                        }
                    } else if (i14 != 1) {
                        continue;
                    } else {
                        int a11 = a(4, bArr, i10, i11);
                        i10 += a11;
                        i11 -= a11;
                        if (this.f2676c.position() == 2 && this.f2676c.getShort() == -39) {
                            this.out.write(this.f2676c.array(), 0, 2);
                            this.f2676c.rewind();
                        }
                        if (this.f2676c.position() >= 4) {
                            this.f2676c.rewind();
                            short s10 = this.f2676c.getShort();
                            if (s10 == -31) {
                                this.f2678e = (this.f2676c.getShort() & 65535) - 2;
                                this.f2677d = 2;
                            } else if (!a.a(s10)) {
                                this.out.write(this.f2676c.array(), 0, 4);
                                this.f2679f = (this.f2676c.getShort() & 65535) - 2;
                            } else {
                                this.out.write(this.f2676c.array(), 0, 4);
                                this.f2677d = 2;
                            }
                            this.f2676c.rewind();
                        } else {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }
        if (i11 > 0) {
            this.out.write(bArr, i10, i11);
        }
    }

    public void write(int i10) throws IOException {
        byte[] bArr = this.f2675b;
        bArr[0] = (byte) (i10 & 255);
        write(bArr);
    }

    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
