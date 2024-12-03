package com.mparticle.identity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.mparticle.MParticle;
import com.mparticle.MParticleTask;
import com.mparticle.f0;
import com.mparticle.internal.KitManager;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IdentityApi {
    public static int BAD_REQUEST = 400;
    public static int SERVER_ERROR = 500;
    public static int THROTTLE_ERROR = 429;
    public static int UNKNOWN_ERROR = -1;
    /* access modifiers changed from: private */
    public static Object lock = new Object();
    Set<IdentityStateListener> identityStateListeners = new HashSet();
    private f0 mApiClient;
    /* access modifiers changed from: private */
    public com.mparticle.b mBackgroundHandler;
    com.mparticle.internal.b mConfigManager;
    /* access modifiers changed from: private */
    public Context mContext;
    private i mInternal = new i();
    KitManager mKitManager;
    /* access modifiers changed from: private */
    public com.mparticle.b mMainHandler;
    com.mparticle.internal.j mMessageManager;
    private MParticle.OperatingSystem mOperatingSystem;
    b mUserDelegate;

    class a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdentityApiRequest f22326a;

        a(IdentityApiRequest identityApiRequest) {
            this.f22326a = identityApiRequest;
        }

        public IdentityHttpResponse a(IdentityApiRequest identityApiRequest) throws Exception {
            return IdentityApi.this.getApiClient().d(identityApiRequest);
        }

        public void a(IdentityApiResult identityApiResult) {
            IdentityApi.this.mKitManager.onLogoutCompleted(identityApiResult.getUser(), this.f22326a);
        }
    }

    class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdentityApiRequest f22328a;

        b(IdentityApiRequest identityApiRequest) {
            this.f22328a = identityApiRequest;
        }

        public IdentityHttpResponse a(IdentityApiRequest identityApiRequest) throws Exception {
            return IdentityApi.this.getApiClient().b(identityApiRequest);
        }

        public void a(IdentityApiResult identityApiResult) {
            IdentityApi.this.mKitManager.onLoginCompleted(identityApiResult.getUser(), this.f22328a);
        }
    }

    class c implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdentityApiRequest f22330a;

        c(IdentityApiRequest identityApiRequest) {
            this.f22330a = identityApiRequest;
        }

        public IdentityHttpResponse a(IdentityApiRequest identityApiRequest) throws Exception {
            return IdentityApi.this.getApiClient().c(identityApiRequest);
        }

        public void a(IdentityApiResult identityApiResult) {
            IdentityApi.this.mKitManager.onIdentifyCompleted(identityApiResult.getUser(), this.f22330a);
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdentityApiRequest f22332a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseIdentityTask f22333b;

        class a implements Runnable {
            a() {
            }

            public void run() {
                d dVar = d.this;
                IdentityApi identityApi = IdentityApi.this;
                identityApi.mKitManager.onModifyCompleted(identityApi.getUser(dVar.f22332a.mpid), d.this.f22332a);
            }
        }

        d(IdentityApiRequest identityApiRequest, BaseIdentityTask baseIdentityTask) {
            this.f22332a = identityApiRequest;
            this.f22333b = baseIdentityTask;
        }

        public void run() {
            try {
                IdentityHttpResponse a10 = IdentityApi.this.getApiClient().a(this.f22332a);
                if (!a10.isSuccessful()) {
                    this.f22333b.setFailed(a10);
                    return;
                }
                b.a(IdentityApi.this.mUserDelegate, this.f22332a.getUserIdentities(), this.f22332a.mpid.longValue());
                this.f22333b.setSuccessful(new IdentityApiResult(c.a(IdentityApi.this.mContext, this.f22332a.mpid.longValue(), IdentityApi.this.mUserDelegate), (MParticleUser) null));
                new Handler(Looper.getMainLooper()).post(new a());
            } catch (Exception e10) {
                this.f22333b.setFailed(new IdentityHttpResponse(IdentityApi.UNKNOWN_ERROR, e10.toString()));
            }
        }
    }

    class e implements Comparator<MParticleUser> {
        e() {
        }

        /* renamed from: a */
        public int compare(MParticleUser mParticleUser, MParticleUser mParticleUser2) {
            int i10 = (mParticleUser.getLastSeenTime() > mParticleUser2.getLastSeenTime() ? 1 : (mParticleUser.getLastSeenTime() == mParticleUser2.getLastSeenTime() ? 0 : -1));
            if (i10 > 0) {
                return -1;
            }
            if (i10 < 0) {
                return 1;
            }
            return 0;
        }
    }

    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f22337a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ IdentityApiRequest f22338b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseIdentityTask f22339c;

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MParticleUser f22341a;

            a(MParticleUser mParticleUser) {
                this.f22341a = mParticleUser;
            }

            public void run() {
                f fVar = f.this;
                fVar.f22337a.a(new IdentityApiResult(IdentityApi.this.getCurrentUser(), this.f22341a));
            }
        }

        f(g gVar, IdentityApiRequest identityApiRequest, BaseIdentityTask baseIdentityTask) {
            this.f22337a = gVar;
            this.f22338b = identityApiRequest;
            this.f22339c = baseIdentityTask;
        }

        public void run() {
            MParticleUser mParticleUser;
            synchronized (IdentityApi.lock) {
                if (!IdentityApi.this.mBackgroundHandler.a()) {
                    try {
                        long E = IdentityApi.this.mConfigManager.E();
                        IdentityHttpResponse a10 = this.f22337a.a(this.f22338b);
                        if (!a10.isSuccessful()) {
                            com.mparticle.internal.b.d(false);
                            this.f22339c.setFailed(a10);
                        } else {
                            long mpId = a10.getMpId();
                            boolean isLoggedIn = a10.isLoggedIn();
                            com.mparticle.internal.b.d(false);
                            IdentityApi identityApi = IdentityApi.this;
                            identityApi.mUserDelegate.a(identityApi.mContext, E, mpId, this.f22338b.getUserIdentities(), this.f22338b.getUserAliasHandler(), isLoggedIn);
                            long j10 = mpId;
                            if (E != j10) {
                                mParticleUser = IdentityApi.this.getUser(Long.valueOf(E));
                            } else {
                                mParticleUser = null;
                            }
                            this.f22339c.setSuccessful(new IdentityApiResult(c.a(IdentityApi.this.mContext, j10, IdentityApi.this.mUserDelegate), mParticleUser));
                            new Handler(Looper.getMainLooper()).post(new a(mParticleUser));
                        }
                    } catch (Exception e10) {
                        com.mparticle.internal.b.d(false);
                        this.f22339c.setFailed(new IdentityHttpResponse(IdentityApi.UNKNOWN_ERROR, e10.toString()));
                    }
                }
            }
        }
    }

    interface g {
        IdentityHttpResponse a(IdentityApiRequest identityApiRequest) throws Exception;

        void a(IdentityApiResult identityApiResult);
    }

    class h implements j {

        private class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            Set<IdentityStateListener> f22344a;

            /* renamed from: b  reason: collision with root package name */
            MParticleUser f22345b;

            /* renamed from: c  reason: collision with root package name */
            MParticleUser f22346c;

            /* synthetic */ a(h hVar, Set set, MParticleUser mParticleUser, MParticleUser mParticleUser2, a aVar) {
                this(set, mParticleUser, mParticleUser2);
            }

            public void run() {
                try {
                    for (IdentityStateListener onUserIdentified : this.f22344a) {
                        onUserIdentified.onUserIdentified(this.f22345b, this.f22346c);
                    }
                } catch (Exception e10) {
                    Logger.error(e10.toString());
                }
            }

            private a(Set<IdentityStateListener> set, MParticleUser mParticleUser, MParticleUser mParticleUser2) {
                this.f22344a = new HashSet(set);
                this.f22345b = mParticleUser;
                this.f22346c = mParticleUser2;
            }
        }

        h() {
        }

        public void a(long j10, long j11) {
            MParticleUser mParticleUser;
            MParticleUser a10 = c.a(IdentityApi.this.mContext, j10, IdentityApi.this.mUserDelegate);
            Set<IdentityStateListener> set = IdentityApi.this.identityStateListeners;
            if (set != null && set.size() > 0) {
                if (IdentityApi.this.mMainHandler == null) {
                    com.mparticle.b unused = IdentityApi.this.mMainHandler = new com.mparticle.b(Looper.getMainLooper());
                }
                if (j11 != 0) {
                    mParticleUser = c.a(IdentityApi.this.mContext, j11, IdentityApi.this.mUserDelegate);
                } else {
                    mParticleUser = null;
                }
                IdentityApi.this.mMainHandler.post(new a(this, IdentityApi.this.identityStateListeners, a10, mParticleUser, (a) null));
            }
        }
    }

    public class i {
        public i() {
        }

        public void a() {
            IdentityApi.this.reset();
        }
    }

    public interface j {
        void a(long j10, long j11);
    }

    public static abstract class k implements IdentityStateListener {
        public abstract void a(MParticleUser mParticleUser);

        public void onUserIdentified(MParticleUser mParticleUser, MParticleUser mParticleUser2) {
            MParticle.getInstance().Identity().removeIdentityStateListener(this);
            a(mParticleUser);
        }
    }

    protected IdentityApi() {
    }

    private BaseIdentityTask makeIdentityRequest(IdentityApiRequest identityApiRequest, g gVar) {
        if (identityApiRequest == null) {
            identityApiRequest = IdentityApiRequest.withEmptyUser().build();
        }
        BaseIdentityTask baseIdentityTask = new BaseIdentityTask();
        com.mparticle.internal.b.d(true);
        this.mBackgroundHandler.post(new f(gVar, identityApiRequest, baseIdentityTask));
        return baseIdentityTask;
    }

    /* access modifiers changed from: private */
    public void reset() {
        this.identityStateListeners = new HashSet();
        this.mBackgroundHandler.removeCallbacksAndMessages((Object) null);
        this.mBackgroundHandler.a(true);
        com.mparticle.b bVar = this.mMainHandler;
        if (bVar != null) {
            bVar.a(true);
            this.mMainHandler.removeCallbacksAndMessages((Object) null);
        }
    }

    @NonNull
    public i Internal() {
        return this.mInternal;
    }

    public void addIdentityStateListener(@NonNull IdentityStateListener identityStateListener) {
        this.identityStateListeners.add(identityStateListener);
    }

    public boolean aliasUsers(@NonNull AliasRequest aliasRequest) {
        if (aliasRequest.getDestinationMpid() == 0 || aliasRequest.getSourceMpid() == 0) {
            Logger.error("AliasRequest does not have a valid destinationMpid and a valid sourceMpid");
            return false;
        } else if (aliasRequest.getDestinationMpid() == aliasRequest.getSourceMpid()) {
            Logger.error("AliasRequest cannot have the same value for destinationMpid and sourceMpid");
            return false;
        } else if (aliasRequest.getEndTime() == 0 || aliasRequest.getStartTime() == 0) {
            Logger.error("AliasRequest must have both a startTime and an endTime");
            return false;
        } else if (aliasRequest.getEndTime() < aliasRequest.getStartTime()) {
            Logger.error("AliasRequest cannot have an startTime that is greater than its endTime");
            return false;
        } else {
            this.mMessageManager.a(aliasRequest);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public f0 getApiClient() {
        if (this.mApiClient == null) {
            this.mApiClient = new a(this.mContext, this.mConfigManager, this.mOperatingSystem);
        }
        return this.mApiClient;
    }

    public MParticleUser getCurrentUser() {
        long E = this.mConfigManager.E();
        if (com.mparticle.h.f22319b.longValue() == E) {
            return null;
        }
        return c.a(this.mContext, E, this.mUserDelegate);
    }

    @NonNull
    public String getDeviceApplicationStamp() {
        return this.mConfigManager.t();
    }

    public MParticleUser getUser(@NonNull Long l10) {
        if (com.mparticle.h.f22319b.equals(l10) || !this.mConfigManager.g(l10.longValue())) {
            return null;
        }
        return c.a(this.mContext, l10.longValue(), this.mUserDelegate);
    }

    @NonNull
    public List<MParticleUser> getUsers() {
        ArrayList arrayList = new ArrayList();
        Set<Long> F = this.mConfigManager.F();
        F.remove(com.mparticle.h.f22319b);
        for (Long longValue : F) {
            arrayList.add(c.a(this.mContext, longValue.longValue(), this.mUserDelegate));
        }
        sortUsers(arrayList);
        return arrayList;
    }

    @NonNull
    public MParticleTask<IdentityApiResult> identify(IdentityApiRequest identityApiRequest) {
        return makeIdentityRequest(identityApiRequest, new c(identityApiRequest));
    }

    @NonNull
    public MParticleTask<IdentityApiResult> login() {
        return login((IdentityApiRequest) null);
    }

    @NonNull
    public MParticleTask<IdentityApiResult> logout() {
        return logout((IdentityApiRequest) null);
    }

    @NonNull
    public BaseIdentityTask modify(@NonNull IdentityApiRequest identityApiRequest) {
        boolean z10;
        if (MPUtility.isDevEnv() || MPUtility.isAppDebuggable(this.mContext)) {
            z10 = true;
        } else {
            z10 = false;
        }
        BaseIdentityTask baseIdentityTask = new BaseIdentityTask();
        if (identityApiRequest.mpid == null) {
            identityApiRequest.mpid = Long.valueOf(this.mConfigManager.E());
        }
        if (!com.mparticle.h.f22319b.equals(identityApiRequest.mpid)) {
            this.mBackgroundHandler.post(new d(identityApiRequest, baseIdentityTask));
            return baseIdentityTask;
        } else if (!z10) {
            Logger.error("modify() requires a non-zero MPID, please make sure a MParticleUser is present before making a modify request.");
            baseIdentityTask.setFailed(new IdentityHttpResponse(UNKNOWN_ERROR, "modify() requires a non-zero MPID, please make sure a MParticleUser is present before making a modify request."));
            return baseIdentityTask;
        } else {
            throw new IllegalArgumentException("modify() requires a non-zero MPID, please make sure a MParticleUser is present before making a modify request.");
        }
    }

    public void removeIdentityStateListener(@NonNull IdentityStateListener identityStateListener) {
        this.identityStateListeners.remove(identityStateListener);
    }

    /* access modifiers changed from: package-private */
    public void setApiClient(f0 f0Var) {
        this.mApiClient = f0Var;
    }

    /* access modifiers changed from: package-private */
    public void sortUsers(List<MParticleUser> list) {
        Collections.sort(list, new e());
    }

    @NonNull
    public MParticleTask<IdentityApiResult> login(IdentityApiRequest identityApiRequest) {
        return makeIdentityRequest(identityApiRequest, new b(identityApiRequest));
    }

    @NonNull
    public MParticleTask<IdentityApiResult> logout(IdentityApiRequest identityApiRequest) {
        return makeIdentityRequest(identityApiRequest, new a(identityApiRequest));
    }

    @SuppressLint({"UnknownNullness"})
    public IdentityApi(Context context, com.mparticle.internal.a aVar, com.mparticle.internal.j jVar, com.mparticle.internal.b bVar, KitManager kitManager, MParticle.OperatingSystem operatingSystem) {
        this.mContext = context;
        this.mBackgroundHandler = jVar.f22501g;
        this.mUserDelegate = new b(aVar, bVar, jVar, kitManager);
        this.mConfigManager = bVar;
        this.mMessageManager = jVar;
        this.mKitManager = kitManager;
        this.mOperatingSystem = operatingSystem;
        com.mparticle.internal.b.a((j) new h());
        setApiClient(new a(context, bVar, operatingSystem));
    }
}
