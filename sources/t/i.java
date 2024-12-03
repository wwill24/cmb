package t;

import a0.n;
import a0.o;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import java.io.ByteArrayOutputStream;
import java.util.Objects;

class i implements n<a, o<byte[]>> {

    static abstract class a {
        a() {
        }

        @NonNull
        static a c(@NonNull o<Bitmap> oVar, int i10) {
            return new a(oVar, i10);
        }

        /* access modifiers changed from: package-private */
        public abstract int a();

        /* access modifiers changed from: package-private */
        public abstract o<Bitmap> b();
    }

    i() {
    }

    @NonNull
    /* renamed from: a */
    public o<byte[]> apply(@NonNull a aVar) throws ImageCaptureException {
        o<Bitmap> b10 = aVar.b();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b10.c().compress(Bitmap.CompressFormat.JPEG, aVar.a(), byteArrayOutputStream);
        b10.c().recycle();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        androidx.camera.core.impl.utils.i d10 = b10.d();
        Objects.requireNonNull(d10);
        return o.l(byteArray, d10, 256, b10.h(), b10.b(), b10.f(), b10.g(), b10.a());
    }
}
