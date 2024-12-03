package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$HorizontalStackAxisStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$HorizontalStackAxisStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.AxisContainer f28420a;

    public static final class a implements Parcelable.Creator<AttributeStyles$HorizontalStackAxisStyle> {
        /* renamed from: a */
        public final AttributeStyles$HorizontalStackAxisStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$HorizontalStackAxisStyle(parcel.readInt() == 0 ? null : StyleElements.AxisContainer.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$HorizontalStackAxisStyle[] newArray(int i10) {
            return new AttributeStyles$HorizontalStackAxisStyle[i10];
        }
    }

    public AttributeStyles$HorizontalStackAxisStyle(StyleElements.AxisContainer axisContainer) {
        this.f28420a = axisContainer;
    }

    public final StyleElements.AxisContainer a() {
        return this.f28420a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.AxisContainer axisContainer = this.f28420a;
        if (axisContainer == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        axisContainer.writeToParcel(parcel, i10);
    }
}
