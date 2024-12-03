package h8;

import a7.a;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.experiment.t;
import com.facebook.AccessToken;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.login.LoginResult;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.util.HashMap;
import lc.g;
import lc.l;
import org.jivesoftware.smack.sm.packet.StreamManagement;

public class f implements c {

    /* renamed from: a  reason: collision with root package name */
    private d f15417a;

    /* renamed from: b  reason: collision with root package name */
    private ConnectivityManager f15418b;

    /* renamed from: c  reason: collision with root package name */
    private t f15419c;

    /* renamed from: d  reason: collision with root package name */
    private int f15420d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15421e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15422f;

    /* renamed from: g  reason: collision with root package name */
    private String f15423g;

    /* renamed from: h  reason: collision with root package name */
    private String f15424h;

    /* renamed from: i  reason: collision with root package name */
    private String f15425i;

    /* renamed from: j  reason: collision with root package name */
    private String f15426j;

    /* renamed from: k  reason: collision with root package name */
    private a f15427k;

    /* renamed from: l  reason: collision with root package name */
    private a f15428l;

    public f(d dVar, ConnectivityManager connectivityManager, a aVar, a aVar2, t tVar) {
        this.f15417a = dVar;
        this.f15418b = connectivityManager;
        this.f15427k = aVar;
        this.f15428l = aVar2;
        this.f15419c = tVar;
    }

    private void P() {
        if (!this.f15421e) {
            this.f15421e = true;
            this.f15422f = true;
            this.f15420d++;
            this.f15417a.i0();
        }
    }

    private boolean S() {
        return this.f15418b.getActiveNetworkInfo() != null;
    }

    private void V(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(MessageTemplateConstants.Args.MESSAGE, str);
        this.f15428l.trackEvent("Facebook Login", hashMap);
    }

    private boolean W() {
        if (!g.b() || !this.f15419c.t() || l.e()) {
            return false;
        }
        return true;
    }

    private void X() {
        HashMap hashMap = new HashMap();
        hashMap.put("provider", this.f15428l.e(this.f15425i));
        hashMap.put("login attempts", String.valueOf(this.f15420d));
        hashMap.put("description shown", this.f15428l.e(this.f15424h));
        hashMap.put("assurance shown", this.f15428l.e(this.f15426j));
        hashMap.put("state", this.f15428l.e(this.f15423g));
        this.f15428l.trackEvent("Sign-up flow", hashMap);
    }

    private void Y(boolean z10) {
        String str;
        HashMap hashMap = new HashMap();
        if (z10) {
            str = AccessToken.DEFAULT_GRAPH_DOMAIN;
        } else {
            str = "phone";
        }
        hashMap.put("type", str);
        this.f15428l.trackEvent("Login Tapped", hashMap);
    }

    public void B() {
        Y(true);
        if (!S()) {
            this.f15417a.v0();
        } else {
            P();
        }
    }

    public void D() {
        if (!this.f15422f) {
            X();
        }
    }

    public void F(FacebookException facebookException) {
        this.f15423g = StreamManagement.Failed.ELEMENT;
        this.f15421e = false;
        if (((facebookException instanceof FacebookOperationCanceledException) || (facebookException instanceof FacebookAuthorizationException)) && !TextUtils.isEmpty(facebookException.getMessage()) && (facebookException.getMessage().contains("net::ERR_NAME_NOT_RESOLVED") || facebookException.getMessage().contains("Couldn't find the URL"))) {
            this.f15417a.T(R.string.error_internet_connection);
        }
        this.f15417a.D();
        this.f15427k.clear();
        this.f15417a.V();
        this.f15417a.q0(StreamManagement.Failed.ELEMENT);
        if (facebookException != null) {
            V(facebookException.getMessage());
        } else {
            V(StreamManagement.Failed.ELEMENT);
        }
    }

    public void I(Bundle bundle) {
        bundle.putBoolean("has_clicked_login", this.f15422f);
    }

    public void O(LoginResult loginResult) {
        this.f15423g = "granted";
        X();
        V("succeeded");
        this.f15427k.b(loginResult.getAccessToken());
        this.f15417a.t0();
        if (this.f15421e) {
            new Bundle().putString(AppEventsConstants.EVENT_PARAM_REGISTRATION_METHOD, "Facebook");
            this.f15421e = false;
        }
    }

    public void a() {
        this.f15425i = AccessToken.DEFAULT_GRAPH_DOMAIN;
        this.f15424h = AccessToken.DEFAULT_GRAPH_DOMAIN;
        this.f15422f = false;
    }

    public void i() {
        this.f15426j = AccessToken.DEFAULT_GRAPH_DOMAIN;
    }

    public void o() {
        this.f15420d--;
        this.f15423g = AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED;
        this.f15421e = false;
        V(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
        this.f15417a.D();
    }

    public void start() {
    }

    public void stop() {
    }

    public void v() {
        Y(false);
        if (W()) {
            this.f15417a.p0();
        } else if (!S()) {
            this.f15417a.v0();
        } else {
            this.f15417a.B();
        }
    }

    public void w(Bundle bundle) {
        if (bundle != null && bundle.containsKey("has_clicked_login")) {
            this.f15422f = bundle.getBoolean("has_clicked_login");
        }
        this.f15428l.trackEvent("Login View", new HashMap());
        this.f15428l.f("login view");
    }
}
