package org.jivesoftware.smackx.bookmarks;

import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iqprivate.packet.PrivateData;
import org.jivesoftware.smackx.iqprivate.provider.PrivateDataProvider;
import org.jxmpp.jid.parts.Resourcepart;

public class Bookmarks implements PrivateData {
    public static final String ELEMENT = "storage";
    public static final String NAMESPACE = "storage:bookmarks";
    private final List<BookmarkedConference> bookmarkedConferences = new ArrayList();
    private final List<BookmarkedURL> bookmarkedURLS = new ArrayList();

    public static class Provider implements PrivateDataProvider {
        public PrivateData parsePrivateData(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            Bookmarks bookmarks = new Bookmarks();
            boolean z10 = false;
            while (!z10) {
                XmlPullParser.Event next = xmlPullParser.next();
                XmlPullParser.Event event = XmlPullParser.Event.START_ELEMENT;
                if (next == event && "url".equals(xmlPullParser.getName())) {
                    BookmarkedURL access$000 = Bookmarks.getURLStorage(xmlPullParser);
                    if (access$000 != null) {
                        bookmarks.addBookmarkedURL(access$000);
                    }
                } else if (next == event && "conference".equals(xmlPullParser.getName())) {
                    bookmarks.addBookmarkedConference(Bookmarks.getConferenceStorage(xmlPullParser));
                } else if (next == XmlPullParser.Event.END_ELEMENT && Bookmarks.ELEMENT.equals(xmlPullParser.getName())) {
                    z10 = true;
                }
            }
            return bookmarks;
        }
    }

    /* access modifiers changed from: private */
    public static BookmarkedConference getConferenceStorage(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", "name");
        boolean z10 = false;
        boolean booleanAttribute = ParserUtils.getBooleanAttribute(xmlPullParser, "autojoin", false);
        BookmarkedConference bookmarkedConference = new BookmarkedConference(ParserUtils.getBareJidAttribute(xmlPullParser));
        bookmarkedConference.setName(attributeValue);
        bookmarkedConference.setAutoJoin(booleanAttribute);
        while (!z10) {
            XmlPullParser.Event next = xmlPullParser.next();
            XmlPullParser.Event event = XmlPullParser.Event.START_ELEMENT;
            if (next == event && "nick".equals(xmlPullParser.getName())) {
                bookmarkedConference.setNickname(Resourcepart.b(xmlPullParser.nextText()));
            } else if (next == event && "password".equals(xmlPullParser.getName())) {
                bookmarkedConference.setPassword(xmlPullParser.nextText());
            } else if (next == event && "shared_bookmark".equals(xmlPullParser.getName())) {
                bookmarkedConference.setShared(true);
            } else if (next == XmlPullParser.Event.END_ELEMENT && "conference".equals(xmlPullParser.getName())) {
                z10 = true;
            }
        }
        return bookmarkedConference;
    }

    /* access modifiers changed from: private */
    public static BookmarkedURL getURLStorage(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        boolean z10;
        String attributeValue = xmlPullParser.getAttributeValue("", "name");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "url");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "rss");
        boolean z11 = false;
        if (attributeValue3 == null || !ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(attributeValue3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        BookmarkedURL bookmarkedURL = new BookmarkedURL(attributeValue2, attributeValue, z10);
        while (!z11) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT && "shared_bookmark".equals(xmlPullParser.getName())) {
                bookmarkedURL.setShared(true);
            } else if (next == XmlPullParser.Event.END_ELEMENT && "url".equals(xmlPullParser.getName())) {
                z11 = true;
            }
        }
        return bookmarkedURL;
    }

    public void addBookmarkedConference(BookmarkedConference bookmarkedConference) {
        this.bookmarkedConferences.add(bookmarkedConference);
    }

    public void addBookmarkedURL(BookmarkedURL bookmarkedURL) {
        this.bookmarkedURLS.add(bookmarkedURL);
    }

    public void clearBookmarkedConferences() {
        this.bookmarkedConferences.clear();
    }

    public void clearBookmarkedURLS() {
        this.bookmarkedURLS.clear();
    }

    public List<BookmarkedConference> getBookmarkedConferences() {
        return this.bookmarkedConferences;
    }

    public List<BookmarkedURL> getBookmarkedURLS() {
        return this.bookmarkedURLS;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public void removeBookmarkedConference(BookmarkedConference bookmarkedConference) {
        this.bookmarkedConferences.remove(bookmarkedConference);
    }

    public void removeBookmarkedURL(BookmarkedURL bookmarkedURL) {
        this.bookmarkedURLS.remove(bookmarkedURL);
    }

    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.halfOpenElement(ELEMENT).xmlnsAttribute(NAMESPACE).rightAngleBracket();
        for (BookmarkedURL next : getBookmarkedURLS()) {
            if (!next.isShared()) {
                xmlStringBuilder.halfOpenElement("url").attribute("name", next.getName()).attribute("url", next.getURL());
                xmlStringBuilder.condAttribute(next.isRss(), "rss", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                xmlStringBuilder.closeEmptyElement();
            }
        }
        for (BookmarkedConference next2 : getBookmarkedConferences()) {
            if (!next2.isShared()) {
                xmlStringBuilder.halfOpenElement("conference");
                xmlStringBuilder.attribute("name", next2.getName());
                xmlStringBuilder.attribute("autojoin", Boolean.toString(next2.isAutoJoin()));
                xmlStringBuilder.attribute("jid", (CharSequence) next2.getJid());
                xmlStringBuilder.rightAngleBracket();
                xmlStringBuilder.optElement("nick", (CharSequence) next2.getNickname());
                xmlStringBuilder.optElement("password", next2.getPassword());
                xmlStringBuilder.closeElement("conference");
            }
        }
        xmlStringBuilder.closeElement(ELEMENT);
        return xmlStringBuilder;
    }
}
