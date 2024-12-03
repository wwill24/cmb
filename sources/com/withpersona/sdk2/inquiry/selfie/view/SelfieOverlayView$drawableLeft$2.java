package com.withpersona.sdk2.inquiry.selfie.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.a;
import com.withpersona.sdk2.inquiry.selfie.f;
import com.withpersona.sdk2.inquiry.selfie.h;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ti.n;

final class SelfieOverlayView$drawableLeft$2 extends Lambda implements Function0<Drawable> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieOverlayView$drawableLeft$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* renamed from: a */
    public final Drawable invoke() {
        Integer f10 = n.f(this.$context, f.personaSelfieLookLeftDrawable, (TypedValue) null, false, 6, (Object) null);
        if (f10 != null) {
            return a.getDrawable(this.$context, f10.intValue());
        }
        return a.getDrawable(this.$context, h.pi2_ic_selfie_left);
    }
}
