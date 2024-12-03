package com.coffeemeetsbagel.profile;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final String f36095a;

    /* renamed from: b  reason: collision with root package name */
    private final String f36096b;

    /* renamed from: c  reason: collision with root package name */
    private final String f36097c;

    public i(String str, String str2, String str3) {
        j.g(str, "firstIcebreaker");
        j.g(str2, "secondIcebreaker");
        j.g(str3, "thirdIcebreaker");
        this.f36095a = str;
        this.f36096b = str2;
        this.f36097c = str3;
    }

    public final String a() {
        return this.f36095a;
    }

    public final String b() {
        return this.f36096b;
    }

    public final String c() {
        return this.f36097c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return j.b(this.f36095a, iVar.f36095a) && j.b(this.f36096b, iVar.f36096b) && j.b(this.f36097c, iVar.f36097c);
    }

    public int hashCode() {
        return (((this.f36095a.hashCode() * 31) + this.f36096b.hashCode()) * 31) + this.f36097c.hashCode();
    }

    public String toString() {
        return "Icebreakers(firstIcebreaker=" + this.f36095a + ", secondIcebreaker=" + this.f36096b + ", thirdIcebreaker=" + this.f36097c + PropertyUtils.MAPPED_DELIM2;
    }
}
