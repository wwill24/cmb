package org.jivesoftware.smack.packet;

import com.facebook.internal.ServerProtocol;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class StreamOpen implements Nonza {
    public static final String CLIENT_NAMESPACE = "jabber:client";
    public static final String ELEMENT = "stream:stream";
    public static final String SERVER_NAMESPACE = "jabber:server";
    public static final String VERSION = "1.0";
    private final String contentNamespace;
    private final String from;

    /* renamed from: id  reason: collision with root package name */
    private final String f24132id;
    private final String lang;
    private final String to;

    /* renamed from: org.jivesoftware.smack.packet.StreamOpen$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$StreamOpen$StreamContentNamespace;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.packet.StreamOpen$StreamContentNamespace[] r0 = org.jivesoftware.smack.packet.StreamOpen.StreamContentNamespace.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$packet$StreamOpen$StreamContentNamespace = r0
                org.jivesoftware.smack.packet.StreamOpen$StreamContentNamespace r1 = org.jivesoftware.smack.packet.StreamOpen.StreamContentNamespace.client     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$packet$StreamOpen$StreamContentNamespace     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.packet.StreamOpen$StreamContentNamespace r1 = org.jivesoftware.smack.packet.StreamOpen.StreamContentNamespace.server     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.packet.StreamOpen.AnonymousClass1.<clinit>():void");
        }
    }

    public enum StreamContentNamespace {
        client,
        server
    }

    public StreamOpen(CharSequence charSequence) {
        this(charSequence, (CharSequence) null, (String) null, (String) null, StreamContentNamespace.client);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return this.contentNamespace;
    }

    public StreamOpen(CharSequence charSequence, CharSequence charSequence2, String str) {
        this(charSequence, charSequence2, str, "en", StreamContentNamespace.client);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.halfOpenElement(getElementName());
        String str = "jabber:client";
        if (xmlEnvironment != null) {
            str = xmlEnvironment.getEffectiveNamespaceOrUse(str);
        }
        xmlStringBuilder.attribute("xmlns", str);
        xmlStringBuilder.attribute("to", this.to);
        xmlStringBuilder.attribute("xmlns:stream", "http://etherx.jabber.org/streams");
        xmlStringBuilder.attribute(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "1.0");
        xmlStringBuilder.optAttribute("from", this.from);
        xmlStringBuilder.optAttribute("id", this.f24132id);
        xmlStringBuilder.xmllangAttribute(this.lang);
        xmlStringBuilder.rightAngleBracket();
        return xmlStringBuilder;
    }

    public StreamOpen(CharSequence charSequence, CharSequence charSequence2, String str, String str2, StreamContentNamespace streamContentNamespace) {
        this.to = StringUtils.maybeToString(charSequence);
        this.from = StringUtils.maybeToString(charSequence2);
        this.f24132id = str;
        this.lang = str2;
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$StreamOpen$StreamContentNamespace[streamContentNamespace.ordinal()];
        if (i10 == 1) {
            this.contentNamespace = "jabber:client";
        } else if (i10 == 2) {
            this.contentNamespace = SERVER_NAMESPACE;
        } else {
            throw new IllegalStateException();
        }
    }
}
