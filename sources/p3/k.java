package p3;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import i3.e;
import j3.d;
import java.io.File;
import java.io.FileNotFoundException;
import p3.n;

public final class k implements n<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16945a;

    public static final class a implements o<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f16946a;

        public a(Context context) {
            this.f16946a = context;
        }

        public void a() {
        }

        @NonNull
        public n<Uri, File> c(r rVar) {
            return new k(this.f16946a);
        }
    }

    private static class b implements d<File> {

        /* renamed from: c  reason: collision with root package name */
        private static final String[] f16947c = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final Context f16948a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f16949b;

        b(Context context, Uri uri) {
            this.f16948a = context;
            this.f16949b = uri;
        }

        @NonNull
        public Class<File> a() {
            return File.class;
        }

        public void b() {
        }

        public void cancel() {
        }

        public void d(@NonNull Priority priority, @NonNull d.a<? super File> aVar) {
            Cursor query = this.f16948a.getContentResolver().query(this.f16949b, f16947c, (String) null, (String[]) null, (String) null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                aVar.c(new FileNotFoundException("Failed to find file path for: " + this.f16949b));
                return;
            }
            aVar.f(new File(str));
        }

        @NonNull
        public DataSource e() {
            return DataSource.LOCAL;
        }
    }

    public k(Context context) {
        this.f16945a = context;
    }

    /* renamed from: c */
    public n.a<File> b(@NonNull Uri uri, int i10, int i11, @NonNull e eVar) {
        return new n.a<>(new e4.d(uri), new b(this.f16945a, uri));
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return k3.b.b(uri);
    }
}
