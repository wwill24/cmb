package l8;

import androidx.annotation.NonNull;
import com.coffeemeetsbagel.bakery.g1;
import io.reactivex.subjects.SingleSubject;
import java.util.HashMap;
import java.util.Objects;
import oc.e;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.carbons.CarbonManager;
import org.jivesoftware.smackx.mam.MamManager;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.jivesoftware.smackx.mam.element.MamPrefsIQ;
import org.jivesoftware.smackx.ping.PingManager;
import org.jxmpp.jid.EntityBareJid;
import qj.b0;
import qj.w;
import qj.y;

public class o2 {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String f16175i = "o2";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a7.a f16176a;

    /* renamed from: b  reason: collision with root package name */
    private final d f16177b;

    /* renamed from: c  reason: collision with root package name */
    private final e f16178c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public PingManager f16179d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public long f16180e;

    /* renamed from: f  reason: collision with root package name */
    private final tj.a f16181f = new tj.a();

    /* renamed from: g  reason: collision with root package name */
    private SingleSubject<XMPPTCPConnection> f16182g;

    /* renamed from: h  reason: collision with root package name */
    private c f16183h;

    class a implements ConnectionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SingleSubject f16184a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SingleSubject f16185b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ XMPPTCPConnection f16186c;

        a(SingleSubject singleSubject, SingleSubject singleSubject2, XMPPTCPConnection xMPPTCPConnection) {
            this.f16184a = singleSubject;
            this.f16185b = singleSubject2;
            this.f16186c = xMPPTCPConnection;
        }

        public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
            String unused = o2.f16175i;
            g1.a("chat_authenticate", "is_successful", "successful");
            g1.d("chat_authenticate");
            this.f16185b.onSuccess((XMPPTCPConnection) xMPPConnection);
            HashMap hashMap = new HashMap();
            hashMap.put(MamElements.MamResultExtension.ELEMENT, "succeeded");
            o2.this.f16176a.trackEvent("Chat Authenticate", hashMap);
            o2.this.f16179d = PingManager.getInstanceFor(xMPPConnection);
        }

        public void connected(XMPPConnection xMPPConnection) {
            String unused = o2.f16175i;
            g1.a("chat_connect", "is_successful", "successful");
            g1.a("chat_connect", "connecting_duration", String.valueOf(o2.this.f16180e));
            g1.d("chat_connect");
            this.f16184a.onSuccess((XMPPTCPConnection) xMPPConnection);
            HashMap hashMap = new HashMap();
            hashMap.put(MamElements.MamResultExtension.ELEMENT, "succeeded");
            o2.this.f16176a.trackEvent("Chat Connect", hashMap);
        }

        public void connectionClosed() {
            String unused = o2.f16175i;
            this.f16186c.removeConnectionListener(this);
            o2.this.f16180e = 0;
        }

        public void connectionClosedOnError(Exception exc) {
            fa.a.g(o2.f16175i, "XMPP Connection closed on error.", exc);
            this.f16186c.removeConnectionListener(this);
            HashMap hashMap = new HashMap();
            hashMap.put("error_message", exc.getMessage());
            o2.this.f16176a.trackEvent("Chat Accidental Disconnect", hashMap);
            o2.this.f16180e = 0;
        }
    }

    class b implements ConnectionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ XMPPTCPConnection f16188a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ qj.c f16189b;

        b(XMPPTCPConnection xMPPTCPConnection, qj.c cVar) {
            this.f16188a = xMPPTCPConnection;
            this.f16189b = cVar;
        }

        public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
        }

        public void connected(XMPPConnection xMPPConnection) {
        }

        public void connectionClosed() {
            this.f16188a.removeConnectionListener(this);
            this.f16189b.onComplete();
        }

        public void connectionClosedOnError(Exception exc) {
            this.f16188a.removeConnectionListener(this);
            this.f16189b.onError(exc);
        }
    }

    interface c {
        void a(XMPPTCPConnection xMPPTCPConnection);

        void b(XMPPTCPConnection xMPPTCPConnection);
    }

    o2(a7.a aVar, d dVar, e eVar) {
        this.f16176a = aVar;
        this.f16177b = dVar;
        this.f16178c = eVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(XMPPTCPConnection xMPPTCPConnection, String str) throws Exception {
        xMPPTCPConnection.login(this.f16178c.d(), str, this.f16178c.f());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(Throwable th2) throws Exception {
        this.f16177b.e();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ XMPPTCPConnection F(XMPPTCPConnection xMPPTCPConnection, String str) throws Exception {
        return xMPPTCPConnection;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void G(XMPPTCPConnection xMPPTCPConnection) throws Exception {
        CarbonManager.getInstanceFor(xMPPTCPConnection).enableCarbons();
        MamManager.MamPrefsResult retrieveArchivingPreferences = MamManager.getInstanceFor((XMPPConnection) xMPPTCPConnection).retrieveArchivingPreferences();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Default MAM: ");
        sb2.append(retrieveArchivingPreferences.asMamPrefs().getDefaultBehavior());
        MamPrefsIQ.DefaultBehavior defaultBehavior = retrieveArchivingPreferences.asMamPrefs().getDefaultBehavior();
        MamPrefsIQ.DefaultBehavior defaultBehavior2 = MamPrefsIQ.DefaultBehavior.always;
        if (defaultBehavior != defaultBehavior2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Setting MAM settings to to: ");
            sb3.append(defaultBehavior2);
            MamManager.getInstanceFor((XMPPConnection) xMPPTCPConnection).enableMamForAllMessages();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(SingleSubject singleSubject, XMPPTCPConnection xMPPTCPConnection, Throwable th2) throws Exception {
        if (th2 != null) {
            String str = f16175i;
            fa.a.g(str, "Error while authenticating: " + th2.getMessage(), th2);
            HashMap hashMap = new HashMap();
            hashMap.put(MamElements.MamResultExtension.ELEMENT, StreamManagement.Failed.ELEMENT);
            hashMap.put("error_message", th2.getMessage());
            this.f16176a.trackEvent("Chat Authenticate", hashMap);
            g1.a("chat_authenticate", "is_successful", "unsuccessful");
            g1.d("chat_authenticate");
            if (!singleSubject.Y() && !singleSubject.Z()) {
                singleSubject.onError(th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(long j10, SingleSubject singleSubject, SingleSubject singleSubject2, XMPPTCPConnection xMPPTCPConnection) throws Exception {
        this.f16180e = System.currentTimeMillis() - j10;
        c cVar = this.f16183h;
        if (cVar != null) {
            cVar.a(xMPPTCPConnection);
        }
        xMPPTCPConnection.addConnectionListener(new a(singleSubject, singleSubject2, xMPPTCPConnection));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(SingleSubject singleSubject, XMPPTCPConnection xMPPTCPConnection, Throwable th2) throws Exception {
        if (th2 != null) {
            String str = f16175i;
            fa.a.g(str, "Error while connecting: " + th2.getMessage(), th2);
            g1.a("chat_connect", "is_successful", "unsuccessful");
            g1.d("chat_connect");
            HashMap hashMap = new HashMap();
            hashMap.put(MamElements.MamResultExtension.ELEMENT, StreamManagement.Failed.ELEMENT);
            hashMap.put("error_message", th2.getMessage());
            this.f16176a.trackEvent("Chat Connect", hashMap);
            if (!singleSubject.Y() && !singleSubject.Z()) {
                singleSubject.onError(th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(XMPPTCPConnection xMPPTCPConnection, qj.c cVar) throws Exception {
        xMPPTCPConnection.addConnectionListener(new b(xMPPTCPConnection, cVar));
        xMPPTCPConnection.disconnect();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ b0 M(boolean z10, Boolean bool) throws Exception {
        SingleSubject<XMPPTCPConnection> singleSubject = this.f16182g;
        if (singleSubject == null || singleSubject.Y()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getAuthenticatedConnection - create connection - ping: ");
            sb2.append(z10);
            this.f16182g = SingleSubject.W();
            w().f(this.f16182g);
            return this.f16182g;
        }
        XMPPTCPConnection X = this.f16182g.X();
        if (X != null && (!X.isConnected() || !X.isAuthenticated() || !bool.booleanValue())) {
            this.f16182g = SingleSubject.W();
            x(X).c(w()).f(this.f16182g);
        }
        return this.f16182g;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(y yVar) throws Exception {
        boolean z10;
        PingManager pingManager = this.f16179d;
        if (pingManager != null) {
            try {
                z10 = pingManager.pingMyServer();
            } catch (InterruptedException | SmackException.NotConnectedException e10) {
                yVar.onError(e10);
                fa.a.i(e10);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getAuthenticatedConnection - pingSuccess ");
            sb2.append(z10);
            yVar.onSuccess(Boolean.valueOf(z10));
        }
        z10 = false;
        StringBuilder sb22 = new StringBuilder();
        sb22.append("getAuthenticatedConnection - pingSuccess ");
        sb22.append(z10);
        yVar.onSuccess(Boolean.valueOf(z10));
    }

    private qj.a T(Stanza stanza) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Sending stanza to XMPP server: ");
        sb2.append(stanza);
        return A(true).r(new h2(stanza)).B().F(dk.a.d()).z(dk.a.d());
    }

    /* access modifiers changed from: private */
    public w<XMPPTCPConnection> t(XMPPTCPConnection xMPPTCPConnection) {
        g1.c("chat_authenticate");
        return this.f16177b.f().E(dk.a.d()).r(new y1(this, xMPPTCPConnection)).p(new f2(this)).I(new e(3)).D(new g2(xMPPTCPConnection)).K(dk.a.d());
    }

    private void u() {
        this.f16181f.e();
        this.f16177b.e();
        this.f16182g = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void L(@NonNull XMPPTCPConnection xMPPTCPConnection) {
        c cVar = this.f16183h;
        if (cVar != null) {
            cVar.b(xMPPTCPConnection);
        }
        u();
    }

    private synchronized w<XMPPTCPConnection> w() {
        SingleSubject W;
        g1.c("chat_connect");
        SingleSubject W2 = SingleSubject.W();
        W = SingleSubject.W();
        this.f16181f.a(W2.v(new l2(this)).r(new m2()).K(dk.a.d()).E(dk.a.d()).I(new e(3)).e(new n2(this, W)));
        long currentTimeMillis = System.currentTimeMillis();
        e eVar = this.f16178c;
        Objects.requireNonNull(eVar);
        this.f16181f.a(w.A(new z1(eVar)).K(dk.a.d()).E(dk.a.d()).r(new a2(this, currentTimeMillis, W2, W)).E(dk.a.d()).r(new b2()).E(dk.a.d()).I(new e(3)).e(new c2(this, W)));
        return W;
    }

    private qj.a x(@NonNull XMPPTCPConnection xMPPTCPConnection) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Disconnecting from XMPP server: ");
        sb2.append(xMPPTCPConnection.getHost());
        return qj.a.n(new d2(this, xMPPTCPConnection)).F(dk.a.d()).z(dk.a.d()).b(qj.a.w(new e2(this, xMPPTCPConnection)));
    }

    public w<XMPPTCPConnection> A(boolean z10) {
        return Q(z10).v(new i2(this, z10)).K(dk.a.d());
    }

    /* access modifiers changed from: package-private */
    public boolean B() {
        SingleSubject<XMPPTCPConnection> singleSubject = this.f16182g;
        if (singleSubject == null || singleSubject.X() == null || !this.f16182g.X().isAuthenticated()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        SingleSubject<XMPPTCPConnection> singleSubject = this.f16182g;
        if (singleSubject == null || singleSubject.X() == null || !this.f16182g.X().isConnected()) {
            return false;
        }
        return true;
    }

    public w<Boolean> Q(boolean z10) {
        if (!z10) {
            return w.C(Boolean.TRUE);
        }
        return w.k(new k2(this));
    }

    /* access modifiers changed from: package-private */
    public qj.a R(Message message, EntityBareJid entityBareJid) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Sending message: ");
        sb2.append(message);
        sb2.append(" to JID: ");
        sb2.append(entityBareJid);
        return z().r(new j2(entityBareJid, message)).B().F(dk.a.d()).z(dk.a.d());
    }

    /* access modifiers changed from: package-private */
    public qj.a S(Presence.Type type) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Sending presence to XMPP server: ");
        sb2.append(type);
        return T(new Presence(this.f16178c.b(), type));
    }

    /* access modifiers changed from: package-private */
    public void U(c cVar) {
        this.f16183h = cVar;
    }

    public void y() {
        SingleSubject<XMPPTCPConnection> singleSubject = this.f16182g;
        if (singleSubject == null || singleSubject.X() == null) {
            u();
            return;
        }
        XMPPTCPConnection X = this.f16182g.X();
        X.disconnect();
        L(X);
    }

    public w<XMPPTCPConnection> z() {
        return A(false);
    }
}
