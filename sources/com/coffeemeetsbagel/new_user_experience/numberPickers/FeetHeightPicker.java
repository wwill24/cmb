package com.coffeemeetsbagel.new_user_experience.numberPickers;

import android.content.Context;
import android.util.AttributeSet;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.ArrayList;
import kotlin.jvm.internal.j;

public final class FeetHeightPicker extends OnboardingPicker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeetHeightPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(attributeSet, "attrs");
        setMinValue(4);
        setMaxValue(8);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 4; i10 < 9; i10++) {
            arrayList.add(i10 + "'");
        }
        setDisplayedValues((String[]) arrayList.toArray(new String[0]));
    }
}
