package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.work.impl.e;
import androidx.work.impl.e0;
import androidx.work.impl.v;
import androidx.work.impl.w;
import b2.f;
import g2.m;
import java.util.HashMap;
import java.util.Map;

public class SystemJobService extends JobService implements e {

    /* renamed from: d  reason: collision with root package name */
    private static final String f7472d = f.i("SystemJobService");

    /* renamed from: a  reason: collision with root package name */
    private e0 f7473a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<m, JobParameters> f7474b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final w f7475c = new w();

    static class a {
        static String[] a(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentAuthorities();
        }

        static Uri[] b(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentUris();
        }
    }

    static class b {
        static Network a(JobParameters jobParameters) {
            return jobParameters.getNetwork();
        }
    }

    private static m b(@NonNull JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new m(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public void a(@NonNull m mVar, boolean z10) {
        JobParameters remove;
        f e10 = f.e();
        String str = f7472d;
        e10.a(str, mVar.b() + " executed on JobScheduler");
        synchronized (this.f7474b) {
            remove = this.f7474b.remove(mVar);
        }
        this.f7475c.b(mVar);
        if (remove != null) {
            jobFinished(remove, z10);
        }
    }

    public void onCreate() {
        super.onCreate();
        try {
            e0 j10 = e0.j(getApplicationContext());
            this.f7473a = j10;
            j10.l().g(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                f.e().k(f7472d, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        e0 e0Var = this.f7473a;
        if (e0Var != null) {
            e0Var.l().n(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006e, code lost:
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = new androidx.work.WorkerParameters.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0079, code lost:
        if (androidx.work.impl.background.systemjob.SystemJobService.a.b(r8) == null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007b, code lost:
        r3.f7367b = java.util.Arrays.asList(androidx.work.impl.background.systemjob.SystemJobService.a.b(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0089, code lost:
        if (androidx.work.impl.background.systemjob.SystemJobService.a.a(r8) == null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008b, code lost:
        r3.f7366a = java.util.Arrays.asList(androidx.work.impl.background.systemjob.SystemJobService.a.a(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0097, code lost:
        if (r2 < 28) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0099, code lost:
        r3.f7368c = androidx.work.impl.background.systemjob.SystemJobService.b.a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009f, code lost:
        r7.f7473a.v(r7.f7475c.d(r0), r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00aa, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStartJob(@androidx.annotation.NonNull android.app.job.JobParameters r8) {
        /*
            r7 = this;
            androidx.work.impl.e0 r0 = r7.f7473a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0015
            b2.f r0 = b2.f.e()
            java.lang.String r3 = f7472d
            java.lang.String r4 = "WorkManager is not initialized; requesting retry."
            r0.a(r3, r4)
            r7.jobFinished(r8, r1)
            return r2
        L_0x0015:
            g2.m r0 = b(r8)
            if (r0 != 0) goto L_0x0027
            b2.f r8 = b2.f.e()
            java.lang.String r0 = f7472d
            java.lang.String r1 = "WorkSpec id not found!"
            r8.c(r0, r1)
            return r2
        L_0x0027:
            java.util.Map<g2.m, android.app.job.JobParameters> r3 = r7.f7474b
            monitor-enter(r3)
            java.util.Map<g2.m, android.app.job.JobParameters> r4 = r7.f7474b     // Catch:{ all -> 0x00ab }
            boolean r4 = r4.containsKey(r0)     // Catch:{ all -> 0x00ab }
            if (r4 == 0) goto L_0x004e
            b2.f r8 = b2.f.e()     // Catch:{ all -> 0x00ab }
            java.lang.String r1 = f7472d     // Catch:{ all -> 0x00ab }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ab }
            r4.<init>()     // Catch:{ all -> 0x00ab }
            java.lang.String r5 = "Job is already being executed by SystemJobService: "
            r4.append(r5)     // Catch:{ all -> 0x00ab }
            r4.append(r0)     // Catch:{ all -> 0x00ab }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x00ab }
            r8.a(r1, r0)     // Catch:{ all -> 0x00ab }
            monitor-exit(r3)     // Catch:{ all -> 0x00ab }
            return r2
        L_0x004e:
            b2.f r2 = b2.f.e()     // Catch:{ all -> 0x00ab }
            java.lang.String r4 = f7472d     // Catch:{ all -> 0x00ab }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ab }
            r5.<init>()     // Catch:{ all -> 0x00ab }
            java.lang.String r6 = "onStartJob for "
            r5.append(r6)     // Catch:{ all -> 0x00ab }
            r5.append(r0)     // Catch:{ all -> 0x00ab }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00ab }
            r2.a(r4, r5)     // Catch:{ all -> 0x00ab }
            java.util.Map<g2.m, android.app.job.JobParameters> r2 = r7.f7474b     // Catch:{ all -> 0x00ab }
            r2.put(r0, r8)     // Catch:{ all -> 0x00ab }
            monitor-exit(r3)     // Catch:{ all -> 0x00ab }
            int r2 = android.os.Build.VERSION.SDK_INT
            androidx.work.WorkerParameters$a r3 = new androidx.work.WorkerParameters$a
            r3.<init>()
            android.net.Uri[] r4 = androidx.work.impl.background.systemjob.SystemJobService.a.b(r8)
            if (r4 == 0) goto L_0x0085
            android.net.Uri[] r4 = androidx.work.impl.background.systemjob.SystemJobService.a.b(r8)
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.f7367b = r4
        L_0x0085:
            java.lang.String[] r4 = androidx.work.impl.background.systemjob.SystemJobService.a.a(r8)
            if (r4 == 0) goto L_0x0095
            java.lang.String[] r4 = androidx.work.impl.background.systemjob.SystemJobService.a.a(r8)
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.f7366a = r4
        L_0x0095:
            r4 = 28
            if (r2 < r4) goto L_0x009f
            android.net.Network r8 = androidx.work.impl.background.systemjob.SystemJobService.b.a(r8)
            r3.f7368c = r8
        L_0x009f:
            androidx.work.impl.e0 r8 = r7.f7473a
            androidx.work.impl.w r2 = r7.f7475c
            androidx.work.impl.v r0 = r2.d(r0)
            r8.v(r0, r3)
            return r1
        L_0x00ab:
            r8 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00ab }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    public boolean onStopJob(@NonNull JobParameters jobParameters) {
        if (this.f7473a == null) {
            f.e().a(f7472d, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        m b10 = b(jobParameters);
        if (b10 == null) {
            f.e().c(f7472d, "WorkSpec id not found!");
            return false;
        }
        f e10 = f.e();
        String str = f7472d;
        e10.a(str, "onStopJob for " + b10);
        synchronized (this.f7474b) {
            this.f7474b.remove(b10);
        }
        v b11 = this.f7475c.b(b10);
        if (b11 != null) {
            this.f7473a.x(b11);
        }
        return !this.f7473a.l().j(b10.b());
    }
}
