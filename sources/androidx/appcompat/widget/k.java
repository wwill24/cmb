package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import d.j;
import g1.f;

class k {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextView f1306a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final f f1307b;

    k(@NonNull TextView textView) {
        this.f1306a = textView;
        this.f1307b = new f(textView, false);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
        return this.f1307b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f1307b.b();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = this.f1306a.getContext().obtainStyledAttributes(attributeSet, j.AppCompatTextView, i10, 0);
        try {
            int i11 = j.AppCompatTextView_emojiCompatEnabled;
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
    public void d(boolean z10) {
        this.f1307b.c(z10);
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z10) {
        this.f1307b.d(z10);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f1307b.e(transformationMethod);
    }
}
