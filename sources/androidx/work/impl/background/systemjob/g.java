package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.core.util.a;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.e0;
import androidx.work.impl.t;
import b2.f;
import g2.l;
import g2.m;
import g2.u;
import g2.v;
import g2.x;
import h2.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class g implements t {

    /* renamed from: e  reason: collision with root package name */
    private static final String f7479e = f.i("SystemJobScheduler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f7480a;

    /* renamed from: b  reason: collision with root package name */
    private final JobScheduler f7481b;

    /* renamed from: c  reason: collision with root package name */
    private final e0 f7482c;

    /* renamed from: d  reason: collision with root package name */
    private final f f7483d;

    public g(@NonNull Context context, @NonNull e0 e0Var) {
        this(context, e0Var, (JobScheduler) context.getSystemService("jobscheduler"), new f(context));
    }

    public static void a(@NonNull Context context) {
        List<JobInfo> g10;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (g10 = g(context, jobScheduler)) != null && !g10.isEmpty()) {
            for (JobInfo id2 : g10) {
                b(jobScheduler, id2.getId());
            }
        }
    }

    private static void b(@NonNull JobScheduler jobScheduler, int i10) {
        try {
            jobScheduler.cancel(i10);
        } catch (Throwable th2) {
            f.e().d(f7479e, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(i10)}), th2);
        }
    }

    private static List<Integer> f(@NonNull Context context, @NonNull JobScheduler jobScheduler, @NonNull String str) {
        List<JobInfo> g10 = g(context, jobScheduler);
        if (g10 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo next : g10) {
            m h10 = h(next);
            if (h10 != null && str.equals(h10.b())) {
                arrayList.add(Integer.valueOf(next.getId()));
            }
        }
        return arrayList;
    }

    private static List<JobInfo> g(@NonNull Context context, @NonNull JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th2) {
            f.e().d(f7479e, "getAllPendingJobs() is not reliable on this device.", th2);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo next : list) {
            if (componentName.equals(next.getService())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static m h(@NonNull JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new m(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean i(@NonNull Context context, @NonNull e0 e0Var) {
        int i10;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> g10 = g(context, jobScheduler);
        List<String> e10 = e0Var.o().H().e();
        boolean z10 = false;
        if (g10 != null) {
            i10 = g10.size();
        } else {
            i10 = 0;
        }
        HashSet hashSet = new HashSet(i10);
        if (g10 != null && !g10.isEmpty()) {
            for (JobInfo next : g10) {
                m h10 = h(next);
                if (h10 != null) {
                    hashSet.add(h10.b());
                } else {
                    b(jobScheduler, next.getId());
                }
            }
        }
        Iterator<String> it = e10.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!hashSet.contains(it.next())) {
                    f.e().a(f7479e, "Reconciling jobs");
                    z10 = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z10) {
            WorkDatabase o10 = e0Var.o();
            o10.e();
            try {
                v K = o10.K();
                for (String m10 : e10) {
                    K.m(m10, -1);
                }
                o10.C();
            } finally {
                o10.j();
            }
        }
        return z10;
    }

    public void c(@NonNull String str) {
        List<Integer> f10 = f(this.f7480a, this.f7481b, str);
        if (f10 != null && !f10.isEmpty()) {
            for (Integer intValue : f10) {
                b(this.f7481b, intValue.intValue());
            }
            this.f7482c.o().H().g(str);
        }
    }

    public void d(@NonNull u... uVarArr) {
        int i10;
        WorkDatabase o10 = this.f7482c.o();
        i iVar = new i(o10);
        int length = uVarArr.length;
        int i11 = 0;
        while (i11 < length) {
            u uVar = uVarArr[i11];
            o10.e();
            try {
                u h10 = o10.K().h(uVar.f15077a);
                if (h10 == null) {
                    f e10 = f.e();
                    String str = f7479e;
                    e10.k(str, "Skipping scheduling " + uVar.f15077a + " because it's no longer in the DB");
                    o10.C();
                } else if (h10.f15078b != WorkInfo.State.ENQUEUED) {
                    f e11 = f.e();
                    String str2 = f7479e;
                    e11.k(str2, "Skipping scheduling " + uVar.f15077a + " because it is no longer enqueued");
                    o10.C();
                } else {
                    m a10 = x.a(uVar);
                    g2.i c10 = o10.H().c(a10);
                    if (c10 != null) {
                        i10 = c10.f15050c;
                    } else {
                        i10 = iVar.e(this.f7482c.h().i(), this.f7482c.h().g());
                    }
                    if (c10 == null) {
                        this.f7482c.o().H().b(l.a(a10, i10));
                    }
                    j(uVar, i10);
                    o10.C();
                }
                i11++;
            } finally {
                o10.j();
            }
        }
    }

    public boolean e() {
        return true;
    }

    public void j(@NonNull u uVar, int i10) {
        int i11;
        JobInfo a10 = this.f7483d.a(uVar, i10);
        f e10 = f.e();
        String str = f7479e;
        e10.a(str, "Scheduling work ID " + uVar.f15077a + "Job ID " + i10);
        try {
            if (this.f7481b.schedule(a10) == 0) {
                f.e().k(str, "Unable to schedule work ID " + uVar.f15077a);
                if (uVar.f15093q && uVar.f15094r == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    uVar.f15093q = false;
                    f.e().a(str, String.format("Scheduling a non-expedited job (work ID %s)", new Object[]{uVar.f15077a}));
                    j(uVar, i10);
                }
            }
        } catch (IllegalStateException e11) {
            List<JobInfo> g10 = g(this.f7480a, this.f7481b);
            if (g10 != null) {
                i11 = g10.size();
            } else {
                i11 = 0;
            }
            String format2 = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(i11), Integer.valueOf(this.f7482c.o().K().d().size()), Integer.valueOf(this.f7482c.h().h())});
            f.e().c(f7479e, format2);
            IllegalStateException illegalStateException = new IllegalStateException(format2, e11);
            a<Throwable> l10 = this.f7482c.h().l();
            if (l10 != null) {
                l10.accept(illegalStateException);
                return;
            }
            throw illegalStateException;
        } catch (Throwable th2) {
            f.e().d(f7479e, "Unable to schedule " + uVar, th2);
        }
    }

    public g(@NonNull Context context, @NonNull e0 e0Var, @NonNull JobScheduler jobScheduler, @NonNull f fVar) {
        this.f7480a = context;
        this.f7482c = e0Var;
        this.f7481b = jobScheduler;
        this.f7483d = fVar;
    }
}
