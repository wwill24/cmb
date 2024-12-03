package com.withpersona.sdk2.inquiry.ui;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.components.d;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class UiScreenRunner$updateRendering$showInputSelectBottomSheet$1 extends Lambda implements Function1<List<? extends String>, Unit> {
    final /* synthetic */ UiComponent $component;
    final /* synthetic */ TextInputLayout $textInputLayout;
    final /* synthetic */ UiScreenRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiScreenRunner$updateRendering$showInputSelectBottomSheet$1(UiScreenRunner uiScreenRunner, TextInputLayout textInputLayout, UiComponent uiComponent) {
        super(1);
        this.this$0 = uiScreenRunner;
        this.$textInputLayout = textInputLayout;
        this.$component = uiComponent;
    }

    public final void a(List<String> list) {
        j.g(list, "selectedItems");
        boolean z10 = true;
        this.this$0.f29311b.f29596h.getBackButton().setEnabled(true);
        this.$textInputLayout.setEnabled(true);
        this.this$0.f29311b.f29596h.setImportantForAccessibility(1);
        this.this$0.f29311b.f29599l.setImportantForAccessibility(1);
        String W = CollectionsKt___CollectionsKt.W(list, com.withpersona.sdk2.inquiry.steps.ui.components.j.f27586r.a(), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        UiComponent uiComponent = this.$component;
        if (W.length() != 0) {
            z10 = false;
        }
        if (z10) {
            W = ((d) uiComponent).w();
        }
        EditText editText = this.$textInputLayout.getEditText();
        if (editText != null) {
            editText.setText(W);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
