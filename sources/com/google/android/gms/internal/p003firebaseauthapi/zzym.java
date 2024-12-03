package com.google.android.gms.internal.p003firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzym  reason: invalid package */
public final class zzym {
    public static int zza(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return (zzmq.zzd(ellipticCurve).subtract(BigInteger.ONE).bitLength() + 7) / 8;
    }

    public static BigInteger zzb(BigInteger bigInteger, boolean z10, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger bigInteger2;
        BigInteger zzd = zzmq.zzd(ellipticCurve);
        BigInteger mod = bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(zzd);
        if (zzd.signum() == 1) {
            BigInteger mod2 = mod.mod(zzd);
            BigInteger bigInteger3 = BigInteger.ZERO;
            if (!mod2.equals(bigInteger3)) {
                if (!zzd.testBit(0) || !zzd.testBit(1)) {
                    if (zzd.testBit(0) && !zzd.testBit(1)) {
                        bigInteger3 = BigInteger.ONE;
                        BigInteger shiftRight = zzd.subtract(bigInteger3).shiftRight(1);
                        int i10 = 0;
                        while (true) {
                            BigInteger mod3 = bigInteger3.multiply(bigInteger3).subtract(mod2).mod(zzd);
                            if (mod3.equals(BigInteger.ZERO)) {
                                break;
                            }
                            BigInteger modPow = mod3.modPow(shiftRight, zzd);
                            BigInteger bigInteger4 = BigInteger.ONE;
                            if (modPow.add(bigInteger4).equals(zzd)) {
                                BigInteger shiftRight2 = zzd.add(bigInteger4).shiftRight(1);
                                BigInteger bigInteger5 = bigInteger3;
                                for (int bitLength = shiftRight2.bitLength() - 2; bitLength >= 0; bitLength--) {
                                    BigInteger multiply = bigInteger5.multiply(bigInteger4);
                                    bigInteger5 = bigInteger5.multiply(bigInteger5).add(bigInteger4.multiply(bigInteger4).mod(zzd).multiply(mod3)).mod(zzd);
                                    BigInteger mod4 = multiply.add(multiply).mod(zzd);
                                    if (shiftRight2.testBit(bitLength)) {
                                        BigInteger mod5 = bigInteger5.multiply(bigInteger3).add(mod4.multiply(mod3)).mod(zzd);
                                        bigInteger4 = bigInteger3.multiply(mod4).add(bigInteger5).mod(zzd);
                                        bigInteger5 = mod5;
                                    } else {
                                        bigInteger4 = mod4;
                                    }
                                }
                                bigInteger2 = bigInteger5;
                            } else if (modPow.equals(bigInteger4)) {
                                bigInteger3 = bigInteger3.add(bigInteger4);
                                i10++;
                                if (i10 == 128 && !zzd.isProbablePrime(80)) {
                                    throw new InvalidAlgorithmParameterException("p is not prime");
                                }
                            } else {
                                throw new InvalidAlgorithmParameterException("p is not prime");
                            }
                        }
                    } else {
                        bigInteger2 = null;
                    }
                } else {
                    bigInteger2 = mod2.modPow(zzd.add(BigInteger.ONE).shiftRight(2), zzd);
                }
                if (bigInteger3 != null && bigInteger3.multiply(bigInteger3).mod(zzd).compareTo(mod2) != 0) {
                    throw new GeneralSecurityException("Could not find a modular square root");
                }
            }
            if (z10 != bigInteger3.testBit(0)) {
                return zzd.subtract(bigInteger3).mod(zzd);
            }
            return bigInteger3;
        }
        throw new InvalidAlgorithmParameterException("p must be positive");
    }

    public static KeyPair zzc(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzyv.zzf.zza("EC");
        keyPairGenerator.initialize(eCParameterSpec);
        return keyPairGenerator.generateKeyPair();
    }

    public static void zzd(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        zze(eCPublicKey, eCPrivateKey);
        zzmq.zzf(eCPublicKey.getW(), eCPrivateKey.getParams().getCurve());
    }

    static void zze(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        try {
            if (!zzmq.zzg(eCPublicKey.getParams(), eCPrivateKey.getParams())) {
                throw new GeneralSecurityException("invalid public key spec");
            }
        } catch (IllegalArgumentException | NullPointerException e10) {
            throw new GeneralSecurityException(e10);
        }
    }

    public static byte[] zzf(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) throws GeneralSecurityException {
        zze(eCPublicKey, eCPrivateKey);
        ECPoint w10 = eCPublicKey.getW();
        zzmq.zzf(w10, eCPrivateKey.getParams().getCurve());
        PublicKey generatePublic = ((KeyFactory) zzyv.zzg.zza("EC")).generatePublic(new ECPublicKeySpec(w10, eCPrivateKey.getParams()));
        KeyAgreement keyAgreement = (KeyAgreement) zzyv.zze.zza("ECDH");
        keyAgreement.init(eCPrivateKey);
        try {
            keyAgreement.doPhase(generatePublic, true);
            byte[] generateSecret = keyAgreement.generateSecret();
            EllipticCurve curve = eCPrivateKey.getParams().getCurve();
            BigInteger bigInteger = new BigInteger(1, generateSecret);
            if (bigInteger.signum() == -1 || bigInteger.compareTo(zzmq.zzd(curve)) >= 0) {
                throw new GeneralSecurityException("shared secret is out of range");
            }
            zzb(bigInteger, true, curve);
            return generateSecret;
        } catch (IllegalStateException e10) {
            throw new GeneralSecurityException(e10);
        }
    }

    public static ECPrivateKey zzg(int i10, byte[] bArr) throws GeneralSecurityException {
        return (ECPrivateKey) ((KeyFactory) zzyv.zzg.zza("EC")).generatePrivate(new ECPrivateKeySpec(zzmn.zza(bArr), zzi(i10)));
    }

    public static ECPublicKey zzh(ECParameterSpec eCParameterSpec, int i10, byte[] bArr) throws GeneralSecurityException {
        return (ECPublicKey) ((KeyFactory) zzyv.zzg.zza("EC")).generatePublic(new ECPublicKeySpec(zzj(eCParameterSpec.getCurve(), i10, bArr), eCParameterSpec));
    }

    public static ECParameterSpec zzi(int i10) throws NoSuchAlgorithmException {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return zzmq.zza;
        }
        if (i11 != 1) {
            return zzmq.zzc;
        }
        return zzmq.zzb;
    }

    public static ECPoint zzj(EllipticCurve ellipticCurve, int i10, byte[] bArr) throws GeneralSecurityException {
        int zza = zza(ellipticCurve);
        int i11 = i10 - 1;
        boolean z10 = false;
        if (i11 == 0) {
            int length = bArr.length;
            if (length != zza + zza + 1) {
                throw new GeneralSecurityException("invalid point size");
            } else if (bArr[0] == 4) {
                int i12 = zza + 1;
                ECPoint eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i12)), new BigInteger(1, Arrays.copyOfRange(bArr, i12, length)));
                zzmq.zzf(eCPoint, ellipticCurve);
                return eCPoint;
            } else {
                throw new GeneralSecurityException("invalid point format");
            }
        } else if (i11 != 1) {
            int i13 = zza + zza;
            int length2 = bArr.length;
            if (length2 == i13) {
                ECPoint eCPoint2 = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 0, zza)), new BigInteger(1, Arrays.copyOfRange(bArr, zza, length2)));
                zzmq.zzf(eCPoint2, ellipticCurve);
                return eCPoint2;
            }
            throw new GeneralSecurityException("invalid point size");
        } else {
            int i14 = zza + 1;
            BigInteger zzd = zzmq.zzd(ellipticCurve);
            int length3 = bArr.length;
            if (length3 == i14) {
                byte b10 = bArr[0];
                if (b10 != 2) {
                    if (b10 == 3) {
                        z10 = true;
                    } else {
                        throw new GeneralSecurityException("invalid format");
                    }
                }
                BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, length3));
                if (bigInteger.signum() != -1 && bigInteger.compareTo(zzd) < 0) {
                    return new ECPoint(bigInteger, zzb(bigInteger, z10, ellipticCurve));
                }
                throw new GeneralSecurityException("x is out of range");
            }
            throw new GeneralSecurityException("compressed point has wrong length");
        }
    }
}
