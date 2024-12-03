package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.y;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class ProcessLifecycleOwner implements l {

    /* renamed from: j  reason: collision with root package name */
    public static final b f5952j = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final ProcessLifecycleOwner f5953k = new ProcessLifecycleOwner();

    /* renamed from: a  reason: collision with root package name */
    private int f5954a;

    /* renamed from: b  reason: collision with root package name */
    private int f5955b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5956c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5957d = true;

    /* renamed from: e  reason: collision with root package name */
    private Handler f5958e;

    /* renamed from: f  reason: collision with root package name */
    private final n f5959f = new n(this);

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f5960g = new w(this);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final y.a f5961h = new d(this);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f5962a = new a();

        private a() {
        }

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            j.g(activity, "activity");
            j.g(activityLifecycleCallbacks, "callback");
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final l a() {
            return ProcessLifecycleOwner.f5953k;
        }

        public final void b(Context context) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            ProcessLifecycleOwner.f5953k.h(context);
        }
    }

    public static final class c extends d {
        final /* synthetic */ ProcessLifecycleOwner this$0;

        public static final class a extends d {
            final /* synthetic */ ProcessLifecycleOwner this$0;

            a(ProcessLifecycleOwner processLifecycleOwner) {
                this.this$0 = processLifecycleOwner;
            }

            public void onActivityPostResumed(Activity activity) {
                j.g(activity, "activity");
                this.this$0.e();
            }

            public void onActivityPostStarted(Activity activity) {
                j.g(activity, "activity");
                this.this$0.f();
            }
        }

        c(ProcessLifecycleOwner processLifecycleOwner) {
            this.this$0 = processLifecycleOwner;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            j.g(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                y.f6069b.b(activity).f(this.this$0.f5961h);
            }
        }

        public void onActivityPaused(Activity activity) {
            j.g(activity, "activity");
            this.this$0.d();
        }

        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            j.g(activity, "activity");
            a.a(activity, new a(this.this$0));
        }

        public void onActivityStopped(Activity activity) {
            j.g(activity, "activity");
            this.this$0.g();
        }
    }

    public static final class d implements y.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProcessLifecycleOwner f5963a;

        d(ProcessLifecycleOwner processLifecycleOwner) {
            this.f5963a = processLifecycleOwner;
        }

        public void a() {
            this.f5963a.e();
        }

        public void b() {
            this.f5963a.f();
        }

        public void c() {
        }
    }

    private ProcessLifecycleOwner() {
    }

    /* access modifiers changed from: private */
    public static final void i(ProcessLifecycleOwner processLifecycleOwner) {
        j.g(processLifecycleOwner, "this$0");
        processLifecycleOwner.j();
        processLifecycleOwner.k();
    }

    public static final l l() {
        return f5952j.a();
    }

    public final void d() {
        int i10 = this.f5955b - 1;
        this.f5955b = i10;
        if (i10 == 0) {
            Handler handler = this.f5958e;
            j.d(handler);
            handler.postDelayed(this.f5960g, 700);
        }
    }

    public final void e() {
        int i10 = this.f5955b + 1;
        this.f5955b = i10;
        if (i10 != 1) {
            return;
        }
        if (this.f5956c) {
            this.f5959f.j(Lifecycle.Event.ON_RESUME);
            this.f5956c = false;
            return;
        }
        Handler handler = this.f5958e;
        j.d(handler);
        handler.removeCallbacks(this.f5960g);
    }

    public final void f() {
        int i10 = this.f5954a + 1;
        this.f5954a = i10;
        if (i10 == 1 && this.f5957d) {
            this.f5959f.j(Lifecycle.Event.ON_START);
            this.f5957d = false;
        }
    }

    public final void g() {
        this.f5954a--;
        k();
    }

    public Lifecycle getLifecycle() {
        return this.f5959f;
    }

    public final void h(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f5958e = new Handler();
        this.f5959f.j(Lifecycle.Event.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        j.e(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c(this));
    }

    public final void j() {
        if (this.f5955b == 0) {
            this.f5956c = true;
            this.f5959f.j(Lifecycle.Event.ON_PAUSE);
        }
    }

    public final void k() {
        if (this.f5954a == 0 && this.f5956c) {
            this.f5959f.j(Lifecycle.Event.ON_STOP);
            this.f5957d = true;
        }
    }
}
