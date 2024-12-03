package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface$Builder;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.core.content.res.e;
import androidx.core.provider.g;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import org.jivesoftware.smack.sm.packet.StreamManagement;

public class h extends f {

    /* renamed from: g  reason: collision with root package name */
    protected final Class<?> f4620g;

    /* renamed from: h  reason: collision with root package name */
    protected final Constructor<?> f4621h;

    /* renamed from: i  reason: collision with root package name */
    protected final Method f4622i;

    /* renamed from: j  reason: collision with root package name */
    protected final Method f4623j;

    /* renamed from: k  reason: collision with root package name */
    protected final Method f4624k;

    /* renamed from: l  reason: collision with root package name */
    protected final Method f4625l;

    /* renamed from: m  reason: collision with root package name */
    protected final Method f4626m;

    public h() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor<?> constructor;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> v10 = v();
            constructor = w(v10);
            method4 = s(v10);
            method3 = t(v10);
            method2 = x(v10);
            method = r(v10);
            Class<?> cls2 = v10;
            method5 = u(v10);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to collect necessary methods for class ");
            sb2.append(e10.getClass().getName());
            method5 = null;
            constructor = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f4620g = cls;
        this.f4621h = constructor;
        this.f4622i = method4;
        this.f4623j = method3;
        this.f4624k = method2;
        this.f4625l = method;
        this.f4626m = method5;
    }

    private Object l() {
        try {
            return this.f4621h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void m(Object obj) {
        try {
            this.f4625l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean n(Context context, Object obj, String str, int i10, int i11, int i12, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f4622i.invoke(obj, new Object[]{context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean o(Object obj, ByteBuffer byteBuffer, int i10, int i11, int i12) {
        try {
            return ((Boolean) this.f4623j.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i10), null, Integer.valueOf(i11), Integer.valueOf(i12)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean p(Object obj) {
        try {
            return ((Boolean) this.f4624k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean q() {
        return this.f4622i != null;
    }

    public Typeface a(Context context, e.c cVar, Resources resources, int i10) {
        if (!q()) {
            return super.a(context, cVar, resources, i10);
        }
        Object l10 = l();
        if (l10 == null) {
            return null;
        }
        for (e.d dVar : cVar.a()) {
            if (!n(context, l10, dVar.a(), dVar.c(), dVar.e(), dVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.d()))) {
                m(l10);
                return null;
            }
        }
        if (!p(l10)) {
            return null;
        }
        return i(l10);
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, @NonNull g.b[] bVarArr, int i10) {
        Typeface i11;
        ParcelFileDescriptor openFileDescriptor;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!q()) {
            g.b g10 = g(bVarArr, i10);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(g10.d(), StreamManagement.AckRequest.ELEMENT, cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface$Builder(openFileDescriptor.getFileDescriptor()).setWeight(g10.e()).setItalic(g10.f()).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            Map<Uri, ByteBuffer> h10 = l.h(context, bVarArr, cancellationSignal);
            Object l10 = l();
            if (l10 == null) {
                return null;
            }
            boolean z10 = false;
            for (g.b bVar : bVarArr) {
                ByteBuffer byteBuffer = h10.get(bVar.d());
                if (byteBuffer != null) {
                    if (!o(l10, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                        m(l10);
                        return null;
                    }
                    z10 = true;
                }
            }
            if (!z10) {
                m(l10);
                return null;
            } else if (p(l10) && (i11 = i(l10)) != null) {
                return Typeface.create(i11, i10);
            } else {
                return null;
            }
        }
        throw th;
    }

    public Typeface d(Context context, Resources resources, int i10, String str, int i11) {
        if (!q()) {
            return super.d(context, resources, i10, str, i11);
        }
        Object l10 = l();
        if (l10 == null) {
            return null;
        }
        if (!n(context, l10, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            m(l10);
            return null;
        } else if (!p(l10)) {
            return null;
        } else {
            return i(l10);
        }
    }

    /* access modifiers changed from: protected */
    public Typeface i(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f4620g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f4626m.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Method r(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method s(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class});
    }

    /* access modifiers changed from: protected */
    public Method t(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2});
    }

    /* access modifiers changed from: protected */
    public Method u(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    /* access modifiers changed from: protected */
    public Class<?> v() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    /* access modifiers changed from: protected */
    public Constructor<?> w(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method x(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }
}
