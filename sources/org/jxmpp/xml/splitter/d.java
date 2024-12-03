package org.jxmpp.xml.splitter;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class d extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final h f24346a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f24347b = new byte[6];

    /* renamed from: c  reason: collision with root package name */
    private char[] f24348c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    private int f24349d;

    /* renamed from: e  reason: collision with root package name */
    private byte f24350e;

    /* renamed from: f  reason: collision with root package name */
    private byte f24351f;

    public d(h hVar) {
        this.f24346a = hVar;
    }

    private void a() throws IOException {
        this.f24346a.write(this.f24348c, 0, this.f24349d);
        this.f24349d = 0;
    }

    private void b(char c10) {
        char[] cArr = this.f24348c;
        int i10 = this.f24349d;
        this.f24349d = i10 + 1;
        cArr[i10] = c10;
    }

    private void c(int i10) {
        int i11 = this.f24349d;
        int i12 = i10 + i11;
        char[] cArr = this.f24348c;
        if (i12 > cArr.length) {
            char[] cArr2 = new char[i12];
            System.arraycopy(cArr, 0, cArr2, 0, i11);
            this.f24348c = cArr2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(byte r9) throws java.io.IOException {
        /*
            r8 = this;
            byte[] r0 = r8.f24347b
            byte r1 = r8.f24350e
            r0[r1] = r9
            r9 = 4
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 != 0) goto L_0x0044
            byte r6 = r0[r4]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r7 = 128(0x80, float:1.794E-43)
            if (r6 >= r7) goto L_0x0018
            r8.f24351f = r5
            goto L_0x0044
        L_0x0018:
            r7 = 224(0xe0, float:3.14E-43)
            if (r6 >= r7) goto L_0x001f
            r8.f24351f = r3
            goto L_0x0044
        L_0x001f:
            r7 = 240(0xf0, float:3.36E-43)
            if (r6 >= r7) goto L_0x0026
            r8.f24351f = r2
            goto L_0x0044
        L_0x0026:
            r7 = 248(0xf8, float:3.48E-43)
            if (r6 >= r7) goto L_0x002d
            r8.f24351f = r9
            goto L_0x0044
        L_0x002d:
            java.io.IOException r9 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid first UTF-8 byte: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L_0x0044:
            int r1 = r1 + r5
            byte r1 = (byte) r1
            r8.f24350e = r1
            byte r6 = r8.f24351f
            if (r1 != r6) goto L_0x00ab
            if (r6 != r5) goto L_0x0053
            byte r9 = r0[r4]
            r9 = r9 & 127(0x7f, float:1.78E-43)
            goto L_0x0088
        L_0x0053:
            if (r6 == r3) goto L_0x006d
            if (r6 == r2) goto L_0x0066
            if (r6 != r9) goto L_0x0060
            byte r9 = r0[r4]
            r9 = r9 & 6
            int r9 = r9 << 18
            goto L_0x0073
        L_0x0060:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L_0x0066:
            byte r9 = r0[r4]
            r9 = r9 & 15
            int r9 = r9 << 12
            goto L_0x0073
        L_0x006d:
            byte r9 = r0[r4]
            r9 = r9 & 31
            int r9 = r9 << 6
        L_0x0073:
            byte r0 = r8.f24351f
            if (r5 >= r0) goto L_0x0088
            byte[] r1 = r8.f24347b
            byte r1 = r1[r5]
            r1 = r1 & 63
            int r0 = r0 + -1
            int r0 = r0 - r5
            int r0 = r0 * 6
            int r0 = r1 << r0
            r9 = r9 | r0
            int r5 = r5 + 1
            goto L_0x0073
        L_0x0088:
            r8.c(r3)
            r0 = 65536(0x10000, float:9.18355E-41)
            if (r9 >= r0) goto L_0x0094
            char r9 = (char) r9
            r8.b(r9)
            goto L_0x00a9
        L_0x0094:
            r0 = 55296(0xd800, float:7.7486E-41)
            r1 = -6291456(0xffffffffffa00000, float:NaN)
            r1 = r1 & r9
            int r1 = r1 + r0
            char r0 = (char) r1
            r8.b(r0)
            r0 = 56320(0xdc00, float:7.8921E-41)
            r9 = r9 & 1023(0x3ff, float:1.434E-42)
            int r9 = r9 + r0
            char r9 = (char) r9
            r8.b(r9)
        L_0x00a9:
            r8.f24350e = r4
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jxmpp.xml.splitter.d.e(byte):void");
    }

    private void h(ByteBuffer byteBuffer) throws IOException {
        int remaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            k(byteBuffer.array(), byteBuffer.arrayOffset(), remaining);
        } else {
            int position = byteBuffer.position();
            for (int i10 = 0; i10 < remaining; i10++) {
                e(byteBuffer.get(position + i10));
            }
        }
        byteBuffer.flip();
    }

    private void k(byte[] bArr, int i10, int i11) throws IOException {
        for (int i12 = 0; i12 < i11; i12++) {
            e(bArr[i10 + i12]);
        }
    }

    public void f(byte b10) throws IOException {
        e(b10);
        a();
    }

    public void g(ByteBuffer byteBuffer) throws IOException {
        c(byteBuffer.remaining());
        h(byteBuffer);
        a();
    }

    public void write(int i10) throws IOException {
        f((byte) (i10 & 255));
    }

    public void write(byte[] bArr, int i10, int i11) throws IOException {
        c(i11);
        k(bArr, i10, i11);
        a();
    }
}
