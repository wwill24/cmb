package org.jivesoftware.smackx.xmlelement.provider;

import java.io.IOException;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.StandardExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.parsing.StandardExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProvider;
import org.jivesoftware.smackx.xmlelement.element.DataFormsXmlElement;

public class DataFormsXmlElementProvider extends FormFieldChildElementProvider<DataFormsXmlElement> {
    public QName getQName() {
        return DataFormsXmlElement.QNAME;
    }

    public DataFormsXmlElement parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws IOException, XmlPullParserException, SmackParsingException {
        return new DataFormsXmlElement(xmlPullParser.nextTag() == XmlPullParser.TagEvent.START_ELEMENT ? (StandardExtensionElement) StandardExtensionElementProvider.INSTANCE.parse(xmlPullParser) : null);
    }
}
