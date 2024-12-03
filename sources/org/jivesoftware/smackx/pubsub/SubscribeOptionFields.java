package org.jivesoftware.smackx.pubsub;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public enum SubscribeOptionFields {
    deliver,
    digest,
    digest_frequency,
    expire,
    include_body,
    show_values,
    subscription_type,
    subscription_depth;

    public static SubscribeOptionFields valueOfFromElement(String str) {
        String substring = str.substring(str.lastIndexOf(36));
        if ("show-values".equals(substring)) {
            return show_values;
        }
        return valueOf(substring);
    }

    public String getFieldName() {
        if (this == show_values) {
            return "pubsub#" + toString().replace('_', SignatureVisitor.SUPER);
        }
        return "pubsub#" + toString();
    }
}
