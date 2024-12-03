package com.coffeemeetsbagel.instant_like;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.b0;
import com.coffeemeetsbagel.instant_like.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class InstantLikeBottomSheetRouter$insufficientBeansDialog$2 extends Lambda implements Function0<b0> {
    final /* synthetic */ f.a $component;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstantLikeBottomSheetRouter$insufficientBeansDialog$2(f.a aVar) {
        super(0);
        this.$component = aVar;
    }

    /* renamed from: a */
    public final b0 invoke() {
        return new b0(this.$component.O0(), R.string.dialog_notenoughbeans_title, R.string.dialog_notenoughbeans_content, R.string.dialog_notenoughbeans_button_dls);
    }
}
