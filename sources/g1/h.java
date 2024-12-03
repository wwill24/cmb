package g1;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.emoji2.text.e;

class h implements TransformationMethod {

    /* renamed from: a  reason: collision with root package name */
    private final TransformationMethod f15027a;

    h(TransformationMethod transformationMethod) {
        this.f15027a = transformationMethod;
    }

    public TransformationMethod a() {
        return this.f15027a;
    }

    public CharSequence getTransformation(CharSequence charSequence, @NonNull View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f15027a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        if (charSequence == null || e.b().d() != 1) {
            return charSequence;
        }
        return e.b().o(charSequence);
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z10, int i10, Rect rect) {
        TransformationMethod transformationMethod = this.f15027a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z10, i10, rect);
        }
    }
}
