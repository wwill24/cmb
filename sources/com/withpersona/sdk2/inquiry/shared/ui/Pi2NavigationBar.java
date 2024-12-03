package com.withpersona.sdk2.inquiry.shared.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import ti.f;
import ti.g;
import ti.k;
import vi.c;

public final class Pi2NavigationBar extends ConstraintLayout {
    private final c F;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Pi2NavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
        c b10 = c.b(LayoutInflater.from(getContext()), this);
        j.f(b10, "inflate(LayoutInflater.from(context), this)");
        this.F = b10;
        q(attributeSet, 0, 0);
    }

    /* access modifiers changed from: private */
    public static final void D(NavigationUiState navigationUiState, View view) {
        j.g(navigationUiState, "$state");
        Function0<Unit> a10 = navigationUiState.a();
        if (a10 != null) {
            a10.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void E(NavigationUiState navigationUiState, View view) {
        j.g(navigationUiState, "$state");
        Function0<Unit> c10 = navigationUiState.c();
        if (c10 != null) {
            c10.invoke();
        }
    }

    private final void q(AttributeSet attributeSet, int i10, int i11) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, k.Pi2NavigationBar, i10, i11);
            j.f(obtainStyledAttributes, "context.obtainStyledAttr…      defStyleRes\n      )");
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i12 = 0; i12 < indexCount; i12++) {
                int index = obtainStyledAttributes.getIndex(i12);
                if (index == k.Pi2NavigationBar_pi2BackButtonIcon) {
                    this.F.f33906b.setImageResource(obtainStyledAttributes.getResourceId(index, g.pi2_shared_arrow_back));
                } else if (index == k.Pi2NavigationBar_pi2CancelButtonIcon) {
                    this.F.f33907c.setImageResource(obtainStyledAttributes.getResourceId(index, g.pi2_shared_close_icon));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final View getBackButton() {
        ImageView imageView = this.F.f33906b;
        j.f(imageView, "binding.backButton");
        return imageView;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(f.pi2_navigation_bar_padding);
        setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
    }

    public final void setControlsColor(int i10) {
        this.F.f33906b.setColorFilter(i10);
        this.F.f33907c.setColorFilter(i10);
    }

    public final void setState(NavigationUiState navigationUiState) {
        int i10;
        j.g(navigationUiState, "state");
        ImageView imageView = this.F.f33906b;
        int i11 = 0;
        if (navigationUiState.d()) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        imageView.setVisibility(i10);
        this.F.f33906b.setOnClickListener(new c(navigationUiState));
        ImageView imageView2 = this.F.f33907c;
        if (!navigationUiState.e()) {
            i11 = 8;
        }
        imageView2.setVisibility(i11);
        this.F.f33907c.setOnClickListener(new d(navigationUiState));
        View root = this.F.getRoot();
        j.f(root, "binding.root");
        b.c(root, new Pi2NavigationBar$setState$3(navigationUiState));
    }
}
