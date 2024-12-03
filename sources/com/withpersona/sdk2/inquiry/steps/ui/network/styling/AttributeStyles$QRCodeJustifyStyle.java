package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$QRCodeJustifyStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$QRCodeJustifyStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.Position f28480a;

    public static final class a implements Parcelable.Creator<AttributeStyles$QRCodeJustifyStyle> {
        /* renamed from: a */
        public final AttributeStyles$QRCodeJustifyStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$QRCodeJustifyStyle(parcel.readInt() == 0 ? null : StyleElements.Position.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$QRCodeJustifyStyle[] newArray(int i10) {
            return new AttributeStyles$QRCodeJustifyStyle[i10];
        }
    }

    public AttributeStyles$QRCodeJustifyStyle(StyleElements.Position position) {
        this.f28480a = position;
    }

    public final StyleElements.Position a() {
        return this.f28480a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.Position position = this.f28480a;
        if (position == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        position.writeToParcel(parcel, i10);
    }
}
