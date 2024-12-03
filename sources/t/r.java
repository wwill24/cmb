package t;

import a0.n;
import a0.o;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.h1;
import androidx.camera.core.impl.utils.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.UUID;

class r implements n<a, h1.p> {

    static abstract class a {
        a() {
        }

        @NonNull
        static a c(@NonNull o<byte[]> oVar, @NonNull h1.o oVar2) {
            return new e(oVar, oVar2);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract h1.o a();

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract o<byte[]> b();
    }

    r() {
    }

    private static Uri b(@NonNull File file, @NonNull File file2) throws ImageCaptureException {
        if (file2.exists()) {
            file2.delete();
        }
        if (file.renameTo(file2)) {
            return Uri.fromFile(file2);
        }
        throw new ImageCaptureException(1, "Failed to overwrite the file: " + file2.getAbsolutePath(), (Throwable) null);
    }

    private static Uri c(@NonNull File file, @NonNull h1.o oVar) throws ImageCaptureException {
        ContentValues contentValues;
        ContentResolver a10 = oVar.a();
        Objects.requireNonNull(a10);
        ContentResolver contentResolver = a10;
        if (oVar.b() != null) {
            contentValues = new ContentValues(oVar.b());
        } else {
            contentValues = new ContentValues();
        }
        k(contentValues, 1);
        Uri insert = a10.insert(oVar.f(), contentValues);
        if (insert != null) {
            try {
                f(file, insert, a10);
                m(insert, a10, 0);
                return insert;
            } catch (IOException e10) {
                throw new ImageCaptureException(1, "Failed to write to MediaStore URI: " + insert, e10);
            } catch (Throwable th2) {
                m(insert, a10, 0);
                throw th2;
            }
        } else {
            throw new ImageCaptureException(1, "Failed to insert a MediaStore URI.", (Throwable) null);
        }
    }

    private static void d(@NonNull File file, @NonNull OutputStream outputStream) throws IOException {
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

    private static Uri e(@NonNull File file, @NonNull h1.o oVar) throws ImageCaptureException {
        if (i(oVar)) {
            return c(file, oVar);
        }
        if (j(oVar)) {
            try {
                OutputStream e10 = oVar.e();
                Objects.requireNonNull(e10);
                OutputStream outputStream = e10;
                d(file, e10);
                return null;
            } catch (IOException unused) {
                throw new ImageCaptureException(1, "Failed to write to OutputStream.", (Throwable) null);
            }
        } else if (h(oVar)) {
            File c10 = oVar.c();
            Objects.requireNonNull(c10);
            File file2 = c10;
            return b(file, c10);
        } else {
            throw new ImageCaptureException(0, "Invalid OutputFileOptions", (Throwable) null);
        }
    }

    private static void f(@NonNull File file, @NonNull Uri uri, @NonNull ContentResolver contentResolver) throws IOException {
        OutputStream openOutputStream = contentResolver.openOutputStream(uri);
        if (openOutputStream != null) {
            try {
                d(file, openOutputStream);
                openOutputStream.close();
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            throw new FileNotFoundException(uri + " cannot be resolved.");
        }
        throw th;
    }

    @NonNull
    private static File g(@NonNull h1.o oVar) throws ImageCaptureException {
        try {
            File c10 = oVar.c();
            if (c10 == null) {
                return File.createTempFile("CameraX", ".tmp");
            }
            String parent = c10.getParent();
            return new File(parent, "CameraX" + UUID.randomUUID().toString() + ".tmp");
        } catch (IOException e10) {
            throw new ImageCaptureException(1, "Failed to create temp file.", e10);
        }
    }

    private static boolean h(h1.o oVar) {
        return oVar.c() != null;
    }

    private static boolean i(h1.o oVar) {
        if (oVar.f() == null || oVar.a() == null || oVar.b() == null) {
            return false;
        }
        return true;
    }

    private static boolean j(h1.o oVar) {
        return oVar.e() != null;
    }

    private static void k(@NonNull ContentValues contentValues, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", Integer.valueOf(i10));
        }
    }

    private static void l(@NonNull File file, @NonNull i iVar, @NonNull h1.o oVar, int i10) throws ImageCaptureException {
        try {
            i h10 = i.h(file);
            iVar.g(h10);
            if (h10.s() == 0 && i10 != 0) {
                h10.z(i10);
            }
            h1.l d10 = oVar.d();
            if (d10.b()) {
                h10.l();
            }
            if (d10.c()) {
                h10.m();
            }
            if (d10.a() != null) {
                h10.b(d10.a());
            }
            h10.A();
        } catch (IOException e10) {
            throw new ImageCaptureException(1, "Failed to update Exif data", e10);
        }
    }

    private static void m(@NonNull Uri uri, @NonNull ContentResolver contentResolver, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            k(contentValues, i10);
            contentResolver.update(uri, contentValues, (String) null, (String[]) null);
        }
    }

    private static void n(@NonNull File file, @NonNull byte[] bArr) throws ImageCaptureException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return;
        } catch (IOException e10) {
            throw new ImageCaptureException(1, "Failed to write to temp file", e10);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    @NonNull
    /* renamed from: a */
    public h1.p apply(@NonNull a aVar) throws ImageCaptureException {
        o<byte[]> b10 = aVar.b();
        h1.o a10 = aVar.a();
        File g10 = g(a10);
        n(g10, b10.c());
        i d10 = b10.d();
        Objects.requireNonNull(d10);
        l(g10, d10, a10, b10.f());
        return new h1.p(e(g10, a10));
    }
}
