package com.coffeemeetsbagel.feature.likepassflow;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coffeemeetsbagel.R;

public class RowItemView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f13049a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f13050b;

    public RowItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public String getText() {
        return this.f13050b.getText().toString();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f13049a = (ImageView) findViewById(R.id.imageView_check);
        this.f13050b = (TextView) findViewById(R.id.text_label);
    }

    public void setChecked(boolean z10) {
        int i10;
        int i11;
        if (z10) {
            i10 = R.color.dark_gray;
        } else {
            i10 = R.color.gray;
        }
        this.f13050b.setTextColor(getResources().getColor(i10));
        ImageView imageView = this.f13049a;
        if (z10) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        imageView.setVisibility(i11);
    }

    public void setText(String str) {
        this.f13050b.setText(str);
    }
}
