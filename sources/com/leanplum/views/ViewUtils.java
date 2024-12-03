package com.leanplum.views;

import android.app.Activity;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import com.leanplum.utils.SizeUtil;

public class ViewUtils {
    public static void applyBackground(@NonNull View view, int i10, boolean z10) {
        int i11;
        SizeUtil.init(view.getContext());
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        if (z10) {
            i11 = SizeUtil.dp20;
        } else {
            i11 = 0;
        }
        shapeDrawable.setShape(createRoundRect(i11));
        shapeDrawable.getPaint().setColor(i10);
        n0.w0(view, shapeDrawable);
    }

    public static Animation createFadeInAnimation(long j10) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(j10);
        return alphaAnimation;
    }

    public static Animation createFadeOutAnimation(long j10) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setDuration(j10);
        return alphaAnimation;
    }

    private static Shape createRoundRect(int i10) {
        float f10 = (float) i10;
        return new RoundRectShape(new float[]{f10, f10, f10, f10, f10, f10, f10, f10}, (RectF) null, (float[]) null);
    }

    public static int getThemeId(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024 ? 16973841 : 16973840;
    }
}
