package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.g;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$GovernmentIdStepStyle implements StepStyle {
    public static final Parcelable.Creator<StepStyles$GovernmentIdStepStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AttributeStyles$HeaderButtonColorStyle f28935a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$StepBackgroundColorStyle f28936b;

    /* renamed from: c  reason: collision with root package name */
    private final StepStyles$StepBackgroundImageStyle f28937c;

    /* renamed from: d  reason: collision with root package name */
    private final StepStyles$GovernmentIdStepTitleComponentStyle f28938d;

    /* renamed from: e  reason: collision with root package name */
    private final StepStyles$GovernmentIdStepTextBasedComponentStyle f28939e;

    /* renamed from: f  reason: collision with root package name */
    private final StepStyles$GovernmentIdStepPrimaryButtonComponentStyle f28940f;

    /* renamed from: g  reason: collision with root package name */
    private final StepStyles$GovernmentIdStepSecondaryButtonComponentStyle f28941g;

    /* renamed from: h  reason: collision with root package name */
    private final StepStyles$StepTextBasedComponentStyle f28942h;

    /* renamed from: j  reason: collision with root package name */
    private final StepStyles$GovernmentIdStepRowHeight f28943j;

    /* renamed from: k  reason: collision with root package name */
    private final StepStyles$GovernmentIdStepStrokeColor f28944k;

    /* renamed from: l  reason: collision with root package name */
    private final StepStyles$GovernmentIdStepFillColor f28945l;

    /* renamed from: m  reason: collision with root package name */
    private final StepStyles$GovernmentIdStepBorderColor f28946m;

    /* renamed from: n  reason: collision with root package name */
    private final StepStyles$GovernmentIdStepBorderRadius f28947n;

    /* renamed from: p  reason: collision with root package name */
    private final StepStyles$GovernmentIdStepBorderWidth f28948p;

    /* renamed from: q  reason: collision with root package name */
    private final StepStyles$StepPaddingStyle f28949q;

    public static final class a implements Parcelable.Creator<StepStyles$GovernmentIdStepStyle> {
        /* renamed from: a */
        public final StepStyles$GovernmentIdStepStyle createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            j.g(parcel2, "parcel");
            StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle = null;
            AttributeStyles$HeaderButtonColorStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$HeaderButtonColorStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$StepBackgroundColorStyle createFromParcel2 = parcel.readInt() == 0 ? null : StepStyles$StepBackgroundColorStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$StepBackgroundImageStyle createFromParcel3 = parcel.readInt() == 0 ? null : StepStyles$StepBackgroundImageStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$GovernmentIdStepTitleComponentStyle createFromParcel4 = parcel.readInt() == 0 ? null : StepStyles$GovernmentIdStepTitleComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$GovernmentIdStepTextBasedComponentStyle createFromParcel5 = parcel.readInt() == 0 ? null : StepStyles$GovernmentIdStepTextBasedComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$GovernmentIdStepPrimaryButtonComponentStyle createFromParcel6 = parcel.readInt() == 0 ? null : StepStyles$GovernmentIdStepPrimaryButtonComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$GovernmentIdStepSecondaryButtonComponentStyle createFromParcel7 = parcel.readInt() == 0 ? null : StepStyles$GovernmentIdStepSecondaryButtonComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$StepTextBasedComponentStyle createFromParcel8 = parcel.readInt() == 0 ? null : StepStyles$StepTextBasedComponentStyle.CREATOR.createFromParcel(parcel2);
            StepStyles$GovernmentIdStepRowHeight createFromParcel9 = parcel.readInt() == 0 ? null : StepStyles$GovernmentIdStepRowHeight.CREATOR.createFromParcel(parcel2);
            StepStyles$GovernmentIdStepStrokeColor createFromParcel10 = parcel.readInt() == 0 ? null : StepStyles$GovernmentIdStepStrokeColor.CREATOR.createFromParcel(parcel2);
            StepStyles$GovernmentIdStepFillColor createFromParcel11 = parcel.readInt() == 0 ? null : StepStyles$GovernmentIdStepFillColor.CREATOR.createFromParcel(parcel2);
            StepStyles$GovernmentIdStepBorderColor createFromParcel12 = parcel.readInt() == 0 ? null : StepStyles$GovernmentIdStepBorderColor.CREATOR.createFromParcel(parcel2);
            StepStyles$GovernmentIdStepBorderRadius createFromParcel13 = parcel.readInt() == 0 ? null : StepStyles$GovernmentIdStepBorderRadius.CREATOR.createFromParcel(parcel2);
            StepStyles$GovernmentIdStepBorderWidth createFromParcel14 = parcel.readInt() == 0 ? null : StepStyles$GovernmentIdStepBorderWidth.CREATOR.createFromParcel(parcel2);
            if (parcel.readInt() != 0) {
                stepStyles$StepPaddingStyle = StepStyles$StepPaddingStyle.CREATOR.createFromParcel(parcel2);
            }
            return new StepStyles$GovernmentIdStepStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, createFromParcel9, createFromParcel10, createFromParcel11, createFromParcel12, createFromParcel13, createFromParcel14, stepStyles$StepPaddingStyle);
        }

        /* renamed from: b */
        public final StepStyles$GovernmentIdStepStyle[] newArray(int i10) {
            return new StepStyles$GovernmentIdStepStyle[i10];
        }
    }

    public StepStyles$GovernmentIdStepStyle(@g(name = "textColor") AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle, StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle, StepStyles$StepBackgroundImageStyle stepStyles$StepBackgroundImageStyle, StepStyles$GovernmentIdStepTitleComponentStyle stepStyles$GovernmentIdStepTitleComponentStyle, StepStyles$GovernmentIdStepTextBasedComponentStyle stepStyles$GovernmentIdStepTextBasedComponentStyle, StepStyles$GovernmentIdStepPrimaryButtonComponentStyle stepStyles$GovernmentIdStepPrimaryButtonComponentStyle, StepStyles$GovernmentIdStepSecondaryButtonComponentStyle stepStyles$GovernmentIdStepSecondaryButtonComponentStyle, StepStyles$StepTextBasedComponentStyle stepStyles$StepTextBasedComponentStyle, StepStyles$GovernmentIdStepRowHeight stepStyles$GovernmentIdStepRowHeight, StepStyles$GovernmentIdStepStrokeColor stepStyles$GovernmentIdStepStrokeColor, StepStyles$GovernmentIdStepFillColor stepStyles$GovernmentIdStepFillColor, StepStyles$GovernmentIdStepBorderColor stepStyles$GovernmentIdStepBorderColor, StepStyles$GovernmentIdStepBorderRadius stepStyles$GovernmentIdStepBorderRadius, StepStyles$GovernmentIdStepBorderWidth stepStyles$GovernmentIdStepBorderWidth, StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle) {
        this.f28935a = attributeStyles$HeaderButtonColorStyle;
        this.f28936b = stepStyles$StepBackgroundColorStyle;
        this.f28937c = stepStyles$StepBackgroundImageStyle;
        this.f28938d = stepStyles$GovernmentIdStepTitleComponentStyle;
        this.f28939e = stepStyles$GovernmentIdStepTextBasedComponentStyle;
        this.f28940f = stepStyles$GovernmentIdStepPrimaryButtonComponentStyle;
        this.f28941g = stepStyles$GovernmentIdStepSecondaryButtonComponentStyle;
        this.f28942h = stepStyles$StepTextBasedComponentStyle;
        this.f28943j = stepStyles$GovernmentIdStepRowHeight;
        this.f28944k = stepStyles$GovernmentIdStepStrokeColor;
        this.f28945l = stepStyles$GovernmentIdStepFillColor;
        this.f28946m = stepStyles$GovernmentIdStepBorderColor;
        this.f28947n = stepStyles$GovernmentIdStepBorderRadius;
        this.f28948p = stepStyles$GovernmentIdStepBorderWidth;
        this.f28949q = stepStyles$StepPaddingStyle;
    }

    public final Double A() {
        StyleElements.DPMeasurementSet c10;
        StyleElements.DPSizeSet a10;
        StyleElements.DPSize e10;
        StepStyles$GovernmentIdStepBorderWidth stepStyles$GovernmentIdStepBorderWidth = this.f28948p;
        if (stepStyles$GovernmentIdStepBorderWidth == null || (c10 = stepStyles$GovernmentIdStepBorderWidth.c()) == null || (a10 = c10.a()) == null || (e10 = a10.e()) == null) {
            return null;
        }
        return e10.a();
    }

    public String A0() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$GovernmentIdStepFillColor stepStyles$GovernmentIdStepFillColor = this.f28945l;
        if (stepStyles$GovernmentIdStepFillColor == null || (a10 = stepStyles$GovernmentIdStepFillColor.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final String B() {
        StyleElements.SimpleElementColor e10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$GovernmentIdStepBorderColor stepStyles$GovernmentIdStepBorderColor = this.f28946m;
        if (stepStyles$GovernmentIdStepBorderColor == null || (e10 = stepStyles$GovernmentIdStepBorderColor.e()) == null || (a10 = e10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public String C() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$GovernmentIdStepStrokeColor stepStyles$GovernmentIdStepStrokeColor = this.f28944k;
        if (stepStyles$GovernmentIdStepStrokeColor == null || (a10 = stepStyles$GovernmentIdStepStrokeColor.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final Double D() {
        StyleElements.DPMeasurement a10;
        StyleElements.DPSize a11;
        StepStyles$GovernmentIdStepRowHeight stepStyles$GovernmentIdStepRowHeight = this.f28943j;
        if (stepStyles$GovernmentIdStepRowHeight == null || (a10 = stepStyles$GovernmentIdStepRowHeight.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final TextBasedComponentStyle E() {
        StepStyles$StepTextBasedComponentStyleContainer e10;
        StepStyles$GovernmentIdStepTextBasedComponentStyle stepStyles$GovernmentIdStepTextBasedComponentStyle = this.f28939e;
        if (stepStyles$GovernmentIdStepTextBasedComponentStyle == null || (e10 = stepStyles$GovernmentIdStepTextBasedComponentStyle.e()) == null) {
            return null;
        }
        return e10.a();
    }

    public final AttributeStyles$HeaderButtonColorStyle F() {
        return this.f28935a;
    }

    public final String G() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle = this.f28935a;
        if (attributeStyles$HeaderButtonColorStyle == null || (a10 = attributeStyles$HeaderButtonColorStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final StepStyles$GovernmentIdStepRowHeight H() {
        return this.f28943j;
    }

    public TextBasedComponentStyle H1() {
        StepStyles$StepTextBasedComponentStyleContainer a10;
        StepStyles$GovernmentIdStepTextBasedComponentStyle stepStyles$GovernmentIdStepTextBasedComponentStyle = this.f28939e;
        if (stepStyles$GovernmentIdStepTextBasedComponentStyle == null || (a10 = stepStyles$GovernmentIdStepTextBasedComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final StepStyles$StepPaddingStyle I() {
        return this.f28949q;
    }

    public final ButtonCancelComponentStyle K() {
        StepStyles$StepCancelButtonComponentStyleContainer c10;
        StepStyles$GovernmentIdStepSecondaryButtonComponentStyle stepStyles$GovernmentIdStepSecondaryButtonComponentStyle = this.f28941g;
        if (stepStyles$GovernmentIdStepSecondaryButtonComponentStyle == null || (c10 = stepStyles$GovernmentIdStepSecondaryButtonComponentStyle.c()) == null) {
            return null;
        }
        return c10.a();
    }

    public final StepStyles$GovernmentIdStepStrokeColor L() {
        return this.f28944k;
    }

    public final ButtonSubmitComponentStyle M() {
        StepStyles$StepSubmitButtonComponentStyleContainer c10;
        StepStyles$GovernmentIdStepPrimaryButtonComponentStyle stepStyles$GovernmentIdStepPrimaryButtonComponentStyle = this.f28940f;
        if (stepStyles$GovernmentIdStepPrimaryButtonComponentStyle == null || (c10 = stepStyles$GovernmentIdStepPrimaryButtonComponentStyle.c()) == null) {
            return null;
        }
        return c10.a();
    }

    public StyleElements.DPSize N() {
        StyleElements.DPMeasurement d10;
        StepStyles$GovernmentIdStepBorderRadius stepStyles$GovernmentIdStepBorderRadius = this.f28947n;
        if (stepStyles$GovernmentIdStepBorderRadius == null || (d10 = stepStyles$GovernmentIdStepBorderRadius.d()) == null) {
            return null;
        }
        return d10.a();
    }

    public final StepStyles$GovernmentIdStepTextBasedComponentStyle O() {
        return this.f28939e;
    }

    public final StepStyles$GovernmentIdStepTitleComponentStyle P() {
        return this.f28938d;
    }

    public StyleElements.DPSizeSet T1() {
        StepStyles$StepPaddingStyleContainer a10;
        StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle = this.f28949q;
        if (stepStyles$StepPaddingStyle == null || (a10 = stepStyles$StepPaddingStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public String V1() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle = this.f28936b;
        if (stepStyles$StepBackgroundColorStyle == null || (a10 = stepStyles$StepBackgroundColorStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public ButtonSubmitComponentStyle X1() {
        StepStyles$StepSubmitButtonComponentStyleContainer a10;
        StepStyles$GovernmentIdStepPrimaryButtonComponentStyle stepStyles$GovernmentIdStepPrimaryButtonComponentStyle = this.f28940f;
        if (stepStyles$GovernmentIdStepPrimaryButtonComponentStyle == null || (a10 = stepStyles$GovernmentIdStepPrimaryButtonComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final String a() {
        StyleElements.ComplexElementColor c10;
        StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle = this.f28936b;
        if (stepStyles$StepBackgroundColorStyle == null || (c10 = stepStyles$StepBackgroundColorStyle.c()) == null) {
            return null;
        }
        return c10.a();
    }

    public final StepStyles$StepBackgroundColorStyle c() {
        return this.f28936b;
    }

    public final StepStyles$StepBackgroundImageStyle d() {
        return this.f28937c;
    }

    public int describeContents() {
        return 0;
    }

    public final StepStyles$GovernmentIdStepBorderColor e() {
        return this.f28946m;
    }

    public TextBasedComponentStyle e1() {
        StepStyles$StepTextBasedComponentStyleContainer a10;
        StepStyles$GovernmentIdStepTitleComponentStyle stepStyles$GovernmentIdStepTitleComponentStyle = this.f28938d;
        if (stepStyles$GovernmentIdStepTitleComponentStyle == null || (a10 = stepStyles$GovernmentIdStepTitleComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final StepStyles$GovernmentIdStepBorderRadius f() {
        return this.f28947n;
    }

    public final StepStyles$GovernmentIdStepBorderWidth g() {
        return this.f28948p;
    }

    public final StepStyles$GovernmentIdStepPrimaryButtonComponentStyle h() {
        return this.f28940f;
    }

    public final StepStyles$GovernmentIdStepSecondaryButtonComponentStyle i() {
        return this.f28941g;
    }

    public final String j() {
        StyleElements.SimpleElementColor c10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$GovernmentIdStepFillColor stepStyles$GovernmentIdStepFillColor = this.f28945l;
        if (stepStyles$GovernmentIdStepFillColor == null || (c10 = stepStyles$GovernmentIdStepFillColor.c()) == null || (a10 = c10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final String k() {
        StyleElements.SimpleElementColor c10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$GovernmentIdStepStrokeColor stepStyles$GovernmentIdStepStrokeColor = this.f28944k;
        if (stepStyles$GovernmentIdStepStrokeColor == null || (c10 = stepStyles$GovernmentIdStepStrokeColor.c()) == null || (a10 = c10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final String l() {
        StyleElements.SimpleElementColor d10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$GovernmentIdStepStrokeColor stepStyles$GovernmentIdStepStrokeColor = this.f28944k;
        if (stepStyles$GovernmentIdStepStrokeColor == null || (d10 = stepStyles$GovernmentIdStepStrokeColor.d()) == null || (a10 = d10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final StepStyles$StepTextBasedComponentStyle m() {
        return this.f28942h;
    }

    public final TextBasedComponentStyle n() {
        StepStyles$StepTextBasedComponentStyleContainer a10;
        StepStyles$StepTextBasedComponentStyle stepStyles$StepTextBasedComponentStyle = this.f28942h;
        if (stepStyles$StepTextBasedComponentStyle == null || (a10 = stepStyles$StepTextBasedComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final StepStyles$GovernmentIdStepFillColor o() {
        return this.f28945l;
    }

    public final String p() {
        StyleElements.SimpleElementColor c10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$GovernmentIdStepBorderColor stepStyles$GovernmentIdStepBorderColor = this.f28946m;
        if (stepStyles$GovernmentIdStepBorderColor == null || (c10 = stepStyles$GovernmentIdStepBorderColor.c()) == null || (a10 = c10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final Double q() {
        StyleElements.DPMeasurement a10;
        StyleElements.DPSize a11;
        StepStyles$GovernmentIdStepBorderRadius stepStyles$GovernmentIdStepBorderRadius = this.f28947n;
        if (stepStyles$GovernmentIdStepBorderRadius == null || (a10 = stepStyles$GovernmentIdStepBorderRadius.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final Double r() {
        StyleElements.DPMeasurementSet a10;
        StyleElements.DPSizeSet a11;
        StyleElements.DPSize e10;
        StepStyles$GovernmentIdStepBorderWidth stepStyles$GovernmentIdStepBorderWidth = this.f28948p;
        if (stepStyles$GovernmentIdStepBorderWidth == null || (a10 = stepStyles$GovernmentIdStepBorderWidth.a()) == null || (a11 = a10.a()) == null || (e10 = a11.e()) == null) {
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
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$StepBackgroundImageStyle r0 = r1.f28937c
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
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle.r1(android.content.Context):android.graphics.drawable.Drawable");
    }

    public final TextBasedComponentStyle s() {
        StepStyles$StepTextBasedComponentStyleContainer c10;
        StepStyles$GovernmentIdStepTextBasedComponentStyle stepStyles$GovernmentIdStepTextBasedComponentStyle = this.f28939e;
        if (stepStyles$GovernmentIdStepTextBasedComponentStyle == null || (c10 = stepStyles$GovernmentIdStepTextBasedComponentStyle.c()) == null) {
            return null;
        }
        return c10.a();
    }

    public final String t() {
        StyleElements.SimpleElementColor d10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$GovernmentIdStepFillColor stepStyles$GovernmentIdStepFillColor = this.f28945l;
        if (stepStyles$GovernmentIdStepFillColor == null || (d10 = stepStyles$GovernmentIdStepFillColor.d()) == null || (a10 = d10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final String u() {
        StyleElements.SimpleElementColor e10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$GovernmentIdStepStrokeColor stepStyles$GovernmentIdStepStrokeColor = this.f28944k;
        if (stepStyles$GovernmentIdStepStrokeColor == null || (e10 = stepStyles$GovernmentIdStepStrokeColor.e()) == null || (a10 = e10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public TextBasedComponentStyle v() {
        StepStyles$StepTextBasedComponentStyleContainer c10;
        StepStyles$GovernmentIdStepTitleComponentStyle stepStyles$GovernmentIdStepTitleComponentStyle = this.f28938d;
        if (stepStyles$GovernmentIdStepTitleComponentStyle == null || (c10 = stepStyles$GovernmentIdStepTitleComponentStyle.c()) == null) {
            return null;
        }
        return c10.a();
    }

    public ButtonCancelComponentStyle v0() {
        StepStyles$StepCancelButtonComponentStyleContainer a10;
        StepStyles$GovernmentIdStepSecondaryButtonComponentStyle stepStyles$GovernmentIdStepSecondaryButtonComponentStyle = this.f28941g;
        if (stepStyles$GovernmentIdStepSecondaryButtonComponentStyle == null || (a10 = stepStyles$GovernmentIdStepSecondaryButtonComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final Double w() {
        StyleElements.DPMeasurementSet d10;
        StyleElements.DPSizeSet a10;
        StyleElements.DPSize e10;
        StepStyles$GovernmentIdStepBorderWidth stepStyles$GovernmentIdStepBorderWidth = this.f28948p;
        if (stepStyles$GovernmentIdStepBorderWidth == null || (d10 = stepStyles$GovernmentIdStepBorderWidth.d()) == null || (a10 = d10.a()) == null || (e10 = a10.e()) == null) {
            return null;
        }
        return e10.a();
    }

    public TextBasedComponentStyle w1() {
        StepStyles$StepTextBasedComponentStyleContainer d10;
        StepStyles$GovernmentIdStepTextBasedComponentStyle stepStyles$GovernmentIdStepTextBasedComponentStyle = this.f28939e;
        if (stepStyles$GovernmentIdStepTextBasedComponentStyle == null || (d10 = stepStyles$GovernmentIdStepTextBasedComponentStyle.d()) == null) {
            return null;
        }
        return d10.a();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle = this.f28935a;
        if (attributeStyles$HeaderButtonColorStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$HeaderButtonColorStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle = this.f28936b;
        if (stepStyles$StepBackgroundColorStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepBackgroundColorStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepBackgroundImageStyle stepStyles$StepBackgroundImageStyle = this.f28937c;
        if (stepStyles$StepBackgroundImageStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepBackgroundImageStyle.writeToParcel(parcel, i10);
        }
        StepStyles$GovernmentIdStepTitleComponentStyle stepStyles$GovernmentIdStepTitleComponentStyle = this.f28938d;
        if (stepStyles$GovernmentIdStepTitleComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$GovernmentIdStepTitleComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$GovernmentIdStepTextBasedComponentStyle stepStyles$GovernmentIdStepTextBasedComponentStyle = this.f28939e;
        if (stepStyles$GovernmentIdStepTextBasedComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$GovernmentIdStepTextBasedComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$GovernmentIdStepPrimaryButtonComponentStyle stepStyles$GovernmentIdStepPrimaryButtonComponentStyle = this.f28940f;
        if (stepStyles$GovernmentIdStepPrimaryButtonComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$GovernmentIdStepPrimaryButtonComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$GovernmentIdStepSecondaryButtonComponentStyle stepStyles$GovernmentIdStepSecondaryButtonComponentStyle = this.f28941g;
        if (stepStyles$GovernmentIdStepSecondaryButtonComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$GovernmentIdStepSecondaryButtonComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepTextBasedComponentStyle stepStyles$StepTextBasedComponentStyle = this.f28942h;
        if (stepStyles$StepTextBasedComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepTextBasedComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$GovernmentIdStepRowHeight stepStyles$GovernmentIdStepRowHeight = this.f28943j;
        if (stepStyles$GovernmentIdStepRowHeight == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$GovernmentIdStepRowHeight.writeToParcel(parcel, i10);
        }
        StepStyles$GovernmentIdStepStrokeColor stepStyles$GovernmentIdStepStrokeColor = this.f28944k;
        if (stepStyles$GovernmentIdStepStrokeColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$GovernmentIdStepStrokeColor.writeToParcel(parcel, i10);
        }
        StepStyles$GovernmentIdStepFillColor stepStyles$GovernmentIdStepFillColor = this.f28945l;
        if (stepStyles$GovernmentIdStepFillColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$GovernmentIdStepFillColor.writeToParcel(parcel, i10);
        }
        StepStyles$GovernmentIdStepBorderColor stepStyles$GovernmentIdStepBorderColor = this.f28946m;
        if (stepStyles$GovernmentIdStepBorderColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$GovernmentIdStepBorderColor.writeToParcel(parcel, i10);
        }
        StepStyles$GovernmentIdStepBorderRadius stepStyles$GovernmentIdStepBorderRadius = this.f28947n;
        if (stepStyles$GovernmentIdStepBorderRadius == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$GovernmentIdStepBorderRadius.writeToParcel(parcel, i10);
        }
        StepStyles$GovernmentIdStepBorderWidth stepStyles$GovernmentIdStepBorderWidth = this.f28948p;
        if (stepStyles$GovernmentIdStepBorderWidth == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$GovernmentIdStepBorderWidth.writeToParcel(parcel, i10);
        }
        StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle = this.f28949q;
        if (stepStyles$StepPaddingStyle == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepPaddingStyle.writeToParcel(parcel, i10);
    }

    public final String x() {
        StyleElements.SimpleElementColor d10;
        StyleElements.SimpleElementColorValue a10;
        StepStyles$GovernmentIdStepBorderColor stepStyles$GovernmentIdStepBorderColor = this.f28946m;
        if (stepStyles$GovernmentIdStepBorderColor == null || (d10 = stepStyles$GovernmentIdStepBorderColor.d()) == null || (a10 = d10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final Double z() {
        StyleElements.DPMeasurement c10;
        StyleElements.DPSize a10;
        StepStyles$GovernmentIdStepBorderRadius stepStyles$GovernmentIdStepBorderRadius = this.f28947n;
        if (stepStyles$GovernmentIdStepBorderRadius == null || (c10 = stepStyles$GovernmentIdStepBorderRadius.c()) == null || (a10 = c10.a()) == null) {
            return null;
        }
        return a10.a();
    }
}
