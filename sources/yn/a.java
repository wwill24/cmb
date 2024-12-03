package yn;

import android.annotation.TargetApi;
import android.view.View;

public class a {
    public static int a(int i10) {
        return b(i10);
    }

    @TargetApi(11)
    private static int b(int i10) {
        return (i10 & 65280) >> 8;
    }

    public static void c(View view, Runnable runnable) {
        d(view, runnable);
    }

    @TargetApi(16)
    private static void d(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
