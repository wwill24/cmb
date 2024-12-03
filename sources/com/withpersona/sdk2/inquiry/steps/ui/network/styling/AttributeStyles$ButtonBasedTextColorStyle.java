package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ButtonBasedTextColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ButtonBasedTextColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28359a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ButtonBasedTextColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$ButtonBasedTextColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ButtonBasedTextColorStyle(parcel.readInt() == 0 ? null : StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ButtonBasedTextColorStyle[] newArray(int i10) {
            return new AttributeStyles$ButtonBasedTextColorStyle[i10];
        }
    }

    public AttributeStyles$ButtonBasedTextColorStyle(StyleElements.ComplexElementColor complexElementColor) {
        this.f28359a = complexElementColor;
    }

    public final StyleElements.ComplexElementColor a() {
        return this.f28359a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.ComplexElementColor complexElementColor = this.f28359a;
        if (complexElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        complexElementColor.writeToParcel(parcel, i10);
    }
}
