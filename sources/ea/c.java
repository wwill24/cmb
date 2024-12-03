package ea;

import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.j;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f40640a;

    /* renamed from: b  reason: collision with root package name */
    private final int f40641b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40642c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40643d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f40644e;

    /* renamed from: f  reason: collision with root package name */
    private final PurchaseAttribution f40645f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Triple<String, String, PurchaseAttribution>> f40646g;

    public c(int i10, int i11, String str, String str2, boolean z10, PurchaseAttribution purchaseAttribution, List<? extends Triple<String, String, ? extends PurchaseAttribution>> list) {
        j.g(str, "matchId");
        j.g(str2, "profileId");
        j.g(list, "allCards");
        this.f40640a = i10;
        this.f40641b = i11;
        this.f40642c = str;
        this.f40643d = str2;
        this.f40644e = z10;
        this.f40645f = purchaseAttribution;
        this.f40646g = list;
    }

    public final List<Triple<String, String, PurchaseAttribution>> a() {
        return this.f40646g;
    }

    public final String b() {
        return this.f40642c;
    }

    public final int c() {
        return this.f40641b;
    }

    public final int d() {
        return this.f40640a;
    }

    public final String e() {
        return this.f40643d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f40640a == cVar.f40640a && this.f40641b == cVar.f40641b && j.b(this.f40642c, cVar.f40642c) && j.b(this.f40643d, cVar.f40643d) && this.f40644e == cVar.f40644e && this.f40645f == cVar.f40645f && j.b(this.f40646g, cVar.f40646g);
    }

    public final PurchaseAttribution f() {
        return this.f40645f;
    }

    public final boolean g() {
        return this.f40644e;
    }

    public int hashCode() {
        int hashCode = ((((((Integer.hashCode(this.f40640a) * 31) + Integer.hashCode(this.f40641b)) * 31) + this.f40642c.hashCode()) * 31) + this.f40643d.hashCode()) * 31;
        boolean z10 = this.f40644e;
        if (z10) {
            z10 = true;
        }
        int i10 = (hashCode + (z10 ? 1 : 0)) * 31;
        PurchaseAttribution purchaseAttribution = this.f40645f;
        return ((i10 + (purchaseAttribution == null ? 0 : purchaseAttribution.hashCode())) * 31) + this.f40646g.hashCode();
    }

    public String toString() {
        int i10 = this.f40640a;
        int i11 = this.f40641b;
        String str = this.f40642c;
        String str2 = this.f40643d;
        boolean z10 = this.f40644e;
        PurchaseAttribution purchaseAttribution = this.f40645f;
        List<Triple<String, String, PurchaseAttribution>> list = this.f40646g;
        return "GridClickData(position=" + i10 + ", maxItems=" + i11 + ", matchId=" + str + ", profileId=" + str2 + ", isBlurred=" + z10 + ", purchaseAttribution=" + purchaseAttribution + ", allCards=" + list + ")";
    }
}
