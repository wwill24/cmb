package com.coffeemeetsbagel.feature.comment_on_like;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public class RisingCommentView extends ConstraintLayout {
    private CmbTextView F;
    private CmbTextView G;

    public RisingCommentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void B(String str, String str2) {
        this.F.setText(str);
        this.G.setText(str2);
    }

    public void C(boolean z10) {
        int i10;
        View findViewById = findViewById(R.id.givetake_comment_start_quotations);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 4;
        }
        findViewById.setVisibility(i10);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.F = (CmbTextView) findViewById(R.id.givetake_comment_overall_title);
        this.G = (CmbTextView) findViewById(R.id.givetake_comment_overall_text);
    }
}
