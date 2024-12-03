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
import java.security.cert.PKIXRevocationChecker;
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
import org.bouncycastle.jcajce.PKIXCertRevocationChecker;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.interfaces.BCX509Certificate;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.x509.ExtendedPKIXParameters;

public class PKIXCertPathValidatorSpi_8 extends CertPathValidatorSpi {
    private final JcaJceHelper helper;
    private final boolean isForCRLCheck;

    public PKIXCertPathValidatorSpi_8() {
        this(false);
    }

    public PKIXCertPathValidatorSpi_8(boolean z10) {
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

    public PKIXCertPathChecker engineGetRevocationChecker() {
        return new ProvRevocationChecker(this.helper);
    }

    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        PKIXExtendedParameters pKIXExtendedParameters;
        List<? extends Certificate> list;
        int i10;
        PublicKey publicKey;
        X500Name x500Name;
        HashSet hashSet;
        ArrayList arrayList;
        int i11;
        int i12;
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
                        ArrayList arrayList2 = new ArrayList();
                        PKIXCertRevocationChecker pKIXCertRevocationChecker = null;
                        for (PKIXCertPathChecker pKIXCertPathChecker : build.getCertPathCheckers()) {
                            pKIXCertPathChecker.init(false);
                            if (!(pKIXCertPathChecker instanceof PKIXRevocationChecker)) {
                                arrayList2.add(pKIXCertPathChecker);
                            } else if (pKIXCertRevocationChecker == null) {
                                pKIXCertRevocationChecker = pKIXCertPathChecker instanceof PKIXCertRevocationChecker ? (PKIXCertRevocationChecker) pKIXCertPathChecker : new WrappedRevocationChecker(pKIXCertPathChecker);
                            } else {
                                throw new CertPathValidatorException("only one PKIXRevocationChecker allowed");
                            }
                        }
                        if (build.isRevocationEnabled() && pKIXCertRevocationChecker == null) {
                            pKIXCertRevocationChecker = new ProvRevocationChecker(this.helper);
                        }
                        PKIXCertRevocationChecker pKIXCertRevocationChecker2 = pKIXCertRevocationChecker;
                        int i13 = size + 1;
                        ArrayList[] arrayListArr = new ArrayList[i13];
                        for (int i14 = 0; i14 < i13; i14++) {
                            arrayListArr[i14] = new ArrayList();
                        }
                        HashSet hashSet3 = new HashSet();
                        hashSet3.add(RFC3280CertPathUtilities.ANY_POLICY);
                        PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), 0, hashSet3, (PolicyNode) null, new HashSet(), RFC3280CertPathUtilities.ANY_POLICY, false);
                        arrayListArr[0].add(pKIXPolicyNode);
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
                                boolean z10 = true;
                                int size2 = certificates.size() - 1;
                                int i17 = size;
                                X509Certificate x509Certificate = null;
                                int i18 = i16;
                                int i19 = i13;
                                int i20 = i15;
                                PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
                                while (size2 >= 0) {
                                    int i21 = size - size2;
                                    int i22 = size;
                                    X509Certificate x509Certificate2 = (X509Certificate) certificates.get(size2);
                                    boolean z11 = size2 == certificates.size() + -1 ? z10 : false;
                                    try {
                                        checkCertificate(x509Certificate2);
                                        int i23 = size2;
                                        List<? extends Certificate> list2 = certificates;
                                        PKIXNameConstraintValidator pKIXNameConstraintValidator2 = pKIXNameConstraintValidator;
                                        Date date = validityDate;
                                        Date date2 = validityDate;
                                        ArrayList[] arrayListArr2 = arrayListArr;
                                        PKIXExtendedParameters pKIXExtendedParameters2 = build;
                                        int i24 = i20;
                                        ArrayList arrayList3 = arrayList2;
                                        boolean z12 = z11;
                                        TrustAnchor trustAnchor = findTrustAnchor;
                                        int i25 = i19;
                                        boolean z13 = z10;
                                        RFC3280CertPathUtilities.processCertA(certPath, build, date, pKIXCertRevocationChecker2, i23, publicKey, z12, x500Name, trustedCert);
                                        int i26 = i23;
                                        RFC3280CertPathUtilities.processCertBC(certPath2, i26, pKIXNameConstraintValidator2, this.isForCRLCheck);
                                        PKIXPolicyNode processCertE = RFC3280CertPathUtilities.processCertE(certPath2, i26, RFC3280CertPathUtilities.processCertD(certPath, i26, hashSet4, pKIXPolicyNode2, arrayListArr2, i18, this.isForCRLCheck));
                                        RFC3280CertPathUtilities.processCertF(certPath2, i26, processCertE, i24);
                                        int i27 = i22;
                                        if (i21 != i27) {
                                            if (x509Certificate2 == null || x509Certificate2.getVersion() != z13) {
                                                RFC3280CertPathUtilities.prepareNextCertA(certPath2, i26);
                                                arrayListArr = arrayListArr2;
                                                int i28 = i25;
                                                PKIXPolicyNode prepareCertB = RFC3280CertPathUtilities.prepareCertB(certPath2, i26, arrayListArr, processCertE, i28);
                                                RFC3280CertPathUtilities.prepareNextCertG(certPath2, i26, pKIXNameConstraintValidator2);
                                                int prepareNextCertH1 = RFC3280CertPathUtilities.prepareNextCertH1(certPath2, i26, i24);
                                                int prepareNextCertH2 = RFC3280CertPathUtilities.prepareNextCertH2(certPath2, i26, i28);
                                                int prepareNextCertH3 = RFC3280CertPathUtilities.prepareNextCertH3(certPath2, i26, i18);
                                                i24 = RFC3280CertPathUtilities.prepareNextCertI1(certPath2, i26, prepareNextCertH1);
                                                i12 = RFC3280CertPathUtilities.prepareNextCertI2(certPath2, i26, prepareNextCertH2);
                                                i11 = RFC3280CertPathUtilities.prepareNextCertJ(certPath2, i26, prepareNextCertH3);
                                                RFC3280CertPathUtilities.prepareNextCertK(certPath2, i26);
                                                i17 = RFC3280CertPathUtilities.prepareNextCertM(certPath2, i26, RFC3280CertPathUtilities.prepareNextCertL(certPath2, i26, i17));
                                                RFC3280CertPathUtilities.prepareNextCertN(certPath2, i26);
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
                                                arrayList = arrayList3;
                                                RFC3280CertPathUtilities.prepareNextCertO(certPath2, i26, hashSet2, arrayList);
                                                X500Name subjectPrincipal = PrincipalUtils.getSubjectPrincipal(x509Certificate2);
                                                try {
                                                    PublicKey nextWorkingKey = CertPathValidatorUtilities.getNextWorkingKey(certPath.getCertificates(), i26, this.helper);
                                                    AlgorithmIdentifier algorithmIdentifier2 = CertPathValidatorUtilities.getAlgorithmIdentifier(nextWorkingKey);
                                                    algorithmIdentifier2.getAlgorithm();
                                                    algorithmIdentifier2.getParameters();
                                                    pKIXPolicyNode2 = prepareCertB;
                                                    x500Name = subjectPrincipal;
                                                    publicKey = nextWorkingKey;
                                                    trustedCert = x509Certificate2;
                                                    i20 = i24;
                                                    int i29 = i26 - 1;
                                                    i18 = i11;
                                                    arrayList2 = arrayList;
                                                    z10 = z13;
                                                    findTrustAnchor = trustAnchor;
                                                    validityDate = date2;
                                                    i19 = i12;
                                                    pKIXNameConstraintValidator = pKIXNameConstraintValidator2;
                                                    x509Certificate = x509Certificate2;
                                                    certificates = list2;
                                                    size = i27;
                                                    size2 = i29;
                                                    build = pKIXExtendedParameters2;
                                                } catch (CertPathValidatorException e11) {
                                                    throw new CertPathValidatorException("Next working key could not be retrieved.", e11, certPath2, i26);
                                                }
                                            } else if (i21 != z13 || !x509Certificate2.equals(trustAnchor.getTrustedCert())) {
                                                throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", (Throwable) null, certPath2, i26);
                                            }
                                        }
                                        i11 = i18;
                                        arrayListArr = arrayListArr2;
                                        arrayList = arrayList3;
                                        i12 = i25;
                                        pKIXPolicyNode2 = processCertE;
                                        i17 = i17;
                                        i20 = i24;
                                        int i292 = i26 - 1;
                                        i18 = i11;
                                        arrayList2 = arrayList;
                                        z10 = z13;
                                        findTrustAnchor = trustAnchor;
                                        validityDate = date2;
                                        i19 = i12;
                                        pKIXNameConstraintValidator = pKIXNameConstraintValidator2;
                                        x509Certificate = x509Certificate2;
                                        certificates = list2;
                                        size = i27;
                                        size2 = i292;
                                        build = pKIXExtendedParameters2;
                                    } catch (AnnotatedException e12) {
                                        AnnotatedException annotatedException = e12;
                                        throw new CertPathValidatorException(annotatedException.getMessage(), annotatedException.getUnderlyingException(), certPath2, size2);
                                    }
                                }
                                PKIXExtendedParameters pKIXExtendedParameters3 = build;
                                ArrayList arrayList4 = arrayList2;
                                TrustAnchor trustAnchor2 = findTrustAnchor;
                                X509Certificate x509Certificate3 = x509Certificate;
                                int i30 = size2;
                                int i31 = i30 + 1;
                                int wrapupCertB = RFC3280CertPathUtilities.wrapupCertB(certPath2, i31, RFC3280CertPathUtilities.wrapupCertA(i20, x509Certificate3));
                                Set<String> criticalExtensionOIDs2 = x509Certificate3.getCriticalExtensionOIDs();
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
                                RFC3280CertPathUtilities.wrapupCertF(certPath2, i31, arrayList4, hashSet);
                                PKIXPolicyNode wrapupCertG = RFC3280CertPathUtilities.wrapupCertG(certPath, pKIXExtendedParameters3, initialPolicies, i31, arrayListArr, pKIXPolicyNode2, hashSet4);
                                if (wrapupCertB > 0 || wrapupCertG != null) {
                                    return new PKIXCertPathValidatorResult(trustAnchor2, wrapupCertG, x509Certificate3.getPublicKey());
                                }
                                throw new CertPathValidatorException("Path processing failed on policy.", (Throwable) null, certPath2, i30);
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
