package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.appcompat.widget.c;
import q5.f;
import q5.p;

public class DelayAutoCompleteTextView extends c {

    /* renamed from: e  reason: collision with root package name */
    private final Handler f11507e = new a();

    /* renamed from: f  reason: collision with root package name */
    private ProgressBar f11508f;

    class a extends Handler {
        a() {
        }

        public void handleMessage(Message message) {
            DelayAutoCompleteTextView.super.performFiltering((CharSequence) message.obj, message.arg1);
        }
    }

    public DelayAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
        setLayerType(1, (Paint) null);
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.DelayAutoCompleteTextView);
        d(context, obtainStyledAttributes.getString(p.DelayAutoCompleteTextView_customFont));
        obtainStyledAttributes.recycle();
    }

    public boolean d(Context context, String str) {
        Typeface c10 = f.c(context, str);
        if (c10 == null) {
            return false;
        }
        setTypeface(c10);
        return true;
    }

    public void onFilterComplete(int i10) {
        ProgressBar progressBar = this.f11508f;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        super.onFilterComplete(i10);
    }

    /* access modifiers changed from: protected */
    public void performFiltering(CharSequence charSequence, int i10) {
        ProgressBar progressBar = this.f11508f;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        this.f11507e.removeMessages(100);
        Handler handler = this.f11507e;
        handler.sendMessageDelayed(handler.obtainMessage(100, charSequence), 750);
    }

    public void setLoadingIndicator(ProgressBar progressBar) {
        this.f11508f = progressBar;
    }
}
