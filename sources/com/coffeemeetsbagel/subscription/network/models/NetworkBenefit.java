package com.coffeemeetsbagel.subscription.network.models;

import java.util.List;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class NetworkBenefit {
    @c("description")
    private final String description;
    @c("icon_url")
    private final String iconUrl;
    @c("image_url")
    private final String imageUrl;
    @c("intents")
    private final List<String> intents;
    @c("name")
    private final String name;
    @c("title")
    private final String title;
    @c("title_small_display")
    private final String titleSmallDisplay;

    public NetworkBenefit(List<String> list, String str, String str2, String str3, String str4, String str5, String str6) {
        j.g(list, "intents");
        j.g(str, "description");
        j.g(str2, "iconUrl");
        j.g(str3, "imageUrl");
        j.g(str4, "name");
        j.g(str5, "title");
        this.intents = list;
        this.description = str;
        this.iconUrl = str2;
        this.imageUrl = str3;
        this.name = str4;
        this.title = str5;
        this.titleSmallDisplay = str6;
    }

    public static /* synthetic */ NetworkBenefit copy$default(NetworkBenefit networkBenefit, List<String> list, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = networkBenefit.intents;
        }
        if ((i10 & 2) != 0) {
            str = networkBenefit.description;
        }
        String str7 = str;
        if ((i10 & 4) != 0) {
            str2 = networkBenefit.iconUrl;
        }
        String str8 = str2;
        if ((i10 & 8) != 0) {
            str3 = networkBenefit.imageUrl;
        }
        String str9 = str3;
        if ((i10 & 16) != 0) {
            str4 = networkBenefit.name;
        }
        String str10 = str4;
        if ((i10 & 32) != 0) {
            str5 = networkBenefit.title;
        }
        String str11 = str5;
        if ((i10 & 64) != 0) {
            str6 = networkBenefit.titleSmallDisplay;
        }
        return networkBenefit.copy(list, str7, str8, str9, str10, str11, str6);
    }

    public final List<String> component1() {
        return this.intents;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.iconUrl;
    }

    public final String component4() {
        return this.imageUrl;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.titleSmallDisplay;
    }

    public final NetworkBenefit copy(List<String> list, String str, String str2, String str3, String str4, String str5, String str6) {
        j.g(list, "intents");
        j.g(str, "description");
        j.g(str2, "iconUrl");
        j.g(str3, "imageUrl");
        j.g(str4, "name");
        j.g(str5, "title");
        return new NetworkBenefit(list, str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkBenefit)) {
            return false;
        }
        NetworkBenefit networkBenefit = (NetworkBenefit) obj;
        return j.b(this.intents, networkBenefit.intents) && j.b(this.description, networkBenefit.description) && j.b(this.iconUrl, networkBenefit.iconUrl) && j.b(this.imageUrl, networkBenefit.imageUrl) && j.b(this.name, networkBenefit.name) && j.b(this.title, networkBenefit.title) && j.b(this.titleSmallDisplay, networkBenefit.titleSmallDisplay);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final List<String> getIntents() {
        return this.intents;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleSmallDisplay() {
        return this.titleSmallDisplay;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.intents.hashCode() * 31) + this.description.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.name.hashCode()) * 31) + this.title.hashCode()) * 31;
        String str = this.titleSmallDisplay;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "NetworkBenefit(intents=" + this.intents + ", description=" + this.description + ", iconUrl=" + this.iconUrl + ", imageUrl=" + this.imageUrl + ", name=" + this.name + ", title=" + this.title + ", titleSmallDisplay=" + this.titleSmallDisplay + PropertyUtils.MAPPED_DELIM2;
    }
}
