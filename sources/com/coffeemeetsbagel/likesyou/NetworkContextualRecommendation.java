package com.coffeemeetsbagel.likesyou;

import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class NetworkContextualRecommendation {
    @c("description_text")
    private final String descriptionText;
    @c("icon_url")
    private final String iconUrl;
    @c("title_text")
    private final String titleText;

    public NetworkContextualRecommendation(String str, String str2, String str3) {
        this.descriptionText = str;
        this.iconUrl = str2;
        this.titleText = str3;
    }

    public static /* synthetic */ NetworkContextualRecommendation copy$default(NetworkContextualRecommendation networkContextualRecommendation, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = networkContextualRecommendation.descriptionText;
        }
        if ((i10 & 2) != 0) {
            str2 = networkContextualRecommendation.iconUrl;
        }
        if ((i10 & 4) != 0) {
            str3 = networkContextualRecommendation.titleText;
        }
        return networkContextualRecommendation.copy(str, str2, str3);
    }

    public final String component1() {
        return this.descriptionText;
    }

    public final String component2() {
        return this.iconUrl;
    }

    public final String component3() {
        return this.titleText;
    }

    public final NetworkContextualRecommendation copy(String str, String str2, String str3) {
        return new NetworkContextualRecommendation(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkContextualRecommendation)) {
            return false;
        }
        NetworkContextualRecommendation networkContextualRecommendation = (NetworkContextualRecommendation) obj;
        return j.b(this.descriptionText, networkContextualRecommendation.descriptionText) && j.b(this.iconUrl, networkContextualRecommendation.iconUrl) && j.b(this.titleText, networkContextualRecommendation.titleText);
    }

    public final String getDescriptionText() {
        return this.descriptionText;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public int hashCode() {
        String str = this.descriptionText;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.iconUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.titleText;
        if (str3 != null) {
            i10 = str3.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return "NetworkContextualRecommendation(descriptionText=" + this.descriptionText + ", iconUrl=" + this.iconUrl + ", titleText=" + this.titleText + PropertyUtils.MAPPED_DELIM2;
    }
}
