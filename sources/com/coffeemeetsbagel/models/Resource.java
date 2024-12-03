package com.coffeemeetsbagel.models;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class Resource {
    private final String key;
    private String listName;
    private final String value;

    public Resource(String str, String str2, String str3) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(str2, "value");
        j.g(str3, "listName");
        this.key = str;
        this.value = str2;
        this.listName = str3;
    }

    public static /* synthetic */ Resource copy$default(Resource resource, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = resource.key;
        }
        if ((i10 & 2) != 0) {
            str2 = resource.value;
        }
        if ((i10 & 4) != 0) {
            str3 = resource.listName;
        }
        return resource.copy(str, str2, str3);
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

    public final Resource copy(String str, String str2, String str3) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(str2, "value");
        j.g(str3, "listName");
        return new Resource(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Resource)) {
            return false;
        }
        Resource resource = (Resource) obj;
        return j.b(this.key, resource.key) && j.b(this.value, resource.value) && j.b(this.listName, resource.listName);
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

    public final void setListName(String str) {
        j.g(str, "<set-?>");
        this.listName = str;
    }

    public String toString() {
        return "Resource(key=" + this.key + ", value=" + this.value + ", listName=" + this.listName + PropertyUtils.MAPPED_DELIM2;
    }
}
