package org.jivesoftware.smackx.ox.crypto;

import cn.k;
import org.jivesoftware.smackx.ox.element.OpenPgpElement;

public class OpenPgpElementAndMetadata {
    private final OpenPgpElement element;
    private final k metadata;

    public OpenPgpElementAndMetadata(OpenPgpElement openPgpElement, k kVar) {
        this.element = openPgpElement;
        this.metadata = kVar;
    }

    public OpenPgpElement getElement() {
        return this.element;
    }

    public k getMetadata() {
        return this.metadata;
    }
}
