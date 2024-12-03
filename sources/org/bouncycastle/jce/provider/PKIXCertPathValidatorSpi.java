package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.interfaces.BCX509Certificate;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.x509.ExtendedPKIXParameters;

public class PKIXCertPathValidatorSpi extends CertPathValidatorSpi {
    private final JcaJceHelper helper;
    private final boolean isForCRLCheck;

    public PKIXCertPathValidatorSpi() {
        this(false);
    }

    public PKIXCertPathValidatorSpi(boolean z10) {
        this.helper = new BCJcaJceHelper();
        this.isForCRLCheck = z10;
    }

    static void checkCertificate(X509Certificate x509Certificate) throws AnnotatedException {
        if (x509Certificate instanceof BCX509Certificate) {
            RuntimeException runtimeException = null;
            try {
                if (((BCX509Certificate) x509Certificate).getTBSCertificateNative() != null) {
                    return;
                }
            } catch (RuntimeException e10) {
                runtimeException = e10;
            }
            throw new AnnotatedException("unable to process TBSCertificate", runtimeException);
        }
        try {
            TBSCertificate.getInstance(x509Certificate.getTBSCertificate());
        } catch (CertificateEncodingException e11) {
            throw new AnnotatedException("unable to process TBSCertificate", e11);
        } catch (IllegalArgumentException e12) {
            throw new AnnotatedException(e12.getMessage());
        }
    }

    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        PKIXExtendedParameters pKIXExtendedParameters;
        List<? extends Certificate> list;
        int i10;
        PublicKey publicKey;
        X500Name x500Name;
        HashSet hashSet;
        List list2;
        int i11;
        int i12;
        ArrayList[] arrayListArr;
        HashSet hashSet2;
        CertPath certPath2 = certPath;
        CertPathParameters certPathParameters2 = certPathParameters;
        if (certPathParameters2 instanceof PKIXParameters) {
            PKIXExtendedParameters.Builder builder = new PKIXExtendedParameters.Builder((PKIXParameters) certPathParameters2);
            if (certPathParameters2 instanceof ExtendedPKIXParameters) {
                ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters2;
                builder.setUseDeltasEnabled(extendedPKIXParameters.isUseDeltasEnabled());
                builder.setValidityModel(extendedPKIXParameters.getValidityModel());
            }
            pKIXExtendedParameters = builder.build();
        } else if (certPathParameters2 instanceof PKIXExtendedBuilderParameters) {
            pKIXExtendedParameters = ((PKIXExtendedBuilderParameters) certPathParameters2).getBaseParameters();
        } else if (certPathParameters2 instanceof PKIXExtendedParameters) {
            pKIXExtendedParameters = (PKIXExtendedParameters) certPathParameters2;
        } else {
            throw new InvalidAlgorithmParameterException("Parameters must be a " + PKIXParameters.class.getName() + " instance.");
        }
        if (pKIXExtendedParameters.getTrustAnchors() != null) {
            List<? extends Certificate> certificates = certPath.getCertificates();
            int size = certificates.size();
            if (!certificates.isEmpty()) {
                Date validityDate = CertPathValidatorUtilities.getValidityDate(pKIXExtendedParameters, new Date());
                Set initialPolicies = pKIXExtendedParameters.getInitialPolicies();
                try {
                    TrustAnchor findTrustAnchor = CertPathValidatorUtilities.findTrustAnchor((X509Certificate) certificates.get(certificates.size() - 1), pKIXExtendedParameters.getTrustAnchors(), pKIXExtendedParameters.getSigProvider());
                    if (findTrustAnchor != null) {
                        checkCertificate(findTrustAnchor.getTrustedCert());
                        PKIXExtendedParameters build = new PKIXExtendedParameters.Builder(pKIXExtendedParameters).setTrustAnchor(findTrustAnchor).build();
                        int i13 = size + 1;
                        ArrayList[] arrayListArr2 = new ArrayList[i13];
                        for (int i14 = 0; i14 < i13; i14++) {
                            arrayListArr2[i14] = new ArrayList();
                        }
                        HashSet hashSet3 = new HashSet();
                        hashSet3.add(RFC3280CertPathUtilities.ANY_POLICY);
                        PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet3, (PolicyNode) null, new HashSet(), RFC3280CertPathUtilities.ANY_POLICY, false);
                        arrayListArr2[0].add(pKIXPolicyNode);
                        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
                        HashSet hashSet4 = new HashSet();
                        int i15 = build.isExplicitPolicyRequired() ? 0 : i13;
                        int i16 = build.isAnyPolicyInhibited() ? 0 : i13;
                        if (build.isPolicyMappingInhibited()) {
                            i13 = 0;
                        }
                        X509Certificate trustedCert = findTrustAnchor.getTrustedCert();
                        if (trustedCert != null) {
                            try {
                                x500Name = PrincipalUtils.getSubjectPrincipal(trustedCert);
                                publicKey = trustedCert.getPublicKey();
                            } catch (RuntimeException e10) {
                                throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", e10, certPath2, -1);
                            }
                        } else {
                            x500Name = PrincipalUtils.getCA(findTrustAnchor);
                            publicKey = findTrustAnchor.getCAPublicKey();
                        }
                        try {
                            AlgorithmIdentifier algorithmIdentifier = CertPathValidatorUtilities.getAlgorithmIdentifier(publicKey);
                            algorithmIdentifier.getAlgorithm();
                            algorithmIdentifier.getParameters();
                            if (build.getTargetConstraints() == null || build.getTargetConstraints().match((Certificate) (X509Certificate) certificates.get(0))) {
                                List<PKIXCertPathChecker> certPathCheckers = build.getCertPathCheckers();
                                for (PKIXCertPathChecker init : certPathCheckers) {
                                    init.init(false);
                                }
                                ProvCrlRevocationChecker provCrlRevocationChecker = build.isRevocationEnabled() ? new ProvCrlRevocationChecker(this.helper) : null;
                                boolean z10 = true;
                                TrustAnchor trustAnchor = findTrustAnchor;
                                int i17 = size;
                                X509Certificate x509Certificate = null;
                                int i18 = i13;
                                int i19 = i16;
                                PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
                                int i20 = i15;
                                int size2 = certificates.size() - 1;
                                int i21 = i20;
                                while (size2 >= 0) {
                                    int i22 = size - size2;
                                    int i23 = size;
                                    X509Certificate x509Certificate2 = (X509Certificate) certificates.get(size2);
                                    boolean z11 = size2 == certificates.size() + -1 ? z10 : false;
                                    try {
                                        checkCertificate(x509Certificate2);
                                        List<? extends Certificate> list3 = certificates;
                                        int i24 = i21;
                                        int i25 = size2;
                                        Date date = validityDate;
                                        Date date2 = validityDate;
                                        int i26 = i18;
                                        ProvCrlRevocationChecker provCrlRevocationChecker2 = provCrlRevocationChecker;
                                        ProvCrlRevocationChecker provCrlRevocationChecker3 = provCrlRevocationChecker;
                                        PKIXNameConstraintValidator pKIXNameConstraintValidator2 = pKIXNameConstraintValidator;
                                        int i27 = i19;
                                        ArrayList[] arrayListArr3 = arrayListArr2;
                                        boolean z12 = z11;
                                        TrustAnchor trustAnchor2 = trustAnchor;
                                        PKIXExtendedParameters pKIXExtendedParameters2 = build;
                                        int i28 = i22;
                                        List list4 = certPathCheckers;
                                        boolean z13 = z10;
                                        int i29 = i26;
                                        boolean z14 = z13;
                                        RFC3280CertPathUtilities.processCertA(certPath, build, date, provCrlRevocationChecker2, i25, publicKey, z12, x500Name, trustedCert);
                                        int i30 = i25;
                                        RFC3280CertPathUtilities.processCertBC(certPath2, i30, pKIXNameConstraintValidator2, this.isForCRLCheck);
                                        PKIXPolicyNode processCertE = RFC3280CertPathUtilities.processCertE(certPath2, i30, RFC3280CertPathUtilities.processCertD(certPath, i30, hashSet4, pKIXPolicyNode2, arrayListArr3, i27, this.isForCRLCheck));
                                        RFC3280CertPathUtilities.processCertF(certPath2, i30, processCertE, i24);
                                        int i31 = i23;
                                        if (i28 != i31) {
                                            if (x509Certificate2 == null || x509Certificate2.getVersion() != z14) {
                                                RFC3280CertPathUtilities.prepareNextCertA(certPath2, i30);
                                                int i32 = i29;
                                                arrayListArr = arrayListArr3;
                                                PKIXPolicyNode prepareCertB = RFC3280CertPathUtilities.prepareCertB(certPath2, i30, arrayListArr, processCertE, i32);
                                                RFC3280CertPathUtilities.prepareNextCertG(certPath2, i30, pKIXNameConstraintValidator2);
                                                int prepareNextCertH1 = RFC3280CertPathUtilities.prepareNextCertH1(certPath2, i30, i24);
                                                int prepareNextCertH2 = RFC3280CertPathUtilities.prepareNextCertH2(certPath2, i30, i32);
                                                int prepareNextCertH3 = RFC3280CertPathUtilities.prepareNextCertH3(certPath2, i30, i27);
                                                i11 = RFC3280CertPathUtilities.prepareNextCertI1(certPath2, i30, prepareNextCertH1);
                                                i12 = RFC3280CertPathUtilities.prepareNextCertI2(certPath2, i30, prepareNextCertH2);
                                                int prepareNextCertJ = RFC3280CertPathUtilities.prepareNextCertJ(certPath2, i30, prepareNextCertH3);
                                                RFC3280CertPathUtilities.prepareNextCertK(certPath2, i30);
                                                i17 = RFC3280CertPathUtilities.prepareNextCertM(certPath2, i30, RFC3280CertPathUtilities.prepareNextCertL(certPath2, i30, i17));
                                                RFC3280CertPathUtilities.prepareNextCertN(certPath2, i30);
                                                Set<String> criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                                                if (criticalExtensionOIDs != null) {
                                                    hashSet2.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                                    hashSet2.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                                    hashSet2.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                                    hashSet2.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                                    hashSet2.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                                    hashSet2.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                                    hashSet2.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                                    hashSet2.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                                    hashSet2.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                                    hashSet2.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                                } else {
                                                    hashSet2 = new HashSet();
                                                }
                                                list2 = list4;
                                                RFC3280CertPathUtilities.prepareNextCertO(certPath2, i30, hashSet2, list2);
                                                X500Name subjectPrincipal = PrincipalUtils.getSubjectPrincipal(x509Certificate2);
                                                try {
                                                    PublicKey nextWorkingKey = CertPathValidatorUtilities.getNextWorkingKey(certPath.getCertificates(), i30, this.helper);
                                                    AlgorithmIdentifier algorithmIdentifier2 = CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey);
                                                    algorithmIdentifier2.getAlgorithm();
                                                    algorithmIdentifier2.getParameters();
                                                    pKIXPolicyNode2 = prepareCertB;
                                                    i19 = prepareNextCertJ;
                                                    x500Name = subjectPrincipal;
                                                    publicKey = nextWorkingKey;
                                                    trustedCert = x509Certificate2;
                                                    int i33 = i30 - 1;
                                                    arrayListArr2 = arrayListArr;
                                                    certPathCheckers = list2;
                                                    x509Certificate = x509Certificate2;
                                                    z10 = z14;
                                                    certificates = list3;
                                                    validityDate = date2;
                                                    build = pKIXExtendedParameters2;
                                                    size = i31;
                                                    i21 = i11;
                                                    trustAnchor = trustAnchor2;
                                                    i18 = i12;
                                                    size2 = i33;
                                                    pKIXNameConstraintValidator = pKIXNameConstraintValidator2;
                                                    provCrlRevocationChecker = provCrlRevocationChecker3;
                                                } catch (CertPathValidatorException e11) {
                                                    throw new CertPathValidatorException("Next working key could not be retrieved.", e11, certPath2, i30);
                                                }
                                            } else if (i28 != z14 || !x509Certificate2.equals(trustAnchor2.getTrustedCert())) {
                                                throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", (Throwable) null, certPath2, i30);
                                            }
                                        }
                                        i12 = i29;
                                        arrayListArr = arrayListArr3;
                                        list2 = list4;
                                        pKIXPolicyNode2 = processCertE;
                                        i19 = i27;
                                        i17 = i17;
                                        i11 = i24;
                                        int i332 = i30 - 1;
                                        arrayListArr2 = arrayListArr;
                                        certPathCheckers = list2;
                                        x509Certificate = x509Certificate2;
                                        z10 = z14;
                                        certificates = list3;
                                        validityDate = date2;
                                        build = pKIXExtendedParameters2;
                                        size = i31;
                                        i21 = i11;
                                        trustAnchor = trustAnchor2;
                                        i18 = i12;
                                        size2 = i332;
                                        pKIXNameConstraintValidator = pKIXNameConstraintValidator2;
                                        provCrlRevocationChecker = provCrlRevocationChecker3;
                                    } catch (AnnotatedException e12) {
                                        AnnotatedException annotatedException = e12;
                                        throw new CertPathValidatorException(annotatedException.getMessage(), annotatedException.getUnderlyingException(), certPath2, size2);
                                    }
                                }
                                TrustAnchor trustAnchor3 = trustAnchor;
                                PKIXExtendedParameters pKIXExtendedParameters3 = build;
                                ArrayList[] arrayListArr4 = arrayListArr2;
                                List list5 = certPathCheckers;
                                int i34 = size2;
                                int i35 = i34 + 1;
                                int wrapupCertB = RFC3280CertPathUtilities.wrapupCertB(certPath2, i35, RFC3280CertPathUtilities.wrapupCertA(i21, x509Certificate));
                                Set<String> criticalExtensionOIDs2 = x509Certificate.getCriticalExtensionOIDs();
                                if (criticalExtensionOIDs2 != null) {
                                    hashSet.remove(RFC3280CertPathUtilities.KEY_USAGE);
                                    hashSet.remove(RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
                                    hashSet.remove(RFC3280CertPathUtilities.POLICY_MAPPINGS);
                                    hashSet.remove(RFC3280CertPathUtilities.INHIBIT_ANY_POLICY);
                                    hashSet.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
                                    hashSet.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
                                    hashSet.remove(RFC3280CertPathUtilities.POLICY_CONSTRAINTS);
                                    hashSet.remove(RFC3280CertPathUtilities.BASIC_CONSTRAINTS);
                                    hashSet.remove(RFC3280CertPathUtilities.SUBJECT_ALTERNATIVE_NAME);
                                    hashSet.remove(RFC3280CertPathUtilities.NAME_CONSTRAINTS);
                                    hashSet.remove(RFC3280CertPathUtilities.CRL_DISTRIBUTION_POINTS);
                                    hashSet.remove(Extension.extendedKeyUsage.getId());
                                } else {
                                    hashSet = new HashSet();
                                }
                                RFC3280CertPathUtilities.wrapupCertF(certPath2, i35, list5, hashSet);
                                PKIXPolicyNode wrapupCertG = RFC3280CertPathUtilities.wrapupCertG(certPath, pKIXExtendedParameters3, initialPolicies, i35, arrayListArr4, pKIXPolicyNode2, hashSet4);
                                if (wrapupCertB > 0 || wrapupCertG != null) {
                                    return new PKIXCertPathValidatorResult(trustAnchor3, wrapupCertG, x509Certificate.getPublicKey());
                                }
                                throw new CertPathValidatorException("Path processing failed on policy.", (Throwable) null, certPath2, i34);
                            }
                            throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", (Throwable) null, certPath2, 0);
                        } catch (CertPathValidatorException e13) {
                            throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", e13, certPath2, -1);
                        }
                    } else {
                        i10 = 1;
                        list = certificates;
                        try {
                            throw new CertPathValidatorException("Trust anchor for certification path not found.", (Throwable) null, certPath2, -1);
                        } catch (AnnotatedException e14) {
                            e = e14;
                            throw new CertPathValidatorException(e.getMessage(), e.getUnderlyingException(), certPath2, list.size() - i10);
                        }
                    }
                } catch (AnnotatedException e15) {
                    e = e15;
                    i10 = 1;
                    list = certificates;
                    throw new CertPathValidatorException(e.getMessage(), e.getUnderlyingException(), certPath2, list.size() - i10);
                }
            } else {
                throw new CertPathValidatorException("Certification path is empty.", (Throwable) null, certPath2, -1);
            }
        } else {
            throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
        }
    }
}
