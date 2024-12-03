package t;

import a0.o;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.i;
import androidx.camera.core.impl.utils.k;
import androidx.camera.core.impl.utils.q;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.o1;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import v.b;

final class n implements a0.n<a, o<byte[]>> {

    static abstract class a {
        a() {
        }

        @NonNull
        static a c(@NonNull o<o1> oVar, int i10) {
            return new d(oVar, i10);
        }

        /* access modifiers changed from: package-private */
        public abstract int a();

        /* access modifiers changed from: package-private */
        public abstract o<o1> b();
    }

    n() {
    }

    private static byte[] b(@NonNull ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        byteBuffer.rewind();
        byteBuffer.get(bArr, 0, position);
        return bArr;
    }

    private static i c(@NonNull byte[] bArr) throws ImageCaptureException {
        try {
            return i.k(new ByteArrayInputStream(bArr));
        } catch (IOException e10) {
            throw new ImageCaptureException(0, "Failed to extract Exif from YUV-generated JPEG", e10);
        }
    }

    private o<byte[]> d(@NonNull a aVar) {
        o<o1> b10 = aVar.b();
        byte[] i10 = ImageUtil.i(b10.c());
        i d10 = b10.d();
        Objects.requireNonNull(d10);
        return o.l(i10, d10, 256, b10.h(), b10.b(), b10.f(), b10.g(), b10.a());
    }

    private o<byte[]> e(@NonNull a aVar) throws ImageCaptureException {
        o<o1> b10 = aVar.b();
        o1 c10 = b10.c();
        Rect b11 = b10.b();
        YuvImage yuvImage = new YuvImage(ImageUtil.q(c10), 17, c10.getWidth(), c10.getHeight(), (int[]) null);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(b11.width() * b11.height() * 2);
        yuvImage.compressToJpeg(b11, aVar.a(), new k(new b(allocateDirect), ExifData.b(c10, b10.f())));
        byte[] b12 = b(allocateDirect);
        return o.l(b12, c(b12), 256, new Size(b11.width(), b11.height()), new Rect(0, 0, b11.width(), b11.height()), b10.f(), q.p(b10.g(), b11), b10.a());
    }

    @NonNull
    /* renamed from: a */
    public o<byte[]> apply(@NonNull a aVar) throws ImageCaptureException {
        o<byte[]> e10;
        try {
            int e11 = aVar.b().e();
            if (e11 == 35) {
                e10 = e(aVar);
            } else if (e11 == 256) {
                e10 = d(aVar);
            } else {
                throw new IllegalArgumentException("Unexpected format: " + e11);
            }
            return e10;
        } finally {
            aVar.b().c().close();
        }
    }
}
