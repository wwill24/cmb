package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$HeaderButtonColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$HeaderButtonColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28418a;

    public static final class a implements Parcelable.Creator<AttributeStyles$HeaderButtonColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$HeaderButtonColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$HeaderButtonColorStyle(parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$HeaderButtonColorStyle[] newArray(int i10) {
            return new AttributeStyles$HeaderButtonColorStyle[i10];
        }
    }

    public AttributeStyles$HeaderButtonColorStyle(StyleElements.SimpleElementColor simpleElementColor) {
        this.f28418a = simpleElementColor;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28418a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28418a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor.writeToParcel(parcel, i10);
    }
}
