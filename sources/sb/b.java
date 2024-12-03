package sb;

import android.app.Activity;
import android.view.View;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import kotlin.jvm.internal.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f41915a;

    public b(Activity activity) {
        j.g(activity, "activity");
        this.f41915a = activity;
    }

    public final void a(int i10) {
        View view;
        Activity activity = this.f41915a;
        if (activity instanceof ActivityMain) {
            view = ((ActivityMain) activity).getWindow().getDecorView().findViewById(R.id.main_coordinator_layout);
            j.f(view, "{\n            activity.w…dinator_layout)\n        }");
        } else {
            view = activity.getWindow().getDecorView().findViewById(R.id.content);
            j.f(view, "{\n            activity.w…d(R.id.content)\n        }");
        }
        a.g(view, i10);
    }

    public final void b(View view, int i10) {
        j.g(view, "view");
        a.g(view, i10);
    }

    public final void c(View view, String str) {
        j.g(view, "view");
        j.g(str, "message");
        a.j(view, str);
    }

    public final void d(String str) {
        j.g(str, "message");
        View decorView = this.f41915a.getWindow().getDecorView();
        j.f(decorView, "activity.window.decorView");
        a.h(decorView, str);
    }
}
