package da;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.likes_you.r0;
import com.coffeemeetsbagel.likes_you.s0;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f40563a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextView f40564b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f40565c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f40566d;

    private b(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f40563a = constraintLayout;
        this.f40564b = textView;
        this.f40565c = textView2;
        this.f40566d = textView3;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i10 = r0.edit_prefs_card_cta;
        TextView textView = (TextView) z1.b.a(view, i10);
        if (textView != null) {
            i10 = r0.edit_prefs_card_text;
            TextView textView2 = (TextView) z1.b.a(view, i10);
            if (textView2 != null) {
                i10 = r0.edit_prefs_card_title;
                TextView textView3 = (TextView) z1.b.a(view, i10);
                if (textView3 != null) {
                    return new b((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(s0.likes_you_edit_prefs_card, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f40563a;
    }
}
