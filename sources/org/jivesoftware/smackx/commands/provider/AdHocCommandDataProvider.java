package org.jivesoftware.smackx.commands.provider;

import com.coffeemeetsbagel.models.util.FacebookParse;
import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.commands.AdHocCommand;
import org.jivesoftware.smackx.commands.AdHocCommandNote;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jivesoftware.smackx.xdata.provider.DataFormProvider;

public class AdHocCommandDataProvider extends IQProvider<AdHocCommandData> {

    public static class BadActionError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.badAction);
        }
    }

    public static class BadLocaleError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.badLocale);
        }
    }

    public static class BadPayloadError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.badPayload);
        }
    }

    public static class BadSessionIDError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.badSessionid);
        }
    }

    public static class MalformedActionError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.malformedAction);
        }
    }

    public static class SessionExpiredError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.sessionExpired);
        }
    }

    public AdHocCommandData parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        AdHocCommandNote.Type type;
        AdHocCommandData adHocCommandData = new AdHocCommandData();
        DataFormProvider dataFormProvider = new DataFormProvider();
        adHocCommandData.setSessionID(xmlPullParser.getAttributeValue("", "sessionid"));
        adHocCommandData.setNode(xmlPullParser.getAttributeValue("", NodeElement.ELEMENT));
        String attributeValue = xmlPullParser.getAttributeValue("", "status");
        AdHocCommand.Status status = AdHocCommand.Status.executing;
        if (status.toString().equalsIgnoreCase(attributeValue)) {
            adHocCommandData.setStatus(status);
        } else {
            AdHocCommand.Status status2 = AdHocCommand.Status.completed;
            if (status2.toString().equalsIgnoreCase(attributeValue)) {
                adHocCommandData.setStatus(status2);
            } else {
                AdHocCommand.Status status3 = AdHocCommand.Status.canceled;
                if (status3.toString().equalsIgnoreCase(attributeValue)) {
                    adHocCommandData.setStatus(status3);
                }
            }
        }
        String attributeValue2 = xmlPullParser.getAttributeValue("", "action");
        if (attributeValue2 != null) {
            AdHocCommand.Action valueOf = AdHocCommand.Action.valueOf(attributeValue2);
            if (valueOf == null || valueOf.equals(AdHocCommand.Action.unknown)) {
                adHocCommandData.setAction(AdHocCommand.Action.unknown);
            } else {
                adHocCommandData.setAction(valueOf);
            }
        }
        boolean z10 = false;
        while (!z10) {
            XmlPullParser.Event next = xmlPullParser.next();
            String namespace = xmlPullParser.getNamespace();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                String name = xmlPullParser.getName();
                if (xmlPullParser.getName().equals("actions")) {
                    String attributeValue3 = xmlPullParser.getAttributeValue("", "execute");
                    if (attributeValue3 != null) {
                        adHocCommandData.setExecuteAction(AdHocCommand.Action.valueOf(attributeValue3));
                    }
                } else if (xmlPullParser.getName().equals(FacebookParse.FB_PARAM_NEXT)) {
                    adHocCommandData.addAction(AdHocCommand.Action.next);
                } else if (xmlPullParser.getName().equals("complete")) {
                    adHocCommandData.addAction(AdHocCommand.Action.complete);
                } else if (xmlPullParser.getName().equals("prev")) {
                    adHocCommandData.addAction(AdHocCommand.Action.prev);
                } else if (name.equals("x") && namespace.equals("jabber:x:data")) {
                    adHocCommandData.setForm((DataForm) dataFormProvider.parse(xmlPullParser));
                } else if (xmlPullParser.getName().equals("note")) {
                    String attributeValue4 = xmlPullParser.getAttributeValue("", "type");
                    if (attributeValue4 != null) {
                        type = AdHocCommandNote.Type.valueOf(attributeValue4);
                    } else {
                        type = AdHocCommandNote.Type.info;
                    }
                    adHocCommandData.addNote(new AdHocCommandNote(type, xmlPullParser.nextText()));
                } else if (xmlPullParser.getName().equals("error")) {
                    adHocCommandData.setError(PacketParserUtils.parseError(xmlPullParser));
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(AdHocCommandData.ELEMENT)) {
                z10 = true;
            }
        }
        return adHocCommandData;
    }
}
