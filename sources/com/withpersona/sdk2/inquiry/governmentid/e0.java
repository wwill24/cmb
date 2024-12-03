package com.withpersona.sdk2.inquiry.governmentid;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.jvm.internal.j;
import ti.n;

public final class e0 {
    public static final GradientDrawable a(Context context, int i10) {
        j.g(context, "<this>");
        float dimension = context.getResources().getDimension(j0.pi2_overlay_corner_radius);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(j0.pi2_overlay_stroke_width);
        int color = context.getResources().getColor(i0.pi2_overlay_stroke_color);
        Integer f10 = n.f(context, i10, (TypedValue) null, false, 6, (Object) null);
        if (f10 != null) {
            int intValue = f10.intValue();
            int[] iArr = p0.Pi2IdFrame;
            j.f(iArr, "Pi2IdFrame");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(intValue, iArr);
            j.f(obtainStyledAttributes, "obtainStyledAttributes(resourceId, attrs)");
            dimension = obtainStyledAttributes.getDimension(p0.Pi2IdFrame_pi2CornerRadius, dimension);
            dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(p0.Pi2IdFrame_pi2StrokeWidth, dimensionPixelSize);
            color = obtainStyledAttributes.getColor(p0.Pi2IdFrame_pi2StrokeColor, color);
            obtainStyledAttributes.recycle();
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setStroke(dimensionPixelSize, color);
        return gradientDrawable;
    }

    public static final f0 b(Context context, GovernmentIdWorkflow.Screen.Overlay overlay) {
        int i10;
        int i11;
        int i12;
        j.g(context, "<this>");
        j.g(overlay, "overlay");
        GovernmentIdWorkflow.Screen.Overlay.Passport passport = GovernmentIdWorkflow.Screen.Overlay.Passport.f25560a;
        if (j.b(overlay, passport)) {
            i10 = n0.pi2_mrz_intro_lottie;
        } else if (j.b(overlay, GovernmentIdWorkflow.Screen.Overlay.Barcode.f25557a)) {
            i10 = n0.pi2_barcode_intro_lottie;
        } else {
            i10 = n0.pi2_id_front_processing_lottie;
        }
        if (j.b(overlay, passport)) {
            i11 = k0.pi2_governmentid_passport_idguide;
        } else if (j.b(overlay, GovernmentIdWorkflow.Screen.Overlay.Barcode.f25557a)) {
            i11 = k0.pi2_governmentid_barcode_idguide;
        } else {
            i11 = k0.pi2_governmentid_face_with_text;
        }
        if (j.b(overlay, passport)) {
            i12 = h0.personaIdFrameMrzGuideAssets;
        } else if (j.b(overlay, GovernmentIdWorkflow.Screen.Overlay.Barcode.f25557a)) {
            i12 = h0.personaIdFrameBarcodeGuideAssets;
        } else {
            i12 = h0.personaIdFrameFrontGuideAssets;
        }
        Integer f10 = n.f(context, i12, (TypedValue) null, false, 6, (Object) null);
        if (f10 != null) {
            int intValue = f10.intValue();
            int[] iArr = p0.Pi2IdFrameGuideAssets;
            j.f(iArr, "Pi2IdFrameGuideAssets");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(intValue, iArr);
            j.f(obtainStyledAttributes, "obtainStyledAttributes(resourceId, attrs)");
            i10 = obtainStyledAttributes.getResourceId(p0.Pi2IdFrameGuideAssets_pi2HintLottieRaw, i10);
            i11 = obtainStyledAttributes.getResourceId(p0.Pi2IdFrameGuideAssets_pi2OverlayDrawable, i11);
            obtainStyledAttributes.recycle();
        }
        return new f0(i10, i11);
    }
}
