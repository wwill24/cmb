package com.mparticle.kits;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.mparticle.AttributionError;
import com.mparticle.AttributionListener;
import com.mparticle.AttributionResult;
import com.mparticle.BaseEvent;
import com.mparticle.Configuration;
import com.mparticle.MPEvent;
import com.mparticle.MParticle;
import com.mparticle.MParticleOptions;
import com.mparticle.UserAttributeListener;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.consent.ConsentState;
import com.mparticle.identity.IdentityApiRequest;
import com.mparticle.identity.IdentityStateListener;
import com.mparticle.identity.MParticleUser;
import com.mparticle.internal.CoreCallbacks;
import com.mparticle.internal.KitManager;
import com.mparticle.internal.KitsLoadedCallback;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.internal.ReportingManager;
import com.mparticle.kits.KitIntegration;
import com.mparticle.kits.ReportingMessage;
import com.mparticle.kits.mappings.CustomMapping;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class KitManagerImpl implements KitManager, AttributionListener, UserAttributeListener, IdentityStateListener {
    private static final String LOG_LTV = "LogLTVIncrease";
    private static final String METHOD_NAME = "$MethodName";
    private static final String RESERVED_KEY_LTV = "$Amount";

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f22595a = 0;
    private static HandlerThread kitHandlerThread;
    private volatile List<KitConfiguration> kitConfigurations = new ArrayList();
    private ArrayList<KitsLoadedListener> kitsLoadedListeners = new ArrayList<>();
    private Map<Integer, AttributionResult> mAttributionResultsMap = new TreeMap();
    private final Context mContext;
    protected final CoreCallbacks mCoreCallbacks;
    private DataplanFilter mDataplanFilter = DataplanFilterImpl.EMPTY;
    private Handler mKitHandler;
    KitIntegrationFactory mKitIntegrationFactory;
    private KitOptions mKitOptions;
    private final ReportingManager mReportingManager;
    ConcurrentHashMap<Integer, KitIntegration> providers = new ConcurrentHashMap<>();

    interface KitsLoadedListener {
        void onKitsLoaded(Map<Integer, KitIntegration> map, Map<Integer, KitIntegration> map2, List<KitConfiguration> list);
    }

    static {
        HandlerThread handlerThread = new HandlerThread("mParticle_kit_thread");
        kitHandlerThread = handlerThread;
        handlerThread.start();
    }

    public KitManagerImpl(Context context, ReportingManager reportingManager, CoreCallbacks coreCallbacks, MParticleOptions mParticleOptions) {
        this.mContext = context;
        this.mReportingManager = reportingManager;
        this.mCoreCallbacks = coreCallbacks;
        this.mKitIntegrationFactory = new KitIntegrationFactory(mParticleOptions);
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            instance.Identity().addIdentityStateListener(this);
        }
        if (mParticleOptions != null) {
            for (Configuration<?> apply : mParticleOptions.getConfigurationsForTarget(getClass())) {
                apply.apply(this);
            }
        }
        initializeKitIntegrationFactory();
    }

    private static Intent getMockInstallReferrerIntent(@NonNull String str) {
        if (MPUtility.isEmpty((CharSequence) str)) {
            return null;
        }
        Intent intent = new Intent("com.android.vending.INSTALL_REFERRER");
        intent.putExtra("referrer", str);
        return intent;
    }

    private ReportingManager getReportingManager() {
        return this.mReportingManager;
    }

    private void initializeKit(KitIntegration kitIntegration) {
        Intent mockInstallReferrerIntent;
        WeakReference<Activity> currentActivity;
        Activity activity;
        Logger.debug("Initializing kit: " + kitIntegration.getName());
        kitIntegration.onKitCreate(kitIntegration.getConfiguration().getSettings(), getContext());
        if (!(!(kitIntegration instanceof KitIntegration.ActivityListener) || (currentActivity = getCurrentActivity()) == null || (activity = currentActivity.get()) == null)) {
            KitIntegration.ActivityListener activityListener = (KitIntegration.ActivityListener) kitIntegration;
            getReportingManager().logAll(activityListener.onActivityCreated(activity, (Bundle) null));
            getReportingManager().logAll(activityListener.onActivityStarted(activity));
            getReportingManager().logAll(activityListener.onActivityResumed(activity));
        }
        if (kitIntegration instanceof KitIntegration.AttributeListener) {
            syncUserIdentities((KitIntegration.AttributeListener) kitIntegration, kitIntegration.getConfiguration());
        }
        MParticle instance = MParticle.getInstance();
        if (!(instance == null || (mockInstallReferrerIntent = getMockInstallReferrerIntent(instance.getInstallReferrer())) == null)) {
            kitIntegration.setInstallReferrer(mockInstallReferrerIntent);
        }
        if (kitIntegration instanceof KitIntegration.PushListener) {
            String pushSenderId = this.mCoreCallbacks.getPushSenderId();
            String pushInstanceId = this.mCoreCallbacks.getPushInstanceId();
            if (!MPUtility.isEmpty((CharSequence) pushInstanceId) && ((KitIntegration.PushListener) kitIntegration).onPushRegistration(pushInstanceId, pushSenderId)) {
                getReportingManager().log(ReportingMessage.fromPushRegistrationMessage(kitIntegration));
            }
        }
        getContext().sendBroadcast(new Intent(MParticle.ServiceProviders.BROADCAST_ACTIVE + kitIntegration.getConfiguration().getKitId()));
    }

    private void initializeKitIntegrationFactory() {
        if (this.mKitIntegrationFactory != null) {
            KitOptions kitOptions = this.mKitOptions;
            if (kitOptions != null) {
                for (Map.Entry next : kitOptions.getKits().entrySet()) {
                    Logger.info("Kit registered: " + ((Class) next.getValue()).getSimpleName() + "(" + next.getKey() + ")");
                    this.mKitIntegrationFactory.addSupportedKit(((Integer) next.getKey()).intValue(), (Class) next.getValue());
                }
            }
            Map<Integer, Class> map = this.mKitIntegrationFactory.supportedKits;
            if (map != null) {
                for (Integer next2 : map.keySet()) {
                    if (this.mCoreCallbacks.getKitListener() != null) {
                        this.mCoreCallbacks.getKitListener().kitFound(next2.intValue());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateKits$0(KitsLoadedCallback kitsLoadedCallback) {
        updateDataplan(this.mCoreCallbacks.getDataplanOptions());
        configureKits(this.kitConfigurations);
        kitsLoadedCallback.setKitsLoaded();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateKits$1(a aVar, KitsLoadedCallback kitsLoadedCallback) {
        this.kitConfigurations = parseKitConfigurations(aVar);
        runOnMainThread(new e(this, kitsLoadedCallback));
    }

    private void onKitsLoaded(Map<Integer, KitIntegration> map, Map<Integer, KitIntegration> map2, List<KitConfiguration> list) {
        Iterator<KitsLoadedListener> it = this.kitsLoadedListeners.iterator();
        while (it.hasNext()) {
            it.next().onKitsLoaded(map, map2, list);
        }
    }

    private List<KitConfiguration> parseKitConfigurations(a aVar) {
        ArrayList arrayList = new ArrayList();
        if (aVar == null) {
            aVar = new a();
        }
        for (int i10 = 0; i10 < aVar.o(); i10++) {
            b bVar = null;
            try {
                bVar = aVar.j(i10);
            } catch (JSONException e10) {
                Logger.error(e10, "Malformed Kit configuration");
            }
            if (bVar != null) {
                try {
                    arrayList.add(createKitConfiguration(bVar));
                } catch (JSONException e11) {
                    int optInt = bVar.optInt("id", -1);
                    this.mCoreCallbacks.getKitListener().kitExcluded(optInt, "exception while starting. Exception: " + e11.getMessage());
                    Logger.error("Exception while starting kit: " + optInt + ": " + e11.getMessage());
                }
            }
        }
        return arrayList;
    }

    private void syncUserIdentities(KitIntegration.AttributeListener attributeListener, KitConfiguration kitConfiguration) {
        MParticleUser currentUser;
        Map<MParticle.IdentityType, String> userIdentities;
        MParticle instance = MParticle.getInstance();
        if (instance != null && (currentUser = instance.Identity().getCurrentUser()) != null && (userIdentities = currentUser.getUserIdentities()) != null) {
            for (Map.Entry next : userIdentities.entrySet()) {
                if (kitConfiguration.shouldSetIdentity((MParticle.IdentityType) next.getKey())) {
                    attributeListener.setUserIdentity((MParticle.IdentityType) next.getKey(), (String) next.getValue());
                }
            }
        }
    }

    public void addKitsLoadedListener(KitsLoadedListener kitsLoadedListener) {
        this.kitsLoadedListeners.add(kitsLoadedListener);
    }

    /* access modifiers changed from: package-private */
    public void clearIntegrationAttributes(KitIntegration kitIntegration) {
        setIntegrationAttributes(kitIntegration, (Map<String, String>) null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0086 A[SYNTHETIC, Splitter:B:31:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bb A[Catch:{ Exception -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bd A[Catch:{ Exception -> 0x00fc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void configureKits(@androidx.annotation.NonNull java.util.List<com.mparticle.kits.KitConfiguration> r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            if (r13 != 0) goto L_0x0008
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x01c6 }
            r13.<init>()     // Catch:{ all -> 0x01c6 }
        L_0x0008:
            com.mparticle.MParticle r0 = com.mparticle.MParticle.getInstance()     // Catch:{ all -> 0x01c6 }
            if (r0 != 0) goto L_0x0010
            monitor-exit(r12)
            return
        L_0x0010:
            com.mparticle.identity.IdentityApi r0 = r0.Identity()     // Catch:{ all -> 0x01c6 }
            com.mparticle.identity.MParticleUser r0 = r0.getCurrentUser()     // Catch:{ all -> 0x01c6 }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x01c6 }
            r1.<init>()     // Catch:{ all -> 0x01c6 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x01c6 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.mparticle.kits.KitIntegration> r3 = r12.providers     // Catch:{ all -> 0x01c6 }
            r2.<init>(r3)     // Catch:{ all -> 0x01c6 }
            java.util.Iterator r3 = r13.iterator()     // Catch:{ all -> 0x01c6 }
        L_0x0028:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x01c6 }
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0149
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x01c6 }
            com.mparticle.kits.KitConfiguration r4 = (com.mparticle.kits.KitConfiguration) r4     // Catch:{ all -> 0x01c6 }
            int r7 = r4.getKitId()     // Catch:{ Exception -> 0x00fc }
            boolean r8 = r4.shouldExcludeUser(r0)     // Catch:{ Exception -> 0x00fc }
            if (r8 == 0) goto L_0x004c
            com.mparticle.internal.CoreCallbacks r8 = r12.mCoreCallbacks     // Catch:{ Exception -> 0x00fc }
            com.mparticle.internal.CoreCallbacks$KitListener r8 = r8.getKitListener()     // Catch:{ Exception -> 0x00fc }
            java.lang.String r9 = "User was required to be known, but was not."
            r8.kitExcluded(r7, r9)     // Catch:{ Exception -> 0x00fc }
            goto L_0x0028
        L_0x004c:
            com.mparticle.kits.KitIntegrationFactory r8 = r12.mKitIntegrationFactory     // Catch:{ Exception -> 0x00fc }
            int r9 = r4.getKitId()     // Catch:{ Exception -> 0x00fc }
            boolean r8 = r8.isSupported(r9)     // Catch:{ Exception -> 0x00fc }
            if (r8 != 0) goto L_0x0059
            goto L_0x0028
        L_0x0059:
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.mparticle.kits.KitIntegration> r8 = r12.providers     // Catch:{ Exception -> 0x00fc }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00fc }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ Exception -> 0x00fc }
            com.mparticle.kits.KitIntegration r8 = (com.mparticle.kits.KitIntegration) r8     // Catch:{ Exception -> 0x00fc }
            if (r8 != 0) goto L_0x00db
            java.util.Set r9 = r12.getSupportedKits()     // Catch:{ Exception -> 0x0083 }
            int r10 = r4.getKitId()     // Catch:{ Exception -> 0x0083 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x0083 }
            boolean r9 = r9.contains(r10)     // Catch:{ Exception -> 0x0083 }
            if (r9 == 0) goto L_0x0083
            com.mparticle.kits.KitIntegrationFactory r9 = r12.mKitIntegrationFactory     // Catch:{ Exception -> 0x0083 }
            com.mparticle.kits.KitIntegration r8 = r9.createInstance((com.mparticle.kits.KitManagerImpl) r12, (com.mparticle.kits.KitConfiguration) r4)     // Catch:{ Exception -> 0x0083 }
            if (r8 == 0) goto L_0x0083
            r9 = r5
            goto L_0x0084
        L_0x0083:
            r9 = r6
        L_0x0084:
            if (r9 != 0) goto L_0x00ad
            int r10 = r4.getKitId()     // Catch:{ Exception -> 0x00fc }
            r11 = 1000000(0xf4240, float:1.401298E-39)
            if (r10 < r11) goto L_0x00ad
            java.lang.String[] r7 = new java.lang.String[r5]     // Catch:{ Exception -> 0x00fc }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fc }
            r8.<init>()     // Catch:{ Exception -> 0x00fc }
            java.lang.String r9 = "De-initializing sideloaded kit with id: "
            r8.append(r9)     // Catch:{ Exception -> 0x00fc }
            int r9 = r4.getKitId()     // Catch:{ Exception -> 0x00fc }
            r8.append(r9)     // Catch:{ Exception -> 0x00fc }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00fc }
            r7[r6] = r8     // Catch:{ Exception -> 0x00fc }
            com.mparticle.internal.Logger.verbose(r7)     // Catch:{ Exception -> 0x00fc }
            goto L_0x0028
        L_0x00ad:
            if (r9 == 0) goto L_0x0028
            boolean r9 = r8.isDisabled()     // Catch:{ Exception -> 0x00fc }
            if (r9 != 0) goto L_0x0028
            boolean r9 = r4.shouldIncludeFromConsentRules(r0)     // Catch:{ Exception -> 0x00fc }
            if (r9 != 0) goto L_0x00bd
            goto L_0x0028
        L_0x00bd:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00fc }
            r1.add(r9)     // Catch:{ Exception -> 0x00fc }
            r12.initializeKit(r8)     // Catch:{ Exception -> 0x00fc }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.mparticle.kits.KitIntegration> r9 = r12.providers     // Catch:{ Exception -> 0x00fc }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00fc }
            r9.put(r10, r8)     // Catch:{ Exception -> 0x00fc }
            com.mparticle.internal.CoreCallbacks r8 = r12.mCoreCallbacks     // Catch:{ Exception -> 0x00fc }
            com.mparticle.internal.CoreCallbacks$KitListener r8 = r8.getKitListener()     // Catch:{ Exception -> 0x00fc }
            r8.kitStarted(r7)     // Catch:{ Exception -> 0x00fc }
            goto L_0x0028
        L_0x00db:
            r8.setConfiguration(r4)     // Catch:{ Exception -> 0x00fc }
            boolean r9 = r8.isDisabled()     // Catch:{ Exception -> 0x00fc }
            if (r9 != 0) goto L_0x0028
            boolean r9 = r4.shouldIncludeFromConsentRules(r0)     // Catch:{ Exception -> 0x00fc }
            if (r9 != 0) goto L_0x00ec
            goto L_0x0028
        L_0x00ec:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00fc }
            r1.add(r7)     // Catch:{ Exception -> 0x00fc }
            java.util.Map r7 = r4.getSettings()     // Catch:{ Exception -> 0x00fc }
            r8.onSettingsUpdated(r7)     // Catch:{ Exception -> 0x00fc }
            goto L_0x0028
        L_0x00fc:
            r7 = move-exception
            com.mparticle.internal.CoreCallbacks r8 = r12.mCoreCallbacks     // Catch:{ all -> 0x01c6 }
            com.mparticle.internal.CoreCallbacks$KitListener r8 = r8.getKitListener()     // Catch:{ all -> 0x01c6 }
            int r9 = r4.getKitId()     // Catch:{ all -> 0x01c6 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c6 }
            r10.<init>()     // Catch:{ all -> 0x01c6 }
            java.lang.String r11 = "exception while starting. Exception: "
            r10.append(r11)     // Catch:{ all -> 0x01c6 }
            java.lang.String r11 = r7.getMessage()     // Catch:{ all -> 0x01c6 }
            r10.append(r11)     // Catch:{ all -> 0x01c6 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x01c6 }
            r8.kitExcluded(r9, r10)     // Catch:{ all -> 0x01c6 }
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x01c6 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c6 }
            r8.<init>()     // Catch:{ all -> 0x01c6 }
            java.lang.String r9 = "Exception while starting kit "
            r8.append(r9)     // Catch:{ all -> 0x01c6 }
            int r4 = r4.getKitId()     // Catch:{ all -> 0x01c6 }
            r8.append(r4)     // Catch:{ all -> 0x01c6 }
            java.lang.String r4 = ": "
            r8.append(r4)     // Catch:{ all -> 0x01c6 }
            java.lang.String r4 = r7.getMessage()     // Catch:{ all -> 0x01c6 }
            r8.append(r4)     // Catch:{ all -> 0x01c6 }
            java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x01c6 }
            r5[r6] = r4     // Catch:{ all -> 0x01c6 }
            com.mparticle.internal.Logger.error(r5)     // Catch:{ all -> 0x01c6 }
            goto L_0x0028
        L_0x0149:
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.mparticle.kits.KitIntegration> r0 = r12.providers     // Catch:{ all -> 0x01c6 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x01c6 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x01c6 }
        L_0x0153:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x01c6 }
            if (r3 == 0) goto L_0x01b5
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x01c6 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x01c6 }
            boolean r4 = r1.contains(r3)     // Catch:{ all -> 0x01c6 }
            if (r4 != 0) goto L_0x0153
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.mparticle.kits.KitIntegration> r4 = r12.providers     // Catch:{ all -> 0x01c6 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x01c6 }
            com.mparticle.kits.KitIntegration r4 = (com.mparticle.kits.KitIntegration) r4     // Catch:{ all -> 0x01c6 }
            if (r4 == 0) goto L_0x0194
            java.lang.String[] r7 = new java.lang.String[r5]     // Catch:{ all -> 0x01c6 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c6 }
            r8.<init>()     // Catch:{ all -> 0x01c6 }
            java.lang.String r9 = "De-initializing kit: "
            r8.append(r9)     // Catch:{ all -> 0x01c6 }
            java.lang.String r9 = r4.getName()     // Catch:{ all -> 0x01c6 }
            r8.append(r9)     // Catch:{ all -> 0x01c6 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x01c6 }
            r7[r6] = r8     // Catch:{ all -> 0x01c6 }
            com.mparticle.internal.Logger.debug(r7)     // Catch:{ all -> 0x01c6 }
            r12.clearIntegrationAttributes(r4)     // Catch:{ all -> 0x01c6 }
            r4.onKitDestroy()     // Catch:{ all -> 0x01c6 }
            r4.onKitCleanup()     // Catch:{ all -> 0x01c6 }
        L_0x0194:
            r0.remove()     // Catch:{ all -> 0x01c6 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ all -> 0x01c6 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c6 }
            r7.<init>()     // Catch:{ all -> 0x01c6 }
            java.lang.String r8 = "MPARTICLE_SERVICE_PROVIDER_DISABLED_"
            r7.append(r8)     // Catch:{ all -> 0x01c6 }
            r7.append(r3)     // Catch:{ all -> 0x01c6 }
            java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x01c6 }
            r4.<init>(r3)     // Catch:{ all -> 0x01c6 }
            android.content.Context r3 = r12.getContext()     // Catch:{ all -> 0x01c6 }
            r3.sendBroadcast(r4)     // Catch:{ all -> 0x01c6 }
            goto L_0x0153
        L_0x01b5:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x01c6 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.mparticle.kits.KitIntegration> r1 = r12.providers     // Catch:{ all -> 0x01c6 }
            r0.<init>(r1)     // Catch:{ all -> 0x01c6 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x01c6 }
            r1.<init>(r13)     // Catch:{ all -> 0x01c6 }
            r12.onKitsLoaded(r0, r2, r1)     // Catch:{ all -> 0x01c6 }
            monitor-exit(r12)
            return
        L_0x01c6:
            r13 = move-exception
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.kits.KitManagerImpl.configureKits(java.util.List):void");
    }

    /* access modifiers changed from: protected */
    public KitConfiguration createKitConfiguration(b bVar) throws JSONException {
        return KitConfiguration.createKitConfiguration(bVar);
    }

    public Map<Integer, AttributionResult> getAttributionResults() {
        return this.mAttributionResultsMap;
    }

    public Context getContext() {
        return this.mContext;
    }

    public WeakReference<Activity> getCurrentActivity() {
        return this.mCoreCallbacks.getCurrentActivity();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public DataplanFilter getDataplanFilter() {
        DataplanFilter dataplanFilter = this.mDataplanFilter;
        if (dataplanFilter != null) {
            return dataplanFilter;
        }
        Logger.warning("DataplanFilter could not be found");
        return DataplanFilterImpl.EMPTY;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getIntegrationAttributes(KitIntegration kitIntegration) {
        return this.mCoreCallbacks.getIntegrationAttributes(kitIntegration.getConfiguration().getKitId());
    }

    public Object getKitInstance(int i10) {
        KitIntegration kitIntegration = this.providers.get(Integer.valueOf(i10));
        if (kitIntegration == null) {
            return null;
        }
        return kitIntegration.getInstance();
    }

    public Map<Integer, KitManager.KitStatus> getKitStatus() {
        HashMap hashMap = new HashMap();
        for (Integer put : this.mKitIntegrationFactory.getSupportedKits()) {
            hashMap.put(put, KitManager.KitStatus.NOT_CONFIGURED);
        }
        for (KitConfiguration kitId : this.kitConfigurations) {
            hashMap.put(Integer.valueOf(kitId.getKitId()), KitManager.KitStatus.STOPPED);
        }
        for (Map.Entry next : this.providers.entrySet()) {
            if (!((KitIntegration) next.getValue()).isDisabled()) {
                hashMap.put((Integer) next.getKey(), KitManager.KitStatus.ACTIVE);
            }
        }
        return hashMap;
    }

    public String getLaunchAction() {
        return this.mCoreCallbacks.getLaunchAction();
    }

    public Uri getLaunchUri() {
        return this.mCoreCallbacks.getLaunchUri();
    }

    public String getPushInstanceId() {
        return this.mCoreCallbacks.getPushInstanceId();
    }

    public String getPushSenderId() {
        return this.mCoreCallbacks.getPushSenderId();
    }

    public Set<Integer> getSupportedKits() {
        return this.mKitIntegrationFactory.getSupportedKits();
    }

    public Uri getSurveyUrl(int i10, Map<String, String> map, Map<String, List<String>> map2) {
        Map<String, T> transformUserAttributes = this.mDataplanFilter.transformUserAttributes(map);
        Map<String, T> transformUserAttributes2 = this.mDataplanFilter.transformUserAttributes(map2);
        KitIntegration kitIntegration = this.providers.get(Integer.valueOf(i10));
        if (kitIntegration == null) {
            return null;
        }
        kitIntegration.getConfiguration();
        Map<String, ?> filterAttributes = KitConfiguration.filterAttributes(kitIntegration.getConfiguration().getUserAttributeFilters(), transformUserAttributes);
        kitIntegration.getConfiguration();
        return kitIntegration.getSurveyUrl(filterAttributes, KitConfiguration.filterAttributes(kitIntegration.getConfiguration().getUserAttributeFilters(), transformUserAttributes2));
    }

    public int getUserBucket() {
        return this.mCoreCallbacks.getUserBucket();
    }

    public void incrementUserAttribute(String str, Number number, String str2, long j10) {
        if (!this.mDataplanFilter.isUserAttributeBlocked(str)) {
            for (KitIntegration next : this.providers.values()) {
                try {
                    if (!next.isDisabled() && KitConfiguration.shouldForwardAttribute(next.getConfiguration().getUserAttributeFilters(), str) && (next instanceof KitIntegration.UserAttributeListener)) {
                        ((KitIntegration.UserAttributeListener) next).onIncrementUserAttribute(str, number, str2, FilteredMParticleUser.getInstance(j10, next));
                    }
                    if (next instanceof KitIntegration.AttributeListener) {
                        ((KitIntegration.AttributeListener) next).setUserAttribute(str, str2);
                    }
                } catch (Exception e10) {
                    Logger.warning("Failed to call onIncrementUserAttribute for kit: " + next.getName() + ": " + e10.getMessage());
                }
            }
        }
    }

    public void installReferrerUpdated() {
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            Intent mockInstallReferrerIntent = getMockInstallReferrerIntent(instance.getInstallReferrer());
            for (KitIntegration next : this.providers.values()) {
                try {
                    if (!next.isDisabled()) {
                        next.setInstallReferrer(mockInstallReferrerIntent);
                    }
                } catch (Exception e10) {
                    Logger.warning("Failed to update Install Referrer for kit: " + next.getName() + ": " + e10.getMessage());
                }
            }
        }
    }

    public boolean isBackgrounded() {
        return this.mCoreCallbacks.isBackgrounded();
    }

    public boolean isKitActive(int i10) {
        KitIntegration kitIntegration = this.providers.get(Integer.valueOf(i10));
        if (kitIntegration == null || kitIntegration.isDisabled()) {
            return false;
        }
        return true;
    }

    public boolean isOptedOut() {
        return !this.mCoreCallbacks.isEnabled();
    }

    public boolean isPushEnabled() {
        return this.mCoreCallbacks.isPushEnabled();
    }

    public void leaveBreadcrumb(String str) {
        boolean z10;
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.EventListener) && !next.isDisabled()) {
                    List<ReportingMessage> leaveBreadcrumb = ((KitIntegration.EventListener) next).leaveBreadcrumb(str);
                    getReportingManager().logAll(leaveBreadcrumb);
                    CoreCallbacks.KitListener kitListener = this.mCoreCallbacks.getKitListener();
                    int kitId = next.getConfiguration().getKitId();
                    if (!MPUtility.isEmpty((Collection) leaveBreadcrumb)) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    kitListener.onKitApiCalled(kitId, Boolean.valueOf(z10), str);
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call leaveBreadcrumb for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void logBatch(String str) {
        for (KitIntegration next : this.providers.values()) {
            try {
                if (next instanceof KitIntegration.BatchListener) {
                    getReportingManager().logAll(((KitIntegration.BatchListener) next).logBatch(new b(str)));
                }
            } catch (JSONException e10) {
                Logger.error(e10, "Failed to call logBatch (unable to deserialize Batch) for kit" + next.getName() + ": " + e10.getMessage());
            } catch (Exception e11) {
                Logger.warning("Failed to call logBatch for kit: " + next.getName() + ": " + e11.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void logCommerceEvent(CommerceEvent commerceEvent) {
        Iterator<KitIntegration> it;
        boolean z10;
        boolean z11;
        boolean z12;
        List<ReportingMessage> list;
        String str;
        boolean z13;
        boolean z14;
        Iterator<KitIntegration> it2 = this.providers.values().iterator();
        while (it2.hasNext()) {
            KitIntegration next = it2.next();
            try {
                if (!next.isDisabled()) {
                    try {
                        CommerceEvent filterCommerceEvent = next.getConfiguration().filterCommerceEvent(commerceEvent);
                        if (filterCommerceEvent != null) {
                            if (next instanceof KitIntegration.CommerceListener) {
                                List<CustomMapping.ProjectionResult> projectEvents = CustomMapping.projectEvents(filterCommerceEvent, next.getConfiguration().getCustomMappingList(), next.getConfiguration().getDefaultCommerceCustomMapping());
                                if (projectEvents == null || projectEvents.size() <= 0) {
                                    it = it2;
                                    List<ReportingMessage> logEvent = ((KitIntegration.CommerceListener) next).logEvent(filterCommerceEvent);
                                    CoreCallbacks.KitListener kitListener = this.mCoreCallbacks.getKitListener();
                                    int kitId = next.getConfiguration().getKitId();
                                    if (!MPUtility.isEmpty((Collection) logEvent)) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    kitListener.onKitApiCalled("logMPEvent()", kitId, Boolean.valueOf(z12), filterCommerceEvent);
                                    if (logEvent != null && logEvent.size() > 0) {
                                        getReportingManager().log(ReportingMessage.fromEvent(next, filterCommerceEvent));
                                    }
                                } else {
                                    ReportingMessage fromEvent = ReportingMessage.fromEvent(next, filterCommerceEvent);
                                    int i10 = 0;
                                    boolean z15 = false;
                                    while (i10 < projectEvents.size()) {
                                        if (projectEvents.get(i10).getMPEvent() != null) {
                                            MPEvent mPEvent = projectEvents.get(i10).getMPEvent();
                                            list = ((KitIntegration.EventListener) next).logEvent(mPEvent);
                                            CoreCallbacks.KitListener kitListener2 = this.mCoreCallbacks.getKitListener();
                                            int kitId2 = next.getConfiguration().getKitId();
                                            if (!MPUtility.isEmpty((Collection) list)) {
                                                z14 = true;
                                            } else {
                                                z14 = false;
                                            }
                                            it = it2;
                                            try {
                                                kitListener2.onKitApiCalled("logMPEvent()", kitId2, Boolean.valueOf(z14), mPEvent);
                                                str = ReportingMessage.MessageType.EVENT;
                                            } catch (Exception e10) {
                                                e = e10;
                                                Logger.warning("Failed to call logCommerceEvent for kit: " + next.getName() + ": " + e.getMessage());
                                                it2 = it;
                                            }
                                        } else {
                                            it = it2;
                                            CommerceEvent commerceEvent2 = projectEvents.get(i10).getCommerceEvent();
                                            list = ((KitIntegration.CommerceListener) next).logEvent(commerceEvent2);
                                            CoreCallbacks.KitListener kitListener3 = this.mCoreCallbacks.getKitListener();
                                            int kitId3 = next.getConfiguration().getKitId();
                                            if (!MPUtility.isEmpty((Collection) list)) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            kitListener3.onKitApiCalled("logMPEvent()", kitId3, Boolean.valueOf(z13), commerceEvent2);
                                            str = ReportingMessage.MessageType.COMMERCE_EVENT;
                                        }
                                        if (list != null && list.size() > 0) {
                                            for (ReportingMessage next2 : list) {
                                                fromEvent.addProjectionReport(new ReportingMessage.ProjectionReport(projectEvents.get(i10).getProjectionId(), str, next2.getEventName(), next2.getEventTypeString()));
                                            }
                                            z15 = true;
                                        }
                                        i10++;
                                        it2 = it;
                                    }
                                    it = it2;
                                    if (z15) {
                                        getReportingManager().log(fromEvent);
                                    }
                                }
                            } else {
                                it = it2;
                                if (next instanceof KitIntegration.EventListener) {
                                    List<MPEvent> expand = CommerceEventUtils.expand(filterCommerceEvent);
                                    if (expand != null) {
                                        while (true) {
                                            z10 = false;
                                            for (MPEvent next3 : expand) {
                                                List<ReportingMessage> logEvent2 = ((KitIntegration.EventListener) next).logEvent(next3);
                                                CoreCallbacks.KitListener kitListener4 = this.mCoreCallbacks.getKitListener();
                                                int kitId4 = next.getConfiguration().getKitId();
                                                if (!MPUtility.isEmpty((Collection) logEvent2)) {
                                                    z11 = true;
                                                } else {
                                                    z11 = false;
                                                }
                                                kitListener4.onKitApiCalled("logMPEvent()", kitId4, Boolean.valueOf(z11), next3);
                                                if (z10 || (logEvent2 != null && logEvent2.size() > 0)) {
                                                    z10 = true;
                                                }
                                            }
                                            break;
                                        }
                                    } else {
                                        z10 = false;
                                    }
                                    if (z10) {
                                        getReportingManager().log(ReportingMessage.fromEvent(next, filterCommerceEvent));
                                    }
                                }
                            }
                            it2 = it;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        it = it2;
                        Logger.warning("Failed to call logCommerceEvent for kit: " + next.getName() + ": " + e.getMessage());
                        it2 = it;
                    }
                } else {
                    CommerceEvent commerceEvent3 = commerceEvent;
                }
                it = it2;
            } catch (Exception e12) {
                e = e12;
                CommerceEvent commerceEvent4 = commerceEvent;
                it = it2;
                Logger.warning("Failed to call logCommerceEvent for kit: " + next.getName() + ": " + e.getMessage());
                it2 = it;
            }
            it2 = it;
        }
    }

    public void logError(String str, Map<String, String> map) {
        boolean z10;
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.EventListener) && !next.isDisabled()) {
                    List<ReportingMessage> logError = ((KitIntegration.EventListener) next).logError(str, map);
                    getReportingManager().logAll(logError);
                    CoreCallbacks.KitListener kitListener = this.mCoreCallbacks.getKitListener();
                    int kitId = next.getConfiguration().getKitId();
                    if (!MPUtility.isEmpty((Collection) logError)) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    kitListener.onKitApiCalled(kitId, Boolean.valueOf(z10), str, map);
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call logError for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void logEvent(BaseEvent baseEvent) {
        boolean z10;
        DataplanFilter dataplanFilter = this.mDataplanFilter;
        if (dataplanFilter == null || (baseEvent = dataplanFilter.transformEventForEvent(baseEvent)) != null) {
            for (KitIntegration next : this.providers.values()) {
                try {
                    List<ReportingMessage> logBaseEvent = next.logBaseEvent(baseEvent);
                    CoreCallbacks.KitListener kitListener = this.mCoreCallbacks.getKitListener();
                    int kitId = next.getConfiguration().getKitId();
                    if (!MPUtility.isEmpty((Collection) logBaseEvent)) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    kitListener.onKitApiCalled(kitId, Boolean.valueOf(z10), baseEvent);
                    this.mReportingManager.logAll(logBaseEvent);
                } catch (Exception e10) {
                    Logger.warning("Failed to call logMPEvent for kit: " + next.getName() + ": " + e10.getMessage());
                    this.mCoreCallbacks.getKitListener().onKitApiCalled(next.getConfiguration().getKitId(), Boolean.FALSE, baseEvent, e10);
                }
            }
            if (baseEvent instanceof MPEvent) {
                logMPEvent((MPEvent) baseEvent);
            } else if (baseEvent instanceof CommerceEvent) {
                logCommerceEvent((CommerceEvent) baseEvent);
            }
        }
    }

    public void logException(Exception exc, Map<String, String> map, String str) {
        boolean z10;
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.EventListener) && !next.isDisabled()) {
                    List<ReportingMessage> logException = ((KitIntegration.EventListener) next).logException(exc, map, str);
                    getReportingManager().logAll(logException);
                    CoreCallbacks.KitListener kitListener = this.mCoreCallbacks.getKitListener();
                    int kitId = next.getConfiguration().getKitId();
                    if (!MPUtility.isEmpty((Collection) logException)) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    kitListener.onKitApiCalled(kitId, Boolean.valueOf(z10), exc, str, map);
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call logException for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void logMPEvent(MPEvent mPEvent) {
        boolean z10;
        List<ReportingMessage> list;
        boolean z11;
        KitManagerImpl kitManagerImpl = this;
        MPEvent mPEvent2 = mPEvent;
        if (mPEvent.isScreenEvent()) {
            logScreen(mPEvent);
            return;
        }
        for (KitIntegration next : kitManagerImpl.providers.values()) {
            try {
                if ((next instanceof KitIntegration.EventListener) && !next.isDisabled() && next.getConfiguration().shouldLogEvent(mPEvent2)) {
                    MPEvent mPEvent3 = new MPEvent(mPEvent2);
                    mPEvent3.setCustomAttributes(next.getConfiguration().filterEventAttributes(mPEvent3));
                    List<CustomMapping.ProjectionResult> projectEvents = CustomMapping.projectEvents(mPEvent3, next.getConfiguration().getCustomMappingList(), next.getConfiguration().getDefaultEventProjection());
                    LinkedList linkedList = new LinkedList();
                    if (projectEvents == null) {
                        if (mPEvent3.getCustomAttributeStrings() == null || !mPEvent3.getCustomAttributeStrings().containsKey(METHOD_NAME) || !mPEvent3.getCustomAttributeStrings().get(METHOD_NAME).equals(LOG_LTV)) {
                            List<ReportingMessage> logEvent = ((KitIntegration.EventListener) next).logEvent(mPEvent3);
                            CoreCallbacks.KitListener kitListener = kitManagerImpl.mCoreCallbacks.getKitListener();
                            int kitId = next.getConfiguration().getKitId();
                            if (!MPUtility.isEmpty((Collection) logEvent)) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            kitListener.onKitApiCalled(kitId, Boolean.valueOf(z11), mPEvent3);
                            list = logEvent;
                        } else {
                            list = ((KitIntegration.CommerceListener) next).logLtvIncrease(new BigDecimal(mPEvent3.getCustomAttributeStrings().get("$Amount")), new BigDecimal(mPEvent3.getCustomAttributeStrings().get("$Amount")), mPEvent3.getEventName(), mPEvent3.getCustomAttributeStrings());
                        }
                        if (list != null && list.size() > 0) {
                            linkedList.addAll(list);
                        }
                    } else {
                        ReportingMessage fromEvent = ReportingMessage.fromEvent(next, mPEvent3);
                        int i10 = 0;
                        boolean z12 = false;
                        while (i10 < projectEvents.size()) {
                            MPEvent mPEvent4 = projectEvents.get(i10).getMPEvent();
                            List<ReportingMessage> logEvent2 = ((KitIntegration.EventListener) next).logEvent(mPEvent4);
                            CoreCallbacks.KitListener kitListener2 = kitManagerImpl.mCoreCallbacks.getKitListener();
                            int kitId2 = next.getConfiguration().getKitId();
                            if (!MPUtility.isEmpty((Collection) logEvent2)) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            kitListener2.onKitApiCalled(kitId2, Boolean.valueOf(z10), mPEvent4);
                            if (logEvent2 != null && logEvent2.size() > 0) {
                                for (ReportingMessage next2 : logEvent2) {
                                    fromEvent.addProjectionReport(new ReportingMessage.ProjectionReport(projectEvents.get(i10).getProjectionId(), ReportingMessage.MessageType.EVENT, next2.getEventName(), next2.getEventTypeString()));
                                }
                                z12 = true;
                            }
                            i10++;
                            kitManagerImpl = this;
                            MPEvent mPEvent5 = mPEvent;
                        }
                        if (z12) {
                            linkedList.add(fromEvent);
                        }
                    }
                    getReportingManager().logAll(linkedList);
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call logMPEvent for kit: " + next.getName() + ": " + e10.getMessage());
            }
            kitManagerImpl = this;
            mPEvent2 = mPEvent;
        }
    }

    public void logNetworkPerformance(String str, long j10, String str2, long j11, long j12, long j13, String str3, int i10) {
        Iterator<KitIntegration> it;
        int i11;
        boolean z10;
        Iterator<KitIntegration> it2 = this.providers.values().iterator();
        while (it2.hasNext()) {
            KitIntegration next = it2.next();
            try {
                if (!next.isDisabled()) {
                    it = it2;
                    i11 = 1;
                    try {
                        List<ReportingMessage> logNetworkPerformance = next.logNetworkPerformance(str, j10, str2, j11, j12, j13, str3, i10);
                        getReportingManager().logAll(logNetworkPerformance);
                        CoreCallbacks.KitListener kitListener = this.mCoreCallbacks.getKitListener();
                        int kitId = next.getConfiguration().getKitId();
                        if (!MPUtility.isEmpty((Collection) logNetworkPerformance)) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        kitListener.onKitApiCalled(kitId, Boolean.valueOf(z10), str, Long.valueOf(j10), str2, Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13), str3, Integer.valueOf(i10));
                    } catch (Exception e10) {
                        e = e10;
                        String[] strArr = new String[i11];
                        strArr[0] = "Failed to call logNetworkPerformance for kit: " + next.getName() + ": " + e.getMessage();
                        Logger.warning(strArr);
                        it2 = it;
                    }
                } else {
                    it = it2;
                }
            } catch (Exception e11) {
                e = e11;
                it = it2;
                i11 = 1;
                String[] strArr2 = new String[i11];
                strArr2[0] = "Failed to call logNetworkPerformance for kit: " + next.getName() + ": " + e.getMessage();
                Logger.warning(strArr2);
                it2 = it;
            }
            it2 = it;
        }
    }

    public void logScreen(MPEvent mPEvent) {
        boolean z10;
        boolean z11;
        DataplanFilter dataplanFilter = this.mDataplanFilter;
        MPEvent mPEvent2 = mPEvent;
        if (dataplanFilter != null) {
            MPEvent mPEvent3 = (MPEvent) dataplanFilter.transformEventForEvent(mPEvent2);
            if (mPEvent3 != null) {
                mPEvent2 = mPEvent3;
            } else {
                return;
            }
        }
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.EventListener) && !next.isDisabled() && next.getConfiguration().shouldLogScreen(mPEvent2.getEventName())) {
                    MPEvent build = new MPEvent.Builder(mPEvent2).customAttributes(next.getConfiguration().filterScreenAttributes((MParticle.EventType) null, mPEvent2.getEventName(), mPEvent2.getCustomAttributes())).build();
                    List<CustomMapping.ProjectionResult> projectEvents = CustomMapping.projectEvents(build, true, next.getConfiguration().getCustomMappingList(), next.getConfiguration().getDefaultEventProjection(), next.getConfiguration().getDefaultScreenCustomMapping());
                    if (projectEvents == null) {
                        String eventName = build.getEventName();
                        Map<String, String> customAttributeStrings = build.getCustomAttributeStrings();
                        List<ReportingMessage> logScreen = ((KitIntegration.EventListener) next).logScreen(eventName, customAttributeStrings);
                        CoreCallbacks.KitListener kitListener = this.mCoreCallbacks.getKitListener();
                        int kitId = next.getConfiguration().getKitId();
                        if (!MPUtility.isEmpty((Collection) logScreen)) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        kitListener.onKitApiCalled(kitId, Boolean.valueOf(z11), eventName, customAttributeStrings);
                        if (logScreen != null && logScreen.size() > 0) {
                            for (ReportingMessage next2 : logScreen) {
                                next2.setMessageType(ReportingMessage.MessageType.SCREEN_VIEW);
                                next2.setScreenName(build.getEventName());
                            }
                        }
                        getReportingManager().logAll(logScreen);
                    } else {
                        ReportingMessage reportingMessage = new ReportingMessage(next, ReportingMessage.MessageType.SCREEN_VIEW, System.currentTimeMillis(), build.getCustomAttributeStrings());
                        Iterator<CustomMapping.ProjectionResult> it = projectEvents.iterator();
                        boolean z12 = false;
                        while (it.hasNext()) {
                            CustomMapping.ProjectionResult next3 = it.next();
                            List<ReportingMessage> logEvent = ((KitIntegration.EventListener) next).logEvent(next3.getMPEvent());
                            CoreCallbacks.KitListener kitListener2 = this.mCoreCallbacks.getKitListener();
                            int kitId2 = next.getConfiguration().getKitId();
                            if (!MPUtility.isEmpty((Collection) logEvent)) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            Iterator<CustomMapping.ProjectionResult> it2 = it;
                            kitListener2.onKitApiCalled("logMPEvent()", kitId2, Boolean.valueOf(z10), next3);
                            if (logEvent != null && logEvent.size() > 0) {
                                for (ReportingMessage next4 : logEvent) {
                                    ReportingMessage.ProjectionReport projectionReport = new ReportingMessage.ProjectionReport(next3.getProjectionId(), ReportingMessage.MessageType.EVENT, next4.getEventName(), next4.getEventTypeString());
                                    reportingMessage.setMessageType(ReportingMessage.MessageType.SCREEN_VIEW);
                                    reportingMessage.setScreenName(next4.getEventName());
                                    reportingMessage.addProjectionReport(projectionReport);
                                }
                                z12 = true;
                            }
                            it = it2;
                        }
                        if (z12) {
                            getReportingManager().log(reportingMessage);
                        }
                    }
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call logScreen for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void logout() {
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.AttributeListener) && !next.isDisabled()) {
                    getReportingManager().logAll(((KitIntegration.AttributeListener) next).logout());
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call logout for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.ActivityListener) && !next.isDisabled()) {
                    getReportingManager().logAll(((KitIntegration.ActivityListener) next).onActivityCreated(activity, bundle));
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onActivityCreated for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.ActivityListener) && !next.isDisabled()) {
                    getReportingManager().logAll(((KitIntegration.ActivityListener) next).onActivityDestroyed(activity));
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onActivityDestroyed for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.ActivityListener) && !next.isDisabled()) {
                    getReportingManager().logAll(((KitIntegration.ActivityListener) next).onActivityPaused(activity));
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onResume for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onActivityResumed(Activity activity) {
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.ActivityListener) && !next.isDisabled()) {
                    getReportingManager().logAll(((KitIntegration.ActivityListener) next).onActivityResumed(activity));
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onActivityResumed for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.ActivityListener) && !next.isDisabled()) {
                    getReportingManager().logAll(((KitIntegration.ActivityListener) next).onActivitySaveInstanceState(activity, bundle));
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onActivitySaveInstanceState for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.ActivityListener) && !next.isDisabled()) {
                    getReportingManager().logAll(((KitIntegration.ActivityListener) next).onActivityStarted(activity));
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onActivityStarted for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.ActivityListener) && !next.isDisabled()) {
                    getReportingManager().logAll(((KitIntegration.ActivityListener) next).onActivityStopped(activity));
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onActivityStopped for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onApplicationBackground() {
        for (KitIntegration next : this.providers.values()) {
            try {
                if (next instanceof KitIntegration.ApplicationStateListener) {
                    ((KitIntegration.ApplicationStateListener) next).onApplicationBackground();
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onApplicationBackground for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onApplicationForeground() {
        for (KitIntegration next : this.providers.values()) {
            try {
                if (next instanceof KitIntegration.ApplicationStateListener) {
                    ((KitIntegration.ApplicationStateListener) next).onApplicationForeground();
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onApplicationForeground for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onConsentStateUpdated(ConsentState consentState, ConsentState consentState2, long j10) {
        reloadKits();
        for (KitIntegration next : this.providers.values()) {
            if ((next instanceof KitIntegration.UserAttributeListener) && !next.isDisabled()) {
                try {
                    ((KitIntegration.UserAttributeListener) next).onConsentStateUpdated(consentState, consentState2, FilteredMParticleUser.getInstance(j10, next));
                } catch (Exception e10) {
                    Logger.warning("Failed to call onConsentStateUpdated for kit: " + next.getName() + ": " + e10.getMessage());
                }
            }
        }
    }

    public void onError(AttributionError attributionError) {
        AttributionListener attributionListener;
        MParticle instance = MParticle.getInstance();
        if (instance != null && (attributionListener = instance.getAttributionListener()) != null && attributionError != null) {
            Logger.debug("Attribution error returned: \n" + attributionError.toString());
            attributionListener.onError(attributionError);
        }
    }

    public void onIdentifyCompleted(MParticleUser mParticleUser, IdentityApiRequest identityApiRequest) {
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.IdentityListener) && !next.isDisabled()) {
                    ((KitIntegration.IdentityListener) next).onIdentifyCompleted(FilteredMParticleUser.getInstance(mParticleUser, next), new FilteredIdentityApiRequest(identityApiRequest, next));
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onIdentifyCompleted for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onLoginCompleted(MParticleUser mParticleUser, IdentityApiRequest identityApiRequest) {
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.IdentityListener) && !next.isDisabled()) {
                    ((KitIntegration.IdentityListener) next).onLoginCompleted(FilteredMParticleUser.getInstance(mParticleUser, next), new FilteredIdentityApiRequest(identityApiRequest, next));
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onLoginCompleted for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onLogoutCompleted(MParticleUser mParticleUser, IdentityApiRequest identityApiRequest) {
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.IdentityListener) && !next.isDisabled()) {
                    ((KitIntegration.IdentityListener) next).onLogoutCompleted(FilteredMParticleUser.getInstance(mParticleUser, next), new FilteredIdentityApiRequest(identityApiRequest, next));
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onLogoutCompleted for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public boolean onMessageReceived(Context context, Intent intent) {
        for (KitIntegration next : this.providers.values()) {
            if (next instanceof KitIntegration.PushListener) {
                try {
                    if (!next.isDisabled()) {
                        boolean willHandlePushMessage = ((KitIntegration.PushListener) next).willHandlePushMessage(intent);
                        this.mCoreCallbacks.getKitListener().onKitApiCalled("willHandlePushMessage()", next.getConfiguration().getKitId(), Boolean.valueOf(willHandlePushMessage), intent);
                        if (willHandlePushMessage) {
                            ((KitIntegration.PushListener) next).onPushMessageReceived(context, intent);
                            this.mCoreCallbacks.getKitListener().onKitApiCalled("onPushMessageReceived()", next.getConfiguration().getKitId(), (Boolean) null, context, intent);
                            getReportingManager().log(ReportingMessage.fromPushMessage(next, intent));
                            return true;
                        }
                    } else {
                        continue;
                    }
                } catch (Exception e10) {
                    Logger.warning("Failed to call onPushMessageReceived for kit: " + next.getName() + ": " + e10.getMessage());
                }
            }
        }
        return false;
    }

    public void onModifyCompleted(MParticleUser mParticleUser, IdentityApiRequest identityApiRequest) {
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.IdentityListener) && !next.isDisabled()) {
                    ((KitIntegration.IdentityListener) next).onModifyCompleted(FilteredMParticleUser.getInstance(mParticleUser, next), new FilteredIdentityApiRequest(identityApiRequest, next));
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onModifyCompleted for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public boolean onPushRegistration(String str, String str2) {
        for (KitIntegration next : this.providers.values()) {
            if (next instanceof KitIntegration.PushListener) {
                try {
                    if (!next.isDisabled()) {
                        boolean onPushRegistration = ((KitIntegration.PushListener) next).onPushRegistration(str, str2);
                        this.mCoreCallbacks.getKitListener().onKitApiCalled(next.getConfiguration().getKitId(), Boolean.valueOf(onPushRegistration), str, str2);
                        if (onPushRegistration) {
                            getReportingManager().log(ReportingMessage.fromPushRegistrationMessage(next));
                        }
                        return true;
                    }
                } catch (Exception e10) {
                    Logger.warning("Failed to call onPushRegistration for kit: " + next.getName() + ": " + e10.getMessage());
                }
            }
        }
        return false;
    }

    public void onResult(AttributionResult attributionResult) {
        AttributionListener attributionListener;
        this.mAttributionResultsMap.put(Integer.valueOf(attributionResult.getServiceProviderId()), attributionResult);
        MParticle instance = MParticle.getInstance();
        if (instance != null && (attributionListener = instance.getAttributionListener()) != null) {
            Logger.debug("Attribution result returned: \n" + attributionResult.toString());
            attributionListener.onResult(attributionResult);
        }
    }

    public void onSessionEnd() {
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.SessionListener) && !next.isDisabled()) {
                    getReportingManager().logAll(((KitIntegration.SessionListener) next).onSessionEnd());
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onSessionEnd for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onSessionStart() {
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.SessionListener) && !next.isDisabled()) {
                    getReportingManager().logAll(((KitIntegration.SessionListener) next).onSessionStart());
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onSessionStart for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onUserAttributesReceived(Map<String, String> map, Map<String, List<String>> map2, Long l10) {
        Map<String, T> transformUserAttributes = this.mDataplanFilter.transformUserAttributes(map);
        Map<String, T> transformUserAttributes2 = this.mDataplanFilter.transformUserAttributes(map2);
        for (KitIntegration next : this.providers.values()) {
            try {
                if (((next instanceof KitIntegration.AttributeListener) || (next instanceof KitIntegration.UserAttributeListener)) && !next.isDisabled()) {
                    Map<String, ?> filterAttributes = KitConfiguration.filterAttributes(next.getConfiguration().getUserAttributeFilters(), transformUserAttributes);
                    Map<String, ?> filterAttributes2 = KitConfiguration.filterAttributes(next.getConfiguration().getUserAttributeFilters(), transformUserAttributes2);
                    if (next instanceof KitIntegration.AttributeListener) {
                        if (((KitIntegration.AttributeListener) next).supportsAttributeLists()) {
                            ((KitIntegration.AttributeListener) next).setAllUserAttributes(filterAttributes, filterAttributes2);
                        } else {
                            HashMap hashMap = new HashMap(filterAttributes);
                            for (Map.Entry next2 : filterAttributes2.entrySet()) {
                                hashMap.put((String) next2.getKey(), KitUtils.join((List) next2.getValue()));
                            }
                            ((KitIntegration.AttributeListener) next).setAllUserAttributes(hashMap, new HashMap());
                        }
                    }
                    if (next instanceof KitIntegration.UserAttributeListener) {
                        if (((KitIntegration.UserAttributeListener) next).supportsAttributeLists()) {
                            ((KitIntegration.UserAttributeListener) next).onSetAllUserAttributes(filterAttributes, filterAttributes2, FilteredMParticleUser.getInstance(l10.longValue(), next));
                        } else {
                            HashMap hashMap2 = new HashMap(filterAttributes);
                            for (Map.Entry next3 : filterAttributes2.entrySet()) {
                                hashMap2.put((String) next3.getKey(), KitUtils.join((List) next3.getValue()));
                            }
                            ((KitIntegration.UserAttributeListener) next).onSetAllUserAttributes(hashMap2, new HashMap(), FilteredMParticleUser.getInstance(l10.longValue(), next));
                        }
                    }
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call setUserAttributes for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void onUserIdentified(MParticleUser mParticleUser, MParticleUser mParticleUser2) {
        reloadKits();
        for (KitIntegration next : this.providers.values()) {
            try {
                if ((next instanceof KitIntegration.IdentityListener) && !next.isDisabled()) {
                    ((KitIntegration.IdentityListener) next).onUserIdentified(FilteredMParticleUser.getInstance(mParticleUser, next));
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call onUserIdentified for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
        mParticleUser.getUserAttributes(this);
    }

    public void reloadKits() {
        configureKits(this.kitConfigurations);
    }

    public void removeUserAttribute(String str, long j10) {
        if (!this.mDataplanFilter.isUserAttributeBlocked(str)) {
            for (KitIntegration next : this.providers.values()) {
                try {
                    if (((next instanceof KitIntegration.AttributeListener) || (next instanceof KitIntegration.UserAttributeListener)) && !next.isDisabled() && KitConfiguration.shouldForwardAttribute(next.getConfiguration().getUserAttributeFilters(), str)) {
                        if (next instanceof KitIntegration.AttributeListener) {
                            ((KitIntegration.AttributeListener) next).removeUserAttribute(str);
                        }
                        if (next instanceof KitIntegration.UserAttributeListener) {
                            ((KitIntegration.UserAttributeListener) next).onRemoveUserAttribute(str, FilteredMParticleUser.getInstance(j10, next));
                        }
                    }
                } catch (Exception e10) {
                    Logger.warning("Failed to call removeUserAttribute/onRemoveUserAttribute for kit: " + next.getName() + ": " + e10.getMessage());
                }
            }
        }
    }

    public void removeUserIdentity(MParticle.IdentityType identityType) {
        if (!this.mDataplanFilter.isUserIdentityBlocked(identityType)) {
            for (KitIntegration next : this.providers.values()) {
                try {
                    if ((next instanceof KitIntegration.AttributeListener) && !next.isDisabled()) {
                        ((KitIntegration.AttributeListener) next).removeUserIdentity(identityType);
                    }
                } catch (Exception e10) {
                    Logger.warning("Failed to call removeUserIdentity for kit: " + next.getName() + ": " + e10.getMessage());
                }
            }
        }
    }

    public void reset() {
        for (KitIntegration next : this.providers.values()) {
            try {
                next.reset();
            } catch (Exception e10) {
                Logger.warning("Failed to call reset for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void runOnKitThread(Runnable runnable) {
        if (this.mKitHandler == null) {
            this.mKitHandler = new Handler(kitHandlerThread.getLooper());
        }
        this.mKitHandler.post(runnable);
    }

    public void runOnMainThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    public void setDataplanFilter(DataplanFilter dataplanFilter) {
        if (dataplanFilter != null) {
            this.mDataplanFilter = dataplanFilter;
        } else {
            this.mDataplanFilter = DataplanFilterImpl.EMPTY;
        }
    }

    /* access modifiers changed from: package-private */
    public void setIntegrationAttributes(KitIntegration kitIntegration, Map<String, String> map) {
        this.mCoreCallbacks.setIntegrationAttributes(kitIntegration.getConfiguration().getKitId(), map);
    }

    public void setKitFactory(KitIntegrationFactory kitIntegrationFactory) {
        this.mKitIntegrationFactory = kitIntegrationFactory;
    }

    public void setKitOptions(KitOptions kitOptions) {
        this.mKitOptions = kitOptions;
    }

    public void setLocation(Location location) {
        for (KitIntegration next : this.providers.values()) {
            try {
                if (!next.isDisabled()) {
                    next.setLocation(location);
                    this.mCoreCallbacks.getKitListener().onKitApiCalled(next.getConfiguration().getKitId(), Boolean.TRUE, location);
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call setLocation for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
    }

    public void setOptOut(boolean z10) {
        boolean z11;
        for (KitIntegration next : this.providers.values()) {
            try {
                if (!next.isDisabled(true)) {
                    List<ReportingMessage> optOut = next.setOptOut(z10);
                    getReportingManager().logAll(optOut);
                    CoreCallbacks.KitListener kitListener = this.mCoreCallbacks.getKitListener();
                    int kitId = next.getConfiguration().getKitId();
                    if (!MPUtility.isEmpty((Collection) optOut)) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    kitListener.onKitApiCalled(kitId, Boolean.valueOf(z11), Boolean.valueOf(z10));
                }
            } catch (Exception e10) {
                Logger.warning("Failed to call setOptOut for kit: " + next.getName() + ": " + e10.getMessage());
            }
        }
        reloadKits();
    }

    public void setUserAttribute(String str, String str2, long j10) {
        if (!this.mDataplanFilter.isUserAttributeBlocked(str)) {
            for (KitIntegration next : this.providers.values()) {
                try {
                    setUserAttribute(next, str, str2, j10);
                } catch (Exception e10) {
                    Logger.warning("Failed to call setUserAttributes/onSetUserAttribute for kit: " + next.getName() + ": " + e10.getMessage());
                }
            }
        }
    }

    public void setUserAttributeList(String str, List<String> list, long j10) {
        if (!this.mDataplanFilter.isUserAttributeBlocked(str)) {
            for (KitIntegration next : this.providers.values()) {
                try {
                    setUserAttribute(next, str, list, j10);
                } catch (Exception e10) {
                    Logger.warning("Failed to call setUserAttributes/onSetUserAttribute for kit: " + next.getName() + ": " + e10.getMessage());
                }
            }
        }
    }

    public void setUserIdentity(String str, MParticle.IdentityType identityType) {
        if (!this.mDataplanFilter.isUserIdentityBlocked(identityType)) {
            for (KitIntegration next : this.providers.values()) {
                try {
                    if ((next instanceof KitIntegration.AttributeListener) && !next.isDisabled() && next.getConfiguration().shouldSetIdentity(identityType)) {
                        ((KitIntegration.AttributeListener) next).setUserIdentity(identityType, str);
                    }
                } catch (Exception e10) {
                    Logger.warning("Failed to call setUserIdentity for kit: " + next.getName() + ": " + e10.getMessage());
                }
            }
        }
    }

    public void setUserTag(String str, long j10) {
        if (!this.mDataplanFilter.isUserAttributeBlocked(str)) {
            for (KitIntegration next : this.providers.values()) {
                try {
                    if ((next instanceof KitIntegration.UserAttributeListener) && !next.isDisabled() && KitConfiguration.shouldForwardAttribute(next.getConfiguration().getUserAttributeFilters(), str)) {
                        ((KitIntegration.UserAttributeListener) next).onSetUserTag(str, FilteredMParticleUser.getInstance(j10, next));
                    }
                } catch (Exception e10) {
                    Logger.warning("Failed to call onSetUserTag for kit: " + next.getName() + ": " + e10.getMessage());
                }
            }
        }
    }

    public void updateDataplan(MParticleOptions.DataplanOptions dataplanOptions) {
        if (dataplanOptions != null) {
            try {
                Logger.info("Updating Data Plan");
                Logger.debug(dataplanOptions.toString());
                this.mDataplanFilter = new DataplanFilterImpl(dataplanOptions);
            } catch (Exception e10) {
                Logger.warning(e10, "Failed to parse DataplanOptions, Dataplan filtering for Kits will not be applied");
                this.mDataplanFilter = DataplanFilterImpl.EMPTY;
            }
        } else {
            this.mDataplanFilter = DataplanFilterImpl.EMPTY;
            Logger.info("Clearing Data Plan");
        }
    }

    public KitsLoadedCallback updateKits(a aVar) {
        KitsLoadedCallback kitsLoadedCallback = new KitsLoadedCallback();
        runOnKitThread(new f(this, aVar, kitsLoadedCallback));
        return kitsLoadedCallback;
    }

    private void setUserAttribute(KitIntegration kitIntegration, String str, List<String> list, long j10) {
        if (((kitIntegration instanceof KitIntegration.AttributeListener) || (kitIntegration instanceof KitIntegration.UserAttributeListener)) && !kitIntegration.isDisabled() && KitConfiguration.shouldForwardAttribute(kitIntegration.getConfiguration().getUserAttributeFilters(), str)) {
            if (kitIntegration instanceof KitIntegration.AttributeListener) {
                KitIntegration.AttributeListener attributeListener = (KitIntegration.AttributeListener) kitIntegration;
                if (attributeListener.supportsAttributeLists()) {
                    attributeListener.setUserAttributeList(str, list);
                } else {
                    attributeListener.setUserAttribute(str, KitUtils.join(list));
                }
            }
            if (kitIntegration instanceof KitIntegration.UserAttributeListener) {
                KitIntegration.UserAttributeListener userAttributeListener = (KitIntegration.UserAttributeListener) kitIntegration;
                if (userAttributeListener.supportsAttributeLists()) {
                    userAttributeListener.onSetUserAttributeList(str, list, FilteredMParticleUser.getInstance(j10, kitIntegration));
                } else {
                    userAttributeListener.onSetUserAttribute(str, KitUtils.join(list), FilteredMParticleUser.getInstance(j10, kitIntegration));
                }
            }
        }
    }

    private void setUserAttribute(KitIntegration kitIntegration, String str, String str2, long j10) {
        if (((kitIntegration instanceof KitIntegration.AttributeListener) || (kitIntegration instanceof KitIntegration.UserAttributeListener)) && !kitIntegration.isDisabled() && KitConfiguration.shouldForwardAttribute(kitIntegration.getConfiguration().getUserAttributeFilters(), str)) {
            if (kitIntegration instanceof KitIntegration.AttributeListener) {
                ((KitIntegration.AttributeListener) kitIntegration).setUserAttribute(str, str2);
            }
            if (kitIntegration instanceof KitIntegration.UserAttributeListener) {
                ((KitIntegration.UserAttributeListener) kitIntegration).onSetUserAttribute(str, str2, FilteredMParticleUser.getInstance(j10, kitIntegration));
            }
        }
    }
}
