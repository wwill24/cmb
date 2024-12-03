package aj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.withpersona.sdk2.inquiry.steps.ui.h;
import z1.a;

public final class f implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f24853a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Guideline f24854b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f24855c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Guideline f24856d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final View f24857e;

    private f(@NonNull ConstraintLayout constraintLayout, @NonNull Guideline guideline, @NonNull ConstraintLayout constraintLayout2, @NonNull Guideline guideline2, @NonNull View view) {
        this.f24853a = constraintLayout;
        this.f24854b = guideline;
        this.f24855c = constraintLayout2;
        this.f24856d = guideline2;
        this.f24857e = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        r0 = com.withpersona.sdk2.inquiry.steps.ui.g.hairline;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static aj.f a(@androidx.annotation.NonNull android.view.View r8) {
        /*
            int r0 = com.withpersona.sdk2.inquiry.steps.ui.g.footer_begin_margin
            android.view.View r1 = z1.b.a(r8, r0)
            r4 = r1
            androidx.constraintlayout.widget.Guideline r4 = (androidx.constraintlayout.widget.Guideline) r4
            if (r4 == 0) goto L_0x0029
            r5 = r8
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            int r0 = com.withpersona.sdk2.inquiry.steps.ui.g.footer_end_margin
            android.view.View r1 = z1.b.a(r8, r0)
            r6 = r1
            androidx.constraintlayout.widget.Guideline r6 = (androidx.constraintlayout.widget.Guideline) r6
            if (r6 == 0) goto L_0x0029
            int r0 = com.withpersona.sdk2.inquiry.steps.ui.g.hairline
            android.view.View r7 = z1.b.a(r8, r0)
            if (r7 == 0) goto L_0x0029
            aj.f r8 = new aj.f
            r2 = r8
            r3 = r5
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        L_0x0029:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: aj.f.a(android.view.View):aj.f");
    }

    @NonNull
    public static f c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static f d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.pi2_ui_footer, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f24853a;
    }
}
