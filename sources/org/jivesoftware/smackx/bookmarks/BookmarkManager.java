package org.jivesoftware.smackx.bookmarks;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.bookmarks.Bookmarks;
import org.jivesoftware.smackx.iqprivate.PrivateDataManager;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.parts.Resourcepart;

public final class BookmarkManager {
    private static final Map<XMPPConnection, BookmarkManager> bookmarkManagerMap = new WeakHashMap();
    private final Object bookmarkLock = new Object();
    private Bookmarks bookmarks;
    private final PrivateDataManager privateDataManager;

    static {
        PrivateDataManager.addPrivateDataProvider(Bookmarks.ELEMENT, Bookmarks.NAMESPACE, new Bookmarks.Provider());
    }

    private BookmarkManager(XMPPConnection xMPPConnection) {
        this.privateDataManager = PrivateDataManager.getInstanceFor(xMPPConnection);
    }

    public static synchronized BookmarkManager getBookmarkManager(XMPPConnection xMPPConnection) {
        BookmarkManager bookmarkManager;
        synchronized (BookmarkManager.class) {
            Map<XMPPConnection, BookmarkManager> map = bookmarkManagerMap;
            bookmarkManager = map.get(xMPPConnection);
            if (bookmarkManager == null) {
                bookmarkManager = new BookmarkManager(xMPPConnection);
                map.put(xMPPConnection, bookmarkManager);
            }
        }
        return bookmarkManager;
    }

    private Bookmarks retrieveBookmarks() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        Bookmarks bookmarks2;
        synchronized (this.bookmarkLock) {
            if (this.bookmarks == null) {
                this.bookmarks = (Bookmarks) this.privateDataManager.getPrivateData(Bookmarks.ELEMENT, Bookmarks.NAMESPACE);
            }
            bookmarks2 = this.bookmarks;
        }
        return bookmarks2;
    }

    public void addBookmarkedConference(String str, EntityBareJid entityBareJid, boolean z10, Resourcepart resourcepart, String str2) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        retrieveBookmarks();
        BookmarkedConference bookmarkedConference = new BookmarkedConference(str, entityBareJid, z10, resourcepart, str2);
        List<BookmarkedConference> bookmarkedConferences = this.bookmarks.getBookmarkedConferences();
        if (bookmarkedConferences.contains(bookmarkedConference)) {
            BookmarkedConference bookmarkedConference2 = bookmarkedConferences.get(bookmarkedConferences.indexOf(bookmarkedConference));
            if (!bookmarkedConference2.isShared()) {
                bookmarkedConference2.setAutoJoin(z10);
                bookmarkedConference2.setName(str);
                bookmarkedConference2.setNickname(resourcepart);
                bookmarkedConference2.setPassword(str2);
            } else {
                throw new IllegalArgumentException("Cannot modify shared bookmark");
            }
        } else {
            this.bookmarks.addBookmarkedConference(bookmarkedConference);
        }
        this.privateDataManager.setPrivateData(this.bookmarks);
    }

    public void addBookmarkedURL(String str, String str2, boolean z10) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        retrieveBookmarks();
        BookmarkedURL bookmarkedURL = new BookmarkedURL(str, str2, z10);
        List<BookmarkedURL> bookmarkedURLS = this.bookmarks.getBookmarkedURLS();
        if (bookmarkedURLS.contains(bookmarkedURL)) {
            BookmarkedURL bookmarkedURL2 = bookmarkedURLS.get(bookmarkedURLS.indexOf(bookmarkedURL));
            if (!bookmarkedURL2.isShared()) {
                bookmarkedURL2.setName(str2);
                bookmarkedURL2.setRss(z10);
            } else {
                throw new IllegalArgumentException("Cannot modify shared bookmarks");
            }
        } else {
            this.bookmarks.addBookmarkedURL(bookmarkedURL);
        }
        this.privateDataManager.setPrivateData(this.bookmarks);
    }

    public List<BookmarkedConference> getBookmarkedConferences() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        retrieveBookmarks();
        return Collections.unmodifiableList(this.bookmarks.getBookmarkedConferences());
    }

    public List<BookmarkedURL> getBookmarkedURLs() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        retrieveBookmarks();
        return Collections.unmodifiableList(this.bookmarks.getBookmarkedURLS());
    }

    public boolean isSupported() throws SmackException.NoResponseException, SmackException.NotConnectedException, XMPPException.XMPPErrorException, InterruptedException {
        return this.privateDataManager.isSupported();
    }

    public void removeBookmarkedConference(EntityBareJid entityBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        retrieveBookmarks();
        Iterator<BookmarkedConference> it = this.bookmarks.getBookmarkedConferences().iterator();
        while (it.hasNext()) {
            BookmarkedConference next = it.next();
            if (next.getJid().Y(entityBareJid)) {
                if (!next.isShared()) {
                    it.remove();
                    this.privateDataManager.setPrivateData(this.bookmarks);
                    return;
                }
                throw new IllegalArgumentException("Conference is shared and can't be removed");
            }
        }
    }

    public void removeBookmarkedURL(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        retrieveBookmarks();
        Iterator<BookmarkedURL> it = this.bookmarks.getBookmarkedURLS().iterator();
        while (it.hasNext()) {
            BookmarkedURL next = it.next();
            if (next.getURL().equalsIgnoreCase(str)) {
                if (!next.isShared()) {
                    it.remove();
                    this.privateDataManager.setPrivateData(this.bookmarks);
                    return;
                }
                throw new IllegalArgumentException("Cannot delete a shared bookmark.");
            }
        }
    }
}
