package org.bouncycastle.jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ua.UAObjectIdentifiers;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.engines.DSTU7624Engine;
import org.bouncycastle.crypto.engines.DSTU7624WrapEngine;
import org.bouncycastle.crypto.macs.KGMac;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.KCCMBlockCipher;
import org.bouncycastle.crypto.modes.KCTRBlockCipher;
import org.bouncycastle.crypto.modes.KGCMBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

public class DSTU7624 {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        private final int ivLength;

        public AlgParamGen(int i10) {
            this.ivLength = i10 / 8;
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[this.ivLength];
            if (this.random == null) {
                this.random = CryptoServicesRegistrar.getSecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance("DSTU7624");
                createParametersInstance.init(new IvParameterSpec(bArr));
                return createParametersInstance;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSTU7624 parameter generation.");
        }
    }

    public static class AlgParamGen128 extends AlgParamGen {
        public AlgParamGen128() {
            super(128);
        }
    }

    public static class AlgParamGen256 extends AlgParamGen {
        public AlgParamGen256() {
            super(256);
        }
    }

    public static class AlgParamGen512 extends AlgParamGen {
        public AlgParamGen512() {
            super(512);
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        /* access modifiers changed from: protected */
        public String engineToString() {
            return "DSTU7624 IV";
        }
    }

    public static class CBC128 extends BaseBlockCipher {
        public CBC128() {
            super((BlockCipher) new CBCBlockCipher(new DSTU7624Engine(128)), 128);
        }
    }

    public static class CBC256 extends BaseBlockCipher {
        public CBC256() {
            super((BlockCipher) new CBCBlockCipher(new DSTU7624Engine(256)), 256);
        }
    }

    public static class CBC512 extends BaseBlockCipher {
        public CBC512() {
            super((BlockCipher) new CBCBlockCipher(new DSTU7624Engine(512)), 512);
        }
    }

    public static class CCM128 extends BaseBlockCipher {
        public CCM128() {
            super((AEADBlockCipher) new KCCMBlockCipher(new DSTU7624Engine(128)));
        }
    }

    public static class CCM256 extends BaseBlockCipher {
        public CCM256() {
            super((AEADBlockCipher) new KCCMBlockCipher(new DSTU7624Engine(256)));
        }
    }

    public static class CCM512 extends BaseBlockCipher {
        public CCM512() {
            super((AEADBlockCipher) new KCCMBlockCipher(new DSTU7624Engine(512)));
        }
    }

    public static class CFB128 extends BaseBlockCipher {
        public CFB128() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new DSTU7624Engine(128), 128)), 128);
        }
    }

    public static class CFB256 extends BaseBlockCipher {
        public CFB256() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new DSTU7624Engine(256), 256)), 256);
        }
    }

    public static class CFB512 extends BaseBlockCipher {
        public CFB512() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new DSTU7624Engine(512), 512)), 512);
        }
    }

    public static class CTR128 extends BaseBlockCipher {
        public CTR128() {
            super(new BufferedBlockCipher(new KCTRBlockCipher(new DSTU7624Engine(128))), 128);
        }
    }

    public static class CTR256 extends BaseBlockCipher {
        public CTR256() {
            super(new BufferedBlockCipher(new KCTRBlockCipher(new DSTU7624Engine(256))), 256);
        }
    }

    public static class CTR512 extends BaseBlockCipher {
        public CTR512() {
            super(new BufferedBlockCipher(new KCTRBlockCipher(new DSTU7624Engine(512))), 512);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public BlockCipher get() {
                    return new DSTU7624Engine(128);
                }
            });
        }
    }

    public static class ECB128 extends BaseBlockCipher {
        public ECB128() {
            super((BlockCipher) new DSTU7624Engine(128));
        }
    }

    public static class ECB256 extends BaseBlockCipher {
        public ECB256() {
            super((BlockCipher) new DSTU7624Engine(256));
        }
    }

    public static class ECB512 extends BaseBlockCipher {
        public ECB512() {
            super((BlockCipher) new DSTU7624Engine(512));
        }
    }

    public static class ECB_128 extends BaseBlockCipher {
        public ECB_128() {
            super((BlockCipher) new DSTU7624Engine(128));
        }
    }

    public static class ECB_256 extends BaseBlockCipher {
        public ECB_256() {
            super((BlockCipher) new DSTU7624Engine(256));
        }
    }

    public static class ECB_512 extends BaseBlockCipher {
        public ECB_512() {
            super((BlockCipher) new DSTU7624Engine(512));
        }
    }

    public static class GCM128 extends BaseBlockCipher {
        public GCM128() {
            super((AEADBlockCipher) new KGCMBlockCipher(new DSTU7624Engine(128)));
        }
    }

    public static class GCM256 extends BaseBlockCipher {
        public GCM256() {
            super((AEADBlockCipher) new KGCMBlockCipher(new DSTU7624Engine(256)));
        }
    }

    public static class GCM512 extends BaseBlockCipher {
        public GCM512() {
            super((AEADBlockCipher) new KGCMBlockCipher(new DSTU7624Engine(512)));
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super(new KGMac(new KGCMBlockCipher(new DSTU7624Engine(128)), 128));
        }
    }

    public static class GMAC128 extends BaseMac {
        public GMAC128() {
            super(new KGMac(new KGCMBlockCipher(new DSTU7624Engine(128)), 128));
        }
    }

    public static class GMAC256 extends BaseMac {
        public GMAC256() {
            super(new KGMac(new KGCMBlockCipher(new DSTU7624Engine(256)), 256));
        }
    }

    public static class GMAC512 extends BaseMac {
        public GMAC512() {
            super(new KGMac(new KGCMBlockCipher(new DSTU7624Engine(512)), 512));
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(256);
        }

        public KeyGen(int i10) {
            super("DSTU7624", i10, new CipherKeyGenerator());
        }
    }

    public static class KeyGen128 extends KeyGen {
        public KeyGen128() {
            super(128);
        }
    }

    public static class KeyGen256 extends KeyGen {
        public KeyGen256() {
            super(256);
        }
    }

    public static class KeyGen512 extends KeyGen {
        public KeyGen512() {
            super(512);
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        private static final String PREFIX = DSTU7624.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            ConfigurableProvider configurableProvider2 = configurableProvider;
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$AlgParams");
            configurableProvider2.addAlgorithm("AlgorithmParameters.DSTU7624", sb2.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = UAObjectIdentifiers.dstu7624cbc_128;
            configurableProvider2.addAlgorithm("AlgorithmParameters", aSN1ObjectIdentifier, str + "$AlgParams");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = UAObjectIdentifiers.dstu7624cbc_256;
            configurableProvider2.addAlgorithm("AlgorithmParameters", aSN1ObjectIdentifier2, str + "$AlgParams");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = UAObjectIdentifiers.dstu7624cbc_512;
            configurableProvider2.addAlgorithm("AlgorithmParameters", aSN1ObjectIdentifier3, str + "$AlgParams");
            configurableProvider2.addAlgorithm("AlgorithmParameterGenerator.DSTU7624", str + "$AlgParamGen128");
            configurableProvider2.addAlgorithm("AlgorithmParameterGenerator", aSN1ObjectIdentifier, str + "$AlgParamGen128");
            configurableProvider2.addAlgorithm("AlgorithmParameterGenerator", aSN1ObjectIdentifier2, str + "$AlgParamGen256");
            configurableProvider2.addAlgorithm("AlgorithmParameterGenerator", aSN1ObjectIdentifier3, str + "$AlgParamGen512");
            configurableProvider2.addAlgorithm("Cipher.DSTU7624", str + "$ECB_128");
            configurableProvider2.addAlgorithm("Cipher.DSTU7624-128", str + "$ECB_128");
            configurableProvider2.addAlgorithm("Cipher.DSTU7624-256", str + "$ECB_256");
            configurableProvider2.addAlgorithm("Cipher.DSTU7624-512", str + "$ECB_512");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = UAObjectIdentifiers.dstu7624ecb_128;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier4, str + "$ECB128");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = UAObjectIdentifiers.dstu7624ecb_256;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier5, str + "$ECB256");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = UAObjectIdentifiers.dstu7624ecb_512;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier6, str + "$ECB512");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier, str + "$CBC128");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier2, str + "$CBC256");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier3, str + "$CBC512");
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = UAObjectIdentifiers.dstu7624ofb_128;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier7, str + "$OFB128");
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = UAObjectIdentifiers.dstu7624ofb_256;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier8, str + "$OFB256");
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = UAObjectIdentifiers.dstu7624ofb_512;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier9, str + "$OFB512");
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = UAObjectIdentifiers.dstu7624cfb_128;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier10, str + "$CFB128");
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = UAObjectIdentifiers.dstu7624cfb_256;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier11, str + "$CFB256");
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = UAObjectIdentifiers.dstu7624cfb_512;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = aSN1ObjectIdentifier11;
            sb3.append("$CFB512");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier12, sb3.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = UAObjectIdentifiers.dstu7624ctr_128;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = aSN1ObjectIdentifier12;
            sb4.append("$CTR128");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier14, sb4.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier16 = UAObjectIdentifiers.dstu7624ctr_256;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            ASN1ObjectIdentifier aSN1ObjectIdentifier17 = aSN1ObjectIdentifier14;
            sb5.append("$CTR256");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier16, sb5.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = UAObjectIdentifiers.dstu7624ctr_512;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str);
            ASN1ObjectIdentifier aSN1ObjectIdentifier19 = aSN1ObjectIdentifier16;
            sb6.append("$CTR512");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier18, sb6.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier20 = UAObjectIdentifiers.dstu7624ccm_128;
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str);
            ASN1ObjectIdentifier aSN1ObjectIdentifier21 = aSN1ObjectIdentifier18;
            sb7.append("$CCM128");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier20, sb7.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = UAObjectIdentifiers.dstu7624ccm_256;
            StringBuilder sb8 = new StringBuilder();
            sb8.append(str);
            ASN1ObjectIdentifier aSN1ObjectIdentifier23 = aSN1ObjectIdentifier20;
            sb8.append("$CCM256");
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier22, sb8.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier24 = UAObjectIdentifiers.dstu7624ccm_512;
            configurableProvider2.addAlgorithm("Cipher", aSN1ObjectIdentifier24, str + "$CCM512");
            configurableProvider2.addAlgorithm("Cipher.DSTU7624KW", str + "$Wrap");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.DSTU7624WRAP", "DSTU7624KW");
            configurableProvider2.addAlgorithm("Cipher.DSTU7624-128KW", str + "$Wrap128");
            StringBuilder sb9 = new StringBuilder();
            sb9.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier25 = UAObjectIdentifiers.dstu7624kw_128;
            ASN1ObjectIdentifier aSN1ObjectIdentifier26 = aSN1ObjectIdentifier24;
            sb9.append(aSN1ObjectIdentifier25.getId());
            configurableProvider2.addAlgorithm(sb9.toString(), "DSTU7624-128KW");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.DSTU7624-128WRAP", "DSTU7624-128KW");
            configurableProvider2.addAlgorithm("Cipher.DSTU7624-256KW", str + "$Wrap256");
            StringBuilder sb10 = new StringBuilder();
            sb10.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier27 = UAObjectIdentifiers.dstu7624kw_256;
            ASN1ObjectIdentifier aSN1ObjectIdentifier28 = aSN1ObjectIdentifier10;
            sb10.append(aSN1ObjectIdentifier27.getId());
            configurableProvider2.addAlgorithm(sb10.toString(), "DSTU7624-256KW");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.DSTU7624-256WRAP", "DSTU7624-256KW");
            configurableProvider2.addAlgorithm("Cipher.DSTU7624-512KW", str + "$Wrap512");
            StringBuilder sb11 = new StringBuilder();
            sb11.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier29 = UAObjectIdentifiers.dstu7624kw_512;
            sb11.append(aSN1ObjectIdentifier29.getId());
            configurableProvider2.addAlgorithm(sb11.toString(), "DSTU7624-512KW");
            configurableProvider2.addAlgorithm("Alg.Alias.Cipher.DSTU7624-512WRAP", "DSTU7624-512KW");
            configurableProvider2.addAlgorithm("Mac.DSTU7624GMAC", str + "$GMAC");
            configurableProvider2.addAlgorithm("Mac.DSTU7624-128GMAC", str + "$GMAC128");
            StringBuilder sb12 = new StringBuilder();
            sb12.append("Alg.Alias.Mac.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier30 = aSN1ObjectIdentifier9;
            ASN1ObjectIdentifier aSN1ObjectIdentifier31 = UAObjectIdentifiers.dstu7624gmac_128;
            ASN1ObjectIdentifier aSN1ObjectIdentifier32 = aSN1ObjectIdentifier8;
            sb12.append(aSN1ObjectIdentifier31.getId());
            configurableProvider2.addAlgorithm(sb12.toString(), "DSTU7624-128GMAC");
            configurableProvider2.addAlgorithm("Mac.DSTU7624-256GMAC", str + "$GMAC256");
            StringBuilder sb13 = new StringBuilder();
            sb13.append("Alg.Alias.Mac.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier33 = UAObjectIdentifiers.dstu7624gmac_256;
            ASN1ObjectIdentifier aSN1ObjectIdentifier34 = aSN1ObjectIdentifier31;
            sb13.append(aSN1ObjectIdentifier33.getId());
            configurableProvider2.addAlgorithm(sb13.toString(), "DSTU7624-256GMAC");
            configurableProvider2.addAlgorithm("Mac.DSTU7624-512GMAC", str + "$GMAC512");
            StringBuilder sb14 = new StringBuilder();
            sb14.append("Alg.Alias.Mac.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier35 = UAObjectIdentifiers.dstu7624gmac_512;
            sb14.append(aSN1ObjectIdentifier35.getId());
            configurableProvider2.addAlgorithm(sb14.toString(), "DSTU7624-512GMAC");
            configurableProvider2.addAlgorithm("KeyGenerator.DSTU7624", str + "$KeyGen");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier25, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier27, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier29, str + "$KeyGen512");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier4, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier5, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier6, str + "$KeyGen512");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier2, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier3, str + "$KeyGen512");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier7, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier32, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier30, str + "$KeyGen512");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier28, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier13, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier15, str + "$KeyGen512");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier17, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier19, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier21, str + "$KeyGen512");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier23, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier22, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier26, str + "$KeyGen512");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier34, str + "$KeyGen128");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier33, str + "$KeyGen256");
            configurableProvider2.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier35, str + "$KeyGen512");
        }
    }

    public static class OFB128 extends BaseBlockCipher {
        public OFB128() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new DSTU7624Engine(128), 128)), 128);
        }
    }

    public static class OFB256 extends BaseBlockCipher {
        public OFB256() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new DSTU7624Engine(256), 256)), 256);
        }
    }

    public static class OFB512 extends BaseBlockCipher {
        public OFB512() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new DSTU7624Engine(512), 512)), 512);
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new DSTU7624WrapEngine(128));
        }
    }

    public static class Wrap128 extends BaseWrapCipher {
        public Wrap128() {
            super(new DSTU7624WrapEngine(128));
        }
    }

    public static class Wrap256 extends BaseWrapCipher {
        public Wrap256() {
            super(new DSTU7624WrapEngine(256));
        }
    }

    public static class Wrap512 extends BaseWrapCipher {
        public Wrap512() {
            super(new DSTU7624WrapEngine(512));
        }
    }

    private DSTU7624() {
    }
}
