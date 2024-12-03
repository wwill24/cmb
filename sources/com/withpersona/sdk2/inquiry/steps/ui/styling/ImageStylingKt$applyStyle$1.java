package com.withpersona.sdk2.inquiry.steps.ui.styling;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import cj.e;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$LocalImageJustifyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class ImageStylingKt$applyStyle$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LocalImageComponentStyle $styles;
    final /* synthetic */ ThemeableLottieAnimationView $this_applyStyle;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29239a;

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
                f29239a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt$applyStyle$1.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageStylingKt$applyStyle$1(LocalImageComponentStyle localImageComponentStyle, ThemeableLottieAnimationView themeableLottieAnimationView) {
        super(0);
        this.$styles = localImageComponentStyle;
        this.$this_applyStyle = themeableLottieAnimationView;
    }

    public final void invoke() {
        AttributeStyles$LocalImageJustifyStyle e10;
        StyleElements.Position a10;
        StyleElements.PositionType a11;
        float f10;
        StyleElements.DPSizeSet g10;
        LocalImageComponentStyle localImageComponentStyle = this.$styles;
        if (!(localImageComponentStyle == null || (g10 = localImageComponentStyle.g()) == null)) {
            e.c(this.$this_applyStyle, g10);
        }
        ThemeableLottieAnimationView themeableLottieAnimationView = this.$this_applyStyle;
        LocalImageComponentStyle localImageComponentStyle2 = this.$styles;
        StyleElements.Size size = null;
        e.b(themeableLottieAnimationView, localImageComponentStyle2 != null ? localImageComponentStyle2.j() : null);
        ThemeableLottieAnimationView themeableLottieAnimationView2 = this.$this_applyStyle;
        LocalImageComponentStyle localImageComponentStyle3 = this.$styles;
        if (localImageComponentStyle3 != null) {
            size = localImageComponentStyle3.d();
        }
        e.a(themeableLottieAnimationView2, size);
        ThemeableLottieAnimationView themeableLottieAnimationView3 = this.$this_applyStyle;
        ViewGroup.LayoutParams layoutParams = themeableLottieAnimationView3.getLayoutParams();
        LocalImageComponentStyle localImageComponentStyle4 = this.$styles;
        if (!(localImageComponentStyle4 == null || (e10 = localImageComponentStyle4.e()) == null || (a10 = e10.a()) == null || (a11 = a10.a()) == null || !(layoutParams instanceof ConstraintLayout.b))) {
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            int i10 = a.f29239a[a11.ordinal()];
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
        themeableLottieAnimationView3.setLayoutParams(layoutParams);
    }
}
