package org.jivesoftware.smackx.rsm.packet;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.hoxt.packet.Base64BinaryChunk;

public class RSMSet implements ExtensionElement {
    public static final String ELEMENT = "set";
    public static final String NAMESPACE = "http://jabber.org/protocol/rsm";
    public static final QName QNAME = new QName(NAMESPACE, "set");
    private final String after;
    private final String before;
    private final int count;
    private final int firstIndex;
    private final String firstString;
    private final int index;
    private final String last;
    private final int max;

    /* renamed from: org.jivesoftware.smackx.rsm.packet.RSMSet$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$rsm$packet$RSMSet$PageDirection;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smackx.rsm.packet.RSMSet$PageDirection[] r0 = org.jivesoftware.smackx.rsm.packet.RSMSet.PageDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smackx$rsm$packet$RSMSet$PageDirection = r0
                org.jivesoftware.smackx.rsm.packet.RSMSet$PageDirection r1 = org.jivesoftware.smackx.rsm.packet.RSMSet.PageDirection.before     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$rsm$packet$RSMSet$PageDirection     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smackx.rsm.packet.RSMSet$PageDirection r1 = org.jivesoftware.smackx.rsm.packet.RSMSet.PageDirection.after     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.rsm.packet.RSMSet.AnonymousClass1.<clinit>():void");
        }
    }

    public enum PageDirection {
        before,
        after
    }

    public RSMSet(int i10) {
        this(i10, -1);
    }

    public static RSMSet from(Stanza stanza) {
        return (RSMSet) stanza.getExtensionElement("set", NAMESPACE);
    }

    public static RSMSet newAfter(String str) {
        return new RSMSet(str, PageDirection.after);
    }

    public static RSMSet newBefore(String str) {
        return new RSMSet(str, PageDirection.before);
    }

    public String getAfter() {
        return this.after;
    }

    public String getBefore() {
        return this.before;
    }

    public int getCount() {
        return this.count;
    }

    public String getElementName() {
        return "set";
    }

    public String getFirst() {
        return this.firstString;
    }

    public int getFirstIndex() {
        return this.firstIndex;
    }

    public int getIndex() {
        return this.index;
    }

    public String getLast() {
        return this.last;
    }

    public int getMax() {
        return this.max;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public RSMSet(int i10, int i11) {
        this((String) null, (String) null, -1, i11, (String) null, i10, (String) null, -1);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("after", this.after);
        xmlStringBuilder.optElement("before", this.before);
        xmlStringBuilder.optIntElement("count", this.count);
        if (this.firstString != null) {
            xmlStringBuilder.halfOpenElement("first");
            xmlStringBuilder.optIntAttribute(FirebaseAnalytics.Param.INDEX, this.firstIndex);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append((CharSequence) this.firstString);
            xmlStringBuilder.closeElement("first");
        }
        xmlStringBuilder.optIntElement(FirebaseAnalytics.Param.INDEX, this.index);
        xmlStringBuilder.optElement(Base64BinaryChunk.ATTRIBUTE_LAST, this.last);
        xmlStringBuilder.optIntElement("max", this.max);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }

    public RSMSet(String str, PageDirection pageDirection) {
        this(-1, str, pageDirection);
    }

    public RSMSet(int i10, String str, PageDirection pageDirection) {
        int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$rsm$packet$RSMSet$PageDirection[pageDirection.ordinal()];
        if (i11 == 1) {
            this.before = str;
            this.after = null;
        } else if (i11 == 2) {
            this.before = null;
            this.after = str;
        } else {
            throw new AssertionError();
        }
        this.count = -1;
        this.index = -1;
        this.last = null;
        this.max = i10;
        this.firstString = null;
        this.firstIndex = -1;
    }

    public RSMSet(String str, String str2, int i10, int i11, String str3, int i12, String str4, int i13) {
        this.after = str;
        this.before = str2;
        this.count = i10;
        this.index = i11;
        this.last = str3;
        this.max = i12;
        this.firstString = str4;
        this.firstIndex = i13;
    }
}
