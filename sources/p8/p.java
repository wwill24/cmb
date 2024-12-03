package p8;

import com.coffeemeetsbagel.feature.mongoose.sync.MongooseSyncJobService;
import com.coffeemeetsbagel.models.RosterElement;
import vj.j;

public final /* synthetic */ class p implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MongooseSyncJobService f17060a;

    public /* synthetic */ p(MongooseSyncJobService mongooseSyncJobService) {
        this.f17060a = mongooseSyncJobService;
    }

    public final Object apply(Object obj) {
        return this.f17060a.w((RosterElement) obj);
    }
}
