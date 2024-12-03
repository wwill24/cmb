package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ClickableStackChildSizesStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ClickableStackChildSizesStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.ChildSizes f28367a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ClickableStackChildSizesStyle> {
        /* renamed from: a */
        public final AttributeStyles$ClickableStackChildSizesStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ClickableStackChildSizesStyle(parcel.readInt() == 0 ? null : StyleElements.ChildSizes.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ClickableStackChildSizesStyle[] newArray(int i10) {
            return new AttributeStyles$ClickableStackChildSizesStyle[i10];
        }
    }

    public AttributeStyles$ClickableStackChildSizesStyle(StyleElements.ChildSizes childSizes) {
        this.f28367a = childSizes;
    }

    public final StyleElements.ChildSizes a() {
        return this.f28367a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.ChildSizes childSizes = this.f28367a;
        if (childSizes == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        childSizes.writeToParcel(parcel, i10);
    }
}
