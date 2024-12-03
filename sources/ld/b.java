package ld;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import ed.p;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;
import md.d;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;
import pd.a;

public class b implements u {

    /* renamed from: a  reason: collision with root package name */
    private final Context f41118a;

    /* renamed from: b  reason: collision with root package name */
    private final d f41119b;

    /* renamed from: c  reason: collision with root package name */
    private final SchedulerConfig f41120c;

    public b(Context context, d dVar, SchedulerConfig schedulerConfig) {
        this.f41118a = context;
        this.f41119b = dVar;
        this.f41120c = schedulerConfig;
    }

    private boolean d(JobScheduler jobScheduler, int i10, int i11) {
        for (JobInfo next : jobScheduler.getAllPendingJobs()) {
            int i12 = next.getExtras().getInt("attemptNumber");
            if (next.getId() == i10) {
                if (i12 >= i11) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public void a(p pVar, int i10) {
        b(pVar, i10, false);
    }

    public void b(p pVar, int i10, boolean z10) {
        ComponentName componentName = new ComponentName(this.f41118a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f41118a.getSystemService("jobscheduler");
        int c10 = c(pVar);
        if (z10 || !d(jobScheduler, c10, i10)) {
            long u12 = this.f41119b.u1(pVar);
            JobInfo.Builder c11 = this.f41120c.c(new JobInfo.Builder(c10, componentName), pVar.d(), u12, i10);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i10);
            persistableBundle.putString("backendName", pVar.b());
            persistableBundle.putInt(JingleS5BTransportCandidate.ATTR_PRIORITY, a.a(pVar.d()));
            if (pVar.c() != null) {
                persistableBundle.putString("extras", Base64.encodeToString(pVar.c(), 0));
            }
            c11.setExtras(persistableBundle);
            id.a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", pVar, Integer.valueOf(c10), Long.valueOf(this.f41120c.g(pVar.d(), u12, i10)), Long.valueOf(u12), Integer.valueOf(i10));
            jobScheduler.schedule(c11.build());
            return;
        }
        id.a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
    }

    /* access modifiers changed from: package-private */
    public int c(p pVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f41118a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(pVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(a.a(pVar.d())).array());
        if (pVar.c() != null) {
            adler32.update(pVar.c());
        }
        return (int) adler32.getValue();
    }
}
