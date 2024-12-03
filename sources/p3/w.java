package p3;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import i3.e;
import j3.i;
import j3.o;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p3.n;

public class w<Data> implements n<Uri, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f16992b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", "content"})));

    /* renamed from: a  reason: collision with root package name */
    private final c<Data> f16993a;

    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f16994a;

        public a(ContentResolver contentResolver) {
            this.f16994a = contentResolver;
        }

        public void a() {
        }

        public j3.d<AssetFileDescriptor> b(Uri uri) {
            return new j3.a(this.f16994a, uri);
        }

        public n<Uri, AssetFileDescriptor> c(r rVar) {
            return new w(this);
        }
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f16995a;

        public b(ContentResolver contentResolver) {
            this.f16995a = contentResolver;
        }

        public void a() {
        }

        public j3.d<ParcelFileDescriptor> b(Uri uri) {
            return new i(this.f16995a, uri);
        }

        @NonNull
        public n<Uri, ParcelFileDescriptor> c(r rVar) {
            return new w(this);
        }
    }

    public interface c<Data> {
        j3.d<Data> b(Uri uri);
    }

    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f16996a;

        public d(ContentResolver contentResolver) {
            this.f16996a = contentResolver;
        }

        public void a() {
        }

        public j3.d<InputStream> b(Uri uri) {
            return new o(this.f16996a, uri);
        }

        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new w(this);
        }
    }

    public w(c<Data> cVar) {
        this.f16993a = cVar;
    }

    /* renamed from: c */
    public n.a<Data> b(@NonNull Uri uri, int i10, int i11, @NonNull e eVar) {
        return new n.a<>(new e4.d(uri), this.f16993a.b(uri));
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return f16992b.contains(uri.getScheme());
    }
}
