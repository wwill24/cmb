package pj;

import android.text.Spanned;

public abstract class c {
    public static boolean a(int i10, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanEnd(obj) == i10;
    }

    public static boolean b(int i10, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanStart(obj) == i10;
    }
}
