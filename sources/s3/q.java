package s3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import f4.j;
import l3.b;
import l3.c;

public final class q implements c<BitmapDrawable>, b {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f17459a;

    /* renamed from: b  reason: collision with root package name */
    private final c<Bitmap> f17460b;

    private q(@NonNull Resources resources, @NonNull c<Bitmap> cVar) {
        this.f17459a = (Resources) j.d(resources);
        this.f17460b = (c) j.d(cVar);
    }

    public static c<BitmapDrawable> d(@NonNull Resources resources, c<Bitmap> cVar) {
        if (cVar == null) {
            return null;
        }
        return new q(resources, cVar);
    }

    public void a() {
        this.f17460b.a();
    }

    @NonNull
    public Class<BitmapDrawable> b() {
        return BitmapDrawable.class;
    }

    @NonNull
    /* renamed from: c */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f17459a, this.f17460b.get());
    }

    public int getSize() {
        return this.f17460b.getSize();
    }

    public void initialize() {
        c<Bitmap> cVar = this.f17460b;
        if (cVar instanceof b) {
            ((b) cVar).initialize();
        }
    }
}
