package org.jivesoftware.smackx.muc.bookmarkautojoin;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.bookmarks.BookmarkManager;
import org.jivesoftware.smackx.bookmarks.BookmarkedConference;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.MultiUserChatException;
import org.jivesoftware.smackx.muc.MultiUserChatManager;
import org.jxmpp.jid.parts.Resourcepart;

public final class MucBookmarkAutojoinManager extends Manager {
    private static final Map<XMPPConnection, MucBookmarkAutojoinManager> INSTANCES = new WeakHashMap();
    private static final Logger LOGGER = Logger.getLogger(MucBookmarkAutojoinManager.class.getName());
    private static boolean autojoinEnabledDefault = false;
    /* access modifiers changed from: private */
    public boolean autojoinEnabled = autojoinEnabledDefault;
    private final BookmarkManager bookmarkManager;
    private final MultiUserChatManager multiUserChatManager;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                MucBookmarkAutojoinManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private MucBookmarkAutojoinManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.multiUserChatManager = MultiUserChatManager.getInstanceFor(xMPPConnection);
        this.bookmarkManager = BookmarkManager.getBookmarkManager(xMPPConnection);
        xMPPConnection.addConnectionListener(new ConnectionListener() {
            public void authenticated(XMPPConnection xMPPConnection, boolean z10) {
                if (MucBookmarkAutojoinManager.this.autojoinEnabled) {
                    MucBookmarkAutojoinManager.this.autojoinBookmarkedConferences();
                }
            }
        });
    }

    public static synchronized MucBookmarkAutojoinManager getInstanceFor(XMPPConnection xMPPConnection) {
        MucBookmarkAutojoinManager mucBookmarkAutojoinManager;
        synchronized (MucBookmarkAutojoinManager.class) {
            Map<XMPPConnection, MucBookmarkAutojoinManager> map = INSTANCES;
            mucBookmarkAutojoinManager = map.get(xMPPConnection);
            if (mucBookmarkAutojoinManager == null) {
                mucBookmarkAutojoinManager = new MucBookmarkAutojoinManager(xMPPConnection);
                map.put(xMPPConnection, mucBookmarkAutojoinManager);
            }
        }
        return mucBookmarkAutojoinManager;
    }

    public static void setAutojoinPerDefault(boolean z10) {
        autojoinEnabledDefault = z10;
    }

    public void autojoinBookmarkedConferences() {
        try {
            List<BookmarkedConference> bookmarkedConferences = this.bookmarkManager.getBookmarkedConferences();
            Resourcepart q02 = connection().getUser().q0();
            for (BookmarkedConference next : bookmarkedConferences) {
                if (next.isAutoJoin()) {
                    Resourcepart nickname = next.getNickname();
                    if (nickname == null) {
                        nickname = q02;
                    }
                    try {
                        MultiUserChat.MucCreateConfigFormHandle createOrJoinIfNecessary = this.multiUserChatManager.getMultiUserChat(next.getJid()).createOrJoinIfNecessary(nickname, next.getPassword());
                        if (createOrJoinIfNecessary != null) {
                            createOrJoinIfNecessary.makeInstant();
                        }
                    } catch (InterruptedException | SmackException.NotConnectedException e10) {
                        LOGGER.log(Level.FINER, "Could not autojoin bookmarked MUC", e10);
                        return;
                    } catch (SmackException.NoResponseException | XMPPException.XMPPErrorException | MultiUserChatException.NotAMucServiceException e11) {
                        LOGGER.log(Level.WARNING, "Could not autojoin bookmarked MUC", e11);
                    }
                }
            }
        } catch (InterruptedException | SmackException.NotConnectedException e12) {
            LOGGER.log(Level.FINER, "Could not get MUC bookmarks", e12);
        } catch (SmackException.NoResponseException | XMPPException.XMPPErrorException e13) {
            LOGGER.log(Level.WARNING, "Could not get MUC bookmarks", e13);
        }
    }

    public void setAutojoinEnabled(boolean z10) {
        this.autojoinEnabled = z10;
    }
}
