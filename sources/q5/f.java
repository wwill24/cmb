package q5;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, Typeface> f17170a = new HashMap<>();

    public static Typeface b(Context context, int i10) {
        return c(context, context.getString(i10));
    }

    public static Typeface c(Context context, String str) {
        if (f17170a.containsKey(str)) {
            return f17170a.get(str);
        }
        try {
            AssetManager assets = context.getAssets();
            Typeface createFromAsset = Typeface.createFromAsset(assets, "fonts/" + str);
            f17170a.put(str, createFromAsset);
            return createFromAsset;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean d(float f10, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setAlpha(f10);
            return false;
        } else if (action != 1 && action != 3) {
            return false;
        } else {
            view.setAlpha(1.0f);
            return false;
        }
    }

    public static void e(View view) {
        f(view, 0.5f);
    }

    public static void f(View view, float f10) {
        if (view != null) {
            view.setOnTouchListener(new e(f10));
        }
    }

    public static void g(View... viewArr) {
        for (View e10 : viewArr) {
            e(e10);
        }
    }
}
