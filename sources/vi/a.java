package vi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import ti.i;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f33895a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f33896b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f33897c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final NestedScrollView f33898d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final View f33899e;

    private a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull NestedScrollView nestedScrollView, @NonNull View view) {
        this.f33895a = coordinatorLayout;
        this.f33896b = constraintLayout;
        this.f33897c = frameLayout;
        this.f33898d = nestedScrollView;
        this.f33899e = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = ti.h.tint_screen;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static vi.a a(@androidx.annotation.NonNull android.view.View r8) {
        /*
            int r0 = ti.h.bottom_sheet
            android.view.View r1 = z1.b.a(r8, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x0033
            int r0 = ti.h.content_container
            android.view.View r1 = z1.b.a(r8, r0)
            r5 = r1
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            if (r5 == 0) goto L_0x0033
            int r0 = ti.h.content_scroll_view
            android.view.View r1 = z1.b.a(r8, r0)
            r6 = r1
            androidx.core.widget.NestedScrollView r6 = (androidx.core.widget.NestedScrollView) r6
            if (r6 == 0) goto L_0x0033
            int r0 = ti.h.tint_screen
            android.view.View r7 = z1.b.a(r8, r0)
            if (r7 == 0) goto L_0x0033
            vi.a r0 = new vi.a
            r3 = r8
            androidx.coordinatorlayout.widget.CoordinatorLayout r3 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x0033:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: vi.a.a(android.view.View):vi.a");
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.pi2_generic_ui_step_bottom_sheet, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f33895a;
    }
}
