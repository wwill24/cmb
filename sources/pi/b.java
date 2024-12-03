package pi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.withpersona.sdk2.inquiry.permissions.d;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f33756a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f33757b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Flow f33758c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f33759d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Button f33760e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Button f33761f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final View f33762g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f33763h;

    private b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ConstraintLayout constraintLayout, @NonNull Flow flow, @NonNull TextView textView, @NonNull Button button, @NonNull Button button2, @NonNull View view, @NonNull TextView textView2) {
        this.f33756a = coordinatorLayout;
        this.f33757b = constraintLayout;
        this.f33758c = flow;
        this.f33759d = textView;
        this.f33760e = button;
        this.f33761f = button2;
        this.f33762g = view;
        this.f33763h = textView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.withpersona.sdk2.inquiry.permissions.c.tint_screen;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static pi.b a(@androidx.annotation.NonNull android.view.View r11) {
        /*
            int r0 = com.withpersona.sdk2.inquiry.permissions.c.bottom_sheet
            android.view.View r1 = z1.b.a(r11, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x0054
            int r0 = com.withpersona.sdk2.inquiry.permissions.c.flow_layout
            android.view.View r1 = z1.b.a(r11, r0)
            r5 = r1
            androidx.constraintlayout.helper.widget.Flow r5 = (androidx.constraintlayout.helper.widget.Flow) r5
            if (r5 == 0) goto L_0x0054
            int r0 = com.withpersona.sdk2.inquiry.permissions.c.message
            android.view.View r1 = z1.b.a(r11, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0054
            int r0 = com.withpersona.sdk2.inquiry.permissions.c.negative_button
            android.view.View r1 = z1.b.a(r11, r0)
            r7 = r1
            android.widget.Button r7 = (android.widget.Button) r7
            if (r7 == 0) goto L_0x0054
            int r0 = com.withpersona.sdk2.inquiry.permissions.c.positive_button
            android.view.View r1 = z1.b.a(r11, r0)
            r8 = r1
            android.widget.Button r8 = (android.widget.Button) r8
            if (r8 == 0) goto L_0x0054
            int r0 = com.withpersona.sdk2.inquiry.permissions.c.tint_screen
            android.view.View r9 = z1.b.a(r11, r0)
            if (r9 == 0) goto L_0x0054
            int r0 = com.withpersona.sdk2.inquiry.permissions.c.title
            android.view.View r1 = z1.b.a(r11, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0054
            pi.b r0 = new pi.b
            r3 = r11
            androidx.coordinatorlayout.widget.CoordinatorLayout r3 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0054:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: pi.b.a(android.view.View):pi.b");
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(d.pi2_request_permission_rationale, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f33756a;
    }
}
