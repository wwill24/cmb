package s3;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import f4.a;
import i3.e;
import i3.f;
import java.io.IOException;
import java.io.InputStream;
import l3.c;

public final class p implements f<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final d f17458a = new d();

    /* renamed from: c */
    public c<Bitmap> a(@NonNull InputStream inputStream, int i10, int i11, @NonNull e eVar) throws IOException {
        return this.f17458a.a(ImageDecoder.createSource(a.b(inputStream)), i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean b(@NonNull InputStream inputStream, @NonNull e eVar) throws IOException {
        return true;
    }
}
