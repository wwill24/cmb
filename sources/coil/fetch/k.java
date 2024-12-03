package coil.fetch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.l;
import coil.fetch.i;
import coil.util.d;
import coil.util.m;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okio.Okio;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0007\u0005B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcoil/fetch/k;", "Lcoil/fetch/i;", "Landroid/net/Uri;", "data", "", "b", "Lcoil/fetch/h;", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroid/net/Uri;", "Lcoil/request/k;", "Lcoil/request/k;", "options", "<init>", "(Landroid/net/Uri;Lcoil/request/k;)V", "c", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class k implements i {

    /* renamed from: c  reason: collision with root package name */
    public static final a f8198c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Uri f8199a;

    /* renamed from: b  reason: collision with root package name */
    private final coil.request.k f8200b;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcoil/fetch/k$a;", "", "", "MIME_TYPE_XML", "Ljava/lang/String;", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcoil/fetch/k$b;", "Lcoil/fetch/i$a;", "Landroid/net/Uri;", "data", "", "c", "Lcoil/request/k;", "options", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/fetch/i;", "b", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class b implements i.a<Uri> {
        private final boolean c(Uri uri) {
            return j.b(uri.getScheme(), "android.resource");
        }

        /* renamed from: b */
        public i a(Uri uri, coil.request.k kVar, ImageLoader imageLoader) {
            if (!c(uri)) {
                return null;
            }
            return new k(uri, kVar);
        }
    }

    public k(Uri uri, coil.request.k kVar) {
        this.f8199a = uri;
        this.f8200b = kVar;
    }

    private final Void b(Uri uri) {
        throw new IllegalStateException("Invalid android.resource URI: " + uri);
    }

    public Object a(c<? super h> cVar) {
        Integer j10;
        Resources resources;
        Drawable drawable;
        String authority = this.f8199a.getAuthority();
        if (authority != null) {
            if (!(!r.w(authority))) {
                authority = null;
            }
            if (authority != null) {
                String str = (String) CollectionsKt___CollectionsKt.Z(this.f8199a.getPathSegments());
                if (str == null || (j10 = q.j(str)) == null) {
                    b(this.f8199a);
                    throw new KotlinNothingValueException();
                }
                int intValue = j10.intValue();
                Context g10 = this.f8200b.g();
                if (j.b(authority, g10.getPackageName())) {
                    resources = g10.getResources();
                } else {
                    resources = g10.getPackageManager().getResourcesForApplication(authority);
                }
                TypedValue typedValue = new TypedValue();
                resources.getValue(intValue, typedValue, true);
                CharSequence charSequence = typedValue.string;
                String k10 = coil.util.j.k(MimeTypeMap.getSingleton(), charSequence.subSequence(StringsKt__StringsKt.f0(charSequence, '/', 0, false, 6, (Object) null), charSequence.length()).toString());
                if (j.b(k10, "text/xml")) {
                    if (j.b(authority, g10.getPackageName())) {
                        drawable = d.a(g10, intValue);
                    } else {
                        drawable = d.d(g10, resources, intValue);
                    }
                    Drawable drawable2 = drawable;
                    boolean v10 = coil.util.j.v(drawable2);
                    if (v10) {
                        drawable2 = new BitmapDrawable(g10.getResources(), m.f8436a.a(drawable2, this.f8200b.f(), this.f8200b.o(), this.f8200b.n(), this.f8200b.c()));
                    }
                    return new g(drawable2, v10, DataSource.DISK);
                }
                TypedValue typedValue2 = new TypedValue();
                return new l(l.b(Okio.c(Okio.j(resources.openRawResource(intValue, typedValue2))), g10, new coil.decode.m(authority, intValue, typedValue2.density)), k10, DataSource.DISK);
            }
        }
        b(this.f8199a);
        throw new KotlinNothingValueException();
    }
}
