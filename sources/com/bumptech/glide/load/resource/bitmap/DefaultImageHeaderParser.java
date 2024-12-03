package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import f4.j;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f9449a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f9450b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private interface Reader {

        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a() throws IOException;

        int b(byte[] bArr, int i10) throws IOException;

        short c() throws IOException;

        long skip(long j10) throws IOException;
    }

    private static final class a implements Reader {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f9451a;

        a(ByteBuffer byteBuffer) {
            this.f9451a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() throws Reader.EndOfFileException {
            return (c() << 8) | c();
        }

        public int b(byte[] bArr, int i10) {
            int min = Math.min(i10, this.f9451a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f9451a.get(bArr, 0, min);
            return min;
        }

        public short c() throws Reader.EndOfFileException {
            if (this.f9451a.remaining() >= 1) {
                return (short) (this.f9451a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        public long skip(long j10) {
            int min = (int) Math.min((long) this.f9451a.remaining(), j10);
            ByteBuffer byteBuffer = this.f9451a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f9452a;

        b(byte[] bArr, int i10) {
            this.f9452a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i10);
        }

        private boolean c(int i10, int i11) {
            return this.f9452a.remaining() - i10 >= i11;
        }

        /* access modifiers changed from: package-private */
        public short a(int i10) {
            if (c(i10, 2)) {
                return this.f9452a.getShort(i10);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int b(int i10) {
            if (c(i10, 4)) {
                return this.f9452a.getInt(i10);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            return this.f9452a.remaining();
        }

        /* access modifiers changed from: package-private */
        public void e(ByteOrder byteOrder) {
            this.f9452a.order(byteOrder);
        }
    }

    private static final class c implements Reader {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f9453a;

        c(InputStream inputStream) {
            this.f9453a = inputStream;
        }

        public int a() throws IOException {
            return (c() << 8) | c();
        }

        public int b(byte[] bArr, int i10) throws IOException {
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10 && (i12 = this.f9453a.read(bArr, i11, i10 - i11)) != -1) {
                i11 += i12;
            }
            if (i11 != 0 || i12 != -1) {
                return i11;
            }
            throw new Reader.EndOfFileException();
        }

        public short c() throws IOException {
            int read = this.f9453a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        public long skip(long j10) throws IOException {
            if (j10 < 0) {
                return 0;
            }
            long j11 = j10;
            while (j11 > 0) {
                long skip = this.f9453a.skip(j11);
                if (skip <= 0) {
                    if (this.f9453a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j11 -= skip;
            }
            return j10 - j11;
        }
    }

    private static int d(int i10, int i11) {
        return i10 + 2 + (i11 * 12);
    }

    private int e(Reader reader, m3.b bVar) throws IOException {
        byte[] bArr;
        try {
            int a10 = reader.a();
            if (!g(a10)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Parser doesn't handle magic number: ");
                    sb2.append(a10);
                }
                return -1;
            }
            int i10 = i(reader);
            if (i10 == -1) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            bArr = (byte[]) bVar.c(i10, byte[].class);
            int k10 = k(reader, bArr, i10);
            bVar.put(bArr);
            return k10;
        } catch (Reader.EndOfFileException unused) {
            return -1;
        } catch (Throwable th2) {
            bVar.put(bArr);
            throw th2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0039 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bumptech.glide.load.ImageHeaderParser.ImageType f(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader r6) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            r1 = 65496(0xffd8, float:9.178E-41)
            if (r0 != r1) goto L_0x000c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x000c:
            int r0 = r0 << 8
            short r1 = r6.c()     // Catch:{ EndOfFileException -> 0x00a0 }
            r0 = r0 | r1
            r1 = 4671814(0x474946, float:6.546606E-39)
            if (r0 != r1) goto L_0x001b
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.GIF     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x001b:
            int r0 = r0 << 8
            short r1 = r6.c()     // Catch:{ EndOfFileException -> 0x00a0 }
            r0 = r0 | r1
            r1 = -1991225785(0xffffffff89504e47, float:-2.5073895E-33)
            if (r0 != r1) goto L_0x003c
            r0 = 21
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.c()     // Catch:{ EndOfFileException -> 0x0039 }
            r0 = 3
            if (r6 < r0) goto L_0x0036
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A     // Catch:{ EndOfFileException -> 0x0039 }
            goto L_0x0038
        L_0x0036:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x0039 }
        L_0x0038:
            return r6
        L_0x0039:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x003c:
            r1 = 1380533830(0x52494646, float:2.16116855E11)
            if (r0 == r1) goto L_0x0044
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x0044:
            r0 = 4
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            r2 = r2 | r3
            r3 = 1464156752(0x57454250, float:2.16888601E14)
            if (r2 == r3) goto L_0x005c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x005c:
            int r2 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            r2 = r2 | r3
            r3 = r2 & -256(0xffffffffffffff00, float:NaN)
            r4 = 1448097792(0x56503800, float:5.7234734E13)
            if (r3 == r4) goto L_0x0071
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x0071:
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 88
            if (r2 != r3) goto L_0x0088
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.c()     // Catch:{ EndOfFileException -> 0x00a0 }
            r6 = r6 & 16
            if (r6 == 0) goto L_0x0085
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00a0 }
            goto L_0x0087
        L_0x0085:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
        L_0x0087:
            return r6
        L_0x0088:
            r3 = 76
            if (r2 != r3) goto L_0x009d
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.c()     // Catch:{ EndOfFileException -> 0x00a0 }
            r6 = r6 & 8
            if (r6 == 0) goto L_0x009a
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00a0 }
            goto L_0x009c
        L_0x009a:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
        L_0x009c:
            return r6
        L_0x009d:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x00a0:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.f(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader):com.bumptech.glide.load.ImageHeaderParser$ImageType");
    }

    private static boolean g(int i10) {
        return (i10 & 65496) == 65496 || i10 == 19789 || i10 == 18761;
    }

    private boolean h(byte[] bArr, int i10) {
        boolean z10;
        if (bArr == null || i10 <= f9449a.length) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            int i11 = 0;
            while (true) {
                byte[] bArr2 = f9449a;
                if (i11 >= bArr2.length) {
                    break;
                } else if (bArr[i11] != bArr2[i11]) {
                    return false;
                } else {
                    i11++;
                }
            }
        }
        return z10;
    }

    private int i(Reader reader) throws IOException {
        short c10;
        int a10;
        long j10;
        long skip;
        do {
            short c11 = reader.c();
            if (c11 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unknown segmentId=");
                    sb2.append(c11);
                }
                return -1;
            }
            c10 = reader.c();
            if (c10 == 218) {
                return -1;
            }
            if (c10 == 217) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            a10 = reader.a() - 2;
            if (c10 == 225) {
                return a10;
            }
            j10 = (long) a10;
            skip = reader.skip(j10);
        } while (skip == j10);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to skip enough data, type: ");
            sb3.append(c10);
            sb3.append(", wanted to skip: ");
            sb3.append(a10);
            sb3.append(", but actually skipped: ");
            sb3.append(skip);
        }
        return -1;
    }

    private static int j(b bVar) {
        ByteOrder byteOrder;
        short a10 = bVar.a(6);
        if (a10 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (a10 != 19789) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unknown endianness = ");
                sb2.append(a10);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.e(byteOrder);
        int b10 = bVar.b(10) + 6;
        short a11 = bVar.a(b10);
        for (int i10 = 0; i10 < a11; i10++) {
            int d10 = d(b10, i10);
            short a12 = bVar.a(d10);
            if (a12 == 274) {
                short a13 = bVar.a(d10 + 2);
                if (a13 >= 1 && a13 <= 12) {
                    int b11 = bVar.b(d10 + 4);
                    if (b11 < 0) {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                    } else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Got tagIndex=");
                            sb3.append(i10);
                            sb3.append(" tagType=");
                            sb3.append(a12);
                            sb3.append(" formatCode=");
                            sb3.append(a13);
                            sb3.append(" componentCount=");
                            sb3.append(b11);
                        }
                        int i11 = b11 + f9450b[a13];
                        if (i11 <= 4) {
                            int i12 = d10 + 8;
                            if (i12 < 0 || i12 > bVar.d()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("Illegal tagValueOffset=");
                                    sb4.append(i12);
                                    sb4.append(" tagType=");
                                    sb4.append(a12);
                                }
                            } else if (i11 >= 0 && i11 + i12 <= bVar.d()) {
                                return bVar.a(i12);
                            } else {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("Illegal number of bytes for TI tag data tagType=");
                                    sb5.append(a12);
                                }
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("Got byte count > 4, not orientation, continuing, formatCode=");
                            sb6.append(a13);
                        }
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("Got invalid format code = ");
                    sb7.append(a13);
                }
            }
        }
        return -1;
    }

    private int k(Reader reader, byte[] bArr, int i10) throws IOException {
        int b10 = reader.b(bArr, i10);
        if (b10 != i10) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to read exif segment data, length: ");
                sb2.append(i10);
                sb2.append(", actually read: ");
                sb2.append(b10);
            }
            return -1;
        } else if (h(bArr, i10)) {
            return j(new b(bArr, i10));
        } else {
            Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
    }

    public int a(@NonNull InputStream inputStream, @NonNull m3.b bVar) throws IOException {
        return e(new c((InputStream) j.d(inputStream)), (m3.b) j.d(bVar));
    }

    @NonNull
    public ImageHeaderParser.ImageType b(@NonNull ByteBuffer byteBuffer) throws IOException {
        return f(new a((ByteBuffer) j.d(byteBuffer)));
    }

    @NonNull
    public ImageHeaderParser.ImageType c(@NonNull InputStream inputStream) throws IOException {
        return f(new c((InputStream) j.d(inputStream)));
    }
}
