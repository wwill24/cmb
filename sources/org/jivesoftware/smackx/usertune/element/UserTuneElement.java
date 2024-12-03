package org.jivesoftware.smackx.usertune.element;

import com.leanplum.internal.RequestBuilder;
import java.net.URI;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

public final class UserTuneElement implements ExtensionElement {
    public static final String ELEMENT = "tune";
    public static final UserTuneElement EMPTY_USER_TUNE = null;
    public static final String NAMESPACE = "http://jabber.org/protocol/tune";
    public static final QName QNAME = new QName("http://jabber.org/protocol/tune", ELEMENT);
    private final String artist;
    private final UInt16 length;
    private final Integer rating;
    private final String source;
    private final String title;
    private final String track;
    private final URI uri;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String artist;
        /* access modifiers changed from: private */
        public UInt16 length;
        /* access modifiers changed from: private */
        public Integer rating;
        /* access modifiers changed from: private */
        public String source;
        /* access modifiers changed from: private */
        public String title;
        /* access modifiers changed from: private */
        public String track;
        /* access modifiers changed from: private */
        public URI uri;

        public UserTuneElement build() {
            return new UserTuneElement(this);
        }

        public Builder setArtist(String str) {
            this.artist = str;
            return this;
        }

        public Builder setLength(int i10) {
            return setLength(UInt16.from(i10));
        }

        public Builder setRating(int i10) {
            this.rating = Integer.valueOf(i10);
            return this;
        }

        public Builder setSource(String str) {
            this.source = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setTrack(String str) {
            this.track = str;
            return this;
        }

        public Builder setUri(URI uri2) {
            this.uri = uri2;
            return this;
        }

        private Builder() {
        }

        public Builder setLength(UInt16 uInt16) {
            this.length = uInt16;
            return this;
        }
    }

    public static UserTuneElement from(Message message) {
        return (UserTuneElement) message.getExtension(UserTuneElement.class);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static boolean hasUserTuneElement(Message message) {
        return message.hasExtension((Class<? extends ExtensionElement>) UserTuneElement.class);
    }

    private boolean isEmptyUserTune() {
        return equals(EMPTY_USER_TUNE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$equals$0(EqualsUtil.Builder builder, UserTuneElement userTuneElement) {
        builder.append(this.artist, userTuneElement.artist).append(this.length, userTuneElement.length).append(this.rating, userTuneElement.rating).append(this.source, userTuneElement.source).append(this.title, userTuneElement.title).append(this.track, userTuneElement.track).append(this.uri, userTuneElement.uri);
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new a(this));
    }

    public String getArtist() {
        return this.artist;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public UInt16 getLength() {
        return this.length;
    }

    public String getNamespace() {
        return "http://jabber.org/protocol/tune";
    }

    public Integer getRating() {
        return this.rating;
    }

    public String getSource() {
        return this.source;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTrack() {
        return this.track;
    }

    public URI getUri() {
        return this.uri;
    }

    public int hashCode() {
        return HashCode.builder().append((Object) this.artist).append((Object) this.length).append((Object) this.rating).append((Object) this.source).append((Object) this.title).append((Object) this.track).append((Object) this.uri).build();
    }

    private UserTuneElement(Builder builder) {
        this.artist = builder.artist;
        this.length = builder.length;
        this.rating = builder.rating;
        this.source = builder.source;
        this.title = builder.title;
        this.track = builder.track;
        this.uri = builder.uri;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        if (isEmptyUserTune()) {
            return xmlStringBuilder.closeEmptyElement();
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("artist", this.artist);
        xmlStringBuilder.optElement(Range.ATTR_LENGTH, (CharSequence) this.length);
        xmlStringBuilder.optElement("rating", (Object) this.rating);
        xmlStringBuilder.optElement("source", this.source);
        xmlStringBuilder.optElement("title", this.title);
        xmlStringBuilder.optElement(RequestBuilder.ACTION_TRACK, this.track);
        xmlStringBuilder.optElement("uri", (Object) this.uri);
        return xmlStringBuilder.closeElement(getElementName());
    }
}
