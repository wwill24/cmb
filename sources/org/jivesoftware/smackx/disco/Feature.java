package org.jivesoftware.smackx.disco;

public class Feature {

    public enum Support {
        optional,
        recommended,
        required;

        public boolean isNotRequired() {
            return !isRequired();
        }

        public boolean isRequired() {
            return this == required;
        }
    }
}
