package com.coffeemeetsbagel.dialogs;

import android.widget.TextView;
import com.coffeemeetsbagel.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class HorizontalPrimarySecondaryDialog$primaryButton$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ HorizontalPrimarySecondaryDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HorizontalPrimarySecondaryDialog$primaryButton$2(HorizontalPrimarySecondaryDialog horizontalPrimarySecondaryDialog) {
        super(0);
        this.this$0 = horizontalPrimarySecondaryDialog;
    }

    /* renamed from: a */
    public final TextView invoke() {
        return (TextView) this.this$0.findViewById(R.id.primary_button);
    }
}
