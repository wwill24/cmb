package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.facebook.AuthenticationTokenClaims;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
public abstract class i extends Service {
    static final boolean DEBUG = false;
    static final String TAG = "JobIntentService";
    static final HashMap<ComponentName, h> sClassWorkEnqueuer = new HashMap<>();
    static final Object sLock = new Object();
    final ArrayList<d> mCompatQueue;
    h mCompatWorkEnqueuer;
    a mCurProcessor;
    boolean mDestroyed = false;
    boolean mInterruptIfStopped = false;
    b mJobImpl;
    boolean mStopped = false;

    final class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e dequeueWork = i.this.dequeueWork();
                if (dequeueWork == null) {
                    return null;
                }
                i.this.onHandleWork(dequeueWork.getIntent());
                dequeueWork.complete();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onCancelled(Void voidR) {
            i.this.processorFinished();
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(Void voidR) {
            i.this.processorFinished();
        }
    }

    interface b {
        IBinder a();

        e b();
    }

    static final class c extends h {

        /* renamed from: d  reason: collision with root package name */
        private final Context f4434d;

        /* renamed from: e  reason: collision with root package name */
        private final PowerManager.WakeLock f4435e;

        /* renamed from: f  reason: collision with root package name */
        private final PowerManager.WakeLock f4436f;

        /* renamed from: g  reason: collision with root package name */
        boolean f4437g;

        /* renamed from: h  reason: collision with root package name */
        boolean f4438h;

        c(Context context, ComponentName componentName) {
            super(componentName);
            this.f4434d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f4435e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f4436f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        /* access modifiers changed from: package-private */
        public void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f4449a);
            if (this.f4434d.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.f4437g) {
                        this.f4437g = true;
                        if (!this.f4438h) {
                            this.f4435e.acquire(DateUtils.MILLIS_IN_MINUTE);
                        }
                    }
                }
            }
        }

        public void c() {
            synchronized (this) {
                if (this.f4438h) {
                    if (this.f4437g) {
                        this.f4435e.acquire(DateUtils.MILLIS_IN_MINUTE);
                    }
                    this.f4438h = false;
                    this.f4436f.release();
                }
            }
        }

        public void d() {
            synchronized (this) {
                if (!this.f4438h) {
                    this.f4438h = true;
                    this.f4436f.acquire(AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED);
                    this.f4435e.release();
                }
            }
        }

        public void e() {
            synchronized (this) {
                this.f4437g = false;
            }
        }
    }

    final class d implements e {

        /* renamed from: a  reason: collision with root package name */
        final Intent f4439a;

        /* renamed from: b  reason: collision with root package name */
        final int f4440b;

        d(Intent intent, int i10) {
            this.f4439a = intent;
            this.f4440b = i10;
        }

        public void complete() {
            i.this.stopSelf(this.f4440b);
        }

        public Intent getIntent() {
            return this.f4439a;
        }
    }

    interface e {
        void complete();

        Intent getIntent();
    }

    static final class f extends JobServiceEngine implements b {

        /* renamed from: a  reason: collision with root package name */
        final i f4442a;

        /* renamed from: b  reason: collision with root package name */
        final Object f4443b = new Object();

        /* renamed from: c  reason: collision with root package name */
        JobParameters f4444c;

        final class a implements e {

            /* renamed from: a  reason: collision with root package name */
            final JobWorkItem f4445a;

            a(JobWorkItem jobWorkItem) {
                this.f4445a = jobWorkItem;
            }

            public void complete() {
                synchronized (f.this.f4443b) {
                    JobParameters jobParameters = f.this.f4444c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f4445a);
                    }
                }
            }

            public Intent getIntent() {
                return this.f4445a.getIntent();
            }
        }

        f(i iVar) {
            super(iVar);
            this.f4442a = iVar;
        }

        public IBinder a() {
            return getBinder();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            r1.getIntent().setExtrasClassLoader(r3.f4442a.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
            return new androidx.core.app.i.f.a(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
            if (r1 == null) goto L_0x0024;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.core.app.i.e b() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.f4443b
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r3.f4444c     // Catch:{ all -> 0x0025 }
                r2 = 0
                if (r1 != 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return r2
            L_0x000a:
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ all -> 0x0025 }
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                if (r1 == 0) goto L_0x0024
                android.content.Intent r0 = r1.getIntent()
                androidx.core.app.i r2 = r3.f4442a
                java.lang.ClassLoader r2 = r2.getClassLoader()
                r0.setExtrasClassLoader(r2)
                androidx.core.app.i$f$a r0 = new androidx.core.app.i$f$a
                r0.<init>(r1)
                return r0
            L_0x0024:
                return r2
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.i.f.b():androidx.core.app.i$e");
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f4444c = jobParameters;
            this.f4442a.ensureProcessorRunningLocked(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean doStopCurrentWork = this.f4442a.doStopCurrentWork();
            synchronized (this.f4443b) {
                this.f4444c = null;
            }
            return doStopCurrentWork;
        }
    }

    static final class g extends h {

        /* renamed from: d  reason: collision with root package name */
        private final JobInfo f4447d;

        /* renamed from: e  reason: collision with root package name */
        private final JobScheduler f4448e;

        g(Context context, ComponentName componentName, int i10) {
            super(componentName);
            b(i10);
            this.f4447d = new JobInfo.Builder(i10, this.f4449a).setOverrideDeadline(0).build();
            this.f4448e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* access modifiers changed from: package-private */
        public void a(Intent intent) {
            int unused = this.f4448e.enqueue(this.f4447d, new JobWorkItem(intent));
        }
    }

    static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f4449a;

        /* renamed from: b  reason: collision with root package name */
        boolean f4450b;

        /* renamed from: c  reason: collision with root package name */
        int f4451c;

        h(ComponentName componentName) {
            this.f4449a = componentName;
        }

        /* access modifiers changed from: package-private */
        public abstract void a(Intent intent);

        /* access modifiers changed from: package-private */
        public void b(int i10) {
            if (!this.f4450b) {
                this.f4450b = true;
                this.f4451c = i10;
            } else if (this.f4451c != i10) {
                throw new IllegalArgumentException("Given job ID " + i10 + " is different than previous " + this.f4451c);
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public i() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mCompatQueue = null;
        } else {
            this.mCompatQueue = new ArrayList<>();
        }
    }

    public static void enqueueWork(@NonNull Context context, @NonNull Class<?> cls, int i10, @NonNull Intent intent) {
        enqueueWork(context, new ComponentName(context, cls), i10, intent);
    }

    static h getWorkEnqueuer(Context context, ComponentName componentName, boolean z10, int i10) {
        h hVar;
        HashMap<ComponentName, h> hashMap = sClassWorkEnqueuer;
        h hVar2 = hashMap.get(componentName);
        if (hVar2 != null) {
            return hVar2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            hVar = new c(context, componentName);
        } else if (z10) {
            hVar = new g(context, componentName, i10);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        h hVar3 = hVar;
        hashMap.put(componentName, hVar3);
        return hVar3;
    }

    /* access modifiers changed from: package-private */
    public e dequeueWork() {
        b bVar = this.mJobImpl;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.mCompatQueue) {
            if (this.mCompatQueue.size() <= 0) {
                return null;
            }
            e remove = this.mCompatQueue.remove(0);
            return remove;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean doStopCurrentWork() {
        a aVar = this.mCurProcessor;
        if (aVar != null) {
            aVar.cancel(this.mInterruptIfStopped);
        }
        this.mStopped = true;
        return onStopCurrentWork();
    }

    /* access modifiers changed from: package-private */
    public void ensureProcessorRunningLocked(boolean z10) {
        if (this.mCurProcessor == null) {
            this.mCurProcessor = new a();
            h hVar = this.mCompatWorkEnqueuer;
            if (hVar != null && z10) {
                hVar.d();
            }
            this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    public IBinder onBind(@NonNull Intent intent) {
        b bVar = this.mJobImpl;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.mJobImpl = new f(this);
            this.mCompatWorkEnqueuer = null;
            return;
        }
        this.mJobImpl = null;
        this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.mCompatQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mDestroyed = true;
                this.mCompatWorkEnqueuer.c();
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onHandleWork(@NonNull Intent intent);

    public int onStartCommand(Intent intent, int i10, int i11) {
        if (this.mCompatQueue == null) {
            return 2;
        }
        this.mCompatWorkEnqueuer.e();
        synchronized (this.mCompatQueue) {
            ArrayList<d> arrayList = this.mCompatQueue;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i11));
            ensureProcessorRunningLocked(true);
        }
        return 3;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void processorFinished() {
        ArrayList<d> arrayList = this.mCompatQueue;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.mCurProcessor = null;
                ArrayList<d> arrayList2 = this.mCompatQueue;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    ensureProcessorRunningLocked(false);
                } else if (!this.mDestroyed) {
                    this.mCompatWorkEnqueuer.c();
                }
            }
        }
    }

    public void setInterruptIfStopped(boolean z10) {
        this.mInterruptIfStopped = z10;
    }

    public static void enqueueWork(@NonNull Context context, @NonNull ComponentName componentName, int i10, @NonNull Intent intent) {
        if (intent != null) {
            synchronized (sLock) {
                h workEnqueuer = getWorkEnqueuer(context, componentName, true, i10);
                workEnqueuer.b(i10);
                workEnqueuer.a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }
}
