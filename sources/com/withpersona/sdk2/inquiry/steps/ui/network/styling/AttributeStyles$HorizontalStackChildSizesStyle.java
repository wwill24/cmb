package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$HorizontalStackChildSizesStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$HorizontalStackChildSizesStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.ChildSizes f28425a;

    public static final class a implements Parcelable.Creator<AttributeStyles$HorizontalStackChildSizesStyle> {
        /* renamed from: a */
        public final AttributeStyles$HorizontalStackChildSizesStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$HorizontalStackChildSizesStyle(parcel.readInt() == 0 ? null : StyleElements.ChildSizes.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$HorizontalStackChildSizesStyle[] newArray(int i10) {
            return new AttributeStyles$HorizontalStackChildSizesStyle[i10];
        }
    }

    public AttributeStyles$HorizontalStackChildSizesStyle(StyleElements.ChildSizes childSizes) {
        this.f28425a = childSizes;
    }

    public final StyleElements.ChildSizes a() {
        return this.f28425a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.ChildSizes childSizes = this.f28425a;
        if (childSizes == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        childSizes.writeToParcel(parcel, i10);
    }
}
