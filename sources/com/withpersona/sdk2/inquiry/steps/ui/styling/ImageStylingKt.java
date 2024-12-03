package com.withpersona.sdk2.inquiry.steps.ui.styling;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cj.e;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$RemoteImageJustifyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.j;
import ti.n;

public final class ImageStylingKt {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29238a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType[] r0 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType r1 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.START     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType r1 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.CENTER     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType r1 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.END     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f29238a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.a.<clinit>():void");
        }
    }

    public static final void a(ImageView imageView, UiComponent.CombinedStepImagePreview.CombinedStepImagePreviewComponentStyle combinedStepImagePreviewComponentStyle) {
        StyleElements.Size size;
        AttributeStyles$RemoteImageJustifyStyle d10;
        StyleElements.Position a10;
        StyleElements.PositionType a11;
        float f10;
        StyleElements.DPSizeSet f11;
        j.g(imageView, "<this>");
        if (!(combinedStepImagePreviewComponentStyle == null || (f11 = combinedStepImagePreviewComponentStyle.f()) == null)) {
            e.c(imageView, f11);
        }
        StyleElements.Size size2 = null;
        if (combinedStepImagePreviewComponentStyle != null) {
            size = combinedStepImagePreviewComponentStyle.h();
        } else {
            size = null;
        }
        e.b(imageView, size);
        if (combinedStepImagePreviewComponentStyle != null) {
            size2 = combinedStepImagePreviewComponentStyle.c();
        }
        e.a(imageView, size2);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (!(combinedStepImagePreviewComponentStyle == null || (d10 = combinedStepImagePreviewComponentStyle.d()) == null || (a10 = d10.a()) == null || (a11 = a10.a()) == null || !(layoutParams instanceof ConstraintLayout.b))) {
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            int i10 = a.f29238a[a11.ordinal()];
            if (i10 == 1) {
                f10 = 0.0f;
            } else if (i10 == 2) {
                f10 = 0.5f;
            } else if (i10 == 3) {
                f10 = 1.0f;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            bVar.G = f10;
        }
        imageView.setLayoutParams(layoutParams);
    }

    public static final void b(ThemeableLottieAnimationView themeableLottieAnimationView, LocalImageComponentStyle localImageComponentStyle, String[] strArr, String[] strArr2, String[] strArr3) {
        String str;
        String str2;
        j.g(themeableLottieAnimationView, "<this>");
        j.g(strArr, "originalStrokeColors");
        j.g(strArr2, "originalFillColors");
        j.g(strArr3, "originalBackgroundColors");
        String str3 = null;
        if (localImageComponentStyle != null) {
            str = localImageComponentStyle.C();
        } else {
            str = null;
        }
        if (localImageComponentStyle != null) {
            str2 = localImageComponentStyle.A0();
        } else {
            str2 = null;
        }
        if (localImageComponentStyle != null) {
            str3 = localImageComponentStyle.V1();
        }
        e(themeableLottieAnimationView, str, str2, str3, strArr, strArr2, strArr3);
        k.b(themeableLottieAnimationView, new ImageStylingKt$applyStyle$1(localImageComponentStyle, themeableLottieAnimationView));
    }

    public static final void c(ImageView imageView, UiComponent.RemoteImage remoteImage) {
        Unit unit;
        float f10;
        j.g(imageView, "<this>");
        j.g(remoteImage, "component");
        StyleElements.DPSizeSet F = remoteImage.F();
        if (F != null) {
            e.c(imageView, F);
        }
        e.b(imageView, remoteImage.H());
        e.a(imageView, remoteImage.D());
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        StyleElements.PositionType E = remoteImage.E();
        float f11 = 0.5f;
        if (E != null) {
            if (layoutParams instanceof ConstraintLayout.b) {
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                int i10 = a.f29238a[E.ordinal()];
                if (i10 == 1) {
                    f10 = 0.0f;
                } else if (i10 == 2) {
                    f10 = 0.5f;
                } else if (i10 == 3) {
                    f10 = 1.0f;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                bVar.G = f10;
            }
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null && (layoutParams instanceof ConstraintLayout.b)) {
            ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams;
            Context context = imageView.getContext();
            j.f(context, "this@applyStyles.context");
            if (!n.b(context, ti.e.personaCenterAlignRemoteAsset, (TypedValue) null, false, 6, (Object) null)) {
                f11 = 0.0f;
            }
            bVar2.G = f11;
        }
        imageView.setLayoutParams(layoutParams);
    }

    public static final void d(ThemeableLottieAnimationView themeableLottieAnimationView, Integer num, Integer num2, Integer num3, String[] strArr, String[] strArr2, String[] strArr3) {
        j.g(themeableLottieAnimationView, "<this>");
        j.g(strArr, "originalStrokeColors");
        j.g(strArr2, "originalFillColors");
        j.g(strArr3, "originalBackgroundColors");
        if (num != null) {
            int intValue = num.intValue();
            for (String parseColor : strArr) {
                themeableLottieAnimationView.I(Color.parseColor(parseColor), intValue);
            }
        }
        if (num2 != null) {
            int intValue2 = num2.intValue();
            for (String parseColor2 : strArr2) {
                themeableLottieAnimationView.I(Color.parseColor(parseColor2), intValue2);
            }
        }
        if (num3 != null) {
            int intValue3 = num3.intValue();
            for (String parseColor3 : strArr3) {
                themeableLottieAnimationView.I(Color.parseColor(parseColor3), intValue3);
            }
        }
    }

    public static final void e(ThemeableLottieAnimationView themeableLottieAnimationView, String str, String str2, String str3, String[] strArr, String[] strArr2, String[] strArr3) {
        Integer num;
        Integer num2;
        j.g(themeableLottieAnimationView, "<this>");
        j.g(strArr, "originalStrokeColors");
        j.g(strArr2, "originalFillColors");
        j.g(strArr3, "originalBackgroundColors");
        Integer num3 = null;
        if (str != null) {
            num = Integer.valueOf(f(str));
        } else {
            num = null;
        }
        if (str2 != null) {
            num2 = Integer.valueOf(f(str2));
        } else {
            num2 = null;
        }
        if (str3 != null) {
            num3 = Integer.valueOf(f(str3));
        }
        d(themeableLottieAnimationView, num, num2, num3, strArr, strArr2, strArr3);
    }

    private static final int f(String str) {
        return Color.parseColor(str);
    }
}
