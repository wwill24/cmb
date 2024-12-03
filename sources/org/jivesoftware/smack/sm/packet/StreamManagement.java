package org.jivesoftware.smack.sm.packet;

import com.facebook.internal.ServerProtocol;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.StanzaErrorTextElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class StreamManagement {
    public static final String NAMESPACE = "urn:xmpp:sm:3";

    private static abstract class AbstractEnable implements Nonza {
        protected int max;
        protected boolean resume;

        private AbstractEnable() {
            this.max = -1;
            this.resume = false;
        }

        public int getMaxResumptionTime() {
            return this.max;
        }

        public final String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        public boolean isResumeSet() {
            return this.resume;
        }

        /* access modifiers changed from: protected */
        public void maybeAddMaxAttributeTo(XmlStringBuilder xmlStringBuilder) {
            int i10 = this.max;
            if (i10 > 0) {
                xmlStringBuilder.attribute("max", Integer.toString(i10));
            }
        }

        /* access modifiers changed from: protected */
        public void maybeAddResumeAttributeTo(XmlStringBuilder xmlStringBuilder) {
            if (this.resume) {
                xmlStringBuilder.attribute(Resume.ELEMENT, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
        }
    }

    private static abstract class AbstractResume implements Nonza {
        private final long handledCount;
        private final String previd;

        public long getHandledCount() {
            return this.handledCount;
        }

        public final String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        public String getPrevId() {
            return this.previd;
        }

        private AbstractResume(long j10, String str) {
            this.handledCount = j10;
            this.previd = str;
        }

        public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("h", Long.toString(this.handledCount));
            xmlStringBuilder.attribute("previd", this.previd);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class AckAnswer implements Nonza {
        public static final String ELEMENT = "a";
        private final long handledCount;

        public AckAnswer(long j10) {
            this.handledCount = j10;
        }

        public String getElementName() {
            return "a";
        }

        public long getHandledCount() {
            return this.handledCount;
        }

        public String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("h", Long.toString(this.handledCount));
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static final class AckRequest implements Nonza {
        public static final String ELEMENT = "r";
        public static final AckRequest INSTANCE = new AckRequest();

        private AckRequest() {
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return "<r xmlns='urn:xmpp:sm:3'/>";
        }
    }

    public static class Enable extends AbstractEnable {
        public static final String ELEMENT = "enable";
        public static final Enable INSTANCE = new Enable();

        private Enable() {
            super();
        }

        public String getElementName() {
            return "enable";
        }

        public /* bridge */ /* synthetic */ int getMaxResumptionTime() {
            return super.getMaxResumptionTime();
        }

        public /* bridge */ /* synthetic */ boolean isResumeSet() {
            return super.isResumeSet();
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            maybeAddResumeAttributeTo(xmlStringBuilder);
            maybeAddMaxAttributeTo(xmlStringBuilder);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public Enable(boolean z10) {
            super();
            this.resume = z10;
        }

        public Enable(boolean z10, int i10) {
            this(z10);
            this.max = i10;
        }
    }

    public static class Enabled extends AbstractEnable {
        public static final String ELEMENT = "enabled";

        /* renamed from: id  reason: collision with root package name */
        private final String f24141id;
        private final String location;

        public Enabled(String str, boolean z10) {
            this(str, z10, (String) null, -1);
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getId() {
            return this.f24141id;
        }

        public String getLocation() {
            return this.location;
        }

        public /* bridge */ /* synthetic */ int getMaxResumptionTime() {
            return super.getMaxResumptionTime();
        }

        public /* bridge */ /* synthetic */ boolean isResumeSet() {
            return super.isResumeSet();
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optAttribute("id", this.f24141id);
            maybeAddResumeAttributeTo(xmlStringBuilder);
            xmlStringBuilder.optAttribute("location", this.location);
            maybeAddMaxAttributeTo(xmlStringBuilder);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public Enabled(String str, boolean z10, String str2, int i10) {
            super();
            this.f24141id = str;
            this.resume = z10;
            this.location = str2;
            this.max = i10;
        }
    }

    public static class Failed implements Nonza {
        public static final String ELEMENT = "failed";
        private final StanzaError.Condition condition;
        private final List<StanzaErrorTextElement> textElements;

        public Failed() {
            this((StanzaError.Condition) null, (List<StanzaErrorTextElement>) null);
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        public StanzaError.Condition getStanzaErrorCondition() {
            return this.condition;
        }

        public List<StanzaErrorTextElement> getTextElements() {
            return this.textElements;
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            if (this.condition != null || !this.textElements.isEmpty()) {
                if (this.condition != null) {
                    xmlStringBuilder.rightAngleBracket();
                    xmlStringBuilder.append((CharSequence) this.condition.toString());
                    xmlStringBuilder.xmlnsAttribute("urn:ietf:params:xml:ns:xmpp-stanzas");
                    xmlStringBuilder.closeEmptyElement();
                }
                xmlStringBuilder.append((Collection<? extends Element>) this.textElements);
                xmlStringBuilder.closeElement(ELEMENT);
            } else {
                xmlStringBuilder.closeEmptyElement();
            }
            return xmlStringBuilder;
        }

        public Failed(StanzaError.Condition condition2, List<StanzaErrorTextElement> list) {
            this.condition = condition2;
            if (list == null) {
                this.textElements = Collections.emptyList();
            } else {
                this.textElements = Collections.unmodifiableList(list);
            }
        }
    }

    public static class Resume extends AbstractResume {
        public static final String ELEMENT = "resume";

        public Resume(long j10, String str) {
            super(j10, str);
        }

        public String getElementName() {
            return ELEMENT;
        }

        public /* bridge */ /* synthetic */ long getHandledCount() {
            return super.getHandledCount();
        }

        public /* bridge */ /* synthetic */ String getPrevId() {
            return super.getPrevId();
        }
    }

    public static class Resumed extends AbstractResume {
        public static final String ELEMENT = "resumed";

        public Resumed(long j10, String str) {
            super(j10, str);
        }

        public String getElementName() {
            return ELEMENT;
        }

        public /* bridge */ /* synthetic */ long getHandledCount() {
            return super.getHandledCount();
        }

        public /* bridge */ /* synthetic */ String getPrevId() {
            return super.getPrevId();
        }
    }

    public static final class StreamManagementFeature implements ExtensionElement {
        public static final String ELEMENT = "sm";
        public static final StreamManagementFeature INSTANCE = new StreamManagementFeature();

        private StreamManagementFeature() {
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getNamespace() {
            return StreamManagement.NAMESPACE;
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }
}
