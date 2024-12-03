package org.bouncycastle.jcajce.spec;

import java.security.spec.EncodedKeySpec;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class OpenSSHPublicKeySpec extends EncodedKeySpec {
    private static final String[] allowedTypes = {"ssh-rsa", "ssh-ed25519", "ssh-dss"};
    private final String type;

    public OpenSSHPublicKeySpec(byte[] bArr) {
        super(bArr);
        int i10 = 0;
        int i11 = (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << Tnaf.POW_2_WIDTH) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) + 4;
        if (i11 < bArr.length) {
            String fromByteArray = Strings.fromByteArray(Arrays.copyOfRange(bArr, 4, i11));
            this.type = fromByteArray;
            if (!fromByteArray.startsWith("ecdsa")) {
                while (true) {
                    String[] strArr = allowedTypes;
                    if (i10 >= strArr.length) {
                        throw new IllegalArgumentException("unrecognised public key type " + this.type);
                    } else if (!strArr[i10].equals(this.type)) {
                        i10++;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("invalid public key blob: type field longer than blob");
        }
    }

    public String getFormat() {
        return "OpenSSH";
    }

    public String getType() {
        return this.type;
    }
}
