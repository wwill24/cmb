package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import com.coffeemeetsbagel.R;
import com.google.android.material.appbar.AppBarLayout;
import z1.a;
import z1.b;

public final class c implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f15707a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final AppBarLayout f15708b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ViewPager2 f15709c;

    private c(@NonNull LinearLayout linearLayout, @NonNull AppBarLayout appBarLayout, @NonNull ViewPager2 viewPager2) {
        this.f15707a = linearLayout;
        this.f15708b = appBarLayout;
        this.f15709c = viewPager2;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i10 = R.id.app_bar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) b.a(view, R.id.app_bar_layout);
        if (appBarLayout != null) {
            i10 = R.id.view_pager_2;
            ViewPager2 viewPager2 = (ViewPager2) b.a(view, R.id.view_pager_2);
            if (viewPager2 != null) {
                return new c((LinearLayout) view, appBarLayout, viewPager2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_profile_completion_helper, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f15707a;
    }
}
