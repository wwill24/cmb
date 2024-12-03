package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ButtonBasedBackgroundColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ButtonBasedBackgroundColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28346a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ButtonBasedBackgroundColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$ButtonBasedBackgroundColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ButtonBasedBackgroundColorStyle(parcel.readInt() == 0 ? null : StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ButtonBasedBackgroundColorStyle[] newArray(int i10) {
            return new AttributeStyles$ButtonBasedBackgroundColorStyle[i10];
        }
    }

    public AttributeStyles$ButtonBasedBackgroundColorStyle(StyleElements.ComplexElementColor complexElementColor) {
        this.f28346a = complexElementColor;
    }

    public final StyleElements.ComplexElementColor a() {
        return this.f28346a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.ComplexElementColor complexElementColor = this.f28346a;
        if (complexElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        complexElementColor.writeToParcel(parcel, i10);
    }
}
