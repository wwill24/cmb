package org.bouncycastle.crypto.digests;

import org.apache.commons.cli.HelpFormatter;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.params.SkeinParameters;
import org.bouncycastle.util.Memoable;

public class SkeinDigest implements ExtendedDigest, Memoable {
    public static final int SKEIN_1024 = 1024;
    public static final int SKEIN_256 = 256;
    public static final int SKEIN_512 = 512;
    private SkeinEngine engine;

    public SkeinDigest(int i10, int i11) {
        this.engine = new SkeinEngine(i10, i11);
        init((SkeinParameters) null);
    }

    public SkeinDigest(SkeinDigest skeinDigest) {
        this.engine = new SkeinEngine(skeinDigest.engine);
    }

    public Memoable copy() {
        return new SkeinDigest(this);
    }

    public int doFinal(byte[] bArr, int i10) {
        return this.engine.doFinal(bArr, i10);
    }

    public String getAlgorithmName() {
        return "Skein-" + (this.engine.getBlockSize() * 8) + HelpFormatter.DEFAULT_OPT_PREFIX + (this.engine.getOutputSize() * 8);
    }

    public int getByteLength() {
        return this.engine.getBlockSize();
    }

    public int getDigestSize() {
        return this.engine.getOutputSize();
    }

    public void init(SkeinParameters skeinParameters) {
        this.engine.init(skeinParameters);
    }

    public void reset() {
        this.engine.reset();
    }

    public void reset(Memoable memoable) {
        this.engine.reset(((SkeinDigest) memoable).engine);
    }

    public void update(byte b10) {
        this.engine.update(b10);
    }

    public void update(byte[] bArr, int i10, int i11) {
        this.engine.update(bArr, i10, i11);
    }
}
