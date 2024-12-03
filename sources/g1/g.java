package g1;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.e;
import com.google.android.gms.common.api.a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class g implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final EditText f15020a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f15021b;

    /* renamed from: c  reason: collision with root package name */
    private e.C0055e f15022c;

    /* renamed from: d  reason: collision with root package name */
    private int f15023d = a.e.API_PRIORITY_OTHER;

    /* renamed from: e  reason: collision with root package name */
    private int f15024e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15025f;

    private static class a extends e.C0055e {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<EditText> f15026a;

        a(EditText editText) {
            this.f15026a = new WeakReference(editText);
        }

        public void b() {
            super.b();
            g.b(this.f15026a.get(), 1);
        }
    }

    g(EditText editText, boolean z10) {
        this.f15020a = editText;
        this.f15021b = z10;
        this.f15025f = true;
    }

    private e.C0055e a() {
        if (this.f15022c == null) {
            this.f15022c = new a(this.f15020a);
        }
        return this.f15022c;
    }

    static void b(EditText editText, int i10) {
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            e.b().o(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean d() {
        return !this.f15025f || (!this.f15021b && !e.h());
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void c(boolean z10) {
        if (this.f15025f != z10) {
            if (this.f15022c != null) {
                e.b().t(this.f15022c);
            }
            this.f15025f = z10;
            if (z10) {
                b(this.f15020a, e.b().d());
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (!this.f15020a.isInEditMode() && !d() && i11 <= i12 && (charSequence instanceof Spannable)) {
            int d10 = e.b().d();
            if (d10 != 0) {
                if (d10 == 1) {
                    e.b().r((Spannable) charSequence, i10, i10 + i12, this.f15023d, this.f15024e);
                    return;
                } else if (d10 != 3) {
                    return;
                }
            }
            e.b().s(a());
        }
    }
}
