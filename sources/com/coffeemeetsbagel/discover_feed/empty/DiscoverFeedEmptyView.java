package com.coffeemeetsbagel.discover_feed.empty;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import io.reactivex.subjects.a;
import p6.m;
import p6.n;
import qj.q;

public class DiscoverFeedEmptyView extends ConstraintLayout {
    private a<EmptyScreenAction> F = a.C0();
    private ImageView G;
    private CmbTextView H;
    private View I;
    private CmbTextView J;
    private CmbTextView K;

    public DiscoverFeedEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(View view) {
        this.F.d(EmptyScreenAction.MODIFY_FILTERS);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(View view) {
        this.F.d(EmptyScreenAction.RESET_FILTERS);
    }

    private void G() {
        this.G.setImageResource(R.drawable.empty_discover_no_filters_icon);
        this.H.setVisibility(8);
        this.I.setVisibility(8);
        this.K.setText(R.string.discover_empty_heading);
        this.J.setText(R.string.discover_empty_explanation);
    }

    private void H() {
        this.G.setImageResource(R.drawable.empty_page_checkmark_heart_icon);
        this.H.setText(R.string.edit_my_search);
        this.H.setOnClickListener(new m(this));
        this.I.setOnClickListener(new n(this));
        this.K.setText(R.string.discover_empty_search_heading);
        this.J.setText(R.string.discover_empty_search_explanation);
    }

    public q<EmptyScreenAction> D() {
        return this.F;
    }

    public void I(boolean z10) {
        if (z10) {
            H();
        } else {
            G();
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.G = (ImageView) findViewById(R.id.discover_empty_icon);
        this.H = (CmbTextView) findViewById(R.id.discover_empty_button);
        this.I = findViewById(R.id.discover_reset_search);
        this.J = (CmbTextView) findViewById(R.id.discover_empty_description);
        this.K = (CmbTextView) findViewById(R.id.discover_empty_heading);
    }
}
