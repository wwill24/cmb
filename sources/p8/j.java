package p8;

import com.coffeemeetsbagel.feature.mongoose.sync.MongooseSyncJobService;
import org.jxmpp.jid.Jid;

public final /* synthetic */ class j implements vj.j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MongooseSyncJobService f17054a;

    public /* synthetic */ j(MongooseSyncJobService mongooseSyncJobService) {
        this.f17054a = mongooseSyncJobService;
    }

    public final Object apply(Object obj) {
        return this.f17054a.t((Jid) obj);
    }
}
