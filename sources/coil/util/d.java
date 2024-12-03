package coil.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.h;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.l;
import e.a;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0000\u001a$\u0010\b\u001a\u00020\u0003*\u00020\u00052\b\b\u0001\u0010\u0002\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0018\u00010\u0006R\u00020\u0005H\u0000\u001a\u001e\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b*\u0004\u0018\u00010\u0000H\u0000\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0000¨\u0006\u0011"}, d2 = {"Landroid/content/Context;", "", "resId", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/content/res/Resources;", "Landroid/content/res/Resources$Theme;", "theme", "b", "resources", "d", "Landroidx/lifecycle/Lifecycle;", "c", "", "permission", "", "e", "coil-base_release"}, k = 2, mv = {1, 7, 1})
public final class d {
    public static final Drawable a(Context context, int i10) {
        Drawable b10 = a.b(context, i10);
        if (b10 != null) {
            return b10;
        }
        throw new IllegalStateException(("Invalid resource ID: " + i10).toString());
    }

    public static final Drawable b(Resources resources, int i10, Resources.Theme theme) {
        Drawable e10 = h.e(resources, i10, theme);
        if (e10 != null) {
            return e10;
        }
        throw new IllegalStateException(("Invalid resource ID: " + i10).toString());
    }

    public static final Lifecycle c(Context context) {
        while (!(context instanceof l)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return ((l) context).getLifecycle();
    }

    public static final Drawable d(Context context, Resources resources, int i10) {
        XmlResourceParser xml = resources.getXml(i10);
        int next = xml.next();
        while (next != 2 && next != 1) {
            next = xml.next();
        }
        if (next == 2) {
            return b(resources, i10, context.getTheme());
        }
        throw new XmlPullParserException("No start tag found.");
    }

    public static final boolean e(Context context, String str) {
        return androidx.core.content.a.checkSelfPermission(context, str) == 0;
    }
}
