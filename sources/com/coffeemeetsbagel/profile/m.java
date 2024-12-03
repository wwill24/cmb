package com.coffeemeetsbagel.profile;

import kotlin.jvm.internal.j;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f36123a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f36124b;

    public m(String str, boolean z10) {
        j.g(str, "answer");
        this.f36123a = str;
        this.f36124b = z10;
    }

    public final String a() {
        return this.f36123a;
    }

    public final boolean b() {
        return this.f36124b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return j.b(this.f36123a, mVar.f36123a) && this.f36124b == mVar.f36124b;
    }

    public int hashCode() {
        int hashCode = this.f36123a.hashCode() * 31;
        boolean z10 = this.f36124b;
        if (z10) {
            z10 = true;
        }
        return hashCode + (z10 ? 1 : 0);
    }

    public String toString() {
        String str = this.f36123a;
        boolean z10 = this.f36124b;
        return "ProfileAnswerItem(answer=" + str + ", inCommon=" + z10 + ")";
    }
}
