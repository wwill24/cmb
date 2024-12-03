package p8;

import android.app.job.JobParameters;
import com.coffeemeetsbagel.feature.mongoose.sync.MongooseSyncJobService;
import vj.f;

public final /* synthetic */ class m implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MongooseSyncJobService f17057a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JobParameters f17058b;

    public /* synthetic */ m(MongooseSyncJobService mongooseSyncJobService, JobParameters jobParameters) {
        this.f17057a = mongooseSyncJobService;
        this.f17058b = jobParameters;
    }

    public final void accept(Object obj) {
        this.f17057a.v(this.f17058b, (Throwable) obj);
    }
}
