package ic;

import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.today_view.main.e;
import com.coffeemeetsbagel.utils.model.Optional;
import java.util.List;
import vj.f;

public final /* synthetic */ class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f40952a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f40953b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ProfileManager.ProfileStatus f40954c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Optional f40955d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Optional f40956e;

    public /* synthetic */ g(e eVar, List list, ProfileManager.ProfileStatus profileStatus, Optional optional, Optional optional2) {
        this.f40952a = eVar;
        this.f40953b = list;
        this.f40954c = profileStatus;
        this.f40955d = optional;
        this.f40956e = optional2;
    }

    public final void accept(Object obj) {
        this.f40952a.j2(this.f40953b, this.f40954c, this.f40955d, this.f40956e, (List) obj);
    }
}
