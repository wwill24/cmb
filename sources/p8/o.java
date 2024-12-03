package p8;

import com.coffeemeetsbagel.feature.mongoose.sync.MongooseSyncJobService;
import com.coffeemeetsbagel.models.RosterElement;
import vj.l;

public final /* synthetic */ class o implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MongooseSyncJobService f17059a;

    public /* synthetic */ o(MongooseSyncJobService mongooseSyncJobService) {
        this.f17059a = mongooseSyncJobService;
    }

    public final boolean test(Object obj) {
        return this.f17059a.B((RosterElement) obj);
    }
}
