package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

public class SM2ParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: id  reason: collision with root package name */
    private byte[] f23859id;

    public SM2ParameterSpec(byte[] bArr) {
        if (bArr != null) {
            this.f23859id = Arrays.clone(bArr);
            return;
        }
        throw new NullPointerException("id string cannot be null");
    }

    public byte[] getID() {
        return Arrays.clone(this.f23859id);
    }
}
