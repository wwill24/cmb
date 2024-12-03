package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.g;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$UiStepStyle implements StepStyle {
    public static final Parcelable.Creator<StepStyles$UiStepStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AttributeStyles$HeaderButtonColorStyle f29002a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$StepBackgroundColorStyle f29003b;

    /* renamed from: c  reason: collision with root package name */
    private final StepStyles$StepBackgroundImageStyle f29004c;

    /* renamed from: d  reason: collision with root package name */
    private final StepStyles$UiStepTitleComponentStyle f29005d;

    /* renamed from: e  reason: collision with root package name */
    private final StepStyles$UiStepTextBasedComponentStyle f29006e;

    /* renamed from: f  reason: collision with root package name */
    private final StepStyles$StepPrimaryButtonComponentStyle f29007f;

    /* renamed from: g  reason: collision with root package name */
    private final StepStyles$StepSecondaryButtonComponentStyle f29008g;

    /* renamed from: h  reason: collision with root package name */
    private final StepStyles$UiStepStrokeColor f29009h;

    /* renamed from: j  reason: collision with root package name */
    private final StepStyles$UiStepFillColor f29010j;

    /* renamed from: k  reason: collision with root package name */
    private final StepStyles$UiStepAlignment f29011k;

    /* renamed from: l  reason: collision with root package name */
    private final StepStyles$StepPaddingStyle f29012l;

    /* renamed from: m  reason: collision with root package name */
    private final StepStyles$StepBorderRadiusStyle f29013m;

    public static final class a implements Parcelable.Creator<StepStyles$UiStepStyle> {
        /* renamed from: a */
        public final StepStyles$UiStepStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StepStyles$StepBorderRadiusStyle stepStyles$StepBorderRadiusStyle = null;
            AttributeStyles$HeaderButtonColorStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$HeaderButtonColorStyle.CREATOR.createFromParcel(parcel);
            StepStyles$StepBackgroundColorStyle createFromParcel2 = parcel.readInt() == 0 ? null : StepStyles$StepBackgroundColorStyle.CREATOR.createFromParcel(parcel);
            StepStyles$StepBackgroundImageStyle createFromParcel3 = parcel.readInt() == 0 ? null : StepStyles$StepBackgroundImageStyle.CREATOR.createFromParcel(parcel);
            StepStyles$UiStepTitleComponentStyle createFromParcel4 = parcel.readInt() == 0 ? null : StepStyles$UiStepTitleComponentStyle.CREATOR.createFromParcel(parcel);
            StepStyles$UiStepTextBasedComponentStyle createFromParcel5 = parcel.readInt() == 0 ? null : StepStyles$UiStepTextBasedComponentStyle.CREATOR.createFromParcel(parcel);
            StepStyles$StepPrimaryButtonComponentStyle createFromParcel6 = parcel.readInt() == 0 ? null : StepStyles$StepPrimaryButtonComponentStyle.CREATOR.createFromParcel(parcel);
            StepStyles$StepSecondaryButtonComponentStyle createFromParcel7 = parcel.readInt() == 0 ? null : StepStyles$StepSecondaryButtonComponentStyle.CREATOR.createFromParcel(parcel);
            StepStyles$UiStepStrokeColor createFromParcel8 = parcel.readInt() == 0 ? null : StepStyles$UiStepStrokeColor.CREATOR.createFromParcel(parcel);
            StepStyles$UiStepFillColor createFromParcel9 = parcel.readInt() == 0 ? null : StepStyles$UiStepFillColor.CREATOR.createFromParcel(parcel);
            StepStyles$UiStepAlignment createFromParcel10 = parcel.readInt() == 0 ? null : StepStyles$UiStepAlignment.CREATOR.createFromParcel(parcel);
            StepStyles$StepPaddingStyle createFromParcel11 = parcel.readInt() == 0 ? null : StepStyles$StepPaddingStyle.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                stepStyles$StepBorderRadiusStyle = StepStyles$StepBorderRadiusStyle.CREATOR.createFromParcel(parcel);
            }
            return new StepStyles$UiStepStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, createFromParcel9, createFromParcel10, createFromParcel11, stepStyles$StepBorderRadiusStyle);
        }

        /* renamed from: b */
        public final StepStyles$UiStepStyle[] newArray(int i10) {
            return new StepStyles$UiStepStyle[i10];
        }
    }

    public StepStyles$UiStepStyle(@g(name = "textColor") AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle, StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle, StepStyles$StepBackgroundImageStyle stepStyles$StepBackgroundImageStyle, StepStyles$UiStepTitleComponentStyle stepStyles$UiStepTitleComponentStyle, StepStyles$UiStepTextBasedComponentStyle stepStyles$UiStepTextBasedComponentStyle, StepStyles$StepPrimaryButtonComponentStyle stepStyles$StepPrimaryButtonComponentStyle, StepStyles$StepSecondaryButtonComponentStyle stepStyles$StepSecondaryButtonComponentStyle, StepStyles$UiStepStrokeColor stepStyles$UiStepStrokeColor, StepStyles$UiStepFillColor stepStyles$UiStepFillColor, StepStyles$UiStepAlignment stepStyles$UiStepAlignment, StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle, StepStyles$StepBorderRadiusStyle stepStyles$StepBorderRadiusStyle) {
        this.f29002a = attributeStyles$HeaderButtonColorStyle;
        this.f29003b = stepStyles$StepBackgroundColorStyle;
        this.f29004c = stepStyles$StepBackgroundImageStyle;
        this.f29005d = stepStyles$UiStepTitleComponentStyle;
        this.f29006e = stepStyles$UiStepTextBasedComponentStyle;
        this.f29007f = stepStyles$StepPrimaryButtonComponentStyle;
        this.f29008g = stepStyles$StepSecondaryButtonComponentStyle;
        this.f29009h = stepStyles$UiStepStrokeColor;
        this.f29010j = stepStyles$UiStepFillColor;
        this.f29011k = stepStyles$UiStepAlignment;
        this.f29012l = stepStyles$StepPaddingStyle;
        this.f29013m = stepStyles$StepBorderRadiusStyle;
    }

    public String A0() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$UiStepFillColor stepStyles$UiStepFillColor = this.f29010j;
        if (stepStyles$UiStepFillColor == null || (a10 = stepStyles$UiStepFillColor.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public String C() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$UiStepStrokeColor stepStyles$UiStepStrokeColor = this.f29009h;
        if (stepStyles$UiStepStrokeColor == null || (a10 = stepStyles$UiStepStrokeColor.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public TextBasedComponentStyle H1() {
        StepStyles$StepTextBasedComponentStyleContainer a10;
        StepStyles$UiStepTextBasedComponentStyle stepStyles$UiStepTextBasedComponentStyle = this.f29006e;
        if (stepStyles$UiStepTextBasedComponentStyle == null || (a10 = stepStyles$UiStepTextBasedComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public StyleElements.DPSize N() {
        StyleElements.DPMeasurement a10;
        StepStyles$StepBorderRadiusStyle stepStyles$StepBorderRadiusStyle = this.f29013m;
        if (stepStyles$StepBorderRadiusStyle == null || (a10 = stepStyles$StepBorderRadiusStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public StyleElements.DPSizeSet T1() {
        StepStyles$StepPaddingStyleContainer a10;
        StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle = this.f29012l;
        if (stepStyles$StepPaddingStyle == null || (a10 = stepStyles$StepPaddingStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public String V1() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle = this.f29003b;
        if (stepStyles$StepBackgroundColorStyle == null || (a10 = stepStyles$StepBackgroundColorStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public ButtonSubmitComponentStyle X1() {
        StepStyles$StepSubmitButtonComponentStyleContainer a10;
        StepStyles$StepPrimaryButtonComponentStyle stepStyles$StepPrimaryButtonComponentStyle = this.f29007f;
        if (stepStyles$StepPrimaryButtonComponentStyle == null || (a10 = stepStyles$StepPrimaryButtonComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final StepStyles$UiStepAlignment a() {
        return this.f29011k;
    }

    public final StepStyles$StepBackgroundColorStyle c() {
        return this.f29003b;
    }

    public final StepStyles$StepBackgroundImageStyle d() {
        return this.f29004c;
    }

    public int describeContents() {
        return 0;
    }

    public final StepStyles$StepBorderRadiusStyle e() {
        return this.f29013m;
    }

    public TextBasedComponentStyle e1() {
        StepStyles$StepTextBasedComponentStyleContainer a10;
        StepStyles$UiStepTitleComponentStyle stepStyles$UiStepTitleComponentStyle = this.f29005d;
        if (stepStyles$UiStepTitleComponentStyle == null || (a10 = stepStyles$UiStepTitleComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final StepStyles$StepPrimaryButtonComponentStyle f() {
        return this.f29007f;
    }

    public final StepStyles$StepSecondaryButtonComponentStyle g() {
        return this.f29008g;
    }

    public final StepStyles$UiStepFillColor h() {
        return this.f29010j;
    }

    public final AttributeStyles$HeaderButtonColorStyle i() {
        return this.f29002a;
    }

    public final StepStyles$StepPaddingStyle j() {
        return this.f29012l;
    }

    public final StyleElements.PositionType k() {
        StyleElements.Position a10;
        StepStyles$UiStepAlignment stepStyles$UiStepAlignment = this.f29011k;
        if (stepStyles$UiStepAlignment == null || (a10 = stepStyles$UiStepAlignment.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final StepStyles$UiStepStrokeColor l() {
        return this.f29009h;
    }

    public final StepStyles$UiStepTextBasedComponentStyle m() {
        return this.f29006e;
    }

    public final StepStyles$UiStepTitleComponentStyle n() {
        return this.f29005d;
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
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$StepBackgroundImageStyle r0 = r1.f29004c
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
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle.r1(android.content.Context):android.graphics.drawable.Drawable");
    }

    public TextBasedComponentStyle v() {
        StepStyles$StepTextBasedComponentStyleContainer c10;
        StepStyles$UiStepTitleComponentStyle stepStyles$UiStepTitleComponentStyle = this.f29005d;
        if (stepStyles$UiStepTitleComponentStyle == null || (c10 = stepStyles$UiStepTitleComponentStyle.c()) == null) {
            return null;
        }
        return c10.a();
    }

    public ButtonCancelComponentStyle v0() {
        StepStyles$StepCancelButtonComponentStyleContainer a10;
        StepStyles$StepSecondaryButtonComponentStyle stepStyles$StepSecondaryButtonComponentStyle = this.f29008g;
        if (stepStyles$StepSecondaryButtonComponentStyle == null || (a10 = stepStyles$StepSecondaryButtonComponentStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public TextBasedComponentStyle w1() {
        StepStyles$StepTextBasedComponentStyleContainer c10;
        StepStyles$UiStepTextBasedComponentStyle stepStyles$UiStepTextBasedComponentStyle = this.f29006e;
        if (stepStyles$UiStepTextBasedComponentStyle == null || (c10 = stepStyles$UiStepTextBasedComponentStyle.c()) == null) {
            return null;
        }
        return c10.a();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        AttributeStyles$HeaderButtonColorStyle attributeStyles$HeaderButtonColorStyle = this.f29002a;
        if (attributeStyles$HeaderButtonColorStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$HeaderButtonColorStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepBackgroundColorStyle stepStyles$StepBackgroundColorStyle = this.f29003b;
        if (stepStyles$StepBackgroundColorStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepBackgroundColorStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepBackgroundImageStyle stepStyles$StepBackgroundImageStyle = this.f29004c;
        if (stepStyles$StepBackgroundImageStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepBackgroundImageStyle.writeToParcel(parcel, i10);
        }
        StepStyles$UiStepTitleComponentStyle stepStyles$UiStepTitleComponentStyle = this.f29005d;
        if (stepStyles$UiStepTitleComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$UiStepTitleComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$UiStepTextBasedComponentStyle stepStyles$UiStepTextBasedComponentStyle = this.f29006e;
        if (stepStyles$UiStepTextBasedComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$UiStepTextBasedComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepPrimaryButtonComponentStyle stepStyles$StepPrimaryButtonComponentStyle = this.f29007f;
        if (stepStyles$StepPrimaryButtonComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepPrimaryButtonComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepSecondaryButtonComponentStyle stepStyles$StepSecondaryButtonComponentStyle = this.f29008g;
        if (stepStyles$StepSecondaryButtonComponentStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepSecondaryButtonComponentStyle.writeToParcel(parcel, i10);
        }
        StepStyles$UiStepStrokeColor stepStyles$UiStepStrokeColor = this.f29009h;
        if (stepStyles$UiStepStrokeColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$UiStepStrokeColor.writeToParcel(parcel, i10);
        }
        StepStyles$UiStepFillColor stepStyles$UiStepFillColor = this.f29010j;
        if (stepStyles$UiStepFillColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$UiStepFillColor.writeToParcel(parcel, i10);
        }
        StepStyles$UiStepAlignment stepStyles$UiStepAlignment = this.f29011k;
        if (stepStyles$UiStepAlignment == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$UiStepAlignment.writeToParcel(parcel, i10);
        }
        StepStyles$StepPaddingStyle stepStyles$StepPaddingStyle = this.f29012l;
        if (stepStyles$StepPaddingStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            stepStyles$StepPaddingStyle.writeToParcel(parcel, i10);
        }
        StepStyles$StepBorderRadiusStyle stepStyles$StepBorderRadiusStyle = this.f29013m;
        if (stepStyles$StepBorderRadiusStyle == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$StepBorderRadiusStyle.writeToParcel(parcel, i10);
    }
}
