package org.jivesoftware.smackx.ox.util;

import en.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.ox.OpenPgpManager;
import org.jivesoftware.smackx.ox.element.PubkeyElement;
import org.jivesoftware.smackx.ox.element.PublicKeysListElement;
import org.jivesoftware.smackx.ox.element.SecretkeyElement;
import org.jivesoftware.smackx.pep.PepManager;
import org.jivesoftware.smackx.pubsub.AccessModel;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.Node;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubException;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.form.ConfigureForm;
import org.jivesoftware.smackx.pubsub.form.FillableConfigureForm;
import org.jxmpp.jid.BareJid;

public class OpenPgpPubSubUtil {
    private static final Logger LOGGER = Logger.getLogger(OpenPgpPubSubUtil.class.getName());
    public static final String PEP_NODE_PUBLIC_KEYS = "urn:xmpp:openpgp:0:public-keys";
    public static final String PEP_NODE_PUBLIC_KEYS_NOTIFY = "urn:xmpp:openpgp:0:public-keys+notify";
    public static final String PEP_NODE_SECRET_KEY = "urn:xmpp:openpgp:0:secret-key";

    public static String PEP_NODE_PUBLIC_KEY(a aVar) {
        return "urn:xmpp:openpgp:0:public-keys:" + aVar;
    }

    public static void changeAccessModelIfNecessary(LeafNode leafNode, AccessModel accessModel) throws XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException {
        ConfigureForm nodeConfiguration = leafNode.getNodeConfiguration();
        if (nodeConfiguration.getAccessModel() != accessModel) {
            FillableConfigureForm fillableForm = nodeConfiguration.getFillableForm();
            fillableForm.setAccessModel(accessModel);
            leafNode.sendConfigurationForm(fillableForm);
        }
    }

    public static boolean deletePubkeysListNode(PepManager pepManager) throws XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException {
        return pepManager.getPepPubSubManager().deleteNode(PEP_NODE_PUBLIC_KEYS);
    }

    public static boolean deletePublicKeyNode(PepManager pepManager, a aVar) throws XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException {
        return pepManager.getPepPubSubManager().deleteNode(PEP_NODE_PUBLIC_KEY(aVar));
    }

    public static boolean deleteSecretKeyNode(PepManager pepManager) throws XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException {
        return pepManager.getPepPubSubManager().deleteNode(PEP_NODE_SECRET_KEY);
    }

    public static void depositSecretKey(XMPPConnection xMPPConnection, SecretkeyElement secretkeyElement) throws InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException, SmackException.FeatureNotSupportedException {
        if (OpenPgpManager.serverSupportsSecretKeyBackups(xMPPConnection)) {
            LeafNode orCreateLeafNode = PepManager.getInstanceFor(xMPPConnection).getPepPubSubManager().getOrCreateLeafNode(PEP_NODE_SECRET_KEY);
            changeAccessModelIfNecessary(orCreateLeafNode, AccessModel.whitelist);
            orCreateLeafNode.publish(new PayloadItem(secretkeyElement));
            return;
        }
        throw new SmackException.FeatureNotSupportedException("http://jabber.org/protocol/pubsub#access-whitelist");
    }

    public static PubkeyElement fetchPubkey(XMPPConnection xMPPConnection, BareJid bareJid, a aVar) throws InterruptedException, XMPPException.XMPPErrorException, PubSubException.NotAPubSubNodeException, PubSubException.NotALeafNodeException, SmackException.NotConnectedException, SmackException.NoResponseException {
        List items = getLeafNode(PubSubManager.getInstanceFor(xMPPConnection, bareJid), PEP_NODE_PUBLIC_KEY(aVar)).getItems(1);
        if (items.isEmpty()) {
            return null;
        }
        return (PubkeyElement) ((PayloadItem) items.get(0)).getPayload();
    }

    public static PublicKeysListElement fetchPubkeysList(XMPPConnection xMPPConnection) throws InterruptedException, XMPPException.XMPPErrorException, PubSubException.NotAPubSubNodeException, PubSubException.NotALeafNodeException, SmackException.NotConnectedException, SmackException.NoResponseException {
        return fetchPubkeysList(xMPPConnection, (BareJid) null);
    }

    public static SecretkeyElement fetchSecretKey(PepManager pepManager) throws InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException {
        List items = pepManager.getPepPubSubManager().getOrCreateLeafNode(PEP_NODE_SECRET_KEY).getItems(1);
        if (items.size() != 0) {
            return (SecretkeyElement) ((PayloadItem) items.get(0)).getPayload();
        }
        LOGGER.log(Level.INFO, "No secret key published!");
        return null;
    }

    static LeafNode getLeafNode(PubSubManager pubSubManager, String str) throws XMPPException.XMPPErrorException, PubSubException.NotALeafNodeException, InterruptedException, PubSubException.NotAPubSubNodeException, SmackException.NotConnectedException, SmackException.NoResponseException {
        try {
            return pubSubManager.getLeafNode(str);
        } catch (XMPPException.XMPPErrorException e10) {
            if (e10.getStanzaError().getCondition() == StanzaError.Condition.subscription_required) {
                return getOpenLeafNode(pubSubManager, str);
            }
            throw e10;
        }
    }

    public static LeafNode getOpenLeafNode(PubSubManager pubSubManager, String str) throws PubSubException.NotALeafNodeException {
        Class<String> cls = String.class;
        try {
            Field declaredField = pubSubManager.getClass().getDeclaredField("nodeMap");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(pubSubManager);
            Node node = (Node) map.get(str);
            if (node == null) {
                Constructor<LeafNode> declaredConstructor = LeafNode.class.getDeclaredConstructor(new Class[]{PubSubManager.class, cls});
                declaredConstructor.setAccessible(true);
                LeafNode newInstance = declaredConstructor.newInstance(new Object[]{pubSubManager, str});
                map.put(str, newInstance);
                return newInstance;
            } else if (node instanceof LeafNode) {
                return (LeafNode) node;
            } else {
                Constructor<PubSubException.NotALeafNodeException> declaredConstructor2 = PubSubException.NotALeafNodeException.class.getDeclaredConstructor(new Class[]{cls, BareJid.class});
                declaredConstructor2.setAccessible(true);
                throw declaredConstructor2.newInstance(new Object[]{str, pubSubManager.getServiceJid()});
            }
        } catch (IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e10) {
            LOGGER.log(Level.SEVERE, "Using reflections to create a LeafNode and put it into PubSubManagers nodeMap failed.", e10);
            throw new AssertionError(e10);
        }
    }

    public static void publishPublicKey(PepManager pepManager, PubkeyElement pubkeyElement, a aVar) throws InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException {
        String PEP_NODE_PUBLIC_KEY = PEP_NODE_PUBLIC_KEY(aVar);
        PubSubManager pepPubSubManager = pepManager.getPepPubSubManager();
        LeafNode orCreateLeafNode = pepPubSubManager.getOrCreateLeafNode(PEP_NODE_PUBLIC_KEY);
        AccessModel accessModel = AccessModel.open;
        changeAccessModelIfNecessary(orCreateLeafNode, accessModel);
        if (orCreateLeafNode.getItems(1).isEmpty()) {
            Logger logger = LOGGER;
            Level level = Level.FINE;
            logger.log(level, "Node " + PEP_NODE_PUBLIC_KEY + " is empty. Publish.");
            orCreateLeafNode.publish(new PayloadItem(pubkeyElement));
        } else {
            Logger logger2 = LOGGER;
            Level level2 = Level.FINE;
            logger2.log(level2, "Node " + PEP_NODE_PUBLIC_KEY + " already contains key. Skip.");
        }
        LeafNode orCreateLeafNode2 = pepPubSubManager.getOrCreateLeafNode(PEP_NODE_PUBLIC_KEYS);
        changeAccessModelIfNecessary(orCreateLeafNode2, accessModel);
        List items = orCreateLeafNode2.getItems(1);
        PublicKeysListElement.Builder builder = PublicKeysListElement.builder();
        if (!items.isEmpty() && ((PayloadItem) items.get(0)).getPayload() != null) {
            for (PublicKeysListElement.PubkeyMetadataElement addMetadata : ((PublicKeysListElement) ((PayloadItem) items.get(0)).getPayload()).getMetadata().values()) {
                builder.addMetadata(addMetadata);
            }
        }
        builder.addMetadata(new PublicKeysListElement.PubkeyMetadataElement(aVar, new Date()));
        orCreateLeafNode2.publish(new PayloadItem(builder.build()));
    }

    public static PublicKeysListElement fetchPubkeysList(XMPPConnection xMPPConnection, BareJid bareJid) throws InterruptedException, XMPPException.XMPPErrorException, SmackException.NoResponseException, PubSubException.NotALeafNodeException, SmackException.NotConnectedException, PubSubException.NotAPubSubNodeException {
        List items = getLeafNode(PubSubManager.getInstanceFor(xMPPConnection, bareJid), PEP_NODE_PUBLIC_KEYS).getItems(1);
        if (items.isEmpty()) {
            return null;
        }
        return (PublicKeysListElement) ((PayloadItem) items.get(0)).getPayload();
    }
}
