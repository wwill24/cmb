package da;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.likes_you.r0;
import com.coffeemeetsbagel.likes_you.s0;
import com.google.android.material.tabs.TabLayout;
import z1.b;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f40552a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f40553b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbButton f40554c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f40555d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f40556e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f40557f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ProgressBar f40558g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final RecyclerView f40559h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TabLayout f40560j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final FrameLayout f40561k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final CmbButton f40562l;

    private a(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull CmbButton cmbButton, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull ProgressBar progressBar, @NonNull RecyclerView recyclerView, @NonNull TabLayout tabLayout, @NonNull FrameLayout frameLayout, @NonNull CmbButton cmbButton2) {
        this.f40552a = constraintLayout;
        this.f40553b = constraintLayout2;
        this.f40554c = cmbButton;
        this.f40555d = textView;
        this.f40556e = imageView;
        this.f40557f = textView2;
        this.f40558g = progressBar;
        this.f40559h = recyclerView;
        this.f40560j = tabLayout;
        this.f40561k = frameLayout;
        this.f40562l = cmbButton2;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i10 = r0.empty_state_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) b.a(view, i10);
        if (constraintLayout != null) {
            i10 = r0.empty_state_cta;
            CmbButton cmbButton = (CmbButton) b.a(view, i10);
            if (cmbButton != null) {
                i10 = r0.empty_state_description;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    i10 = r0.empty_state_image;
                    ImageView imageView = (ImageView) b.a(view, i10);
                    if (imageView != null) {
                        i10 = r0.empty_state_title;
                        TextView textView2 = (TextView) b.a(view, i10);
                        if (textView2 != null) {
                            i10 = r0.loader;
                            ProgressBar progressBar = (ProgressBar) b.a(view, i10);
                            if (progressBar != null) {
                                i10 = r0.recycler_view;
                                RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
                                if (recyclerView != null) {
                                    i10 = r0.tab_layout_v2;
                                    TabLayout tabLayout = (TabLayout) b.a(view, i10);
                                    if (tabLayout != null) {
                                        i10 = r0.tabs_container;
                                        FrameLayout frameLayout = (FrameLayout) b.a(view, i10);
                                        if (frameLayout != null) {
                                            i10 = r0.upsell_cta;
                                            CmbButton cmbButton2 = (CmbButton) b.a(view, i10);
                                            if (cmbButton2 != null) {
                                                return new a((ConstraintLayout) view, constraintLayout, cmbButton, textView, imageView, textView2, progressBar, recyclerView, tabLayout, frameLayout, cmbButton2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(s0.fragment_likes_you, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f40552a;
    }
}
