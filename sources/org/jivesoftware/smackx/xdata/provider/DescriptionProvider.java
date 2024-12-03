package org.jivesoftware.smackx.xdata.provider;

import java.io.IOException;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.xdata.FormField;

public class DescriptionProvider extends FormFieldChildElementProvider<FormField.Description> {
    public QName getQName() {
        return FormField.Description.QNAME;
    }

    public FormField.Description parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        return new FormField.Description(xmlPullParser.nextText());
    }
}
