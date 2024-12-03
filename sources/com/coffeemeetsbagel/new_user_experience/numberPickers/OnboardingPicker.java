package com.coffeemeetsbagel.new_user_experience.numberPickers;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import androidx.core.content.a;
import com.coffeemeetsbagel.R;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;
import lc.c;
import net.bytebuddy.jar.asm.Opcodes;

public class OnboardingPicker extends NumberPicker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnboardingPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(attributeSet, "attrs");
        setWrapSelectorWheel(false);
        setDescendantFocusability(Opcodes.ASM6);
        if (getContext() != null) {
            c.m(this, a.getColor(getContext(), R.color.very_light_gray));
        }
    }
}
