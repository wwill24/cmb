package org.jivesoftware.smackx.receipts;

import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.MessageWithBodiesFilter;
import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jxmpp.jid.Jid;

public final class DeliveryReceiptManager extends Manager {
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(DeliveryReceiptManager.class.getName());
    private static final StanzaFilter MESSAGES_TO_REQUEST_RECEIPTS_FOR = new AndFilter(MessageTypeFilter.NORMAL_OR_CHAT_OR_HEADLINE, new NotFilter(new StanzaExtensionFilter(DeliveryReceipt.ELEMENT, "urn:xmpp:receipts")), MessageWithBodiesFilter.INSTANCE);
    private static final StanzaFilter MESSAGES_WITH_DELIVERY_RECEIPT;
    private static final StanzaFilter NON_ERROR_GROUPCHAT_MESSAGES_WITH_DELIVERY_RECEIPT_REQUEST;
    private static AutoReceiptMode defaultAutoReceiptMode = AutoReceiptMode.ifIsSubscribed;
    private static final Map<XMPPConnection, DeliveryReceiptManager> instances = new WeakHashMap();
    /* access modifiers changed from: private */
    public AutoReceiptMode autoReceiptMode = defaultAutoReceiptMode;
    /* access modifiers changed from: private */
    public final Set<ReceiptReceivedListener> receiptReceivedListeners = new CopyOnWriteArraySet();

    /* renamed from: org.jivesoftware.smackx.receipts.DeliveryReceiptManager$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.jivesoftware.smackx.receipts.DeliveryReceiptManager$AutoReceiptMode[] r0 = org.jivesoftware.smackx.receipts.DeliveryReceiptManager.AutoReceiptMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode = r0
                org.jivesoftware.smackx.receipts.DeliveryReceiptManager$AutoReceiptMode r1 = org.jivesoftware.smackx.receipts.DeliveryReceiptManager.AutoReceiptMode.disabled     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smackx.receipts.DeliveryReceiptManager$AutoReceiptMode r1 = org.jivesoftware.smackx.receipts.DeliveryReceiptManager.AutoReceiptMode.ifIsSubscribed     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smackx.receipts.DeliveryReceiptManager$AutoReceiptMode r1 = org.jivesoftware.smackx.receipts.DeliveryReceiptManager.AutoReceiptMode.always     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.receipts.DeliveryReceiptManager.AnonymousClass4.<clinit>():void");
        }
    }

    public enum AutoReceiptMode {
        disabled,
        ifIsSubscribed,
        always
    }

    static {
        StanzaTypeFilter stanzaTypeFilter = StanzaTypeFilter.MESSAGE;
        NON_ERROR_GROUPCHAT_MESSAGES_WITH_DELIVERY_RECEIPT_REQUEST = new AndFilter(stanzaTypeFilter, new StanzaExtensionFilter((ExtensionElement) new DeliveryReceiptRequest()), new NotFilter(MessageTypeFilter.ERROR));
        MESSAGES_WITH_DELIVERY_RECEIPT = new AndFilter(stanzaTypeFilter, new StanzaExtensionFilter(DeliveryReceipt.ELEMENT, "urn:xmpp:receipts"));
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                DeliveryReceiptManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private DeliveryReceiptManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("urn:xmpp:receipts");
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() {
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException {
                DeliveryReceipt from = DeliveryReceipt.from((Message) stanza);
                for (ReceiptReceivedListener onReceiptReceived : DeliveryReceiptManager.this.receiptReceivedListeners) {
                    onReceiptReceived.onReceiptReceived(stanza.getFrom(), stanza.getTo(), from.getId(), stanza);
                }
            }
        }, MESSAGES_WITH_DELIVERY_RECEIPT);
        xMPPConnection.addAsyncStanzaListener(new StanzaListener() {
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
                Jid from = stanza.getFrom();
                XMPPConnection access$100 = DeliveryReceiptManager.this.connection();
                int i10 = AnonymousClass4.$SwitchMap$org$jivesoftware$smackx$receipts$DeliveryReceiptManager$AutoReceiptMode[DeliveryReceiptManager.this.autoReceiptMode.ordinal()];
                if (i10 == 1) {
                    return;
                }
                if (i10 != 2 || Roster.getInstanceFor(access$100).isSubscribedToMyPresence(from)) {
                    Message message = (Message) stanza;
                    Message receiptMessageFor = DeliveryReceiptManager.receiptMessageFor(message);
                    if (receiptMessageFor == null) {
                        Logger access$300 = DeliveryReceiptManager.LOGGER;
                        access$300.warning("Received message stanza with receipt request from '" + from + "' without a stanza ID set. Message: " + message);
                        return;
                    }
                    access$100.sendStanza(receiptMessageFor);
                }
            }
        }, NON_ERROR_GROUPCHAT_MESSAGES_WITH_DELIVERY_RECEIPT_REQUEST);
    }

    @Deprecated
    public static String addDeliveryReceiptRequest(Message message) {
        return DeliveryReceiptRequest.addTo(message);
    }

    public static synchronized DeliveryReceiptManager getInstanceFor(XMPPConnection xMPPConnection) {
        DeliveryReceiptManager deliveryReceiptManager;
        synchronized (DeliveryReceiptManager.class) {
            Map<XMPPConnection, DeliveryReceiptManager> map = instances;
            deliveryReceiptManager = map.get(xMPPConnection);
            if (deliveryReceiptManager == null) {
                deliveryReceiptManager = new DeliveryReceiptManager(xMPPConnection);
                map.put(xMPPConnection, deliveryReceiptManager);
            }
        }
        return deliveryReceiptManager;
    }

    public static boolean hasDeliveryReceiptRequest(Message message) {
        return DeliveryReceiptRequest.from(message) != null;
    }

    public static Message receiptMessageFor(Message message) {
        String stanzaId = message.getStanzaId();
        if (StringUtils.isNullOrEmpty((CharSequence) stanzaId)) {
            return null;
        }
        return ((MessageBuilder) ((MessageBuilder) StanzaBuilder.buildMessage().ofType(message.getType()).to(message.getFrom())).addExtension(new DeliveryReceipt(stanzaId))).build();
    }

    public static void setDefaultAutoReceiptMode(AutoReceiptMode autoReceiptMode2) {
        defaultAutoReceiptMode = autoReceiptMode2;
    }

    public void addReceiptReceivedListener(ReceiptReceivedListener receiptReceivedListener) {
        this.receiptReceivedListeners.add(receiptReceivedListener);
    }

    public void autoAddDeliveryReceiptRequests() {
        connection().addMessageInterceptor(new a(), new b());
    }

    public void dontAutoAddDeliveryReceiptRequests() {
        connection().removeMessageInterceptor(new a());
    }

    public AutoReceiptMode getAutoReceiptMode() {
        return this.autoReceiptMode;
    }

    public boolean isSupported(Jid jid) throws SmackException, XMPPException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(jid, "urn:xmpp:receipts");
    }

    public void removeReceiptReceivedListener(ReceiptReceivedListener receiptReceivedListener) {
        this.receiptReceivedListeners.remove(receiptReceivedListener);
    }

    public void setAutoReceiptMode(AutoReceiptMode autoReceiptMode2) {
        this.autoReceiptMode = autoReceiptMode2;
    }
}
