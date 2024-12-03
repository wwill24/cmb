package org.bouncycastle.crypto;

import java.math.BigInteger;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAValidationParameters;
import org.bouncycastle.util.encoders.Hex;

public final class CryptoServicesRegistrar {
    private static final Permission CanSetDefaultProperty = new CryptoServicesPermission(CryptoServicesPermission.GLOBAL_CONFIG);
    private static final Permission CanSetDefaultRandom = new CryptoServicesPermission(CryptoServicesPermission.DEFAULT_RANDOM);
    private static final Permission CanSetThreadProperty = new CryptoServicesPermission(CryptoServicesPermission.THREAD_LOCAL_CONFIG);
    private static final Object cacheLock = new Object();
    private static SecureRandom defaultSecureRandom;
    private static final Map<String, Object[]> globalProperties = Collections.synchronizedMap(new HashMap());
    private static final ThreadLocal<Map<String, Object[]>> threadProperties = new ThreadLocal<>();

    public static final class Property {
        public static final Property DH_DEFAULT_PARAMS = new Property("dhDefaultParams", DHParameters.class);
        public static final Property DSA_DEFAULT_PARAMS = new Property("dsaDefaultParams", DSAParameters.class);
        public static final Property EC_IMPLICITLY_CA = new Property("ecImplicitlyCA", X9ECParameters.class);
        /* access modifiers changed from: private */
        public final String name;
        /* access modifiers changed from: private */
        public final Class type;

        private Property(String str, Class cls) {
            this.name = str;
            this.type = cls;
        }
    }

    static {
        DSAParameters dSAParameters = new DSAParameters(new BigInteger("fca682ce8e12caba26efccf7110e526db078b05edecbcd1eb4a208f3ae1617ae01f35b91a47e6df63413c5e12ed0899bcd132acd50d99151bdc43ee737592e17", 16), new BigInteger("962eddcc369cba8ebb260ee6b6a126d9346e38c5", 16), new BigInteger("678471b27a9cf44ee91a49c5147db1a9aaf244f05a434d6486931d2d14271b9e35030b71fd73da179069b32e2935630e1c2062354d0da20a6c416e50be794ca4", 16), new DSAValidationParameters(Hex.decodeStrict("b869c82b35d70e1b1ff91b28e37a62ecdc34409b"), 123));
        DSAParameters dSAParameters2 = new DSAParameters(new BigInteger("e9e642599d355f37c97ffd3567120b8e25c9cd43e927b3a9670fbec5d890141922d2c3b3ad2480093799869d1e846aab49fab0ad26d2ce6a22219d470bce7d777d4a21fbe9c270b57f607002f3cef8393694cf45ee3688c11a8c56ab127a3daf", 16), new BigInteger("9cdbd84c9f1ac2f38d0f80f42ab952e7338bf511", 16), new BigInteger("30470ad5a005fb14ce2d9dcd87e38bc7d1b1c5facbaecbe95f190aa7a31d23c4dbbcbe06174544401a5b2c020965d8c2bd2171d3668445771f74ba084d2029d83c1c158547f3a9f1a2715be23d51ae4d3e5a1f6a7064f316933a346d3f529252", 16), new DSAValidationParameters(Hex.decodeStrict("77d0f8c4dad15eb8c4f2f8d6726cefd96d5bb399"), 263));
        DSAParameters dSAParameters3 = new DSAParameters(new BigInteger("fd7f53811d75122952df4a9c2eece4e7f611b7523cef4400c31e3f80b6512669455d402251fb593d8d58fabfc5f5ba30f6cb9b556cd7813b801d346ff26660b76b9950a5a49f9fe8047b1022c24fbba9d7feb7c61bf83b57e7c6a8a6150f04fb83f6d3c51ec3023554135a169132f675f3ae2b61d72aeff22203199dd14801c7", 16), new BigInteger("9760508f15230bccb292b982a2eb840bf0581cf5", 16), new BigInteger("f7e1a085d69b3ddecbbcab5c36b857b97994afbbfa3aea82f9574c0b3d0782675159578ebad4594fe67107108180b449167123e84c281613b7cf09328cc8a6e13c167a8b547c8d28e0a3ae1e2bb3a675916ea37f0bfa213562f1fb627a01243bcca4f1bea8519089a883dfe15ae59f06928b665e807b552564014c3bfecf492a", 16), new DSAValidationParameters(Hex.decodeStrict("8d5155894229d5e689ee01e6018a237e2cae64cd"), 92));
        DSAParameters dSAParameters4 = new DSAParameters(new BigInteger("95475cf5d93e596c3fcd1d902add02f427f5f3c7210313bb45fb4d5bb2e5fe1cbd678cd4bbdd84c9836be1f31c0777725aeb6c2fc38b85f48076fa76bcd8146cc89a6fb2f706dd719898c2083dc8d896f84062e2c9c94d137b054a8d8096adb8d51952398eeca852a0af12df83e475aa65d4ec0c38a9560d5661186ff98b9fc9eb60eee8b030376b236bc73be3acdbd74fd61c1d2475fa3077b8f080467881ff7e1ca56fee066d79506ade51edbb5443a563927dbc4ba520086746175c8885925ebc64c6147906773496990cb714ec667304e261faee33b3cbdf008e0c3fa90650d97d3909c9275bf4ac86ffcb3d03e6dfc8ada5934242dd6d3bcca2a406cb0b", 16), new BigInteger("f8183668ba5fc5bb06b5981e6d8b795d30b8978d43ca0ec572e37e09939a9773", 16), new BigInteger("42debb9da5b3d88cc956e08787ec3f3a09bba5f48b889a74aaf53174aa0fbe7e3c5b8fcd7a53bef563b0e98560328960a9517f4014d3325fc7962bf1e049370d76d1314a76137e792f3f0db859d095e4a5b932024f079ecf2ef09c797452b0770e1350782ed57ddf794979dcef23cb96f183061965c4ebc93c9c71c56b925955a75f94cccf1449ac43d586d0beee43251b0b2287349d68de0d144403f13e802f4146d882e057af19b6f6275c6676c8fa0e3ca2713a3257fd1b27d0639f695e347d8d1cf9ac819a26ca9b04cb0eb9b7b035988d15bbac65212a55239cfc7e58fae38d7250ab9991ffbc97134025fe8ce04c4399ad96569be91a546f4978693c7a", 16), new DSAValidationParameters(Hex.decodeStrict("b0b4417601b59cbc9d8ac8f935cadaec4f5fbb2f23785609ae466748d9b5a536"), 497));
        localSetGlobalProperty(Property.DSA_DEFAULT_PARAMS, dSAParameters, dSAParameters2, dSAParameters3, dSAParameters4);
        localSetGlobalProperty(Property.DH_DEFAULT_PARAMS, toDH(dSAParameters), toDH(dSAParameters2), toDH(dSAParameters3), toDH(dSAParameters4));
    }

    private CryptoServicesRegistrar() {
    }

    private static void checkPermission(final Permission permission) {
        final SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            AccessController.doPrivileged(new PrivilegedAction<Object>() {
                public Object run() {
                    securityManager.checkPermission(permission);
                    return null;
                }
            });
        }
    }

    private static int chooseLowerBound(int i10) {
        if (i10 <= 1024) {
            return 160;
        }
        if (i10 <= 2048) {
            return 224;
        }
        if (i10 <= 3072) {
            return 256;
        }
        return i10 <= 7680 ? 384 : 512;
    }

    public static <T> T[] clearGlobalProperty(Property property) {
        checkPermission(CanSetDefaultProperty);
        localClearThreadProperty(property);
        return (Object[]) globalProperties.remove(property.name);
    }

    public static <T> T[] clearThreadProperty(Property property) {
        checkPermission(CanSetThreadProperty);
        return localClearThreadProperty(property);
    }

    public static <T> T getProperty(Property property) {
        T[] lookupProperty = lookupProperty(property);
        if (lookupProperty != null) {
            return lookupProperty[0];
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0012, code lost:
        if (defaultSecureRandom != null) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0014, code lost:
        defaultSecureRandom = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0016, code lost:
        r1 = defaultSecureRandom;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0018, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0019, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
        r1 = new java.security.SecureRandom();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        monitor-enter(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.SecureRandom getSecureRandom() {
        /*
            java.lang.Object r0 = cacheLock
            monitor-enter(r0)
            java.security.SecureRandom r1 = defaultSecureRandom     // Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return r1
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            java.security.SecureRandom r1 = new java.security.SecureRandom
            r1.<init>()
            monitor-enter(r0)
            java.security.SecureRandom r2 = defaultSecureRandom     // Catch:{ all -> 0x001a }
            if (r2 != 0) goto L_0x0016
            defaultSecureRandom = r1     // Catch:{ all -> 0x001a }
        L_0x0016:
            java.security.SecureRandom r1 = defaultSecureRandom     // Catch:{ all -> 0x001a }
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            return r1
        L_0x001a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001a }
            throw r1
        L_0x001d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.CryptoServicesRegistrar.getSecureRandom():java.security.SecureRandom");
    }

    public static SecureRandom getSecureRandom(SecureRandom secureRandom) {
        return secureRandom == null ? getSecureRandom() : secureRandom;
    }

    public static <T> T getSizedProperty(Property property, int i10) {
        T[] lookupProperty = lookupProperty(property);
        if (lookupProperty == null) {
            return null;
        }
        int i11 = 0;
        if (property.type.isAssignableFrom(DHParameters.class)) {
            while (i11 != lookupProperty.length) {
                T t10 = (DHParameters) lookupProperty[i11];
                if (t10.getP().bitLength() == i10) {
                    return t10;
                }
                i11++;
            }
        } else if (property.type.isAssignableFrom(DSAParameters.class)) {
            while (i11 != lookupProperty.length) {
                T t11 = (DSAParameters) lookupProperty[i11];
                if (t11.getP().bitLength() == i10) {
                    return t11;
                }
                i11++;
            }
        }
        return null;
    }

    public static <T> T[] getSizedProperty(Property property) {
        Object[] lookupProperty = lookupProperty(property);
        if (lookupProperty == null) {
            return null;
        }
        return (Object[]) lookupProperty.clone();
    }

    private static Object[] localClearThreadProperty(Property property) {
        ThreadLocal<Map<String, Object[]>> threadLocal = threadProperties;
        Map map = threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
        }
        return (Object[]) map.remove(property.name);
    }

    private static <T> void localSetGlobalProperty(Property property, T... tArr) {
        if (property.type.isAssignableFrom(tArr[0].getClass())) {
            localSetThread(property, tArr);
            globalProperties.put(property.name, tArr);
            return;
        }
        throw new IllegalArgumentException("Bad property value passed");
    }

    private static <T> void localSetThread(Property property, T[] tArr) {
        ThreadLocal<Map<String, Object[]>> threadLocal = threadProperties;
        Map map = threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
        }
        map.put(property.name, tArr);
    }

    private static Object[] lookupProperty(Property property) {
        Map<String, Object[]> map = threadProperties.get();
        if (map == null || !map.containsKey(property.name)) {
            map = globalProperties;
        }
        return map.get(property.name);
    }

    public static <T> void setGlobalProperty(Property property, T... tArr) {
        checkPermission(CanSetDefaultProperty);
        localSetGlobalProperty(property, (Object[]) tArr.clone());
    }

    public static void setSecureRandom(SecureRandom secureRandom) {
        checkPermission(CanSetDefaultRandom);
        synchronized (cacheLock) {
            defaultSecureRandom = secureRandom;
        }
    }

    public static <T> void setThreadProperty(Property property, T... tArr) {
        checkPermission(CanSetThreadProperty);
        if (property.type.isAssignableFrom(tArr[0].getClass())) {
            localSetThread(property, (Object[]) tArr.clone());
            return;
        }
        throw new IllegalArgumentException("Bad property value passed");
    }

    private static DHParameters toDH(DSAParameters dSAParameters) {
        return new DHParameters(dSAParameters.getP(), dSAParameters.getG(), dSAParameters.getQ(), chooseLowerBound(dSAParameters.getP().bitLength()), 0, (BigInteger) null, new DHValidationParameters(dSAParameters.getValidationParameters().getSeed(), dSAParameters.getValidationParameters().getCounter()));
    }
}
