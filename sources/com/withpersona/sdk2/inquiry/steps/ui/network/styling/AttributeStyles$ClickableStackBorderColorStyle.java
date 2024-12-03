package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ClickableStackBorderColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ClickableStackBorderColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28364a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ClickableStackBorderColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$ClickableStackBorderColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ClickableStackBorderColorStyle(parcel.readInt() == 0 ? null : StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ClickableStackBorderColorStyle[] newArray(int i10) {
            return new AttributeStyles$ClickableStackBorderColorStyle[i10];
        }
    }

    public AttributeStyles$ClickableStackBorderColorStyle(StyleElements.ComplexElementColor complexElementColor) {
        this.f28364a = complexElementColor;
    }

    public final StyleElements.ComplexElementColor a() {
        return this.f28364a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.ComplexElementColor complexElementColor = this.f28364a;
        if (complexElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        complexElementColor.writeToParcel(parcel, i10);
    }
}
