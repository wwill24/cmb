package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ESignatureSecondaryButtonStyles implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ESignatureSecondaryButtonStyles> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final AttributeStyles$ESignatureSecondaryButtonStylesContainer f28413a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ESignatureSecondaryButtonStyles> {
        /* renamed from: a */
        public final AttributeStyles$ESignatureSecondaryButtonStyles createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ESignatureSecondaryButtonStyles(parcel.readInt() == 0 ? null : AttributeStyles$ESignatureSecondaryButtonStylesContainer.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ESignatureSecondaryButtonStyles[] newArray(int i10) {
            return new AttributeStyles$ESignatureSecondaryButtonStyles[i10];
        }
    }

    public AttributeStyles$ESignatureSecondaryButtonStyles(AttributeStyles$ESignatureSecondaryButtonStylesContainer attributeStyles$ESignatureSecondaryButtonStylesContainer) {
        this.f28413a = attributeStyles$ESignatureSecondaryButtonStylesContainer;
    }

    public final AttributeStyles$ESignatureSecondaryButtonStylesContainer a() {
        return this.f28413a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        AttributeStyles$ESignatureSecondaryButtonStylesContainer attributeStyles$ESignatureSecondaryButtonStylesContainer = this.f28413a;
        if (attributeStyles$ESignatureSecondaryButtonStylesContainer == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        attributeStyles$ESignatureSecondaryButtonStylesContainer.writeToParcel(parcel, i10);
    }
}
