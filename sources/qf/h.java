package qf;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import androidx.annotation.NonNull;
import v0.a;

public class h {
    public static Typeface a(@NonNull Context context, @NonNull Typeface typeface) {
        return b(context.getResources().getConfiguration(), typeface);
    }

    public static Typeface b(@NonNull Configuration configuration, @NonNull Typeface typeface) {
        int i10;
        if (Build.VERSION.SDK_INT < 31 || (i10 = configuration.fontWeightAdjustment) == Integer.MAX_VALUE || i10 == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, a.b(typeface.getWeight() + configuration.fontWeightAdjustment, 1, 1000), typeface.isItalic());
    }
}
