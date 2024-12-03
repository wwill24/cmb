package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ESignaturePrimaryButtonStyles implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ESignaturePrimaryButtonStyles> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AttributeStyles$ESignaturePrimaryButtonStylesContainer f28411a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ESignaturePrimaryButtonStyles> {
        /* renamed from: a */
        public final AttributeStyles$ESignaturePrimaryButtonStyles createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ESignaturePrimaryButtonStyles(parcel.readInt() == 0 ? null : AttributeStyles$ESignaturePrimaryButtonStylesContainer.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ESignaturePrimaryButtonStyles[] newArray(int i10) {
            return new AttributeStyles$ESignaturePrimaryButtonStyles[i10];
        }
    }

    public AttributeStyles$ESignaturePrimaryButtonStyles(AttributeStyles$ESignaturePrimaryButtonStylesContainer attributeStyles$ESignaturePrimaryButtonStylesContainer) {
        this.f28411a = attributeStyles$ESignaturePrimaryButtonStylesContainer;
    }

    public final AttributeStyles$ESignaturePrimaryButtonStylesContainer a() {
        return this.f28411a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        AttributeStyles$ESignaturePrimaryButtonStylesContainer attributeStyles$ESignaturePrimaryButtonStylesContainer = this.f28411a;
        if (attributeStyles$ESignaturePrimaryButtonStylesContainer == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        attributeStyles$ESignaturePrimaryButtonStylesContainer.writeToParcel(parcel, i10);
    }
}
