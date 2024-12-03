package org.jivesoftware.smackx.muclight.element;

import com.facebook.internal.ServerProtocol;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.MUCLightRoomConfiguration;
import org.jxmpp.jid.Jid;

public abstract class MUCLightElements {

    public static class AffiliationsChangeExtension implements ExtensionElement {
        public static final String ELEMENT = "x";
        public static final String NAMESPACE = "urn:xmpp:muclight:0#affiliations";
        public static final QName QNAME = new QName("urn:xmpp:muclight:0#affiliations", "x");
        private final HashMap<Jid, MUCLightAffiliation> affiliations;
        private final String prevVersion;
        private final String version;

        public AffiliationsChangeExtension(HashMap<Jid, MUCLightAffiliation> hashMap, String str, String str2) {
            this.affiliations = hashMap;
            this.prevVersion = str;
            this.version = str2;
        }

        public static AffiliationsChangeExtension from(Message message) {
            return (AffiliationsChangeExtension) message.getExtension(AffiliationsChangeExtension.class);
        }

        public HashMap<Jid, MUCLightAffiliation> getAffiliations() {
            return this.affiliations;
        }

        public String getElementName() {
            return "x";
        }

        public String getNamespace() {
            return "urn:xmpp:muclight:0#affiliations";
        }

        public String getPrevVersion() {
            return this.prevVersion;
        }

        public String getVersion() {
            return this.version;
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.optElement("prev-version", this.prevVersion);
            xmlStringBuilder.optElement(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.version);
            for (Map.Entry next : this.affiliations.entrySet()) {
                xmlStringBuilder.append((Element) new UserWithAffiliationElement((Jid) next.getKey(), (MUCLightAffiliation) next.getValue()));
            }
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    public static class BlockingElement implements Element {
        private Boolean allow;
        private Boolean isRoom;
        private Jid jid;

        public BlockingElement(Jid jid2, Boolean bool, Boolean bool2) {
            this.jid = jid2;
            this.allow = bool;
            this.isRoom = bool2;
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            String str;
            String str2;
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            if (this.isRoom.booleanValue()) {
                str = "room";
            } else {
                str = "user";
            }
            xmlStringBuilder.halfOpenElement(str);
            if (this.allow.booleanValue()) {
                str2 = "allow";
            } else {
                str2 = "deny";
            }
            xmlStringBuilder.attribute("action", str2);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape((CharSequence) this.jid);
            xmlStringBuilder.closeElement(str);
            return xmlStringBuilder;
        }
    }

    public static class ConfigurationElement implements Element {
        private MUCLightRoomConfiguration configuration;

        public ConfigurationElement(MUCLightRoomConfiguration mUCLightRoomConfiguration) {
            this.configuration = mUCLightRoomConfiguration;
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.openElement("configuration");
            xmlStringBuilder.element("roomname", this.configuration.getRoomName());
            xmlStringBuilder.optElement(Message.Subject.ELEMENT, this.configuration.getSubject());
            if (this.configuration.getCustomConfigs() != null) {
                for (Map.Entry next : this.configuration.getCustomConfigs().entrySet()) {
                    xmlStringBuilder.element((String) next.getKey(), (String) next.getValue());
                }
            }
            xmlStringBuilder.closeElement("configuration");
            return xmlStringBuilder;
        }
    }

    public static class ConfigurationsChangeExtension implements ExtensionElement {
        public static final String ELEMENT = "x";
        public static final String NAMESPACE = "urn:xmpp:muclight:0#configuration";
        private final HashMap<String, String> customConfigs;
        private final String prevVersion;
        private final String roomName;
        private final String subject;
        private final String version;

        public ConfigurationsChangeExtension(String str, String str2, String str3, String str4, HashMap<String, String> hashMap) {
            this.prevVersion = str;
            this.version = str2;
            this.roomName = str3;
            this.subject = str4;
            this.customConfigs = hashMap;
        }

        public static ConfigurationsChangeExtension from(Message message) {
            return (ConfigurationsChangeExtension) message.getExtensionElement("x", "urn:xmpp:muclight:0#configuration");
        }

        public HashMap<String, String> getCustomConfigs() {
            return this.customConfigs;
        }

        public String getElementName() {
            return "x";
        }

        public String getNamespace() {
            return "urn:xmpp:muclight:0#configuration";
        }

        public String getPrevVersion() {
            return this.prevVersion;
        }

        public String getRoomName() {
            return this.roomName;
        }

        public String getSubject() {
            return this.subject;
        }

        public String getVersion() {
            return this.version;
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.optElement("prev-version", this.prevVersion);
            xmlStringBuilder.optElement(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.version);
            xmlStringBuilder.optElement("roomname", this.roomName);
            xmlStringBuilder.optElement(Message.Subject.ELEMENT, this.subject);
            HashMap<String, String> hashMap = this.customConfigs;
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    xmlStringBuilder.element((String) next.getKey(), (String) next.getValue());
                }
            }
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    public static class OccupantsElement implements Element {
        private HashMap<Jid, MUCLightAffiliation> occupants;

        public OccupantsElement(HashMap<Jid, MUCLightAffiliation> hashMap) {
            this.occupants = hashMap;
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.openElement("occupants");
            for (Map.Entry next : this.occupants.entrySet()) {
                xmlStringBuilder.append((Element) new UserWithAffiliationElement((Jid) next.getKey(), (MUCLightAffiliation) next.getValue()));
            }
            xmlStringBuilder.closeElement("occupants");
            return xmlStringBuilder;
        }
    }

    public static class UserWithAffiliationElement implements Element {
        private MUCLightAffiliation affiliation;
        private Jid user;

        public UserWithAffiliationElement(Jid jid, MUCLightAffiliation mUCLightAffiliation) {
            this.user = jid;
            this.affiliation = mUCLightAffiliation;
        }

        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement("user");
            xmlStringBuilder.attribute("affiliation", (Enum<?>) this.affiliation);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape((CharSequence) this.user);
            xmlStringBuilder.closeElement("user");
            return xmlStringBuilder;
        }
    }
}
