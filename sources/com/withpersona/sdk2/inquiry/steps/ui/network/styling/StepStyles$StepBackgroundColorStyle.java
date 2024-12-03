package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$StepBackgroundColorStyle implements Parcelable {
    public static final Parcelable.Creator<StepStyles$StepBackgroundColorStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28985a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.ComplexElementColor f28986b;

    public static final class a implements Parcelable.Creator<StepStyles$StepBackgroundColorStyle> {
        /* renamed from: a */
        public final StepStyles$StepBackgroundColorStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.ComplexElementColor complexElementColor = null;
            StyleElements.SimpleElementColor createFromParcel = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                complexElementColor = StyleElements.ComplexElementColor.CREATOR.createFromParcel(parcel);
            }
            return new StepStyles$StepBackgroundColorStyle(createFromParcel, complexElementColor);
        }

        /* renamed from: b */
        public final StepStyles$StepBackgroundColorStyle[] newArray(int i10) {
            return new StepStyles$StepBackgroundColorStyle[i10];
        }
    }

    public StepStyles$StepBackgroundColorStyle(StyleElements.SimpleElementColor simpleElementColor, StyleElements.ComplexElementColor complexElementColor) {
        this.f28985a = simpleElementColor;
        this.f28986b = complexElementColor;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28985a;
    }

    public final StyleElements.ComplexElementColor c() {
        return this.f28986b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28985a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor.writeToParcel(parcel, i10);
        }
        StyleElements.ComplexElementColor complexElementColor = this.f28986b;
        if (complexElementColor == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        complexElementColor.writeToParcel(parcel, i10);
    }
}
