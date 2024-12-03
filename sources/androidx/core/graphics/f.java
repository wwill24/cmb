package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.core.content.res.e;
import androidx.core.provider.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.jivesoftware.smack.sm.packet.StreamManagement;

class f extends k {

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f4611b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Constructor<?> f4612c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Method f4613d = null;

    /* renamed from: e  reason: collision with root package name */
    private static Method f4614e = null;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f4615f = false;

    f() {
    }

    private static boolean h(Object obj, String str, int i10, boolean z10) {
        k();
        try {
            return ((Boolean) f4613d.invoke(obj, new Object[]{str, Integer.valueOf(i10), Boolean.valueOf(z10)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static Typeface i(Object obj) {
        k();
        try {
            Object newInstance = Array.newInstance(f4611b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f4614e.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    private File j(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void k() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f4615f) {
            f4615f = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                method2 = null;
                cls = null;
                method = null;
            }
            f4612c = constructor;
            f4611b = cls;
            f4613d = method;
            f4614e = method2;
        }
    }

    private static Object l() {
        k();
        try {
            return f4612c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    public Typeface a(Context context, e.c cVar, Resources resources, int i10) {
        Object l10 = l();
        e.d[] a10 = cVar.a();
        int length = a10.length;
        int i11 = 0;
        while (i11 < length) {
            e.d dVar = a10[i11];
            File e10 = l.e(context);
            if (e10 == null) {
                return null;
            }
            try {
                if (!l.c(e10, resources, dVar.b())) {
                    e10.delete();
                    return null;
                } else if (!h(l10, e10.getPath(), dVar.e(), dVar.f())) {
                    return null;
                } else {
                    e10.delete();
                    i11++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                e10.delete();
            }
        }
        return i(l10);
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, @NonNull g.b[] bVarArr, int i10) {
        FileInputStream fileInputStream;
        if (bVarArr.length < 1) {
            return null;
        }
        g.b g10 = g(bVarArr, i10);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(g10.d(), StreamManagement.AckRequest.ELEMENT, cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File j10 = j(openFileDescriptor);
                if (j10 != null) {
                    if (j10.canRead()) {
                        Typeface createFromFile = Typeface.createFromFile(j10);
                        openFileDescriptor.close();
                        return createFromFile;
                    }
                }
                fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                Typeface c10 = super.c(context, fileInputStream);
                fileInputStream.close();
                openFileDescriptor.close();
                return c10;
            } catch (Throwable th2) {
                openFileDescriptor.close();
                throw th2;
            }
        } catch (IOException unused) {
            return null;
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
        throw th;
    }
}
