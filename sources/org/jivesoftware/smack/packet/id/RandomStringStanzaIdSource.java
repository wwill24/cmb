package org.jivesoftware.smack.packet.id;

import fm.a;
import fm.b;
import org.jivesoftware.smack.util.StringUtils;

public final class RandomStringStanzaIdSource {

    public static class Factory implements StanzaIdSourceFactory {
        public static final Factory MEDIUM_SECURE = new Factory(10, false);
        private static final int REQUIRED_MIN_LENGTH = 10;
        public static final Factory VERY_SECURE = new Factory(10, true);
        private final int length;
        private final boolean verySecure;

        public Factory(int i10, boolean z10) {
            if (i10 >= 10) {
                this.length = i10;
                this.verySecure = z10;
                return;
            }
            throw new IllegalArgumentException("Insufficient length " + i10 + ", must be at least " + 10);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String lambda$constructStanzaIdSource$0() {
            return StringUtils.randomString(this.length);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String lambda$constructStanzaIdSource$1() {
            return StringUtils.insecureRandomString(this.length);
        }

        public StanzaIdSource constructStanzaIdSource() {
            if (this.verySecure) {
                return new a(this);
            }
            return new b(this);
        }
    }
}
