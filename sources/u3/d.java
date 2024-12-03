package u3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import i3.e;
import i3.f;
import java.util.List;
import l3.c;

public class d implements f<Uri, Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f18014a;

    public d(Context context) {
        this.f18014a = context.getApplicationContext();
    }

    @NonNull
    private Context d(Uri uri, String str) {
        if (str.equals(this.f18014a.getPackageName())) {
            return this.f18014a;
        }
        try {
            return this.f18014a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            if (str.contains(this.f18014a.getPackageName())) {
                return this.f18014a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e10);
        }
    }

    private int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e10) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e10);
        }
    }

    private int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    /* renamed from: c */
    public c<Drawable> a(@NonNull Uri uri, int i10, int i11, @NonNull e eVar) {
        Context d10 = d(uri, uri.getAuthority());
        return c.d(a.b(this.f18014a, d10, g(d10, uri)));
    }

    /* renamed from: h */
    public boolean b(@NonNull Uri uri, @NonNull e eVar) {
        return uri.getScheme().equals("android.resource");
    }
}
