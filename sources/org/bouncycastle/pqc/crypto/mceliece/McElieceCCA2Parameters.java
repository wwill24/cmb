package org.bouncycastle.pqc.crypto.mceliece;

public class McElieceCCA2Parameters extends McElieceParameters {
    private final String digest;

    public McElieceCCA2Parameters() {
        this(11, 50, "SHA-256");
    }

    public McElieceCCA2Parameters(int i10) {
        this(i10, "SHA-256");
    }

    public McElieceCCA2Parameters(int i10, int i11) {
        this(i10, i11, "SHA-256");
    }

    public McElieceCCA2Parameters(int i10, int i11, int i12) {
        this(i10, i11, i12, "SHA-256");
    }

    public McElieceCCA2Parameters(int i10, int i11, int i12, String str) {
        super(i10, i11, i12);
        this.digest = str;
    }

    public McElieceCCA2Parameters(int i10, int i11, String str) {
        super(i10, i11);
        this.digest = str;
    }

    public McElieceCCA2Parameters(int i10, String str) {
        super(i10);
        this.digest = str;
    }

    public McElieceCCA2Parameters(String str) {
        this(11, 50, str);
    }

    public String getDigest() {
        return this.digest;
    }
}
