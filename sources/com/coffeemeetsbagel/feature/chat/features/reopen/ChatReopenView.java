package com.coffeemeetsbagel.feature.chat.features.reopen;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import j5.x;
import qj.q;

public class ChatReopenView extends ConstraintLayout {
    private CmbTextView F;
    private CmbTextView G;
    private CmbTextView H;

    public ChatReopenView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public q<x> B() {
        return this.H.s();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.F = (CmbTextView) findViewById(R.id.text_title);
        this.G = (CmbTextView) findViewById(R.id.text_description);
        this.H = (CmbTextView) findViewById(R.id.button);
    }

    public void setType(ChatReopenPromptType chatReopenPromptType) {
        this.F.setText(chatReopenPromptType.c());
        this.G.setText(chatReopenPromptType.a());
    }
}
