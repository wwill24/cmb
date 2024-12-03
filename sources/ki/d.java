package ki;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.withpersona.sdk2.inquiry.governmentid.m0;
import com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar;
import z1.a;

public final class d implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f31960a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f31961b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f31962c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Pi2NavigationBar f31963d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f31964e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f31965f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f31966g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f31967h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f31968j;

    private d(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull Pi2NavigationBar pi2NavigationBar, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f31960a = coordinatorLayout;
        this.f31961b = imageView;
        this.f31962c = view;
        this.f31963d = pi2NavigationBar;
        this.f31964e = recyclerView;
        this.f31965f = textView;
        this.f31966g = textView2;
        this.f31967h = textView3;
        this.f31968j = textView4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.withpersona.sdk2.inquiry.governmentid.l0.list_divider;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ki.d a(@androidx.annotation.NonNull android.view.View r12) {
        /*
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.imageview_governmentid_header_image
            android.view.View r1 = z1.b.a(r12, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x005f
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.list_divider
            android.view.View r5 = z1.b.a(r12, r0)
            if (r5 == 0) goto L_0x005f
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.navigation_bar
            android.view.View r1 = z1.b.a(r12, r0)
            r6 = r1
            com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar r6 = (com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar) r6
            if (r6 == 0) goto L_0x005f
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.recyclerview_governmentid_idlist
            android.view.View r1 = z1.b.a(r12, r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x005f
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.textview_governmentid_instructions_body
            android.view.View r1 = z1.b.a(r12, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x005f
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.textview_governmentid_instructions_disclaimer
            android.view.View r1 = z1.b.a(r12, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x005f
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.textview_governmentid_instructions_title
            android.view.View r1 = z1.b.a(r12, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x005f
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.textview_governmentid_instructionslistheader
            android.view.View r1 = z1.b.a(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x005f
            ki.d r0 = new ki.d
            r3 = r12
            androidx.coordinatorlayout.widget.CoordinatorLayout r3 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x005f:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ki.d.a(android.view.View):ki.d");
    }

    @NonNull
    public static d c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(m0.pi2_governmentid_instructions, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f31960a;
    }
}
