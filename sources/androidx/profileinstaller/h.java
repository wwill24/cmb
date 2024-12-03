package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final c f6168a = new a();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    static final c f6169b = new b();

    class a implements c {
        a() {
        }

        public void a(int i10, Object obj) {
        }

        public void b(int i10, Object obj) {
        }
    }

    class b implements c {
        b() {
        }

        public void a(int i10, Object obj) {
            switch (i10) {
            }
            if (i10 == 6 || i10 == 7 || i10 == 8) {
                Throwable th2 = (Throwable) obj;
            }
        }

        public void b(int i10, Object obj) {
        }
    }

    public interface c {
        void a(int i10, Object obj);

        void b(int i10, Object obj);
    }

    static boolean b(@NonNull File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    static void c(@NonNull Context context, @NonNull Executor executor, @NonNull c cVar) {
        b(context.getFilesDir());
        g(executor, cVar, 11, (Object) null);
    }

    static boolean d(PackageInfo packageInfo, File file, c cVar) {
        DataInputStream dataInputStream;
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        boolean z10 = false;
        if (!file2.exists()) {
            return false;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(file2));
            long readLong = dataInputStream.readLong();
            dataInputStream.close();
            if (readLong == packageInfo.lastUpdateTime) {
                z10 = true;
            }
            if (z10) {
                cVar.a(2, (Object) null);
            }
            return z10;
        } catch (IOException unused) {
            return false;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    static void f(@NonNull PackageInfo packageInfo, @NonNull File file) {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            dataOutputStream.writeLong(packageInfo.lastUpdateTime);
            dataOutputStream.close();
            return;
        } catch (IOException unused) {
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    static void g(@NonNull Executor executor, @NonNull c cVar, int i10, Object obj) {
        executor.execute(new g(cVar, i10, obj));
    }

    private static boolean h(@NonNull AssetManager assetManager, @NonNull String str, @NonNull PackageInfo packageInfo, @NonNull File file, @NonNull String str2, @NonNull Executor executor, @NonNull c cVar) {
        c cVar2 = new c(assetManager, executor, cVar, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
        if (!cVar2.e()) {
            return false;
        }
        boolean n10 = cVar2.i().m().n();
        if (n10) {
            f(packageInfo, file);
        }
        return n10;
    }

    public static void i(@NonNull Context context) {
        j(context, new f(), f6168a);
    }

    public static void j(@NonNull Context context, @NonNull Executor executor, @NonNull c cVar) {
        k(context, executor, cVar, false);
    }

    static void k(@NonNull Context context, @NonNull Executor executor, @NonNull c cVar, boolean z10) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z11 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (z10 || !d(packageInfo, filesDir, cVar)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Installing profile for ");
                sb2.append(context.getPackageName());
                if (h(assets, packageName, packageInfo, filesDir, name, executor, cVar) && z10) {
                    z11 = true;
                }
                n.c(context, z11);
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Skipping profile installation for ");
            sb3.append(context.getPackageName());
            n.c(context, false);
        } catch (PackageManager.NameNotFoundException e10) {
            cVar.a(7, e10);
            n.c(context, false);
        }
    }

    static void l(@NonNull Context context, @NonNull Executor executor, @NonNull c cVar) {
        try {
            f(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            g(executor, cVar, 10, (Object) null);
        } catch (PackageManager.NameNotFoundException e10) {
            g(executor, cVar, 7, e10);
        }
    }
}
