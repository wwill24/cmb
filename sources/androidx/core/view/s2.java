package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.collection.g;

public final class s2 {

    /* renamed from: a  reason: collision with root package name */
    private final e f4896a;

    private static class a extends e {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        protected final Window f4897a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final View f4898b;

        a(@NonNull Window window, @NonNull View view) {
            this.f4897a = window;
            this.f4898b = view;
        }

        private void e(int i10) {
            if (i10 == 1) {
                f(4);
            } else if (i10 == 2) {
                f(2);
            } else if (i10 == 8) {
                ((InputMethodManager) this.f4897a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f4897a.getDecorView().getWindowToken(), 0);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    e(i11);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void f(int i10) {
            View decorView = this.f4897a.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void g(int i10) {
            this.f4897a.addFlags(i10);
        }

        /* access modifiers changed from: protected */
        public void h(int i10) {
            View decorView = this.f4897a.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void i(int i10) {
            this.f4897a.clearFlags(i10);
        }
    }

    private static class b extends a {
        b(@NonNull Window window, View view) {
            super(window, view);
        }

        public boolean b() {
            return (this.f4897a.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        public void d(boolean z10) {
            if (z10) {
                i(67108864);
                g(Integer.MIN_VALUE);
                f(8192);
                return;
            }
            h(8192);
        }
    }

    private static class c extends b {
        c(@NonNull Window window, View view) {
            super(window, view);
        }

        public void c(boolean z10) {
            if (z10) {
                i(134217728);
                g(Integer.MIN_VALUE);
                f(16);
                return;
            }
            h(16);
        }
    }

    private static class e {
        e() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i10) {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        public void c(boolean z10) {
        }

        public void d(boolean z10) {
            throw null;
        }
    }

    @Deprecated
    private s2(@NonNull WindowInsetsController windowInsetsController) {
        this.f4896a = new d(windowInsetsController, this);
    }

    @NonNull
    @Deprecated
    public static s2 e(@NonNull WindowInsetsController windowInsetsController) {
        return new s2(windowInsetsController);
    }

    public void a(int i10) {
        this.f4896a.a(i10);
    }

    public boolean b() {
        return this.f4896a.b();
    }

    public void c(boolean z10) {
        this.f4896a.c(z10);
    }

    public void d(boolean z10) {
        this.f4896a.d(z10);
    }

    private static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final s2 f4899a;

        /* renamed from: b  reason: collision with root package name */
        final WindowInsetsController f4900b;

        /* renamed from: c  reason: collision with root package name */
        private final g<Object, WindowInsetsController.OnControllableInsetsChangedListener> f4901c;

        /* renamed from: d  reason: collision with root package name */
        protected Window f4902d;

        d(@NonNull Window window, @NonNull s2 s2Var) {
            this(window.getInsetsController(), s2Var);
            this.f4902d = window;
        }

        /* access modifiers changed from: package-private */
        public void a(int i10) {
            this.f4900b.hide(i10);
        }

        public boolean b() {
            return (this.f4900b.getSystemBarsAppearance() & 8) != 0;
        }

        public void c(boolean z10) {
            if (z10) {
                if (this.f4902d != null) {
                    e(16);
                }
                this.f4900b.setSystemBarsAppearance(16, 16);
                return;
            }
            if (this.f4902d != null) {
                f(16);
            }
            this.f4900b.setSystemBarsAppearance(0, 16);
        }

        public void d(boolean z10) {
            if (z10) {
                if (this.f4902d != null) {
                    e(8192);
                }
                this.f4900b.setSystemBarsAppearance(8, 8);
                return;
            }
            if (this.f4902d != null) {
                f(8192);
            }
            this.f4900b.setSystemBarsAppearance(0, 8);
        }

        /* access modifiers changed from: protected */
        public void e(int i10) {
            View decorView = this.f4902d.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void f(int i10) {
            View decorView = this.f4902d.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        d(@NonNull WindowInsetsController windowInsetsController, @NonNull s2 s2Var) {
            this.f4901c = new g<>();
            this.f4900b = windowInsetsController;
            this.f4899a = s2Var;
        }
    }

    public s2(@NonNull Window window, @NonNull View view) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f4896a = new d(window, this);
        } else if (i10 >= 26) {
            this.f4896a = new c(window, view);
        } else {
            this.f4896a = new b(window, view);
        }
    }
}
