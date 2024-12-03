package ub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.store.o0;
import z1.a;

public final class e implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f41978a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextView f41979b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f41980c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f41981d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final View f41982e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f41983f;

    private e(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull View view, @NonNull ImageView imageView2) {
        this.f41978a = relativeLayout;
        this.f41979b = textView;
        this.f41980c = relativeLayout2;
        this.f41981d = imageView;
        this.f41982e = view;
        this.f41983f = imageView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        r0 = com.coffeemeetsbagel.store.n0.partial_profile_holder_divider;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ub.e a(@androidx.annotation.NonNull android.view.View r9) {
        /*
            int r0 = com.coffeemeetsbagel.store.n0.benefit_title
            android.view.View r1 = z1.b.a(r9, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0034
            r5 = r9
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            int r0 = com.coffeemeetsbagel.store.n0.first_bundle_check
            android.view.View r1 = z1.b.a(r9, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0034
            int r0 = com.coffeemeetsbagel.store.n0.partial_profile_holder_divider
            android.view.View r7 = z1.b.a(r9, r0)
            if (r7 == 0) goto L_0x0034
            int r0 = com.coffeemeetsbagel.store.n0.second_bundle_check
            android.view.View r1 = z1.b.a(r9, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0034
            ub.e r9 = new ub.e
            r2 = r9
            r3 = r5
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r9
        L_0x0034:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.e.a(android.view.View):ub.e");
    }

    @NonNull
    public static e c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(o0.subscription_comparison_benefit, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f41978a;
    }
}
