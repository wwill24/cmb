package ld;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JobInfoSchedulerService f41121a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JobParameters f41122b;

    public /* synthetic */ c(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f41121a = jobInfoSchedulerService;
        this.f41122b = jobParameters;
    }

    public final void run() {
        this.f41121a.b(this.f41122b);
    }
}
