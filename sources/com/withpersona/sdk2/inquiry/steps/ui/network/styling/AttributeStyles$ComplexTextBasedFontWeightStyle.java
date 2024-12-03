package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ComplexTextBasedFontWeightStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ComplexTextBasedFontWeightStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.FontWeightContainer f28380a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.FontWeightContainer f28381b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.FontWeightContainer f28382c;

    /* renamed from: d  reason: collision with root package name */
    private final StyleElements.FontWeightContainer f28383d;

    public static final class a implements Parcelable.Creator<AttributeStyles$ComplexTextBasedFontWeightStyle> {
        /* renamed from: a */
        public final AttributeStyles$ComplexTextBasedFontWeightStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.FontWeightContainer fontWeightContainer = null;
            StyleElements.FontWeightContainer createFromParcel = parcel.readInt() == 0 ? null : StyleElements.FontWeightContainer.CREATOR.createFromParcel(parcel);
            StyleElements.FontWeightContainer createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.FontWeightContainer.CREATOR.createFromParcel(parcel);
            StyleElements.FontWeightContainer createFromParcel3 = parcel.readInt() == 0 ? null : StyleElements.FontWeightContainer.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                fontWeightContainer = StyleElements.FontWeightContainer.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$ComplexTextBasedFontWeightStyle(createFromParcel, createFromParcel2, createFromParcel3, fontWeightContainer);
        }

        /* renamed from: b */
        public final AttributeStyles$ComplexTextBasedFontWeightStyle[] newArray(int i10) {
            return new AttributeStyles$ComplexTextBasedFontWeightStyle[i10];
        }
    }

    public AttributeStyles$ComplexTextBasedFontWeightStyle(StyleElements.FontWeightContainer fontWeightContainer, StyleElements.FontWeightContainer fontWeightContainer2, StyleElements.FontWeightContainer fontWeightContainer3, StyleElements.FontWeightContainer fontWeightContainer4) {
        this.f28380a = fontWeightContainer;
        this.f28381b = fontWeightContainer2;
        this.f28382c = fontWeightContainer3;
        this.f28383d = fontWeightContainer4;
    }

    public final StyleElements.FontWeightContainer a() {
        return this.f28383d;
    }

    public final StyleElements.FontWeightContainer c() {
        return this.f28382c;
    }

    public final StyleElements.FontWeightContainer d() {
        return this.f28381b;
    }

    public int describeContents() {
        return 0;
    }

    public final StyleElements.FontWeightContainer e() {
        return this.f28380a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.FontWeightContainer fontWeightContainer = this.f28380a;
        if (fontWeightContainer == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fontWeightContainer.writeToParcel(parcel, i10);
        }
        StyleElements.FontWeightContainer fontWeightContainer2 = this.f28381b;
        if (fontWeightContainer2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fontWeightContainer2.writeToParcel(parcel, i10);
        }
        StyleElements.FontWeightContainer fontWeightContainer3 = this.f28382c;
        if (fontWeightContainer3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fontWeightContainer3.writeToParcel(parcel, i10);
        }
        StyleElements.FontWeightContainer fontWeightContainer4 = this.f28383d;
        if (fontWeightContainer4 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        fontWeightContainer4.writeToParcel(parcel, i10);
    }
}
