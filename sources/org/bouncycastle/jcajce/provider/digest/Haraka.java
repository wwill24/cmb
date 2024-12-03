package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.crypto.digests.Haraka256Digest;
import org.bouncycastle.crypto.digests.Haraka512Digest;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;

public class Haraka {

    public static class Digest256 extends BCMessageDigest implements Cloneable {
        public Digest256() {
            super(new Haraka256Digest());
        }

        public Object clone() throws CloneNotSupportedException {
            Digest256 digest256 = (Digest256) super.clone();
            digest256.digest = new Haraka256Digest((Haraka256Digest) this.digest);
            return digest256;
        }
    }

    public static class Digest512 extends BCMessageDigest implements Cloneable {
        public Digest512() {
            super(new Haraka512Digest());
        }

        public Object clone() throws CloneNotSupportedException {
            Digest512 digest512 = (Digest512) super.clone();
            digest512.digest = new Haraka512Digest((Haraka512Digest) this.digest);
            return digest512;
        }
    }

    public static class Mappings extends DigestAlgorithmProvider {
        private static final String PREFIX = Haraka.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$Digest256");
            configurableProvider.addAlgorithm("MessageDigest.HARAKA-256", sb2.toString());
            configurableProvider.addAlgorithm("MessageDigest.HARAKA-512", str + "$Digest512");
        }
    }

    private Haraka() {
    }
}
