package vb;

import com.coffeemeetsbagel.models.entities.SubscriptionState;
import com.coffeemeetsbagel.store.domain.BenefitKeys;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f42040a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f42041b;

    /* renamed from: c  reason: collision with root package name */
    private final String f42042c;

    /* renamed from: d  reason: collision with root package name */
    private final String f42043d;

    /* renamed from: e  reason: collision with root package name */
    private final String f42044e;

    /* renamed from: f  reason: collision with root package name */
    private final SubscriptionState f42045f;

    /* renamed from: g  reason: collision with root package name */
    private final String f42046g;

    /* renamed from: h  reason: collision with root package name */
    private final int f42047h;

    /* renamed from: i  reason: collision with root package name */
    private final String f42048i;

    public a(boolean z10, List<b> list, String str, String str2, String str3, SubscriptionState subscriptionState, String str4, int i10, String str5) {
        j.g(list, "benefits");
        j.g(str2, "sku");
        j.g(str3, "startDate");
        j.g(str4, "bundleId");
        j.g(str5, SDKConstants.PARAM_PURCHASE_TOKEN);
        this.f42040a = z10;
        this.f42041b = list;
        this.f42042c = str;
        this.f42043d = str2;
        this.f42044e = str3;
        this.f42045f = subscriptionState;
        this.f42046g = str4;
        this.f42047h = i10;
        this.f42048i = str5;
    }

    public final boolean a() {
        return this.f42040a;
    }

    public final List<b> b() {
        return this.f42041b;
    }

    public final String c() {
        return this.f42046g;
    }

    public final String d() {
        return this.f42042c;
    }

    public final String e() {
        return this.f42043d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f42040a == aVar.f42040a && j.b(this.f42041b, aVar.f42041b) && j.b(this.f42042c, aVar.f42042c) && j.b(this.f42043d, aVar.f42043d) && j.b(this.f42044e, aVar.f42044e) && this.f42045f == aVar.f42045f && j.b(this.f42046g, aVar.f42046g) && this.f42047h == aVar.f42047h && j.b(this.f42048i, aVar.f42048i);
    }

    public final SubscriptionState f() {
        return this.f42045f;
    }

    public final int g() {
        return this.f42047h;
    }

    public final boolean h(BenefitKeys benefitKeys) {
        j.g(benefitKeys, "benefitKey");
        List<b> list = this.f42041b;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (b g10 : list) {
            if (g10.g(benefitKeys)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        boolean z10 = this.f42040a;
        if (z10) {
            z10 = true;
        }
        int hashCode = (((z10 ? 1 : 0) * true) + this.f42041b.hashCode()) * 31;
        String str = this.f42042c;
        int i10 = 0;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f42043d.hashCode()) * 31) + this.f42044e.hashCode()) * 31;
        SubscriptionState subscriptionState = this.f42045f;
        if (subscriptionState != null) {
            i10 = subscriptionState.hashCode();
        }
        return ((((((hashCode2 + i10) * 31) + this.f42046g.hashCode()) * 31) + Integer.hashCode(this.f42047h)) * 31) + this.f42048i.hashCode();
    }

    public String toString() {
        return "ActiveSubscription(autoRenew=" + this.f42040a + ", benefits=" + this.f42041b + ", expiryDate=" + this.f42042c + ", sku=" + this.f42043d + ", startDate=" + this.f42044e + ", subscriptionState=" + this.f42045f + ", bundleId=" + this.f42046g + ", tier=" + this.f42047h + ", purchaseToken=" + this.f42048i + PropertyUtils.MAPPED_DELIM2;
    }
}
