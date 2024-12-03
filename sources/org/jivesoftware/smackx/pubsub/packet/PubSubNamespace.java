package org.jivesoftware.smackx.pubsub.packet;

import com.mparticle.identity.IdentityHttpResponse;

public enum PubSubNamespace {
    basic((String) null),
    error(IdentityHttpResponse.ERRORS),
    event("event"),
    owner("owner");
    
    private final String fragment;
    private final String fullNamespace;

    private PubSubNamespace(String str) {
        this.fragment = str;
        if (str != null) {
            this.fullNamespace = "http://jabber.org/protocol/pubsub#" + str;
            return;
        }
        this.fullNamespace = "http://jabber.org/protocol/pubsub";
    }

    public static PubSubNamespace valueOfFromXmlns(String str) {
        int lastIndexOf = str.lastIndexOf(35);
        if (lastIndexOf != -1) {
            if (lastIndexOf <= str.length()) {
                return valueOf(str.substring(lastIndexOf + 1));
            }
            throw new IllegalArgumentException(str + " is not a valid PubSub namespace");
        } else if ("http://jabber.org/protocol/pubsub".equals(str)) {
            return basic;
        } else {
            throw new IllegalArgumentException(str + " is not a valid PubSub namespace");
        }
    }

    public String getFragment() {
        return this.fragment;
    }

    public String getXmlns() {
        return this.fullNamespace;
    }
}
