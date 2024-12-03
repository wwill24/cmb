package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Encodable;

public abstract class LMSKeyParameters extends AsymmetricKeyParameter implements Encodable {
    protected LMSKeyParameters(boolean z10) {
        super(z10);
    }

    public abstract byte[] getEncoded() throws IOException;
}
