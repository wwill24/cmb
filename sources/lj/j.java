package lj;

import android.text.Spannable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<TextView> f32777a;

    public j(@NonNull TextView textView) {
        this.f32777a = new WeakReference<>(textView);
    }

    public static void a(@NonNull Spannable spannable, @NonNull TextView textView) {
        j[] jVarArr = (j[]) spannable.getSpans(0, spannable.length(), j.class);
        if (jVarArr != null) {
            for (j removeSpan : jVarArr) {
                spannable.removeSpan(removeSpan);
            }
        }
        spannable.setSpan(new j(textView), 0, spannable.length(), 18);
    }
}
