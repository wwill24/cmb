package xh;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewAnimationUtils;
import kotlin.jvm.internal.j;

public final class f {
    public static final /* synthetic */ void b(View view, long j10) {
        j.g(view, "<this>");
        view.setVisibility(4);
        view.post(new e(view, j10));
    }

    /* access modifiers changed from: private */
    public static final void c(View view, long j10) {
        j.g(view, "$this_circularRevealed");
        if (view.isAttachedToWindow()) {
            view.setVisibility(0);
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, (view.getLeft() + view.getRight()) / 2, (view.getTop() + view.getBottom()) / 2, 0.0f, (float) Math.max(view.getWidth(), view.getHeight()));
            createCircularReveal.setDuration(j10);
            createCircularReveal.start();
        }
    }

    public static final /* synthetic */ int d(View view, boolean z10) {
        j.g(view, "<this>");
        Rect rect = new Rect();
        Context context = view.getContext();
        if (!(context instanceof Activity) || !z10) {
            return 0;
        }
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static final /* synthetic */ Point e(View view) {
        j.g(view, "<this>");
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return new Point(iArr[0], iArr[1]);
    }

    public static final /* synthetic */ void f(View view, boolean z10) {
        j.g(view, "<this>");
        view.setVisibility(z10 ? 0 : 8);
    }
}
