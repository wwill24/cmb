package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import g1.a;

class j {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final EditText f1303a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final a f1304b;

    j(@NonNull EditText editText) {
        this.f1303a = editText;
        this.f1304b = new a(editText, false);
    }

    /* access modifiers changed from: package-private */
    public KeyListener a(KeyListener keyListener) {
        if (b(keyListener)) {
            return this.f1304b.a(keyListener);
        }
        return keyListener;
    }

    /* access modifiers changed from: package-private */
    public boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = this.f1303a.getContext().obtainStyledAttributes(attributeSet, d.j.AppCompatTextView, i10, 0);
        try {
            int i11 = d.j.AppCompatTextView_emojiCompatEnabled;
            boolean z10 = true;
            if (obtainStyledAttributes.hasValue(i11)) {
                z10 = obtainStyledAttributes.getBoolean(i11, true);
            }
            obtainStyledAttributes.recycle();
            e(z10);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public InputConnection d(InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        return this.f1304b.b(inputConnection, editorInfo);
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z10) {
        this.f1304b.c(z10);
    }
}
