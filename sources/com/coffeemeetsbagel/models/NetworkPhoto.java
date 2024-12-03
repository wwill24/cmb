package com.coffeemeetsbagel.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.models.enums.MediaItemType;
import com.coffeemeetsbagel.models.interfaces.MediaItemContract;
import com.coffeemeetsbagel.models.util.ComparisonUtils;
import com.google.gson.d;
import java.io.Serializable;

public class NetworkPhoto implements Serializable, Model, Comparable<NetworkPhoto>, MediaItemContract.MediaItem, Parcelable {
    public static final Parcelable.Creator<NetworkPhoto> CREATOR = new Parcelable.Creator<NetworkPhoto>() {
        public NetworkPhoto createFromParcel(Parcel parcel) {
            return new NetworkPhoto(parcel);
        }

        public NetworkPhoto[] newArray(int i10) {
            return new NetworkPhoto[i10];
        }
    };
    private String caption;

    /* renamed from: id  reason: collision with root package name */
    private String f34708id;
    private String idProfile;
    private String iphoneFullscreen;
    private int position;

    public NetworkPhoto() {
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NetworkPhoto)) {
            return false;
        }
        NetworkPhoto networkPhoto = (NetworkPhoto) obj;
        if (this.position != networkPhoto.position || !ComparisonUtils.equalsWithNullCheck(this.iphoneFullscreen, networkPhoto.iphoneFullscreen) || !ComparisonUtils.equalsWithNullCheck(this.f34708id, networkPhoto.f34708id) || !ComparisonUtils.equalsWithNullCheck(this.idProfile, networkPhoto.idProfile) || !ComparisonUtils.equalsWithNullCheck(this.caption, networkPhoto.caption)) {
            return false;
        }
        return true;
    }

    public String getCaption() {
        return this.caption;
    }

    public String getId() {
        return this.f34708id;
    }

    public String getIdProfile() {
        return this.idProfile;
    }

    public int getPosition() {
        return this.position;
    }

    public MediaItemType getType() {
        return MediaItemType.PHOTO;
    }

    public String getUrl() {
        return this.iphoneFullscreen;
    }

    public void readFromParcel(Parcel parcel) {
        this.caption = parcel.readString();
        this.f34708id = parcel.readString();
        this.idProfile = parcel.readString();
        this.position = parcel.readInt();
        this.iphoneFullscreen = parcel.readString();
    }

    public void setCaption(String str) {
        this.caption = str;
    }

    public void setId(String str) {
        this.f34708id = str;
    }

    public void setIdProfile(String str) {
        this.idProfile = str;
    }

    public void setPosition(int i10) {
        this.position = i10;
    }

    public void setUrl(String str) {
        this.iphoneFullscreen = str;
    }

    public String toString() {
        return new d().u(this);
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.caption);
        parcel.writeString(this.f34708id);
        parcel.writeString(this.idProfile);
        parcel.writeInt(this.position);
        parcel.writeString(this.iphoneFullscreen);
    }

    public NetworkPhoto(int i10, String str, String str2, String str3, String str4) {
        this.iphoneFullscreen = str;
        this.position = i10;
        this.f34708id = str2;
        this.idProfile = str3;
        this.caption = str4;
    }

    public int compareTo(@NonNull NetworkPhoto networkPhoto) {
        return this.position - networkPhoto.position;
    }

    public NetworkPhoto(NetworkPhoto networkPhoto) {
        this.iphoneFullscreen = networkPhoto.getUrl();
        this.position = networkPhoto.getPosition();
        this.f34708id = networkPhoto.getId();
        this.idProfile = networkPhoto.getIdProfile();
        this.caption = networkPhoto.getCaption();
    }

    protected NetworkPhoto(Parcel parcel) {
        this.caption = parcel.readString();
        this.f34708id = parcel.readString();
        this.idProfile = parcel.readString();
        this.position = parcel.readInt();
        this.iphoneFullscreen = parcel.readString();
    }
}
