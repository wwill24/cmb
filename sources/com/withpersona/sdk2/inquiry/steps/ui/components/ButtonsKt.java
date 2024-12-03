package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.content.Context;
import android.util.AttributeSet;
import cj.b;
import com.google.android.material.button.MaterialButton;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;
import ti.e;

public final class ButtonsKt {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27562a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$Button$ButtonType[] r0 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Button.ButtonType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$Button$ButtonType r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Button.ButtonType.PRIMARY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$Button$ButtonType r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.Button.ButtonType.SECONDARY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f27562a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.components.ButtonsKt.a.<clinit>():void");
        }
    }

    public static final MaterialButton b(Context context, UiComponent.Button button) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(button, "component");
        com.withpersona.sdk2.inquiry.steps.ui.network.styling.a D = button.D();
        if (D != null) {
            MaterialButton materialButton = new MaterialButton(context);
            UiComponent.Button.Attributes B = button.z();
            if (B != null) {
                materialButton.setText(B.f());
            }
            k.b(materialButton, new ButtonsKt$buttonView$1$1(materialButton, D));
            return materialButton;
        }
        MaterialButton materialButton2 = new MaterialButton(context, (AttributeSet) null, d(button));
        UiComponent.Button.Attributes B2 = button.z();
        if (B2 != null) {
            materialButton2.setText(B2.f());
        }
        return materialButton2;
    }

    public static final b c(Context context, UiComponent.Button button) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(button, "component");
        com.withpersona.sdk2.inquiry.steps.ui.network.styling.a D = button.D();
        if (D != null) {
            b bVar = new b(context, D);
            UiComponent.Button.Attributes B = button.z();
            if (B != null) {
                bVar.setText(B.f());
            }
            k.b(bVar, new ButtonsKt$buttonViewWithLoadingIndicator$1$1(bVar, D));
            return bVar;
        }
        b bVar2 = new b(context, d(button));
        UiComponent.Button.Attributes B2 = button.z();
        if (B2 != null) {
            bVar2.setText(B2.f());
        }
        return bVar2;
    }

    private static final int d(UiComponent.Button button) {
        UiComponent.Button.ButtonType buttonType;
        int i10;
        UiComponent.Button.Attributes B = button.z();
        if (B != null) {
            buttonType = B.e();
        } else {
            buttonType = null;
        }
        if (buttonType == null) {
            i10 = -1;
        } else {
            i10 = a.f27562a[buttonType.ordinal()];
        }
        if (i10 == -1) {
            return e.materialButtonStyle;
        }
        if (i10 == 1) {
            return e.materialButtonStyle;
        }
        if (i10 == 2) {
            return e.materialButtonStyleSecondary;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public static final void e(b bVar, com.withpersona.sdk2.inquiry.steps.ui.network.styling.a aVar) {
        ButtonStylingKt.c(bVar.getButton(), aVar, false, false, 6, (Object) null);
    }
}
