package ia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.match_prefs.g;
import com.coffeemeetsbagel.match_prefs.h;
import z1.b;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f40926a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextView f40927b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f40928c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f40929d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f40930e;

    private a(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TextView textView3) {
        this.f40926a = constraintLayout;
        this.f40927b = textView;
        this.f40928c = textView2;
        this.f40929d = imageView;
        this.f40930e = textView3;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i10 = g.body;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = g.cta;
            TextView textView2 = (TextView) b.a(view, i10);
            if (textView2 != null) {
                i10 = g.illustration;
                ImageView imageView = (ImageView) b.a(view, i10);
                if (imageView != null) {
                    i10 = g.title;
                    TextView textView3 = (TextView) b.a(view, i10);
                    if (textView3 != null) {
                        return new a((ConstraintLayout) view, textView, textView2, imageView, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.match_pref_dealbreakers_bottom_sheet, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f40926a;
    }
}
