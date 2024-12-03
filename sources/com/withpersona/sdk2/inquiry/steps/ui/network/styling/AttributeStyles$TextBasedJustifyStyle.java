package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$TextBasedJustifyStyle implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$TextBasedJustifyStyle> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final StyleElements.Position f28493a;

    public static final class a implements Parcelable.Creator<AttributeStyles$TextBasedJustifyStyle> {
        /* renamed from: a */
        public final AttributeStyles$TextBasedJustifyStyle createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$TextBasedJustifyStyle(parcel.readInt() == 0 ? null : StyleElements.Position.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$TextBasedJustifyStyle[] newArray(int i10) {
            return new AttributeStyles$TextBasedJustifyStyle[i10];
        }
    }

    public AttributeStyles$TextBasedJustifyStyle(StyleElements.Position position) {
        this.f28493a = position;
    }

    public final StyleElements.Position a() {
        return this.f28493a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        StyleElements.Position position = this.f28493a;
        if (position == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        position.writeToParcel(parcel, i10);
    }
}
