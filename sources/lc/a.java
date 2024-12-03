package lc;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import j1.b;

public class a {
    public static void a(View view) {
        view.animate().setInterpolator(new b()).setDuration(200).scaleX(1.0f).scaleY(1.0f).start();
    }

    public static void b(View view, float f10) {
        view.animate().setInterpolator(new b()).setDuration(200).scaleX(f10).scaleY(f10).start();
    }

    public static void c(Activity activity, Intent intent) {
        activity.startActivity(intent);
    }

    public static void d(Activity activity, Intent intent, int i10) {
        activity.startActivityForResult(intent, i10);
    }

    public static void e(Fragment fragment, Intent intent, int i10) {
        if (fragment.getActivity() != null) {
            fragment.startActivityForResult(intent, i10);
        }
    }
}
