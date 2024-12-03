package androidx.profileinstaller;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

class a {

    /* renamed from: androidx.profileinstaller.a$a  reason: collision with other inner class name */
    private static class C0069a {
        static File a(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    static boolean a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            boolean z10 = true;
            for (File a10 : listFiles) {
                if (!a(a10) || !z10) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            }
            return z10;
        }
        file.delete();
        return true;
    }

    static void b(@NonNull Context context, @NonNull ProfileInstallReceiver.a aVar) {
        if (a(C0069a.a(context))) {
            aVar.a(14, (Object) null);
        } else {
            aVar.a(15, (Object) null);
        }
    }
}
