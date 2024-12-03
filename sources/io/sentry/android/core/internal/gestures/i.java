package io.sentry.android.core.internal.gestures;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.internal.gestures.UiElement;
import io.sentry.internal.gestures.a;
import io.sentry.util.l;
import java.util.Iterator;
import java.util.LinkedList;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class i {
    static UiElement a(SentryAndroidOptions sentryAndroidOptions, View view, float f10, float f11, UiElement.Type type) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        UiElement uiElement = null;
        while (linkedList.size() > 0) {
            View view2 = (View) l.c((View) linkedList.poll(), "view is required");
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    linkedList.add(viewGroup.getChildAt(i10));
                }
            }
            Iterator<a> it = sentryAndroidOptions.getGestureTargetLocators().iterator();
            while (true) {
                if (it.hasNext()) {
                    UiElement a10 = it.next().a(view2, f10, f11, type);
                    if (a10 != null) {
                        if (type != UiElement.Type.CLICKABLE) {
                            return a10;
                        }
                        uiElement = a10;
                    }
                }
            }
        }
        return uiElement;
    }

    public static String b(View view) throws Resources.NotFoundException {
        int id2 = view.getId();
        if (id2 == -1 || c(id2)) {
            throw new Resources.NotFoundException();
        }
        Resources resources = view.getContext().getResources();
        if (resources != null) {
            return resources.getResourceEntryName(id2);
        }
        return "";
    }

    private static boolean c(int i10) {
        return (-16777216 & i10) == 0 && (i10 & 16777215) != 0;
    }
}
