package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.sessions.settings.RemoteSettings;

public class ChildKey implements Comparable<ChildKey> {
    private static final ChildKey INFO_CHILD_KEY = new ChildKey(".info");
    private static final ChildKey MAX_KEY = new ChildKey(MAX_KEY_NAME);
    public static final String MAX_KEY_NAME = "[MAX_KEY]";
    private static final ChildKey MIN_KEY = new ChildKey(MIN_KEY_NAME);
    public static final String MIN_KEY_NAME = "[MIN_NAME]";
    private static final ChildKey PRIORITY_CHILD_KEY = new ChildKey(".priority");
    /* access modifiers changed from: private */
    public final String key;

    private static class IntegerChildKey extends ChildKey {
        private final int intValue;

        IntegerChildKey(String str, int i10) {
            super(str);
            this.intValue = i10;
        }

        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return ChildKey.super.compareTo((ChildKey) obj);
        }

        /* access modifiers changed from: protected */
        public int intValue() {
            return this.intValue;
        }

        /* access modifiers changed from: protected */
        public boolean isInt() {
            return true;
        }

        public String toString() {
            return "IntegerChildName(\"" + this.key + "\")";
        }
    }

    public static ChildKey fromString(String str) {
        Integer tryParseInt = Utilities.tryParseInt(str);
        if (tryParseInt != null) {
            return new IntegerChildKey(str, tryParseInt.intValue());
        }
        if (str.equals(".priority")) {
            return PRIORITY_CHILD_KEY;
        }
        Utilities.hardAssert(!str.contains(RemoteSettings.FORWARD_SLASH_STRING));
        return new ChildKey(str);
    }

    public static ChildKey getInfoKey() {
        return INFO_CHILD_KEY;
    }

    public static ChildKey getMaxName() {
        return MAX_KEY;
    }

    public static ChildKey getMinName() {
        return MIN_KEY;
    }

    public static ChildKey getPriorityKey() {
        return PRIORITY_CHILD_KEY;
    }

    public String asString() {
        return this.key;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChildKey)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.key.equals(((ChildKey) obj).key);
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    /* access modifiers changed from: protected */
    public int intValue() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean isInt() {
        return false;
    }

    public boolean isPriorityChildName() {
        return equals(PRIORITY_CHILD_KEY);
    }

    public String toString() {
        return "ChildKey(\"" + this.key + "\")";
    }

    private ChildKey(String str) {
        this.key = str;
    }

    public int compareTo(ChildKey childKey) {
        if (this == childKey) {
            return 0;
        }
        if (this.key.equals(MIN_KEY_NAME) || childKey.key.equals(MAX_KEY_NAME)) {
            return -1;
        }
        if (childKey.key.equals(MIN_KEY_NAME) || this.key.equals(MAX_KEY_NAME)) {
            return 1;
        }
        if (isInt()) {
            if (!childKey.isInt()) {
                return -1;
            }
            int compareInts = Utilities.compareInts(intValue(), childKey.intValue());
            return compareInts == 0 ? Utilities.compareInts(this.key.length(), childKey.key.length()) : compareInts;
        } else if (childKey.isInt()) {
            return 1;
        } else {
            return this.key.compareTo(childKey.key);
        }
    }
}
