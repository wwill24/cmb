package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.cli.HelpFormatter;

final class WOTSPlusOid implements XMSSOid {
    private static final Map<String, WOTSPlusOid> oidLookupTable;
    private final int oid;
    private final String stringRepresentation;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(createKey("SHA-256", 32, 16, 67), new WOTSPlusOid(16777217, "WOTSP_SHA2-256_W16"));
        hashMap.put(createKey("SHA-512", 64, 16, Opcodes.LXOR), new WOTSPlusOid(33554434, "WOTSP_SHA2-512_W16"));
        hashMap.put(createKey("SHAKE128", 32, 16, 67), new WOTSPlusOid(50331651, "WOTSP_SHAKE128_W16"));
        hashMap.put(createKey("SHAKE256", 64, 16, Opcodes.LXOR), new WOTSPlusOid(67108868, "WOTSP_SHAKE256_W16"));
        oidLookupTable = Collections.unmodifiableMap(hashMap);
    }

    private WOTSPlusOid(int i10, String str) {
        this.oid = i10;
        this.stringRepresentation = str;
    }

    private static String createKey(String str, int i10, int i11, int i12) {
        if (str != null) {
            return str + HelpFormatter.DEFAULT_OPT_PREFIX + i10 + HelpFormatter.DEFAULT_OPT_PREFIX + i11 + HelpFormatter.DEFAULT_OPT_PREFIX + i12;
        }
        throw new NullPointerException("algorithmName == null");
    }

    protected static WOTSPlusOid lookup(String str, int i10, int i11, int i12) {
        if (str != null) {
            return oidLookupTable.get(createKey(str, i10, i11, i12));
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
