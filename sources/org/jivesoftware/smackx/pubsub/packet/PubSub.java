package org.jivesoftware.smackx.pubsub.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.pubsub.NodeExtension;
import org.jivesoftware.smackx.pubsub.PubSubElementType;
import org.jxmpp.jid.Jid;

public class PubSub extends IQ {
    public static final String ELEMENT = "pubsub";
    public static final String NAMESPACE = "http://jabber.org/protocol/pubsub";

    public PubSub() {
        super("pubsub", "http://jabber.org/protocol/pubsub");
    }

    public static PubSub createPubsubPacket(Jid jid, IQ.Type type, NodeExtension nodeExtension) {
        PubSub pubSub = new PubSub(jid, type, nodeExtension.getPubSubNamespace());
        pubSub.addExtension(nodeExtension);
        return pubSub;
    }

    public <PE extends ExtensionElement> PE getExtension(PubSubElementType pubSubElementType) {
        return getExtensionElement(pubSubElementType.getElementName(), pubSubElementType.getNamespace().getXmlns());
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        return iQChildElementXmlStringBuilder;
    }

    public PubSub(PubSubNamespace pubSubNamespace) {
        super("pubsub", pubSubNamespace.getXmlns());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PubSub(Jid jid, IQ.Type type, PubSubNamespace pubSubNamespace) {
        super("pubsub", (pubSubNamespace == null ? PubSubNamespace.basic : pubSubNamespace).getXmlns());
        setTo(jid);
        setType(type);
    }
}
