package org.jivesoftware.smackx.jiveproperties.provider;

import com.leanplum.internal.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.jiveproperties.JivePropertiesManager;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

public class JivePropertiesExtensionProvider extends ExtensionElementProvider<JivePropertiesExtension> {
    private static final Logger LOGGER = Logger.getLogger(JivePropertiesExtensionProvider.class.getName());

    public JivePropertiesExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Object readObject;
        HashMap hashMap = new HashMap();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT && xmlPullParser.getName().equals("property")) {
                boolean z10 = false;
                String str = null;
                String str2 = null;
                String str3 = null;
                Object obj = null;
                while (!z10) {
                    XmlPullParser.Event next2 = xmlPullParser.next();
                    if (next2 == XmlPullParser.Event.START_ELEMENT) {
                        String name = xmlPullParser.getName();
                        if (name.equals("name")) {
                            str3 = xmlPullParser.nextText();
                        } else if (name.equals("value")) {
                            str = xmlPullParser.getAttributeValue("", "type");
                            str2 = xmlPullParser.nextText();
                        }
                    } else if (next2 == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("property")) {
                        if (Constants.Kinds.INT.equals(str)) {
                            readObject = Integer.valueOf(str2);
                        } else if ("long".equals(str)) {
                            readObject = Long.valueOf(str2);
                        } else if (Constants.Kinds.FLOAT.equals(str)) {
                            readObject = Float.valueOf(str2);
                        } else if ("double".equals(str)) {
                            readObject = Double.valueOf(str2);
                        } else if ("boolean".equals(str)) {
                            readObject = Boolean.valueOf(str2);
                        } else {
                            if ("string".equals(str)) {
                                obj = str2;
                            } else if ("java-object".equals(str)) {
                                if (JivePropertiesManager.isJavaObjectEnabled()) {
                                    try {
                                        readObject = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str2))).readObject();
                                    } catch (Exception e10) {
                                        LOGGER.log(Level.SEVERE, "Error parsing java object", e10);
                                    }
                                } else {
                                    LOGGER.severe("JavaObject is not enabled. Enable with JivePropertiesManager.setJavaObjectEnabled(true)");
                                }
                            }
                            if (!(str3 == null || obj == null)) {
                                hashMap.put(str3, obj);
                            }
                            z10 = true;
                        }
                        obj = readObject;
                        hashMap.put(str3, obj);
                        z10 = true;
                    }
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(JivePropertiesExtension.ELEMENT)) {
                return new JivePropertiesExtension(hashMap);
            }
        }
    }
}
