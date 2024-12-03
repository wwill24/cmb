package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$TextBasedTextColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$TextBasedTextColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28497a;

    public static final class a implements Parcelable.Creator<AttributeStyles$TextBasedTextColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$TextBasedTextColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$TextBasedTextColorStyle(parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$TextBasedTextColorStyle[] newArray(int i10) {
            return new AttributeStyles$TextBasedTextColorStyle[i10];
        }
    }

    public AttributeStyles$TextBasedTextColorStyle(StyleElements.SimpleElementColor simpleElementColor) {
        this.f28497a = simpleElementColor;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28497a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28497a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor.writeToParcel(parcel, i10);
    }
}
