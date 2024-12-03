package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$DateSelectTextColorStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$DateSelectTextColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28403a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28404b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28405c;

    /* renamed from: d  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28406d;

    /* renamed from: e  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28407e;

    public static final class a implements Parcelable.Creator<AttributeStyles$DateSelectTextColorStyle> {
        /* renamed from: a */
        public final AttributeStyles$DateSelectTextColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.SimpleElementColor simpleElementColor = null;
            StyleElements.ComplexElementColor createFromParcel = parcel.readInt() == 0 ? null : StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel);
            StyleElements.ComplexElementColor createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel);
            StyleElements.ComplexElementColor createFromParcel3 = parcel.readInt() == 0 ? null : StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel);
            StyleElements.ComplexElementColor createFromParcel4 = parcel.readInt() == 0 ? null : StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                simpleElementColor = StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$DateSelectTextColorStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, simpleElementColor);
        }

        /* renamed from: b */
        public final AttributeStyles$DateSelectTextColorStyle[] newArray(int i10) {
            return new AttributeStyles$DateSelectTextColorStyle[i10];
        }
    }

    public AttributeStyles$DateSelectTextColorStyle(StyleElements.ComplexElementColor complexElementColor, StyleElements.ComplexElementColor complexElementColor2, StyleElements.ComplexElementColor complexElementColor3, StyleElements.ComplexElementColor complexElementColor4, StyleElements.SimpleElementColor simpleElementColor) {
        this.f28403a = complexElementColor;
        this.f28404b = complexElementColor2;
        this.f28405c = complexElementColor3;
        this.f28406d = complexElementColor4;
        this.f28407e = simpleElementColor;
    }

    public final StyleElements.ComplexElementColor a() {
        return this.f28406d;
    }

    public final StyleElements.SimpleElementColor c() {
        return this.f28407e;
    }

    public final StyleElements.ComplexElementColor d() {
        return this.f28405c;
    }

    public int describeContents() {
        return 0;
    }

    public final StyleElements.ComplexElementColor e() {
        return this.f28404b;
    }

    public final StyleElements.ComplexElementColor f() {
        return this.f28403a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.ComplexElementColor complexElementColor = this.f28403a;
        if (complexElementColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            complexElementColor.writeToParcel(parcel, i10);
        }
        StyleElements.ComplexElementColor complexElementColor2 = this.f28404b;
        if (complexElementColor2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            complexElementColor2.writeToParcel(parcel, i10);
        }
        StyleElements.ComplexElementColor complexElementColor3 = this.f28405c;
        if (complexElementColor3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            complexElementColor3.writeToParcel(parcel, i10);
        }
        StyleElements.ComplexElementColor complexElementColor4 = this.f28406d;
        if (complexElementColor4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            complexElementColor4.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor = this.f28407e;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor.writeToParcel(parcel, i10);
    }
}
