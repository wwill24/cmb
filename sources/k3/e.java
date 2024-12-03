package k3;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import m3.b;

class e {

    /* renamed from: f  reason: collision with root package name */
    private static final a f15653f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final a f15654a;

    /* renamed from: b  reason: collision with root package name */
    private final d f15655b;

    /* renamed from: c  reason: collision with root package name */
    private final b f15656c;

    /* renamed from: d  reason: collision with root package name */
    private final ContentResolver f15657d;

    /* renamed from: e  reason: collision with root package name */
    private final List<ImageHeaderParser> f15658e;

    e(List<ImageHeaderParser> list, d dVar, b bVar, ContentResolver contentResolver) {
        this(list, f15653f, dVar, bVar, contentResolver);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002a A[Catch:{ all -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(@androidx.annotation.NonNull android.net.Uri r5) {
        /*
            r4 = this;
            r0 = 0
            k3.d r1 = r4.f15655b     // Catch:{ SecurityException -> 0x0020, all -> 0x001e }
            android.database.Cursor r1 = r1.a(r5)     // Catch:{ SecurityException -> 0x0020, all -> 0x001e }
            if (r1 == 0) goto L_0x0018
            boolean r2 = r1.moveToFirst()     // Catch:{ SecurityException -> 0x0021 }
            if (r2 == 0) goto L_0x0018
            r2 = 0
            java.lang.String r5 = r1.getString(r2)     // Catch:{ SecurityException -> 0x0021 }
            r1.close()
            return r5
        L_0x0018:
            if (r1 == 0) goto L_0x001d
            r1.close()
        L_0x001d:
            return r0
        L_0x001e:
            r5 = move-exception
            goto L_0x003f
        L_0x0020:
            r1 = r0
        L_0x0021:
            java.lang.String r2 = "ThumbStreamOpener"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x0037
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003d }
            r2.<init>()     // Catch:{ all -> 0x003d }
            java.lang.String r3 = "Failed to query for thumbnail for Uri: "
            r2.append(r3)     // Catch:{ all -> 0x003d }
            r2.append(r5)     // Catch:{ all -> 0x003d }
        L_0x0037:
            if (r1 == 0) goto L_0x003c
            r1.close()
        L_0x003c:
            return r0
        L_0x003d:
            r5 = move-exception
            r0 = r1
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.e.b(android.net.Uri):java.lang.String");
    }

    private boolean c(File file) {
        return this.f15654a.a(file) && 0 < this.f15654a.c(file);
    }

    /* access modifiers changed from: package-private */
    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            InputStream openInputStream = this.f15657d.openInputStream(uri);
            int b10 = a.b(this.f15658e, openInputStream, this.f15656c);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException unused) {
                }
            }
            return b10;
        } catch (IOException | NullPointerException unused2) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to open uri: ");
                sb2.append(uri);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused3) {
                return -1;
            }
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th2;
        }
    }

    public InputStream d(Uri uri) throws FileNotFoundException {
        String b10 = b(uri);
        if (TextUtils.isEmpty(b10)) {
            return null;
        }
        File b11 = this.f15654a.b(b10);
        if (!c(b11)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(b11);
        try {
            return this.f15657d.openInputStream(fromFile);
        } catch (NullPointerException e10) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e10));
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, b bVar, ContentResolver contentResolver) {
        this.f15654a = aVar;
        this.f15655b = dVar;
        this.f15656c = bVar;
        this.f15657d = contentResolver;
        this.f15658e = list;
    }
}
