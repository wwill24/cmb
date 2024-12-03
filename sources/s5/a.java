package s5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import q5.m;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CheckBox f17480a;

    private a(@NonNull CheckBox checkBox) {
        this.f17480a = checkBox;
    }

    @NonNull
    public static a a(@NonNull View view) {
        if (view != null) {
            return new a((CheckBox) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(m.cmb_radio_group_checkbox, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public CheckBox getRoot() {
        return this.f17480a;
    }
}
