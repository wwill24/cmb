package com.coffeemeetsbagel.new_user_experience;

import android.content.Context;
import android.util.AttributeSet;
import com.coffeemeetsbagel.R;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.internal.j;

public final class OnboardingTextInputLayout extends TextInputLayout {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OnboardingTextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
        j.g(context, "ctx");
    }

    public final void y0(boolean z10) {
        if (z10) {
            setError(" ");
        } else {
            setError((CharSequence) null);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnboardingTextInputLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j.g(context, "ctx");
    }
}
