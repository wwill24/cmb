package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class b0 {

    /* renamed from: a  reason: collision with root package name */
    private final l f5782a;

    /* renamed from: b  reason: collision with root package name */
    private final ClassLoader f5783b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<a> f5784c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    int f5785d;

    /* renamed from: e  reason: collision with root package name */
    int f5786e;

    /* renamed from: f  reason: collision with root package name */
    int f5787f;

    /* renamed from: g  reason: collision with root package name */
    int f5788g;

    /* renamed from: h  reason: collision with root package name */
    int f5789h;

    /* renamed from: i  reason: collision with root package name */
    boolean f5790i;

    /* renamed from: j  reason: collision with root package name */
    boolean f5791j = true;

    /* renamed from: k  reason: collision with root package name */
    String f5792k;

    /* renamed from: l  reason: collision with root package name */
    int f5793l;

    /* renamed from: m  reason: collision with root package name */
    CharSequence f5794m;

    /* renamed from: n  reason: collision with root package name */
    int f5795n;

    /* renamed from: o  reason: collision with root package name */
    CharSequence f5796o;

    /* renamed from: p  reason: collision with root package name */
    ArrayList<String> f5797p;

    /* renamed from: q  reason: collision with root package name */
    ArrayList<String> f5798q;

    /* renamed from: r  reason: collision with root package name */
    boolean f5799r = false;

    /* renamed from: s  reason: collision with root package name */
    ArrayList<Runnable> f5800s;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f5801a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f5802b;

        /* renamed from: c  reason: collision with root package name */
        boolean f5803c;

        /* renamed from: d  reason: collision with root package name */
        int f5804d;

        /* renamed from: e  reason: collision with root package name */
        int f5805e;

        /* renamed from: f  reason: collision with root package name */
        int f5806f;

        /* renamed from: g  reason: collision with root package name */
        int f5807g;

        /* renamed from: h  reason: collision with root package name */
        Lifecycle.State f5808h;

        /* renamed from: i  reason: collision with root package name */
        Lifecycle.State f5809i;

        a() {
        }

        a(int i10, Fragment fragment) {
            this.f5801a = i10;
            this.f5802b = fragment;
            this.f5803c = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f5808h = state;
            this.f5809i = state;
        }

        a(int i10, Fragment fragment, boolean z10) {
            this.f5801a = i10;
            this.f5802b = fragment;
            this.f5803c = z10;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f5808h = state;
            this.f5809i = state;
        }

        a(int i10, @NonNull Fragment fragment, Lifecycle.State state) {
            this.f5801a = i10;
            this.f5802b = fragment;
            this.f5803c = false;
            this.f5808h = fragment.mMaxState;
            this.f5809i = state;
        }
    }

    b0(@NonNull l lVar, ClassLoader classLoader) {
        this.f5782a = lVar;
        this.f5783b = classLoader;
    }

    @NonNull
    public b0 b(int i10, @NonNull Fragment fragment) {
        o(i10, fragment, (String) null, 1);
        return this;
    }

    @NonNull
    public b0 c(int i10, @NonNull Fragment fragment, String str) {
        o(i10, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public b0 d(@NonNull ViewGroup viewGroup, @NonNull Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    @NonNull
    public b0 e(@NonNull Fragment fragment, String str) {
        o(0, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void f(a aVar) {
        this.f5784c.add(aVar);
        aVar.f5804d = this.f5785d;
        aVar.f5805e = this.f5786e;
        aVar.f5806f = this.f5787f;
        aVar.f5807g = this.f5788g;
    }

    @NonNull
    public b0 g(String str) {
        if (this.f5791j) {
            this.f5790i = true;
            this.f5792k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    @NonNull
    public b0 h(@NonNull Fragment fragment) {
        f(new a(7, fragment));
        return this;
    }

    public abstract int i();

    public abstract int j();

    public abstract void k();

    public abstract void l();

    @NonNull
    public b0 m(@NonNull Fragment fragment) {
        f(new a(6, fragment));
        return this;
    }

    @NonNull
    public b0 n() {
        if (!this.f5790i) {
            this.f5791j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    /* access modifiers changed from: package-private */
    public void o(int i10, Fragment fragment, String str, int i11) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.h(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 == null || str.equals(str3)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i10 != 0) {
            if (i10 != -1) {
                int i12 = fragment.mFragmentId;
                if (i12 == 0 || i12 == i10) {
                    fragment.mFragmentId = i10;
                    fragment.mContainerId = i10;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i10);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        f(new a(i11, fragment));
    }

    @NonNull
    public b0 p(@NonNull Fragment fragment) {
        f(new a(4, fragment));
        return this;
    }

    public abstract boolean q();

    @NonNull
    public b0 r(@NonNull Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    @NonNull
    public b0 s(int i10, @NonNull Fragment fragment) {
        return t(i10, fragment, (String) null);
    }

    @NonNull
    public b0 t(int i10, @NonNull Fragment fragment, String str) {
        if (i10 != 0) {
            o(i10, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    @NonNull
    public b0 u(int i10, int i11) {
        return v(i10, i11, 0, 0);
    }

    @NonNull
    public b0 v(int i10, int i11, int i12, int i13) {
        this.f5785d = i10;
        this.f5786e = i11;
        this.f5787f = i12;
        this.f5788g = i13;
        return this;
    }

    @NonNull
    public b0 w(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        f(new a(10, fragment, state));
        return this;
    }

    @NonNull
    public b0 x(boolean z10) {
        this.f5799r = z10;
        return this;
    }

    @NonNull
    public b0 y(@NonNull Fragment fragment) {
        f(new a(5, fragment));
        return this;
    }
}
