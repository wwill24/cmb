package e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.w0;

@SuppressLint({"RestrictedAPI"})
public final class a {
    public static ColorStateList a(@NonNull Context context, int i10) {
        return androidx.core.content.a.getColorStateList(context, i10);
    }

    public static Drawable b(@NonNull Context context, int i10) {
        return w0.g().i(context, i10);
    }
}
