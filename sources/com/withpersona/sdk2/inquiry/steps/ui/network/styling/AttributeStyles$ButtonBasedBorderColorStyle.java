package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ButtonBasedBorderColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ButtonBasedBorderColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28347a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ButtonBasedBorderColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$ButtonBasedBorderColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ButtonBasedBorderColorStyle(parcel.readInt() == 0 ? null : StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ButtonBasedBorderColorStyle[] newArray(int i10) {
            return new AttributeStyles$ButtonBasedBorderColorStyle[i10];
        }
    }

    public AttributeStyles$ButtonBasedBorderColorStyle(StyleElements.ComplexElementColor complexElementColor) {
        this.f28347a = complexElementColor;
    }

    public final StyleElements.ComplexElementColor a() {
        return this.f28347a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.ComplexElementColor complexElementColor = this.f28347a;
        if (complexElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        complexElementColor.writeToParcel(parcel, i10);
    }
}
