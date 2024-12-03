package coil.fetch;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.l;
import coil.fetch.i;
import coil.request.k;
import coil.util.j;
import com.google.firebase.sessions.settings.RemoteSettings;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import okio.Okio;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcoil/fetch/a;", "Lcoil/fetch/i;", "Lcoil/fetch/h;", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroid/net/Uri;", "Landroid/net/Uri;", "data", "Lcoil/request/k;", "b", "Lcoil/request/k;", "options", "<init>", "(Landroid/net/Uri;Lcoil/request/k;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class a implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f8184a;

    /* renamed from: b  reason: collision with root package name */
    private final k f8185b;

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcoil/fetch/a$a;", "Lcoil/fetch/i$a;", "Landroid/net/Uri;", "data", "Lcoil/request/k;", "options", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/fetch/i;", "b", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: coil.fetch.a$a  reason: collision with other inner class name */
    public static final class C0103a implements i.a<Uri> {
        /* renamed from: b */
        public i a(Uri uri, k kVar, ImageLoader imageLoader) {
            if (!j.r(uri)) {
                return null;
            }
            return new a(uri, kVar);
        }
    }

    public a(Uri uri, k kVar) {
        this.f8184a = uri;
        this.f8185b = kVar;
    }

    public Object a(c<? super h> cVar) {
        String W = CollectionsKt___CollectionsKt.W(CollectionsKt___CollectionsKt.G(this.f8184a.getPathSegments(), 1), RemoteSettings.FORWARD_SLASH_STRING, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        return new l(l.b(Okio.c(Okio.j(this.f8185b.g().getAssets().open(W))), this.f8185b.g(), new coil.decode.a(W)), j.k(MimeTypeMap.getSingleton(), W), DataSource.DISK);
    }
}
