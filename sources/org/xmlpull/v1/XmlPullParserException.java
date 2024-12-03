package org.xmlpull.v1;

import java.io.PrintStream;

public class XmlPullParserException extends Exception {
    protected int column = -1;
    protected Throwable detail;
    protected int row = -1;

    public XmlPullParserException(String str) {
        super(str);
    }

    public void printStackTrace() {
        if (this.detail == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(super.getMessage());
            stringBuffer.append("; nested exception is:");
            printStream.println(stringBuffer.toString());
            this.detail.printStackTrace();
        }
    }
}
