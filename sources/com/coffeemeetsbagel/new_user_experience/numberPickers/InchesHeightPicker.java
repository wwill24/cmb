package com.coffeemeetsbagel.new_user_experience.numberPickers;

import android.content.Context;
import android.util.AttributeSet;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class InchesHeightPicker extends OnboardingPicker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InchesHeightPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(attributeSet, "attrs");
        setMinValue(0);
        setMaxValue(11);
        String[] strArr = new String[12];
        for (int i10 = 0; i10 < 12; i10++) {
            strArr[i10] = i10 + "\"";
        }
        setDisplayedValues(strArr);
    }
}
