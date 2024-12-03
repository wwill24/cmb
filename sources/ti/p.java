package ti;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class p {

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        private String f33868a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f33869b;

        a(Function1<? super String, Unit> function1) {
            this.f33869b = function1;
        }

        public void afterTextChanged(Editable editable) {
            String valueOf = String.valueOf(editable);
            String str = this.f33868a;
            if (str == null) {
                j.y("oldText");
                str = null;
            }
            if (!j.b(valueOf, str)) {
                this.f33869b.invoke(String.valueOf(editable));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            this.f33868a = String.valueOf(charSequence);
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final void a(TextView textView, Function1<? super String, Unit> function1) {
        j.g(textView, "<this>");
        j.g(function1, "listener");
        int i10 = h.text_changed_listener;
        Object tag = textView.getTag(i10);
        if (tag != null) {
            textView.removeTextChangedListener((TextWatcher) tag);
        }
        a aVar = new a(function1);
        textView.addTextChangedListener(aVar);
        textView.setTag(i10, aVar);
    }
}
