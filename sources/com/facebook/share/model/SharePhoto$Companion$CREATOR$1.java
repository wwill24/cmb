package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/facebook/share/model/SharePhoto$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/SharePhoto;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/share/model/SharePhoto;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SharePhoto$Companion$CREATOR$1 implements Parcelable.Creator<SharePhoto> {
    SharePhoto$Companion$CREATOR$1() {
    }

    public SharePhoto createFromParcel(Parcel parcel) {
        j.g(parcel, "source");
        return new SharePhoto(parcel);
    }

    public SharePhoto[] newArray(int i10) {
        return new SharePhoto[i10];
    }
}
