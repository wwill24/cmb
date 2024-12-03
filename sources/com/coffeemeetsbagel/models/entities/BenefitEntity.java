package com.coffeemeetsbagel.models.entities;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.jvm.internal.j;

public final class BenefitEntity {
    private final long cachedAt;
    private final List<String> deepLinkTags;
    private final String description;
    private final String iconUrl;
    private final String imageUrl;
    private final String key;
    private final String title;
    private final String titleSmallDisplay;

    public BenefitEntity(String str, long j10, List<String> list, String str2, String str3, String str4, String str5, String str6) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(list, "deepLinkTags");
        j.g(str2, "description");
        j.g(str3, "iconUrl");
        j.g(str4, "imageUrl");
        j.g(str5, "title");
        this.key = str;
        this.cachedAt = j10;
        this.deepLinkTags = list;
        this.description = str2;
        this.iconUrl = str3;
        this.imageUrl = str4;
        this.title = str5;
        this.titleSmallDisplay = str6;
    }

    public final long getCachedAt() {
        return this.cachedAt;
    }

    public final List<String> getDeepLinkTags() {
        return this.deepLinkTags;
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

    public final String getKey() {
        return this.key;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleSmallDisplay() {
        return this.titleSmallDisplay;
    }
}
