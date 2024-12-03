package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class StepStyles$DocumentStepFillColor implements Parcelable {
    public static final Parcelable.Creator<StepStyles$DocumentStepFillColor> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28883a;

    /* renamed from: b  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28884b;

    /* renamed from: c  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28885c;

    /* renamed from: d  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28886d;

    /* renamed from: e  reason: collision with root package name */
    private final StyleElements.SimpleElementColor f28887e;

    public static final class a implements Parcelable.Creator<StepStyles$DocumentStepFillColor> {
        /* renamed from: a */
        public final StepStyles$DocumentStepFillColor createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            StyleElements.SimpleElementColor simpleElementColor = null;
            StyleElements.SimpleElementColor createFromParcel = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            StyleElements.SimpleElementColor createFromParcel2 = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            StyleElements.SimpleElementColor createFromParcel3 = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            StyleElements.SimpleElementColor createFromParcel4 = parcel.readInt() == 0 ? null : StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                simpleElementColor = StyleElements.SimpleElementColor.CREATOR.createFromParcel(parcel);
            }
            return new StepStyles$DocumentStepFillColor(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, simpleElementColor);
        }

        /* renamed from: b */
        public final StepStyles$DocumentStepFillColor[] newArray(int i10) {
            return new StepStyles$DocumentStepFillColor[i10];
        }
    }

    public StepStyles$DocumentStepFillColor(StyleElements.SimpleElementColor simpleElementColor, StyleElements.SimpleElementColor simpleElementColor2, StyleElements.SimpleElementColor simpleElementColor3, StyleElements.SimpleElementColor simpleElementColor4, StyleElements.SimpleElementColor simpleElementColor5) {
        this.f28883a = simpleElementColor;
        this.f28884b = simpleElementColor2;
        this.f28885c = simpleElementColor3;
        this.f28886d = simpleElementColor4;
        this.f28887e = simpleElementColor5;
    }

    public final StyleElements.SimpleElementColor a() {
        return this.f28883a;
    }

    public final StyleElements.SimpleElementColor c() {
        return this.f28887e;
    }

    public final StyleElements.SimpleElementColor d() {
        return this.f28886d;
    }

    public int describeContents() {
        return 0;
    }

    public final StyleElements.SimpleElementColor e() {
        return this.f28884b;
    }

    public final StyleElements.SimpleElementColor f() {
        return this.f28885c;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.SimpleElementColor simpleElementColor = this.f28883a;
        if (simpleElementColor == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor2 = this.f28884b;
        if (simpleElementColor2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor2.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor3 = this.f28885c;
        if (simpleElementColor3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor3.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor4 = this.f28886d;
        if (simpleElementColor4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            simpleElementColor4.writeToParcel(parcel, i10);
        }
        StyleElements.SimpleElementColor simpleElementColor5 = this.f28887e;
        if (simpleElementColor5 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        simpleElementColor5.writeToParcel(parcel, i10);
    }
}
