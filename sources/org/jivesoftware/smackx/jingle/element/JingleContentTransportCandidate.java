package org.jivesoftware.smackx.jingle.element;

import org.jivesoftware.smack.packet.FullyQualifiedElement;

public abstract class JingleContentTransportCandidate implements FullyQualifiedElement {
    public static final String ELEMENT = "candidate";

    public String getElementName() {
        return ELEMENT;
    }
}
