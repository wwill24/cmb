package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.a;
import com.facebook.internal.security.CertificateUtil;

@Deprecated
public abstract class x extends a {

    /* renamed from: c  reason: collision with root package name */
    private final FragmentManager f5902c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5903d;

    /* renamed from: e  reason: collision with root package name */
    private b0 f5904e;

    /* renamed from: f  reason: collision with root package name */
    private Fragment f5905f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5906g;

    @Deprecated
    public x(@NonNull FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    private static String w(int i10, long j10) {
        return "android:switcher:" + i10 + CertificateUtil.DELIMITER + j10;
    }

    public void b(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f5904e == null) {
            this.f5904e = this.f5902c.p();
        }
        this.f5904e.m(fragment);
        if (fragment.equals(this.f5905f)) {
            this.f5905f = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void d(@NonNull ViewGroup viewGroup) {
        b0 b0Var = this.f5904e;
        if (b0Var != null) {
            if (!this.f5906g) {
                try {
                    this.f5906g = true;
                    b0Var.l();
                    this.f5906g = false;
                } catch (Throwable th2) {
                    this.f5906g = false;
                    throw th2;
                }
            }
            this.f5904e = null;
        }
    }

    @NonNull
    public Object i(@NonNull ViewGroup viewGroup, int i10) {
        if (this.f5904e == null) {
            this.f5904e = this.f5902c.p();
        }
        long v10 = v(i10);
        Fragment j02 = this.f5902c.j0(w(viewGroup.getId(), v10));
        if (j02 != null) {
            this.f5904e.h(j02);
        } else {
            j02 = u(i10);
            this.f5904e.c(viewGroup.getId(), j02, w(viewGroup.getId(), v10));
        }
        if (j02 != this.f5905f) {
            j02.setMenuVisibility(false);
            if (this.f5903d == 1) {
                this.f5904e.w(j02, Lifecycle.State.STARTED);
            } else {
                j02.setUserVisibleHint(false);
            }
        }
        return j02;
    }

    public boolean j(@NonNull View view, @NonNull Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void m(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable n() {
        return null;
    }

    public void p(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f5905f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f5903d == 1) {
                    if (this.f5904e == null) {
                        this.f5904e = this.f5902c.p();
                    }
                    this.f5904e.w(this.f5905f, Lifecycle.State.STARTED);
                } else {
                    this.f5905f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f5903d == 1) {
                if (this.f5904e == null) {
                    this.f5904e = this.f5902c.p();
                }
                this.f5904e.w(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f5905f = fragment;
        }
    }

    public void s(@NonNull ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    @NonNull
    public abstract Fragment u(int i10);

    public long v(int i10) {
        return (long) i10;
    }

    public x(@NonNull FragmentManager fragmentManager, int i10) {
        this.f5904e = null;
        this.f5905f = null;
        this.f5902c = fragmentManager;
        this.f5903d = i10;
    }
}
