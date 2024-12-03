package com.coffeemeetsbagel.qna.data.network;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NetworkOption implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private final String f36267id;
    private final String name;
    private final String title;

    public NetworkOption(String str, String str2, String str3) {
        j.g(str, "id");
        j.g(str2, "title");
        this.f36267id = str;
        this.title = str2;
        this.name = str3;
    }

    public static /* synthetic */ NetworkOption copy$default(NetworkOption networkOption, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = networkOption.f36267id;
        }
        if ((i10 & 2) != 0) {
            str2 = networkOption.title;
        }
        if ((i10 & 4) != 0) {
            str3 = networkOption.name;
        }
        return networkOption.copy(str, str2, str3);
    }

    public final String component1() {
        return this.f36267id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.name;
    }

    public final NetworkOption copy(String str, String str2, String str3) {
        j.g(str, "id");
        j.g(str2, "title");
        return new NetworkOption(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkOption)) {
            return false;
        }
        NetworkOption networkOption = (NetworkOption) obj;
        return j.b(this.f36267id, networkOption.f36267id) && j.b(this.title, networkOption.title) && j.b(this.name, networkOption.name);
    }

    public final String getId() {
        return this.f36267id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((this.f36267id.hashCode() * 31) + this.title.hashCode()) * 31;
        String str = this.name;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "NetworkOption(id=" + this.f36267id + ", title=" + this.title + ", name=" + this.name + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkOption(String str, String str2, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i10 & 4) != 0 ? null : str3);
    }
}
