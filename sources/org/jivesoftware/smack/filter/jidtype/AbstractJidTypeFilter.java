package org.jivesoftware.smack.filter.jidtype;

import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.Objects;
import org.jxmpp.jid.Jid;

public abstract class AbstractJidTypeFilter implements StanzaFilter {
    private final JidType jidType;

    /* renamed from: org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter$JidType[] r0 = org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter.JidType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType = r0
                org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter$JidType r1 = org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter.JidType.BareJid     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter$JidType r1 = org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter.JidType.DomainBareJid     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter$JidType r1 = org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter.JidType.DomainFullJid     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter$JidType r1 = org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter.JidType.EntityBareJid     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter$JidType r1 = org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter.JidType.EntityFullJid     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter$JidType r1 = org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter.JidType.EntityJid     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter$JidType r1 = org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter.JidType.FullJid     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter.AnonymousClass1.<clinit>():void");
        }
    }

    public enum JidType {
        BareJid,
        DomainBareJid,
        DomainFullJid,
        DomainJid,
        EntityBareJid,
        EntityFullJid,
        EntityJid,
        FullJid;

        public boolean isTypeOf(Jid jid) {
            if (jid == null) {
                return false;
            }
            switch (AnonymousClass1.$SwitchMap$org$jivesoftware$smack$filter$jidtype$AbstractJidTypeFilter$JidType[ordinal()]) {
                case 1:
                    return jid.G1();
                case 2:
                    return jid.f0();
                case 3:
                    return jid.j1();
                case 4:
                    return jid.t0();
                case 5:
                    return jid.B0();
                case 6:
                    return jid.W0();
                case 7:
                    return jid.R1();
                default:
                    throw new IllegalStateException();
            }
        }
    }

    protected AbstractJidTypeFilter(JidType jidType2) {
        this.jidType = (JidType) Objects.requireNonNull(jidType2, "jidType must not be null");
    }

    public boolean accept(Stanza stanza) {
        Jid jidToMatchFrom = getJidToMatchFrom(stanza);
        if (jidToMatchFrom == null) {
            return false;
        }
        return this.jidType.isTypeOf(jidToMatchFrom);
    }

    /* access modifiers changed from: protected */
    public abstract Jid getJidToMatchFrom(Stanza stanza);

    public final String toString() {
        return getClass().getSimpleName() + ": " + this.jidType;
    }
}
