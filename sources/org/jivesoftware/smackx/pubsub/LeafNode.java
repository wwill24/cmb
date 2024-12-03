package org.jivesoftware.smackx.pubsub;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.pubsub.ItemsExtension;
import org.jivesoftware.smackx.pubsub.packet.PubSub;

public class LeafNode extends Node {
    LeafNode(PubSubManager pubSubManager, String str) {
        super(pubSubManager, str);
    }

    public void deleteAllItems() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        this.pubSubManager.getConnection().createStanzaCollectorAndSend(createPubsubPacket(IQ.Type.set, new NodeExtension(PubSubElementType.PURGE_OWNER, getId()))).nextResultOrThrow();
    }

    public void deleteItem(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        deleteItem((Collection<String>) arrayList);
    }

    public DiscoverItems discoverItems() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        DiscoverItems discoverItems = new DiscoverItems();
        discoverItems.setTo(this.pubSubManager.getServiceJid());
        discoverItems.setNode(getId());
        return (DiscoverItems) this.pubSubManager.getConnection().createStanzaCollectorAndSend(discoverItems).nextResultOrThrow();
    }

    public <T extends Item> List<T> getItems() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getItems((List<ExtensionElement>) null, (List<ExtensionElement>) null);
    }

    public void publish() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        this.pubSubManager.getConnection().createStanzaCollectorAndSend(createPubsubPacket(IQ.Type.set, new NodeExtension(PubSubElementType.PUBLISH, getId()))).nextResultOrThrow();
    }

    @Deprecated
    public void send() throws SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        publish();
    }

    public <T extends Item> List<T> getItems(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getItems(createPubsubPacket(IQ.Type.get, new GetItemsRequest(getId(), str)));
    }

    @Deprecated
    public <T extends Item> void send(T t10) throws SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        publish(t10);
    }

    public <T extends Item> void publish(T t10) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        ArrayList arrayList = new ArrayList(1);
        if (t10 == null) {
            t10 = new Item();
        }
        arrayList.add(t10);
        publish(arrayList);
    }

    @Deprecated
    public <T extends Item> void send(Collection<T> collection) throws SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        publish(collection);
    }

    public void deleteItem(Collection<String> collection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        ArrayList arrayList = new ArrayList(collection.size());
        for (String item : collection) {
            arrayList.add(new Item(item));
        }
        this.pubSubManager.getConnection().createStanzaCollectorAndSend(createPubsubPacket(IQ.Type.set, new ItemsExtension(ItemsExtension.ItemsElementType.retract, getId(), (List<? extends NamedElement>) arrayList))).nextResultOrThrow();
    }

    public <T extends Item> List<T> getItems(Collection<String> collection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        ArrayList arrayList = new ArrayList(collection.size());
        for (String item : collection) {
            arrayList.add(new Item(item));
        }
        return getItems(createPubsubPacket(IQ.Type.get, new ItemsExtension(ItemsExtension.ItemsElementType.items, getId(), (List<? extends NamedElement>) arrayList)));
    }

    public <T extends Item> void publish(Collection<T> collection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        this.pubSubManager.getConnection().createStanzaCollectorAndSend(createPubsubPacket(IQ.Type.set, new PublishItem(getId(), collection))).nextResultOrThrow();
    }

    public <T extends Item> List<T> getItems(int i10) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getItems(createPubsubPacket(IQ.Type.get, new GetItemsRequest(getId(), i10)));
    }

    public <T extends Item> List<T> getItems(int i10, String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getItems(createPubsubPacket(IQ.Type.get, new GetItemsRequest(getId(), str, i10)));
    }

    public <T extends Item> List<T> getItems(List<ExtensionElement> list, List<ExtensionElement> list2) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        PubSub createPubsubPacket = createPubsubPacket(IQ.Type.get, new GetItemsRequest(getId()));
        createPubsubPacket.addExtensions(list);
        return getItems(createPubsubPacket, list2);
    }

    private <T extends Item> List<T> getItems(PubSub pubSub) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getItems(pubSub, (List<ExtensionElement>) null);
    }

    private <T extends Item> List<T> getItems(PubSub pubSub, List<ExtensionElement> list) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        PubSub pubSub2 = (PubSub) this.pubSubManager.getConnection().createStanzaCollectorAndSend(pubSub).nextResultOrThrow();
        ItemsExtension itemsExtension = (ItemsExtension) pubSub2.getExtension(PubSubElementType.ITEMS);
        if (list != null) {
            list.addAll(pubSub2.getExtensions());
        }
        return itemsExtension.getItems();
    }
}
