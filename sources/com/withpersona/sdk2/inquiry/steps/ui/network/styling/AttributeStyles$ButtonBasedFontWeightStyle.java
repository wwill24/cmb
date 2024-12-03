package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ButtonBasedFontWeightStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ButtonBasedFontWeightStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.FontWeightContainer f28352a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ButtonBasedFontWeightStyle> {
        /* renamed from: a */
        public final AttributeStyles$ButtonBasedFontWeightStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ButtonBasedFontWeightStyle(parcel.readInt() == 0 ? null : StyleElements.FontWeightContainer.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ButtonBasedFontWeightStyle[] newArray(int i10) {
            return new AttributeStyles$ButtonBasedFontWeightStyle[i10];
        }
    }

    public AttributeStyles$ButtonBasedFontWeightStyle(StyleElements.FontWeightContainer fontWeightContainer) {
        this.f28352a = fontWeightContainer;
    }

    public final StyleElements.FontWeightContainer a() {
        return this.f28352a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.FontWeightContainer fontWeightContainer = this.f28352a;
        if (fontWeightContainer == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        fontWeightContainer.writeToParcel(parcel, i10);
    }
}
