package c4;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.bumptech.glide.f;
import f4.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public abstract class i<T extends View, Z> extends a<Z> {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f7952f;

    /* renamed from: g  reason: collision with root package name */
    private static int f7953g = f.glide_custom_view_target_tag;

    /* renamed from: a  reason: collision with root package name */
    protected final T f7954a;

    /* renamed from: b  reason: collision with root package name */
    private final a f7955b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnAttachStateChangeListener f7956c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7957d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7958e;

    static final class a {

        /* renamed from: e  reason: collision with root package name */
        static Integer f7959e;

        /* renamed from: a  reason: collision with root package name */
        private final View f7960a;

        /* renamed from: b  reason: collision with root package name */
        private final List<g> f7961b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        boolean f7962c;

        /* renamed from: d  reason: collision with root package name */
        private C0094a f7963d;

        /* renamed from: c4.i$a$a  reason: collision with other inner class name */
        private static final class C0094a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f7964a;

            C0094a(@NonNull a aVar) {
                this.f7964a = new WeakReference<>(aVar);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("OnGlobalLayoutListener called attachStateListener=");
                    sb2.append(this);
                }
                a aVar = this.f7964a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(@NonNull View view) {
            this.f7960a = view;
        }

        private static int c(@NonNull Context context) {
            if (f7959e == null) {
                Display defaultDisplay = ((WindowManager) j.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f7959e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f7959e.intValue();
        }

        private int e(int i10, int i11, int i12) {
            int i13 = i11 - i12;
            if (i13 > 0) {
                return i13;
            }
            if (this.f7962c && this.f7960a.isLayoutRequested()) {
                return 0;
            }
            int i14 = i10 - i12;
            if (i14 > 0) {
                return i14;
            }
            if (this.f7960a.isLayoutRequested() || i11 != -2) {
                return 0;
            }
            Log.isLoggable("ViewTarget", 4);
            return c(this.f7960a.getContext());
        }

        private int f() {
            int i10;
            int paddingTop = this.f7960a.getPaddingTop() + this.f7960a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f7960a.getLayoutParams();
            if (layoutParams != null) {
                i10 = layoutParams.height;
            } else {
                i10 = 0;
            }
            return e(this.f7960a.getHeight(), i10, paddingTop);
        }

        private int g() {
            int i10;
            int paddingLeft = this.f7960a.getPaddingLeft() + this.f7960a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f7960a.getLayoutParams();
            if (layoutParams != null) {
                i10 = layoutParams.width;
            } else {
                i10 = 0;
            }
            return e(this.f7960a.getWidth(), i10, paddingLeft);
        }

        private boolean h(int i10) {
            return i10 > 0 || i10 == Integer.MIN_VALUE;
        }

        private boolean i(int i10, int i11) {
            return h(i10) && h(i11);
        }

        private void j(int i10, int i11) {
            Iterator it = new ArrayList(this.f7961b).iterator();
            while (it.hasNext()) {
                ((g) it.next()).d(i10, i11);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.f7961b.isEmpty()) {
                int g10 = g();
                int f10 = f();
                if (i(g10, f10)) {
                    j(g10, f10);
                    b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            ViewTreeObserver viewTreeObserver = this.f7960a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f7963d);
            }
            this.f7963d = null;
            this.f7961b.clear();
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull g gVar) {
            int g10 = g();
            int f10 = f();
            if (i(g10, f10)) {
                gVar.d(g10, f10);
                return;
            }
            if (!this.f7961b.contains(gVar)) {
                this.f7961b.add(gVar);
            }
            if (this.f7963d == null) {
                ViewTreeObserver viewTreeObserver = this.f7960a.getViewTreeObserver();
                C0094a aVar = new C0094a(this);
                this.f7963d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(@NonNull g gVar) {
            this.f7961b.remove(gVar);
        }
    }

    public i(@NonNull T t10) {
        this.f7954a = (View) j.d(t10);
        this.f7955b = new a(t10);
    }

    private Object n() {
        return this.f7954a.getTag(f7953g);
    }

    private void o() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f7956c;
        if (onAttachStateChangeListener != null && !this.f7958e) {
            this.f7954a.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f7958e = true;
        }
    }

    private void p() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f7956c;
        if (onAttachStateChangeListener != null && this.f7958e) {
            this.f7954a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f7958e = false;
        }
    }

    private void q(Object obj) {
        f7952f = true;
        this.f7954a.setTag(f7953g, obj);
    }

    public b4.a a() {
        Object n10 = n();
        if (n10 == null) {
            return null;
        }
        if (n10 instanceof b4.a) {
            return (b4.a) n10;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public void c(@NonNull g gVar) {
        this.f7955b.d(gVar);
    }

    public void g(b4.a aVar) {
        q(aVar);
    }

    @NonNull
    public T getView() {
        return this.f7954a;
    }

    public void i(Drawable drawable) {
        super.i(drawable);
        o();
    }

    public void j(@NonNull g gVar) {
        this.f7955b.k(gVar);
    }

    public void k(Drawable drawable) {
        super.k(drawable);
        this.f7955b.b();
        if (!this.f7957d) {
            p();
        }
    }

    public String toString() {
        return "Target for: " + this.f7954a;
    }
}
