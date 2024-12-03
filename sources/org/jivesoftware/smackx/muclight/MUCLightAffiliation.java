package org.jivesoftware.smackx.muclight;

import java.util.Locale;

public enum MUCLightAffiliation {
    owner,
    member,
    none;

    public static MUCLightAffiliation fromString(String str) {
        if (str == null) {
            return null;
        }
        return valueOf(str.toLowerCase(Locale.US));
    }
}
