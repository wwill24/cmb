package org.jivesoftware.smackx.privacy.filter;

import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.privacy.packet.Privacy;

public final class SetDefaultListFilter extends FlexibleStanzaTypeFilter<Privacy> {
    public static final SetDefaultListFilter INSTANCE = new SetDefaultListFilter();

    private SetDefaultListFilter() {
    }

    /* access modifiers changed from: protected */
    public boolean acceptSpecific(Privacy privacy) {
        if (privacy.getType() != IQ.Type.set) {
            return false;
        }
        if (privacy.getDefaultName() != null || privacy.isDeclineDefaultList()) {
            return true;
        }
        return false;
    }
}
