package x3;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import i3.e;
import java.io.ByteArrayOutputStream;
import l3.c;
import t3.b;

public class a implements e<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap.CompressFormat f18526a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18527b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public c<byte[]> a(@NonNull c<Bitmap> cVar, @NonNull e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        cVar.get().compress(this.f18526a, this.f18527b, byteArrayOutputStream);
        cVar.a();
        return new b(byteArrayOutputStream.toByteArray());
    }

    public a(@NonNull Bitmap.CompressFormat compressFormat, int i10) {
        this.f18526a = compressFormat;
        this.f18527b = i10;
    }
}
