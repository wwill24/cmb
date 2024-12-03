package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class AttributeStyles$ESignaturePrimaryButtonStylesContainer implements Parcelable {
    public static final Parcelable.Creator<AttributeStyles$ESignaturePrimaryButtonStylesContainer> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final ButtonSubmitComponentStyle f28412a;

    public static final class a implements Parcelable.Creator<AttributeStyles$ESignaturePrimaryButtonStylesContainer> {
        /* renamed from: a */
        public final AttributeStyles$ESignaturePrimaryButtonStylesContainer createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new AttributeStyles$ESignaturePrimaryButtonStylesContainer(parcel.readInt() == 0 ? null : ButtonSubmitComponentStyle.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final AttributeStyles$ESignaturePrimaryButtonStylesContainer[] newArray(int i10) {
            return new AttributeStyles$ESignaturePrimaryButtonStylesContainer[i10];
        }
    }

    public AttributeStyles$ESignaturePrimaryButtonStylesContainer(ButtonSubmitComponentStyle buttonSubmitComponentStyle) {
        this.f28412a = buttonSubmitComponentStyle;
    }

    public final ButtonSubmitComponentStyle a() {
        return this.f28412a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        ButtonSubmitComponentStyle buttonSubmitComponentStyle = this.f28412a;
        if (buttonSubmitComponentStyle == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        buttonSubmitComponentStyle.writeToParcel(parcel, i10);
    }
}
