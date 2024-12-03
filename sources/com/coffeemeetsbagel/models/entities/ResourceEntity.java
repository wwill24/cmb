package com.coffeemeetsbagel.models.entities;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ResourceEntity {
    private final String key;
    private final String listName;
    private final String value;

    public ResourceEntity(String str, String str2, String str3) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(str2, "value");
        j.g(str3, "listName");
        this.key = str;
        this.value = str2;
        this.listName = str3;
    }

    public static /* synthetic */ ResourceEntity copy$default(ResourceEntity resourceEntity, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = resourceEntity.key;
        }
        if ((i10 & 2) != 0) {
            str2 = resourceEntity.value;
        }
        if ((i10 & 4) != 0) {
            str3 = resourceEntity.listName;
        }
        return resourceEntity.copy(str, str2, str3);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.value;
    }

    public final String component3() {
        return this.listName;
    }

    public final ResourceEntity copy(String str, String str2, String str3) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(str2, "value");
        j.g(str3, "listName");
        return new ResourceEntity(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResourceEntity)) {
            return false;
        }
        ResourceEntity resourceEntity = (ResourceEntity) obj;
        return j.b(this.key, resourceEntity.key) && j.b(this.value, resourceEntity.value) && j.b(this.listName, resourceEntity.listName);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getListName() {
        return this.listName;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + this.value.hashCode()) * 31) + this.listName.hashCode();
    }

    public String toString() {
        return "ResourceEntity(key=" + this.key + ", value=" + this.value + ", listName=" + this.listName + PropertyUtils.MAPPED_DELIM2;
    }
}
