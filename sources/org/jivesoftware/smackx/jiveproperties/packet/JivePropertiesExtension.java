package org.jivesoftware.smackx.jiveproperties.packet;

import com.leanplum.internal.Constants;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.util.stringencoder.Base64;

public class JivePropertiesExtension implements ExtensionElement {
    public static final String ELEMENT = "properties";
    private static final Logger LOGGER = Logger.getLogger(JivePropertiesExtension.class.getName());
    public static final String NAMESPACE = "http://www.jivesoftware.com/xmlns/xmpp/properties";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);
    private final Map<String, Object> properties;

    public JivePropertiesExtension() {
        this.properties = new HashMap();
    }

    public static JivePropertiesExtension from(Message message) {
        return (JivePropertiesExtension) message.getExtension(JivePropertiesExtension.class);
    }

    public synchronized void deleteProperty(String str) {
        Map<String, Object> map = this.properties;
        if (map != null) {
            map.remove(str);
        }
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public synchronized Map<String, Object> getProperties() {
        if (this.properties == null) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new HashMap(this.properties));
    }

    public synchronized Object getProperty(String str) {
        Map<String, Object> map = this.properties;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public synchronized Collection<String> getPropertyNames() {
        if (this.properties == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.properties.keySet()));
    }

    public synchronized void setProperty(String str, Object obj) {
        if (obj instanceof Serializable) {
            this.properties.put(str, obj);
        } else {
            throw new IllegalArgumentException("Value must be serializable");
        }
    }

    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        String str;
        ObjectOutputStream objectOutputStream;
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        for (String next : getPropertyNames()) {
            Object property = getProperty(next);
            xmlStringBuilder.openElement("property");
            xmlStringBuilder.element("name", next);
            xmlStringBuilder.halfOpenElement("value");
            String str2 = "java-object";
            if (property instanceof Integer) {
                str = Integer.toString(((Integer) property).intValue());
                str2 = Constants.Kinds.INT;
            } else if (property instanceof Long) {
                str = Long.toString(((Long) property).longValue());
                str2 = "long";
            } else if (property instanceof Float) {
                str = Float.toString(((Float) property).floatValue());
                str2 = Constants.Kinds.FLOAT;
            } else if (property instanceof Double) {
                str = Double.toString(((Double) property).doubleValue());
                str2 = "double";
            } else if (property instanceof Boolean) {
                str = Boolean.toString(((Boolean) property).booleanValue());
                str2 = "boolean";
            } else if (property instanceof String) {
                str = (String) property;
                str2 = "string";
            } else {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        objectOutputStream.writeObject(property);
                        str = Base64.encodeToString(byteArrayOutputStream.toByteArray());
                        objectOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        byteArrayOutputStream.close();
                        throw th2;
                    }
                } catch (Exception e10) {
                    LOGGER.log(Level.SEVERE, "Error encoding java object", e10);
                    str = "Serializing error: " + e10.getMessage();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            xmlStringBuilder.attribute("type", str2);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(str);
            xmlStringBuilder.closeElement("value");
            xmlStringBuilder.closeElement("property");
        }
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
        throw th;
    }

    public JivePropertiesExtension(Map<String, Object> map) {
        this.properties = map;
    }
}
