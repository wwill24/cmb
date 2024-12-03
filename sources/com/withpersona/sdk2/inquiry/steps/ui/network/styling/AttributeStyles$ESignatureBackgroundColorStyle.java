package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ESignatureBackgroundColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ESignatureBackgroundColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28408a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28409b;

    public static final class a implements Parcelable.Creator<AttributeStyles$ESignatureBackgroundColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$ESignatureBackgroundColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.SimpleElementColor simpleElementColor = null;
            StyleElements.ComplexElementColor createFromParcel = parcel.readInt() == 0 ? null : StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                simpleElementColor = StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$ESignatureBackgroundColorStyle(createFromParcel, simpleElementColor);
        }

        /* renamed from: b */
        public final AttributeStyles$ESignatureBackgroundColorStyle[] newArray(int i10) {
            return new AttributeStyles$ESignatureBackgroundColorStyle[i10];
        }
    }

    public AttributeStyles$ESignatureBackgroundColorStyle(StyleElements.ComplexElementColor complexElementColor, StyleElements.SimpleElementColor simpleElementColor) {
        this.f28408a = complexElementColor;
        this.f28409b = simpleElementColor;
    }

    public final StyleElements.ComplexElementColor a() {
        return this.f28408a;
    }

    public final StyleElements.SimpleElementColor c() {
        return this.f28409b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.ComplexElementColor complexElementColor = this.f28408a;
        if (complexElementColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            complexElementColor.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor = this.f28409b;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor.writeToParcel(parcel, i10);
    }
}
