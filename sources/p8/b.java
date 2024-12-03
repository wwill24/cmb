package p8;

import com.coffeemeetsbagel.feature.mongoose.sync.MongooseSyncJobService;
import java.util.Collection;
import vj.j;

public final /* synthetic */ class b implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MongooseSyncJobService f17049a;

    public /* synthetic */ b(MongooseSyncJobService mongooseSyncJobService) {
        this.f17049a = mongooseSyncJobService;
    }

    public final Object apply(Object obj) {
        return this.f17049a.H((Collection) obj);
    }
}
