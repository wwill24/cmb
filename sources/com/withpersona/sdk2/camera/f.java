package com.withpersona.sdk2.camera;

import android.media.Image;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.j;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f14346a = new f();

    private f() {
    }

    private final boolean a(Image.Plane[] planeArr, int i10, int i11) {
        int i12 = i10 * i11;
        boolean z10 = true;
        ByteBuffer buffer = planeArr[1].getBuffer();
        ByteBuffer buffer2 = planeArr[2].getBuffer();
        int position = buffer2.position();
        int limit = buffer.limit();
        buffer2.position(position + 1);
        buffer.limit(limit - 1);
        if (!(buffer2.remaining() == ((i12 * 2) / 4) - 2 && buffer2.compareTo(buffer) == 0)) {
            z10 = false;
        }
        buffer2.position(position);
        buffer.limit(limit);
        return z10;
    }

    private final void b(Image.Plane plane, int i10, int i11, byte[] bArr, int i12, int i13) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int limit = ((buffer.limit() + plane.getRowStride()) - 1) / plane.getRowStride();
        if (limit != 0) {
            int i14 = i10 / (i11 / limit);
            int i15 = 0;
            for (int i16 = 0; i16 < limit; i16++) {
                int i17 = i15;
                for (int i18 = 0; i18 < i14; i18++) {
                    bArr[i12] = buffer.get(i17);
                    i12 += i13;
                    i17 += plane.getPixelStride();
                }
                i15 += plane.getRowStride();
            }
        }
    }

    public final ByteBuffer c(Image.Plane[] planeArr, int i10, int i11) {
        j.g(planeArr, "yuv420888planes");
        int i12 = i10 * i11;
        byte[] bArr = new byte[(((i12 / 4) * 2) + i12)];
        if (a(planeArr, i10, i11)) {
            planeArr[0].getBuffer().rewind();
            planeArr[0].getBuffer().get(bArr, 0, i12);
            ByteBuffer buffer = planeArr[1].getBuffer();
            planeArr[2].getBuffer().get(bArr, i12, 1);
            buffer.get(bArr, i12 + 1, ((i12 * 2) / 4) - 1);
        } else {
            int i13 = i10;
            int i14 = i11;
            byte[] bArr2 = bArr;
            b(planeArr[0], i13, i14, bArr2, 0, 1);
            b(planeArr[1], i13, i14, bArr2, i12 + 1, 2);
            b(planeArr[2], i13, i14, bArr2, i12, 2);
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        j.f(wrap, "wrap(out)");
        return wrap;
    }
}
