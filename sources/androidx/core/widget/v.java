package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

public interface v {
    ColorStateList getSupportButtonTintList();

    void setSupportButtonTintList(ColorStateList colorStateList);

    void setSupportButtonTintMode(PorterDuff.Mode mode);
}
