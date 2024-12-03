package w;

import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private static Method f18156a;

    static {
        Class<ImageWriter> cls = ImageWriter.class;
        try {
            Class cls2 = Integer.TYPE;
            f18156a = cls.getMethod(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, new Class[]{Surface.class, cls2, cls2});
        } catch (NoSuchMethodException unused) {
        }
    }

    @NonNull
    static ImageWriter a(@NonNull Surface surface, int i10, int i11) {
        Throwable th2 = null;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return (ImageWriter) h.g(f18156a.invoke((Object) null, new Object[]{surface, Integer.valueOf(i10), Integer.valueOf(i11)}));
            } catch (IllegalAccessException | InvocationTargetException e10) {
                th2 = e10;
            }
        }
        throw new RuntimeException("Unable to invoke newInstance(Surface, int, int) via reflection.", th2);
    }
}
