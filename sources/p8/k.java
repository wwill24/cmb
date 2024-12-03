package p8;

import com.coffeemeetsbagel.feature.mongoose.sync.MongooseSyncJobService;
import com.coffeemeetsbagel.models.RosterElement;
import java.util.Comparator;

public final /* synthetic */ class k implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MongooseSyncJobService f17055a;

    public /* synthetic */ k(MongooseSyncJobService mongooseSyncJobService) {
        this.f17055a = mongooseSyncJobService;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f17055a.G((RosterElement) obj, (RosterElement) obj2);
    }
}
