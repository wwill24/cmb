package p3;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import i3.e;
import java.io.File;
import java.io.InputStream;
import p3.n;

public class u<Data> implements n<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f16988a;

    public static final class a implements o<String, AssetFileDescriptor> {
        public void a() {
        }

        public n<String, AssetFileDescriptor> c(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements o<String, ParcelFileDescriptor> {
        public void a() {
        }

        @NonNull
        public n<String, ParcelFileDescriptor> c(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements o<String, InputStream> {
        public void a() {
        }

        @NonNull
        public n<String, InputStream> c(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, InputStream.class));
        }
    }

    public u(n<Uri, Data> nVar) {
        this.f16988a = nVar;
    }

    private static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null) {
            return f(str);
        }
        return parse;
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    /* renamed from: c */
    public n.a<Data> b(@NonNull String str, int i10, int i11, @NonNull e eVar) {
        Uri e10 = e(str);
        if (e10 == null || !this.f16988a.a(e10)) {
            return null;
        }
        return this.f16988a.b(e10, i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean a(@NonNull String str) {
        return true;
    }
}
