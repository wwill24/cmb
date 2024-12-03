package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import ed.p;
import ed.u;
import ld.c;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;
import pd.a;

public class JobInfoSchedulerService extends JobService {
    /* access modifiers changed from: private */
    public /* synthetic */ void b(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i10 = jobParameters.getExtras().getInt(JingleS5BTransportCandidate.ATTR_PRIORITY);
        int i11 = jobParameters.getExtras().getInt("attemptNumber");
        u.f(getApplicationContext());
        p.a d10 = p.a().b(string).d(a.b(i10));
        if (string2 != null) {
            d10.c(Base64.decode(string2, 0));
        }
        u.c().e().v(d10.a(), i11, new c(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
