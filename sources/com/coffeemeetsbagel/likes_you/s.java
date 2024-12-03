package com.coffeemeetsbagel.likes_you;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    private final String f34315a;

    /* renamed from: b  reason: collision with root package name */
    private final String f34316b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34317c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f34318d;

    /* renamed from: e  reason: collision with root package name */
    private final int f34319e;

    /* renamed from: f  reason: collision with root package name */
    private final int f34320f;

    public s(String str, String str2, int i10, Integer num, int i11, int i12) {
        j.g(str, "id");
        j.g(str2, "name");
        this.f34315a = str;
        this.f34316b = str2;
        this.f34317c = i10;
        this.f34318d = num;
        this.f34319e = i11;
        this.f34320f = i12;
    }

    public final int a() {
        return this.f34317c;
    }

    public final String b() {
        return this.f34315a;
    }

    public final Integer c() {
        return this.f34318d;
    }

    public final String d() {
        return this.f34316b;
    }

    public final int e() {
        return this.f34319e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return j.b(this.f34315a, sVar.f34315a) && j.b(this.f34316b, sVar.f34316b) && this.f34317c == sVar.f34317c && j.b(this.f34318d, sVar.f34318d) && this.f34319e == sVar.f34319e && this.f34320f == sVar.f34320f;
    }

    public int hashCode() {
        int hashCode = ((((this.f34315a.hashCode() * 31) + this.f34316b.hashCode()) * 31) + Integer.hashCode(this.f34317c)) * 31;
        Integer num = this.f34318d;
        return ((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.f34319e)) * 31) + Integer.hashCode(this.f34320f);
    }

    public String toString() {
        return "LikesYouTab(id=" + this.f34315a + ", name=" + this.f34316b + ", count=" + this.f34317c + ", maxCount=" + this.f34318d + ", ordinal=" + this.f34319e + ", freeProfilesIdsSize=" + this.f34320f + PropertyUtils.MAPPED_DELIM2;
    }
}
