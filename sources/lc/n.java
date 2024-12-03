package lc;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

public class n {
    public static void a(Context context, Drawable drawable, int i10) {
        drawable.setColorFilter(context.getResources().getColor(i10), PorterDuff.Mode.SRC_ATOP);
    }
}
