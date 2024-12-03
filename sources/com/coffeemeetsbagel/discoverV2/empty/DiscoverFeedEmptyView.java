package com.coffeemeetsbagel.discoverV2.empty;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import io.reactivex.subjects.a;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.rx2.RxConvertKt;
import n6.b;

public final class DiscoverFeedEmptyView extends ConstraintLayout {
    private final a<EmptyScreenAction> F;
    private ImageView G;
    private CmbTextView H;
    private View I;
    private CmbTextView J;
    private CmbTextView K;

    public enum EmptyScreenAction {
        MODIFY_FILTERS,
        RESET_FILTERS
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiscoverFeedEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.d(context);
        a<EmptyScreenAction> C0 = a.C0();
        j.f(C0, "create<EmptyScreenAction>()");
        this.F = C0;
    }

    private final void E() {
        ImageView imageView = this.G;
        j.d(imageView);
        imageView.setImageResource(R.drawable.empty_discover_no_filters_icon);
        CmbTextView cmbTextView = this.H;
        j.d(cmbTextView);
        cmbTextView.setVisibility(8);
        View view = this.I;
        j.d(view);
        view.setVisibility(8);
        CmbTextView cmbTextView2 = this.K;
        j.d(cmbTextView2);
        cmbTextView2.setText(R.string.discover_empty_heading);
        CmbTextView cmbTextView3 = this.J;
        j.d(cmbTextView3);
        cmbTextView3.setText(R.string.discover_empty_explanation);
    }

    private final void F() {
        ImageView imageView = this.G;
        j.d(imageView);
        imageView.setImageResource(R.drawable.empty_page_checkmark_heart_icon);
        CmbTextView cmbTextView = this.H;
        j.d(cmbTextView);
        cmbTextView.setText(R.string.edit_my_search);
        CmbTextView cmbTextView2 = this.H;
        j.d(cmbTextView2);
        cmbTextView2.setOnClickListener(new n6.a(this));
        View view = this.I;
        j.d(view);
        view.setOnClickListener(new b(this));
        CmbTextView cmbTextView3 = this.K;
        j.d(cmbTextView3);
        cmbTextView3.setText(R.string.discover_empty_search_heading);
        CmbTextView cmbTextView4 = this.J;
        j.d(cmbTextView4);
        cmbTextView4.setText(R.string.discover_empty_search_explanation);
    }

    /* access modifiers changed from: private */
    public static final void G(DiscoverFeedEmptyView discoverFeedEmptyView, View view) {
        j.g(discoverFeedEmptyView, "this$0");
        discoverFeedEmptyView.F.d(EmptyScreenAction.MODIFY_FILTERS);
    }

    /* access modifiers changed from: private */
    public static final void H(DiscoverFeedEmptyView discoverFeedEmptyView, View view) {
        j.g(discoverFeedEmptyView, "this$0");
        discoverFeedEmptyView.F.d(EmptyScreenAction.RESET_FILTERS);
    }

    public final kotlinx.coroutines.flow.b<EmptyScreenAction> D() {
        return RxConvertKt.a(this.F);
    }

    public final void I(boolean z10) {
        if (z10) {
            F();
        } else {
            E();
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
