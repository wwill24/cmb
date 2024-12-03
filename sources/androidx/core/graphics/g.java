package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.core.content.res.e;
import androidx.core.provider.g;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

class g extends k {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f4616b;

    /* renamed from: c  reason: collision with root package name */
    private static final Constructor<?> f4617c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f4618d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f4619e;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class cls2 = Integer.TYPE;
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            cls = null;
            method2 = null;
            method = null;
        }
        f4617c = constructor;
        f4616b = cls;
        f4618d = method;
        f4619e = method2;
    }

    g() {
    }

    private static boolean h(Object obj, ByteBuffer byteBuffer, int i10, int i11, boolean z10) {
        try {
            return ((Boolean) f4618d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i10), null, Integer.valueOf(i11), Boolean.valueOf(z10)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface i(Object obj) {
        try {
            Object newInstance = Array.newInstance(f4616b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f4619e.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean j() {
        return f4618d != null;
    }

    private static Object k() {
        try {
            return f4617c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Typeface a(Context context, e.c cVar, Resources resources, int i10) {
        Object k10 = k();
        if (k10 == null) {
            return null;
        }
        for (e.d dVar : cVar.a()) {
            ByteBuffer b10 = l.b(context, resources, dVar.b());
            if (b10 == null || !h(k10, b10, dVar.c(), dVar.e(), dVar.f())) {
                return null;
            }
        }
        return i(k10);
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, @NonNull g.b[] bVarArr, int i10) {
        Object k10 = k();
        if (k10 == null) {
            return null;
        }
        androidx.collection.g gVar = new androidx.collection.g();
        for (g.b bVar : bVarArr) {
            Uri d10 = bVar.d();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(d10);
            if (byteBuffer == null) {
                byteBuffer = l.f(context, cancellationSignal, d10);
                gVar.put(d10, byteBuffer);
            }
            if (byteBuffer == null || !h(k10, byteBuffer, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface i11 = i(k10);
        if (i11 == null) {
            return null;
        }
        return Typeface.create(i11, i10);
    }
}
