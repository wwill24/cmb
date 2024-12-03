package aj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.withpersona.sdk2.inquiry.steps.ui.g;
import com.withpersona.sdk2.inquiry.steps.ui.h;
import z1.a;
import z1.b;

public final class k implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f24865a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final RadioGroup f24866b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f24867c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f24868d;

    private k(@NonNull LinearLayout linearLayout, @NonNull RadioGroup radioGroup, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f24865a = linearLayout;
        this.f24866b = radioGroup;
        this.f24867c = textView;
        this.f24868d = textView2;
    }

    @NonNull
    public static k a(@NonNull View view) {
        int i10 = g.radio_group;
        RadioGroup radioGroup = (RadioGroup) b.a(view, i10);
        if (radioGroup != null) {
            i10 = g.radio_group_error;
            TextView textView = (TextView) b.a(view, i10);
            if (textView != null) {
                i10 = g.radio_group_label;
                TextView textView2 = (TextView) b.a(view, i10);
                if (textView2 != null) {
                    return new k((LinearLayout) view, radioGroup, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static k c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static k d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.pi2_ui_input_radio_group, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f24865a;
    }
}
