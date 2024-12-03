package si;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.withpersona.sdk2.inquiry.selfie.j;
import com.withpersona.sdk2.inquiry.selfie.view.CircleMaskView;
import com.withpersona.sdk2.inquiry.selfie.view.ProgressArcView;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import org.jivesoftware.smack.packet.Message;
import z1.a;

public final class c implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f33828a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final View f33829b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CircleMaskView f33830c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ThemeableLottieAnimationView f33831d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f33832e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f33833f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final View f33834g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ProgressArcView f33835h;

    private c(@NonNull View view, @NonNull View view2, @NonNull CircleMaskView circleMaskView, @NonNull ThemeableLottieAnimationView themeableLottieAnimationView, @NonNull ImageView imageView, @NonNull View view3, @NonNull View view4, @NonNull ProgressArcView progressArcView) {
        this.f33828a = view;
        this.f33829b = view2;
        this.f33830c = circleMaskView;
        this.f33831d = themeableLottieAnimationView;
        this.f33832e = imageView;
        this.f33833f = view3;
        this.f33834g = view4;
        this.f33835h = progressArcView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r0 = com.withpersona.sdk2.inquiry.selfie.i.image_overlay_view;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r0 = com.withpersona.sdk2.inquiry.selfie.i.hint_overlay_view;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static si.c a(@androidx.annotation.NonNull android.view.View r10) {
        /*
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.blinds_view
            android.view.View r3 = z1.b.a(r10, r0)
            if (r3 == 0) goto L_0x004c
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.circle_mask
            android.view.View r1 = z1.b.a(r10, r0)
            r4 = r1
            com.withpersona.sdk2.inquiry.selfie.view.CircleMaskView r4 = (com.withpersona.sdk2.inquiry.selfie.view.CircleMaskView) r4
            if (r4 == 0) goto L_0x004c
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.hint_animation
            android.view.View r1 = z1.b.a(r10, r0)
            r5 = r1
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r5 = (com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView) r5
            if (r5 == 0) goto L_0x004c
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.hint_image
            android.view.View r1 = z1.b.a(r10, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x004c
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.hint_overlay_view
            android.view.View r7 = z1.b.a(r10, r0)
            if (r7 == 0) goto L_0x004c
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.image_overlay_view
            android.view.View r8 = z1.b.a(r10, r0)
            if (r8 == 0) goto L_0x004c
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.progress_arc
            android.view.View r1 = z1.b.a(r10, r0)
            r9 = r1
            com.withpersona.sdk2.inquiry.selfie.view.ProgressArcView r9 = (com.withpersona.sdk2.inquiry.selfie.view.ProgressArcView) r9
            if (r9 == 0) goto L_0x004c
            si.c r0 = new si.c
            r1 = r0
            r2 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x004c:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: si.c.a(android.view.View):si.c");
    }

    @NonNull
    public static c b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(j.pi2_selfie_overlay, viewGroup);
            return a(viewGroup);
        }
        throw new NullPointerException(Message.Thread.PARENT_ATTRIBUTE_NAME);
    }

    @NonNull
    public View getRoot() {
        return this.f33828a;
    }
}
