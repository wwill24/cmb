package on;

import java.security.Provider;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public final class a extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final Provider f41337b = new BouncyCastleProvider();

    public Provider a() {
        return f41337b;
    }
}
