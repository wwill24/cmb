package com.withpersona.sdk2.inquiry.steps.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.widget.NestedScrollView;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.steps.ui.i;
import kotlin.jvm.internal.j;

public final class ShadowedNestedScrollView extends NestedScrollView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShadowedNestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    public int getSolidColor() {
        Context context = getContext();
        j.f(context, IdentityHttpResponse.CONTEXT);
        int[] iArr = i.Theme;
        j.f(iArr, "Theme");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr, 0, 0);
        j.f(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        return obtainStyledAttributes.getColor(i.Theme_personaScrollShadowHintColor, -3355444);
    }
}
