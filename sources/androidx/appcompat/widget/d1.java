package androidx.appcompat.widget;

import android.content.res.Resources;
import android.widget.SpinnerAdapter;

public interface d1 extends SpinnerAdapter {
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(Resources.Theme theme);
}
