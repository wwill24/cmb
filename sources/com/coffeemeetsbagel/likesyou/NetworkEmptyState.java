package com.coffeemeetsbagel.likesyou;

import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class NetworkEmptyState {
    private final String action;
    @c("call_to_action_text")
    private final String callToActionText;
    @c("description_text")
    private final String descriptionText;
    @c("image_url")
    private final String imageUrl;
    @c("title_text")
    private final String titleText;

    public NetworkEmptyState(String str, String str2, String str3, String str4, String str5) {
        this.action = str;
        this.callToActionText = str2;
        this.descriptionText = str3;
        this.imageUrl = str4;
        this.titleText = str5;
    }

    public static /* synthetic */ NetworkEmptyState copy$default(NetworkEmptyState networkEmptyState, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = networkEmptyState.action;
        }
        if ((i10 & 2) != 0) {
            str2 = networkEmptyState.callToActionText;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = networkEmptyState.descriptionText;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = networkEmptyState.imageUrl;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = networkEmptyState.titleText;
        }
        return networkEmptyState.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.action;
    }

    public final String component2() {
        return this.callToActionText;
    }

    public final String component3() {
        return this.descriptionText;
    }

    public final String component4() {
        return this.imageUrl;
    }

    public final String component5() {
        return this.titleText;
    }

    public final NetworkEmptyState copy(String str, String str2, String str3, String str4, String str5) {
        return new NetworkEmptyState(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkEmptyState)) {
            return false;
        }
        NetworkEmptyState networkEmptyState = (NetworkEmptyState) obj;
        return j.b(this.action, networkEmptyState.action) && j.b(this.callToActionText, networkEmptyState.callToActionText) && j.b(this.descriptionText, networkEmptyState.descriptionText) && j.b(this.imageUrl, networkEmptyState.imageUrl) && j.b(this.titleText, networkEmptyState.titleText);
    }

    public final String getAction() {
        return this.action;
    }

    public final String getCallToActionText() {
        return this.callToActionText;
    }

    public final String getDescriptionText() {
        return this.descriptionText;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public int hashCode() {
        String str = this.action;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.callToActionText;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.descriptionText;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.imageUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.titleText;
        if (str5 != null) {
            i10 = str5.hashCode();
        }
        return hashCode4 + i10;
    }

    public String toString() {
        return "NetworkEmptyState(action=" + this.action + ", callToActionText=" + this.callToActionText + ", descriptionText=" + this.descriptionText + ", imageUrl=" + this.imageUrl + ", titleText=" + this.titleText + PropertyUtils.MAPPED_DELIM2;
    }
}
