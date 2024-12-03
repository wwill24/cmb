package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.cli.HelpFormatter;

public final class DefaultXMSSMTOid implements XMSSOid {
    private static final Map<String, DefaultXMSSMTOid> oidLookupTable;
    private final int oid;
    private final String stringRepresentation;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(createKey("SHA-256", 32, 16, 67, 20, 2), new DefaultXMSSMTOid(1, "XMSSMT_SHA2_20/2_256"));
        hashMap.put(createKey("SHA-256", 32, 16, 67, 20, 4), new DefaultXMSSMTOid(2, "XMSSMT_SHA2_20/4_256"));
        hashMap.put(createKey("SHA-256", 32, 16, 67, 40, 2), new DefaultXMSSMTOid(3, "XMSSMT_SHA2_40/2_256"));
        hashMap.put(createKey("SHA-256", 32, 16, 67, 40, 2), new DefaultXMSSMTOid(4, "XMSSMT_SHA2_40/4_256"));
        hashMap.put(createKey("SHA-256", 32, 16, 67, 40, 4), new DefaultXMSSMTOid(5, "XMSSMT_SHA2_40/8_256"));
        hashMap.put(createKey("SHA-256", 32, 16, 67, 60, 8), new DefaultXMSSMTOid(6, "XMSSMT_SHA2_60/3_256"));
        hashMap.put(createKey("SHA-256", 32, 16, 67, 60, 6), new DefaultXMSSMTOid(7, "XMSSMT_SHA2_60/6_256"));
        hashMap.put(createKey("SHA-256", 32, 16, 67, 60, 12), new DefaultXMSSMTOid(8, "XMSSMT_SHA2_60/12_256"));
        hashMap.put(createKey("SHA-512", 64, 16, Opcodes.LXOR, 20, 2), new DefaultXMSSMTOid(9, "XMSSMT_SHA2_20/2_512"));
        hashMap.put(createKey("SHA-512", 64, 16, Opcodes.LXOR, 20, 4), new DefaultXMSSMTOid(10, "XMSSMT_SHA2_20/4_512"));
        hashMap.put(createKey("SHA-512", 64, 16, Opcodes.LXOR, 40, 2), new DefaultXMSSMTOid(11, "XMSSMT_SHA2_40/2_512"));
        hashMap.put(createKey("SHA-512", 64, 16, Opcodes.LXOR, 40, 4), new DefaultXMSSMTOid(12, "XMSSMT_SHA2_40/4_512"));
        hashMap.put(createKey("SHA-512", 64, 16, Opcodes.LXOR, 40, 8), new DefaultXMSSMTOid(13, "XMSSMT_SHA2_40/8_512"));
        hashMap.put(createKey("SHA-512", 64, 16, Opcodes.LXOR, 60, 3), new DefaultXMSSMTOid(14, "XMSSMT_SHA2_60/3_512"));
        hashMap.put(createKey("SHA-512", 64, 16, Opcodes.LXOR, 60, 6), new DefaultXMSSMTOid(15, "XMSSMT_SHA2_60/6_512"));
        hashMap.put(createKey("SHA-512", 64, 16, Opcodes.LXOR, 60, 12), new DefaultXMSSMTOid(16, "XMSSMT_SHA2_60/12_512"));
        hashMap.put(createKey("SHAKE128", 32, 16, 67, 20, 2), new DefaultXMSSMTOid(17, "XMSSMT_SHAKE_20/2_256"));
        hashMap.put(createKey("SHAKE128", 32, 16, 67, 20, 4), new DefaultXMSSMTOid(18, "XMSSMT_SHAKE_20/4_256"));
        hashMap.put(createKey("SHAKE128", 32, 16, 67, 40, 2), new DefaultXMSSMTOid(19, "XMSSMT_SHAKE_40/2_256"));
        hashMap.put(createKey("SHAKE128", 32, 16, 67, 40, 4), new DefaultXMSSMTOid(20, "XMSSMT_SHAKE_40/4_256"));
        hashMap.put(createKey("SHAKE128", 32, 16, 67, 40, 8), new DefaultXMSSMTOid(21, "XMSSMT_SHAKE_40/8_256"));
        hashMap.put(createKey("SHAKE128", 32, 16, 67, 60, 3), new DefaultXMSSMTOid(22, "XMSSMT_SHAKE_60/3_256"));
        hashMap.put(createKey("SHAKE128", 32, 16, 67, 60, 6), new DefaultXMSSMTOid(23, "XMSSMT_SHAKE_60/6_256"));
        hashMap.put(createKey("SHAKE128", 32, 16, 67, 60, 12), new DefaultXMSSMTOid(24, "XMSSMT_SHAKE_60/12_256"));
        hashMap.put(createKey("SHAKE256", 64, 16, Opcodes.LXOR, 20, 2), new DefaultXMSSMTOid(25, "XMSSMT_SHAKE_20/2_512"));
        hashMap.put(createKey("SHAKE256", 64, 16, Opcodes.LXOR, 20, 4), new DefaultXMSSMTOid(26, "XMSSMT_SHAKE_20/4_512"));
        hashMap.put(createKey("SHAKE256", 64, 16, Opcodes.LXOR, 40, 2), new DefaultXMSSMTOid(27, "XMSSMT_SHAKE_40/2_512"));
        hashMap.put(createKey("SHAKE256", 64, 16, Opcodes.LXOR, 40, 4), new DefaultXMSSMTOid(28, "XMSSMT_SHAKE_40/4_512"));
        hashMap.put(createKey("SHAKE256", 64, 16, Opcodes.LXOR, 40, 8), new DefaultXMSSMTOid(29, "XMSSMT_SHAKE_40/8_512"));
        hashMap.put(createKey("SHAKE256", 64, 16, Opcodes.LXOR, 60, 3), new DefaultXMSSMTOid(30, "XMSSMT_SHAKE_60/3_512"));
        hashMap.put(createKey("SHAKE256", 64, 16, Opcodes.LXOR, 60, 6), new DefaultXMSSMTOid(31, "XMSSMT_SHAKE_60/6_512"));
        hashMap.put(createKey("SHAKE256", 64, 16, Opcodes.LXOR, 60, 12), new DefaultXMSSMTOid(32, "XMSSMT_SHAKE_60/12_512"));
        oidLookupTable = Collections.unmodifiableMap(hashMap);
    }

    private DefaultXMSSMTOid(int i10, String str) {
        this.oid = i10;
        this.stringRepresentation = str;
    }

    private static String createKey(String str, int i10, int i11, int i12, int i13, int i14) {
        if (str != null) {
            return str + HelpFormatter.DEFAULT_OPT_PREFIX + i10 + HelpFormatter.DEFAULT_OPT_PREFIX + i11 + HelpFormatter.DEFAULT_OPT_PREFIX + i12 + HelpFormatter.DEFAULT_OPT_PREFIX + i13 + HelpFormatter.DEFAULT_OPT_PREFIX + i14;
        }
        throw new NullPointerException("algorithmName == null");
    }

    public static DefaultXMSSMTOid lookup(String str, int i10, int i11, int i12, int i13, int i14) {
        if (str != null) {
            return oidLookupTable.get(createKey(str, i10, i11, i12, i13, i14));
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
