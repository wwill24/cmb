package ub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.store.o0;
import z1.a;

public final class f implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f41984a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f41985b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f41986c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final View f41987d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f41988e;

    private f(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView, @NonNull View view, @NonNull TextView textView2) {
        this.f41984a = relativeLayout;
        this.f41985b = relativeLayout2;
        this.f41986c = textView;
        this.f41987d = view;
        this.f41988e = textView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r0 = com.coffeemeetsbagel.store.n0.partial_profile_holder_divider;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ub.f a(@androidx.annotation.NonNull android.view.View r6) {
        /*
            r2 = r6
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            int r0 = com.coffeemeetsbagel.store.n0.first_bundle_name
            android.view.View r1 = z1.b.a(r6, r0)
            r3 = r1
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r3 == 0) goto L_0x0029
            int r0 = com.coffeemeetsbagel.store.n0.partial_profile_holder_divider
            android.view.View r4 = z1.b.a(r6, r0)
            if (r4 == 0) goto L_0x0029
            int r0 = com.coffeemeetsbagel.store.n0.second_bundle_name
            android.view.View r1 = z1.b.a(r6, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0029
            ub.f r6 = new ub.f
            r0 = r6
            r1 = r2
            r0.<init>(r1, r2, r3, r4, r5)
            return r6
        L_0x0029:
            android.content.res.Resources r6 = r6.getResources()
            java.lang.String r6 = r6.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r6 = r1.concat(r6)
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.f.a(android.view.View):ub.f");
    }

    @NonNull
    public static f c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(o0.subscription_comparison_name, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f41984a;
    }
}
