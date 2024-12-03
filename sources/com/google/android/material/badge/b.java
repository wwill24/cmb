package com.google.android.material.badge;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f19167a = false;

    public static void a(@NonNull a aVar, @NonNull View view, FrameLayout frameLayout) {
        c(aVar, view, frameLayout);
        if (aVar.g() != null) {
            aVar.g().setForeground(aVar);
        } else if (!f19167a) {
            view.getOverlay().add(aVar);
        } else {
            throw new IllegalArgumentException("Trying to reference null customBadgeParent");
        }
    }

    public static void b(a aVar, @NonNull View view) {
        if (aVar != null) {
            if (f19167a || aVar.g() != null) {
                aVar.g().setForeground((Drawable) null);
            } else {
                view.getOverlay().remove(aVar);
            }
        }
    }

    public static void c(@NonNull a aVar, @NonNull View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        aVar.setBounds(rect);
        aVar.y(view, frameLayout);
    }

    public static void d(@NonNull Rect rect, float f10, float f11, float f12, float f13) {
        rect.set((int) (f10 - f12), (int) (f11 - f13), (int) (f10 + f12), (int) (f11 + f13));
    }
}
