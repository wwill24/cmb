package ic;

import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.entities.SuggestedLimitsEntity;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import kotlin.jvm.internal.j;
import vb.a;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final List<Bagel> f40974a;

    /* renamed from: b  reason: collision with root package name */
    private final ProfileManager.ProfileStatus f40975b;

    /* renamed from: c  reason: collision with root package name */
    private final Optional<a> f40976c;

    /* renamed from: d  reason: collision with root package name */
    private final Optional<SuggestedLimitsEntity> f40977d;

    public p(List<? extends Bagel> list, ProfileManager.ProfileStatus profileStatus, Optional<a> optional, Optional<SuggestedLimitsEntity> optional2) {
        j.g(list, "bagels");
        j.g(profileStatus, "holdStatus");
        j.g(optional, "subscriptionOptional");
        j.g(optional2, "limitsOptional");
        this.f40974a = list;
        this.f40975b = profileStatus;
        this.f40976c = optional;
        this.f40977d = optional2;
    }

    public final List<Bagel> a() {
        return this.f40974a;
    }

    public final ProfileManager.ProfileStatus b() {
        return this.f40975b;
    }

    public final Optional<SuggestedLimitsEntity> c() {
        return this.f40977d;
    }

    public final Optional<a> d() {
        return this.f40976c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return j.b(this.f40974a, pVar.f40974a) && this.f40975b == pVar.f40975b && j.b(this.f40976c, pVar.f40976c) && j.b(this.f40977d, pVar.f40977d);
    }

    public int hashCode() {
        return (((((this.f40974a.hashCode() * 31) + this.f40975b.hashCode()) * 31) + this.f40976c.hashCode()) * 31) + this.f40977d.hashCode();
    }

    public String toString() {
        List<Bagel> list = this.f40974a;
        ProfileManager.ProfileStatus profileStatus = this.f40975b;
        Optional<a> optional = this.f40976c;
        Optional<SuggestedLimitsEntity> optional2 = this.f40977d;
        return "TodayViewState(bagels=" + list + ", holdStatus=" + profileStatus + ", subscriptionOptional=" + optional + ", limitsOptional=" + optional2 + ")";
    }
}
