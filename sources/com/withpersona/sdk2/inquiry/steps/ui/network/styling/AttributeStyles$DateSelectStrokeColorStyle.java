package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$DateSelectStrokeColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$DateSelectStrokeColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28402a;

    public static final class a implements Parcelable.Creator<AttributeStyles$DateSelectStrokeColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$DateSelectStrokeColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$DateSelectStrokeColorStyle(parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$DateSelectStrokeColorStyle[] newArray(int i10) {
            return new AttributeStyles$DateSelectStrokeColorStyle[i10];
        }
    }

    public AttributeStyles$DateSelectStrokeColorStyle(StyleElements.SimpleElementColor simpleElementColor) {
        this.f28402a = simpleElementColor;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28402a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28402a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor.writeToParcel(parcel, i10);
    }
}
