package com.coffeemeetsbagel.profile;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final String f36126a;

    /* renamed from: b  reason: collision with root package name */
    private final String f36127b;

    public n(String str, String str2) {
        j.g(str, "school");
        j.g(str2, "degreeId");
        this.f36126a = str;
        this.f36127b = str2;
    }

    public final String a() {
        return this.f36127b;
    }

    public final String b() {
        return this.f36126a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return j.b(this.f36126a, nVar.f36126a) && j.b(this.f36127b, nVar.f36127b);
    }

    public int hashCode() {
        return (this.f36126a.hashCode() * 31) + this.f36127b.hashCode();
    }

    public String toString() {
        return "ProfileEducation(school=" + this.f36126a + ", degreeId=" + this.f36127b + PropertyUtils.MAPPED_DELIM2;
    }
}
