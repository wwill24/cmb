package com.leanplum.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.leanplum.internal.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class BitmapUtil {
    private static final int BIG_PICTURE_MAX_HEIGHT_DP = 192;

    private static int calculateInSampleSize(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        int i14 = 1;
        if (i12 > i11 || i13 > i10) {
            int i15 = i12 / 2;
            int i16 = i13 / 2;
            while (i15 / i14 >= i11 && i16 / i14 >= i10) {
                i14 *= 2;
            }
        }
        return i14;
    }

    private static void closeStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                Log.e("IOException during closing of image download stream.", (Throwable) e10);
            }
        }
    }

    private static Drawable getBackground(int i10, int i11) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        float f10 = (float) SizeUtil.dp10;
        RoundRectShape roundRectShape = new RoundRectShape(new float[]{f10, f10, f10, f10, f10, f10, f10, f10}, (RectF) null, (float[]) null);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(roundRectShape);
        shapeDrawable.getPaint().setColor(i11);
        stateListDrawable.addState(new int[]{16842919, 16842908}, shapeDrawable);
        stateListDrawable.addState(new int[]{-16842919, 16842908}, shapeDrawable);
        stateListDrawable.addState(new int[]{16842919, -16842908}, shapeDrawable);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable();
        shapeDrawable2.setShape(roundRectShape);
        shapeDrawable2.getPaint().setColor(i10);
        stateListDrawable.addState(new int[]{-16842919, -16842908}, shapeDrawable2);
        return stateListDrawable;
    }

    private static Bitmap getBitmapFromUrl(String str, int i10, int i11) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = new URL(str).openStream();
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                closeStream(inputStream);
                InputStream openStream = new URL(str).openStream();
                options.inSampleSize = calculateInSampleSize(options, i10, i11);
                options.inJustDecodeBounds = false;
                Bitmap decodeStream = BitmapFactory.decodeStream(openStream, (Rect) null, options);
                closeStream(openStream);
                return decodeStream;
            } catch (IOException e10) {
                e = e10;
                try {
                    Log.e(String.format("IOException in image download for URL: %s.", new Object[]{str}), (Throwable) e);
                    closeStream(inputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    closeStream(inputStream2);
                    throw th;
                }
            }
        } catch (IOException e11) {
            e = e11;
            inputStream = null;
            Log.e(String.format("IOException in image download for URL: %s.", new Object[]{str}), (Throwable) e);
            closeStream(inputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            closeStream(inputStream2);
            throw th;
        }
    }

    public static int getDarker(int i10, int i11) {
        if (i11 < 0 || i11 > 100) {
            i11 = 0;
        }
        double d10 = ((double) (100 - i11)) / 100.0d;
        return (((int) (((double) (i10 & 255)) * d10)) & 255) | (((i10 >> 24) & 255) << 24) | ((((int) (((double) ((i10 >> 16) & 255)) * d10)) & 255) << 16) | ((((int) (((double) ((i10 >> 8) & 255)) * d10)) & 255) << 8);
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int i10) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-16777216);
        float f10 = (float) i10;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static Bitmap getScaledBitmap(Context context, String str) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int round = Math.round((displayMetrics.density * 192.0f) + 0.5f);
        int min = Math.min(round * 2, displayMetrics.widthPixels);
        Bitmap bitmapFromUrl = getBitmapFromUrl(str, min, round);
        try {
            return Bitmap.createScaledBitmap(bitmapFromUrl, min, round, true);
        } catch (Exception e10) {
            Log.e("Failed on scale image " + str + " to (" + min + ", " + round + ")", (Throwable) e10);
            return bitmapFromUrl;
        }
    }

    public static void stateBackground(View view, int i10, int i11) {
        view.setBackground(getBackground(i10, i11));
    }

    public static void stateBackgroundDarkerByPercentage(View view, int i10, int i11) {
        stateBackground(view, i10, getDarker(i10, i11));
    }
}
