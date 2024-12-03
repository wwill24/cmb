package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.TargetInformation;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters;
import org.bouncycastle.jcajce.PKIXCertStoreSelector;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.x509.PKIXAttrCertChecker;
import org.bouncycastle.x509.X509AttributeCertificate;
import org.bouncycastle.x509.X509CertStoreSelector;

class RFC3281CertPathUtilities {
    private static final String AUTHORITY_INFO_ACCESS = Extension.authorityInfoAccess.getId();
    private static final String CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.getId();
    private static final String NO_REV_AVAIL = Extension.noRevAvail.getId();
    private static final String TARGET_INFORMATION = Extension.targetInformation.getId();

    RFC3281CertPathUtilities() {
    }

    protected static void additionalChecks(X509AttributeCertificate x509AttributeCertificate, Set set, Set set2) throws CertPathValidatorException {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (x509AttributeCertificate.getAttributes(str) != null) {
                throw new CertPathValidatorException("Attribute certificate contains prohibited attribute: " + str + ".");
            }
        }
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (x509AttributeCertificate.getAttributes(str2) == null) {
                throw new CertPathValidatorException("Attribute certificate does not contain necessary attribute: " + str2 + ".");
            }
        }
    }

    private static void checkCRL(DistributionPoint distributionPoint, X509AttributeCertificate x509AttributeCertificate, PKIXExtendedParameters pKIXExtendedParameters, Date date, Date date2, X509Certificate x509Certificate, CertStatus certStatus, ReasonsMask reasonsMask, List list, JcaJceHelper jcaJceHelper) throws AnnotatedException, RecoverableCertPathValidatorException {
        Iterator it;
        X509CRL x509crl;
        DistributionPoint distributionPoint2 = distributionPoint;
        X509AttributeCertificate x509AttributeCertificate2 = x509AttributeCertificate;
        PKIXExtendedParameters pKIXExtendedParameters2 = pKIXExtendedParameters;
        Date date3 = date2;
        CertStatus certStatus2 = certStatus;
        ReasonsMask reasonsMask2 = reasonsMask;
        if (x509AttributeCertificate2.getExtensionValue(X509Extensions.NoRevAvail.getId()) == null) {
            if (date2.getTime() <= date.getTime()) {
                Iterator it2 = CertPathValidatorUtilities.getCompleteCRLs(new PKIXCertRevocationCheckerParameters(pKIXExtendedParameters, date2, (CertPath) null, -1, x509Certificate, (PublicKey) null), distributionPoint2, x509AttributeCertificate2, pKIXExtendedParameters2, date3).iterator();
                boolean z10 = false;
                e = null;
                while (it2.hasNext() && certStatus.getCertStatus() == 11 && !reasonsMask.isAllReasons()) {
                    try {
                        X509CRL x509crl2 = (X509CRL) it2.next();
                        ReasonsMask processCRLD = RFC3280CertPathUtilities.processCRLD(x509crl2, distributionPoint2);
                        if (!processCRLD.hasNewReasons(reasonsMask2)) {
                            continue;
                        } else {
                            ReasonsMask reasonsMask3 = processCRLD;
                            X509CRL x509crl3 = x509crl2;
                            it = it2;
                            try {
                                PublicKey processCRLG = RFC3280CertPathUtilities.processCRLG(x509crl3, RFC3280CertPathUtilities.processCRLF(x509crl2, x509AttributeCertificate, (X509Certificate) null, (PublicKey) null, pKIXExtendedParameters, list, jcaJceHelper));
                                if (pKIXExtendedParameters.isUseDeltasEnabled()) {
                                    try {
                                        x509crl = RFC3280CertPathUtilities.processCRLH(CertPathValidatorUtilities.getDeltaCRLs(date, x509crl3, pKIXExtendedParameters.getCertStores(), pKIXExtendedParameters.getCRLStores(), jcaJceHelper), processCRLG);
                                    } catch (AnnotatedException e10) {
                                        e = e10;
                                        it2 = it;
                                    }
                                } else {
                                    Date date4 = date;
                                    JcaJceHelper jcaJceHelper2 = jcaJceHelper;
                                    x509crl = null;
                                }
                                if (pKIXExtendedParameters.getValidityModel() != 1) {
                                    try {
                                        if (x509AttributeCertificate.getNotAfter().getTime() < x509crl3.getThisUpdate().getTime()) {
                                            throw new AnnotatedException("No valid CRL for current time found.");
                                        }
                                    } catch (AnnotatedException e11) {
                                        e = e11;
                                    }
                                }
                                RFC3280CertPathUtilities.processCRLB1(distributionPoint2, x509AttributeCertificate2, x509crl3);
                                RFC3280CertPathUtilities.processCRLB2(distributionPoint2, x509AttributeCertificate2, x509crl3);
                                RFC3280CertPathUtilities.processCRLC(x509crl, x509crl3, pKIXExtendedParameters2);
                                RFC3280CertPathUtilities.processCRLI(date3, x509crl, x509AttributeCertificate2, certStatus2, pKIXExtendedParameters2);
                                RFC3280CertPathUtilities.processCRLJ(date3, x509crl3, x509AttributeCertificate2, certStatus2);
                                if (certStatus.getCertStatus() == 8) {
                                    certStatus2.setCertStatus(11);
                                }
                                reasonsMask2.addReasons(reasonsMask3);
                                z10 = true;
                            } catch (AnnotatedException e12) {
                                e = e12;
                                Date date5 = date;
                                JcaJceHelper jcaJceHelper3 = jcaJceHelper;
                                it2 = it;
                            }
                            it2 = it;
                        }
                    } catch (AnnotatedException e13) {
                        e = e13;
                        Date date6 = date;
                        JcaJceHelper jcaJceHelper4 = jcaJceHelper;
                        it = it2;
                        it2 = it;
                    }
                }
                if (!z10) {
                    throw e;
                }
                return;
            }
            throw new AnnotatedException("Validation time is in future.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0173  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static void checkCRLs(org.bouncycastle.x509.X509AttributeCertificate r20, org.bouncycastle.jcajce.PKIXExtendedParameters r21, java.util.Date r22, java.util.Date r23, java.security.cert.X509Certificate r24, java.util.List r25, org.bouncycastle.jcajce.util.JcaJceHelper r26) throws java.security.cert.CertPathValidatorException {
        /*
            r11 = r20
            boolean r0 = r21.isRevocationEnabled()
            if (r0 == 0) goto L_0x01a6
            java.lang.String r0 = NO_REV_AVAIL
            byte[] r0 = r11.getExtensionValue(r0)
            if (r0 != 0) goto L_0x018d
            java.lang.String r0 = CRL_DISTRIBUTION_POINTS     // Catch:{ AnnotatedException -> 0x0184 }
            org.bouncycastle.asn1.ASN1Primitive r0 = org.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r11, r0)     // Catch:{ AnnotatedException -> 0x0184 }
            org.bouncycastle.asn1.x509.CRLDistPoint r0 = org.bouncycastle.asn1.x509.CRLDistPoint.getInstance(r0)     // Catch:{ AnnotatedException -> 0x0184 }
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map r2 = r21.getNamedCRLStoreMap()     // Catch:{ AnnotatedException -> 0x017b }
            r12 = r23
            r13 = r26
            java.util.List r2 = org.bouncycastle.jce.provider.CertPathValidatorUtilities.getAdditionalStoresFromCRLDistributionPoint(r0, r2, r12, r13)     // Catch:{ AnnotatedException -> 0x017b }
            r1.addAll(r2)     // Catch:{ AnnotatedException -> 0x017b }
            org.bouncycastle.jcajce.PKIXExtendedParameters$Builder r2 = new org.bouncycastle.jcajce.PKIXExtendedParameters$Builder
            r3 = r21
            r2.<init>((org.bouncycastle.jcajce.PKIXExtendedParameters) r3)
            java.util.Iterator r3 = r1.iterator()
        L_0x0039:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0046
            r4 = r1
            org.bouncycastle.jcajce.PKIXCRLStore r4 = (org.bouncycastle.jcajce.PKIXCRLStore) r4
            r2.addCRLStore(r4)
            goto L_0x0039
        L_0x0046:
            org.bouncycastle.jcajce.PKIXExtendedParameters r14 = r2.build()
            org.bouncycastle.jce.provider.CertStatus r15 = new org.bouncycastle.jce.provider.CertStatus
            r15.<init>()
            org.bouncycastle.jce.provider.ReasonsMask r16 = new org.bouncycastle.jce.provider.ReasonsMask
            r16.<init>()
            java.lang.String r10 = "No valid CRL for distribution point found."
            r17 = 1
            r9 = 0
            r8 = 0
            r7 = 11
            if (r0 == 0) goto L_0x00b7
            org.bouncycastle.asn1.x509.DistributionPoint[] r0 = r0.getDistributionPoints()     // Catch:{ Exception -> 0x00ad }
            r6 = r9
            r18 = r6
        L_0x0065:
            int r1 = r0.length     // Catch:{ AnnotatedException -> 0x00a4 }
            if (r6 >= r1) goto L_0x00a1
            int r1 = r15.getCertStatus()     // Catch:{ AnnotatedException -> 0x00a4 }
            if (r1 != r7) goto L_0x00a1
            boolean r1 = r16.isAllReasons()     // Catch:{ AnnotatedException -> 0x00a4 }
            if (r1 != 0) goto L_0x00a1
            java.lang.Object r1 = r14.clone()     // Catch:{ AnnotatedException -> 0x00a4 }
            r3 = r1
            org.bouncycastle.jcajce.PKIXExtendedParameters r3 = (org.bouncycastle.jcajce.PKIXExtendedParameters) r3     // Catch:{ AnnotatedException -> 0x00a4 }
            r1 = r0[r6]     // Catch:{ AnnotatedException -> 0x00a4 }
            r2 = r20
            r4 = r22
            r5 = r23
            r19 = r6
            r6 = r24
            r12 = r7
            r7 = r15
            r8 = r16
            r9 = r25
            r12 = r10
            r10 = r26
            checkCRL(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ AnnotatedException -> 0x009f }
            int r6 = r19 + 1
            r10 = r12
            r18 = r17
            r7 = 11
            r8 = 0
            r9 = 0
            r12 = r23
            goto L_0x0065
        L_0x009f:
            r0 = move-exception
            goto L_0x00a6
        L_0x00a1:
            r12 = r10
            r0 = 0
            goto L_0x00bb
        L_0x00a4:
            r0 = move-exception
            r12 = r10
        L_0x00a6:
            org.bouncycastle.jce.provider.AnnotatedException r8 = new org.bouncycastle.jce.provider.AnnotatedException
            r8.<init>(r12, r0)
            r0 = r8
            goto L_0x00bb
        L_0x00ad:
            r0 = move-exception
            r1 = r0
            org.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r2 = "Distribution points could not be read."
            r0.<init>(r2, r1)
            throw r0
        L_0x00b7:
            r12 = r10
            r0 = 0
            r18 = 0
        L_0x00bb:
            int r1 = r15.getCertStatus()
            r2 = 11
            if (r1 != r2) goto L_0x0110
            boolean r1 = r16.isAllReasons()
            if (r1 != 0) goto L_0x0110
            org.bouncycastle.asn1.x500.X500Name r1 = org.bouncycastle.jce.provider.PrincipalUtils.getEncodedIssuerPrincipal(r20)     // Catch:{ Exception -> 0x00ff }
            org.bouncycastle.asn1.x509.DistributionPoint r2 = new org.bouncycastle.asn1.x509.DistributionPoint     // Catch:{ AnnotatedException -> 0x0109 }
            org.bouncycastle.asn1.x509.DistributionPointName r3 = new org.bouncycastle.asn1.x509.DistributionPointName     // Catch:{ AnnotatedException -> 0x0109 }
            org.bouncycastle.asn1.x509.GeneralNames r4 = new org.bouncycastle.asn1.x509.GeneralNames     // Catch:{ AnnotatedException -> 0x0109 }
            org.bouncycastle.asn1.x509.GeneralName r5 = new org.bouncycastle.asn1.x509.GeneralName     // Catch:{ AnnotatedException -> 0x0109 }
            r6 = 4
            r5.<init>((int) r6, (org.bouncycastle.asn1.ASN1Encodable) r1)     // Catch:{ AnnotatedException -> 0x0109 }
            r4.<init>((org.bouncycastle.asn1.x509.GeneralName) r5)     // Catch:{ AnnotatedException -> 0x0109 }
            r1 = 0
            r3.<init>(r1, r4)     // Catch:{ AnnotatedException -> 0x0109 }
            r1 = 0
            r2.<init>(r3, r1, r1)     // Catch:{ AnnotatedException -> 0x0109 }
            java.lang.Object r1 = r14.clone()     // Catch:{ AnnotatedException -> 0x0109 }
            r3 = r1
            org.bouncycastle.jcajce.PKIXExtendedParameters r3 = (org.bouncycastle.jcajce.PKIXExtendedParameters) r3     // Catch:{ AnnotatedException -> 0x0109 }
            r1 = r2
            r2 = r20
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r15
            r8 = r16
            r9 = r25
            r10 = r26
            checkCRL(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ AnnotatedException -> 0x0109 }
            goto L_0x0112
        L_0x00ff:
            r0 = move-exception
            r1 = r0
            org.bouncycastle.jce.provider.AnnotatedException r0 = new org.bouncycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x0109 }
            java.lang.String r2 = "Issuer from certificate for CRL could not be reencoded."
            r0.<init>(r2, r1)     // Catch:{ AnnotatedException -> 0x0109 }
            throw r0     // Catch:{ AnnotatedException -> 0x0109 }
        L_0x0109:
            r0 = move-exception
            org.bouncycastle.jce.provider.AnnotatedException r1 = new org.bouncycastle.jce.provider.AnnotatedException
            r1.<init>(r12, r0)
            r0 = r1
        L_0x0110:
            r17 = r18
        L_0x0112:
            if (r17 == 0) goto L_0x0173
            int r0 = r15.getCertStatus()
            r1 = 11
            if (r0 != r1) goto L_0x013c
            boolean r0 = r16.isAllReasons()
            r2 = 12
            if (r0 != 0) goto L_0x012d
            int r0 = r15.getCertStatus()
            if (r0 != r1) goto L_0x012d
            r15.setCertStatus(r2)
        L_0x012d:
            int r0 = r15.getCertStatus()
            if (r0 == r2) goto L_0x0134
            goto L_0x01a6
        L_0x0134:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "Attribute certificate status could not be determined."
            r0.<init>(r1)
            throw r0
        L_0x013c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Attribute certificate revocation after "
            r0.append(r1)
            java.util.Date r1 = r15.getRevocationDate()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = ", reason: "
            r1.append(r0)
            java.lang.String[] r0 = org.bouncycastle.jce.provider.RFC3280CertPathUtilities.crlReasons
            int r2 = r15.getCertStatus()
            r0 = r0[r2]
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.security.cert.CertPathValidatorException r1 = new java.security.cert.CertPathValidatorException
            r1.<init>(r0)
            throw r1
        L_0x0173:
            org.bouncycastle.jce.exception.ExtCertPathValidatorException r1 = new org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r2 = "No valid CRL found."
            r1.<init>(r2, r0)
            throw r1
        L_0x017b:
            r0 = move-exception
            java.security.cert.CertPathValidatorException r1 = new java.security.cert.CertPathValidatorException
            java.lang.String r2 = "No additional CRL locations could be decoded from CRL distribution point extension."
            r1.<init>(r2, r0)
            throw r1
        L_0x0184:
            r0 = move-exception
            java.security.cert.CertPathValidatorException r1 = new java.security.cert.CertPathValidatorException
            java.lang.String r2 = "CRL distribution point extension could not be read."
            r1.<init>(r2, r0)
            throw r1
        L_0x018d:
            java.lang.String r0 = CRL_DISTRIBUTION_POINTS
            byte[] r0 = r11.getExtensionValue(r0)
            if (r0 != 0) goto L_0x019e
            java.lang.String r0 = AUTHORITY_INFO_ACCESS
            byte[] r0 = r11.getExtensionValue(r0)
            if (r0 != 0) goto L_0x019e
            goto L_0x01a6
        L_0x019e:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "No rev avail extension is set, but also an AC revocation pointer."
            r0.<init>(r1)
            throw r0
        L_0x01a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.RFC3281CertPathUtilities.checkCRLs(org.bouncycastle.x509.X509AttributeCertificate, org.bouncycastle.jcajce.PKIXExtendedParameters, java.util.Date, java.util.Date, java.security.cert.X509Certificate, java.util.List, org.bouncycastle.jcajce.util.JcaJceHelper):void");
    }

    protected static CertPath processAttrCert1(X509AttributeCertificate x509AttributeCertificate, PKIXExtendedParameters pKIXExtendedParameters) throws CertPathValidatorException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i10 = 0;
        if (x509AttributeCertificate.getHolder().getIssuer() != null) {
            X509CertSelector x509CertSelector = new X509CertSelector();
            x509CertSelector.setSerialNumber(x509AttributeCertificate.getHolder().getSerialNumber());
            Principal[] issuer = x509AttributeCertificate.getHolder().getIssuer();
            int i11 = 0;
            while (i11 < issuer.length) {
                try {
                    Principal principal = issuer[i11];
                    if (principal instanceof X500Principal) {
                        x509CertSelector.setIssuer(((X500Principal) principal).getEncoded());
                    }
                    CertPathValidatorUtilities.findCertificates(linkedHashSet, new PKIXCertStoreSelector.Builder(x509CertSelector).build(), pKIXExtendedParameters.getCertStores());
                    i11++;
                } catch (AnnotatedException e10) {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", e10);
                } catch (IOException e11) {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", e11);
                }
            }
            if (linkedHashSet.isEmpty()) {
                throw new CertPathValidatorException("Public key certificate specified in base certificate ID for attribute certificate cannot be found.");
            }
        }
        if (x509AttributeCertificate.getHolder().getEntityNames() != null) {
            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
            Principal[] entityNames = x509AttributeCertificate.getHolder().getEntityNames();
            while (i10 < entityNames.length) {
                try {
                    Principal principal2 = entityNames[i10];
                    if (principal2 instanceof X500Principal) {
                        x509CertStoreSelector.setIssuer(((X500Principal) principal2).getEncoded());
                    }
                    CertPathValidatorUtilities.findCertificates(linkedHashSet, new PKIXCertStoreSelector.Builder(x509CertStoreSelector).build(), pKIXExtendedParameters.getCertStores());
                    i10++;
                } catch (AnnotatedException e12) {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", e12);
                } catch (IOException e13) {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", e13);
                }
            }
            if (linkedHashSet.isEmpty()) {
                throw new CertPathValidatorException("Public key certificate specified in entity name for attribute certificate cannot be found.");
            }
        }
        PKIXExtendedParameters.Builder builder = new PKIXExtendedParameters.Builder(pKIXExtendedParameters);
        Iterator it = linkedHashSet.iterator();
        ExtCertPathValidatorException extCertPathValidatorException = null;
        CertPathBuilderResult certPathBuilderResult = null;
        while (it.hasNext()) {
            X509CertStoreSelector x509CertStoreSelector2 = new X509CertStoreSelector();
            x509CertStoreSelector2.setCertificate((X509Certificate) it.next());
            builder.setTargetConstraints(new PKIXCertStoreSelector.Builder(x509CertStoreSelector2).build());
            try {
                try {
                    certPathBuilderResult = CertPathBuilder.getInstance("PKIX", BouncyCastleProvider.PROVIDER_NAME).build(new PKIXExtendedBuilderParameters.Builder(builder.build()).build());
                } catch (CertPathBuilderException e14) {
                    extCertPathValidatorException = new ExtCertPathValidatorException("Certification path for public key certificate of attribute certificate could not be build.", e14);
                } catch (InvalidAlgorithmParameterException e15) {
                    throw new RuntimeException(e15.getMessage());
                }
            } catch (NoSuchProviderException e16) {
                throw new ExtCertPathValidatorException("Support class could not be created.", e16);
            } catch (NoSuchAlgorithmException e17) {
                throw new ExtCertPathValidatorException("Support class could not be created.", e17);
            }
        }
        if (extCertPathValidatorException == null) {
            return certPathBuilderResult.getCertPath();
        }
        throw extCertPathValidatorException;
    }

    protected static CertPathValidatorResult processAttrCert2(CertPath certPath, PKIXExtendedParameters pKIXExtendedParameters) throws CertPathValidatorException {
        try {
            try {
                return CertPathValidator.getInstance("PKIX", BouncyCastleProvider.PROVIDER_NAME).validate(certPath, pKIXExtendedParameters);
            } catch (CertPathValidatorException e10) {
                throw new ExtCertPathValidatorException("Certification path for issuer certificate of attribute certificate could not be validated.", e10);
            } catch (InvalidAlgorithmParameterException e11) {
                throw new RuntimeException(e11.getMessage());
            }
        } catch (NoSuchProviderException e12) {
            throw new ExtCertPathValidatorException("Support class could not be created.", e12);
        } catch (NoSuchAlgorithmException e13) {
            throw new ExtCertPathValidatorException("Support class could not be created.", e13);
        }
    }

    protected static void processAttrCert3(X509Certificate x509Certificate, PKIXExtendedParameters pKIXExtendedParameters) throws CertPathValidatorException {
        boolean[] keyUsage = x509Certificate.getKeyUsage();
        if (keyUsage != null && ((keyUsage.length <= 0 || !keyUsage[0]) && (keyUsage.length <= 1 || !keyUsage[1]))) {
            throw new CertPathValidatorException("Attribute certificate issuer public key cannot be used to validate digital signatures.");
        } else if (x509Certificate.getBasicConstraints() != -1) {
            throw new CertPathValidatorException("Attribute certificate issuer is also a public key certificate issuer.");
        }
    }

    protected static void processAttrCert4(X509Certificate x509Certificate, Set set) throws CertPathValidatorException {
        Iterator it = set.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            TrustAnchor trustAnchor = (TrustAnchor) it.next();
            if (x509Certificate.getSubjectX500Principal().getName("RFC2253").equals(trustAnchor.getCAName()) || x509Certificate.equals(trustAnchor.getTrustedCert())) {
                z10 = true;
            }
        }
        if (!z10) {
            throw new CertPathValidatorException("Attribute certificate issuer is not directly trusted.");
        }
    }

    protected static void processAttrCert5(X509AttributeCertificate x509AttributeCertificate, Date date) throws CertPathValidatorException {
        try {
            x509AttributeCertificate.checkValidity(date);
        } catch (CertificateExpiredException e10) {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", e10);
        } catch (CertificateNotYetValidException e11) {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", e11);
        }
    }

    protected static void processAttrCert7(X509AttributeCertificate x509AttributeCertificate, CertPath certPath, CertPath certPath2, PKIXExtendedParameters pKIXExtendedParameters, Set set) throws CertPathValidatorException {
        Set<String> criticalExtensionOIDs = x509AttributeCertificate.getCriticalExtensionOIDs();
        String str = TARGET_INFORMATION;
        if (criticalExtensionOIDs.contains(str)) {
            try {
                TargetInformation.getInstance(CertPathValidatorUtilities.getExtensionValue(x509AttributeCertificate, str));
            } catch (AnnotatedException e10) {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", e10);
            } catch (IllegalArgumentException e11) {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", e11);
            }
        }
        criticalExtensionOIDs.remove(str);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((PKIXAttrCertChecker) it.next()).check(x509AttributeCertificate, certPath, certPath2, criticalExtensionOIDs);
        }
        if (!criticalExtensionOIDs.isEmpty()) {
            throw new CertPathValidatorException("Attribute certificate contains unsupported critical extensions: " + criticalExtensionOIDs);
        }
    }
}
