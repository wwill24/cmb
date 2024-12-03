package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$InputRadioGroupFontWeightStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$InputRadioGroupFontWeightStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.FontWeightContainer f28435a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.FontWeightContainer f28436b;

    public static final class a implements Parcelable.Creator<AttributeStyles$InputRadioGroupFontWeightStyle> {
        /* renamed from: a */
        public final AttributeStyles$InputRadioGroupFontWeightStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.FontWeightContainer fontWeightContainer = null;
            StyleElements.FontWeightContainer createFromParcel = parcel.readInt() == 0 ? null : StyleElements.FontWeightContainer.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                fontWeightContainer = StyleElements.FontWeightContainer.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$InputRadioGroupFontWeightStyle(createFromParcel, fontWeightContainer);
        }

        /* renamed from: b */
        public final AttributeStyles$InputRadioGroupFontWeightStyle[] newArray(int i10) {
            return new AttributeStyles$InputRadioGroupFontWeightStyle[i10];
        }
    }

    public AttributeStyles$InputRadioGroupFontWeightStyle(StyleElements.FontWeightContainer fontWeightContainer, StyleElements.FontWeightContainer fontWeightContainer2) {
        this.f28435a = fontWeightContainer;
        this.f28436b = fontWeightContainer2;
    }

    public final StyleElements.FontWeightContainer a() {
        return this.f28435a;
    }

    public final StyleElements.FontWeightContainer c() {
        return this.f28436b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.FontWeightContainer fontWeightContainer = this.f28435a;
        if (fontWeightContainer == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fontWeightContainer.writeToParcel(parcel, i10);
        }
        StyleElements.FontWeightContainer fontWeightContainer2 = this.f28436b;
        if (fontWeightContainer2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        fontWeightContainer2.writeToParcel(parcel, i10);
    }
}
