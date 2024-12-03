package t;

import a0.n;
import a0.o;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.i;
import java.io.IOException;
import java.util.Objects;

final class q implements n<o<byte[]>, o<Bitmap>> {
    q() {
    }

    @NonNull
    private Bitmap b(@NonNull byte[] bArr, @NonNull Rect rect) throws ImageCaptureException {
        try {
            return BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false).decodeRegion(rect, new BitmapFactory.Options());
        } catch (IOException e10) {
            throw new ImageCaptureException(1, "Failed to decode JPEG.", e10);
        }
    }

    @NonNull
    /* renamed from: a */
    public o<Bitmap> apply(@NonNull o<byte[]> oVar) throws ImageCaptureException {
        Rect b10 = oVar.b();
        Bitmap b11 = b(oVar.c(), b10);
        i d10 = oVar.d();
        Objects.requireNonNull(d10);
        return o.j(b11, d10, new Rect(0, 0, b11.getWidth(), b11.getHeight()), oVar.f(), androidx.camera.core.impl.utils.q.p(oVar.g(), b10), oVar.a());
    }
}
