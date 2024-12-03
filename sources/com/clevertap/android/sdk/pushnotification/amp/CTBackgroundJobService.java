package com.clevertap.android.sdk.pushnotification.amp;

import android.app.job.JobParameters;
import android.app.job.JobService;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.p;

public class CTBackgroundJobService extends JobService {

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ JobParameters f10715a;

        a(JobParameters jobParameters) {
            this.f10715a = jobParameters;
        }

        public void run() {
            CleverTapAPI.a0(CTBackgroundJobService.this.getApplicationContext(), this.f10715a);
            CTBackgroundJobService.this.jobFinished(this.f10715a, true);
        }
    }

    public boolean onStartJob(JobParameters jobParameters) {
        p.o("Job Service is starting");
        new Thread(new a(jobParameters)).start();
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
