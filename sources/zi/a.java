package zi;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.g;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f34000a = new a();

    private a() {
    }

    public final String a(View view) {
        Editable editable;
        Editable editable2;
        Editable editable3;
        j.g(view, "view");
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(g.second);
        TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(g.third);
        TextInputLayout textInputLayout3 = (TextInputLayout) view.findViewById(g.fourth);
        String[] strArr = new String[4];
        EditText editText = ((TextInputLayout) view.findViewById(g.first)).getEditText();
        Editable editable4 = null;
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        strArr[0] = String.valueOf(editable);
        EditText editText2 = textInputLayout.getEditText();
        if (editText2 != null) {
            editable2 = editText2.getText();
        } else {
            editable2 = null;
        }
        strArr[1] = String.valueOf(editable2);
        EditText editText3 = textInputLayout2.getEditText();
        if (editText3 != null) {
            editable3 = editText3.getText();
        } else {
            editable3 = null;
        }
        strArr[2] = String.valueOf(editable3);
        EditText editText4 = textInputLayout3.getEditText();
        if (editText4 != null) {
            editable4 = editText4.getText();
        }
        strArr[3] = String.valueOf(editable4);
        return CollectionsKt___CollectionsKt.W(q.m(strArr), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final boolean b(View view) {
        j.g(view, "view");
        return a(view).length() == 4;
    }
}
