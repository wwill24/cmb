package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$LocalImageStrokeColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$LocalImageStrokeColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28477a;

    public static final class a implements Parcelable.Creator<AttributeStyles$LocalImageStrokeColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$LocalImageStrokeColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$LocalImageStrokeColorStyle(parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$LocalImageStrokeColorStyle[] newArray(int i10) {
            return new AttributeStyles$LocalImageStrokeColorStyle[i10];
        }
    }

    public AttributeStyles$LocalImageStrokeColorStyle(StyleElements.SimpleElementColor simpleElementColor) {
        this.f28477a = simpleElementColor;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28477a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28477a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor.writeToParcel(parcel, i10);
    }
}
