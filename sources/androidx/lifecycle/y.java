package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public class y extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public static final b f6069b = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private a f6070a;

    public interface a {
        void a();

        void b();

        void c();
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Activity activity, Lifecycle.Event event) {
            j.g(activity, "activity");
            j.g(event, "event");
            if (activity instanceof o) {
                ((o) activity).getLifecycle().j(event);
            } else if (activity instanceof l) {
                Lifecycle lifecycle = ((l) activity).getLifecycle();
                if (lifecycle instanceof n) {
                    ((n) lifecycle).j(event);
                }
            }
        }

        public final y b(Activity activity) {
            j.g(activity, "<this>");
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            j.e(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (y) findFragmentByTag;
        }

        public final void c(Activity activity) {
            j.g(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                c.Companion.a(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new y(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a((DefaultConstructorMarker) null);

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final void a(Activity activity) {
                j.g(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new c());
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.a(activity);
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            j.g(activity, "activity");
        }

        public void onActivityDestroyed(Activity activity) {
            j.g(activity, "activity");
        }

        public void onActivityPaused(Activity activity) {
            j.g(activity, "activity");
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            j.g(activity, "activity");
            y.f6069b.a(activity, Lifecycle.Event.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            j.g(activity, "activity");
            y.f6069b.a(activity, Lifecycle.Event.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            j.g(activity, "activity");
            y.f6069b.a(activity, Lifecycle.Event.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            j.g(activity, "activity");
            y.f6069b.a(activity, Lifecycle.Event.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            j.g(activity, "activity");
            y.f6069b.a(activity, Lifecycle.Event.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            j.g(activity, "activity");
            y.f6069b.a(activity, Lifecycle.Event.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
            j.g(activity, "activity");
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            j.g(activity, "activity");
            j.g(bundle, "bundle");
        }

        public void onActivityStarted(Activity activity) {
            j.g(activity, "activity");
        }

        public void onActivityStopped(Activity activity) {
            j.g(activity, "activity");
        }
    }

    private final void a(Lifecycle.Event event) {
        if (Build.VERSION.SDK_INT < 29) {
            b bVar = f6069b;
            Activity activity = getActivity();
            j.f(activity, "activity");
            bVar.a(activity, event);
        }
    }

    private final void b(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    private final void c(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private final void d(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    public static final void e(Activity activity) {
        f6069b.c(activity);
    }

    public final void f(a aVar) {
        this.f6070a = aVar;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f6070a);
        a(Lifecycle.Event.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        a(Lifecycle.Event.ON_DESTROY);
        this.f6070a = null;
    }

    public void onPause() {
        super.onPause();
        a(Lifecycle.Event.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        c(this.f6070a);
        a(Lifecycle.Event.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        d(this.f6070a);
        a(Lifecycle.Event.ON_START);
    }

    public void onStop() {
        super.onStop();
        a(Lifecycle.Event.ON_STOP);
    }
}
