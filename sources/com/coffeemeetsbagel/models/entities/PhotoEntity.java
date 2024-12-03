package com.coffeemeetsbagel.models.entities;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class PhotoEntity {
    private final String caption;
    private final String photoId;
    private final int position;
    private final String profileId;
    private final String url;

    public PhotoEntity(String str, String str2, int i10, String str3, String str4) {
        j.g(str, "photoId");
        j.g(str3, "profileId");
        j.g(str4, "url");
        this.photoId = str;
        this.caption = str2;
        this.position = i10;
        this.profileId = str3;
        this.url = str4;
    }

    public static /* synthetic */ PhotoEntity copy$default(PhotoEntity photoEntity, String str, String str2, int i10, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = photoEntity.photoId;
        }
        if ((i11 & 2) != 0) {
            str2 = photoEntity.caption;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            i10 = photoEntity.position;
        }
        int i12 = i10;
        if ((i11 & 8) != 0) {
            str3 = photoEntity.profileId;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            str4 = photoEntity.url;
        }
        return photoEntity.copy(str, str5, i12, str6, str4);
    }

    public final String component1() {
        return this.photoId;
    }

    public final String component2() {
        return this.caption;
    }

    public final int component3() {
        return this.position;
    }

    public final String component4() {
        return this.profileId;
    }

    public final String component5() {
        return this.url;
    }

    public final PhotoEntity copy(String str, String str2, int i10, String str3, String str4) {
        j.g(str, "photoId");
        j.g(str3, "profileId");
        j.g(str4, "url");
        return new PhotoEntity(str, str2, i10, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotoEntity)) {
            return false;
        }
        PhotoEntity photoEntity = (PhotoEntity) obj;
        return j.b(this.photoId, photoEntity.photoId) && j.b(this.caption, photoEntity.caption) && this.position == photoEntity.position && j.b(this.profileId, photoEntity.profileId) && j.b(this.url, photoEntity.url);
    }

    public final String getCaption() {
        return this.caption;
    }

    public final String getPhotoId() {
        return this.photoId;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = this.photoId.hashCode() * 31;
        String str = this.caption;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.position)) * 31) + this.profileId.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "PhotoEntity(photoId=" + this.photoId + ", caption=" + this.caption + ", position=" + this.position + ", profileId=" + this.profileId + ", url=" + this.url + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoEntity(String str, String str2, int i10, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i10, str3, (i11 & 16) != 0 ? "" : str4);
    }
}
