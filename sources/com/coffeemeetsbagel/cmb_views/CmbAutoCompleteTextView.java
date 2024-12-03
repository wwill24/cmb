package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Editable;
import android.util.AttributeSet;
import androidx.appcompat.widget.c;
import io.reactivex.subjects.a;
import q5.f;
import q5.p;

public class CmbAutoCompleteTextView extends c {

    /* renamed from: e  reason: collision with root package name */
    private final a<Editable> f11474e = a.C0();

    public CmbAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
        setLayerType(1, (Paint) null);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.CmbAutoCompleteTextView);
        c(context, obtainStyledAttributes.getString(p.CmbAutoCompleteTextView_customFont));
        obtainStyledAttributes.recycle();
    }

    public boolean c(Context context, String str) {
        Typeface c10 = f.c(context, str);
        if (c10 == null) {
            return false;
        }
        setTypeface(c10);
        return true;
    }
}
