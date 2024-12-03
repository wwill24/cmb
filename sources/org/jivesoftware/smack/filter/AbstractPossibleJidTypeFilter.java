package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.filter.AbstractJidTypeFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

public abstract class AbstractPossibleJidTypeFilter extends AbstractJidTypeFilter {

    /* renamed from: org.jivesoftware.smack.filter.AbstractPossibleJidTypeFilter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$filter$AbstractJidTypeFilter$JidType;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jivesoftware.smack.filter.AbstractJidTypeFilter$JidType[] r0 = org.jivesoftware.smack.filter.AbstractJidTypeFilter.JidType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$filter$AbstractJidTypeFilter$JidType = r0
                org.jivesoftware.smack.filter.AbstractJidTypeFilter$JidType r1 = org.jivesoftware.smack.filter.AbstractJidTypeFilter.JidType.entityFull     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$filter$AbstractJidTypeFilter$JidType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.filter.AbstractJidTypeFilter$JidType r1 = org.jivesoftware.smack.filter.AbstractJidTypeFilter.JidType.entityBare     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$filter$AbstractJidTypeFilter$JidType     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smack.filter.AbstractJidTypeFilter$JidType r1 = org.jivesoftware.smack.filter.AbstractJidTypeFilter.JidType.domainFull     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$filter$AbstractJidTypeFilter$JidType     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jivesoftware.smack.filter.AbstractJidTypeFilter$JidType r1 = org.jivesoftware.smack.filter.AbstractJidTypeFilter.JidType.domainBare     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$filter$AbstractJidTypeFilter$JidType     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jivesoftware.smack.filter.AbstractJidTypeFilter$JidType r1 = org.jivesoftware.smack.filter.AbstractJidTypeFilter.JidType.any     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.filter.AbstractPossibleJidTypeFilter.AnonymousClass1.<clinit>():void");
        }
    }

    protected AbstractPossibleJidTypeFilter(AbstractJidTypeFilter.JidType jidType) {
        super(jidType);
    }

    public final boolean accept(Stanza stanza) {
        Jid jidToInspect = getJidToInspect(stanza);
        if (jidToInspect == null) {
            return false;
        }
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$filter$AbstractJidTypeFilter$JidType[this.jidType.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 == 4 || i10 == 5) {
                        return true;
                    }
                    throw new AssertionError();
                } else if (jidToInspect.d1() != null) {
                    return true;
                } else {
                    return false;
                }
            } else if (jidToInspect.h1() != null) {
                return true;
            } else {
                return false;
            }
        } else if (jidToInspect.m1() != null) {
            return true;
        } else {
            return false;
        }
    }
}
