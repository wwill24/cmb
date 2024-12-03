package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.g;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$DocumentStepStyle implements StepStyle {
    public static final Parcelable.Creator<StepStyles$DocumentStepStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AttributeStyles$HeaderButtonColorStyle f28893a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$StepBackgroundColorStyle f28894b;

    /* renamed from: c  reason: collision with root package name */
    private final StepStyles$StepBackgroundImageStyle f28895c;

    /* renamed from: d  reason: collision with root package name */
    private final StepStyles$DocumentStepTitleComponentStyle f28896d;

    /* renamed from: e  reason: collision with root package name */
    private final StepStyles$DocumentStepTextBasedComponentStyle f28897e;

    /* renamed from: f  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyle f28898f;

    /* renamed from: g  reason: collision with root package name */
    private final StepStyles$StepPrimaryButtonComponentStyle f28899g;

    /* renamed from: h  reason: collision with root package name */
    private final StepStyles$StepSecondaryButtonComponentStyle f28900h;

    /* renamed from: j  reason: collision with root package name */
    private final StepStyles$DocumentStepStrokeColor f28901j;

    /* renamed from: k  reason: collision with root package name */
    private final StepStyles$DocumentStepFillColor f28902k;

    /* renamed from: l  reason: collision with root package name */
    private final StepStyles$DocumentStepBorderColor f28903l;

    /* renamed from: m  reason: collision with root package name */
    private final StepStyles$DocumentStepBorderRadius f28904m;

    /* renamed from: n  reason: collision with root package name */
    private final StepStyles$DocumentStepBorderWidth f28905n;

    /* renamed from: p  reason: collision with root package name */
    private final StepStyles$DocumentStepImageLocalStyle f28906p;

    /* renamed from: q  reason: collision with root package name */
    private final StepStyles$StepPaddingStyle f28907q;

    public static final class a implements Parcelable.Creator<StepStyles$DocumentStepStyle> {
        /* renamed from: a */
        public final StepStyles$DocumentStepStyle createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            j.g(parcel2, "parcel");
            StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle = null;
            AttributeStyles$HeaderButtonColorStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$HeaderButtonColorStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$StepBackgroundColorStyle createFromParcel2 = parcel.readInt() == 0 ? null : StepStyles$StepBackgroundColorStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$StepBackgroundImageStyle createFromParcel3 = parcel.readInt() == 0 ? null : StepStyles$StepBackgroundImageStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$DocumentStepTitleComponentStyle createFromParcel4 = parcel.readInt() == 0 ? null : StepStyles$DocumentStepTitleComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$DocumentStepTextBasedComponentStyle createFromParcel5 = parcel.readInt() == 0 ? null : StepStyles$DocumentStepTextBasedComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$StepTextBasedComponentStyle createFromParcel6 = parcel.readInt() == 0 ? null : StepStyles$StepTextBasedComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$StepPrimaryButtonComponentStyle createFromParcel7 = parcel.readInt() == 0 ? null : StepStyles$StepPrimaryButtonComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$StepSecondaryButtonComponentStyle createFromParcel8 = parcel.readInt() == 0 ? null : StepStyles$StepSecondaryButtonComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$DocumentStepStrokeColor createFromParcel9 = parcel.readInt() == 0 ? null : StepStyles$DocumentStepStrokeColor.CREATOR.createFromParcel(parcel2);
            StepStyles$DocumentStepFillColor createFromParcel10 = parcel.readInt() == 0 ? null : StepStyles$DocumentStepFillColor.CREATOR.createFromParcel(parcel2);
            StepStyles$DocumentStepBorderColor createFromParcel11 = parcel.readInt() == 0 ? null : StepStyles$DocumentStepBorderColor.CREATOR.createFromParcel(parcel2);
            StepStyles$DocumentStepBorderRadius createFromParcel12 = parcel.readInt() == 0 ? null : StepStyles$DocumentStepBorderRadius.CREATOR.createFromParcel(parcel2);
            StepStyles$DocumentStepBorderWidth createFromParcel13 = parcel.readInt() == 0 ? null : StepStyles$DocumentStepBorderWidth.CREATOR.createFromParcel(parcel2);
            StepStyles$DocumentStepImageLocalStyle createFromParcel14 = parcel.readInt() == 0 ? null : StepStyles$DocumentStepImageLocalStyle.CREATOR.createFromParcel(parcel2);
            if (parcel.readInt() != 0) {
                stepStyles$StepPaddingStyle = StepStyles$StepPaddingStyle.CREATOR.createFromParcel(parcel2);
            }
            return new StepStyles$DocumentStepStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, createFromParcel9, createFromParcel10, createFromParcel11, createFromParcel12, createFromParcel13, createFromParcel14, stepStyles$StepPaddingStyle);
        }

        /* renamed from: b */
        public final StepStyles$DocumentStepStyle[] newArray(int i10) {
            return new StepStyles$DocumentStepStyle[i10];
        }
    }

    public StepStyles$DocumentStepStyle(@g(name = "textColor") AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle, StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle, StepStyles$StepBackgroundImageStyle stepStyles$StepBackgroundImageStyle, StepStyles$DocumentStepTitleComponentStyle stepStyles$DocumentStepTitleComponentStyle, StepStyles$DocumentStepTextBasedComponentStyle stepStyles$DocumentStepTextBasedComponentStyle, StepStyles$StepTextBasedComponentStyle stepStyles$StepTextBasedComponentStyle, StepStyles$StepPrimaryButtonComponentStyle stepStyles$StepPrimaryButtonComponentStyle, StepStyles$StepSecondaryButtonComponentStyle stepStyles$StepSecondaryButtonComponentStyle, StepStyles$DocumentStepStrokeColor stepStyles$DocumentStepStrokeColor, StepStyles$DocumentStepFillColor stepStyles$DocumentStepFillColor, StepStyles$DocumentStepBorderColor stepStyles$DocumentStepBorderColor, StepStyles$DocumentStepBorderRadius stepStyles$DocumentStepBorderRadius, StepStyles$DocumentStepBorderWidth stepStyles$DocumentStepBorderWidth, StepStyles$DocumentStepImageLocalStyle stepStyles$DocumentStepImageLocalStyle, StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle) {
        this.f28893a = attributeStyles$HeaderButtonColorStyle;
        this.f28894b = stepStyles$StepBackgroundColorStyle;
        this.f28895c = stepStyles$StepBackgroundImageStyle;
        this.f28896d = stepStyles$DocumentStepTitleComponentStyle;
        this.f28897e = stepStyles$DocumentStepTextBasedComponentStyle;
        this.f28898f = stepStyles$StepTextBasedComponentStyle;
        this.f28899g = stepStyles$StepPrimaryButtonComponentStyle;
        this.f28900h = stepStyles$StepSecondaryButtonComponentStyle;
        this.f28901j = stepStyles$DocumentStepStrokeColor;
        this.f28902k = stepStyles$DocumentStepFillColor;
        this.f28903l = stepStyles$DocumentStepBorderColor;
        this.f28904m = stepStyles$DocumentStepBorderRadius;
        this.f28905n = stepStyles$DocumentStepBorderWidth;
        this.f28906p = stepStyles$DocumentStepImageLocalStyle;
        this.f28907q = stepStyles$StepPaddingStyle;
    }

    public final StepStyles$StepPaddingStyle A() {
        return this.f28907q;
    }

    public String A0() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$DocumentStepFillColor stepStyles$DocumentStepFillColor = this.f28902k;
        if (stepStyles$DocumentStepFillColor == null || (a10 = stepStyles$DocumentStepFillColor.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final StepStyles$DocumentStepStrokeColor B() {
        return this.f28901j;
    }

    public String C() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$DocumentStepStrokeColor stepStyles$DocumentStepStrokeColor = this.f28901j;
        if (stepStyles$DocumentStepStrokeColor == null || (a10 = stepStyles$DocumentStepStrokeColor.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final StepStyles$DocumentStepTextBasedComponentStyle D() {
        return this.f28897e;
    }

    public final StepStyles$DocumentStepTitleComponentStyle E() {
        return this.f28896d;
    }

    public TextBasedComponentStyle H1() {
        StepStyles$StepTextBasedComponentStyleContainer a10;
        StepStyles$DocumentStepTextBasedComponentStyle stepStyles$DocumentStepTextBasedComponentStyle = this.f28897e;
        if (stepStyles$DocumentStepTextBasedComponentStyle == null || (a10 = stepStyles$DocumentStepTextBasedComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public StyleElements.DPSize N() {
        StyleElements.DPMeasurement c10;
        StepStyles$DocumentStepBorderRadius stepStyles$DocumentStepBorderRadius = this.f28904m;
        if (stepStyles$DocumentStepBorderRadius == null || (c10 = stepStyles$DocumentStepBorderRadius.c()) == null) {
            return null;
        }
        return c10.a();
    }

    public StyleElements.DPSizeSet T1() {
        StepStyles$StepPaddingStyleContainer a10;
        StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle = this.f28907q;
        if (stepStyles$StepPaddingStyle == null || (a10 = stepStyles$StepPaddingStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public String V1() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle = this.f28894b;
        if (stepStyles$StepBackgroundColorStyle == null || (a10 = stepStyles$StepBackgroundColorStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public ButtonSubmitComponentStyle X1() {
        StepStyles$StepSubmitButtonComponentStyleContainer a10;
        StepStyles$StepPrimaryButtonComponentStyle stepStyles$StepPrimaryButtonComponentStyle = this.f28899g;
        if (stepStyles$StepPrimaryButtonComponentStyle == null || (a10 = stepStyles$StepPrimaryButtonComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final StepStyles$StepBackgroundColorStyle a() {
        return this.f28894b;
    }

    public final StepStyles$StepBackgroundImageStyle c() {
        return this.f28895c;
    }

    public final StepStyles$DocumentStepBorderColor d() {
        return this.f28903l;
    }

    public int describeContents() {
        return 0;
    }

    public final StepStyles$DocumentStepBorderRadius e() {
        return this.f28904m;
    }

    public TextBasedComponentStyle e1() {
        StepStyles$StepTextBasedComponentStyleContainer a10;
        StepStyles$DocumentStepTitleComponentStyle stepStyles$DocumentStepTitleComponentStyle = this.f28896d;
        if (stepStyles$DocumentStepTitleComponentStyle == null || (a10 = stepStyles$DocumentStepTitleComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final StepStyles$DocumentStepBorderWidth f() {
        return this.f28905n;
    }

    public final StepStyles$StepPrimaryButtonComponentStyle g() {
        return this.f28899g;
    }

    public final StepStyles$StepSecondaryButtonComponentStyle h() {
        return this.f28900h;
    }

    public final StepStyles$StepTextBasedComponentStyle i() {
        return this.f28898f;
    }

    public final TextBasedComponentStyle j() {
        StepStyles$StepTextBasedComponentStyleContainer a10;
        StepStyles$StepTextBasedComponentStyle stepStyles$StepTextBasedComponentStyle = this.f28898f;
        if (stepStyles$StepTextBasedComponentStyle == null || (a10 = stepStyles$StepTextBasedComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final StepStyles$DocumentStepFillColor k() {
        return this.f28902k;
    }

    public final AttributeStyles$HeaderButtonColorStyle l() {
        return this.f28893a;
    }

    public final String m() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle = this.f28893a;
        if (attributeStyles$HeaderButtonColorStyle == null || (a10 = attributeStyles$HeaderButtonColorStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final StepStyles$DocumentStepImageLocalStyle n() {
        return this.f28906p;
    }

    public final TextBasedComponentStyle o() {
        StepStyles$StepTextBasedComponentStyleContainer d10;
        StepStyles$DocumentStepTextBasedComponentStyle stepStyles$DocumentStepTextBasedComponentStyle = this.f28897e;
        if (stepStyles$DocumentStepTextBasedComponentStyle == null || (d10 = stepStyles$DocumentStepTextBasedComponentStyle.d()) == null) {
            return null;
        }
        return d10.a();
    }

    public final String p() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$DocumentStepBorderColor stepStyles$DocumentStepBorderColor = this.f28903l;
        if (stepStyles$DocumentStepBorderColor == null || (a10 = stepStyles$DocumentStepBorderColor.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final Double q() {
        StyleElements.DPMeasurement a10;
        StyleElements.DPSize a11;
        StepStyles$DocumentStepBorderRadius stepStyles$DocumentStepBorderRadius = this.f28904m;
        if (stepStyles$DocumentStepBorderRadius == null || (a10 = stepStyles$DocumentStepBorderRadius.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final Double r() {
        StyleElements.DPMeasurementSet a10;
        StyleElements.DPSizeSet a11;
        StyleElements.DPSize e10;
        StepStyles$DocumentStepBorderWidth stepStyles$DocumentStepBorderWidth = this.f28905n;
        if (stepStyles$DocumentStepBorderWidth == null || (a10 = stepStyles$DocumentStepBorderWidth.a()) == null || (a11 = a10.a()) == null || (e10 = a11.e()) == null) {
            return null;
        }
        return e10.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = (r0 = r0.a()).a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable r1(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.g(r2, r0)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$StepBackgroundImageStyle r0 = r1.f28895c
            if (r0 == 0) goto L_0x001a
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$StepBackgroundImageStyleContainer r0 = r0.a()
            if (r0 == 0) goto L_0x001a
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$StepBackgroundImageNameContainer r0 = r0.a()
            if (r0 == 0) goto L_0x001a
            java.lang.String r0 = r0.a()
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            android.graphics.drawable.Drawable r2 = bj.a.b(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$DocumentStepStyle.r1(android.content.Context):android.graphics.drawable.Drawable");
    }

    public final String s() {
        StyleElements.SimpleElementColor c10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$DocumentStepFillColor stepStyles$DocumentStepFillColor = this.f28902k;
        if (stepStyles$DocumentStepFillColor == null || (c10 = stepStyles$DocumentStepFillColor.c()) == null || (a10 = c10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final String t() {
        StyleElements.SimpleElementColor d10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$DocumentStepFillColor stepStyles$DocumentStepFillColor = this.f28902k;
        if (stepStyles$DocumentStepFillColor == null || (d10 = stepStyles$DocumentStepFillColor.d()) == null || (a10 = d10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final String u() {
        StyleElements.SimpleElementColor e10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$DocumentStepFillColor stepStyles$DocumentStepFillColor = this.f28902k;
        if (stepStyles$DocumentStepFillColor == null || (e10 = stepStyles$DocumentStepFillColor.e()) == null || (a10 = e10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public TextBasedComponentStyle v() {
        StepStyles$StepTextBasedComponentStyleContainer c10;
        StepStyles$DocumentStepTitleComponentStyle stepStyles$DocumentStepTitleComponentStyle = this.f28896d;
        if (stepStyles$DocumentStepTitleComponentStyle == null || (c10 = stepStyles$DocumentStepTitleComponentStyle.c()) == null) {
            return null;
        }
        return c10.a();
    }

    public ButtonCancelComponentStyle v0() {
        StepStyles$StepCancelButtonComponentStyleContainer a10;
        StepStyles$StepSecondaryButtonComponentStyle stepStyles$StepSecondaryButtonComponentStyle = this.f28900h;
        if (stepStyles$StepSecondaryButtonComponentStyle == null || (a10 = stepStyles$StepSecondaryButtonComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final String w() {
        StyleElements.SimpleElementColor c10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$DocumentStepStrokeColor stepStyles$DocumentStepStrokeColor = this.f28901j;
        if (stepStyles$DocumentStepStrokeColor == null || (c10 = stepStyles$DocumentStepStrokeColor.c()) == null || (a10 = c10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public TextBasedComponentStyle w1() {
        StepStyles$StepTextBasedComponentStyleContainer c10;
        StepStyles$DocumentStepTextBasedComponentStyle stepStyles$DocumentStepTextBasedComponentStyle = this.f28897e;
        if (stepStyles$DocumentStepTextBasedComponentStyle == null || (c10 = stepStyles$DocumentStepTextBasedComponentStyle.c()) == null) {
            return null;
        }
        return c10.a();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle = this.f28893a;
        if (attributeStyles$HeaderButtonColorStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$HeaderButtonColorStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle = this.f28894b;
        if (stepStyles$StepBackgroundColorStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepBackgroundColorStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepBackgroundImageStyle stepStyles$StepBackgroundImageStyle = this.f28895c;
        if (stepStyles$StepBackgroundImageStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepBackgroundImageStyle.writeToParcel(parcel, i10);
        }
        StepStyles$DocumentStepTitleComponentStyle stepStyles$DocumentStepTitleComponentStyle = this.f28896d;
        if (stepStyles$DocumentStepTitleComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$DocumentStepTitleComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$DocumentStepTextBasedComponentStyle stepStyles$DocumentStepTextBasedComponentStyle = this.f28897e;
        if (stepStyles$DocumentStepTextBasedComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$DocumentStepTextBasedComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepTextBasedComponentStyle stepStyles$StepTextBasedComponentStyle = this.f28898f;
        if (stepStyles$StepTextBasedComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepTextBasedComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepPrimaryButtonComponentStyle stepStyles$StepPrimaryButtonComponentStyle = this.f28899g;
        if (stepStyles$StepPrimaryButtonComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepPrimaryButtonComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepSecondaryButtonComponentStyle stepStyles$StepSecondaryButtonComponentStyle = this.f28900h;
        if (stepStyles$StepSecondaryButtonComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepSecondaryButtonComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$DocumentStepStrokeColor stepStyles$DocumentStepStrokeColor = this.f28901j;
        if (stepStyles$DocumentStepStrokeColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$DocumentStepStrokeColor.writeToParcel(parcel, i10);
        }
        StepStyles$DocumentStepFillColor stepStyles$DocumentStepFillColor = this.f28902k;
        if (stepStyles$DocumentStepFillColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$DocumentStepFillColor.writeToParcel(parcel, i10);
        }
        StepStyles$DocumentStepBorderColor stepStyles$DocumentStepBorderColor = this.f28903l;
        if (stepStyles$DocumentStepBorderColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$DocumentStepBorderColor.writeToParcel(parcel, i10);
        }
        StepStyles$DocumentStepBorderRadius stepStyles$DocumentStepBorderRadius = this.f28904m;
        if (stepStyles$DocumentStepBorderRadius == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$DocumentStepBorderRadius.writeToParcel(parcel, i10);
        }
        StepStyles$DocumentStepBorderWidth stepStyles$DocumentStepBorderWidth = this.f28905n;
        if (stepStyles$DocumentStepBorderWidth == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$DocumentStepBorderWidth.writeToParcel(parcel, i10);
        }
        StepStyles$DocumentStepImageLocalStyle stepStyles$DocumentStepImageLocalStyle = this.f28906p;
        if (stepStyles$DocumentStepImageLocalStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$DocumentStepImageLocalStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle = this.f28907q;
        if (stepStyles$StepPaddingStyle == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepPaddingStyle.writeToParcel(parcel, i10);
    }

    public final String x() {
        StyleElements.SimpleElementColor f10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$DocumentStepFillColor stepStyles$DocumentStepFillColor = this.f28902k;
        if (stepStyles$DocumentStepFillColor == null || (f10 = stepStyles$DocumentStepFillColor.f()) == null || (a10 = f10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final String z() {
        StyleElements.SimpleElementColor d10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$DocumentStepStrokeColor stepStyles$DocumentStepStrokeColor = this.f28901j;
        if (stepStyles$DocumentStepStrokeColor == null || (d10 = stepStyles$DocumentStepStrokeColor.d()) == null || (a10 = d10.a()) == null) {
            return null;
        }
        return a10.a();
    }
}
