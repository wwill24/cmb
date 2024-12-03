package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import androidx.annotation.NonNull;
import androidx.core.provider.g;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.cli.HelpFormatter;
import org.jivesoftware.smack.sm.packet.StreamManagement;

public class l {

    static class a {
        static ParcelFileDescriptor a(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
            return contentResolver.openFileDescriptor(uri, str, cancellationSignal);
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static ByteBuffer b(@NonNull Context context, @NonNull Resources resources, int i10) {
        File e10 = e(context);
        if (e10 == null) {
            return null;
        }
        try {
            if (!c(e10, resources, i10)) {
                return null;
            }
            ByteBuffer g10 = g(e10);
            e10.delete();
            return g10;
        } finally {
            e10.delete();
        }
    }

    public static boolean c(@NonNull File file, @NonNull Resources resources, int i10) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i10);
            try {
                boolean d10 = d(file, inputStream);
                a(inputStream);
                return d10;
            } catch (Throwable th2) {
                th = th2;
                a(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            a(inputStream);
            throw th;
        }
    }

    public static boolean d(@NonNull File file, @NonNull InputStream inputStream) {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        a(fileOutputStream2);
                        StrictMode.setThreadPolicy(allowThreadDiskWrites);
                        return true;
                    }
                }
            } catch (IOException e10) {
                e = e10;
                fileOutputStream = fileOutputStream2;
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error copying resource contents to temp file: ");
                    sb2.append(e.getMessage());
                    a(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    a(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                a(fileOutputStream);
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                throw th;
            }
        } catch (IOException e11) {
            e = e11;
            StringBuilder sb22 = new StringBuilder();
            sb22.append("Error copying resource contents to temp file: ");
            sb22.append(e.getMessage());
            a(fileOutputStream);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        }
    }

    public static File e(@NonNull Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + HelpFormatter.DEFAULT_OPT_PREFIX + Process.myTid() + HelpFormatter.DEFAULT_OPT_PREFIX;
        int i10 = 0;
        while (i10 < 100) {
            File file = new File(cacheDir, str + i10);
            try {
                if (file.createNewFile()) {
                    return file;
                }
                i10++;
            } catch (IOException unused) {
            }
        }
        return null;
    }

    public static ByteBuffer f(@NonNull Context context, CancellationSignal cancellationSignal, @NonNull Uri uri) {
        FileInputStream fileInputStream;
        try {
            ParcelFileDescriptor a10 = a.a(context.getContentResolver(), uri, StreamManagement.AckRequest.ELEMENT, cancellationSignal);
            if (a10 == null) {
                if (a10 != null) {
                    a10.close();
                }
                return null;
            }
            try {
                fileInputStream = new FileInputStream(a10.getFileDescriptor());
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                fileInputStream.close();
                a10.close();
                return map;
            } catch (Throwable th2) {
                a10.close();
                throw th2;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
    }

    private static ByteBuffer g(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            fileInputStream.close();
            return map;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    @NonNull
    public static Map<Uri, ByteBuffer> h(@NonNull Context context, @NonNull g.b[] bVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (g.b bVar : bVarArr) {
            if (bVar.b() == 0) {
                Uri d10 = bVar.d();
                if (!hashMap.containsKey(d10)) {
                    hashMap.put(d10, f(context, cancellationSignal, d10));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
