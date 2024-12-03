package com.coffeemeetsbagel.likes_you;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f34233a;

    /* renamed from: b  reason: collision with root package name */
    private final String f34234b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34235c;

    public l(Integer num, String str, int i10) {
        j.g(str, "text");
        this.f34233a = num;
        this.f34234b = str;
        this.f34235c = i10;
    }

    public final Integer a() {
        return this.f34233a;
    }

    public final int b() {
        return this.f34235c;
    }

    public final String c() {
        return this.f34234b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return j.b(this.f34233a, lVar.f34233a) && j.b(this.f34234b, lVar.f34234b) && this.f34235c == lVar.f34235c;
    }

    public int hashCode() {
        Integer num = this.f34233a;
        return ((((num == null ? 0 : num.hashCode()) * 31) + this.f34234b.hashCode()) * 31) + Integer.hashCode(this.f34235c);
    }

    public String toString() {
        Integer num = this.f34233a;
        String str = this.f34234b;
        int i10 = this.f34235c;
        return "LikesYouMetaUiItem(icon=" + num + ", text=" + str + ", maxLines=" + i10 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(Integer num, String str, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str, (i11 & 4) != 0 ? 1 : i10);
    }
}
