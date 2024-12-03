package com.coffeemeetsbagel.subscription.network.models;

import com.leanplum.internal.Constants;
import java.util.List;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class NetworkSubscriptionBundle {
    @c("benefits")
    private final List<String> benefits;
    @c("display_name")
    private final String displayName;
    @c("id")

    /* renamed from: id  reason: collision with root package name */
    private final String f37008id;
    @c("tier")
    private final int tier;
    @c("variants")
    private final List<NetworkSubscriptionBundleVariant> variants;

    public NetworkSubscriptionBundle(String str, int i10, List<String> list, String str2, List<NetworkSubscriptionBundleVariant> list2) {
        j.g(str, "id");
        j.g(list, "benefits");
        j.g(str2, "displayName");
        j.g(list2, Constants.Keys.VARIANTS);
        this.f37008id = str;
        this.tier = i10;
        this.benefits = list;
        this.displayName = str2;
        this.variants = list2;
    }

    public static /* synthetic */ NetworkSubscriptionBundle copy$default(NetworkSubscriptionBundle networkSubscriptionBundle, String str, int i10, List<String> list, String str2, List<NetworkSubscriptionBundleVariant> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = networkSubscriptionBundle.f37008id;
        }
        if ((i11 & 2) != 0) {
            i10 = networkSubscriptionBundle.tier;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            list = networkSubscriptionBundle.benefits;
        }
        List<String> list3 = list;
        if ((i11 & 8) != 0) {
            str2 = networkSubscriptionBundle.displayName;
        }
        String str3 = str2;
        if ((i11 & 16) != 0) {
            list2 = networkSubscriptionBundle.variants;
        }
        return networkSubscriptionBundle.copy(str, i12, list3, str3, list2);
    }

    public final String component1() {
        return this.f37008id;
    }

    public final int component2() {
        return this.tier;
    }

    public final List<String> component3() {
        return this.benefits;
    }

    public final String component4() {
        return this.displayName;
    }

    public final List<NetworkSubscriptionBundleVariant> component5() {
        return this.variants;
    }

    public final NetworkSubscriptionBundle copy(String str, int i10, List<String> list, String str2, List<NetworkSubscriptionBundleVariant> list2) {
        j.g(str, "id");
        j.g(list, "benefits");
        j.g(str2, "displayName");
        j.g(list2, Constants.Keys.VARIANTS);
        return new NetworkSubscriptionBundle(str, i10, list, str2, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkSubscriptionBundle)) {
            return false;
        }
        NetworkSubscriptionBundle networkSubscriptionBundle = (NetworkSubscriptionBundle) obj;
        return j.b(this.f37008id, networkSubscriptionBundle.f37008id) && this.tier == networkSubscriptionBundle.tier && j.b(this.benefits, networkSubscriptionBundle.benefits) && j.b(this.displayName, networkSubscriptionBundle.displayName) && j.b(this.variants, networkSubscriptionBundle.variants);
    }

    public final List<String> getBenefits() {
        return this.benefits;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getId() {
        return this.f37008id;
    }

    public final int getTier() {
        return this.tier;
    }

    public final List<NetworkSubscriptionBundleVariant> getVariants() {
        return this.variants;
    }

    public int hashCode() {
        return (((((((this.f37008id.hashCode() * 31) + Integer.hashCode(this.tier)) * 31) + this.benefits.hashCode()) * 31) + this.displayName.hashCode()) * 31) + this.variants.hashCode();
    }

    public String toString() {
        return "NetworkSubscriptionBundle(id=" + this.f37008id + ", tier=" + this.tier + ", benefits=" + this.benefits + ", displayName=" + this.displayName + ", variants=" + this.variants + PropertyUtils.MAPPED_DELIM2;
    }
}
