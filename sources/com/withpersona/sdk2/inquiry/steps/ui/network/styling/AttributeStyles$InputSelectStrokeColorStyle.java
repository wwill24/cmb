package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$InputSelectStrokeColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$InputSelectStrokeColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28447a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28448b;

    public static final class a implements Parcelable.Creator<AttributeStyles$InputSelectStrokeColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$InputSelectStrokeColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.SimpleElementColor simpleElementColor = null;
            StyleElements.SimpleElementColor createFromParcel = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                simpleElementColor = StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$InputSelectStrokeColorStyle(createFromParcel, simpleElementColor);
        }

        /* renamed from: b */
        public final AttributeStyles$InputSelectStrokeColorStyle[] newArray(int i10) {
            return new AttributeStyles$InputSelectStrokeColorStyle[i10];
        }
    }

    public AttributeStyles$InputSelectStrokeColorStyle(StyleElements.SimpleElementColor simpleElementColor, StyleElements.SimpleElementColor simpleElementColor2) {
        this.f28447a = simpleElementColor;
        this.f28448b = simpleElementColor2;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28447a;
    }

    public final StyleElements.SimpleElementColor c() {
        return this.f28448b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28447a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor2 = this.f28448b;
        if (simpleElementColor2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor2.writeToParcel(parcel, i10);
    }
}
