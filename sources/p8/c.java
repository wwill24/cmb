package p8;

import android.app.job.JobParameters;
import com.coffeemeetsbagel.feature.mongoose.sync.MongooseSyncJobService;
import java.util.List;
import vj.f;

public final /* synthetic */ class c implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MongooseSyncJobService f17050a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JobParameters f17051b;

    public /* synthetic */ c(MongooseSyncJobService mongooseSyncJobService, JobParameters jobParameters) {
        this.f17050a = mongooseSyncJobService;
        this.f17051b = jobParameters;
    }

    public final void accept(Object obj) {
        this.f17050a.x(this.f17051b, (List) obj);
    }
}
