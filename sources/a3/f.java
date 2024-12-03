package a3;

import androidx.annotation.NonNull;
import com.airbnb.lottie.network.FileExtension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class f {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final d f130a;

    public f(@NonNull d dVar) {
        this.f130a = dVar;
    }

    private static String b(String str, FileExtension fileExtension, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("lottie_cache_");
        sb2.append(str.replaceAll("\\W+", ""));
        sb2.append(z10 ? fileExtension.b() : fileExtension.extension);
        return sb2.toString();
    }

    private File c(String str) throws FileNotFoundException {
        File file = new File(d(), b(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(d(), b(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File d() {
        File a10 = this.f130a.a();
        if (a10.isFile()) {
            a10.delete();
        }
        if (!a10.exists()) {
            a10.mkdirs();
        }
        return a10;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<com.airbnb.lottie.network.FileExtension, java.io.InputStream> a(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.File r1 = r5.c(r6)     // Catch:{ FileNotFoundException -> 0x0044 }
            if (r1 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{  }
            r2.<init>(r1)     // Catch:{  }
            java.lang.String r0 = r1.getAbsolutePath()
            java.lang.String r3 = ".zip"
            boolean r0 = r0.endsWith(r3)
            if (r0 == 0) goto L_0x001c
            com.airbnb.lottie.network.FileExtension r0 = com.airbnb.lottie.network.FileExtension.ZIP
            goto L_0x001e
        L_0x001c:
            com.airbnb.lottie.network.FileExtension r0 = com.airbnb.lottie.network.FileExtension.JSON
        L_0x001e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Cache hit for "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r6 = " at "
            r3.append(r6)
            java.lang.String r6 = r1.getAbsolutePath()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            c3.f.a(r6)
            android.util.Pair r6 = new android.util.Pair
            r6.<init>(r0, r2)
            return r6
        L_0x0044:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.f.a(java.lang.String):android.util.Pair");
    }

    /* access modifiers changed from: package-private */
    public void e(String str, FileExtension fileExtension) {
        File file = new File(d(), b(str, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        c3.f.a("Copying temp file to real file (" + file2 + ")");
        if (!renameTo) {
            c3.f.c("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
        }
    }

    /* access modifiers changed from: package-private */
    public File f(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        FileOutputStream fileOutputStream;
        File file = new File(d(), b(str, fileExtension, true));
        try {
            fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (Throwable th2) {
            inputStream.close();
            throw th2;
        }
    }
}
