package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class LocalImageComponentStyle implements Parcelable {
    public static final Parcelable.Creator<LocalImageComponentStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AttributeStyles$LocalImageStrokeColorStyle f28866a;

    /* renamed from: b  reason: collision with root package name */
    private final AttributeStyles$LocalImageFillColorStyle f28867b;

    /* renamed from: c  reason: collision with root package name */
    private final AttributeStyles$LocalImageHeightStyle f28868c;

    /* renamed from: d  reason: collision with root package name */
    private final AttributeStyles$LocalImageWidthStyle f28869d;

    /* renamed from: e  reason: collision with root package name */
    private final AttributeStyles$LocalImageJustifyStyle f28870e;

    /* renamed from: f  reason: collision with root package name */
    private final AttributeStyles$LocalImageMarginStyle f28871f;

    public static final class a implements Parcelable.Creator<LocalImageComponentStyle> {
        /* renamed from: a */
        public final LocalImageComponentStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            AttributeStyles$LocalImageMarginStyle attributeStyles$LocalImageMarginStyle = null;
            AttributeStyles$LocalImageStrokeColorStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$LocalImageStrokeColorStyle.CREATOR.createFromParcel(parcel);
            AttributeStyles$LocalImageFillColorStyle createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$LocalImageFillColorStyle.CREATOR.createFromParcel(parcel);
            AttributeStyles$LocalImageHeightStyle createFromParcel3 = parcel.readInt() == 0 ? null : AttributeStyles$LocalImageHeightStyle.CREATOR.createFromParcel(parcel);
            AttributeStyles$LocalImageWidthStyle createFromParcel4 = parcel.readInt() == 0 ? null : AttributeStyles$LocalImageWidthStyle.CREATOR.createFromParcel(parcel);
            AttributeStyles$LocalImageJustifyStyle createFromParcel5 = parcel.readInt() == 0 ? null : AttributeStyles$LocalImageJustifyStyle.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                attributeStyles$LocalImageMarginStyle = AttributeStyles$LocalImageMarginStyle.CREATOR.createFromParcel(parcel);
            }
            return new LocalImageComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, attributeStyles$LocalImageMarginStyle);
        }

        /* renamed from: b */
        public final LocalImageComponentStyle[] newArray(int i10) {
            return new LocalImageComponentStyle[i10];
        }
    }

    public LocalImageComponentStyle(AttributeStyles$LocalImageStrokeColorStyle attributeStyles$LocalImageStrokeColorStyle, AttributeStyles$LocalImageFillColorStyle attributeStyles$LocalImageFillColorStyle, AttributeStyles$LocalImageHeightStyle attributeStyles$LocalImageHeightStyle, AttributeStyles$LocalImageWidthStyle attributeStyles$LocalImageWidthStyle, AttributeStyles$LocalImageJustifyStyle attributeStyles$LocalImageJustifyStyle, AttributeStyles$LocalImageMarginStyle attributeStyles$LocalImageMarginStyle) {
        this.f28866a = attributeStyles$LocalImageStrokeColorStyle;
        this.f28867b = attributeStyles$LocalImageFillColorStyle;
        this.f28868c = attributeStyles$LocalImageHeightStyle;
        this.f28869d = attributeStyles$LocalImageWidthStyle;
        this.f28870e = attributeStyles$LocalImageJustifyStyle;
        this.f28871f = attributeStyles$LocalImageMarginStyle;
    }

    public final String A0() {
        StyleElements.SimpleElementColor c10;
        StyleElements.SimpleElementColorValue a10;
        AttributeStyles$LocalImageFillColorStyle attributeStyles$LocalImageFillColorStyle = this.f28867b;
        if (attributeStyles$LocalImageFillColorStyle == null || (c10 = attributeStyles$LocalImageFillColorStyle.c()) == null || (a10 = c10.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final String C() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        AttributeStyles$LocalImageStrokeColorStyle attributeStyles$LocalImageStrokeColorStyle = this.f28866a;
        if (attributeStyles$LocalImageStrokeColorStyle == null || (a10 = attributeStyles$LocalImageStrokeColorStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final String V1() {
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        AttributeStyles$LocalImageFillColorStyle attributeStyles$LocalImageFillColorStyle = this.f28867b;
        if (attributeStyles$LocalImageFillColorStyle == null || (a10 = attributeStyles$LocalImageFillColorStyle.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final AttributeStyles$LocalImageFillColorStyle a() {
        return this.f28867b;
    }

    public final AttributeStyles$LocalImageHeightStyle c() {
        return this.f28868c;
    }

    public final StyleElements.Size d() {
        StyleElements.Measurement a10;
        AttributeStyles$LocalImageHeightStyle attributeStyles$LocalImageHeightStyle = this.f28868c;
        if (attributeStyles$LocalImageHeightStyle == null || (a10 = attributeStyles$LocalImageHeightStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public int describeContents() {
        return 0;
    }

    public final AttributeStyles$LocalImageJustifyStyle e() {
        return this.f28870e;
    }

    public final AttributeStyles$LocalImageMarginStyle f() {
        return this.f28871f;
    }

    public final StyleElements.DPSizeSet g() {
        StyleElements.DPMeasurementSet a10;
        AttributeStyles$LocalImageMarginStyle attributeStyles$LocalImageMarginStyle = this.f28871f;
        if (attributeStyles$LocalImageMarginStyle == null || (a10 = attributeStyles$LocalImageMarginStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public final AttributeStyles$LocalImageStrokeColorStyle h() {
        return this.f28866a;
    }

    public final AttributeStyles$LocalImageWidthStyle i() {
        return this.f28869d;
    }

    public final StyleElements.Size j() {
        StyleElements.Measurement a10;
        AttributeStyles$LocalImageWidthStyle attributeStyles$LocalImageWidthStyle = this.f28869d;
        if (attributeStyles$LocalImageWidthStyle == null || (a10 = attributeStyles$LocalImageWidthStyle.a()) == null) {
            return null;
        }
        return a10.a();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        AttributeStyles$LocalImageStrokeColorStyle attributeStyles$LocalImageStrokeColorStyle = this.f28866a;
        if (attributeStyles$LocalImageStrokeColorStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$LocalImageStrokeColorStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$LocalImageFillColorStyle attributeStyles$LocalImageFillColorStyle = this.f28867b;
        if (attributeStyles$LocalImageFillColorStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$LocalImageFillColorStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$LocalImageHeightStyle attributeStyles$LocalImageHeightStyle = this.f28868c;
        if (attributeStyles$LocalImageHeightStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$LocalImageHeightStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$LocalImageWidthStyle attributeStyles$LocalImageWidthStyle = this.f28869d;
        if (attributeStyles$LocalImageWidthStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$LocalImageWidthStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$LocalImageJustifyStyle attributeStyles$LocalImageJustifyStyle = this.f28870e;
        if (attributeStyles$LocalImageJustifyStyle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            attributeStyles$LocalImageJustifyStyle.writeToParcel(parcel, i10);
        }
        AttributeStyles$LocalImageMarginStyle attributeStyles$LocalImageMarginStyle = this.f28871f;
        if (attributeStyles$LocalImageMarginStyle == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        attributeStyles$LocalImageMarginStyle.writeToParcel(parcel, i10);
    }
}
