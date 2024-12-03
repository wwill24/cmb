package org.jxmpp;

public enum XmppAddressParttype {
    localpart,
    domainpart,
    resourcepart;
    
    final String capitalizedName;

    public String a() {
        return this.capitalizedName;
    }
}
