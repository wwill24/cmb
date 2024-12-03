package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ESignatureSecondaryButtonStylesContainer implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ESignatureSecondaryButtonStylesContainer> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final ButtonCancelComponentStyle f28414a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ESignatureSecondaryButtonStylesContainer> {
        /* renamed from: a */
        public final AttributeStyles$ESignatureSecondaryButtonStylesContainer createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ESignatureSecondaryButtonStylesContainer(parcel.readInt() == 0 ? null : ButtonCancelComponentStyle.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ESignatureSecondaryButtonStylesContainer[] newArray(int i10) {
            return new AttributeStyles$ESignatureSecondaryButtonStylesContainer[i10];
        }
    }

    public AttributeStyles$ESignatureSecondaryButtonStylesContainer(ButtonCancelComponentStyle buttonCancelComponentStyle) {
        this.f28414a = buttonCancelComponentStyle;
    }

    public final ButtonCancelComponentStyle a() {
        return this.f28414a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        ButtonCancelComponentStyle buttonCancelComponentStyle = this.f28414a;
        if (buttonCancelComponentStyle == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        buttonCancelComponentStyle.writeToParcel(parcel, i10);
    }
}
