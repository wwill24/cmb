package androidx.camera.core;

import android.content.ContentValues;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.h1;
import androidx.camera.core.impl.utils.i;
import androidx.camera.core.internal.utils.ImageUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

final class ImageSaver implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final o1 f2086a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2087b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2088c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final h1.o f2089d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final Executor f2090e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final b f2091f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final Executor f2092g;

    public enum SaveError {
        FILE_IO_FAILED,
        ENCODE_FAILED,
        CROP_FAILED,
        UNKNOWN
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2098a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType[] r0 = androidx.camera.core.internal.utils.ImageUtil.CodecFailedException.FailureType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2098a = r0
                androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType r1 = androidx.camera.core.internal.utils.ImageUtil.CodecFailedException.FailureType.ENCODE_FAILED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2098a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType r1 = androidx.camera.core.internal.utils.ImageUtil.CodecFailedException.FailureType.DECODE_FAILED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2098a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType r1 = androidx.camera.core.internal.utils.ImageUtil.CodecFailedException.FailureType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageSaver.a.<clinit>():void");
        }
    }

    public interface b {
        void a(@NonNull h1.p pVar);

        void b(@NonNull SaveError saveError, @NonNull String str, Throwable th2);
    }

    ImageSaver(@NonNull o1 o1Var, @NonNull h1.o oVar, int i10, int i11, @NonNull Executor executor, @NonNull Executor executor2, @NonNull b bVar) {
        this.f2086a = o1Var;
        this.f2089d = oVar;
        this.f2087b = i10;
        this.f2088c = i11;
        this.f2091f = bVar;
        this.f2090e = executor;
        this.f2092g = executor2;
    }

    private void e(@NonNull File file, @NonNull OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private boolean f(@NonNull File file, @NonNull Uri uri) throws IOException {
        OutputStream openOutputStream = this.f2089d.a().openOutputStream(uri);
        if (openOutputStream == null) {
            if (openOutputStream != null) {
                openOutputStream.close();
            }
            return false;
        }
        try {
            e(file, openOutputStream);
            openOutputStream.close();
            return true;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    @NonNull
    private byte[] g(@NonNull o1 o1Var, int i10) throws ImageUtil.CodecFailedException {
        boolean n10 = ImageUtil.n(o1Var);
        int format2 = o1Var.getFormat();
        if (format2 != 256) {
            Rect rect = null;
            if (format2 == 35) {
                if (n10) {
                    rect = o1Var.X0();
                }
                return ImageUtil.p(o1Var, rect, i10);
            }
            v1.l("ImageSaver", "Unrecognized image format: " + format2);
            return null;
        } else if (!n10) {
            return ImageUtil.i(o1Var);
        } else {
            return ImageUtil.j(o1Var, o1Var.X0(), i10);
        }
    }

    private boolean h() {
        return this.f2089d.c() != null;
    }

    private boolean i() {
        if (this.f2089d.f() == null || this.f2089d.a() == null || this.f2089d.b() == null) {
            return false;
        }
        return true;
    }

    private boolean j() {
        return this.f2089d.e() != null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(SaveError saveError, String str, Throwable th2) {
        this.f2091f.b(saveError, str, th2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(Uri uri) {
        this.f2091f.a(new h1.p(uri));
    }

    private void n(SaveError saveError, String str, Throwable th2) {
        try {
            this.f2090e.execute(new t1(this, saveError, str, th2));
        } catch (RejectedExecutionException unused) {
            v1.c("ImageSaver", "Application executor rejected executing OnImageSavedCallback.onError callback. Skipping.");
        }
    }

    private void o(Uri uri) {
        try {
            this.f2090e.execute(new s1(this, uri));
        } catch (RejectedExecutionException unused) {
            v1.c("ImageSaver", "Application executor rejected executing OnImageSavedCallback.onImageSaved callback. Skipping.");
        }
    }

    private File p() {
        File file;
        String str;
        SaveError saveError;
        ImageUtil.CodecFailedException codecFailedException;
        FileOutputStream fileOutputStream;
        try {
            if (h()) {
                file = new File(this.f2089d.c().getParent(), "CameraX" + UUID.randomUUID().toString() + ".tmp");
            } else {
                file = File.createTempFile("CameraX", ".tmp");
            }
            try {
                o1 o1Var = this.f2086a;
                try {
                    fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(g(this.f2086a, this.f2088c));
                    i h10 = i.h(file);
                    i.j(this.f2086a).g(h10);
                    if (!new y.a().b(this.f2086a)) {
                        h10.z(this.f2087b);
                    }
                    h1.l d10 = this.f2089d.d();
                    if (d10.b()) {
                        h10.l();
                    }
                    if (d10.c()) {
                        h10.m();
                    }
                    if (d10.a() != null) {
                        h10.b(this.f2089d.d().a());
                    }
                    h10.A();
                    fileOutputStream.close();
                    if (o1Var != null) {
                        o1Var.close();
                    }
                    codecFailedException = null;
                    saveError = null;
                    str = null;
                } catch (Throwable th2) {
                    if (o1Var != null) {
                        o1Var.close();
                    }
                    throw th2;
                }
            } catch (IOException | IllegalArgumentException e10) {
                saveError = SaveError.FILE_IO_FAILED;
                str = "Failed to write temp file";
                codecFailedException = e10;
            } catch (ImageUtil.CodecFailedException e11) {
                int i10 = a.f2098a[e11.a().ordinal()];
                if (i10 == 1) {
                    saveError = SaveError.ENCODE_FAILED;
                    str = "Failed to encode mImage";
                    codecFailedException = e11;
                } else if (i10 != 2) {
                    saveError = SaveError.UNKNOWN;
                    str = "Failed to transcode mImage";
                    codecFailedException = e11;
                } else {
                    saveError = SaveError.CROP_FAILED;
                    str = "Failed to crop mImage";
                    codecFailedException = e11;
                }
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            if (saveError == null) {
                return file;
            }
            n(saveError, str, codecFailedException);
            file.delete();
            return null;
            throw th;
        } catch (IOException e12) {
            n(SaveError.FILE_IO_FAILED, "Failed to create temp file", e12);
            return null;
        }
    }

    private void q(@NonNull ContentValues contentValues, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", Integer.valueOf(i10));
        }
    }

    private void r(@NonNull Uri uri) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            q(contentValues, 0);
            this.f2089d.a().update(uri, contentValues, (String) null, (String[]) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a4  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m(@androidx.annotation.NonNull java.io.File r6) {
        /*
            r5 = this;
            androidx.core.util.h.g(r6)
            r0 = 0
            boolean r1 = r5.i()     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            if (r1 == 0) goto L_0x0054
            androidx.camera.core.h1$o r1 = r5.f2089d     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            android.content.ContentValues r1 = r1.b()     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            if (r1 == 0) goto L_0x001e
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            androidx.camera.core.h1$o r2 = r5.f2089d     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            android.content.ContentValues r2 = r2.b()     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            goto L_0x0023
        L_0x001e:
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            r1.<init>()     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
        L_0x0023:
            r2 = 1
            r5.q(r1, r2)     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            androidx.camera.core.h1$o r2 = r5.f2089d     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            android.content.ContentResolver r2 = r2.a()     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            androidx.camera.core.h1$o r3 = r5.f2089d     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            android.net.Uri r3 = r3.f()     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            android.net.Uri r1 = r2.insert(r3, r1)     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            if (r1 != 0) goto L_0x003f
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ IOException -> 0x0052, IllegalArgumentException -> 0x0050 }
            java.lang.String r3 = "Failed to insert URI."
            goto L_0x009b
        L_0x003f:
            boolean r2 = r5.f(r6, r1)     // Catch:{ IOException -> 0x0052, IllegalArgumentException -> 0x0050 }
            if (r2 != 0) goto L_0x004a
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ IOException -> 0x0052, IllegalArgumentException -> 0x0050 }
            java.lang.String r3 = "Failed to save to URI."
            goto L_0x004c
        L_0x004a:
            r2 = r0
            r3 = r2
        L_0x004c:
            r5.r(r1)     // Catch:{ IOException -> 0x0052, IllegalArgumentException -> 0x0050 }
            goto L_0x009b
        L_0x0050:
            r0 = move-exception
            goto L_0x0097
        L_0x0052:
            r0 = move-exception
            goto L_0x0097
        L_0x0054:
            boolean r1 = r5.j()     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            if (r1 == 0) goto L_0x0064
            androidx.camera.core.h1$o r1 = r5.f2089d     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            java.io.OutputStream r1 = r1.e()     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            r5.e(r6, r1)     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            goto L_0x008b
        L_0x0064:
            boolean r1 = r5.h()     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            if (r1 == 0) goto L_0x008b
            androidx.camera.core.h1$o r1 = r5.f2089d     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            java.io.File r1 = r1.c()     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            boolean r2 = r1.exists()     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            if (r2 == 0) goto L_0x0079
            r1.delete()     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
        L_0x0079:
            boolean r2 = r6.renameTo(r1)     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            if (r2 != 0) goto L_0x0084
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            java.lang.String r3 = "Failed to rename file."
            goto L_0x0086
        L_0x0084:
            r2 = r0
            r3 = r2
        L_0x0086:
            android.net.Uri r1 = android.net.Uri.fromFile(r1)     // Catch:{ IOException -> 0x0093, IllegalArgumentException -> 0x0091 }
            goto L_0x009b
        L_0x008b:
            r1 = r0
            r2 = r1
            r3 = r2
            goto L_0x009b
        L_0x008f:
            r0 = move-exception
            goto L_0x00a8
        L_0x0091:
            r1 = move-exception
            goto L_0x0094
        L_0x0093:
            r1 = move-exception
        L_0x0094:
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0097:
            androidx.camera.core.ImageSaver$SaveError r2 = androidx.camera.core.ImageSaver.SaveError.FILE_IO_FAILED     // Catch:{ all -> 0x008f }
            java.lang.String r3 = "Failed to write destination file."
        L_0x009b:
            r6.delete()
            if (r2 == 0) goto L_0x00a4
            r5.n(r2, r3, r0)
            goto L_0x00a7
        L_0x00a4:
            r5.o(r1)
        L_0x00a7:
            return
        L_0x00a8:
            r6.delete()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageSaver.m(java.io.File):void");
    }

    public void run() {
        File p10 = p();
        if (p10 != null) {
            this.f2092g.execute(new r1(this, p10));
        }
    }
}
