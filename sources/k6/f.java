package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.ExpandingView;
import com.google.android.material.chip.ChipGroup;
import z1.a;
import z1.b;

public final class f implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ExpandingView f15737a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ChipGroup f15738b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f15739c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f15740d;

    private f(@NonNull ExpandingView expandingView, @NonNull ChipGroup chipGroup, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f15737a = expandingView;
        this.f15738b = chipGroup;
        this.f15739c = textView;
        this.f15740d = textView2;
    }

    @NonNull
    public static f a(@NonNull View view) {
        int i10 = R.id.chip_group;
        ChipGroup chipGroup = (ChipGroup) b.a(view, R.id.chip_group);
        if (chipGroup != null) {
            i10 = R.id.hide_expand_button;
            TextView textView = (TextView) b.a(view, R.id.hide_expand_button);
            if (textView != null) {
                i10 = R.id.title;
                TextView textView2 = (TextView) b.a(view, R.id.title);
                if (textView2 != null) {
                    return new f((ExpandingView) view, chipGroup, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static f c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static f d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.chip_select_question_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ExpandingView getRoot() {
        return this.f15737a;
    }
}
