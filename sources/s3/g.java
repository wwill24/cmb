package s3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.i;
import d4.b;
import d4.c;

public final class g extends i<g, Bitmap> {
    @NonNull
    public static g j() {
        return new g().e();
    }

    @NonNull
    public g e() {
        return h(new c.a());
    }

    @NonNull
    public g h(@NonNull c.a aVar) {
        return i(aVar.a());
    }

    @NonNull
    public g i(@NonNull d4.g<Drawable> gVar) {
        return (g) d(new b(gVar));
    }
}
