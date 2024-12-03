package zb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import z1.b;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f42223a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f42224b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f42225c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f42226d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f42227e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f42228f;

    private a(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2) {
        this.f42223a = constraintLayout;
        this.f42224b = recyclerView;
        this.f42225c = frameLayout;
        this.f42226d = imageView;
        this.f42227e = textView;
        this.f42228f = constraintLayout2;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i10 = yb.a.bagels_list;
        RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
        if (recyclerView != null) {
            i10 = yb.a.banner_container;
            FrameLayout frameLayout = (FrameLayout) b.a(view, i10);
            if (frameLayout != null) {
                i10 = yb.a.empty_history_image;
                ImageView imageView = (ImageView) b.a(view, i10);
                if (imageView != null) {
                    i10 = yb.a.empty_history_title;
                    TextView textView = (TextView) b.a(view, i10);
                    if (textView != null) {
                        i10 = yb.a.history_empty_state;
                        ConstraintLayout constraintLayout = (ConstraintLayout) b.a(view, i10);
                        if (constraintLayout != null) {
                            return new a((ConstraintLayout) view, recyclerView, frameLayout, imageView, textView, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(yb.b.bagels_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f42223a;
    }
}
