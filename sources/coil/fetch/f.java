package coil.fetch;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.fetch.i;
import coil.request.k;
import coil.util.j;
import coil.util.m;
import kotlin.Metadata;
import kotlin.coroutines.c;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcoil/fetch/f;", "Lcoil/fetch/i;", "Lcoil/fetch/h;", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "data", "Lcoil/request/k;", "b", "Lcoil/request/k;", "options", "<init>", "(Landroid/graphics/drawable/Drawable;Lcoil/request/k;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class f implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f8192a;

    /* renamed from: b  reason: collision with root package name */
    private final k f8193b;

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcoil/fetch/f$a;", "Lcoil/fetch/i$a;", "Landroid/graphics/drawable/Drawable;", "data", "Lcoil/request/k;", "options", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/fetch/i;", "b", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a implements i.a<Drawable> {
        /* renamed from: b */
        public i a(Drawable drawable, k kVar, ImageLoader imageLoader) {
            return new f(drawable, kVar);
        }
    }

    public f(Drawable drawable, k kVar) {
        this.f8192a = drawable;
        this.f8193b = kVar;
    }

    public Object a(c<? super h> cVar) {
        Drawable drawable;
        boolean v10 = j.v(this.f8192a);
        if (v10) {
            drawable = new BitmapDrawable(this.f8193b.g().getResources(), m.f8436a.a(this.f8192a, this.f8193b.f(), this.f8193b.o(), this.f8193b.n(), this.f8193b.c()));
        } else {
            drawable = this.f8192a;
        }
        return new g(drawable, v10, DataSource.MEMORY);
    }
}
