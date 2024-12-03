package org.jivesoftware.smackx.si.packet;

import java.util.Date;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.filetransfer.FileTransferNegotiator;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.util.XmppDateTime;

public class StreamInitiation extends IQ {
    public static final String ELEMENT = "si";
    public static final String NAMESPACE = "http://jabber.org/protocol/si";
    private Feature featureNegotiation;
    private File file;

    /* renamed from: id  reason: collision with root package name */
    private String f24228id;
    private String mimeType;

    /* renamed from: org.jivesoftware.smackx.si.packet.StreamInitiation$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.packet.IQ$Type[] r0 = org.jivesoftware.smack.packet.IQ.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = r0
                org.jivesoftware.smack.packet.IQ$Type r1 = org.jivesoftware.smack.packet.IQ.Type.set     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$packet$IQ$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.packet.IQ$Type r1 = org.jivesoftware.smack.packet.IQ.Type.result     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.si.packet.StreamInitiation.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Feature implements ExtensionElement {
        private final DataForm data;

        public Feature(DataForm dataForm) {
            this.data = dataForm;
        }

        public DataForm getData() {
            return this.data;
        }

        public String getElementName() {
            return "feature";
        }

        public String getNamespace() {
            return "http://jabber.org/protocol/feature-neg";
        }

        public String toXML(XmlEnvironment xmlEnvironment) {
            return "<feature xmlns=\"http://jabber.org/protocol/feature-neg\">" + this.data.toXML() + "</feature>";
        }
    }

    public static class File implements ExtensionElement {
        private Date date;
        private String desc;
        private String hash;
        private boolean isRanged;
        private final String name;
        private final long size;

        public File(String str, long j10) {
            if (str != null) {
                this.name = str;
                this.size = j10;
                return;
            }
            throw new NullPointerException("name cannot be null");
        }

        public Date getDate() {
            return this.date;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getElementName() {
            return "file";
        }

        public String getHash() {
            return this.hash;
        }

        public String getName() {
            return this.name;
        }

        public String getNamespace() {
            return FileTransferNegotiator.SI_PROFILE_FILE_TRANSFER_NAMESPACE;
        }

        public long getSize() {
            return this.size;
        }

        public boolean isRanged() {
            return this.isRanged;
        }

        public void setDate(Date date2) {
            this.date = date2;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setHash(String str) {
            this.hash = str;
        }

        public void setRanged(boolean z10) {
            this.isRanged = z10;
        }

        public String toXML(XmlEnvironment xmlEnvironment) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('<');
            sb2.append(getElementName());
            sb2.append(" xmlns=\"");
            sb2.append(getNamespace());
            sb2.append("\" ");
            if (getName() != null) {
                sb2.append("name=\"");
                sb2.append(StringUtils.escapeForXmlAttribute(getName()));
                sb2.append("\" ");
            }
            if (getSize() > 0) {
                sb2.append("size=\"");
                sb2.append(getSize());
                sb2.append("\" ");
            }
            if (getDate() != null) {
                sb2.append("date=\"");
                sb2.append(XmppDateTime.i(this.date));
                sb2.append("\" ");
            }
            if (getHash() != null) {
                sb2.append("hash=\"");
                sb2.append(getHash());
                sb2.append("\" ");
            }
            String str = this.desc;
            if ((str == null || str.length() <= 0) && !this.isRanged) {
                sb2.append("/>");
            } else {
                sb2.append('>');
                if (getDesc() != null && this.desc.length() > 0) {
                    sb2.append("<desc>");
                    sb2.append(StringUtils.escapeForXmlText(getDesc()));
                    sb2.append("</desc>");
                }
                if (isRanged()) {
                    sb2.append("<range/>");
                }
                sb2.append("</");
                sb2.append(getElementName());
                sb2.append('>');
            }
            return sb2.toString();
        }
    }

    public StreamInitiation() {
        super(ELEMENT, "http://jabber.org/protocol/si");
    }

    public DataForm getFeatureNegotiationForm() {
        return this.featureNegotiation.getData();
    }

    public File getFile() {
        return this.file;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[getType().ordinal()];
        if (i10 == 1) {
            iQChildElementXmlStringBuilder.optAttribute("id", getSessionID());
            iQChildElementXmlStringBuilder.optAttribute("mime-type", getMimeType());
            iQChildElementXmlStringBuilder.attribute("profile", FileTransferNegotiator.SI_PROFILE_FILE_TRANSFER_NAMESPACE);
            iQChildElementXmlStringBuilder.rightAngleBracket();
            iQChildElementXmlStringBuilder.optElement(this.file);
        } else if (i10 == 2) {
            iQChildElementXmlStringBuilder.rightAngleBracket();
        } else {
            throw new IllegalArgumentException("IQ Type not understood");
        }
        Feature feature = this.featureNegotiation;
        if (feature != null) {
            iQChildElementXmlStringBuilder.append(feature.toXML());
        }
        return iQChildElementXmlStringBuilder;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getSessionID() {
        return this.f24228id;
    }

    public void setFeatureNegotiationForm(DataForm dataForm) {
        this.featureNegotiation = new Feature(dataForm);
    }

    public void setFile(File file2) {
        this.file = file2;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setSessionID(String str) {
        this.f24228id = str;
    }
}
