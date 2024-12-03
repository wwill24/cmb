package com.coffeemeetsbagel.new_user_experience.numberPickers;

import android.content.Context;
import android.util.AttributeSet;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.models.Height;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.ArrayList;
import kotlin.jvm.internal.j;

public final class CentimeterHeightPicker extends OnboardingPicker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CentimeterHeightPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(attributeSet, "attrs");
        setMinValue(122);
        setMaxValue(Height.CENTIMETRES_MAX);
        String string = getContext().getString(R.string.centimeter_unit);
        j.f(string, "context.getString(R.string.centimeter_unit)");
        ArrayList arrayList = new ArrayList();
        for (int i10 = 122; i10 < 273; i10++) {
            arrayList.add(i10 + string);
        }
        setDisplayedValues((String[]) arrayList.toArray(new String[0]));
    }
}
