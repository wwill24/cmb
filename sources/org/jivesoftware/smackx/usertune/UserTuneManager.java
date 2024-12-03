package org.jivesoftware.smackx.usertune;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pep.PepEventListener;
import org.jivesoftware.smackx.pep.PepManager;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubException;
import org.jivesoftware.smackx.usertune.element.UserTuneElement;

public final class UserTuneManager extends Manager {
    private static final Map<XMPPConnection, UserTuneManager> INSTANCES = new WeakHashMap();
    public static final String USERTUNE_NODE = "http://jabber.org/protocol/tune";
    private final PepManager pepManager;

    private UserTuneManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.pepManager = PepManager.getInstanceFor(xMPPConnection);
    }

    public static synchronized UserTuneManager getInstanceFor(XMPPConnection xMPPConnection) throws SmackException.NotLoggedInException {
        UserTuneManager userTuneManager;
        synchronized (UserTuneManager.class) {
            Map<XMPPConnection, UserTuneManager> map = INSTANCES;
            userTuneManager = map.get(xMPPConnection);
            if (userTuneManager == null) {
                userTuneManager = new UserTuneManager(xMPPConnection);
                map.put(xMPPConnection, userTuneManager);
            }
        }
        return userTuneManager;
    }

    public boolean addUserTuneListener(PepEventListener<UserTuneElement> pepEventListener) {
        return this.pepManager.addPepEventListener("http://jabber.org/protocol/tune", UserTuneElement.class, pepEventListener);
    }

    public void clearUserTune() throws SmackException.NotLoggedInException, PubSubException.NotALeafNodeException, SmackException.NoResponseException, SmackException.NotConnectedException, XMPPException.XMPPErrorException, InterruptedException {
        publishUserTune(UserTuneElement.EMPTY_USER_TUNE);
    }

    public void publishUserTune(UserTuneElement userTuneElement) throws SmackException.NotLoggedInException, PubSubException.NotALeafNodeException, SmackException.NoResponseException, SmackException.NotConnectedException, XMPPException.XMPPErrorException, InterruptedException {
        this.pepManager.publish("http://jabber.org/protocol/tune", new PayloadItem(userTuneElement));
    }

    public boolean removeUserTuneListener(PepEventListener<UserTuneElement> pepEventListener) {
        return this.pepManager.removePepEventListener(pepEventListener);
    }
}
