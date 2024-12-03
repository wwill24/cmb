package s3;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import java.io.IOException;
import l3.c;
import m3.e;
import r3.a;

public final class d extends a<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    private final m3.d f17447b = new e();

    /* access modifiers changed from: protected */
    public c<Bitmap> c(ImageDecoder.Source source, int i10, int i11, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Decoded [");
            sb2.append(decodeBitmap.getWidth());
            sb2.append("x");
            sb2.append(decodeBitmap.getHeight());
            sb2.append("] for [");
            sb2.append(i10);
            sb2.append("x");
            sb2.append(i11);
            sb2.append("]");
        }
        return new e(decodeBitmap, this.f17447b);
    }
}
