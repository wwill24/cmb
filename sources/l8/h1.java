package l8;

import android.app.job.JobScheduler;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.feature.authentication.LoginEvent;
import com.coffeemeetsbagel.feature.bagel.s;
import com.coffeemeetsbagel.feature.chat.features.ChatMediaType;
import com.coffeemeetsbagel.feature.mongoose.enums.RosterGroup;
import com.coffeemeetsbagel.feature.mongoose.sync.MongooseSyncJobService;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.RosterElement;
import com.coffeemeetsbagel.models.SavedMessage;
import com.coffeemeetsbagel.models.entities.PendingMessageEntity;
import com.coffeemeetsbagel.models.enums.MessageStatus;
import com.coffeemeetsbagel.models.enums.MessageType;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.services.JobServiceTypes$Types;
import com.coffeemeetsbagel.utils.model.Optional;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import d7.c;
import d7.l;
import d7.m;
import io.reactivex.subjects.PublishSubject;
import j5.x;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import l8.h;
import l8.o2;
import oc.e;
import oc.i;
import org.apache.commons.collections.map.LRUMap;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaFactory;
import org.jivesoftware.smack.packet.id.UuidStanzaIdSource;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;
import org.jivesoftware.smackx.chatstates.ChatState;
import org.jivesoftware.smackx.chatstates.packet.ChatStateExtension;
import org.jivesoftware.smackx.mam.MamManager;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.jivesoftware.smackx.time.EntityTimeManager;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.Jid;
import qj.q;
import qj.v;
import qj.w;
import qj.y;
import r7.f;

public class h1 implements h, m {

    /* renamed from: a  reason: collision with root package name */
    private final s f16091a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f16092b;

    /* renamed from: c  reason: collision with root package name */
    private final c f16093c;

    /* renamed from: d  reason: collision with root package name */
    private final hb.c f16094d;

    /* renamed from: e  reason: collision with root package name */
    private final ProfileContract$Manager f16095e;

    /* renamed from: f  reason: collision with root package name */
    private final n8.s f16096f;

    /* renamed from: g  reason: collision with root package name */
    private final r1 f16097g;

    /* renamed from: h  reason: collision with root package name */
    private final n1 f16098h;

    /* renamed from: i  reason: collision with root package name */
    private final o2 f16099i;

    /* renamed from: j  reason: collision with root package name */
    private final l f16100j;

    /* renamed from: k  reason: collision with root package name */
    private final f f16101k;

    /* renamed from: l  reason: collision with root package name */
    private final a7.a f16102l;

    /* renamed from: m  reason: collision with root package name */
    private final r f16103m;

    /* renamed from: n  reason: collision with root package name */
    private final List<h.c> f16104n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private final List<h.a> f16105o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private final List<h.b> f16106p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private final PublishSubject<Presence.Type> f16107q = PublishSubject.C0();

    /* renamed from: r  reason: collision with root package name */
    private final Map<String, MamManager.MamQuery> f16108r = new LRUMap(50);

    /* renamed from: s  reason: collision with root package name */
    private final i5.a f16109s;

    /* renamed from: t  reason: collision with root package name */
    private final StanzaFactory f16110t = new StanzaFactory(UuidStanzaIdSource.INSTANCE);

    /* renamed from: u  reason: collision with root package name */
    private boolean f16111u = true;

    /* renamed from: v  reason: collision with root package name */
    private final v f16112v = dk.a.b(Executors.newFixedThreadPool(5));

    class a implements o2.c {
        a() {
        }

        public void a(XMPPTCPConnection xMPPTCPConnection) {
            h1.this.w0(xMPPTCPConnection);
        }

        public void b(XMPPTCPConnection xMPPTCPConnection) {
            h1.this.G1(xMPPTCPConnection);
        }
    }

    class b implements StanzaListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Message f16114a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f16115b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h.d f16116c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ XMPPTCPConnection f16117d;

        b(Message message, String str, h.d dVar, XMPPTCPConnection xMPPTCPConnection) {
            this.f16114a = message;
            this.f16115b = str;
            this.f16116c = dVar;
            this.f16117d = xMPPTCPConnection;
        }

        public void processStanza(Stanza stanza) {
            if (this.f16114a == stanza) {
                Message message = new Message(this.f16114a);
                message.setStanzaId(stanza.getStanzaId());
                message.removeBody(this.f16114a.getBodies().iterator().next().getLanguage());
                message.setBody(this.f16115b);
                h1.this.J1(message, true, true);
                h.d dVar = this.f16116c;
                if (dVar != null) {
                    dVar.b(message.getStanzaId());
                }
                this.f16117d.removeStanzaInterceptor(this);
            }
        }
    }

    public h1(ProfileRepositoryV2 profileRepositoryV2, s sVar, Context context, c cVar, hb.c cVar2, ProfileContract$Manager profileContract$Manager, n8.s sVar2, o2 o2Var, l lVar, f fVar, i5.a aVar, a7.a aVar2, r rVar) {
        SmackConfiguration.DEBUG = false;
        this.f16091a = sVar;
        this.f16092b = context;
        this.f16093c = cVar;
        this.f16094d = cVar2;
        this.f16095e = profileContract$Manager;
        this.f16096f = sVar2;
        this.f16099i = o2Var;
        this.f16101k = fVar;
        this.f16109s = aVar;
        this.f16102l = aVar2;
        this.f16103m = rVar;
        this.f16097g = new r1(sVar2, lVar);
        this.f16098h = new n1(sVar2, this, context);
        this.f16100j = lVar;
        lVar.b(this);
    }

    private String A0(String str) {
        return "JID_" + str + "_LAST_SYNC_TIME";
    }

    /* access modifiers changed from: private */
    public List<Message> B0(RosterElement rosterElement) {
        return (List) this.f16099i.z().D(new m0(this, rosterElement, System.currentTimeMillis())).I(new e(3)).j();
    }

    /* access modifiers changed from: private */
    public w<Optional<MamManager.MamQuery>> D0(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getOptionalMamQueryForProfileId(): ");
        sb2.append(str);
        return this.f16099i.z().D(new l0(this, str));
    }

    private void D1(Long l10, h.d dVar, Message message) {
        if (l10 != null) {
            ((t) this.f16096f.j0(MessageStatus.SENT, l10.longValue()).K(this.f16112v).E(sj.a.a()).g(com.uber.autodispose.a.a(this.f16100j))).b(new i(dVar, message), new t(dVar));
        } else if (dVar != null) {
            dVar.b(message.getStanzaId());
        }
    }

    private SharedPreferences E0() {
        return this.f16094d.B("MONGOOSE_SYNC_JOB_SERVICE_SP");
    }

    private int E1() {
        return F1(false);
    }

    /* access modifiers changed from: private */
    public void F0(Throwable th2) {
        fa.a.g("MongooseManager", th2.toString(), th2);
    }

    private int F1(boolean z10) {
        int i10 = 5;
        if (z10) {
            i10 = Math.min(Runtime.getRuntime().availableProcessors() * 5, 30);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("queryPageSize(");
        sb2.append(z10);
        sb2.append("): ");
        sb2.append(i10);
        return i10;
    }

    /* access modifiers changed from: private */
    public void G1(XMPPConnection xMPPConnection) {
        xMPPConnection.removeAsyncStanzaListener(this.f16097g);
        Roster.getInstanceFor(xMPPConnection).removeRosterListener(this.f16098h);
    }

    private boolean H0(String str) {
        if (this.f16095e.j() == null || this.f16095e.j().getId() == null || !this.f16095e.j().getId().equals(str)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List I0(String str, XMPPTCPConnection xMPPTCPConnection) throws Exception {
        MamManager.MamQuery z02 = z0(xMPPTCPConnection, str, false);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("fetchNewestPageOfChat: ");
        sb2.append(str);
        sb2.append(" messages=");
        sb2.append(z02.getMessageCount());
        return z02.getMessages();
    }

    private void I1(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("saveLastSyncTimeForJid: ");
        sb2.append(str);
        E0().edit().putLong(A0(str), System.currentTimeMillis()).apply();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List J0(MamManager.MamQuery mamQuery, XMPPTCPConnection xMPPTCPConnection) throws Exception {
        return mamQuery.pagePrevious(F1(true));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List K0(RosterElement rosterElement, long j10, XMPPTCPConnection xMPPTCPConnection) throws Exception {
        List<Message> messages = MamManager.getInstanceFor((XMPPConnection) xMPPTCPConnection).queryArchive(C0(rosterElement)).getMessages();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\tgetNewMamMessages(");
        sb2.append(rosterElement.getJid());
        sb2.append(") - Fetched ");
        sb2.append(messages.size());
        sb2.append(" messages in ");
        sb2.append(System.currentTimeMillis() - j10);
        sb2.append("ms");
        return messages;
    }

    /* access modifiers changed from: private */
    /* renamed from: K1 */
    public List<SavedMessage> u1(List<SavedMessage> list, RosterElement rosterElement) {
        if (list != null && list.size() > 0) {
            this.f16096f.D(list, rosterElement.getProfileId());
        }
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Optional L0(String str, XMPPTCPConnection xMPPTCPConnection) throws Exception {
        return Optional.b(z0(xMPPTCPConnection, str, true));
    }

    private void L1() {
        ((p) this.f16109s.a().g(com.uber.autodispose.a.a(this.f16100j))).b(new w0(this), new d1(this));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Optional M0(Jid jid, XMPPTCPConnection xMPPTCPConnection) throws Exception {
        BareJid a10 = org.jxmpp.jid.impl.a.a(jid);
        Roster instanceFor = Roster.getInstanceFor(xMPPTCPConnection);
        if (!instanceFor.isLoaded()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\tReloading roster for ");
            sb2.append(jid);
            instanceFor.reloadAndWait();
        }
        RosterElement a11 = lc.t.a(instanceFor.getEntry(a10));
        if (a11 != null) {
            return Optional.e(a11);
        }
        return Optional.a();
    }

    private void M1(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(MamElements.MamResultExtension.ELEMENT, str2);
        hashMap.put(Presence.ELEMENT, str);
        this.f16102l.trackEvent("Chat Presence", hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N0() throws Exception {
        this.f16107q.d(Presence.Type.unavailable);
        M1("unavailable", "succeeded");
    }

    private void N1(Long l10, String str) {
        if (l10 != null) {
            this.f16096f.k0(l10, str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0(Throwable th2) throws Exception {
        F0(th2);
        M1("unavailable", StreamManagement.Failed.ELEMENT);
    }

    private void O1(Bagel bagel, RosterElement rosterElement) {
        Date date = DateUtils.getDate(bagel.getDecouplingDate());
        if (date != null && date.getTime() < System.currentTimeMillis()) {
            String groupName = rosterElement.getGroupName();
            RosterGroup rosterGroup = RosterGroup.INACTIVE;
            if (!groupName.equals(rosterGroup.a())) {
                this.f16096f.l0(bagel.getProfileId(), rosterGroup.a());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P0() throws Exception {
        this.f16107q.d(Presence.Type.available);
        M1("available", "succeeded");
        l();
    }

    /* access modifiers changed from: private */
    public w<RosterElement> P1(RosterElement rosterElement) {
        if (this.f16100j.x0() == LoginEvent.LOGOUT) {
            return w.t(new IllegalStateException("user logged out, doing nothing"));
        }
        return w.k(new n0(this, rosterElement.getProfileId(), rosterElement));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q0(Throwable th2) throws Exception {
        F0(th2);
        M1("available", StreamManagement.Failed.ELEMENT);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R0(XMPPTCPConnection xMPPTCPConnection) throws Exception {
        L1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S0(XMPPTCPConnection xMPPTCPConnection, Throwable th2) throws Exception {
        if (th2 != null) {
            F0(th2);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void T0(XMPPTCPConnection xMPPTCPConnection, Throwable th2) throws Exception {
        if (th2 != null) {
            fa.a.g("MongooseManager", th2.toString(), th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U0(Optional optional) throws Exception {
        boolean z10;
        NetworkInfo networkInfo = (NetworkInfo) optional.g();
        NetworkInfo g10 = this.f16101k.b().g();
        if (networkInfo != null) {
            if (g10 == null || !g10.isConnected()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 && networkInfo.isConnected()) {
                ((t) this.f16099i.z().g(com.uber.autodispose.a.a(this.f16100j))).e(new b0());
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void V0(Throwable th2) throws Exception {
        if (th2 != null) {
            fa.a.g("MongooseManager", th2.toString(), th2);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void W0(h.d dVar, Message message, Integer num) throws Exception {
        if (dVar != null) {
            dVar.b(message.getStanzaId());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void X0(h.d dVar, Throwable th2) throws Exception {
        if (dVar != null) {
            dVar.a(th2);
        }
        if (th2 != null) {
            fa.a.i(th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y0(String str, List list) throws Exception {
        this.f16096f.D(list, str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean Z0(MamManager.MamQuery mamQuery) throws Exception {
        if (mamQuery.isComplete() || TextUtils.isEmpty(mamQuery.getPage().getMamFinIq().getRSMSet().getFirst())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a1(String str, List list) throws Exception {
        this.f16096f.D(list, str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c1(Boolean bool) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d1(boolean z10) throws Exception {
        if (z10) {
            this.f16111u = false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean e1(String str, boolean z10) throws Exception {
        Message build = this.f16110t.buildMessageStanza().build();
        EntityBareJid g10 = lc.t.g(str);
        if (z10) {
            build.addExtension(new ChatStateExtension(ChatState.composing));
        } else {
            build.addExtension(new ChatStateExtension(ChatState.active));
            this.f16111u = true;
        }
        if (!z10 || this.f16111u) {
            ((com.uber.autodispose.m) this.f16099i.R(build, g10).j(com.uber.autodispose.a.a(this.f16100j))).f(new v0(this, z10), new d1(this));
        }
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean f1(Stanza stanza) {
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g1(Bagel bagel, String str, ChatMediaType chatMediaType, String str2, String str3, h.d dVar, XMPPTCPConnection xMPPTCPConnection) throws Exception {
        Message build = ((MessageBuilder) ((MessageBuilder) this.f16110t.buildMessageStanza().to((Jid) lc.t.g(bagel.getProfileId()))).from((Jid) lc.t.g(this.f16093c.getProfileId()))).ofType(Message.Type.chat).setBody(str).build();
        if (chatMediaType.equals(ChatMediaType.IMAGE)) {
            build.addExtensions(lc.t.h(build, MessageType.IMAGE, str2, true));
        } else if (chatMediaType.equals(ChatMediaType.STICKER)) {
            build.addExtensions(lc.t.h(build, MessageType.STICKER, str2, true));
        }
        try {
            build.addExtension(new o8.b(DateUtils.getFormattedUtcDate(DateUtils.getMillisFromUtc(EntityTimeManager.getInstanceFor(xMPPTCPConnection).getTime(xMPPTCPConnection.getXMPPServiceDomain()).getUtc(), DateUtils.DATE_WITH_TIME_PATTERN_ISO_8601_Z).longValue(), DateUtils.DATE_WITH_TIME_PATTERN_ISO_8601_Z_MS)));
        } catch (Exception unused) {
            build.addExtension(new o8.b(lc.t.e()));
        }
        xMPPTCPConnection.addStanzaInterceptor(new b(build, str3, dVar, xMPPTCPConnection), new k0());
        xMPPTCPConnection.sendStanza(build);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void h1(h.d dVar, XMPPTCPConnection xMPPTCPConnection, Throwable th2) throws Exception {
        if (th2 != null) {
            if (dVar != null) {
                dVar.a(th2);
            }
            fa.a.i(th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i1(String str, Long l10, Message message, XMPPTCPConnection xMPPTCPConnection) throws Exception {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("send message with authenticated connection SUCCESS ");
        sb2.append(str);
        sb2.append(" pendingMessageId ");
        sb2.append(l10);
        try {
            str2 = DateUtils.getFormattedUtcDate(DateUtils.getMillisFromUtc(EntityTimeManager.getInstanceFor(xMPPTCPConnection).getTime(xMPPTCPConnection.getXMPPServiceDomain()).getUtc(), DateUtils.DATE_WITH_TIME_PATTERN_ISO_8601_Z).longValue(), DateUtils.DATE_WITH_TIME_PATTERN_ISO_8601_Z_MS);
            message.addExtension(new o8.b(str2));
        } catch (Exception unused) {
            str2 = lc.t.e();
            message.addExtension(new o8.b(str2));
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("send message update pending message with time sent ");
        sb3.append(str);
        sb3.append(" pendingMessageId ");
        sb3.append(l10);
        N1(l10, str2);
        J1(message, true, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ qj.f j1(Message message, EntityBareJid entityBareJid, XMPPTCPConnection xMPPTCPConnection) throws Exception {
        return this.f16099i.R(message, entityBareJid);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k1(String str, Long l10, h.d dVar, Message message) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("send message SUCCESS ");
        sb2.append(str);
        D1(l10, dVar, message);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l1(String str, Long l10, h.d dVar, Throwable th2) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("send message FAILED ");
        sb2.append(str);
        m(l10);
        if (dVar != null) {
            dVar.a(th2);
        }
        if (th2 != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("send message FAILED ");
            sb3.append(th2.getMessage());
            fa.a.i(th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m1(Message message, XMPPTCPConnection xMPPTCPConnection) throws Exception {
        try {
            message.addExtension(new o8.b(DateUtils.getFormattedUtcDate(DateUtils.getMillisFromUtc(EntityTimeManager.getInstanceFor(xMPPTCPConnection).getTime(xMPPTCPConnection.getXMPPServiceDomain()).getUtc(), DateUtils.DATE_WITH_TIME_PATTERN_ISO_8601_Z).longValue(), DateUtils.DATE_WITH_TIME_PATTERN_ISO_8601_Z_MS)));
        } catch (Exception unused) {
            message.addExtension(new o8.b(lc.t.e()));
        }
        J1(message, false, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ qj.f n1(Message message, EntityBareJid entityBareJid, XMPPTCPConnection xMPPTCPConnection) throws Exception {
        return this.f16099i.R(message, entityBareJid);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void o1() throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean p1(String str) throws Exception {
        boolean z10;
        SavedMessage d02 = this.f16096f.d0(str);
        if (d02 == null) {
            return Boolean.TRUE;
        }
        SavedMessage b02 = this.f16096f.b0(str);
        if (b02 == null || d02.getTimestampDate() == null || d02.getTimestampDate().after(b02.getTimestampDate())) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return Boolean.TRUE;
        }
        Message build = this.f16110t.buildMessageStanza().build();
        EntityBareJid g10 = lc.t.g(this.f16093c.getProfileId());
        EntityBareJid g11 = lc.t.g(str);
        build.setFrom(g10);
        build.setTo(g11);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\tTo: ");
        sb2.append(g11);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\tFrom: ");
        sb3.append(g10);
        build.addExtension(new ChatMarkersElements.DisplayedExtension(d02.getMessageId()));
        ((com.uber.autodispose.m) this.f16099i.z().r(new c0(this, build)).w(new d0(this, build, g11)).j(com.uber.autodispose.a.a(this.f16100j))).f(new f0(), new d1(this));
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q1(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            B1();
        } else {
            C1();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r1(y yVar) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (RosterElement profileId : this.f16096f.w()) {
            EntityBareJid g10 = lc.t.g(profileId.getProfileId());
            if (g10 != null) {
                arrayList.add(g10);
            }
        }
        if (!yVar.c()) {
            yVar.onSuccess(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s1(List list) throws Exception {
        MongooseSyncJobService.D(this.f16092b, list);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void t1(List list) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Scheduled sync for jids on foreground: ");
        sb2.append(list.size());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v1(RosterElement rosterElement) throws Exception {
        I1(rosterElement.getJid());
    }

    /* access modifiers changed from: private */
    public void w0(XMPPConnection xMPPConnection) {
        Roster.getInstanceFor(xMPPConnection).addRosterListener(this.f16098h);
        xMPPConnection.addAsyncStanzaListener(this.f16097g, new m8.c());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List w1(Throwable th2) throws Exception {
        return new ArrayList();
    }

    /* access modifiers changed from: private */
    public w<List<Message>> x0(String str) {
        return this.f16099i.z().D(new o0(this, str));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x1(String str, RosterElement rosterElement, y yVar, boolean z10) {
        Bagel a02 = this.f16096f.a0(str);
        if (a02 != null) {
            O1(a02, rosterElement);
            yVar.onSuccess(rosterElement);
            return;
        }
        yVar.onError(new AssertionError("No mutableBagel found for profileId: " + str));
    }

    /* access modifiers changed from: private */
    public w<List<Message>> y0(MamManager.MamQuery mamQuery) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("fetchNextPageForMamQuery(): ");
        sb2.append(mamQuery.getPage().getMamFinIq());
        return this.f16099i.z().D(new g0(this, mamQuery));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y1(String str, RosterElement rosterElement, y yVar) throws Exception {
        Bagel a02 = this.f16096f.a0(str);
        if (a02 != null) {
            O1(a02, rosterElement);
            yVar.onSuccess(rosterElement);
            return;
        }
        this.f16091a.E(false, true, new u0(this, str, rosterElement, yVar));
    }

    private MamManager.MamQuery z0(XMPPConnection xMPPConnection, String str, boolean z10) throws XMPPException.XMPPErrorException, InterruptedException, SmackException.NotConnectedException, SmackException.NotLoggedInException, SmackException.NoResponseException {
        MamManager.MamQuery mamQuery;
        if (z10) {
            mamQuery = this.f16108r.get(str);
        } else {
            mamQuery = null;
        }
        if (mamQuery != null) {
            return mamQuery;
        }
        MamManager.MamQuery queryMostRecentPage = MamManager.getInstanceFor(xMPPConnection).queryMostRecentPage(lc.t.g(str), F1(true));
        this.f16108r.put(str, queryMostRecentPage);
        return queryMostRecentPage;
    }

    /* access modifiers changed from: private */
    public void z1(XMPPTCPConnection xMPPTCPConnection) throws SmackException.NotLoggedInException, InterruptedException, SmackException.NotConnectedException {
        Roster.getInstanceFor(xMPPTCPConnection).reload();
    }

    /* access modifiers changed from: package-private */
    public void A1() {
        for (h.c v10 : this.f16104n) {
            v10.v();
        }
    }

    /* access modifiers changed from: package-private */
    public void B1() {
        ((com.uber.autodispose.m) this.f16099i.S(Presence.Type.unavailable).b(qj.a.m()).j(com.uber.autodispose.a.a(this.f16100j))).f(new z0(this), new b1(this));
    }

    /* access modifiers changed from: package-private */
    public MamManager.MamQueryArgs C0(RosterElement rosterElement) {
        EntityBareJid g10 = lc.t.g(rosterElement.getProfileId());
        MamManager.MamQueryArgs.Builder builder = MamManager.MamQueryArgs.builder();
        builder.queryLastPage().limitResultsToJid(g10).setResultPageSize(Integer.valueOf(E1()));
        long v10 = v(rosterElement.getJid());
        if (v10 > 0) {
            Date date = new Date(v10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\tgetNewMessageQueryArgs(");
            sb2.append(rosterElement.getJid());
            sb2.append(") - messages after sync: ");
            sb2.append(date);
            builder.limitResultsSince(date);
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\tgetNewMessageQueryArgs(");
            sb3.append(rosterElement.getJid());
            sb3.append(") - ALL");
        }
        return builder.build();
    }

    /* access modifiers changed from: package-private */
    public void C1() {
        ((com.uber.autodispose.m) this.f16099i.S(Presence.Type.available).j(com.uber.autodispose.a.a(this.f16100j))).f(new x0(this), new y0(this));
    }

    public boolean G0() {
        return this.f16099i.B();
    }

    /* access modifiers changed from: package-private */
    public void H1(Callable<Boolean> callable, boolean z10) {
        int i10;
        q<R> a02 = this.f16099i.z().x(new h0(callable)).m0(this.f16112v).a0(sj.a.a());
        if (z10) {
            i10 = 10;
        } else {
            i10 = 0;
        }
        ((p) a02.g0(new j9.b(i10)).g(com.uber.autodispose.a.a(this.f16100j))).b(new i0(), new d1(this));
    }

    /* access modifiers changed from: package-private */
    public void J1(Message message, boolean z10, boolean z11) {
        String str;
        SavedMessage savedMessage = new SavedMessage();
        boolean H0 = H0(lc.t.j(message.getTo()));
        if (H0) {
            str = lc.t.j(message.getFrom());
        } else {
            str = lc.t.j(message.getTo());
        }
        savedMessage.setToMe(H0);
        savedMessage.setProfileId(str);
        savedMessage.setTimestamp(lc.t.k(message));
        String str2 = ChatMarkersElements.DisplayedExtension.ELEMENT;
        if (message.hasExtension(str2, ChatMarkersElements.NAMESPACE)) {
            savedMessage.setDisplayedMessageId(((ChatMarkersElements.DisplayedExtension) message.getExtension(str2, ChatMarkersElements.NAMESPACE)).getId());
        }
        if (message.getBodies().size() > 1) {
            for (Message.Body next : message.getBodies()) {
                if (this.f16095e.j() != null && !next.getMessage().contains(this.f16095e.j().getUserFirstName())) {
                    savedMessage.setMessage(next.getMessage());
                }
            }
        } else {
            savedMessage.setMessage(message.getBody());
        }
        savedMessage.setMessageId(message.getStanzaId());
        if (z11) {
            savedMessage.setCategory(lc.t.d(message));
            savedMessage.setUrl(lc.t.m(message));
        } else {
            savedMessage.setCategory(lc.t.c(message));
            savedMessage.setUrl(lc.t.l(message));
        }
        this.f16096f.C(savedMessage);
        this.f16094d.b("last_saved_mongoose_messages_time", System.currentTimeMillis());
    }

    public void a() {
        ((JobScheduler) this.f16092b.getSystemService("jobscheduler")).cancel(JobServiceTypes$Types.MONGOOSE_SYNC_JOB.a());
        this.f16099i.U((o2.c) null);
        if (this.f16099i.C()) {
            o2 o2Var = this.f16099i;
            Objects.requireNonNull(o2Var);
            qj.a.w(new p(o2Var)).F(this.f16112v).d();
        }
        this.f16104n.clear();
        this.f16105o.clear();
        this.f16108r.clear();
        this.f16094d.B("MONGOOSE_SYNC_JOB_SERVICE_SP").edit().clear().apply();
    }

    public void b(h.c cVar) {
        for (h.c cVar2 : this.f16104n) {
            if (cVar2 == cVar) {
                return;
            }
        }
        this.f16104n.add(cVar);
    }

    public void c(h.b bVar) {
        this.f16106p.remove(bVar);
    }

    public void d(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sendMessageDisplayed: ");
        sb2.append(str);
        H1(new e0(this, str), true);
    }

    public void e(Bagel bagel, String str, h.d dVar, Long l10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("send message ");
        sb2.append(str);
        sb2.append(" pendingMessageId ");
        sb2.append(l10);
        EntityBareJid g10 = lc.t.g(bagel.getProfileId());
        Message build = ((MessageBuilder) ((MessageBuilder) this.f16110t.buildMessageStanza().ofType(Message.Type.chat).to((Jid) g10)).from((Jid) lc.t.g(this.f16093c.getProfileId()))).setBody(str).build();
        build.addExtensions(lc.t.h(build, MessageType.CHAT, (String) null, true));
        ((com.uber.autodispose.m) this.f16099i.z().r(new q0(this, str, l10, build)).K(this.f16112v).w(new r0(this, build, g10)).z(sj.a.a()).j(com.uber.autodispose.a.a(this.f16100j))).f(new s0(this, str, l10, dVar, build), new t0(this, str, l10, dVar));
    }

    public q<List<SavedMessage>> f(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("queryForNextPageOfChat: ");
        sb2.append(str);
        return w.C(str).v(new l(this)).P().p(i.b()).B(new m()).K(new n(this)).p(x1.g()).v(new o(this, str)).m0(this.f16112v).a0(sj.a.a());
    }

    public w<Long> g(PendingMessageEntity pendingMessageEntity) {
        return this.f16096f.g0(pendingMessageEntity);
    }

    public void h(Bagel bagel, String str, ChatMediaType chatMediaType, String str2, String str3, h.d dVar) {
        ((t) this.f16099i.z().r(new y(this, bagel, str2, chatMediaType, str, str3, dVar)).K(this.f16112v).E(sj.a.a()).g(com.uber.autodispose.a.a(this.f16100j))).e(new z(dVar));
    }

    public void i(boolean z10, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sendChatState: ");
        sb2.append(z10);
        if (G0()) {
            H1(new j0(this, str, z10), false);
        }
    }

    public n8.s j() {
        return this.f16096f;
    }

    public void k(h.a aVar) {
        this.f16105o.remove(aVar);
    }

    public void l() {
        ((t) w.k(new p0(this)).K(this.f16112v).E(sj.a.a()).r(new a1(this)).g(com.uber.autodispose.a.a(this.f16100j))).b(new c1(), new d1(this));
    }

    public void m(Long l10) {
        if (l10 != null) {
            ((t) this.f16096f.j0(MessageStatus.NOT_SENT, l10.longValue()).K(this.f16112v).E(sj.a.a()).g(com.uber.autodispose.a.a(this.f16100j))).d();
        }
    }

    public q<List<SavedMessage>> n(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("queryForNewestPageOfChat: ");
        sb2.append(str);
        return w.C(str).P().K(new w(this)).p(x1.g()).v(new x(this, str)).m0(this.f16112v).a0(sj.a.a());
    }

    public w<Optional<RosterElement>> o(Jid jid) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getOptionalRosterElementFromJid(): ");
        sb2.append(jid);
        return this.f16099i.z().E(this.f16112v).D(new a0(jid));
    }

    public com.jakewharton.rxrelay2.b<x> p() {
        return this.f16096f.S();
    }

    public void q(ConnectionDetails connectionDetails, Bagel bagel) {
        for (h.b h10 : this.f16106p) {
            h10.h(connectionDetails, bagel);
        }
    }

    public void r() {
        this.f16099i.U(new a());
        ((t) this.f16099i.z().r(new q(this)).r(new r(this)).g(com.uber.autodispose.a.a(this.f16100j))).e(new s(this));
        ((p) this.f16101k.c().g(com.uber.autodispose.a.a(this.f16100j))).b(new u(this), new v());
    }

    public List<SavedMessage> s(RosterElement rosterElement) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("syncRosterElement(");
        sb2.append(rosterElement.getJid());
        sb2.append(")");
        return (List) q.V(rosterElement).K(new e1(this)).W(new f1(this)).p(x1.g()).W(new g1(this, rosterElement)).Z(qj.a.w(new j(this, rosterElement))).m0(this.f16112v).c0(new k()).h();
    }

    public void t(h.a aVar) {
        if (!this.f16105o.contains(aVar)) {
            this.f16105o.add(aVar);
        }
    }

    public void u(h.b bVar) {
        if (!this.f16106p.contains(bVar)) {
            this.f16106p.add(bVar);
        }
    }

    public long v(String str) {
        return E0().getLong(A0(str), 0);
    }
}
