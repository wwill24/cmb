package io.sentry.android.core.internal.gestures;

import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.view.ScrollingView;
import io.sentry.internal.gestures.UiElement;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class a implements io.sentry.internal.gestures.a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f30992a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f30993b = new int[2];

    public a(boolean z10) {
        this.f30992a = z10;
    }

    private UiElement b(View view) {
        try {
            String b10 = i.b(view);
            String canonicalName = view.getClass().getCanonicalName();
            if (canonicalName == null) {
                canonicalName = view.getClass().getSimpleName();
            }
            return new UiElement(view, canonicalName, b10, (String) null);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    private static boolean c(View view, boolean z10) {
        if (!z10) {
            return false;
        }
        return ScrollingView.class.isAssignableFrom(view.getClass());
    }

    private static boolean d(View view, boolean z10) {
        if ((c(view, z10) || AbsListView.class.isAssignableFrom(view.getClass()) || ScrollView.class.isAssignableFrom(view.getClass())) && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    private static boolean e(View view) {
        return view.isClickable() && view.getVisibility() == 0;
    }

    private boolean f(View view, float f10, float f11) {
        view.getLocationOnScreen(this.f30993b);
        int[] iArr = this.f30993b;
        int i10 = iArr[0];
        int i11 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        if (f10 < ((float) i10) || f10 > ((float) (i10 + width)) || f11 < ((float) i11) || f11 > ((float) (i11 + height))) {
            return false;
        }
        return true;
    }

    public UiElement a(Object obj, float f10, float f11, UiElement.Type type) {
        if (!(obj instanceof View)) {
            return null;
        }
        View view = (View) obj;
        if (f(view, f10, f11)) {
            if (type == UiElement.Type.CLICKABLE && e(view)) {
                return b(view);
            }
            if (type == UiElement.Type.SCROLLABLE && d(view, this.f30992a)) {
                return b(view);
            }
        }
        return null;
    }
}
