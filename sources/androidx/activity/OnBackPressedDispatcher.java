package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i;
import androidx.lifecycle.l;
import java.util.Collection;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f322a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final g<l> f323b = new g<>();

    /* renamed from: c  reason: collision with root package name */
    private Function0<Unit> f324c;

    /* renamed from: d  reason: collision with root package name */
    private OnBackInvokedCallback f325d;

    /* renamed from: e  reason: collision with root package name */
    private OnBackInvokedDispatcher f326e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f327f;

    private final class LifecycleOnBackPressedCancellable implements i, a {

        /* renamed from: a  reason: collision with root package name */
        private final Lifecycle f328a;

        /* renamed from: b  reason: collision with root package name */
        private final l f329b;

        /* renamed from: c  reason: collision with root package name */
        private a f330c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f331d;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, l lVar) {
            j.g(lifecycle, "lifecycle");
            j.g(lVar, "onBackPressedCallback");
            this.f331d = onBackPressedDispatcher;
            this.f328a = lifecycle;
            this.f329b = lVar;
            lifecycle.a(this);
        }

        public void cancel() {
            this.f328a.d(this);
            this.f329b.e(this);
            a aVar = this.f330c;
            if (aVar != null) {
                aVar.cancel();
            }
            this.f330c = null;
        }

        public void e(l lVar, Lifecycle.Event event) {
            j.g(lVar, "source");
            j.g(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.f330c = this.f331d.c(this.f329b);
            } else if (event == Lifecycle.Event.ON_STOP) {
                a aVar = this.f330c;
                if (aVar != null) {
                    aVar.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f332a = new a();

        private a() {
        }

        /* access modifiers changed from: private */
        public static final void c(Function0 function0) {
            j.g(function0, "$onBackInvoked");
            function0.invoke();
        }

        public final OnBackInvokedCallback b(Function0<Unit> function0) {
            j.g(function0, "onBackInvoked");
            return new m(function0);
        }

        public final void d(Object obj, int i10, Object obj2) {
            j.g(obj, "dispatcher");
            j.g(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i10, (OnBackInvokedCallback) obj2);
        }

        public final void e(Object obj, Object obj2) {
            j.g(obj, "dispatcher");
            j.g(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final l f333a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f334b;

        public b(OnBackPressedDispatcher onBackPressedDispatcher, l lVar) {
            j.g(lVar, "onBackPressedCallback");
            this.f334b = onBackPressedDispatcher;
            this.f333a = lVar;
        }

        public void cancel() {
            this.f334b.f323b.remove(this.f333a);
            this.f333a.e(this);
            if (Build.VERSION.SDK_INT >= 33) {
                this.f333a.g((Function0<Unit>) null);
                this.f334b.g();
            }
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f322a = runnable;
        if (Build.VERSION.SDK_INT >= 33) {
            this.f324c = new Function0<Unit>(this) {
                final /* synthetic */ OnBackPressedDispatcher this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.g();
                }
            };
            this.f325d = a.f332a.b(new Function0<Unit>(this) {
                final /* synthetic */ OnBackPressedDispatcher this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.e();
                }
            });
        }
    }

    public final void b(l lVar, l lVar2) {
        j.g(lVar, "owner");
        j.g(lVar2, "onBackPressedCallback");
        Lifecycle lifecycle = lVar.getLifecycle();
        if (lifecycle.b() != Lifecycle.State.DESTROYED) {
            lVar2.a(new LifecycleOnBackPressedCancellable(this, lifecycle, lVar2));
            if (Build.VERSION.SDK_INT >= 33) {
                g();
                lVar2.g(this.f324c);
            }
        }
    }

    public final a c(l lVar) {
        j.g(lVar, "onBackPressedCallback");
        this.f323b.add(lVar);
        b bVar = new b(this, lVar);
        lVar.a(bVar);
        if (Build.VERSION.SDK_INT >= 33) {
            g();
            lVar.g(this.f324c);
        }
        return bVar;
    }

    public final boolean d() {
        g<l> gVar = this.f323b;
        if ((gVar instanceof Collection) && gVar.isEmpty()) {
            return false;
        }
        for (l c10 : gVar) {
            if (c10.c()) {
                return true;
            }
        }
        return false;
    }

    public final void e() {
        l lVar;
        g<l> gVar = this.f323b;
        ListIterator<l> listIterator = gVar.listIterator(gVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                lVar = null;
                break;
            }
            lVar = listIterator.previous();
            if (lVar.c()) {
                break;
            }
        }
        l lVar2 = lVar;
        if (lVar2 != null) {
            lVar2.b();
            return;
        }
        Runnable runnable = this.f322a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void f(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        j.g(onBackInvokedDispatcher, "invoker");
        this.f326e = onBackInvokedDispatcher;
        g();
    }

    public final void g() {
        boolean d10 = d();
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f326e;
        OnBackInvokedCallback onBackInvokedCallback = this.f325d;
        if (onBackInvokedDispatcher != null && onBackInvokedCallback != null) {
            if (d10 && !this.f327f) {
                a.f332a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
                this.f327f = true;
            } else if (!d10 && this.f327f) {
                a.f332a.e(onBackInvokedDispatcher, onBackInvokedCallback);
                this.f327f = false;
            }
        }
    }
}
