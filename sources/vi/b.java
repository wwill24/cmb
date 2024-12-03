package vi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar;
import ti.h;
import ti.i;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f33900a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f33901b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final NestedScrollView f33902c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f33903d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Pi2NavigationBar f33904e;

    private b(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull NestedScrollView nestedScrollView, @NonNull FrameLayout frameLayout2, @NonNull Pi2NavigationBar pi2NavigationBar) {
        this.f33900a = constraintLayout;
        this.f33901b = frameLayout;
        this.f33902c = nestedScrollView;
        this.f33903d = frameLayout2;
        this.f33904e = pi2NavigationBar;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i10 = h.content_container;
        FrameLayout frameLayout = (FrameLayout) z1.b.a(view, i10);
        if (frameLayout != null) {
            i10 = h.content_scroll_view;
            NestedScrollView nestedScrollView = (NestedScrollView) z1.b.a(view, i10);
            if (nestedScrollView != null) {
                i10 = h.footer_container;
                FrameLayout frameLayout2 = (FrameLayout) z1.b.a(view, i10);
                if (frameLayout2 != null) {
                    i10 = h.navigation_bar;
                    Pi2NavigationBar pi2NavigationBar = (Pi2NavigationBar) z1.b.a(view, i10);
                    if (pi2NavigationBar != null) {
                        return new b((ConstraintLayout) view, frameLayout, nestedScrollView, frameLayout2, pi2NavigationBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.pi2_generic_ui_step_screen, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f33900a;
    }
}
