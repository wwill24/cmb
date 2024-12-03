package q8;

import android.os.Handler;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.mparticle.MPEvent;
import com.mparticle.MParticle;
import com.mparticle.identity.IdentityApi;
import com.mparticle.identity.IdentityApiRequest;
import com.mparticle.identity.IdentityApiResult;
import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.identity.MParticleUser;
import com.mparticle.identity.TaskFailureListener;
import com.mparticle.identity.TaskSuccessListener;
import h8.a;
import java.util.Map;

public class l implements a {

    /* renamed from: a  reason: collision with root package name */
    private final a f17208a;

    /* renamed from: b  reason: collision with root package name */
    private int f17209b = 0;

    public l(a aVar) {
        this.f17208a = aVar;
    }

    /* access modifiers changed from: private */
    public void A(IdentityHttpResponse identityHttpResponse) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed mParticle action ");
        sb2.append(identityHttpResponse.toString());
        fa.a.i(new Throwable("Failed mParticle action " + identityHttpResponse.toString()));
    }

    private void B(IdentityApiRequest identityApiRequest) {
        MParticle.getInstance().Identity().addIdentityStateListener(new j(identityApiRequest));
    }

    private void C(Runnable runnable, IdentityHttpResponse identityHttpResponse) {
        int i10 = this.f17209b;
        if (i10 <= 10) {
            this.f17209b = i10 + 1;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Retrying mParticle action, attempt ");
            sb2.append(this.f17209b);
            new Handler().postDelayed(runnable, 5000);
            return;
        }
        A(identityHttpResponse);
    }

    private IdentityApiRequest p(NetworkProfile networkProfile) {
        return IdentityApiRequest.withEmptyUser().customerId(networkProfile.getId()).email(networkProfile.getUserEmail()).userIdentity(MParticle.IdentityType.Facebook, this.f17208a.a()).build();
    }

    private boolean q(int i10) {
        return i10 == IdentityApi.BAD_REQUEST || i10 == IdentityApi.UNKNOWN_ERROR || i10 == IdentityApi.THROTTLE_ERROR;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(String str, IdentityHttpResponse identityHttpResponse) {
        if (q(identityHttpResponse.getHttpCode())) {
            C(new k(this, str), identityHttpResponse);
        } else {
            A(identityHttpResponse);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(IdentityApiResult identityApiResult) {
        this.f17209b = 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(IdentityApiResult identityApiResult) {
        this.f17209b = 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(NetworkProfile networkProfile, IdentityHttpResponse identityHttpResponse) {
        if (q(identityHttpResponse.getHttpCode())) {
            C(new g(this, networkProfile), identityHttpResponse);
        } else {
            A(identityHttpResponse);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(IdentityApiResult identityApiResult) {
        this.f17209b = 0;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void y(IdentityApiRequest identityApiRequest, MParticleUser mParticleUser, MParticleUser mParticleUser2) {
        if (mParticleUser2 == null) {
            MParticle.getInstance().Identity().modify(identityApiRequest);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void z(String str, Object obj, MParticleUser mParticleUser, Map map, Map map2, long j10) {
        Object obj2;
        Object obj3 = map.get(str);
        if (obj == null) {
            obj2 = "";
        } else {
            obj2 = obj;
        }
        if (obj == null) {
            fa.a.i(new IllegalStateException("Tried to set the custom dimension \"" + str + "\" to null."));
        }
        if (!obj2.equals(obj3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setUserAttribute: Resetting user attribute ");
            sb2.append(str);
            sb2.append(" to ");
            sb2.append(obj2);
            mParticleUser.setUserAttribute(str, obj2);
        }
    }

    /* renamed from: a */
    public void v(NetworkProfile networkProfile) {
        IdentityApiRequest p10 = p(networkProfile);
        if (MParticle.getInstance().Identity().getCurrentUser() != null) {
            MParticle.getInstance().Identity().modify(p10).addFailureListener((TaskFailureListener) new d(this, networkProfile)).addSuccessListener((TaskSuccessListener) new e(this));
        } else {
            B(p10);
        }
    }

    /* renamed from: b */
    public void r(String str) {
        MParticle.getInstance().Identity().login(IdentityApiRequest.withEmptyUser().customerId(str).build()).addFailureListener(new h(this, str)).addSuccessListener(new i(this));
    }

    public void c(String str, MParticle.EventType eventType, Map<String, String> map) {
        MParticle.getInstance().logEvent(new MPEvent.Builder(str, eventType).customAttributes(map).build());
    }

    public void d(String str) {
        MParticle.getInstance().logScreen(str);
        MParticle.getInstance().upload();
    }

    public void e(String str) {
        IdentityApiRequest build = IdentityApiRequest.withEmptyUser().customerId(str).build();
        if (MParticle.getInstance().Identity().getCurrentUser() != null) {
            MParticle.getInstance().Identity().modify(build).addFailureListener((TaskFailureListener) new b(this));
        } else {
            B(build);
        }
    }

    public void logout() {
        MParticle.getInstance().Identity().logout(IdentityApiRequest.withEmptyUser().build()).addFailureListener(new b(this)).addSuccessListener(new f(this));
    }

    public void setUserAttribute(String str, Object obj) {
        MParticleUser currentUser = MParticle.getInstance().Identity().getCurrentUser();
        if (currentUser != null) {
            currentUser.getUserAttributes(new c(str, obj, currentUser));
        }
    }
}
