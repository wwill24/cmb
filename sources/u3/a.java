package u3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.view.d;
import androidx.core.content.res.h;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f18012a = true;

    public static Drawable a(Context context, int i10, Resources.Theme theme) {
        return c(context, context, i10, theme);
    }

    public static Drawable b(Context context, Context context2, int i10) {
        return c(context, context2, i10, (Resources.Theme) null);
    }

    private static Drawable c(Context context, Context context2, int i10, Resources.Theme theme) {
        try {
            if (f18012a) {
                return e(context2, i10, theme);
            }
        } catch (NoClassDefFoundError unused) {
            f18012a = false;
        } catch (IllegalStateException e10) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return androidx.core.content.a.getDrawable(context2, i10);
            }
            throw e10;
        } catch (Resources.NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i10, theme);
    }

    private static Drawable d(Context context, int i10, Resources.Theme theme) {
        return h.e(context.getResources(), i10, theme);
    }

    private static Drawable e(Context context, int i10, Resources.Theme theme) {
        if (theme != null) {
            context = new d(context, theme);
        }
        return e.a.b(context, i10);
    }
}
