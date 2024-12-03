package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$InputMarginStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$InputMarginStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.DPMeasurementSet f28429a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.DPMeasurementSet f28430b;

    public static final class a implements Parcelable.Creator<AttributeStyles$InputMarginStyle> {
        /* renamed from: a */
        public final AttributeStyles$InputMarginStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.DPMeasurementSet dPMeasurementSet = null;
            StyleElements.DPMeasurementSet createFromParcel = parcel.readInt() == 0 ? null : StyleElements.DPMeasurementSet.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                dPMeasurementSet = StyleElements.DPMeasurementSet.CREATOR.createFromParcel(parcel);
            }
            return new AttributeStyles$InputMarginStyle(createFromParcel, dPMeasurementSet);
        }

        /* renamed from: b */
        public final AttributeStyles$InputMarginStyle[] newArray(int i10) {
            return new AttributeStyles$InputMarginStyle[i10];
        }
    }

    public AttributeStyles$InputMarginStyle(StyleElements.DPMeasurementSet dPMeasurementSet, StyleElements.DPMeasurementSet dPMeasurementSet2) {
        this.f28429a = dPMeasurementSet;
        this.f28430b = dPMeasurementSet2;
    }

    public final StyleElements.DPMeasurementSet a() {
        return this.f28429a;
    }

    public final StyleElements.DPMeasurementSet c() {
        return this.f28430b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.DPMeasurementSet dPMeasurementSet = this.f28429a;
        if (dPMeasurementSet == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dPMeasurementSet.writeToParcel(parcel, i10);
        }
        StyleElements.DPMeasurementSet dPMeasurementSet2 = this.f28430b;
        if (dPMeasurementSet2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        dPMeasurementSet2.writeToParcel(parcel, i10);
    }
}
