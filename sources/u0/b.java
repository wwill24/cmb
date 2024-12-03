package u0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;

public interface b extends MenuItem {
    androidx.core.view.b a();

    @NonNull
    b b(androidx.core.view.b bVar);

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    int getAlphabeticModifiers();

    CharSequence getContentDescription();

    ColorStateList getIconTintList();

    PorterDuff.Mode getIconTintMode();

    int getNumericModifiers();

    CharSequence getTooltipText();

    boolean isActionViewExpanded();

    @NonNull
    MenuItem setActionView(int i10);

    @NonNull
    MenuItem setActionView(View view);

    @NonNull
    MenuItem setAlphabeticShortcut(char c10, int i10);

    @NonNull
    b setContentDescription(CharSequence charSequence);

    @NonNull
    MenuItem setIconTintList(ColorStateList colorStateList);

    @NonNull
    MenuItem setIconTintMode(PorterDuff.Mode mode);

    @NonNull
    MenuItem setNumericShortcut(char c10, int i10);

    @NonNull
    MenuItem setShortcut(char c10, char c11, int i10, int i11);

    void setShowAsAction(int i10);

    @NonNull
    MenuItem setShowAsActionFlags(int i10);

    @NonNull
    b setTooltipText(CharSequence charSequence);
}
