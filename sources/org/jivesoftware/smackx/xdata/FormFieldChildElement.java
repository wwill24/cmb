package org.jivesoftware.smackx.xdata;

import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smackx.xdata.FormField;

public interface FormFieldChildElement extends FullyQualifiedElement {
    void checkConsistency(FormField.Builder<?, ?> builder) throws IllegalArgumentException {
    }

    boolean isExclusiveElement() {
        return false;
    }

    boolean mustBeOnlyOfHisKind() {
        return false;
    }

    boolean requiresNoTypeSet() {
        return isExclusiveElement();
    }

    void validate(FormField formField) throws IllegalArgumentException {
    }
}
