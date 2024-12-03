package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f1197a;

    private static class a {
        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public b(ActionBarContainer actionBarContainer) {
        this.f1197a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f1197a;
        if (actionBarContainer.f936h) {
            Drawable drawable = actionBarContainer.f935g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f933e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f1197a;
        Drawable drawable3 = actionBarContainer2.f934f;
        if (drawable3 != null && actionBarContainer2.f937j) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(@NonNull Outline outline) {
        ActionBarContainer actionBarContainer = this.f1197a;
        if (!actionBarContainer.f936h) {
            Drawable drawable = actionBarContainer.f933e;
            if (drawable != null) {
                a.a(drawable, outline);
            }
        } else if (actionBarContainer.f935g != null) {
            a.a(actionBarContainer.f933e, outline);
        }
    }

    public void setAlpha(int i10) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
