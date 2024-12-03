package org.jivesoftware.smackx.sid.element;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.StringUtils;

public abstract class StableAndUniqueIdElement implements ExtensionElement {
    public static final String ATTR_ID = "id";

    /* renamed from: id  reason: collision with root package name */
    private final String f24230id;

    public StableAndUniqueIdElement() {
        this.f24230id = StringUtils.secureUniqueRandomString();
    }

    public String getId() {
        return this.f24230id;
    }

    public StableAndUniqueIdElement(String str) {
        if (!StringUtils.isNullOrEmpty((CharSequence) str)) {
            this.f24230id = str;
            return;
        }
        throw new IllegalArgumentException("Argument 'id' cannot be null or empty.");
    }
}
