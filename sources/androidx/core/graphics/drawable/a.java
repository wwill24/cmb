package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a {

    /* renamed from: androidx.core.graphics.drawable.a$a  reason: collision with other inner class name */
    static class C0037a {
        static int a(Drawable drawable) {
            return drawable.getAlpha();
        }

        static Drawable b(DrawableContainer.DrawableContainerState drawableContainerState, int i10) {
            return drawableContainerState.getChild(i10);
        }

        static Drawable c(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }

        static boolean d(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        static void e(Drawable drawable, boolean z10) {
            drawable.setAutoMirrored(z10);
        }
    }

    static class b {
        static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        static void e(Drawable drawable, float f10, float f11) {
            drawable.setHotspot(f10, f11);
        }

        static void f(Drawable drawable, int i10, int i11, int i12, int i13) {
            drawable.setHotspotBounds(i10, i11, i12, i13);
        }

        static void g(Drawable drawable, int i10) {
            drawable.setTint(i10);
        }

        static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    static class c {
        static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        static boolean b(Drawable drawable, int i10) {
            return drawable.setLayoutDirection(i10);
        }
    }

    public static void a(@NonNull Drawable drawable, @NonNull Resources.Theme theme) {
        b.a(drawable, theme);
    }

    public static boolean b(@NonNull Drawable drawable) {
        return b.b(drawable);
    }

    public static void c(@NonNull Drawable drawable) {
        drawable.clearColorFilter();
    }

    public static int d(@NonNull Drawable drawable) {
        return C0037a.a(drawable);
    }

    public static ColorFilter e(@NonNull Drawable drawable) {
        return b.c(drawable);
    }

    public static int f(@NonNull Drawable drawable) {
        return c.a(drawable);
    }

    public static void g(@NonNull Drawable drawable, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        b.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean h(@NonNull Drawable drawable) {
        return C0037a.d(drawable);
    }

    @Deprecated
    public static void i(@NonNull Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(@NonNull Drawable drawable, boolean z10) {
        C0037a.e(drawable, z10);
    }

    public static void k(@NonNull Drawable drawable, float f10, float f11) {
        b.e(drawable, f10, f11);
    }

    public static void l(@NonNull Drawable drawable, int i10, int i11, int i12, int i13) {
        b.f(drawable, i10, i11, i12, i13);
    }

    public static boolean m(@NonNull Drawable drawable, int i10) {
        return c.b(drawable, i10);
    }

    public static void n(@NonNull Drawable drawable, int i10) {
        b.g(drawable, i10);
    }

    public static void o(@NonNull Drawable drawable, ColorStateList colorStateList) {
        b.h(drawable, colorStateList);
    }

    public static void p(@NonNull Drawable drawable, PorterDuff.Mode mode) {
        b.i(drawable, mode);
    }

    public static <T extends Drawable> T q(@NonNull Drawable drawable) {
        if (drawable instanceof h) {
            return ((h) drawable).a();
        }
        return drawable;
    }

    @NonNull
    public static Drawable r(@NonNull Drawable drawable) {
        return drawable;
    }
}
