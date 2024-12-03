package org.jivesoftware.smack.xml;

public class XmlPullParserException extends Exception {
    private static final long serialVersionUID = 1;

    public XmlPullParserException(Exception exc) {
        super(exc);
    }

    public XmlPullParserException(String str) {
        super(str);
    }
}
