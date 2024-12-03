package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Button;
import com.clevertap.android.sdk.inapp.a;

public abstract class d extends b {
    /* access modifiers changed from: package-private */
    public int U0() {
        WindowManager windowManager = (WindowManager) this.f10383c.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return this.f10383c.getResources().getConfiguration().densityDpi;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    /* access modifiers changed from: package-private */
    public void V0(Button button, CTInAppNotificationButton cTInAppNotificationButton, int i10) {
        ShapeDrawable shapeDrawable;
        Button button2 = button;
        if (cTInAppNotificationButton != null) {
            button2.setVisibility(0);
            button2.setTag(Integer.valueOf(i10));
            button2.setText(cTInAppNotificationButton.g());
            button2.setTextColor(Color.parseColor(cTInAppNotificationButton.h()));
            button2.setOnClickListener(new a.C0118a());
            ShapeDrawable shapeDrawable2 = null;
            if (!cTInAppNotificationButton.e().isEmpty()) {
                float parseFloat = Float.parseFloat(cTInAppNotificationButton.e()) * (480.0f / ((float) U0())) * 2.0f;
                shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{parseFloat, parseFloat, parseFloat, parseFloat, parseFloat, parseFloat, parseFloat, parseFloat}, (RectF) null, new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
                shapeDrawable.getPaint().setColor(Color.parseColor(cTInAppNotificationButton.c()));
                shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
                shapeDrawable.getPaint().setAntiAlias(true);
                shapeDrawable2 = new ShapeDrawable(new RoundRectShape(new float[]{parseFloat, parseFloat, parseFloat, parseFloat, parseFloat, parseFloat, parseFloat, parseFloat}, (RectF) null, new float[]{parseFloat, parseFloat, parseFloat, parseFloat, parseFloat, parseFloat, parseFloat, parseFloat}));
            } else {
                shapeDrawable = null;
            }
            if (!cTInAppNotificationButton.d().isEmpty() && shapeDrawable2 != null) {
                shapeDrawable2.getPaint().setColor(Color.parseColor(cTInAppNotificationButton.d()));
                shapeDrawable2.setPadding(1, 1, 1, 1);
                shapeDrawable2.getPaint().setStyle(Paint.Style.FILL);
            }
            if (shapeDrawable != null) {
                button2.setBackground(new LayerDrawable(new Drawable[]{shapeDrawable2, shapeDrawable}));
                return;
            }
            return;
        }
        button2.setVisibility(8);
    }
}
