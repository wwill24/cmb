package org.jivesoftware.smackx.time.packet;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.util.XmppDateTime;

public class Time extends IQ {
    public static final String ELEMENT = "time";
    private static final Logger LOGGER = Logger.getLogger(Time.class.getName());
    public static final String NAMESPACE = "urn:xmpp:time";
    private String tzo;
    private String utc;

    public Time() {
        super("time", NAMESPACE);
        setType(IQ.Type.get);
    }

    public static Time createResponse(IQ iq) {
        Time time = new Time(Calendar.getInstance());
        time.setType(IQ.Type.result);
        time.setTo(iq.getFrom());
        return time;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        if (this.utc != null) {
            iQChildElementXmlStringBuilder.rightAngleBracket();
            iQChildElementXmlStringBuilder.append((CharSequence) "<utc>").append((CharSequence) this.utc).append((CharSequence) "</utc>");
            iQChildElementXmlStringBuilder.append((CharSequence) "<tzo>").append((CharSequence) this.tzo).append((CharSequence) "</tzo>");
        } else {
            iQChildElementXmlStringBuilder.setEmptyElement();
        }
        return iQChildElementXmlStringBuilder;
    }

    public Date getTime() {
        String str = this.utc;
        if (str == null) {
            return null;
        }
        try {
            return XmppDateTime.l(str);
        } catch (Exception e10) {
            LOGGER.log(Level.SEVERE, "Error getting local time", e10);
            return null;
        }
    }

    public String getTzo() {
        return this.tzo;
    }

    public String getUtc() {
        return this.utc;
    }

    public void setTime(Date date) {
    }

    public void setTzo(String str) {
        this.tzo = str;
    }

    public void setUtc(String str) {
        this.utc = str;
    }

    public Time(Calendar calendar) {
        super("time", NAMESPACE);
        this.tzo = XmppDateTime.c(calendar.getTimeZone());
        this.utc = XmppDateTime.i(calendar.getTime());
    }
}
