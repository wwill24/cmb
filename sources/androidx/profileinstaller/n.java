package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import net.bytebuddy.jar.asm.Opcodes;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final androidx.concurrent.futures.b<c> f6177a = androidx.concurrent.futures.b.a();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f6178b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static c f6179c = null;

    private static class a {
        static PackageInfo a(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f6180a;

        /* renamed from: b  reason: collision with root package name */
        final int f6181b;

        /* renamed from: c  reason: collision with root package name */
        final long f6182c;

        /* renamed from: d  reason: collision with root package name */
        final long f6183d;

        b(int i10, int i11, long j10, long j11) {
            this.f6180a = i10;
            this.f6181b = i11;
            this.f6182c = j10;
            this.f6183d = j11;
        }

        static b a(@NonNull File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }

        /* access modifiers changed from: package-private */
        public void b(@NonNull File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f6180a);
                dataOutputStream.writeInt(this.f6181b);
                dataOutputStream.writeLong(this.f6182c);
                dataOutputStream.writeLong(this.f6183d);
                dataOutputStream.close();
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f6181b == bVar.f6181b && this.f6182c == bVar.f6182c && this.f6180a == bVar.f6180a && this.f6183d == bVar.f6183d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.f6181b), Long.valueOf(this.f6182c), Integer.valueOf(this.f6180a), Long.valueOf(this.f6183d)});
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final int f6184a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f6185b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f6186c;

        c(int i10, boolean z10, boolean z11) {
            this.f6184a = i10;
            this.f6186c = z11;
            this.f6185b = z10;
        }
    }

    private static long a(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return a.a(packageManager, context).lastUpdateTime;
        }
        return packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    private static c b(int i10, boolean z10, boolean z11) {
        c cVar = new c(i10, z10, z11);
        f6179c = cVar;
        f6177a.set(cVar);
        return f6179c;
    }

    @NonNull
    static c c(@NonNull Context context, boolean z10) {
        boolean z11;
        boolean z12;
        b bVar;
        c cVar;
        if (!z10 && (cVar = f6179c) != null) {
            return cVar;
        }
        synchronized (f6178b) {
            if (!z10) {
                c cVar2 = f6179c;
                if (cVar2 != null) {
                    return cVar2;
                }
            }
            int i10 = Build.VERSION.SDK_INT;
            int i11 = 0;
            if (i10 >= 28) {
                if (i10 != 30) {
                    File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                    long length = file.length();
                    if (!file.exists() || length <= 0) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                    long length2 = file2.length();
                    if (!file2.exists() || length2 <= 0) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    try {
                        long a10 = a(context);
                        File file3 = new File(context.getFilesDir(), "profileInstalled");
                        b bVar2 = null;
                        if (file3.exists()) {
                            try {
                                bVar2 = b.a(file3);
                            } catch (IOException unused) {
                                return b(Opcodes.ACC_DEPRECATED, z11, z12);
                            }
                        }
                        if (bVar2 != null && bVar2.f6182c == a10) {
                            int i12 = bVar2.f6181b;
                            if (i12 != 2) {
                                i11 = i12;
                                if (z10 && z12 && i11 != 1) {
                                    i11 = 2;
                                }
                                if (bVar2 != null && bVar2.f6181b == 2 && i11 == 1 && length < bVar2.f6183d) {
                                    i11 = 3;
                                }
                                bVar = new b(1, i11, a10, length2);
                                if (bVar2 == null || !bVar2.equals(bVar)) {
                                    bVar.b(file3);
                                }
                                c b10 = b(i11, z11, z12);
                                return b10;
                            }
                        }
                        if (z11) {
                            i11 = 1;
                        } else if (z12) {
                            i11 = 2;
                        }
                        i11 = 2;
                        i11 = 3;
                        bVar = new b(1, i11, a10, length2);
                        try {
                            bVar.b(file3);
                        } catch (IOException unused2) {
                            i11 = 196608;
                        }
                        c b102 = b(i11, z11, z12);
                        return b102;
                    } catch (PackageManager.NameNotFoundException unused3) {
                        return b(65536, z11, z12);
                    }
                }
            }
            c b11 = b(Opcodes.ASM4, false, false);
            return b11;
        }
    }
}
