package org.jivesoftware.smack.sasl;

import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.sasl.packet.SaslNonza;

public class SASLErrorException extends XMPPException {
    private static final long serialVersionUID = 6247573875760717257L;
    private final String mechanism;
    private final SaslNonza.SASLFailure saslFailure;
    private final Map<String, String> texts;

    public SASLErrorException(String str, SaslNonza.SASLFailure sASLFailure) {
        this(str, sASLFailure, new HashMap());
    }

    public String getMechanism() {
        return this.mechanism;
    }

    public SaslNonza.SASLFailure getSASLFailure() {
        return this.saslFailure;
    }

    public Map<String, String> getTexts() {
        return this.texts;
    }

    public SASLErrorException(String str, SaslNonza.SASLFailure sASLFailure, Map<String, String> map) {
        super("SASLError using " + str + ": " + sASLFailure.getSASLErrorString());
        this.mechanism = str;
        this.saslFailure = sASLFailure;
        this.texts = map;
    }
}
