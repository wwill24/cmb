package ub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.store.o0;
import z1.a;

public final class g implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f41989a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextView f41990b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f41991c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f41992d;

    private g(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull View view, @NonNull TextView textView2) {
        this.f41989a = relativeLayout;
        this.f41990b = textView;
        this.f41991c = view;
        this.f41992d = textView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.coffeemeetsbagel.store.n0.partial_profile_holder_divider;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ub.g a(@androidx.annotation.NonNull android.view.View r4) {
        /*
            int r0 = com.coffeemeetsbagel.store.n0.first_bundle_price
            android.view.View r1 = z1.b.a(r4, r0)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0024
            int r0 = com.coffeemeetsbagel.store.n0.partial_profile_holder_divider
            android.view.View r2 = z1.b.a(r4, r0)
            if (r2 == 0) goto L_0x0024
            int r0 = com.coffeemeetsbagel.store.n0.second_bundle_price
            android.view.View r3 = z1.b.a(r4, r0)
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r3 == 0) goto L_0x0024
            ub.g r0 = new ub.g
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r0.<init>(r4, r1, r2, r3)
            return r0
        L_0x0024:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.g.a(android.view.View):ub.g");
    }

    @NonNull
    public static g c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(o0.subscription_comparison_price, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f41989a;
    }
}
