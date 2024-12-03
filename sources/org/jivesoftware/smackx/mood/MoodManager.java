package org.jivesoftware.smackx.mood;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.mood.element.MoodConcretisation;
import org.jivesoftware.smackx.mood.element.MoodElement;
import org.jivesoftware.smackx.pep.PepEventListener;
import org.jivesoftware.smackx.pep.PepManager;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubException;

public final class MoodManager extends Manager {
    private static final Map<XMPPConnection, MoodManager> INSTANCES = new WeakHashMap();
    public static final String MOOD_NODE = "http://jabber.org/protocol/mood";
    private final PepManager pepManager;

    private MoodManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.pepManager = PepManager.getInstanceFor(xMPPConnection);
    }

    public static void addMoodToMessage(Message message, Mood mood) {
        addMoodToMessage(message, mood, (MoodConcretisation) null);
    }

    private static MoodElement buildMood(Mood mood, MoodConcretisation moodConcretisation, String str) {
        return new MoodElement(new MoodElement.MoodSubjectElement(mood, moodConcretisation), str);
    }

    public static synchronized MoodManager getInstanceFor(XMPPConnection xMPPConnection) {
        MoodManager moodManager;
        synchronized (MoodManager.class) {
            Map<XMPPConnection, MoodManager> map = INSTANCES;
            moodManager = map.get(xMPPConnection);
            if (moodManager == null) {
                moodManager = new MoodManager(xMPPConnection);
                map.put(xMPPConnection, moodManager);
            }
        }
        return moodManager;
    }

    private void publishMood(MoodElement moodElement) throws SmackException.NotLoggedInException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException {
        this.pepManager.publish("http://jabber.org/protocol/mood", new PayloadItem(moodElement));
    }

    public boolean addMoodListener(PepEventListener<MoodElement> pepEventListener) {
        return this.pepManager.addPepEventListener("http://jabber.org/protocol/mood", MoodElement.class, pepEventListener);
    }

    public void clearMood() throws InterruptedException, SmackException.NotLoggedInException, SmackException.NoResponseException, SmackException.NotConnectedException, XMPPException.XMPPErrorException, PubSubException.NotALeafNodeException {
        publishMood(buildMood((Mood) null, (MoodConcretisation) null, (String) null));
    }

    public boolean removeMoodListener(PepEventListener<MoodElement> pepEventListener) {
        return this.pepManager.removePepEventListener(pepEventListener);
    }

    public void setMood(Mood mood) throws InterruptedException, SmackException.NotLoggedInException, SmackException.NoResponseException, SmackException.NotConnectedException, XMPPException.XMPPErrorException, PubSubException.NotALeafNodeException {
        setMood(mood, (MoodConcretisation) null, (String) null);
    }

    public static void addMoodToMessage(Message message, Mood mood, MoodConcretisation moodConcretisation) {
        message.addExtension(buildMood(mood, moodConcretisation, (String) null));
    }

    public void setMood(Mood mood, String str) throws InterruptedException, SmackException.NotLoggedInException, SmackException.NoResponseException, SmackException.NotConnectedException, XMPPException.XMPPErrorException, PubSubException.NotALeafNodeException {
        setMood(mood, (MoodConcretisation) null, str);
    }

    public void setMood(Mood mood, MoodConcretisation moodConcretisation) throws InterruptedException, SmackException.NotLoggedInException, SmackException.NoResponseException, SmackException.NotConnectedException, XMPPException.XMPPErrorException, PubSubException.NotALeafNodeException {
        setMood(mood, moodConcretisation, (String) null);
    }

    public void setMood(Mood mood, MoodConcretisation moodConcretisation, String str) throws InterruptedException, SmackException.NotLoggedInException, SmackException.NoResponseException, SmackException.NotConnectedException, XMPPException.XMPPErrorException, PubSubException.NotALeafNodeException {
        publishMood(buildMood(mood, moodConcretisation, str));
    }
}
