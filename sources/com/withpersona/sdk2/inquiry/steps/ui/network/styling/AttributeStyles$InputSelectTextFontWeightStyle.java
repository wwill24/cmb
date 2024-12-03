package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$InputSelectTextFontWeightStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$InputSelectTextFontWeightStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.FontWeightContainer f28458a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.FontWeightContainer f28459b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.FontWeightContainer f28460c;

    public static final class a implements Parcelable.Creator<AttributeStyles$InputSelectTextFontWeightStyle> {
        /* renamed from: a */
        public final AttributeStyles$InputSelectTextFontWeightStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.FontWeightContainer fontWeightContainer = null;
            StyleElements.FontWeightContainer createFromParcel = parcel.readInt() == 0 ? null : StyleElements.FontWeightContainer.CREATOR.createFromParcel(parcel);
            StyleElements.FontWeightContainer createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.FontWeightContainer.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                fontWeightContainer = StyleElements.FontWeightContainer.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$InputSelectTextFontWeightStyle(createFromParcel, createFromParcel2, fontWeightContainer);
        }

        /* renamed from: b */
        public final AttributeStyles$InputSelectTextFontWeightStyle[] newArray(int i10) {
            return new AttributeStyles$InputSelectTextFontWeightStyle[i10];
        }
    }

    public AttributeStyles$InputSelectTextFontWeightStyle(StyleElements.FontWeightContainer fontWeightContainer, StyleElements.FontWeightContainer fontWeightContainer2, StyleElements.FontWeightContainer fontWeightContainer3) {
        this.f28458a = fontWeightContainer;
        this.f28459b = fontWeightContainer2;
        this.f28460c = fontWeightContainer3;
    }

    public final StyleElements.FontWeightContainer a() {
        return this.f28458a;
    }

    public final StyleElements.FontWeightContainer c() {
        return this.f28460c;
    }

    public final StyleElements.FontWeightContainer d() {
        return this.f28459b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.FontWeightContainer fontWeightContainer = this.f28458a;
        if (fontWeightContainer == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fontWeightContainer.writeToParcel(parcel, i10);
        }
        StyleElements.FontWeightContainer fontWeightContainer2 = this.f28459b;
        if (fontWeightContainer2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fontWeightContainer2.writeToParcel(parcel, i10);
        }
        StyleElements.FontWeightContainer fontWeightContainer3 = this.f28460c;
        if (fontWeightContainer3 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        fontWeightContainer3.writeToParcel(parcel, i10);
    }
}
