package g1;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.emoji2.text.e;

final class c extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f15007a;

    /* renamed from: b  reason: collision with root package name */
    private final a f15008b;

    public static class a {
        public boolean a(@NonNull InputConnection inputConnection, @NonNull Editable editable, int i10, int i11, boolean z10) {
            return e.e(inputConnection, editable, i10, i11, z10);
        }

        public void b(@NonNull EditorInfo editorInfo) {
            if (e.h()) {
                e.b().u(editorInfo);
            }
        }
    }

    c(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }

    private Editable a() {
        return this.f15007a.getEditableText();
    }

    public boolean deleteSurroundingText(int i10, int i11) {
        if (this.f15008b.a(this, a(), i10, i11, false) || super.deleteSurroundingText(i10, i11)) {
            return true;
        }
        return false;
    }

    public boolean deleteSurroundingTextInCodePoints(int i10, int i11) {
        if (this.f15008b.a(this, a(), i10, i11, true) || super.deleteSurroundingTextInCodePoints(i10, i11)) {
            return true;
        }
        return false;
    }

    c(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull a aVar) {
        super(inputConnection, false);
        this.f15007a = textView;
        this.f15008b = aVar;
        aVar.b(editorInfo);
    }
}
