package s3;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import f4.j;
import f4.k;
import l3.b;
import l3.c;
import m3.d;

public class e implements c<Bitmap>, b {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f17448a;

    /* renamed from: b  reason: collision with root package name */
    private final d f17449b;

    public e(@NonNull Bitmap bitmap, @NonNull d dVar) {
        this.f17448a = (Bitmap) j.e(bitmap, "Bitmap must not be null");
        this.f17449b = (d) j.e(dVar, "BitmapPool must not be null");
    }

    public static e d(Bitmap bitmap, @NonNull d dVar) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, dVar);
    }

    public void a() {
        this.f17449b.c(this.f17448a);
    }

    @NonNull
    public Class<Bitmap> b() {
        return Bitmap.class;
    }

    @NonNull
    /* renamed from: c */
    public Bitmap get() {
        return this.f17448a;
    }

    public int getSize() {
        return k.g(this.f17448a);
    }

    public void initialize() {
        this.f17448a.prepareToDraw();
    }
}
