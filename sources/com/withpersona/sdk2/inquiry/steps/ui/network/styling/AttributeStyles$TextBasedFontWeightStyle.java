package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$TextBasedFontWeightStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$TextBasedFontWeightStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.FontWeightContainer f28492a;

    public static final class a implements Parcelable.Creator<AttributeStyles$TextBasedFontWeightStyle> {
        /* renamed from: a */
        public final AttributeStyles$TextBasedFontWeightStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$TextBasedFontWeightStyle(parcel.readInt() == 0 ? null : StyleElements.FontWeightContainer.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$TextBasedFontWeightStyle[] newArray(int i10) {
            return new AttributeStyles$TextBasedFontWeightStyle[i10];
        }
    }

    public AttributeStyles$TextBasedFontWeightStyle(StyleElements.FontWeightContainer fontWeightContainer) {
        this.f28492a = fontWeightContainer;
    }

    public final StyleElements.FontWeightContainer a() {
        return this.f28492a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.FontWeightContainer fontWeightContainer = this.f28492a;
        if (fontWeightContainer == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        fontWeightContainer.writeToParcel(parcel, i10);
    }
}
