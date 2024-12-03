package coil.fetch;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.b;
import coil.decode.l;
import coil.fetch.i;
import coil.request.k;
import coil.size.c;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okio.Okio;
import org.jivesoftware.smack.sm.packet.StreamManagement;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0013\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\f\u0010\u000bR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcoil/fetch/e;", "Lcoil/fetch/i;", "Landroid/os/Bundle;", "d", "Lcoil/fetch/h;", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroid/net/Uri;", "data", "", "b", "(Landroid/net/Uri;)Z", "c", "Landroid/net/Uri;", "Lcoil/request/k;", "Lcoil/request/k;", "options", "<init>", "(Landroid/net/Uri;Lcoil/request/k;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class e implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f8190a;

    /* renamed from: b  reason: collision with root package name */
    private final k f8191b;

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcoil/fetch/e$a;", "Lcoil/fetch/i$a;", "Landroid/net/Uri;", "data", "", "c", "Lcoil/request/k;", "options", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/fetch/i;", "b", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a implements i.a<Uri> {
        private final boolean c(Uri uri) {
            return j.b(uri.getScheme(), "content");
        }

        /* renamed from: b */
        public i a(Uri uri, k kVar, ImageLoader imageLoader) {
            if (!c(uri)) {
                return null;
            }
            return new e(uri, kVar);
        }
    }

    public e(Uri uri, k kVar) {
        this.f8190a = uri;
        this.f8191b = kVar;
    }

    private final Bundle d() {
        c.a aVar;
        c.a aVar2;
        c d10 = this.f8191b.o().d();
        if (d10 instanceof c.a) {
            aVar = (c.a) d10;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        int i10 = aVar.f8407a;
        c c10 = this.f8191b.o().c();
        if (c10 instanceof c.a) {
            aVar2 = (c.a) c10;
        } else {
            aVar2 = null;
        }
        if (aVar2 == null) {
            return null;
        }
        int i11 = aVar2.f8407a;
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("android.content.extra.SIZE", new Point(i10, i11));
        return bundle;
    }

    public Object a(kotlin.coroutines.c<? super h> cVar) {
        ContentResolver contentResolver = this.f8191b.g().getContentResolver();
        InputStream inputStream = null;
        if (b(this.f8190a)) {
            AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.f8190a, StreamManagement.AckRequest.ELEMENT);
            if (openAssetFileDescriptor != null) {
                inputStream = openAssetFileDescriptor.createInputStream();
            }
            if (inputStream == null) {
                throw new IllegalStateException(("Unable to find a contact photo associated with '" + this.f8190a + "'.").toString());
            }
        } else if (Build.VERSION.SDK_INT < 29 || !c(this.f8190a)) {
            inputStream = contentResolver.openInputStream(this.f8190a);
            if (inputStream == null) {
                throw new IllegalStateException(("Unable to open '" + this.f8190a + "'.").toString());
            }
        } else {
            AssetFileDescriptor a10 = contentResolver.openTypedAssetFile(this.f8190a, "image/*", d(), (CancellationSignal) null);
            if (a10 != null) {
                inputStream = a10.createInputStream();
            }
            if (inputStream == null) {
                throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + this.f8190a + "'.").toString());
            }
        }
        return new l(l.b(Okio.c(Okio.j(inputStream)), this.f8191b.g(), new b(this.f8190a)), contentResolver.getType(this.f8190a), DataSource.DISK);
    }

    public final boolean b(Uri uri) {
        if (!j.b(uri.getAuthority(), "com.android.contacts") || !j.b(uri.getLastPathSegment(), "display_photo")) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        r5 = r5.getPathSegments();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(android.net.Uri r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.getAuthority()
            java.lang.String r1 = "media"
            boolean r0 = kotlin.jvm.internal.j.b(r0, r1)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.util.List r5 = r5.getPathSegments()
            int r0 = r5.size()
            r2 = 3
            if (r0 < r2) goto L_0x0036
            int r2 = r0 + -3
            java.lang.Object r2 = r5.get(r2)
            java.lang.String r3 = "audio"
            boolean r2 = kotlin.jvm.internal.j.b(r2, r3)
            if (r2 == 0) goto L_0x0036
            int r0 = r0 + -2
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r0 = "albums"
            boolean r5 = kotlin.jvm.internal.j.b(r5, r0)
            if (r5 == 0) goto L_0x0036
            r1 = 1
        L_0x0036:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.e.c(android.net.Uri):boolean");
    }
}
