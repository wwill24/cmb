package vf;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.d0;
import bf.l;
import qf.b;
import qf.c;

public class a extends d0 {
    public a(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    private void r(@NonNull Resources.Theme theme, int i10) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i10, l.MaterialTextAppearance);
        int v10 = v(getContext(), obtainStyledAttributes, l.MaterialTextAppearance_android_lineHeight, l.MaterialTextAppearance_lineHeight);
        obtainStyledAttributes.recycle();
        if (v10 >= 0) {
            setLineHeight(v10);
        }
    }

    private static boolean s(Context context) {
        return b.b(context, bf.b.textAppearanceLineHeightEnabled, true);
    }

    private static int t(@NonNull Resources.Theme theme, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, l.MaterialTextView, i10, i11);
        int resourceId = obtainStyledAttributes.getResourceId(l.MaterialTextView_android_textAppearance, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private void u(AttributeSet attributeSet, int i10, int i11) {
        int t10;
        Context context = getContext();
        if (s(context)) {
            Resources.Theme theme = context.getTheme();
            if (!w(context, theme, attributeSet, i10, i11) && (t10 = t(theme, attributeSet, i10, i11)) != -1) {
                r(theme, t10);
            }
        }
    }

    private static int v(@NonNull Context context, @NonNull TypedArray typedArray, @NonNull int... iArr) {
        int i10 = -1;
        for (int i11 = 0; i11 < iArr.length && i10 < 0; i11++) {
            i10 = c.c(context, typedArray, iArr[i11], -1);
        }
        return i10;
    }

    private static boolean w(@NonNull Context context, @NonNull Resources.Theme theme, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, l.MaterialTextView, i10, i11);
        int v10 = v(context, obtainStyledAttributes, l.MaterialTextView_android_lineHeight, l.MaterialTextView_lineHeight);
        obtainStyledAttributes.recycle();
        if (v10 != -1) {
            return true;
        }
        return false;
    }

    public void setTextAppearance(@NonNull Context context, int i10) {
        super.setTextAppearance(context, i10);
        if (s(context)) {
            r(context.getTheme(), i10);
        }
    }

    public a(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(wf.a.c(context, attributeSet, i10, 0), attributeSet, i10);
        u(attributeSet, i10, 0);
    }
}
