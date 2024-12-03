package com.mparticle.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import com.mparticle.AttributionResult;
import com.mparticle.BaseEvent;
import com.mparticle.MPEvent;
import com.mparticle.MParticle;
import com.mparticle.MParticleOptions;
import com.mparticle.consent.ConsentState;
import com.mparticle.identity.IdentityApiRequest;
import com.mparticle.identity.MParticleUser;
import com.mparticle.internal.CoreCallbacks;
import com.mparticle.internal.KitManager;
import com.mparticle.internal.listeners.InternalListenerManager;
import com.mparticle.kits.KitManagerImpl;
import com.mparticle.n;
import com.mparticle.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class d implements KitManager {

    /* renamed from: j  reason: collision with root package name */
    private static volatile boolean f22440j = false;

    /* renamed from: k  reason: collision with root package name */
    private static final List<p> f22441k = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    private final Context f22442a;

    /* renamed from: b  reason: collision with root package name */
    final CoreCallbacks f22443b;

    /* renamed from: c  reason: collision with root package name */
    private final ReportingManager f22444c;

    /* renamed from: d  reason: collision with root package name */
    KitManager f22445d;

    /* renamed from: e  reason: collision with root package name */
    private final MParticleOptions f22446e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f22447f;

    /* renamed from: g  reason: collision with root package name */
    private Queue f22448g;

    /* renamed from: h  reason: collision with root package name */
    private Queue<a> f22449h;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f22450i;

    static class b implements CoreCallbacks {

        /* renamed from: a  reason: collision with root package name */
        d f22456a;

        /* renamed from: b  reason: collision with root package name */
        b f22457b;

        /* renamed from: c  reason: collision with root package name */
        a f22458c;

        /* renamed from: d  reason: collision with root package name */
        private CoreCallbacks.KitListener f22459d = new a();

        class a implements CoreCallbacks.KitListener {
            a() {
            }

            public void kitConfigReceived(int i10, String str) {
                InternalListenerManager.getListener().onKitConfigReceived(i10, str);
            }

            public void kitExcluded(int i10, String str) {
                InternalListenerManager.getListener().onKitExcluded(i10, str);
            }

            public void kitFound(int i10) {
                InternalListenerManager.getListener().onKitDetected(i10);
            }

            public void kitStarted(int i10) {
                InternalListenerManager.getListener().onKitStarted(i10);
            }

            public void onKitApiCalled(int i10, Boolean bool, Object... objArr) {
                InternalListenerManager.getListener().onKitApiCalled(i10, bool, objArr);
            }

            public void onKitApiCalled(String str, int i10, Boolean bool, Object... objArr) {
                InternalListenerManager.getListener().onKitApiCalled(str, i10, bool, objArr);
            }
        }

        public b(d dVar, b bVar, a aVar) {
            this.f22456a = dVar;
            this.f22457b = bVar;
            this.f22458c = aVar;
        }

        public WeakReference<Activity> getCurrentActivity() {
            return this.f22458c.f();
        }

        public MParticleOptions.DataplanOptions getDataplanOptions() {
            return this.f22457b.r();
        }

        public Map<String, String> getIntegrationAttributes(int i10) {
            return this.f22457b.a(i10);
        }

        public CoreCallbacks.KitListener getKitListener() {
            return this.f22459d;
        }

        public org.json.a getLatestKitConfiguration() {
            return this.f22457b.C();
        }

        public String getLaunchAction() {
            return this.f22458c.h();
        }

        public Uri getLaunchUri() {
            return this.f22458c.i();
        }

        public String getPushInstanceId() {
            return this.f22457b.K();
        }

        public String getPushSenderId() {
            return this.f22457b.N();
        }

        public int getUserBucket() {
            return this.f22457b.S();
        }

        public boolean isBackgrounded() {
            return this.f22458c.l();
        }

        public boolean isEnabled() {
            return this.f22457b.V();
        }

        public boolean isPushEnabled() {
            return this.f22457b.W();
        }

        public void setIntegrationAttributes(int i10, Map<String, String> map) {
            this.f22457b.a(i10, map);
        }
    }

    public d(Context context, ReportingManager reportingManager, b bVar, a aVar, MParticleOptions mParticleOptions) {
        this(context, reportingManager, bVar, aVar, false, mParticleOptions);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(KitManager kitManager) {
        this.f22445d = kitManager;
        a(true);
        updateDataplan(this.f22443b.getDataplanOptions());
    }

    public boolean b() {
        return f22440j;
    }

    public void c() {
        if (!this.f22447f) {
            Logger.debug("Loading Kit Framework.");
            this.f22447f = true;
            Class<KitManagerImpl> cls = KitManagerImpl.class;
            try {
                int i10 = KitManagerImpl.f22595a;
                KitManager newInstance = cls.getConstructor(new Class[]{Context.class, ReportingManager.class, CoreCallbacks.class, MParticleOptions.class}).newInstance(new Object[]{this.f22442a, this.f22444c, this.f22443b, this.f22446e});
                org.json.a latestKitConfiguration = this.f22443b.getLatestKitConfiguration();
                Logger.debug("Kit Framework loaded.");
                this.f22445d = newInstance;
                if (!MPUtility.isEmpty(latestKitConfiguration)) {
                    Logger.debug("Restoring previous Kit configuration.");
                    newInstance.updateKits(latestKitConfiguration).onKitsLoaded(new r(this, newInstance));
                    return;
                }
                updateDataplan(this.f22443b.getDataplanOptions());
            } catch (Exception unused) {
                Logger.debug("No Kit Framework detected.");
                a(true);
            }
        }
    }

    public synchronized void d() {
        e();
        a();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onSessionStart();
            if (this.f22450i) {
                String pushInstanceId = this.f22443b.getPushInstanceId();
                String pushSenderId = this.f22443b.getPushSenderId();
                if (!MPUtility.isEmpty((CharSequence) pushInstanceId)) {
                    this.f22445d.onPushRegistration(pushInstanceId, pushSenderId);
                }
            }
            Queue queue = this.f22448g;
            if (queue != null && queue.size() > 0) {
                Logger.debug("Replaying events after receiving first kit configuration.");
                for (Object next : this.f22448g) {
                    if (next instanceof MPEvent) {
                        MPEvent mPEvent = (MPEvent) next;
                        if (mPEvent.isScreenEvent()) {
                            this.f22445d.logScreen(mPEvent);
                        } else {
                            this.f22445d.logEvent(mPEvent);
                        }
                    } else if (next instanceof BaseEvent) {
                        this.f22445d.logEvent((BaseEvent) next);
                    }
                }
            }
            Queue<a> queue2 = this.f22449h;
            if (queue2 != null && queue2.size() > 0) {
                Logger.debug("Replaying user attributes after receiving first kit configuration.");
                for (a next2 : this.f22449h) {
                    int i10 = next2.f22454d;
                    if (i10 == 1) {
                        this.f22445d.removeUserAttribute(next2.f22451a, next2.f22453c);
                    } else if (i10 == 2) {
                        Object obj = next2.f22452b;
                        if (obj == null) {
                            this.f22445d.setUserAttribute(next2.f22451a, (String) null, next2.f22453c);
                        } else if (obj instanceof String) {
                            this.f22445d.setUserAttribute(next2.f22451a, (String) obj, next2.f22453c);
                        } else if (obj instanceof List) {
                            this.f22445d.setUserAttributeList(next2.f22451a, (List) obj, next2.f22453c);
                        }
                    } else if (i10 == 3) {
                        Object obj2 = next2.f22452b;
                        if (obj2 instanceof String) {
                            this.f22445d.incrementUserAttribute(next2.f22451a, next2.f22455e, (String) obj2, next2.f22453c);
                        }
                    } else if (i10 == 4) {
                        this.f22445d.setUserTag(next2.f22451a, next2.f22453c);
                    }
                }
            }
        }
    }

    public Map<Integer, AttributionResult> getAttributionResults() {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            return kitManager.getAttributionResults();
        }
        return new TreeMap();
    }

    public WeakReference<Activity> getCurrentActivity() {
        return this.f22443b.getCurrentActivity();
    }

    public Object getKitInstance(int i10) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            return kitManager.getKitInstance(i10);
        }
        return null;
    }

    public Map<Integer, KitManager.KitStatus> getKitStatus() {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            return kitManager.getKitStatus();
        }
        return new HashMap();
    }

    public Set<Integer> getSupportedKits() {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            return kitManager.getSupportedKits();
        }
        return null;
    }

    public Uri getSurveyUrl(int i10, Map<String, String> map, Map<String, List<String>> map2) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            return kitManager.getSurveyUrl(i10, map, map2);
        }
        return null;
    }

    public void incrementUserAttribute(String str, Number number, String str2, long j10) {
        KitManager kitManager;
        if (!a(str, number, str2, j10) && (kitManager = this.f22445d) != null) {
            kitManager.incrementUserAttribute(str, number, str2, j10);
        }
    }

    public void installReferrerUpdated() {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.installReferrerUpdated();
        }
    }

    public boolean isKitActive(int i10) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            return kitManager.isKitActive(i10);
        }
        return false;
    }

    public void leaveBreadcrumb(String str) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.leaveBreadcrumb(str);
        }
    }

    public void logBatch(String str) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.logBatch(str);
        }
    }

    public void logError(String str, Map<String, String> map) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.logError(str, map);
        }
    }

    public void logEvent(BaseEvent baseEvent) {
        KitManager kitManager;
        if (!a((Object) baseEvent) && (kitManager = this.f22445d) != null) {
            kitManager.logEvent(baseEvent);
        }
    }

    public void logException(Exception exc, Map<String, String> map, String str) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.logException(exc, map, str);
        }
    }

    public void logNetworkPerformance(String str, long j10, String str2, long j11, long j12, long j13, String str3, int i10) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.logNetworkPerformance(str, j10, str2, j11, j12, j13, str3, i10);
        }
    }

    public void logScreen(MPEvent mPEvent) {
        KitManager kitManager;
        if (!a((Object) mPEvent) && (kitManager = this.f22445d) != null) {
            kitManager.logScreen(mPEvent);
        }
    }

    public void logout() {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.logout();
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onActivityCreated(activity, bundle);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onActivityDestroyed(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onActivityPaused(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onActivityResumed(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onActivitySaveInstanceState(activity, bundle);
        }
    }

    public void onActivityStarted(Activity activity) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onActivityStarted(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onActivityStopped(activity);
        }
    }

    public void onApplicationBackground() {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onApplicationBackground();
        }
    }

    public void onApplicationForeground() {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onApplicationForeground();
        }
    }

    public void onConsentStateUpdated(ConsentState consentState, ConsentState consentState2, long j10) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onConsentStateUpdated(consentState, consentState2, j10);
        }
    }

    public void onIdentifyCompleted(MParticleUser mParticleUser, IdentityApiRequest identityApiRequest) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onIdentifyCompleted(mParticleUser, identityApiRequest);
        }
    }

    public void onLoginCompleted(MParticleUser mParticleUser, IdentityApiRequest identityApiRequest) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onLoginCompleted(mParticleUser, identityApiRequest);
        }
    }

    public void onLogoutCompleted(MParticleUser mParticleUser, IdentityApiRequest identityApiRequest) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onLogoutCompleted(mParticleUser, identityApiRequest);
        }
    }

    public boolean onMessageReceived(Context context, Intent intent) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            return kitManager.onMessageReceived(context, intent);
        }
        return false;
    }

    public void onModifyCompleted(MParticleUser mParticleUser, IdentityApiRequest identityApiRequest) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onModifyCompleted(mParticleUser, identityApiRequest);
        }
    }

    public boolean onPushRegistration(String str, String str2) {
        KitManager kitManager;
        if (!b() || (kitManager = this.f22445d) == null) {
            this.f22450i = true;
            return false;
        }
        kitManager.onPushRegistration(str, str2);
        return false;
    }

    public void onSessionEnd() {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onSessionEnd();
        }
    }

    public void onSessionStart() {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.onSessionStart();
        }
    }

    public void removeUserAttribute(String str, long j10) {
        KitManager kitManager;
        if (!a(str, j10) && (kitManager = this.f22445d) != null) {
            kitManager.removeUserAttribute(str, j10);
        }
    }

    public void removeUserIdentity(MParticle.IdentityType identityType) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.removeUserIdentity(identityType);
        }
    }

    public void reset() {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.reset();
        }
    }

    public void setLocation(Location location) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.setLocation(location);
        }
    }

    public void setOptOut(boolean z10) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.setOptOut(z10);
        }
    }

    public void setUserAttribute(String str, String str2, long j10) {
        KitManager kitManager;
        if (!a(str, str2, j10) && (kitManager = this.f22445d) != null) {
            kitManager.setUserAttribute(str, str2, j10);
        }
    }

    public void setUserAttributeList(String str, List<String> list, long j10) {
        KitManager kitManager;
        if (!a(str, list, j10) && (kitManager = this.f22445d) != null) {
            kitManager.setUserAttributeList(str, list, j10);
        }
    }

    public void setUserIdentity(String str, MParticle.IdentityType identityType) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.setUserIdentity(str, identityType);
        }
    }

    public void setUserTag(String str, long j10) {
        KitManager kitManager;
        if (!b(str, j10) && (kitManager = this.f22445d) != null) {
            kitManager.setUserTag(str, j10);
        }
    }

    public void updateDataplan(MParticleOptions.DataplanOptions dataplanOptions) {
        KitManager kitManager = this.f22445d;
        if (kitManager != null) {
            kitManager.updateDataplan(dataplanOptions);
        }
    }

    public KitsLoadedCallback updateKits(org.json.a aVar) {
        KitsLoadedCallback kitsLoadedCallback = new KitsLoadedCallback();
        if (this.f22445d != null) {
            if (f22440j) {
                return this.f22445d.updateKits(aVar);
            }
            this.f22445d.updateKits(aVar).onKitsLoaded(new s(this, kitsLoadedCallback));
        }
        return kitsLoadedCallback;
    }

    public d(Context context, ReportingManager reportingManager, b bVar, a aVar, boolean z10, MParticleOptions mParticleOptions) {
        this.f22447f = false;
        this.f22450i = false;
        this.f22446e = mParticleOptions;
        this.f22442a = !z10 ? new n(context) : context;
        this.f22444c = reportingManager;
        this.f22443b = new b(this, bVar, aVar);
        f22440j = false;
    }

    /* access modifiers changed from: package-private */
    public boolean b(String str, long j10) {
        return a(new a(str, j10, 4));
    }

    public void a(p pVar) {
        if (pVar == null) {
            return;
        }
        if (f22440j) {
            pVar.a();
        } else {
            f22441k.add(pVar);
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final String f22451a;

        /* renamed from: b  reason: collision with root package name */
        final Object f22452b;

        /* renamed from: c  reason: collision with root package name */
        final long f22453c;

        /* renamed from: d  reason: collision with root package name */
        final int f22454d;

        /* renamed from: e  reason: collision with root package name */
        Number f22455e;

        a(String str, long j10) {
            this.f22451a = str;
            this.f22452b = null;
            this.f22453c = j10;
            this.f22454d = 1;
        }

        a(String str, Object obj, long j10, int i10) {
            this.f22451a = str;
            this.f22452b = obj;
            this.f22453c = j10;
            this.f22454d = i10;
        }

        a(String str, long j10, int i10) {
            this.f22451a = str;
            this.f22452b = null;
            this.f22453c = j10;
            this.f22454d = i10;
        }

        a(String str, Number number, String str2, long j10) {
            this.f22451a = str;
            this.f22452b = str2;
            this.f22455e = number;
            this.f22453c = j10;
            this.f22454d = 3;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z10) {
        f22440j = z10;
        if (z10) {
            d();
        } else {
            a();
        }
        for (p pVar : new ArrayList(f22441k)) {
            if (pVar != null) {
                pVar.a();
            }
        }
        f22441k.clear();
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        Queue queue = this.f22448g;
        if (queue != null) {
            queue.clear();
            this.f22448g = null;
            Logger.debug("Kit initialization complete. Disabling event queueing.");
        }
        Queue<a> queue2 = this.f22449h;
        if (queue2 != null) {
            queue2.clear();
            this.f22449h = null;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean a(Object obj) {
        if (b()) {
            return false;
        }
        if (this.f22448g == null) {
            this.f22448g = new ConcurrentLinkedQueue();
        }
        if (this.f22448g.size() < 10) {
            Logger.debug("Queuing Kit event while waiting for initial configuration.");
            this.f22448g.add(obj);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, long j10) {
        return a(new a(str, j10));
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, Object obj, long j10) {
        return a(new a(str, obj, j10, 2));
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, Number number, String str2, long j10) {
        return a(new a(str, number, str2, j10));
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean a(a aVar) {
        if (b()) {
            return false;
        }
        if (this.f22449h == null) {
            this.f22449h = new ConcurrentLinkedQueue();
        }
        this.f22449h.add(aVar);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(KitsLoadedCallback kitsLoadedCallback) {
        a(true);
        kitsLoadedCallback.setKitsLoaded();
    }
}
