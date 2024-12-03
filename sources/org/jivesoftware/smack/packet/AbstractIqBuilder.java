package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.AbstractIqBuilder;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.id.StanzaIdSource;
import org.jivesoftware.smack.util.ToStringUtil;

public abstract class AbstractIqBuilder<IB extends AbstractIqBuilder<IB>> extends StanzaBuilder<IB> implements IqView {
    protected IQ.Type type = IQ.Type.get;

    AbstractIqBuilder(IQ iq, String str) {
        super((Stanza) iq, str);
    }

    public static IqData createErrorResponse(IqView iqView) {
        return createResponse(iqView, IQ.ResponseType.error);
    }

    public static IqData createResponse(IqView iqView) {
        return createResponse(iqView, IQ.ResponseType.result);
    }

    /* access modifiers changed from: protected */
    public final void addStanzaSpecificAttributes(ToStringUtil.Builder builder) {
        builder.addValue("type", getType());
    }

    public final IQ.Type getType() {
        return this.type;
    }

    protected static IqData createResponse(IqView iqView, IQ.ResponseType responseType) {
        if (iqView.getType() == IQ.Type.get || iqView.getType() == IQ.Type.set) {
            IqData iqData = (IqData) StanzaBuilder.buildResponse(iqView, new a());
            iqData.ofType(responseType.getType());
            return iqData;
        }
        throw new IllegalArgumentException("IQ request must be of type 'set' or 'get'. Original IQ: " + iqView);
    }

    AbstractIqBuilder(AbstractIqBuilder<?> abstractIqBuilder) {
        super((StanzaBuilder<?>) abstractIqBuilder);
        this.type = abstractIqBuilder.type;
    }

    AbstractIqBuilder(StanzaIdSource stanzaIdSource) {
        super(stanzaIdSource);
    }

    AbstractIqBuilder(String str) {
        super(str);
    }
}
