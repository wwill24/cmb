package org.bouncycastle.crypto.macs;

import org.apache.commons.cli.HelpFormatter;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.digests.SkeinEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.SkeinParameters;

public class SkeinMac implements Mac {
    public static final int SKEIN_1024 = 1024;
    public static final int SKEIN_256 = 256;
    public static final int SKEIN_512 = 512;
    private SkeinEngine engine;

    public SkeinMac(int i10, int i11) {
        this.engine = new SkeinEngine(i10, i11);
    }

    public SkeinMac(SkeinMac skeinMac) {
        this.engine = new SkeinEngine(skeinMac.engine);
    }

    public int doFinal(byte[] bArr, int i10) {
        return this.engine.doFinal(bArr, i10);
    }

    public String getAlgorithmName() {
        return "Skein-MAC-" + (this.engine.getBlockSize() * 8) + HelpFormatter.DEFAULT_OPT_PREFIX + (this.engine.getOutputSize() * 8);
    }

    public int getMacSize() {
        return this.engine.getOutputSize();
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        SkeinParameters skeinParameters;
        if (cipherParameters instanceof SkeinParameters) {
            skeinParameters = (SkeinParameters) cipherParameters;
        } else if (cipherParameters instanceof KeyParameter) {
            skeinParameters = new SkeinParameters.Builder().setKey(((KeyParameter) cipherParameters).getKey()).build();
        } else {
            throw new IllegalArgumentException("Invalid parameter passed to Skein MAC init - " + cipherParameters.getClass().getName());
        }
        if (skeinParameters.getKey() != null) {
            this.engine.init(skeinParameters);
            return;
        }
        throw new IllegalArgumentException("Skein MAC requires a key parameter.");
    }

    public void reset() {
        this.engine.reset();
    }

    public void update(byte b10) {
        this.engine.update(b10);
    }

    public void update(byte[] bArr, int i10, int i11) {
        this.engine.update(bArr, i10, i11);
    }
}
