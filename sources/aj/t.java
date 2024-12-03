package aj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.withpersona.sdk2.inquiry.steps.ui.h;
import z1.a;

public final class t implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextView f24890a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextView f24891b;

    private t(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f24890a = textView;
        this.f24891b = textView2;
    }

    @NonNull
    public static t a(@NonNull View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new t(textView, textView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static t c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static t d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.pi2_ui_title, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public TextView getRoot() {
        return this.f24890a;
    }
}
