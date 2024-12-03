package s3;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import i3.e;
import i3.f;
import java.io.IOException;
import java.nio.ByteBuffer;
import l3.c;

public final class i implements f<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final d f17451a = new d();

    /* renamed from: c */
    public c<Bitmap> a(@NonNull ByteBuffer byteBuffer, int i10, int i11, @NonNull e eVar) throws IOException {
        return this.f17451a.a(ImageDecoder.createSource(byteBuffer), i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean b(@NonNull ByteBuffer byteBuffer, @NonNull e eVar) throws IOException {
        return true;
    }
}
