package k7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.bakery.g1;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.feature.chat.features.ChatMediaType;
import com.coffeemeetsbagel.feature.chat.features.photoupload.api.models.ImageToSend;
import com.coffeemeetsbagel.feature.chatlist.a1;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.MessageToSend;
import com.coffeemeetsbagel.models.SavedMessage;
import com.coffeemeetsbagel.models.entities.PendingMessageEntity;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.enums.MessageStatus;
import com.coffeemeetsbagel.models.enums.MessageType;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.util.MissingCoupleIdException;
import com.uber.autodispose.m;
import com.uber.autodispose.t;
import f6.f2;
import h5.i;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import l8.h;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.mam.element.MamElements;
import r7.f;
import u6.e;

public class s implements b, h.a, h.b {

    /* renamed from: a  reason: collision with root package name */
    private final f2 f15927a;

    /* renamed from: b  reason: collision with root package name */
    private String f15928b;

    /* renamed from: c  reason: collision with root package name */
    private String f15929c;

    /* renamed from: d  reason: collision with root package name */
    private String f15930d;

    /* renamed from: e  reason: collision with root package name */
    private final List<a1> f15931e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<e> f15932f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final d7.c f15933g;

    /* renamed from: h  reason: collision with root package name */
    private final j f15934h;

    /* renamed from: i  reason: collision with root package name */
    private final ConnectivityManager f15935i;

    /* renamed from: j  reason: collision with root package name */
    private final ProfileContract$Manager f15936j;

    /* renamed from: k  reason: collision with root package name */
    private final Context f15937k;

    /* renamed from: l  reason: collision with root package name */
    private final a7.a f15938l;

    /* renamed from: m  reason: collision with root package name */
    private final h f15939m;

    /* renamed from: n  reason: collision with root package name */
    private final f f15940n;

    /* renamed from: o  reason: collision with root package name */
    private final AuthenticationScopeProvider f15941o;

    /* renamed from: p  reason: collision with root package name */
    private final e f15942p;

    class a implements h.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bagel f15943a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f15944b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MessageToSend f15945c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f15946d;

        a(Bagel bagel, String str, MessageToSend messageToSend, a aVar) {
            this.f15943a = bagel;
            this.f15944b = str;
            this.f15945c = messageToSend;
            this.f15946d = aVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(a aVar, MessageToSend messageToSend, Throwable th2) {
            aVar.o(messageToSend);
            s.this.W("text", th2);
            g1.a("chat_send_message", "is_successful", "unsuccessful");
            g1.d("chat_send_message");
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(Bagel bagel, String str, MessageToSend messageToSend, a aVar) {
            s.this.T(bagel, str, messageToSend, aVar);
            g1.a("chat_send_message", "is_successful", "successful");
            g1.d("chat_send_message");
        }

        public void a(Throwable th2) {
            fa.a.f("ChatManager", "Message not pushed successfully");
            s.this.B(new q(this, this.f15946d, this.f15945c, th2));
        }

        public void b(String str) {
            s.this.B(new r(this, this.f15943a, this.f15944b, this.f15945c, this.f15946d));
        }
    }

    class b implements h.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f15948a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ImageToSend f15949b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ChatMediaType f15950c;

        b(a aVar, ImageToSend imageToSend, ChatMediaType chatMediaType) {
            this.f15948a = aVar;
            this.f15949b = imageToSend;
            this.f15950c = chatMediaType;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(a aVar, ImageToSend imageToSend, ChatMediaType chatMediaType, Throwable th2) {
            String str;
            aVar.o(imageToSend);
            s sVar = s.this;
            if (chatMediaType == ChatMediaType.IMAGE) {
                str = "image";
            } else {
                str = "sticker";
            }
            sVar.W(str, th2);
            g1.a("chat_multimedia_send_message", "is_successful", "unsuccessful");
            g1.d("chat_multimedia_send_message");
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(a aVar, ImageToSend imageToSend, ChatMediaType chatMediaType) {
            String str;
            aVar.h0(imageToSend.getDateSent());
            s sVar = s.this;
            if (chatMediaType == ChatMediaType.IMAGE) {
                str = "image";
            } else {
                str = "sticker";
            }
            sVar.V(str);
            g1.a("chat_multimedia_send_message", "is_successful", "successful");
            g1.d("chat_multimedia_send_message");
        }

        public void a(Throwable th2) {
            s.this.B(new t(this, this.f15948a, this.f15949b, this.f15950c, th2));
        }

        public void b(String str) {
            s.this.B(new u(this, this.f15948a, this.f15949b, this.f15950c));
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15952a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.coffeemeetsbagel.feature.chat.features.ChatMediaType[] r0 = com.coffeemeetsbagel.feature.chat.features.ChatMediaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15952a = r0
                com.coffeemeetsbagel.feature.chat.features.ChatMediaType r1 = com.coffeemeetsbagel.feature.chat.features.ChatMediaType.IMAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f15952a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.feature.chat.features.ChatMediaType r1 = com.coffeemeetsbagel.feature.chat.features.ChatMediaType.STICKER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: k7.s.c.<clinit>():void");
        }
    }

    public s(Context context, f2 f2Var, d7.c cVar, ProfileContract$Manager profileContract$Manager, a7.a aVar, j jVar, ConnectivityManager connectivityManager, h hVar, f fVar, AuthenticationScopeProvider authenticationScopeProvider, e eVar) {
        this.f15937k = context;
        this.f15927a = f2Var;
        this.f15933g = cVar;
        this.f15936j = profileContract$Manager;
        this.f15938l = aVar;
        this.f15934h = jVar;
        this.f15935i = connectivityManager;
        this.f15939m = hVar;
        this.f15940n = fVar;
        this.f15941o = authenticationScopeProvider;
        this.f15942p = eVar;
    }

    /* access modifiers changed from: private */
    public void B(Runnable runnable) {
        if (F()) {
            Objects.requireNonNull(runnable);
            ((m) qj.a.w(new n(runnable)).r(new o()).F(dk.a.c()).j(com.uber.autodispose.a.a(this.f15941o))).d();
            return;
        }
        runnable.run();
    }

    private String C(Bagel bagel) {
        return bagel.getProfileId() + "_chat_session";
    }

    private boolean D() {
        NetworkInfo activeNetworkInfo = this.f15935i.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G(Bagel bagel) {
        Bakery.w().M().v(C(bagel));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(Bagel bagel, ConnectionDetails connectionDetails) {
        if (E(bagel.getId())) {
            connectionDetails.resetUnreadMessageCount();
            this.f15939m.d(bagel.getProfileId());
        }
        connectionDetails.setProfileId(bagel.getProfileId());
        R(connectionDetails);
        Y(connectionDetails, bagel);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(ConnectionDetails connectionDetails) {
        connectionDetails.resetUnreadMessageCount();
        this.f15942p.g(connectionDetails);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(Bagel bagel, CharSequence charSequence) {
        Bakery.w().M().i(C(bagel), charSequence.toString());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(boolean z10, Bagel bagel) {
        this.f15939m.i(z10, this.f15930d);
        if (bagel != null) {
            ConnectionDetails connectionDetails = bagel.getConnectionDetails();
            connectionDetails.setPairIsTyping(z10);
            Y(connectionDetails, bagel);
        }
    }

    private void O(Bagel bagel) {
        b0();
        for (a1 u02 : this.f15931e) {
            u02.u0(bagel);
        }
    }

    private void R(ConnectionDetails connectionDetails) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("connectionDetails=");
        sb2.append(connectionDetails);
        SavedMessage c02 = this.f15939m.j().c0(connectionDetails.getProfileId());
        if (c02 != null) {
            connectionDetails.setLastMessageDate(DateUtils.getFormattedDate(DateUtils.getDateFromMongooseTimestamp(c02.getTimestamp()), DateUtils.DATE_WITH_TIME_PATTERN));
            connectionDetails.setLastMessageText(c02.getMessage());
        }
        this.f15942p.g(connectionDetails);
    }

    /* access modifiers changed from: private */
    /* renamed from: S */
    public void M(String str, Bagel bagel, a aVar, Long l10) {
        b0();
        MessageToSend messageToSend = new MessageToSend(str, this.f15933g.getProfileId(), l10);
        if (!D()) {
            U(messageToSend, aVar);
            this.f15939m.m(l10);
            return;
        }
        aVar.u(messageToSend);
        g1.c("chat_send_message");
        this.f15939m.e(bagel, str, new a(bagel, str, messageToSend, aVar), l10);
    }

    /* access modifiers changed from: private */
    public void T(Bagel bagel, String str, MessageToSend messageToSend, a aVar) {
        b0();
        X(bagel, str);
        aVar.h0(messageToSend.getDateSent());
        V("text");
    }

    private void U(MessageToSend messageToSend, a aVar) {
        b0();
        messageToSend.setStatus(MessageStatus.NOT_SENT);
        aVar.v(messageToSend);
    }

    /* access modifiers changed from: private */
    public void V(String str) {
        b0();
        HashMap hashMap = new HashMap();
        hashMap.put("action", "sent");
        hashMap.put(MamElements.MamResultExtension.ELEMENT, "succeeded");
        hashMap.put("type", str);
        this.f15938l.trackEvent("Chat", hashMap);
    }

    /* access modifiers changed from: private */
    public void W(String str, Throwable th2) {
        b0();
        HashMap hashMap = new HashMap();
        hashMap.put(MamElements.MamResultExtension.ELEMENT, StreamManagement.Failed.ELEMENT);
        hashMap.put("type", str);
        hashMap.put("error_message", th2.getMessage());
        this.f15938l.trackEvent("Chat", hashMap);
    }

    private void X(Bagel bagel, String str) {
        b0();
        String formattedUtcDate = DateUtils.getFormattedUtcDate(new Date(), DateUtils.DATE_WITH_TIME_PATTERN);
        ConnectionDetails connectionDetails = bagel.getConnectionDetails();
        connectionDetails.setProfileId(bagel.getProfileId());
        connectionDetails.setLastMessageText(str);
        connectionDetails.setLastMessageDate(formattedUtcDate);
        Z(bagel);
    }

    private void Y(ConnectionDetails connectionDetails, Bagel bagel) {
        b0();
        bagel.setConnectionDetails(connectionDetails);
        this.f15934h.z(connectionDetails, bagel);
        if (E(bagel.getId())) {
            Q(bagel);
        }
        Bakery.w().q().b(EventType.CONNECTION_DETAILS_UPDATED, (Bundle) null);
    }

    private void Z(Bagel bagel) {
        b0();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("connection=");
        sb2.append(bagel);
        if (this.f15933g.isLoggedIn()) {
            if (TextUtils.isEmpty(bagel.getCoupleId())) {
                fa.a.i(new MissingCoupleIdException());
                return;
            }
            ConnectionDetails connectionDetails = bagel.getConnectionDetails();
            if (this.f15936j.j() != null) {
                connectionDetails.setLastSenderProfileId(this.f15936j.j().getId());
            }
            a0(connectionDetails, bagel);
            R(connectionDetails);
        }
    }

    private void a0(ConnectionDetails connectionDetails, Bagel bagel) {
        b0();
        this.f15942p.g(connectionDetails);
        i.b(EventType.CONNECTION_DETAILS_UPDATED);
        O(bagel);
    }

    private void b0() {
        String str;
        if (F()) {
            IllegalStateException illegalStateException = new IllegalStateException();
            StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
            if (stackTrace.length > 1) {
                str = stackTrace[1].toString();
            } else {
                str = "()";
            }
            fa.a.g("ChatManager", str + " should be in background thread.", illegalStateException);
        }
    }

    public void A() {
        e(false, (Bagel) null);
        this.f15939m.k(this);
        this.f15939m.c(this);
        f();
    }

    public boolean E(String str) {
        String str2 = this.f15928b;
        return str2 != null && str2.equals(str);
    }

    public boolean F() {
        return this.f15937k.getMainLooper().isCurrentThread();
    }

    public void P(a1 a1Var) {
        this.f15931e.remove(a1Var);
    }

    public void Q(Bagel bagel) {
        if (bagel != null) {
            ConnectionDetails connectionDetails = bagel.getConnectionDetails();
            if (!this.f15933g.isLoggedIn() || connectionDetails == null || TextUtils.isEmpty(bagel.getCoupleId())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("connectionDetails null, not updating or user logged status=");
                sb2.append(this.f15933g.isLoggedIn());
                return;
            }
            if (TextUtils.isEmpty(connectionDetails.getProfileId())) {
                connectionDetails.setProfileId(bagel.getProfileId());
            }
            B(new j(this, connectionDetails));
        }
    }

    public void a(Bagel bagel) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("clearPartialMessage: ");
        sb2.append(bagel.getProfileId());
        dk.a.c().b().b(new k(this, bagel));
    }

    public void b() {
        this.f15939m.t(this);
        this.f15939m.u(this);
    }

    public String c(Bagel bagel) {
        String k10 = Bakery.w().M().k(C(bagel));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getSavedPartialMessage: ");
        sb2.append(k10);
        return k10;
    }

    public void d(String str, Bagel bagel, a aVar, Long l10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sendMessage(): input=");
        sb2.append(str);
        if (l10 != null) {
            B(new h(this, str, bagel, aVar, l10));
            return;
        }
        ((t) this.f15939m.g(new PendingMessageEntity((Long) null, bagel.getId(), MessageStatus.SENDING, str, lc.t.e(), MessageType.CHAT)).K(dk.a.c()).E(dk.a.c()).g(com.uber.autodispose.a.a(this.f15941o))).c(new i(this, str, bagel, aVar));
    }

    public void e(boolean z10, Bagel bagel) {
        if (TextUtils.isEmpty(this.f15929c) || TextUtils.isEmpty(this.f15930d) || !D()) {
            fa.a.f("ChatManager", "Not updating pair is typing.");
        } else {
            B(new l(this, z10, bagel));
        }
    }

    public void f() {
        this.f15928b = null;
        this.f15929c = null;
    }

    public void g(Bagel bagel, CharSequence charSequence) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("savePartialMessage: ");
        sb2.append(charSequence);
        if (charSequence != null && charSequence.length() > 0) {
            dk.a.c().b().b(new m(this, bagel, charSequence));
        }
    }

    public void h(ConnectionDetails connectionDetails, Bagel bagel) {
        B(new p(this, bagel, connectionDetails));
    }

    public void i(e eVar) {
        for (e eVar2 : this.f15932f) {
            if (eVar2 == eVar) {
                return;
            }
        }
        this.f15932f.add(eVar);
    }

    public void j(e eVar) {
        this.f15932f.remove(eVar);
    }

    public void k(String str, Bagel bagel, a aVar) {
        d(str, bagel, aVar, (Long) null);
    }

    public void l(Bagel bagel) {
        this.f15928b = bagel.getId();
        this.f15929c = bagel.getCoupleId();
        this.f15930d = bagel.getProfile().getId();
    }

    public void m(String str, Bagel bagel, a aVar, ChatMediaType chatMediaType) {
        ImageToSend imageToSend;
        String str2;
        String str3;
        a aVar2 = aVar;
        ChatMediaType chatMediaType2 = chatMediaType;
        int i10 = c.f15952a[chatMediaType.ordinal()];
        if (i10 == 1) {
            imageToSend = new ImageToSend(str, bagel.getCoupleId(), Long.parseLong(this.f15936j.j().getId()), bagel.getProfileId(), false);
        } else if (i10 == 2) {
            imageToSend = new ImageToSend(str, bagel.getCoupleId(), Long.parseLong(this.f15936j.j().getId()), bagel.getProfileId(), true);
        } else {
            return;
        }
        if (chatMediaType2 == ChatMediaType.IMAGE) {
            str3 = String.format(this.f15937k.getString(R.string.bagel_sent_an_image), new Object[]{this.f15936j.j().getUserFirstName()});
            str2 = this.f15937k.getString(R.string.you_sent_an_image);
        } else {
            str3 = String.format(this.f15937k.getString(R.string.bagel_sent_a_sticker), new Object[]{this.f15936j.j().getUserFirstName()});
            str2 = this.f15937k.getString(R.string.you_sent_a_sticker);
        }
        String str4 = str2;
        String str5 = str3;
        if (!this.f15940n.d()) {
            aVar2.v(imageToSend);
            return;
        }
        g1.c("chat_multimedia_send_message");
        this.f15939m.h(bagel, str, chatMediaType, str5, str4, new b(aVar2, imageToSend, chatMediaType2));
    }

    public void z(a1 a1Var) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("listenerChatDetails=");
        sb2.append(a1Var);
        for (a1 a1Var2 : this.f15931e) {
            if (a1Var2 == a1Var) {
                return;
            }
        }
        this.f15931e.add(a1Var);
    }
}
