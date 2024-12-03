package k3;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import j3.d;
import j3.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class c implements d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f15646a;

    /* renamed from: b  reason: collision with root package name */
    private final e f15647b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f15648c;

    static class a implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f15649b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f15650a;

        a(ContentResolver contentResolver) {
            this.f15650a = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f15650a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f15649b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    static class b implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f15651b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f15652a;

        b(ContentResolver contentResolver) {
            this.f15652a = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f15652a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f15651b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    c(Uri uri, e eVar) {
        this.f15646a = uri;
        this.f15647b = eVar;
    }

    private static c c(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.c.c(context).j().g(), dVar, com.bumptech.glide.c.c(context).e(), context.getContentResolver()));
    }

    public static c f(Context context, Uri uri) {
        return c(context, uri, new a(context.getContentResolver()));
    }

    public static c g(Context context, Uri uri) {
        return c(context, uri, new b(context.getContentResolver()));
    }

    private InputStream h() throws FileNotFoundException {
        int i10;
        InputStream d10 = this.f15647b.d(this.f15646a);
        if (d10 != null) {
            i10 = this.f15647b.a(this.f15646a);
        } else {
            i10 = -1;
        }
        if (i10 != -1) {
            return new g(d10, i10);
        }
        return d10;
    }

    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        InputStream inputStream = this.f15648c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public void cancel() {
    }

    public void d(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        try {
            InputStream h10 = h();
            this.f15648c = h10;
            aVar.f(h10);
        } catch (FileNotFoundException e10) {
            Log.isLoggable("MediaStoreThumbFetcher", 3);
            aVar.c(e10);
        }
    }

    @NonNull
    public DataSource e() {
        return DataSource.LOCAL;
    }
}
