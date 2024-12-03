package com.coffeemeetsbagel.feature.mongoose.sync;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.bakery.g1;
import com.coffeemeetsbagel.feature.mongoose.enums.RosterGroup;
import com.coffeemeetsbagel.models.RosterElement;
import com.coffeemeetsbagel.models.SavedMessage;
import com.coffeemeetsbagel.models.util.ComparisonUtils;
import com.coffeemeetsbagel.services.JobServiceTypes$Types;
import hb.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import l8.h;
import l8.o2;
import n8.s;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.jxmpp.jid.Jid;
import org.jxmpp.stringprep.XmppStringprepException;
import p8.a;
import p8.b;
import p8.d;
import p8.e;
import p8.f;
import p8.g;
import p8.i;
import p8.j;
import p8.k;
import p8.l;
import p8.m;
import p8.n;
import p8.o;
import p8.p;
import qj.b0;
import qj.q;

public class MongooseSyncJobService extends JobService {

    /* renamed from: m  reason: collision with root package name */
    private static final String f13098m = MongooseSyncJobService.class.getSimpleName();

    /* renamed from: n  reason: collision with root package name */
    private static final Queue<a> f13099n = new LinkedList();

    /* renamed from: p  reason: collision with root package name */
    private static Collection<Jid> f13100p = Collections.emptyList();

    /* renamed from: a  reason: collision with root package name */
    private long f13101a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f13102b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13103c = false;

    /* renamed from: d  reason: collision with root package name */
    private tj.a f13104d;

    /* renamed from: e  reason: collision with root package name */
    c f13105e;

    /* renamed from: f  reason: collision with root package name */
    o2 f13106f;

    /* renamed from: g  reason: collision with root package name */
    s f13107g;

    /* renamed from: h  reason: collision with root package name */
    a7.a f13108h;

    /* renamed from: j  reason: collision with root package name */
    h f13109j;

    /* renamed from: k  reason: collision with root package name */
    i5.a f13110k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13111l = false;

    private void A(JobParameters jobParameters, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("processJobFinished: total time=");
        sb2.append(this.f13102b - this.f13101a);
        sb2.append("ms");
        Queue<a> queue = f13099n;
        if (queue.size() > 0) {
            C(queue.poll());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\tisAppBackgrounded: ");
        sb3.append(this.f13111l);
        jobFinished(jobParameters, z10);
    }

    /* access modifiers changed from: private */
    public boolean B(RosterElement rosterElement) {
        if (RosterGroup.ACTIVE.a().equals(rosterElement.getGroupName()) || this.f13109j.v(rosterElement.getJid()) == 0) {
            return true;
        }
        return false;
    }

    private static void C(a aVar) {
        if (aVar != null) {
            D(Bakery.w().getApplicationContext(), aVar.a());
        }
    }

    public static void D(Context context, Collection<Jid> collection) {
        E(context, collection, false);
    }

    public static void E(Context context, Collection<Jid> collection, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("scheduleSyncForJids: ");
        sb2.append(collection.size());
        sb2.append(" fromPush=");
        sb2.append(z10);
        PersistableBundle m10 = m(collection);
        m10.putBoolean("MONGOOSE_SYNC_FROM_PUSH", z10);
        if (r(f13100p, collection)) {
            Bakery.w().z().d("Chat Roster Sync Job Ongoing");
        } else if (!q(context, m10)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Scheduling job for ");
            sb3.append(collection.size());
            sb3.append(" addresses");
            ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(JobServiceTypes$Types.MONGOOSE_SYNC_JOB.a(), new ComponentName(context, MongooseSyncJobService.class)).setExtras(m10).setRequiredNetworkType(1).build());
        }
    }

    private void F() {
        this.f13104d.a(this.f13110k.a().c(new e(this)));
    }

    /* access modifiers changed from: private */
    public int G(RosterElement rosterElement, RosterElement rosterElement2) {
        return ComparisonUtils.compareWithNullCheck(RosterGroup.b(rosterElement.getGroupName()), RosterGroup.b(rosterElement2.getGroupName()));
    }

    /* access modifiers changed from: private */
    public Collection<Jid> H(Collection<Jid> collection) {
        g1.c("chat_load_roster");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startRosterLoad: ");
        sb2.append(collection.size());
        sb2.append(" jids from bundle");
        return collection;
    }

    private void l() {
        this.f13104d.dispose();
        f13100p = Collections.emptyList();
        this.f13101a = 0;
        this.f13102b = 0;
    }

    private static PersistableBundle m(Collection<Jid> collection) {
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putStringArray("MONGOOSE_JID_STRING_ARRAY_KEY", (String[]) q.O(collection).W(new d()).w0().j().toArray(new String[0]));
        return persistableBundle;
    }

    private Collection<Jid> n(PersistableBundle persistableBundle) {
        ArrayList arrayList = new ArrayList();
        String[] stringArray = persistableBundle.getStringArray("MONGOOSE_JID_STRING_ARRAY_KEY");
        if (stringArray != null) {
            for (String o10 : stringArray) {
                try {
                    arrayList.add(org.jxmpp.jid.impl.a.o(o10));
                } catch (XmppStringprepException e10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getJidsFromBundle: Exception-");
                    sb2.append(e10);
                }
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    private int o(List<RosterElement> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        return Math.min(list.size() / 100, 15);
    }

    /* access modifiers changed from: private */
    public void p(Throwable th2) {
        fa.a.g(f13098m, th2.toString(), th2);
        g1.a("chat_load_roster", "is_successful", "unsuccessful");
        g1.d("chat_load_roster");
        g1.a("chat_load_item_metadata", "is_successful", "unsuccessful");
        g1.d("chat_load_item_metadata");
    }

    private static boolean q(Context context, PersistableBundle persistableBundle) {
        JobInfo jobInfo;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobInfo = jobScheduler.getPendingJob(JobServiceTypes$Types.MONGOOSE_SYNC_JOB.a());
        } else {
            jobInfo = null;
        }
        if (jobInfo == null || jobInfo.getExtras() == null) {
            return false;
        }
        return Arrays.equals(jobInfo.getExtras().getStringArray("MONGOOSE_JID_STRING_ARRAY_KEY"), persistableBundle.getStringArray("MONGOOSE_JID_STRING_ARRAY_KEY"));
    }

    private static boolean r(Collection<Jid> collection, Collection<Jid> collection2) {
        if (collection2 == null || collection == null || collection.size() != collection2.size() || !collection.containsAll(collection2) || !collection2.containsAll(collection)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Iterable s(Collection collection) throws Exception {
        return collection;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ b0 t(Jid jid) throws Exception {
        return this.f13109j.o(jid);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(List list) throws Exception {
        g1.a("chat_load_roster", "is_successful", "successful");
        g1.a("chat_load_roster", "roster_bucket", Integer.toString(o(list)));
        g1.d("chat_load_roster");
        this.f13107g.B(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(JobParameters jobParameters, Throwable th2) throws Exception {
        String str = f13098m;
        fa.a.f(str, "onStartJob: doOnError(): " + th2);
        g1.a("chat_load_roster", "is_successful", "unsuccessful");
        g1.d("chat_load_roster");
        z(new ArrayList(), this.f13102b - this.f13101a, false);
        A(jobParameters, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List w(RosterElement rosterElement) throws Exception {
        return this.f13109j.s(rosterElement);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(JobParameters jobParameters, List list) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        this.f13102b = currentTimeMillis;
        z(list, currentTimeMillis - this.f13101a, true);
        A(jobParameters, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(Boolean bool) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Backgrounded: ");
        sb2.append(bool);
        this.f13111l = bool.booleanValue();
    }

    private void z(List<List<SavedMessage>> list, long j10, boolean z10) {
        int intValue = ((Integer) list.stream().map(new f()).reduce(new g()).orElse(0)).intValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("logSyncAnalytics: jids=");
        sb2.append(list.size());
        sb2.append(" messages=");
        sb2.append(intValue);
        sb2.append(" duration=");
        sb2.append(j10);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\tisFromPush: ");
        sb3.append(this.f13103c);
        HashMap hashMap = new HashMap();
        if (z10) {
            hashMap.put("Roster count", String.valueOf(list.size()));
            hashMap.put("Message count", String.valueOf(intValue));
            hashMap.put("Roster Sync Duration", String.valueOf(j10));
            hashMap.put(MamElements.MamResultExtension.ELEMENT, "succeeded");
        } else {
            hashMap.put(MamElements.MamResultExtension.ELEMENT, StreamManagement.Failed.ELEMENT);
        }
        if (this.f13103c) {
            this.f13108h.trackEvent("Chat Push Sync", hashMap);
        } else {
            this.f13108h.j("Mongoose Sync Completed", hashMap);
        }
    }

    public void onCreate() {
        super.onCreate();
        Bakery.j().y1(this);
        this.f13104d = new tj.a();
        F();
    }

    public void onDestroy() {
        super.onDestroy();
        l();
    }

    public boolean onStartJob(JobParameters jobParameters) {
        this.f13101a = System.currentTimeMillis();
        this.f13103c = jobParameters.getExtras().getBoolean("MONGOOSE_SYNC_FROM_PUSH", false);
        f13100p = n(jobParameters.getExtras());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\tisFromPush: ");
        sb2.append(this.f13103c);
        this.f13104d.a(q.V(f13100p).W(new b(this)).J(new i()).K(new j(this)).p(oc.i.b()).y0(new k(this)).O().C(new l(this)).A(new m(this, jobParameters)).M(new n()).J(new o(this)).Y(new p(this)).s0().K(dk.a.c()).I(new oc.e(1)).b(new p8.c(this, jobParameters), new p8.h(this)));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        this.f13108h.d("Chat Roster Sync Job Stopped");
        this.f13101a = 0;
        f13100p = Collections.emptyList();
        return false;
    }
}
