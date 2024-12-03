package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.b;
import android.content.Context;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.squareup.workflow1.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import ti.a;

final class InputsKt$inputConfirmationCode$1$1$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ UiComponent.InputConfirmationCode $component;
    final /* synthetic */ EditText $editText;
    final /* synthetic */ List<EditText> $editTexts;
    final /* synthetic */ EditText $nextEditTextOrNull;
    final /* synthetic */ EditText $previousEditTextOrNull;
    final /* synthetic */ b $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputsKt$inputConfirmationCode$1$1$1(List<? extends EditText> list, EditText editText, EditText editText2, EditText editText3, UiComponent.InputConfirmationCode inputConfirmationCode, b bVar) {
        super(1);
        this.$editTexts = list;
        this.$editText = editText;
        this.$previousEditTextOrNull = editText2;
        this.$nextEditTextOrNull = editText3;
        this.$component = inputConfirmationCode;
        this.$this_apply = bVar;
    }

    public final void a(String str) {
        Context context;
        EditText editText;
        EditText editText2;
        j.g(str, "newText");
        if (str.length() >= this.$editTexts.size()) {
            InputsKt.r(str, this.$editTexts);
        } else if (str.length() > 1) {
            InputsKt.s(this.$editText, str);
        } else if (r.w(str) && (editText2 = this.$previousEditTextOrNull) != null) {
            editText2.requestFocus();
        } else if ((!r.w(str)) && (editText = this.$nextEditTextOrNull) != null) {
            editText.requestFocus();
        } else if (!r.w(str)) {
            this.$component.G().a().invoke();
            EditText editText3 = this.$this_apply.f24832c.getEditText();
            if (!(editText3 == null || (context = editText3.getContext()) == null)) {
                a.c(context);
            }
            EditText editText4 = this.$this_apply.f24832c.getEditText();
            if (editText4 != null) {
                editText4.clearFocus();
            }
        }
        k a10 = this.$component.a();
        zi.a aVar = zi.a.f34000a;
        ConstraintLayout b10 = this.$this_apply.getRoot();
        j.f(b10, "this.root");
        a10.d(aVar.a(b10));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}
