package d4;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import d4.f;

public abstract class a<R> implements g<R> {

    /* renamed from: a  reason: collision with root package name */
    private final g<Drawable> f14433a;

    /* renamed from: d4.a$a  reason: collision with other inner class name */
    private final class C0152a implements f<R> {

        /* renamed from: a  reason: collision with root package name */
        private final f<Drawable> f14434a;

        C0152a(f<Drawable> fVar) {
            this.f14434a = fVar;
        }

        public boolean a(R r10, f.a aVar) {
            return this.f14434a.a(new BitmapDrawable(aVar.getView().getResources(), a.this.b(r10)), aVar);
        }
    }

    public a(g<Drawable> gVar) {
        this.f14433a = gVar;
    }

    public f<R> a(DataSource dataSource, boolean z10) {
        return new C0152a(this.f14433a.a(dataSource, z10));
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap b(R r10);
}
