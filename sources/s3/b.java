package s3;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import i3.e;
import i3.g;
import java.io.File;
import l3.c;
import m3.d;

public class b implements g<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final d f17442a;

    /* renamed from: b  reason: collision with root package name */
    private final g<Bitmap> f17443b;

    public b(d dVar, g<Bitmap> gVar) {
        this.f17442a = dVar;
        this.f17443b = gVar;
    }

    @NonNull
    public EncodeStrategy b(@NonNull e eVar) {
        return this.f17443b.b(eVar);
    }

    /* renamed from: c */
    public boolean a(@NonNull c<BitmapDrawable> cVar, @NonNull File file, @NonNull e eVar) {
        return this.f17443b.a(new e(cVar.get().getBitmap(), this.f17442a), file, eVar);
    }
}
