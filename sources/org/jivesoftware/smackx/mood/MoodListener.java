package org.jivesoftware.smackx.mood;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.mood.element.MoodElement;
import org.jxmpp.jid.EntityBareJid;

public interface MoodListener {
    void onMoodUpdated(EntityBareJid entityBareJid, MoodElement moodElement, String str, Message message);
}
