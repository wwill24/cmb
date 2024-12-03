package com.coffeemeetsbagel.likes_you;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final String f34197a;

    /* renamed from: b  reason: collision with root package name */
    private final String f34198b;

    /* renamed from: c  reason: collision with root package name */
    private final String f34199c;

    /* renamed from: d  reason: collision with root package name */
    private final String f34200d;

    /* renamed from: e  reason: collision with root package name */
    private final String f34201e;

    public g(String str, String str2, String str3, String str4, String str5) {
        this.f34197a = str;
        this.f34198b = str2;
        this.f34199c = str3;
        this.f34200d = str4;
        this.f34201e = str5;
    }

    public final String a() {
        return this.f34197a;
    }

    public final String b() {
        return this.f34198b;
    }

    public final String c() {
        return this.f34199c;
    }

    public final String d() {
        return this.f34200d;
    }

    public final String e() {
        return this.f34201e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return j.b(this.f34197a, gVar.f34197a) && j.b(this.f34198b, gVar.f34198b) && j.b(this.f34199c, gVar.f34199c) && j.b(this.f34200d, gVar.f34200d) && j.b(this.f34201e, gVar.f34201e);
    }

    public int hashCode() {
        String str = this.f34197a;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f34198b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f34199c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f34200d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f34201e;
        if (str5 != null) {
            i10 = str5.hashCode();
        }
        return hashCode4 + i10;
    }

    public String toString() {
        return "LikesYouEmptyState(action=" + this.f34197a + ", callToActionText=" + this.f34198b + ", descriptionText=" + this.f34199c + ", imageUrl=" + this.f34200d + ", titleText=" + this.f34201e + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(String str, String str2, String str3, String str4, String str5, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i10 & 8) != 0 ? null : str4, str5);
    }
}
