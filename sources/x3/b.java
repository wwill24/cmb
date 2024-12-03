package x3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import f4.j;
import i3.e;
import l3.c;
import s3.q;

public class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f18528a;

    public b(@NonNull Resources resources) {
        this.f18528a = (Resources) j.d(resources);
    }

    public c<BitmapDrawable> a(@NonNull c<Bitmap> cVar, @NonNull e eVar) {
        return q.d(this.f18528a, cVar);
    }
}
