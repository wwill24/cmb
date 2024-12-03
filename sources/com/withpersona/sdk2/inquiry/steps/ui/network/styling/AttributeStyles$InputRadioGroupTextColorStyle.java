package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$InputRadioGroupTextColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$InputRadioGroupTextColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28441a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28442b;

    public static final class a implements Parcelable.Creator<AttributeStyles$InputRadioGroupTextColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$InputRadioGroupTextColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.SimpleElementColor simpleElementColor = null;
            StyleElements.SimpleElementColor createFromParcel = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                simpleElementColor = StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$InputRadioGroupTextColorStyle(createFromParcel, simpleElementColor);
        }

        /* renamed from: b */
        public final AttributeStyles$InputRadioGroupTextColorStyle[] newArray(int i10) {
            return new AttributeStyles$InputRadioGroupTextColorStyle[i10];
        }
    }

    public AttributeStyles$InputRadioGroupTextColorStyle(StyleElements.SimpleElementColor simpleElementColor, StyleElements.SimpleElementColor simpleElementColor2) {
        this.f28441a = simpleElementColor;
        this.f28442b = simpleElementColor2;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28441a;
    }

    public final StyleElements.SimpleElementColor c() {
        return this.f28442b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28441a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor2 = this.f28442b;
        if (simpleElementColor2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor2.writeToParcel(parcel, i10);
    }
}
