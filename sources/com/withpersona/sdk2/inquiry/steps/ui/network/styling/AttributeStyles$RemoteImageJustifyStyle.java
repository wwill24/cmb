package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$RemoteImageJustifyStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$RemoteImageJustifyStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.Position f28485a;

    public static final class a implements Parcelable.Creator<AttributeStyles$RemoteImageJustifyStyle> {
        /* renamed from: a */
        public final AttributeStyles$RemoteImageJustifyStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$RemoteImageJustifyStyle(parcel.readInt() == 0 ? null : StyleElements.Position.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$RemoteImageJustifyStyle[] newArray(int i10) {
            return new AttributeStyles$RemoteImageJustifyStyle[i10];
        }
    }

    public AttributeStyles$RemoteImageJustifyStyle(StyleElements.Position position) {
        this.f28485a = position;
    }

    public final StyleElements.Position a() {
        return this.f28485a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.Position position = this.f28485a;
        if (position == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        position.writeToParcel(parcel, i10);
    }
}
