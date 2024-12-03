package s2;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import c3.i;

public class a extends Paint {
    public a() {
    }

    public void setAlpha(int i10) {
        if (Build.VERSION.SDK_INT < 30) {
            setColor((i.c(i10, 0, 255) << 24) | (getColor() & 16777215));
            return;
        }
        super.setAlpha(i.c(i10, 0, 255));
    }

    public void setTextLocales(@NonNull LocaleList localeList) {
    }

    public a(int i10) {
        super(i10);
    }

    public a(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public a(int i10, PorterDuff.Mode mode) {
        super(i10);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
