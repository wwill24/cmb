package w0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.core.util.h;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f18157a = new String[0];

    private static class a {
        static void a(@NonNull EditorInfo editorInfo, CharSequence charSequence, int i10) {
            editorInfo.setInitialSurroundingSubText(charSequence, i10);
        }
    }

    private static boolean a(CharSequence charSequence, int i10, int i11) {
        if (i11 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i10));
        }
        if (i11 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i10));
    }

    private static boolean b(int i10) {
        int i11 = i10 & 4095;
        return i11 == 129 || i11 == 225 || i11 == 18;
    }

    public static void c(@NonNull EditorInfo editorInfo, String[] strArr) {
        editorInfo.contentMimeTypes = strArr;
    }

    public static void d(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence, int i10) {
        int i11;
        int i12;
        h.g(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            a.a(editorInfo, charSequence, i10);
            return;
        }
        int i13 = editorInfo.initialSelStart;
        int i14 = editorInfo.initialSelEnd;
        if (i13 > i14) {
            i11 = i14 - i10;
        } else {
            i11 = i13 - i10;
        }
        if (i13 > i14) {
            i12 = i13 - i10;
        } else {
            i12 = i14 - i10;
        }
        int length = charSequence.length();
        if (i10 < 0 || i11 < 0 || i12 > length) {
            f(editorInfo, (CharSequence) null, 0, 0);
        } else if (b(editorInfo.inputType)) {
            f(editorInfo, (CharSequence) null, 0, 0);
        } else if (length <= 2048) {
            f(editorInfo, charSequence, i11, i12);
        } else {
            g(editorInfo, charSequence, i11, i12);
        }
    }

    public static void e(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            a.a(editorInfo, charSequence, 0);
        } else {
            d(editorInfo, charSequence, 0);
        }
    }

    private static void f(EditorInfo editorInfo, CharSequence charSequence, int i10, int i11) {
        SpannableStringBuilder spannableStringBuilder;
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        if (charSequence != null) {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
        } else {
            spannableStringBuilder = null;
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", spannableStringBuilder);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i10);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i11);
    }

    private static void g(EditorInfo editorInfo, CharSequence charSequence, int i10, int i11) {
        int i12;
        CharSequence charSequence2;
        int i13 = i11 - i10;
        if (i13 > 1024) {
            i12 = 0;
        } else {
            i12 = i13;
        }
        int i14 = 2048 - i12;
        int min = Math.min(charSequence.length() - i11, i14 - Math.min(i10, (int) (((double) i14) * 0.8d)));
        int min2 = Math.min(i10, i14 - min);
        int i15 = i10 - min2;
        if (a(charSequence, i15, 0)) {
            i15++;
            min2--;
        }
        if (a(charSequence, (i11 + min) - 1, 1)) {
            min--;
        }
        int i16 = min2 + i12 + min;
        if (i12 != i13) {
            charSequence2 = TextUtils.concat(new CharSequence[]{charSequence.subSequence(i15, i15 + min2), charSequence.subSequence(i11, min + i11)});
        } else {
            charSequence2 = charSequence.subSequence(i15, i16 + i15);
        }
        int i17 = min2 + 0;
        f(editorInfo, charSequence2, i17, i12 + i17);
    }
}
