package q3;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import j3.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import p3.n;
import p3.o;
import p3.r;

public final class e<DataT> implements n<Uri, DataT> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17131a;

    /* renamed from: b  reason: collision with root package name */
    private final n<File, DataT> f17132b;

    /* renamed from: c  reason: collision with root package name */
    private final n<Uri, DataT> f17133c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<DataT> f17134d;

    private static abstract class a<DataT> implements o<Uri, DataT> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f17135a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<DataT> f17136b;

        a(Context context, Class<DataT> cls) {
            this.f17135a = context;
            this.f17136b = cls;
        }

        public final void a() {
        }

        @NonNull
        public final n<Uri, DataT> c(@NonNull r rVar) {
            return new e(this.f17135a, rVar.d(File.class, this.f17136b), rVar.d(Uri.class, this.f17136b), this.f17136b);
        }
    }

    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    private static final class d<DataT> implements j3.d<DataT> {

        /* renamed from: l  reason: collision with root package name */
        private static final String[] f17137l = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final Context f17138a;

        /* renamed from: b  reason: collision with root package name */
        private final n<File, DataT> f17139b;

        /* renamed from: c  reason: collision with root package name */
        private final n<Uri, DataT> f17140c;

        /* renamed from: d  reason: collision with root package name */
        private final Uri f17141d;

        /* renamed from: e  reason: collision with root package name */
        private final int f17142e;

        /* renamed from: f  reason: collision with root package name */
        private final int f17143f;

        /* renamed from: g  reason: collision with root package name */
        private final i3.e f17144g;

        /* renamed from: h  reason: collision with root package name */
        private final Class<DataT> f17145h;

        /* renamed from: j  reason: collision with root package name */
        private volatile boolean f17146j;

        /* renamed from: k  reason: collision with root package name */
        private volatile j3.d<DataT> f17147k;

        d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i10, int i11, i3.e eVar, Class<DataT> cls) {
            this.f17138a = context.getApplicationContext();
            this.f17139b = nVar;
            this.f17140c = nVar2;
            this.f17141d = uri;
            this.f17142e = i10;
            this.f17143f = i11;
            this.f17144g = eVar;
            this.f17145h = cls;
        }

        private n.a<DataT> c() throws FileNotFoundException {
            Uri uri;
            if (Environment.isExternalStorageLegacy()) {
                return this.f17139b.b(h(this.f17141d), this.f17142e, this.f17143f, this.f17144g);
            }
            if (g()) {
                uri = MediaStore.setRequireOriginal(this.f17141d);
            } else {
                uri = this.f17141d;
            }
            return this.f17140c.b(uri, this.f17142e, this.f17143f, this.f17144g);
        }

        private j3.d<DataT> f() throws FileNotFoundException {
            n.a c10 = c();
            if (c10 != null) {
                return c10.f16958c;
            }
            return null;
        }

        private boolean g() {
            return this.f17138a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @NonNull
        private File h(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                cursor = this.f17138a.getContentResolver().query(uri, f17137l, (String) null, (String[]) null, (String) null);
                if (cursor == null || !cursor.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    cursor.close();
                    return file;
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        }

        @NonNull
        public Class<DataT> a() {
            return this.f17145h;
        }

        public void b() {
            j3.d<DataT> dVar = this.f17147k;
            if (dVar != null) {
                dVar.b();
            }
        }

        public void cancel() {
            this.f17146j = true;
            j3.d<DataT> dVar = this.f17147k;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        public void d(@NonNull Priority priority, @NonNull d.a<? super DataT> aVar) {
            try {
                j3.d<DataT> f10 = f();
                if (f10 == null) {
                    aVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f17141d));
                    return;
                }
                this.f17147k = f10;
                if (this.f17146j) {
                    cancel();
                } else {
                    f10.d(priority, aVar);
                }
            } catch (FileNotFoundException e10) {
                aVar.c(e10);
            }
        }

        @NonNull
        public DataSource e() {
            return DataSource.LOCAL;
        }
    }

    e(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.f17131a = context.getApplicationContext();
        this.f17132b = nVar;
        this.f17133c = nVar2;
        this.f17134d = cls;
    }

    /* renamed from: c */
    public n.a<DataT> b(@NonNull Uri uri, int i10, int i11, @NonNull i3.e eVar) {
        return new n.a<>(new e4.d(uri), new d(this.f17131a, this.f17132b, this.f17133c, uri, i10, i11, eVar, this.f17134d));
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && k3.b.b(uri);
    }
}
