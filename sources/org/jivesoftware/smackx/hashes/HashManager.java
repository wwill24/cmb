package org.jivesoftware.smackx.hashes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.hashes.element.HashElement;

public final class HashManager extends Manager {
    private static final WeakHashMap<XMPPConnection, HashManager> INSTANCES = new WeakHashMap<>();
    public static final String PREFIX_NS_ALGO = "urn:xmpp:hash-function-text-names:";
    public static final List<ALGORITHM> RECOMMENDED = Collections.unmodifiableList(Arrays.asList(new ALGORITHM[]{ALGORITHM.SHA_256, ALGORITHM.SHA_384, ALGORITHM.SHA_512, ALGORITHM.SHA3_256, ALGORITHM.SHA3_384, ALGORITHM.SHA3_512, ALGORITHM.BLAKE2B256, ALGORITHM.BLAKE2B384, ALGORITHM.BLAKE2B512}));

    /* renamed from: org.jivesoftware.smackx.hashes.HashManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM[] r0 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM = r0
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM r1 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.MD5     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM r1 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.SHA_1     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM r1 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.SHA_224     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM r1 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.SHA_256     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM r1 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.SHA_384     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM r1 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.SHA_512     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM r1 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.SHA3_224     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM r1 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.SHA3_256     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM     // Catch:{ NoSuchFieldError -> 0x006c }
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM r1 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.SHA3_384     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM r1 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.SHA3_512     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM r1 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.BLAKE2B160     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM r1 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.BLAKE2B256     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM     // Catch:{ NoSuchFieldError -> 0x009c }
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM r1 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.BLAKE2B384     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                org.jivesoftware.smackx.hashes.HashManager$ALGORITHM r1 = org.jivesoftware.smackx.hashes.HashManager.ALGORITHM.BLAKE2B512     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.hashes.HashManager.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ALGORITHM {
        MD5("md5", AlgorithmRecommendation.must_not),
        SHA_1("sha-1", AlgorithmRecommendation.should_not),
        SHA_224("sha-224", r4),
        SHA_256("sha-256", r8),
        SHA_384("sha-384", r4),
        SHA_512("sha-512", r13),
        SHA3_224("sha3-224", r4),
        SHA3_256("sha3-256", r8),
        SHA3_384("sha3-384", r4),
        SHA3_512("sha3-512", r13),
        BLAKE2B160("id-blake2b160", r4),
        BLAKE2B256("id-blake2b256", r8),
        BLAKE2B384("id-blake2b384", r4),
        BLAKE2B512("id-blake2b512", r13);
        
        private final String name;
        private final AlgorithmRecommendation recommendation;

        private ALGORITHM(String str, AlgorithmRecommendation algorithmRecommendation) {
            this.name = str;
            this.recommendation = algorithmRecommendation;
        }

        public static ALGORITHM valueOfName(String str) {
            for (ALGORITHM algorithm : values()) {
                if (algorithm.toString().equals(str)) {
                    return algorithm;
                }
            }
            throw new IllegalArgumentException("No ALGORITHM enum with this name (" + str + ") found.");
        }

        public AlgorithmRecommendation getRecommendation() {
            return this.recommendation;
        }

        public String toString() {
            return this.name;
        }
    }

    enum AlgorithmRecommendation {
        unknown,
        must_not,
        should_not,
        should,
        must
    }

    public enum NAMESPACE {
        V1("urn:xmpp:hashes:1"),
        V2("urn:xmpp:hashes:2");
        
        final String name;

        private NAMESPACE(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    private HashManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(NAMESPACE.V2.toString());
        addAlgorithmsToFeatures(RECOMMENDED);
    }

    public static String asFeature(ALGORITHM algorithm) {
        return PREFIX_NS_ALGO + algorithm.toString();
    }

    public static HashElement assembleHashElement(ALGORITHM algorithm, byte[] bArr) {
        return new HashElement(algorithm, bArr);
    }

    public static byte[] blake2b160(byte[] bArr) {
        return getMessageDigest(ALGORITHM.BLAKE2B160).digest(bArr);
    }

    public static String blake2b160HexString(byte[] bArr) {
        return StringUtils.encodeHex(blake2b160(bArr));
    }

    public static byte[] blake2b256(byte[] bArr) {
        return getMessageDigest(ALGORITHM.BLAKE2B256).digest(bArr);
    }

    public static String blake2b256HexString(byte[] bArr) {
        return StringUtils.encodeHex(blake2b256(bArr));
    }

    public static byte[] blake2b384(byte[] bArr) {
        return getMessageDigest(ALGORITHM.BLAKE2B384).digest(bArr);
    }

    public static String blake2b384HexString(byte[] bArr) {
        return StringUtils.encodeHex(blake2b384(bArr));
    }

    public static byte[] blake2b512(byte[] bArr) {
        return getMessageDigest(ALGORITHM.BLAKE2B512).digest(bArr);
    }

    public static String blake2b512HexString(byte[] bArr) {
        return StringUtils.encodeHex(blake2b512(bArr));
    }

    public static HashElement calculateHashElement(ALGORITHM algorithm, byte[] bArr) {
        return new HashElement(algorithm, hash(algorithm, bArr));
    }

    public static synchronized HashManager getInstanceFor(XMPPConnection xMPPConnection) {
        HashManager hashManager;
        synchronized (HashManager.class) {
            WeakHashMap<XMPPConnection, HashManager> weakHashMap = INSTANCES;
            hashManager = weakHashMap.get(xMPPConnection);
            if (hashManager == null) {
                hashManager = new HashManager(xMPPConnection);
                weakHashMap.put(xMPPConnection, hashManager);
            }
        }
        return hashManager;
    }

    public static MessageDigest getMessageDigest(ALGORITHM algorithm) {
        try {
            switch (AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$hashes$HashManager$ALGORITHM[algorithm.ordinal()]) {
                case 1:
                    return MessageDigest.getInstance(StringUtils.MD5);
                case 2:
                    return MessageDigest.getInstance("SHA-1");
                case 3:
                    return MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA224);
                case 4:
                    return MessageDigest.getInstance("SHA-256");
                case 5:
                    return MessageDigest.getInstance(McElieceCCA2KeyGenParameterSpec.SHA384);
                case 6:
                    return MessageDigest.getInstance("SHA-512");
                case 7:
                    return MessageDigest.getInstance("SHA3-224");
                case 8:
                    return MessageDigest.getInstance("SHA3-256");
                case 9:
                    return MessageDigest.getInstance("SHA3-384");
                case 10:
                    return MessageDigest.getInstance("SHA3-512");
                case 11:
                    return MessageDigest.getInstance("BLAKE2b-160");
                case 12:
                    return MessageDigest.getInstance("BLAKE2b-256");
                case 13:
                    return MessageDigest.getInstance("BLAKE2b-384");
                case 14:
                    return MessageDigest.getInstance("BLAKE2b-512");
                default:
                    throw new AssertionError("Invalid enum value: " + algorithm);
            }
        } catch (NoSuchAlgorithmException e10) {
            throw new AssertionError(e10);
        }
    }

    public static byte[] hash(ALGORITHM algorithm, byte[] bArr) {
        return getMessageDigest(algorithm).digest(bArr);
    }

    public static byte[] md5(byte[] bArr) {
        return getMessageDigest(ALGORITHM.MD5).digest(bArr);
    }

    public static String md5HexString(byte[] bArr) {
        return StringUtils.encodeHex(md5(bArr));
    }

    public static byte[] sha3_224(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA3_224).digest(bArr);
    }

    public static String sha3_224HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha3_224(bArr));
    }

    public static byte[] sha3_256(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA3_256).digest(bArr);
    }

    public static String sha3_256HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha3_256(bArr));
    }

    public static byte[] sha3_384(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA3_384).digest(bArr);
    }

    public static String sha3_384HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha3_384(bArr));
    }

    public static byte[] sha3_512(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA3_512).digest(bArr);
    }

    public static String sha3_512HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha3_512(bArr));
    }

    public static byte[] sha_1(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA_1).digest(bArr);
    }

    public static String sha_1HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha_1(bArr));
    }

    public static byte[] sha_224(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA_224).digest(bArr);
    }

    public static String sha_224HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha_224(bArr));
    }

    public static byte[] sha_256(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA_256).digest(bArr);
    }

    public static String sha_256HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha_256(bArr));
    }

    public static byte[] sha_384(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA_384).digest(bArr);
    }

    public static String sha_384HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha_384(bArr));
    }

    public static byte[] sha_512(byte[] bArr) {
        return getMessageDigest(ALGORITHM.SHA_512).digest(bArr);
    }

    public static String sha_512HexString(byte[] bArr) {
        return StringUtils.encodeHex(sha_512(bArr));
    }

    public void addAlgorithmsToFeatures(List<ALGORITHM> list) {
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(connection());
        for (ALGORITHM asFeature : list) {
            instanceFor.addFeature(asFeature(asFeature));
        }
    }

    public static byte[] blake2b160(String str) {
        return blake2b160(StringUtils.toUtf8Bytes(str));
    }

    public static String blake2b160HexString(String str) {
        return StringUtils.encodeHex(blake2b160(str));
    }

    public static byte[] blake2b256(String str) {
        return blake2b256(StringUtils.toUtf8Bytes(str));
    }

    public static String blake2b256HexString(String str) {
        return StringUtils.encodeHex(blake2b256(str));
    }

    public static byte[] blake2b384(String str) {
        return blake2b384(StringUtils.toUtf8Bytes(str));
    }

    public static String blake2b384HexString(String str) {
        return StringUtils.encodeHex(blake2b384(str));
    }

    public static byte[] blake2b512(String str) {
        return blake2b512(StringUtils.toUtf8Bytes(str));
    }

    public static String blake2b512HexString(String str) {
        return StringUtils.encodeHex(blake2b512(str));
    }

    public static byte[] hash(ALGORITHM algorithm, String str) {
        return hash(algorithm, StringUtils.toUtf8Bytes(str));
    }

    public static byte[] md5(String str) {
        return md5(StringUtils.toUtf8Bytes(str));
    }

    public static String md5HexString(String str) {
        return StringUtils.encodeHex(md5(str));
    }

    public static byte[] sha3_224(String str) {
        return sha3_224(StringUtils.toUtf8Bytes(str));
    }

    public static String sha3_224HexString(String str) {
        return StringUtils.encodeHex(sha3_224(str));
    }

    public static byte[] sha3_256(String str) {
        return sha3_256(StringUtils.toUtf8Bytes(str));
    }

    public static String sha3_256HexString(String str) {
        return StringUtils.encodeHex(sha3_256(str));
    }

    public static byte[] sha3_384(String str) {
        return sha3_384(StringUtils.toUtf8Bytes(str));
    }

    public static String sha3_384HexString(String str) {
        return StringUtils.encodeHex(sha3_384(str));
    }

    public static byte[] sha3_512(String str) {
        return sha3_512(StringUtils.toUtf8Bytes(str));
    }

    public static String sha3_512HexString(String str) {
        return StringUtils.encodeHex(sha3_512(str));
    }

    public static byte[] sha_1(String str) {
        return sha_1(StringUtils.toUtf8Bytes(str));
    }

    public static String sha_1HexString(String str) {
        return StringUtils.encodeHex(sha_1(str));
    }

    public static byte[] sha_224(String str) {
        return sha_224(StringUtils.toUtf8Bytes(str));
    }

    public static String sha_224HexString(String str) {
        return StringUtils.encodeHex(sha_224(str));
    }

    public static byte[] sha_256(String str) {
        return sha_256(StringUtils.toUtf8Bytes(str));
    }

    public static String sha_256HexString(String str) {
        return StringUtils.encodeHex(sha_256(str));
    }

    public static byte[] sha_384(String str) {
        return sha_384(StringUtils.toUtf8Bytes(str));
    }

    public static String sha_384HexString(String str) {
        return StringUtils.encodeHex(sha_384(str));
    }

    public static byte[] sha_512(String str) {
        return sha_512(StringUtils.toUtf8Bytes(str));
    }

    public static String sha_512HexString(String str) {
        return StringUtils.encodeHex(sha_512(str));
    }
}
