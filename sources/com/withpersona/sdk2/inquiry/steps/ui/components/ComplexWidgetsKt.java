package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.n;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.TextControllerControlEditTextKt;
import com.squareup.workflow1.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.components.j;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class ComplexWidgetsKt {
    public static final TextInputLayout a(Context context, UiComponent.InputMultiSelect inputMultiSelect) {
        AutoCompleteTextView autoCompleteTextView;
        boolean z10;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(inputMultiSelect, "component");
        n c10 = n.c(LayoutInflater.from(context));
        UiComponent.InputMultiSelect.Attributes F = inputMultiSelect.z();
        if (F != null) {
            String i10 = F.i();
            if (i10 != null) {
                c10.getRoot().setPlaceholderText(i10);
            }
            List<String> t10 = inputMultiSelect.t();
            j.a aVar = j.f27586r;
            String W = CollectionsKt___CollectionsKt.W(t10, aVar.a(), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            EditText editText = c10.getRoot().getEditText();
            if (editText != null) {
                editText.setText(W);
            }
            String g10 = F.g();
            if (g10 != null) {
                c10.getRoot().setHint((CharSequence) g10);
            }
            EditText editText2 = c10.getRoot().getEditText();
            if (editText2 != null) {
                k a10 = inputMultiSelect.a();
                kotlin.jvm.internal.j.f(editText2, "editText");
                TextControllerControlEditTextKt.b(a10, editText2);
            }
            EditText editText3 = c10.f24875b.getEditText();
            if (editText3 != null) {
                String i11 = F.i();
                if (i11 == null) {
                    i11 = "";
                }
                editText3.setText(i11);
            }
            EditText editText4 = c10.f24875b.getEditText();
            if (editText4 instanceof AutoCompleteTextView) {
                autoCompleteTextView = (AutoCompleteTextView) editText4;
            } else {
                autoCompleteTextView = null;
            }
            if (autoCompleteTextView != null) {
                if (W.length() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    autoCompleteTextView.setText(CollectionsKt___CollectionsKt.W(t10, aVar.a(), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), false);
                }
            }
        }
        TextInputLayout textInputLayout = c10.f24875b;
        kotlin.jvm.internal.j.f(textInputLayout, "listSelector");
        com.withpersona.sdk2.inquiry.shared.ui.k.b(textInputLayout, new ComplexWidgetsKt$inputMultiSelectView$1$2(inputMultiSelect, c10));
        TextInputLayout b10 = c10.getRoot();
        kotlin.jvm.internal.j.f(b10, "inflate(LayoutInflater.f…(styles)\n    }\n  }\n}.root");
        return b10;
    }

    public static final TextInputLayout b(Context context, UiComponent.InputSelect inputSelect) {
        AutoCompleteTextView autoCompleteTextView;
        EditText editText;
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(inputSelect, "component");
        n c10 = n.c(LayoutInflater.from(context));
        UiComponent.InputSelect.Attributes E = inputSelect.z();
        if (E != null) {
            String i10 = E.i();
            if (i10 != null) {
                c10.getRoot().setPlaceholderText(i10);
            }
            String j10 = E.j();
            if (!(j10 == null || (editText = c10.getRoot().getEditText()) == null)) {
                editText.setText(j10);
            }
            String g10 = E.g();
            if (g10 != null) {
                c10.getRoot().setHint((CharSequence) g10);
            }
            EditText editText2 = c10.getRoot().getEditText();
            if (editText2 != null) {
                k a10 = inputSelect.a();
                kotlin.jvm.internal.j.f(editText2, "editText");
                TextControllerControlEditTextKt.b(a10, editText2);
            }
            EditText editText3 = c10.f24875b.getEditText();
            if (editText3 != null) {
                String i11 = E.i();
                if (i11 == null) {
                    i11 = "";
                }
                editText3.setText(i11);
            }
            EditText editText4 = c10.f24875b.getEditText();
            if (editText4 instanceof AutoCompleteTextView) {
                autoCompleteTextView = (AutoCompleteTextView) editText4;
            } else {
                autoCompleteTextView = null;
            }
            if (autoCompleteTextView != null && (!inputSelect.t().isEmpty())) {
                autoCompleteTextView.setText((CharSequence) CollectionsKt___CollectionsKt.N(inputSelect.t()), false);
            }
        }
        TextInputLayout textInputLayout = c10.f24875b;
        kotlin.jvm.internal.j.f(textInputLayout, "listSelector");
        com.withpersona.sdk2.inquiry.shared.ui.k.b(textInputLayout, new ComplexWidgetsKt$inputSelectView$1$2(inputSelect, c10));
        TextInputLayout b10 = c10.getRoot();
        kotlin.jvm.internal.j.f(b10, "inflate(LayoutInflater.f…(styles)\n    }\n  }\n}.root");
        return b10;
    }

    public static final View c(Context context, UiComponent.Spacer spacer) {
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(spacer, "component");
        View view = new View(context);
        com.withpersona.sdk2.inquiry.shared.ui.k.b(view, new ComplexWidgetsKt$spacer$1$1(view, spacer));
        return view;
    }
}
