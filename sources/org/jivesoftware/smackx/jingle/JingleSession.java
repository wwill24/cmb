package org.jivesoftware.smackx.jingle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Future;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleContent;
import org.jivesoftware.smackx.jingle.transports.JingleTransportSession;
import org.jxmpp.jid.FullJid;

public abstract class JingleSession implements JingleSessionHandler {
    protected final List<JingleContent> contents;
    protected HashSet<String> failedTransportMethods;
    protected final FullJid local;
    protected ArrayList<Future<?>> queued;
    protected final FullJid remote;
    protected final Role role;
    protected final String sid;
    protected JingleTransportSession<?> transportSession;

    /* renamed from: org.jivesoftware.smackx.jingle.JingleSession$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jivesoftware.smackx.jingle.element.JingleAction[] r0 = org.jivesoftware.smackx.jingle.element.JingleAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction = r0
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.content_accept     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.content_add     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.content_modify     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.content_reject     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.content_remove     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.description_info     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.session_info     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.security_info     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction     // Catch:{ NoSuchFieldError -> 0x006c }
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.session_accept     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.transport_accept     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.transport_info     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.session_initiate     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction     // Catch:{ NoSuchFieldError -> 0x009c }
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.transport_reject     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction     // Catch:{ NoSuchFieldError -> 0x00a8 }
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.session_terminate     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction     // Catch:{ NoSuchFieldError -> 0x00b4 }
                org.jivesoftware.smackx.jingle.element.JingleAction r1 = org.jivesoftware.smackx.jingle.element.JingleAction.transport_replace     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.jingle.JingleSession.AnonymousClass1.<clinit>():void");
        }
    }

    public JingleSession(FullJid fullJid, FullJid fullJid2, Role role2, String str) {
        this(fullJid, fullJid2, role2, str, (List<JingleContent>) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$equals$0(EqualsUtil.Builder builder, JingleSession jingleSession) {
        builder.append(getInitiator(), jingleSession.getInitiator()).append(getResponder(), jingleSession.getResponder()).append(this.sid, jingleSession.sid);
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new a(this));
    }

    public abstract XMPPConnection getConnection();

    public List<JingleContent> getContents() {
        return this.contents;
    }

    public FullJidAndSessionId getFullJidAndSessionId() {
        return new FullJidAndSessionId(this.remote, this.sid);
    }

    public FullJid getInitiator() {
        return isInitiator() ? this.local : this.remote;
    }

    public FullJid getLocal() {
        return this.local;
    }

    public FullJid getRemote() {
        return this.remote;
    }

    public FullJid getResponder() {
        return isResponder() ? this.local : this.remote;
    }

    public String getSessionId() {
        return this.sid;
    }

    public JingleTransportSession<?> getTransportSession() {
        return this.transportSession;
    }

    /* access modifiers changed from: protected */
    public IQ handleContentAccept(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    /* access modifiers changed from: protected */
    public IQ handleContentAdd(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    /* access modifiers changed from: protected */
    public IQ handleContentModify(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    /* access modifiers changed from: protected */
    public IQ handleContentReject(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    /* access modifiers changed from: protected */
    public IQ handleContentRemove(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    /* access modifiers changed from: protected */
    public IQ handleDescriptionInfo(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    public IQ handleJingleSessionRequest(Jingle jingle) {
        switch (AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[jingle.getAction().ordinal()]) {
            case 1:
                return handleContentAccept(jingle);
            case 2:
                return handleContentAdd(jingle);
            case 3:
                return handleContentModify(jingle);
            case 4:
                return handleContentReject(jingle);
            case 5:
                return handleContentRemove(jingle);
            case 6:
                return handleDescriptionInfo(jingle);
            case 7:
                return handleSessionInfo(jingle);
            case 8:
                return handleSecurityInfo(jingle);
            case 9:
                return handleSessionAccept(jingle);
            case 10:
                return handleTransportAccept(jingle);
            case 11:
                return this.transportSession.handleTransportInfo(jingle);
            case 12:
                return handleSessionInitiate(jingle);
            case 13:
                return handleTransportReject(jingle);
            case 14:
                return handleSessionTerminate(jingle);
            case 15:
                return handleTransportReplace(jingle);
            default:
                return IQ.createResultIQ(jingle);
        }
    }

    /* access modifiers changed from: protected */
    public IQ handleSecurityInfo(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    /* access modifiers changed from: protected */
    public IQ handleSessionAccept(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    /* access modifiers changed from: protected */
    public IQ handleSessionInfo(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    /* access modifiers changed from: protected */
    public IQ handleSessionInitiate(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    /* access modifiers changed from: protected */
    public IQ handleSessionTerminate(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    /* access modifiers changed from: protected */
    public IQ handleTransportAccept(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    /* access modifiers changed from: protected */
    public IQ handleTransportReject(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    /* access modifiers changed from: protected */
    public IQ handleTransportReplace(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    public int hashCode() {
        return HashCode.builder().append((Object) getInitiator()).append((Object) getResponder()).append((Object) getSessionId()).build();
    }

    public boolean isInitiator() {
        return this.role == Role.initiator;
    }

    public boolean isResponder() {
        return this.role == Role.responder;
    }

    public abstract void onTransportMethodFailed(String str);

    /* access modifiers changed from: protected */
    public void setTransportSession(JingleTransportSession<?> jingleTransportSession) {
        this.transportSession = jingleTransportSession;
    }

    public JingleSession(FullJid fullJid, FullJid fullJid2, Role role2, String str, List<JingleContent> list) {
        this.failedTransportMethods = new HashSet<>();
        ArrayList arrayList = new ArrayList();
        this.contents = arrayList;
        this.queued = new ArrayList<>();
        if (role2 == Role.initiator) {
            this.local = fullJid;
            this.remote = fullJid2;
        } else {
            this.local = fullJid2;
            this.remote = fullJid;
        }
        this.sid = str;
        this.role = role2;
        if (list != null) {
            arrayList.addAll(list);
        }
    }
}
