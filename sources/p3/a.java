package p3;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import i3.e;
import j3.d;
import j3.h;
import j3.n;
import java.io.InputStream;
import p3.n;

public class a<Data> implements n<Uri, Data> {

    /* renamed from: c  reason: collision with root package name */
    private static final int f16906c = 22;

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f16907a;

    /* renamed from: b  reason: collision with root package name */
    private final C0184a<Data> f16908b;

    /* renamed from: p3.a$a  reason: collision with other inner class name */
    public interface C0184a<Data> {
        d<Data> b(AssetManager assetManager, String str);
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, C0184a<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f16909a;

        public b(AssetManager assetManager) {
            this.f16909a = assetManager;
        }

        public void a() {
        }

        public d<ParcelFileDescriptor> b(AssetManager assetManager, String str) {
            return new h(assetManager, str);
        }

        @NonNull
        public n<Uri, ParcelFileDescriptor> c(r rVar) {
            return new a(this.f16909a, this);
        }
    }

    public static class c implements o<Uri, InputStream>, C0184a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f16910a;

        public c(AssetManager assetManager) {
            this.f16910a = assetManager;
        }

        public void a() {
        }

        public d<InputStream> b(AssetManager assetManager, String str) {
            return new n(assetManager, str);
        }

        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new a(this.f16910a, this);
        }
    }

    public a(AssetManager assetManager, C0184a<Data> aVar) {
        this.f16907a = assetManager;
        this.f16908b = aVar;
    }

    /* renamed from: c */
    public n.a<Data> b(@NonNull Uri uri, int i10, int i11, @NonNull e eVar) {
        return new n.a<>(new e4.d(uri), this.f16908b.b(this.f16907a, uri.toString().substring(f16906c)));
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }
}
