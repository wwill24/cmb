package n2;

import android.content.res.Resources;
import android.net.Uri;
import coil.request.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Ln2/f;", "Ln2/d;", "Landroid/net/Uri;", "data", "", "b", "Lcoil/request/k;", "options", "c", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class f implements d<Uri, Uri> {
    private final boolean b(Uri uri) {
        boolean z10;
        if (j.b(uri.getScheme(), "android.resource")) {
            String authority = uri.getAuthority();
            if (authority == null || r.w(authority)) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 && uri.getPathSegments().size() == 2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public Uri a(Uri uri, k kVar) {
        if (!b(uri)) {
            return null;
        }
        String authority = uri.getAuthority();
        if (authority == null) {
            authority = "";
        }
        Resources resourcesForApplication = kVar.g().getPackageManager().getResourcesForApplication(authority);
        List<String> pathSegments = uri.getPathSegments();
        boolean z10 = false;
        int identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
        if (identifier != 0) {
            z10 = true;
        }
        if (z10) {
            Uri parse = Uri.parse("android.resource://" + authority + '/' + identifier);
            j.f(parse, "parse(this)");
            return parse;
        }
        throw new IllegalStateException(("Invalid android.resource URI: " + uri).toString());
    }
}
