package com.coffeemeetsbagel.models;

import com.coffeemeetsbagel.models.dto.StickerDataContract;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class Sticker implements StickerDataContract {
    private final String description;
    private final String imageUrl;
    private final String name;

    public Sticker(String str, String str2, String str3) {
        j.g(str, "imageUrl");
        j.g(str2, "name");
        j.g(str3, "description");
        this.imageUrl = str;
        this.name = str2;
        this.description = str3;
    }

    public static /* synthetic */ Sticker copy$default(Sticker sticker, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sticker.getImageUrl();
        }
        if ((i10 & 2) != 0) {
            str2 = sticker.getName();
        }
        if ((i10 & 4) != 0) {
            str3 = sticker.getDescription();
        }
        return sticker.copy(str, str2, str3);
    }

    public final String component1() {
        return getImageUrl();
    }

    public final String component2() {
        return getName();
    }

    public final String component3() {
        return getDescription();
    }

    public final Sticker copy(String str, String str2, String str3) {
        j.g(str, "imageUrl");
        j.g(str2, "name");
        j.g(str3, "description");
        return new Sticker(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Sticker)) {
            return false;
        }
        Sticker sticker = (Sticker) obj;
        return j.b(getImageUrl(), sticker.getImageUrl()) && j.b(getName(), sticker.getName()) && j.b(getDescription(), sticker.getDescription());
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
        return (((getImageUrl().hashCode() * 31) + getName().hashCode()) * 31) + getDescription().hashCode();
    }

    public String toString() {
        return "Sticker(imageUrl=" + getImageUrl() + ", name=" + getName() + ", description=" + getDescription() + PropertyUtils.MAPPED_DELIM2;
    }
}
