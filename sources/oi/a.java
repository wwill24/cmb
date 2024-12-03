package oi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.withpersona.sdk2.inquiry.modal.g;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f32811a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f32812b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f32813c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Flow f32814d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f32815e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f32816f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final Button f32817g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final View f32818h;

    private a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull Flow flow, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Button button2, @NonNull View view) {
        this.f32811a = coordinatorLayout;
        this.f32812b = constraintLayout;
        this.f32813c = button;
        this.f32814d = flow;
        this.f32815e = textView;
        this.f32816f = textView2;
        this.f32817g = button2;
        this.f32818h = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r0 = com.withpersona.sdk2.inquiry.modal.f.tint_screen;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static oi.a a(@androidx.annotation.NonNull android.view.View r11) {
        /*
            int r0 = com.withpersona.sdk2.inquiry.modal.f.bottom_sheet
            android.view.View r1 = z1.b.a(r11, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x0054
            int r0 = com.withpersona.sdk2.inquiry.modal.f.close_button
            android.view.View r1 = z1.b.a(r11, r0)
            r5 = r1
            android.widget.Button r5 = (android.widget.Button) r5
            if (r5 == 0) goto L_0x0054
            int r0 = com.withpersona.sdk2.inquiry.modal.f.flow_layout
            android.view.View r1 = z1.b.a(r11, r0)
            r6 = r1
            androidx.constraintlayout.helper.widget.Flow r6 = (androidx.constraintlayout.helper.widget.Flow) r6
            if (r6 == 0) goto L_0x0054
            int r0 = com.withpersona.sdk2.inquiry.modal.f.hintMessage
            android.view.View r1 = z1.b.a(r11, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0054
            int r0 = com.withpersona.sdk2.inquiry.modal.f.hintTitle
            android.view.View r1 = z1.b.a(r11, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0054
            int r0 = com.withpersona.sdk2.inquiry.modal.f.retry_button
            android.view.View r1 = z1.b.a(r11, r0)
            r9 = r1
            android.widget.Button r9 = (android.widget.Button) r9
            if (r9 == 0) goto L_0x0054
            int r0 = com.withpersona.sdk2.inquiry.modal.f.tint_screen
            android.view.View r10 = z1.b.a(r11, r0)
            if (r10 == 0) goto L_0x0054
            oi.a r0 = new oi.a
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
        throw new UnsupportedOperationException("Method not decompiled: oi.a.a(android.view.View):oi.a");
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(g.pi2_cancel_modal, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f32811a;
    }
}
