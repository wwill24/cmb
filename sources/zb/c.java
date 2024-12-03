package zb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import z1.a;
import z1.b;

public final class c implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f42237a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f42238b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f42239c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f42240d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f42241e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f42242f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f42243g;

    private c(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2) {
        this.f42237a = cardView;
        this.f42238b = imageView;
        this.f42239c = textView;
        this.f42240d = textView2;
        this.f42241e = textView3;
        this.f42242f = linearLayout;
        this.f42243g = imageView2;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i10 = yb.a.avatar_view;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            i10 = yb.a.bagel_age_city;
            TextView textView = (TextView) b.a(view, i10);
            if (textView != null) {
                i10 = yb.a.bagel_education;
                TextView textView2 = (TextView) b.a(view, i10);
                if (textView2 != null) {
                    i10 = yb.a.bagel_occupation;
                    TextView textView3 = (TextView) b.a(view, i10);
                    if (textView3 != null) {
                        i10 = yb.a.info_layout;
                        LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                        if (linearLayout != null) {
                            i10 = yb.a.stamp_view;
                            ImageView imageView2 = (ImageView) b.a(view, i10);
                            if (imageView2 != null) {
                                return new c((CardView) view, imageView, textView, textView2, textView3, linearLayout, imageView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(yb.b.recycler_view_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public CardView getRoot() {
        return this.f42237a;
    }
}
