package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.g;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$SelfieStepStyle implements StepStyle {
    public static final Parcelable.Creator<StepStyles$SelfieStepStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AttributeStyles$HeaderButtonColorStyle f28965a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$StepBackgroundColorStyle f28966b;

    /* renamed from: c  reason: collision with root package name */
    private final StepStyles$StepBackgroundImageStyle f28967c;

    /* renamed from: d  reason: collision with root package name */
    private final StepStyles$SelfieStepTitleComponentStyle f28968d;

    /* renamed from: e  reason: collision with root package name */
    private final StepStyles$SelfieStepTextBasedComponentStyle f28969e;

    /* renamed from: f  reason: collision with root package name */
    private final StepStyles$StepPrimaryButtonComponentStyle f28970f;

    /* renamed from: g  reason: collision with root package name */
    private final StepStyles$StepSecondaryButtonComponentStyle f28971g;

    /* renamed from: h  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyle f28972h;

    /* renamed from: j  reason: collision with root package name */
    private final StepStyles$SelfieStepStrokeColor f28973j;

    /* renamed from: k  reason: collision with root package name */
    private final StepStyles$SelfieStepBorderColor f28974k;

    /* renamed from: l  reason: collision with root package name */
    private final StepStyles$SelfieStepBorderWidth f28975l;

    /* renamed from: m  reason: collision with root package name */
    private final StepStyles$SelfieStepFillColor f28976m;

    /* renamed from: n  reason: collision with root package name */
    private final StepStyles$SelfieStepImageLocalStyle f28977n;

    /* renamed from: p  reason: collision with root package name */
    private final StepStyles$StepPaddingStyle f28978p;

    /* renamed from: q  reason: collision with root package name */
    private final StepStyles$StepBorderRadiusStyle f28979q;

    public static final class a implements Parcelable.Creator<StepStyles$SelfieStepStyle> {
        /* renamed from: a */
        public final StepStyles$SelfieStepStyle createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            j.g(parcel2, "parcel");
            StepStyles$StepBorderRadiusStyle stepStyles$StepBorderRadiusStyle = null;
            AttributeStyles$HeaderButtonColorStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$HeaderButtonColorStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$StepBackgroundColorStyle createFromParcel2 = parcel.readInt() == 0 ? null : StepStyles$StepBackgroundColorStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$StepBackgroundImageStyle createFromParcel3 = parcel.readInt() == 0 ? null : StepStyles$StepBackgroundImageStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$SelfieStepTitleComponentStyle createFromParcel4 = parcel.readInt() == 0 ? null : StepStyles$SelfieStepTitleComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$SelfieStepTextBasedComponentStyle createFromParcel5 = parcel.readInt() == 0 ? null : StepStyles$SelfieStepTextBasedComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$StepPrimaryButtonComponentStyle createFromParcel6 = parcel.readInt() == 0 ? null : StepStyles$StepPrimaryButtonComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$StepSecondaryButtonComponentStyle createFromParcel7 = parcel.readInt() == 0 ? null : StepStyles$StepSecondaryButtonComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$StepTextBasedComponentStyle createFromParcel8 = parcel.readInt() == 0 ? null : StepStyles$StepTextBasedComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$SelfieStepStrokeColor createFromParcel9 = parcel.readInt() == 0 ? null : StepStyles$SelfieStepStrokeColor.CREATOR.createFromParcel(parcel2);
            StepStyles$SelfieStepBorderColor createFromParcel10 = parcel.readInt() == 0 ? null : StepStyles$SelfieStepBorderColor.CREATOR.createFromParcel(parcel2);
            StepStyles$SelfieStepBorderWidth createFromParcel11 = parcel.readInt() == 0 ? null : StepStyles$SelfieStepBorderWidth.CREATOR.createFromParcel(parcel2);
            StepStyles$SelfieStepFillColor createFromParcel12 = parcel.readInt() == 0 ? null : StepStyles$SelfieStepFillColor.CREATOR.createFromParcel(parcel2);
            StepStyles$SelfieStepImageLocalStyle createFromParcel13 = parcel.readInt() == 0 ? null : StepStyles$SelfieStepImageLocalStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$StepPaddingStyle createFromParcel14 = parcel.readInt() == 0 ? null : StepStyles$StepPaddingStyle.CREATOR.createFromParcel(parcel2);
            if (parcel.readInt() != 0) {
                stepStyles$StepBorderRadiusStyle = StepStyles$StepBorderRadiusStyle.CREATOR.createFromParcel(parcel2);
            }
            return new StepStyles$SelfieStepStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, createFromParcel9, createFromParcel10, createFromParcel11, createFromParcel12, createFromParcel13, createFromParcel14, stepStyles$StepBorderRadiusStyle);
        }

        /* renamed from: b */
        public final StepStyles$SelfieStepStyle[] newArray(int i10) {
            return new StepStyles$SelfieStepStyle[i10];
        }
    }

    public StepStyles$SelfieStepStyle(@g(name = "textColor") AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle, StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle, StepStyles$StepBackgroundImageStyle stepStyles$StepBackgroundImageStyle, StepStyles$SelfieStepTitleComponentStyle stepStyles$SelfieStepTitleComponentStyle, StepStyles$SelfieStepTextBasedComponentStyle stepStyles$SelfieStepTextBasedComponentStyle, StepStyles$StepPrimaryButtonComponentStyle stepStyles$StepPrimaryButtonComponentStyle, StepStyles$StepSecondaryButtonComponentStyle stepStyles$StepSecondaryButtonComponentStyle, StepStyles$StepTextBasedComponentStyle stepStyles$StepTextBasedComponentStyle, StepStyles$SelfieStepStrokeColor stepStyles$SelfieStepStrokeColor, StepStyles$SelfieStepBorderColor stepStyles$SelfieStepBorderColor, StepStyles$SelfieStepBorderWidth stepStyles$SelfieStepBorderWidth, StepStyles$SelfieStepFillColor stepStyles$SelfieStepFillColor, StepStyles$SelfieStepImageLocalStyle stepStyles$SelfieStepImageLocalStyle, StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle, StepStyles$StepBorderRadiusStyle stepStyles$StepBorderRadiusStyle) {
        this.f28965a = attributeStyles$HeaderButtonColorStyle;
        this.f28966b = stepStyles$StepBackgroundColorStyle;
        this.f28967c = stepStyles$StepBackgroundImageStyle;
        this.f28968d = stepStyles$SelfieStepTitleComponentStyle;
        this.f28969e = stepStyles$SelfieStepTextBasedComponentStyle;
        this.f28970f = stepStyles$StepPrimaryButtonComponentStyle;
        this.f28971g = stepStyles$StepSecondaryButtonComponentStyle;
        this.f28972h = stepStyles$StepTextBasedComponentStyle;
        this.f28973j = stepStyles$SelfieStepStrokeColor;
        this.f28974k = stepStyles$SelfieStepBorderColor;
        this.f28975l = stepStyles$SelfieStepBorderWidth;
        this.f28976m = stepStyles$SelfieStepFillColor;
        this.f28977n = stepStyles$SelfieStepImageLocalStyle;
        this.f28978p = stepStyles$StepPaddingStyle;
        this.f28979q = stepStyles$StepBorderRadiusStyle;
    }

    public final StepStyles$SelfieStepTitleComponentStyle A() {
        return this.f28968d;
    }

    public String A0() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$SelfieStepFillColor stepStyles$SelfieStepFillColor = this.f28976m;
        if (stepStyles$SelfieStepFillColor == null || (a10 = stepStyles$SelfieStepFillColor.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public String C() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$SelfieStepStrokeColor stepStyles$SelfieStepStrokeColor = this.f28973j;
        if (stepStyles$SelfieStepStrokeColor == null || (a10 = stepStyles$SelfieStepStrokeColor.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public TextBasedComponentStyle H1() {
        StepStyles$StepTextBasedComponentStyleContainer a10;
        StepStyles$SelfieStepTextBasedComponentStyle stepStyles$SelfieStepTextBasedComponentStyle = this.f28969e;
        if (stepStyles$SelfieStepTextBasedComponentStyle == null || (a10 = stepStyles$SelfieStepTextBasedComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public StyleElements.DPSize N() {
        StyleElements.DPMeasurement a10;
        StepStyles$StepBorderRadiusStyle stepStyles$StepBorderRadiusStyle = this.f28979q;
        if (stepStyles$StepBorderRadiusStyle == null || (a10 = stepStyles$StepBorderRadiusStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public StyleElements.DPSizeSet T1() {
        StepStyles$StepPaddingStyleContainer a10;
        StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle = this.f28978p;
        if (stepStyles$StepPaddingStyle == null || (a10 = stepStyles$StepPaddingStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public String V1() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle = this.f28966b;
        if (stepStyles$StepBackgroundColorStyle == null || (a10 = stepStyles$StepBackgroundColorStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public ButtonSubmitComponentStyle X1() {
        StepStyles$StepSubmitButtonComponentStyleContainer a10;
        StepStyles$StepPrimaryButtonComponentStyle stepStyles$StepPrimaryButtonComponentStyle = this.f28970f;
        if (stepStyles$StepPrimaryButtonComponentStyle == null || (a10 = stepStyles$StepPrimaryButtonComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final StepStyles$StepBackgroundColorStyle a() {
        return this.f28966b;
    }

    public final StepStyles$StepBackgroundImageStyle c() {
        return this.f28967c;
    }

    public final StepStyles$SelfieStepBorderColor d() {
        return this.f28974k;
    }

    public int describeContents() {
        return 0;
    }

    public final StepStyles$StepBorderRadiusStyle e() {
        return this.f28979q;
    }

    public TextBasedComponentStyle e1() {
        StepStyles$StepTextBasedComponentStyleContainer a10;
        StepStyles$SelfieStepTitleComponentStyle stepStyles$SelfieStepTitleComponentStyle = this.f28968d;
        if (stepStyles$SelfieStepTitleComponentStyle == null || (a10 = stepStyles$SelfieStepTitleComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final StepStyles$SelfieStepBorderWidth f() {
        return this.f28975l;
    }

    public final StepStyles$StepPrimaryButtonComponentStyle g() {
        return this.f28970f;
    }

    public final StepStyles$StepSecondaryButtonComponentStyle h() {
        return this.f28971g;
    }

    public final StepStyles$StepTextBasedComponentStyle i() {
        return this.f28972h;
    }

    public final TextBasedComponentStyle j() {
        StepStyles$StepTextBasedComponentStyleContainer a10;
        StepStyles$StepTextBasedComponentStyle stepStyles$StepTextBasedComponentStyle = this.f28972h;
        if (stepStyles$StepTextBasedComponentStyle == null || (a10 = stepStyles$StepTextBasedComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final StepStyles$SelfieStepFillColor k() {
        return this.f28976m;
    }

    public final AttributeStyles$HeaderButtonColorStyle l() {
        return this.f28965a;
    }

    public final String m() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle = this.f28965a;
        if (attributeStyles$HeaderButtonColorStyle == null || (a10 = attributeStyles$HeaderButtonColorStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final StepStyles$SelfieStepImageLocalStyle n() {
        return this.f28977n;
    }

    public final StepStyles$StepPaddingStyle o() {
        return this.f28978p;
    }

    public final String p() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$SelfieStepBorderColor stepStyles$SelfieStepBorderColor = this.f28974k;
        if (stepStyles$SelfieStepBorderColor == null || (a10 = stepStyles$SelfieStepBorderColor.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final Double q() {
        StyleElements.DPMeasurementSet a10;
        StyleElements.DPSizeSet a11;
        StyleElements.DPSize e10;
        StepStyles$SelfieStepBorderWidth stepStyles$SelfieStepBorderWidth = this.f28975l;
        if (stepStyles$SelfieStepBorderWidth == null || (a10 = stepStyles$SelfieStepBorderWidth.a()) == null || (a11 = a10.a()) == null || (e10 = a11.e()) == null) {
            return null;
        }
        return e10.a();
    }

    public final TextBasedComponentStyle r() {
        StepStyles$StepTextBasedComponentStyleContainer c10;
        StepStyles$SelfieStepTextBasedComponentStyle stepStyles$SelfieStepTextBasedComponentStyle = this.f28969e;
        if (stepStyles$SelfieStepTextBasedComponentStyle == null || (c10 = stepStyles$SelfieStepTextBasedComponentStyle.c()) == null) {
            return null;
        }
        return c10.a();
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
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$StepBackgroundImageStyle r0 = r1.f28967c
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
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$SelfieStepStyle.r1(android.content.Context):android.graphics.drawable.Drawable");
    }

    public final String s() {
        StyleElements.SimpleElementColor c10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$SelfieStepFillColor stepStyles$SelfieStepFillColor = this.f28976m;
        if (stepStyles$SelfieStepFillColor == null || (c10 = stepStyles$SelfieStepFillColor.c()) == null || (a10 = c10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final String t() {
        StyleElements.SimpleElementColor d10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$SelfieStepFillColor stepStyles$SelfieStepFillColor = this.f28976m;
        if (stepStyles$SelfieStepFillColor == null || (d10 = stepStyles$SelfieStepFillColor.d()) == null || (a10 = d10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final String u() {
        StyleElements.SimpleElementColor c10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$SelfieStepStrokeColor stepStyles$SelfieStepStrokeColor = this.f28973j;
        if (stepStyles$SelfieStepStrokeColor == null || (c10 = stepStyles$SelfieStepStrokeColor.c()) == null || (a10 = c10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public TextBasedComponentStyle v() {
        StepStyles$StepTextBasedComponentStyleContainer c10;
        StepStyles$SelfieStepTitleComponentStyle stepStyles$SelfieStepTitleComponentStyle = this.f28968d;
        if (stepStyles$SelfieStepTitleComponentStyle == null || (c10 = stepStyles$SelfieStepTitleComponentStyle.c()) == null) {
            return null;
        }
        return c10.a();
    }

    public ButtonCancelComponentStyle v0() {
        StepStyles$StepCancelButtonComponentStyleContainer a10;
        StepStyles$StepSecondaryButtonComponentStyle stepStyles$StepSecondaryButtonComponentStyle = this.f28971g;
        if (stepStyles$StepSecondaryButtonComponentStyle == null || (a10 = stepStyles$StepSecondaryButtonComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final LocalImageComponentStyle w() {
        StepStyles$SelfieStepImageLocalStyleContainer a10;
        StepStyles$SelfieStepImageLocalStyle stepStyles$SelfieStepImageLocalStyle = this.f28977n;
        if (stepStyles$SelfieStepImageLocalStyle == null || (a10 = stepStyles$SelfieStepImageLocalStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public TextBasedComponentStyle w1() {
        StepStyles$StepTextBasedComponentStyleContainer d10;
        StepStyles$SelfieStepTextBasedComponentStyle stepStyles$SelfieStepTextBasedComponentStyle = this.f28969e;
        if (stepStyles$SelfieStepTextBasedComponentStyle == null || (d10 = stepStyles$SelfieStepTextBasedComponentStyle.d()) == null) {
            return null;
        }
        return d10.a();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle = this.f28965a;
        if (attributeStyles$HeaderButtonColorStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$HeaderButtonColorStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle = this.f28966b;
        if (stepStyles$StepBackgroundColorStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepBackgroundColorStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepBackgroundImageStyle stepStyles$StepBackgroundImageStyle = this.f28967c;
        if (stepStyles$StepBackgroundImageStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepBackgroundImageStyle.writeToParcel(parcel, i10);
        }
        StepStyles$SelfieStepTitleComponentStyle stepStyles$SelfieStepTitleComponentStyle = this.f28968d;
        if (stepStyles$SelfieStepTitleComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$SelfieStepTitleComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$SelfieStepTextBasedComponentStyle stepStyles$SelfieStepTextBasedComponentStyle = this.f28969e;
        if (stepStyles$SelfieStepTextBasedComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$SelfieStepTextBasedComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepPrimaryButtonComponentStyle stepStyles$StepPrimaryButtonComponentStyle = this.f28970f;
        if (stepStyles$StepPrimaryButtonComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepPrimaryButtonComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepSecondaryButtonComponentStyle stepStyles$StepSecondaryButtonComponentStyle = this.f28971g;
        if (stepStyles$StepSecondaryButtonComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepSecondaryButtonComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepTextBasedComponentStyle stepStyles$StepTextBasedComponentStyle = this.f28972h;
        if (stepStyles$StepTextBasedComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepTextBasedComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$SelfieStepStrokeColor stepStyles$SelfieStepStrokeColor = this.f28973j;
        if (stepStyles$SelfieStepStrokeColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$SelfieStepStrokeColor.writeToParcel(parcel, i10);
        }
        StepStyles$SelfieStepBorderColor stepStyles$SelfieStepBorderColor = this.f28974k;
        if (stepStyles$SelfieStepBorderColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$SelfieStepBorderColor.writeToParcel(parcel, i10);
        }
        StepStyles$SelfieStepBorderWidth stepStyles$SelfieStepBorderWidth = this.f28975l;
        if (stepStyles$SelfieStepBorderWidth == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$SelfieStepBorderWidth.writeToParcel(parcel, i10);
        }
        StepStyles$SelfieStepFillColor stepStyles$SelfieStepFillColor = this.f28976m;
        if (stepStyles$SelfieStepFillColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$SelfieStepFillColor.writeToParcel(parcel, i10);
        }
        StepStyles$SelfieStepImageLocalStyle stepStyles$SelfieStepImageLocalStyle = this.f28977n;
        if (stepStyles$SelfieStepImageLocalStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$SelfieStepImageLocalStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle = this.f28978p;
        if (stepStyles$StepPaddingStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepPaddingStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepBorderRadiusStyle stepStyles$StepBorderRadiusStyle = this.f28979q;
        if (stepStyles$StepBorderRadiusStyle == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepBorderRadiusStyle.writeToParcel(parcel, i10);
    }

    public final StepStyles$SelfieStepStrokeColor x() {
        return this.f28973j;
    }

    public final StepStyles$SelfieStepTextBasedComponentStyle z() {
        return this.f28969e;
    }
}
