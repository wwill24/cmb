package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ClickableStackAxisStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ClickableStackAxisStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.AxisContainer f28362a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ClickableStackAxisStyle> {
        /* renamed from: a */
        public final AttributeStyles$ClickableStackAxisStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ClickableStackAxisStyle(parcel.readInt() == 0 ? null : StyleElements.AxisContainer.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ClickableStackAxisStyle[] newArray(int i10) {
            return new AttributeStyles$ClickableStackAxisStyle[i10];
        }
    }

    public AttributeStyles$ClickableStackAxisStyle(StyleElements.AxisContainer axisContainer) {
        this.f28362a = axisContainer;
    }

    public final StyleElements.AxisContainer a() {
        return this.f28362a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.AxisContainer axisContainer = this.f28362a;
        if (axisContainer == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        axisContainer.writeToParcel(parcel, i10);
    }
}
