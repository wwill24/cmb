package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final androidx.collection.a<String, Method> f7155a;

    /* renamed from: b  reason: collision with root package name */
    protected final androidx.collection.a<String, Method> f7156b;

    /* renamed from: c  reason: collision with root package name */
    protected final androidx.collection.a<String, Class> f7157c;

    public a(androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        this.f7155a = aVar;
        this.f7156b = aVar2;
        this.f7157c = aVar3;
    }

    private void N(y1.a aVar) {
        try {
            I(c(aVar.getClass()).getName());
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(aVar.getClass().getSimpleName() + " does not have a Parcelizer", e10);
        }
    }

    private Class c(Class<? extends y1.a> cls) throws ClassNotFoundException {
        Class cls2 = this.f7157c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.f7157c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Class<a> cls = a.class;
        Method method = this.f7155a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        this.f7155a.put(str, declaredMethod);
        return declaredMethod;
    }

    private Method e(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f7156b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class c10 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c10.getDeclaredMethod("write", new Class[]{cls, a.class});
        this.f7156b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* access modifiers changed from: protected */
    public abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i10) {
        w(i10);
        A(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i10) {
        w(i10);
        C(charSequence);
    }

    /* access modifiers changed from: protected */
    public abstract void E(int i10);

    public void F(int i10, int i11) {
        w(i11);
        E(i10);
    }

    /* access modifiers changed from: protected */
    public abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i10) {
        w(i10);
        G(parcelable);
    }

    /* access modifiers changed from: protected */
    public abstract void I(String str);

    public void J(String str, int i10) {
        w(i10);
        I(str);
    }

    /* access modifiers changed from: protected */
    public <T extends y1.a> void K(T t10, a aVar) {
        try {
            e(t10.getClass()).invoke((Object) null, new Object[]{t10, aVar});
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e10);
        } catch (InvocationTargetException e11) {
            if (e11.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e11.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (ClassNotFoundException e13) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e13);
        }
    }

    /* access modifiers changed from: protected */
    public void L(y1.a aVar) {
        if (aVar == null) {
            I((String) null);
            return;
        }
        N(aVar);
        a b10 = b();
        K(aVar, b10);
        b10.a();
    }

    public void M(y1.a aVar, int i10) {
        w(i10);
        L(aVar);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract a b();

    public boolean f() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean g();

    public boolean h(boolean z10, int i10) {
        if (!m(i10)) {
            return z10;
        }
        return g();
    }

    /* access modifiers changed from: protected */
    public abstract byte[] i();

    public byte[] j(byte[] bArr, int i10) {
        if (!m(i10)) {
            return bArr;
        }
        return i();
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i10) {
        if (!m(i10)) {
            return charSequence;
        }
        return k();
    }

    /* access modifiers changed from: protected */
    public abstract boolean m(int i10);

    /* access modifiers changed from: protected */
    public <T extends y1.a> T n(String str, a aVar) {
        try {
            return (y1.a) d(str).invoke((Object) null, new Object[]{aVar});
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e10);
        } catch (InvocationTargetException e11) {
            if (e11.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e11.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (ClassNotFoundException e13) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e13);
        }
    }

    /* access modifiers changed from: protected */
    public abstract int o();

    public int p(int i10, int i11) {
        if (!m(i11)) {
            return i10;
        }
        return o();
    }

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t10, int i10) {
        if (!m(i10)) {
            return t10;
        }
        return q();
    }

    /* access modifiers changed from: protected */
    public abstract String s();

    public String t(String str, int i10) {
        if (!m(i10)) {
            return str;
        }
        return s();
    }

    /* access modifiers changed from: protected */
    public <T extends y1.a> T u() {
        String s10 = s();
        if (s10 == null) {
            return null;
        }
        return n(s10, b());
    }

    public <T extends y1.a> T v(T t10, int i10) {
        if (!m(i10)) {
            return t10;
        }
        return u();
    }

    /* access modifiers changed from: protected */
    public abstract void w(int i10);

    public void x(boolean z10, boolean z11) {
    }

    /* access modifiers changed from: protected */
    public abstract void y(boolean z10);

    public void z(boolean z10, int i10) {
        w(i10);
        y(z10);
    }
}
