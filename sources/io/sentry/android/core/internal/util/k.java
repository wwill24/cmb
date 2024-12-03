package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import io.sentry.SentryLevel;
import io.sentry.android.core.i0;
import io.sentry.h0;
import java.io.ByteArrayOutputStream;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class k {
    @SuppressLint({"NewApi"})
    private static boolean a(Activity activity, i0 i0Var) {
        if (i0Var.d() < 17) {
            return !activity.isFinishing();
        }
        if (activity.isFinishing() || activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    public static byte[] b(Activity activity, h0 h0Var, i0 i0Var) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (!a(activity, i0Var) || activity.getWindow() == null || activity.getWindow().getDecorView() == null || activity.getWindow().getDecorView().getRootView() == null) {
            h0Var.c(SentryLevel.DEBUG, "Activity isn't valid, not taking screenshot.", new Object[0]);
            return null;
        }
        View rootView = activity.getWindow().getDecorView().getRootView();
        if (rootView.getWidth() <= 0 || rootView.getHeight() <= 0) {
            h0Var.c(SentryLevel.DEBUG, "View's width and height is zeroed, not taking screenshot.", new Object[0]);
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            Bitmap createBitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.ARGB_8888);
            rootView.draw(new Canvas(createBitmap));
            createBitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            if (byteArrayOutputStream.size() <= 0) {
                h0Var.c(SentryLevel.DEBUG, "Screenshot is 0 bytes, not attaching the image.", new Object[0]);
                byteArrayOutputStream.close();
                return null;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            h0Var.b(SentryLevel.ERROR, "Taking screenshot failed.", th2);
            return null;
        }
        throw th;
    }
}
