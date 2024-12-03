package com.coffeemeetsbagel.feature.chatlist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.a;
import com.coffeemeetsbagel.models.enums.Icon;
import lc.c;

public class k {
    public Drawable a(Context context, int i10, int i11, int i12, int i13) {
        TextView textView = new TextView(context);
        c.o(textView, Icon.DONE);
        int dimension = (int) context.getResources().getDimension(i12);
        textView.setPadding(dimension, dimension, dimension, dimension);
        textView.setTextSize(1, context.getResources().getDimension(i13));
        textView.setTextColor(a.getColor(context, i10));
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(textView.getMeasuredWidth(), textView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        textView.draw(new Canvas(createBitmap));
        return new LayerDrawable(new Drawable[]{a.getDrawable(context, i11), new BitmapDrawable(context.getResources(), createBitmap)});
    }
}
