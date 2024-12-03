package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.cli.HelpFormatter;

public final class DefaultXMSSOid implements XMSSOid {
    private static final Map<String, DefaultXMSSOid> oidLookupTable;
    private final int oid;
    private final String stringRepresentation;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(createKey("SHA-256", 32, 16, 67, 10), new DefaultXMSSOid(1, "XMSS_SHA2_10_256"));
        hashMap.put(createKey("SHA-256", 32, 16, 67, 16), new DefaultXMSSOid(2, "XMSS_SHA2_16_256"));
        hashMap.put(createKey("SHA-256", 32, 16, 67, 20), new DefaultXMSSOid(3, "XMSS_SHA2_20_256"));
        hashMap.put(createKey("SHA-512", 64, 16, Opcodes.LXOR, 10), new DefaultXMSSOid(4, "XMSS_SHA2_10_512"));
        hashMap.put(createKey("SHA-512", 64, 16, Opcodes.LXOR, 16), new DefaultXMSSOid(5, "XMSS_SHA2_16_512"));
        hashMap.put(createKey("SHA-512", 64, 16, Opcodes.LXOR, 20), new DefaultXMSSOid(6, "XMSS_SHA2_20_512"));
        hashMap.put(createKey("SHAKE128", 32, 16, 67, 10), new DefaultXMSSOid(7, "XMSS_SHAKE_10_256"));
        hashMap.put(createKey("SHAKE128", 32, 16, 67, 16), new DefaultXMSSOid(8, "XMSS_SHAKE_16_256"));
        hashMap.put(createKey("SHAKE128", 32, 16, 67, 20), new DefaultXMSSOid(9, "XMSS_SHAKE_20_256"));
        hashMap.put(createKey("SHAKE256", 64, 16, Opcodes.LXOR, 10), new DefaultXMSSOid(10, "XMSS_SHAKE_10_512"));
        hashMap.put(createKey("SHAKE256", 64, 16, Opcodes.LXOR, 16), new DefaultXMSSOid(11, "XMSS_SHAKE_16_512"));
        hashMap.put(createKey("SHAKE256", 64, 16, Opcodes.LXOR, 20), new DefaultXMSSOid(12, "XMSS_SHAKE_20_512"));
        oidLookupTable = Collections.unmodifiableMap(hashMap);
    }

    private DefaultXMSSOid(int i10, String str) {
        this.oid = i10;
        this.stringRepresentation = str;
    }

    private static String createKey(String str, int i10, int i11, int i12, int i13) {
        if (str != null) {
            return str + HelpFormatter.DEFAULT_OPT_PREFIX + i10 + HelpFormatter.DEFAULT_OPT_PREFIX + i11 + HelpFormatter.DEFAULT_OPT_PREFIX + i12 + HelpFormatter.DEFAULT_OPT_PREFIX + i13;
        }
        throw new NullPointerException("algorithmName == null");
    }

    public static DefaultXMSSOid lookup(String str, int i10, int i11, int i12, int i13) {
        if (str != null) {
            return oidLookupTable.get(createKey(str, i10, i11, i12, i13));
        }
        throw new NullPointerException("algorithmName == null");
    }

    public int getOid() {
        return this.oid;
    }

    public String toString() {
        return this.stringRepresentation;
    }
}
