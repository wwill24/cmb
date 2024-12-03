package com.coffeemeetsbagel.models.entities;

import com.coffeemeetsbagel.models.dto.StickerDataContract;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StickerEntity implements StickerDataContract {
    private final String description;
    private final String imageUrl;
    private final String name;

    public StickerEntity(String str, String str2, String str3) {
        j.g(str, "name");
        j.g(str2, "description");
        j.g(str3, "imageUrl");
        this.name = str;
        this.description = str2;
        this.imageUrl = str3;
    }

    public static /* synthetic */ StickerEntity copy$default(StickerEntity stickerEntity, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = stickerEntity.getName();
        }
        if ((i10 & 2) != 0) {
            str2 = stickerEntity.getDescription();
        }
        if ((i10 & 4) != 0) {
            str3 = stickerEntity.getImageUrl();
        }
        return stickerEntity.copy(str, str2, str3);
    }

    public final String component1() {
        return getName();
    }

    public final String component2() {
        return getDescription();
    }

    public final String component3() {
        return getImageUrl();
    }

    public final StickerEntity copy(String str, String str2, String str3) {
        j.g(str, "name");
        j.g(str2, "description");
        j.g(str3, "imageUrl");
        return new StickerEntity(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StickerEntity)) {
            return false;
        }
        StickerEntity stickerEntity = (StickerEntity) obj;
        return j.b(getName(), stickerEntity.getName()) && j.b(getDescription(), stickerEntity.getDescription()) && j.b(getImageUrl(), stickerEntity.getImageUrl());
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((getName().hashCode() * 31) + getDescription().hashCode()) * 31) + getImageUrl().hashCode();
    }

    public String toString() {
        return "StickerEntity(name=" + getName() + ", description=" + getDescription() + ", imageUrl=" + getImageUrl() + PropertyUtils.MAPPED_DELIM2;
    }
}
