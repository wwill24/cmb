package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;

public final class c {

    private static class a {
        static Drawable a(@NonNull CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkDrawable();
        }
    }

    private static class b {
        static void a(@NonNull CheckedTextView checkedTextView, ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        static void b(@NonNull CheckedTextView checkedTextView, PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    public static Drawable a(@NonNull CheckedTextView checkedTextView) {
        return a.a(checkedTextView);
    }

    public static void b(@NonNull CheckedTextView checkedTextView, ColorStateList colorStateList) {
        b.a(checkedTextView, colorStateList);
    }

    public static void c(@NonNull CheckedTextView checkedTextView, PorterDuff.Mode mode) {
        b.b(checkedTextView, mode);
    }
}
