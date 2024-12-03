package org.jivesoftware.smackx.jingle_filetransfer.element;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.util.Date;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.hashes.element.HashElement;
import org.jivesoftware.smackx.jingle.element.JingleContentDescriptionChildElement;

public class JingleFileTransferChild implements JingleContentDescriptionChildElement {
    public static final String ELEMENT = "file";
    public static final String ELEM_DATE = "date";
    public static final String ELEM_DESC = "desc";
    public static final String ELEM_MEDIA_TYPE = "media-type";
    public static final String ELEM_NAME = "name";
    public static final String ELEM_SIZE = "size";
    public static final String NAMESPACE = "urn:xmpp:jingle:apps:file-transfer:5";
    private final Date date;
    private final String desc;
    private final HashElement hash;
    private final String mediaType;
    private final String name;
    private final Range range;
    private final int size;

    public static final class Builder {
        private Date date;
        private String desc;
        private HashElement hash;
        private String mediaType;
        private String name;
        private Range range;
        private int size;

        public JingleFileTransferChild build() {
            return new JingleFileTransferChild(this.date, this.desc, this.hash, this.mediaType, this.name, this.size, this.range);
        }

        public Builder setDate(Date date2) {
            this.date = date2;
            return this;
        }

        public Builder setDescription(String str) {
            this.desc = str;
            return this;
        }

        public Builder setFile(File file) {
            return setDate(new Date(file.lastModified())).setName(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1)).setSize((int) file.length());
        }

        public Builder setHash(HashElement hashElement) {
            this.hash = hashElement;
            return this;
        }

        public Builder setMediaType(String str) {
            this.mediaType = str;
            return this;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setRange(Range range2) {
            this.range = range2;
            return this;
        }

        public Builder setSize(int i10) {
            this.size = i10;
            return this;
        }

        private Builder() {
        }
    }

    public JingleFileTransferChild(Date date2, String str, HashElement hashElement, String str2, String str3, int i10, Range range2) {
        this.date = date2;
        this.desc = str;
        this.hash = hashElement;
        this.mediaType = str2;
        this.name = str3;
        this.size = i10;
        this.range = range2;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public Date getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.desc;
    }

    public String getElementName() {
        return "file";
    }

    public HashElement getHash() {
        return this.hash;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public String getName() {
        return this.name;
    }

    public String getNamespace() {
        return "urn:xmpp:jingle:apps:file-transfer:5";
    }

    public Range getRange() {
        return this.range;
    }

    public int getSize() {
        return this.size;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("date", this.date);
        xmlStringBuilder.optElement("desc", this.desc);
        xmlStringBuilder.optElement(ELEM_MEDIA_TYPE, this.mediaType);
        xmlStringBuilder.optElement("name", this.name);
        xmlStringBuilder.optElement(this.range);
        int i10 = this.size;
        if (i10 > 0) {
            xmlStringBuilder.element("size", Integer.toString(i10));
        }
        xmlStringBuilder.optElement(this.hash);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
