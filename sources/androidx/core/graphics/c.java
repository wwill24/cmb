package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.core.util.d;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<d<Rect, Rect>> f4592a = new ThreadLocal<>();

    static class a {
        static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    public static boolean a(@NonNull Paint paint, @NonNull String str) {
        return a.a(paint, str);
    }
}
