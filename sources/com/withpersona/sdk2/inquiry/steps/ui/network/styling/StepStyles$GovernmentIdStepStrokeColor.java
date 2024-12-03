package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$GovernmentIdStepStrokeColor implements Parcelable {
    public static final Parcelable.Creator<StepStyles$GovernmentIdStepStrokeColor> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28931a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28932b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28933c;

    /* renamed from: d  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28934d;

    public static final class a implements Parcelable.Creator<StepStyles$GovernmentIdStepStrokeColor> {
        /* renamed from: a */
        public final StepStyles$GovernmentIdStepStrokeColor createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.SimpleElementColor simpleElementColor = null;
            StyleElements.SimpleElementColor createFromParcel = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            StyleElements.SimpleElementColor createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            StyleElements.SimpleElementColor createFromParcel3 = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                simpleElementColor = StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            }
            return new StepStyles$GovernmentIdStepStrokeColor(createFromParcel, createFromParcel2, createFromParcel3, simpleElementColor);
        }

        /* renamed from: b */
        public final StepStyles$GovernmentIdStepStrokeColor[] newArray(int i10) {
            return new StepStyles$GovernmentIdStepStrokeColor[i10];
        }
    }

    public StepStyles$GovernmentIdStepStrokeColor(StyleElements.SimpleElementColor simpleElementColor, StyleElements.SimpleElementColor simpleElementColor2, StyleElements.SimpleElementColor simpleElementColor3, StyleElements.SimpleElementColor simpleElementColor4) {
        this.f28931a = simpleElementColor;
        this.f28932b = simpleElementColor2;
        this.f28933c = simpleElementColor3;
        this.f28934d = simpleElementColor4;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28931a;
    }

    public final StyleElements.SimpleElementColor c() {
        return this.f28934d;
    }

    public final StyleElements.SimpleElementColor d() {
        return this.f28933c;
    }

    public int describeContents() {
        return 0;
    }

    public final StyleElements.SimpleElementColor e() {
        return this.f28932b;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28931a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor2 = this.f28932b;
        if (simpleElementColor2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor2.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor3 = this.f28933c;
        if (simpleElementColor3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor3.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor4 = this.f28934d;
        if (simpleElementColor4 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor4.writeToParcel(parcel, i10);
    }
}
