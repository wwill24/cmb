package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.Objects;

public final class IQTypeFilter extends FlexibleStanzaTypeFilter<IQ> {
    public static final StanzaFilter ERROR = new IQTypeFilter(IQ.Type.error);
    public static final StanzaFilter GET;
    public static final StanzaFilter GET_OR_SET;
    public static final StanzaFilter RESULT = new IQTypeFilter(IQ.Type.result);
    public static final StanzaFilter SET;
    private final IQ.Type type;

    static {
        IQTypeFilter iQTypeFilter = new IQTypeFilter(IQ.Type.get);
        GET = iQTypeFilter;
        IQTypeFilter iQTypeFilter2 = new IQTypeFilter(IQ.Type.set);
        SET = iQTypeFilter2;
        GET_OR_SET = new OrFilter(iQTypeFilter, iQTypeFilter2);
    }

    private IQTypeFilter(IQ.Type type2) {
        super(IQ.class);
        this.type = (IQ.Type) Objects.requireNonNull(type2, "Type must not be null");
    }

    public String toString() {
        return IQTypeFilter.class.getSimpleName() + ": type=" + this.type;
    }

    /* access modifiers changed from: protected */
    public boolean acceptSpecific(IQ iq) {
        return iq.getType() == this.type;
    }
}
