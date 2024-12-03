package org.bouncycastle.jce.provider;

import com.google.firebase.ktx.BuildConfig;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.GeneralSubtree;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.asn1.x509.NameConstraints;
import org.bouncycastle.asn1.x509.PolicyInformation;
import org.bouncycastle.jcajce.PKIXCertRevocationChecker;
import org.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters;
import org.bouncycastle.jcajce.PKIXCertStoreSelector;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.ClassUtil;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.util.Arrays;

class RFC3280CertPathUtilities {
    public static final String ANY_POLICY = "2.5.29.32.0";
    public static final String AUTHORITY_KEY_IDENTIFIER = Extension.authorityKeyIdentifier.getId();
    public static final String BASIC_CONSTRAINTS = Extension.basicConstraints.getId();
    public static final String CERTIFICATE_POLICIES = Extension.certificatePolicies.getId();
    public static final String CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.getId();
    public static final String CRL_NUMBER = Extension.cRLNumber.getId();
    protected static final int CRL_SIGN = 6;
    public static final String DELTA_CRL_INDICATOR = Extension.deltaCRLIndicator.getId();
    public static final String FRESHEST_CRL = Extension.freshestCRL.getId();
    public static final String INHIBIT_ANY_POLICY = Extension.inhibitAnyPolicy.getId();
    public static final String ISSUING_DISTRIBUTION_POINT = Extension.issuingDistributionPoint.getId();
    protected static final int KEY_CERT_SIGN = 5;
    public static final String KEY_USAGE = Extension.keyUsage.getId();
    public static final String NAME_CONSTRAINTS = Extension.nameConstraints.getId();
    public static final String POLICY_CONSTRAINTS = Extension.policyConstraints.getId();
    public static final String POLICY_MAPPINGS = Extension.policyMappings.getId();
    public static final String SUBJECT_ALTERNATIVE_NAME = Extension.subjectAlternativeName.getId();
    protected static final String[] crlReasons = {BuildConfig.VERSION_NAME, "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};
    private static final Class revChkClass = ClassUtil.loadClass(RFC3280CertPathUtilities.class, "java.security.cert.PKIXRevocationChecker");

    RFC3280CertPathUtilities() {
    }

    private static void checkCRL(PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters, DistributionPoint distributionPoint, PKIXExtendedParameters pKIXExtendedParameters, Date date, Date date2, X509Certificate x509Certificate, X509Certificate x509Certificate2, PublicKey publicKey, CertStatus certStatus, ReasonsMask reasonsMask, List list, JcaJceHelper jcaJceHelper) throws AnnotatedException, RecoverableCertPathValidatorException {
        Iterator it;
        X509CRL x509crl;
        Set<String> criticalExtensionOIDs;
        DistributionPoint distributionPoint2 = distributionPoint;
        PKIXExtendedParameters pKIXExtendedParameters2 = pKIXExtendedParameters;
        Date date3 = date2;
        X509Certificate x509Certificate3 = x509Certificate;
        CertStatus certStatus2 = certStatus;
        ReasonsMask reasonsMask2 = reasonsMask;
        if (date2.getTime() <= date.getTime()) {
            Iterator it2 = CertPathValidatorUtilities.getCompleteCRLs(pKIXCertRevocationCheckerParameters, distributionPoint2, x509Certificate3, pKIXExtendedParameters2, date3).iterator();
            boolean z10 = false;
            e = null;
            while (it2.hasNext() && certStatus.getCertStatus() == 11 && !reasonsMask.isAllReasons()) {
                try {
                    X509CRL x509crl2 = (X509CRL) it2.next();
                    ReasonsMask processCRLD = processCRLD(x509crl2, distributionPoint2);
                    if (!processCRLD.hasNewReasons(reasonsMask2)) {
                        continue;
                    } else {
                        ReasonsMask reasonsMask3 = processCRLD;
                        X509CRL x509crl3 = x509crl2;
                        it = it2;
                        try {
                            PublicKey processCRLG = processCRLG(x509crl3, processCRLF(x509crl2, x509Certificate, x509Certificate2, publicKey, pKIXExtendedParameters, list, jcaJceHelper));
                            if (pKIXExtendedParameters.isUseDeltasEnabled()) {
                                try {
                                    x509crl = processCRLH(CertPathValidatorUtilities.getDeltaCRLs(date3, x509crl3, pKIXExtendedParameters.getCertStores(), pKIXExtendedParameters.getCRLStores(), jcaJceHelper), processCRLG);
                                } catch (AnnotatedException e10) {
                                    e = e10;
                                    it2 = it;
                                }
                            } else {
                                JcaJceHelper jcaJceHelper2 = jcaJceHelper;
                                x509crl = null;
                            }
                            if (pKIXExtendedParameters.getValidityModel() != 1) {
                                try {
                                    if (x509Certificate.getNotAfter().getTime() < x509crl3.getThisUpdate().getTime()) {
                                        throw new AnnotatedException("No valid CRL for current time found.");
                                    }
                                } catch (AnnotatedException e11) {
                                    e = e11;
                                    it2 = it;
                                }
                            }
                            processCRLB1(distributionPoint2, x509Certificate3, x509crl3);
                            processCRLB2(distributionPoint2, x509Certificate3, x509crl3);
                            processCRLC(x509crl, x509crl3, pKIXExtendedParameters2);
                            processCRLI(date3, x509crl, x509Certificate3, certStatus2, pKIXExtendedParameters2);
                            processCRLJ(date3, x509crl3, x509Certificate3, certStatus2);
                            if (certStatus.getCertStatus() == 8) {
                                certStatus2.setCertStatus(11);
                            }
                            reasonsMask2.addReasons(reasonsMask3);
                            Set<String> criticalExtensionOIDs2 = x509crl3.getCriticalExtensionOIDs();
                            if (criticalExtensionOIDs2 != null) {
                                HashSet hashSet = new HashSet(criticalExtensionOIDs2);
                                hashSet.remove(Extension.issuingDistributionPoint.getId());
                                hashSet.remove(Extension.deltaCRLIndicator.getId());
                                if (!hashSet.isEmpty()) {
                                    throw new AnnotatedException("CRL contains unsupported critical extensions.");
                                }
                            }
                            if (!(x509crl == null || (criticalExtensionOIDs = x509crl.getCriticalExtensionOIDs()) == null)) {
                                HashSet hashSet2 = new HashSet(criticalExtensionOIDs);
                                hashSet2.remove(Extension.issuingDistributionPoint.getId());
                                hashSet2.remove(Extension.deltaCRLIndicator.getId());
                                if (!hashSet2.isEmpty()) {
                                    throw new AnnotatedException("Delta CRL contains unsupported critical extension.");
                                }
                            }
                            it2 = it;
                            z10 = true;
                        } catch (AnnotatedException e12) {
                            e = e12;
                            JcaJceHelper jcaJceHelper3 = jcaJceHelper;
                            it2 = it;
                        }
                    }
                } catch (AnnotatedException e13) {
                    e = e13;
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

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static void checkCRLs(org.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters r23, org.bouncycastle.jcajce.PKIXExtendedParameters r24, java.util.Date r25, java.util.Date r26, java.security.cert.X509Certificate r27, java.security.cert.X509Certificate r28, java.security.PublicKey r29, java.util.List r30, org.bouncycastle.jcajce.util.JcaJceHelper r31) throws org.bouncycastle.jce.provider.AnnotatedException, org.bouncycastle.jce.provider.RecoverableCertPathValidatorException {
        /*
            java.lang.String r0 = CRL_DISTRIBUTION_POINTS     // Catch:{ Exception -> 0x0196 }
            r13 = r27
            org.bouncycastle.asn1.ASN1Primitive r0 = org.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r13, r0)     // Catch:{ Exception -> 0x0196 }
            org.bouncycastle.asn1.x509.CRLDistPoint r0 = org.bouncycastle.asn1.x509.CRLDistPoint.getInstance(r0)     // Catch:{ Exception -> 0x0196 }
            org.bouncycastle.jcajce.PKIXExtendedParameters$Builder r1 = new org.bouncycastle.jcajce.PKIXExtendedParameters$Builder
            r14 = r24
            r1.<init>((org.bouncycastle.jcajce.PKIXExtendedParameters) r14)
            java.util.Map r2 = r24.getNamedCRLStoreMap()     // Catch:{ AnnotatedException -> 0x018d }
            r15 = r26
            r12 = r31
            java.util.List r2 = org.bouncycastle.jce.provider.CertPathValidatorUtilities.getAdditionalStoresFromCRLDistributionPoint(r0, r2, r15, r12)     // Catch:{ AnnotatedException -> 0x018d }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ AnnotatedException -> 0x018d }
        L_0x0023:
            boolean r3 = r2.hasNext()     // Catch:{ AnnotatedException -> 0x018d }
            if (r3 == 0) goto L_0x0033
            java.lang.Object r3 = r2.next()     // Catch:{ AnnotatedException -> 0x018d }
            org.bouncycastle.jcajce.PKIXCRLStore r3 = (org.bouncycastle.jcajce.PKIXCRLStore) r3     // Catch:{ AnnotatedException -> 0x018d }
            r1.addCRLStore(r3)     // Catch:{ AnnotatedException -> 0x018d }
            goto L_0x0023
        L_0x0033:
            org.bouncycastle.jce.provider.CertStatus r11 = new org.bouncycastle.jce.provider.CertStatus
            r11.<init>()
            org.bouncycastle.jce.provider.ReasonsMask r16 = new org.bouncycastle.jce.provider.ReasonsMask
            r16.<init>()
            org.bouncycastle.jcajce.PKIXExtendedParameters r17 = r1.build()
            r18 = 1
            r10 = 0
            r9 = 0
            r8 = 11
            if (r0 == 0) goto L_0x00ac
            org.bouncycastle.asn1.x509.DistributionPoint[] r7 = r0.getDistributionPoints()     // Catch:{ Exception -> 0x00a2 }
            if (r7 == 0) goto L_0x00ac
            r0 = r9
            r6 = r10
            r19 = r6
        L_0x0053:
            int r1 = r7.length
            if (r6 >= r1) goto L_0x009e
            int r1 = r11.getCertStatus()
            if (r1 != r8) goto L_0x009e
            boolean r1 = r16.isAllReasons()
            if (r1 != 0) goto L_0x009e
            r2 = r7[r6]     // Catch:{ AnnotatedException -> 0x0088 }
            r1 = r23
            r3 = r17
            r4 = r25
            r5 = r26
            r20 = r6
            r6 = r27
            r21 = r7
            r7 = r28
            r13 = r8
            r8 = r29
            r9 = r11
            r10 = r16
            r22 = r11
            r11 = r30
            r12 = r31
            checkCRL(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ AnnotatedException -> 0x0086 }
            r19 = r18
            goto L_0x0090
        L_0x0086:
            r0 = move-exception
            goto L_0x0090
        L_0x0088:
            r0 = move-exception
            r20 = r6
            r21 = r7
            r13 = r8
            r22 = r11
        L_0x0090:
            int r6 = r20 + 1
            r12 = r31
            r8 = r13
            r7 = r21
            r11 = r22
            r9 = 0
            r10 = 0
            r13 = r27
            goto L_0x0053
        L_0x009e:
            r13 = r8
            r22 = r11
            goto L_0x00b2
        L_0x00a2:
            r0 = move-exception
            r1 = r0
            org.bouncycastle.jce.provider.AnnotatedException r0 = new org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r2 = "Distribution points could not be read."
            r0.<init>(r2, r1)
            throw r0
        L_0x00ac:
            r13 = r8
            r22 = r11
            r0 = 0
            r19 = 0
        L_0x00b2:
            int r1 = r22.getCertStatus()
            if (r1 != r13) goto L_0x0104
            boolean r1 = r16.isAllReasons()
            if (r1 != 0) goto L_0x0104
            org.bouncycastle.asn1.x500.X500Name r1 = org.bouncycastle.jce.provider.PrincipalUtils.getIssuerPrincipal((java.security.cert.X509Certificate) r27)     // Catch:{ RuntimeException -> 0x00fa }
            org.bouncycastle.asn1.x509.DistributionPoint r2 = new org.bouncycastle.asn1.x509.DistributionPoint     // Catch:{ AnnotatedException -> 0x00f8 }
            org.bouncycastle.asn1.x509.DistributionPointName r3 = new org.bouncycastle.asn1.x509.DistributionPointName     // Catch:{ AnnotatedException -> 0x00f8 }
            org.bouncycastle.asn1.x509.GeneralNames r4 = new org.bouncycastle.asn1.x509.GeneralNames     // Catch:{ AnnotatedException -> 0x00f8 }
            org.bouncycastle.asn1.x509.GeneralName r5 = new org.bouncycastle.asn1.x509.GeneralName     // Catch:{ AnnotatedException -> 0x00f8 }
            r6 = 4
            r5.<init>((int) r6, (org.bouncycastle.asn1.ASN1Encodable) r1)     // Catch:{ AnnotatedException -> 0x00f8 }
            r4.<init>((org.bouncycastle.asn1.x509.GeneralName) r5)     // Catch:{ AnnotatedException -> 0x00f8 }
            r1 = 0
            r3.<init>(r1, r4)     // Catch:{ AnnotatedException -> 0x00f8 }
            r1 = 0
            r2.<init>(r3, r1, r1)     // Catch:{ AnnotatedException -> 0x00f8 }
            java.lang.Object r1 = r24.clone()     // Catch:{ AnnotatedException -> 0x00f8 }
            r3 = r1
            org.bouncycastle.jcajce.PKIXExtendedParameters r3 = (org.bouncycastle.jcajce.PKIXExtendedParameters) r3     // Catch:{ AnnotatedException -> 0x00f8 }
            r1 = r23
            r4 = r25
            r5 = r26
            r6 = r27
            r7 = r28
            r8 = r29
            r9 = r22
            r10 = r16
            r11 = r30
            r12 = r31
            checkCRL(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ AnnotatedException -> 0x00f8 }
            goto L_0x0106
        L_0x00f8:
            r0 = move-exception
            goto L_0x0104
        L_0x00fa:
            r0 = move-exception
            r1 = r0
            org.bouncycastle.jce.provider.AnnotatedException r0 = new org.bouncycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00f8 }
            java.lang.String r2 = "Issuer from certificate for CRL could not be reencoded."
            r0.<init>(r2, r1)     // Catch:{ AnnotatedException -> 0x00f8 }
            throw r0     // Catch:{ AnnotatedException -> 0x00f8 }
        L_0x0104:
            r18 = r19
        L_0x0106:
            if (r18 != 0) goto L_0x0115
            boolean r1 = r0 instanceof org.bouncycastle.jce.provider.AnnotatedException
            if (r1 == 0) goto L_0x010d
            throw r0
        L_0x010d:
            org.bouncycastle.jce.provider.AnnotatedException r1 = new org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r2 = "No valid CRL found."
            r1.<init>(r2, r0)
            throw r1
        L_0x0115:
            int r0 = r22.getCertStatus()
            if (r0 != r13) goto L_0x0140
            boolean r0 = r16.isAllReasons()
            r1 = 12
            if (r0 != 0) goto L_0x012f
            int r0 = r22.getCertStatus()
            if (r0 != r13) goto L_0x012f
            r2 = r22
            r2.setCertStatus(r1)
            goto L_0x0131
        L_0x012f:
            r2 = r22
        L_0x0131:
            int r0 = r2.getCertStatus()
            if (r0 == r1) goto L_0x0138
            return
        L_0x0138:
            org.bouncycastle.jce.provider.AnnotatedException r0 = new org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r1 = "Certificate status could not be determined."
            r0.<init>(r1)
            throw r0
        L_0x0140:
            r2 = r22
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "yyyy-MM-dd HH:mm:ss Z"
            r0.<init>(r1)
            java.lang.String r1 = "UTC"
            java.util.TimeZone r1 = j$.util.DesugarTimeZone.getTimeZone(r1)
            r0.setTimeZone(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Certificate revocation after "
            r1.append(r3)
            java.util.Date r3 = r2.getRevocationDate()
            java.lang.String r0 = r0.format(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = ", reason: "
            r1.append(r0)
            java.lang.String[] r0 = crlReasons
            int r2 = r2.getCertStatus()
            r0 = r0[r2]
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            org.bouncycastle.jce.provider.AnnotatedException r1 = new org.bouncycastle.jce.provider.AnnotatedException
            r1.<init>(r0)
            throw r1
        L_0x018d:
            r0 = move-exception
            org.bouncycastle.jce.provider.AnnotatedException r1 = new org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r2 = "No additional CRL locations could be decoded from CRL distribution point extension."
            r1.<init>(r2, r0)
            throw r1
        L_0x0196:
            r0 = move-exception
            org.bouncycastle.jce.provider.AnnotatedException r1 = new org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r2 = "CRL distribution point extension could not be read."
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.RFC3280CertPathUtilities.checkCRLs(org.bouncycastle.jcajce.PKIXCertRevocationCheckerParameters, org.bouncycastle.jcajce.PKIXExtendedParameters, java.util.Date, java.util.Date, java.security.cert.X509Certificate, java.security.cert.X509Certificate, java.security.PublicKey, java.util.List, org.bouncycastle.jcajce.util.JcaJceHelper):void");
    }

    protected static PKIXPolicyNode prepareCertB(CertPath certPath, int i10, List[] listArr, PKIXPolicyNode pKIXPolicyNode, int i11) throws CertPathValidatorException {
        boolean z10;
        CertPath certPath2 = certPath;
        int i12 = i10;
        List[] listArr2 = listArr;
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate = (X509Certificate) certificates.get(i12);
        int size = certificates.size() - i12;
        try {
            ASN1Sequence instance = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, POLICY_MAPPINGS));
            if (instance == null) {
                return pKIXPolicyNode;
            }
            HashMap hashMap = new HashMap();
            HashSet<String> hashSet = new HashSet<>();
            boolean z11 = false;
            for (int i13 = 0; i13 < instance.size(); i13++) {
                ASN1Sequence aSN1Sequence = (ASN1Sequence) instance.getObjectAt(i13);
                String id2 = ((ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0)).getId();
                String id3 = ((ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(1)).getId();
                if (!hashMap.containsKey(id2)) {
                    HashSet hashSet2 = new HashSet();
                    hashSet2.add(id3);
                    hashMap.put(id2, hashSet2);
                    hashSet.add(id2);
                } else {
                    ((Set) hashMap.get(id2)).add(id3);
                }
            }
            PKIXPolicyNode pKIXPolicyNode2 = pKIXPolicyNode;
            for (String str : hashSet) {
                if (i11 > 0) {
                    Iterator it = listArr2[size].iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z10 = z11;
                            break;
                        }
                        PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) it.next();
                        if (pKIXPolicyNode3.getValidPolicy().equals(str)) {
                            pKIXPolicyNode3.expectedPolicies = (Set) hashMap.get(str);
                            z10 = true;
                            break;
                        }
                    }
                    if (!z10) {
                        Iterator it2 = listArr2[size].iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            PKIXPolicyNode pKIXPolicyNode4 = (PKIXPolicyNode) it2.next();
                            if (ANY_POLICY.equals(pKIXPolicyNode4.getValidPolicy())) {
                                Set set = null;
                                try {
                                    Enumeration objects = ((ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, CERTIFICATE_POLICIES)).getObjects();
                                    while (true) {
                                        if (!objects.hasMoreElements()) {
                                            break;
                                        }
                                        try {
                                            PolicyInformation instance2 = PolicyInformation.getInstance(objects.nextElement());
                                            if (ANY_POLICY.equals(instance2.getPolicyIdentifier().getId())) {
                                                try {
                                                    set = CertPathValidatorUtilities.getQualifierSet(instance2.getPolicyQualifiers());
                                                    break;
                                                } catch (CertPathValidatorException e10) {
                                                    throw new ExtCertPathValidatorException("Policy qualifier info set could not be decoded.", e10, certPath2, i12);
                                                }
                                            }
                                        } catch (Exception e11) {
                                            throw new CertPathValidatorException("Policy information could not be decoded.", e11, certPath2, i12);
                                        }
                                    }
                                    Set set2 = set;
                                    boolean contains = x509Certificate.getCriticalExtensionOIDs() != null ? x509Certificate.getCriticalExtensionOIDs().contains(CERTIFICATE_POLICIES) : z11;
                                    PKIXPolicyNode pKIXPolicyNode5 = (PKIXPolicyNode) pKIXPolicyNode4.getParent();
                                    if (ANY_POLICY.equals(pKIXPolicyNode5.getValidPolicy())) {
                                        PKIXPolicyNode pKIXPolicyNode6 = r5;
                                        PKIXPolicyNode pKIXPolicyNode7 = new PKIXPolicyNode(new ArrayList(), size, (Set) hashMap.get(str), pKIXPolicyNode5, set2, str, contains);
                                        pKIXPolicyNode5.addChild(pKIXPolicyNode6);
                                        listArr2[size].add(pKIXPolicyNode6);
                                    }
                                } catch (AnnotatedException e12) {
                                    throw new ExtCertPathValidatorException("Certificate policies extension could not be decoded.", e12, certPath2, i12);
                                }
                            }
                        }
                    }
                } else if (i11 <= 0) {
                    Iterator it3 = listArr2[size].iterator();
                    while (it3.hasNext()) {
                        PKIXPolicyNode pKIXPolicyNode8 = (PKIXPolicyNode) it3.next();
                        if (pKIXPolicyNode8.getValidPolicy().equals(str)) {
                            ((PKIXPolicyNode) pKIXPolicyNode8.getParent()).removeChild(pKIXPolicyNode8);
                            it3.remove();
                            for (int i14 = size - 1; i14 >= 0; i14--) {
                                List list = listArr2[i14];
                                PKIXPolicyNode pKIXPolicyNode9 = pKIXPolicyNode2;
                                for (int i15 = 0; i15 < list.size(); i15++) {
                                    PKIXPolicyNode pKIXPolicyNode10 = (PKIXPolicyNode) list.get(i15);
                                    if (!pKIXPolicyNode10.hasChildren() && (pKIXPolicyNode9 = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNode9, listArr2, pKIXPolicyNode10)) == null) {
                                        break;
                                    }
                                }
                                pKIXPolicyNode2 = pKIXPolicyNode9;
                            }
                        }
                    }
                }
                z11 = false;
            }
            return pKIXPolicyNode2;
        } catch (AnnotatedException e13) {
            throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", e13, certPath2, i12);
        }
    }

    protected static void prepareNextCertA(CertPath certPath, int i10) throws CertPathValidatorException {
        try {
            ASN1Sequence instance = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i10), POLICY_MAPPINGS));
            if (instance != null) {
                int i11 = 0;
                while (i11 < instance.size()) {
                    try {
                        ASN1Sequence instance2 = ASN1Sequence.getInstance(instance.getObjectAt(i11));
                        ASN1ObjectIdentifier instance3 = ASN1ObjectIdentifier.getInstance(instance2.getObjectAt(0));
                        ASN1ObjectIdentifier instance4 = ASN1ObjectIdentifier.getInstance(instance2.getObjectAt(1));
                        if (ANY_POLICY.equals(instance3.getId())) {
                            throw new CertPathValidatorException("IssuerDomainPolicy is anyPolicy", (Throwable) null, certPath, i10);
                        } else if (!ANY_POLICY.equals(instance4.getId())) {
                            i11++;
                        } else {
                            throw new CertPathValidatorException("SubjectDomainPolicy is anyPolicy", (Throwable) null, certPath, i10);
                        }
                    } catch (Exception e10) {
                        throw new ExtCertPathValidatorException("Policy mappings extension contents could not be decoded.", e10, certPath, i10);
                    }
                }
            }
        } catch (AnnotatedException e11) {
            throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", e11, certPath, i10);
        }
    }

    protected static void prepareNextCertG(CertPath certPath, int i10, PKIXNameConstraintValidator pKIXNameConstraintValidator) throws CertPathValidatorException {
        try {
            ASN1Sequence instance = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i10), NAME_CONSTRAINTS));
            NameConstraints instance2 = instance != null ? NameConstraints.getInstance(instance) : null;
            if (instance2 != null) {
                GeneralSubtree[] permittedSubtrees = instance2.getPermittedSubtrees();
                if (permittedSubtrees != null) {
                    try {
                        pKIXNameConstraintValidator.intersectPermittedSubtree(permittedSubtrees);
                    } catch (Exception e10) {
                        throw new ExtCertPathValidatorException("Permitted subtrees cannot be build from name constraints extension.", e10, certPath, i10);
                    }
                }
                GeneralSubtree[] excludedSubtrees = instance2.getExcludedSubtrees();
                if (excludedSubtrees != null) {
                    int i11 = 0;
                    while (i11 != excludedSubtrees.length) {
                        try {
                            pKIXNameConstraintValidator.addExcludedSubtree(excludedSubtrees[i11]);
                            i11++;
                        } catch (Exception e11) {
                            throw new ExtCertPathValidatorException("Excluded subtrees cannot be build from name constraints extension.", e11, certPath, i10);
                        }
                    }
                }
            }
        } catch (Exception e12) {
            throw new ExtCertPathValidatorException("Name constraints extension could not be decoded.", e12, certPath, i10);
        }
    }

    protected static int prepareNextCertH1(CertPath certPath, int i10, int i11) {
        return (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i10)) || i11 == 0) ? i11 : i11 - 1;
    }

    protected static int prepareNextCertH2(CertPath certPath, int i10, int i11) {
        return (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i10)) || i11 == 0) ? i11 : i11 - 1;
    }

    protected static int prepareNextCertH3(CertPath certPath, int i10, int i11) {
        return (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i10)) || i11 == 0) ? i11 : i11 - 1;
    }

    protected static int prepareNextCertI1(CertPath certPath, int i10, int i11) throws CertPathValidatorException {
        try {
            ASN1Sequence instance = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i10), POLICY_CONSTRAINTS));
            if (instance != null) {
                Enumeration objects = instance.getObjects();
                while (true) {
                    if (!objects.hasMoreElements()) {
                        break;
                    }
                    try {
                        ASN1TaggedObject instance2 = ASN1TaggedObject.getInstance(objects.nextElement());
                        if (instance2.getTagNo() == 0) {
                            int intValueExact = ASN1Integer.getInstance(instance2, false).intValueExact();
                            if (intValueExact < i11) {
                                return intValueExact;
                            }
                        }
                    } catch (IllegalArgumentException e10) {
                        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", e10, certPath, i10);
                    }
                }
            }
            return i11;
        } catch (Exception e11) {
            throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", e11, certPath, i10);
        }
    }

    protected static int prepareNextCertI2(CertPath certPath, int i10, int i11) throws CertPathValidatorException {
        try {
            ASN1Sequence instance = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i10), POLICY_CONSTRAINTS));
            if (instance != null) {
                Enumeration objects = instance.getObjects();
                while (true) {
                    if (!objects.hasMoreElements()) {
                        break;
                    }
                    try {
                        ASN1TaggedObject instance2 = ASN1TaggedObject.getInstance(objects.nextElement());
                        if (instance2.getTagNo() == 1) {
                            int intValueExact = ASN1Integer.getInstance(instance2, false).intValueExact();
                            if (intValueExact < i11) {
                                return intValueExact;
                            }
                        }
                    } catch (IllegalArgumentException e10) {
                        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", e10, certPath, i10);
                    }
                }
            }
            return i11;
        } catch (Exception e11) {
            throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", e11, certPath, i10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r2 = r2.intValueExact();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static int prepareNextCertJ(java.security.cert.CertPath r2, int r3, int r4) throws java.security.cert.CertPathValidatorException {
        /*
            java.util.List r0 = r2.getCertificates()
            java.lang.Object r0 = r0.get(r3)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.lang.String r1 = INHIBIT_ANY_POLICY     // Catch:{ Exception -> 0x001e }
            org.bouncycastle.asn1.ASN1Primitive r0 = org.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r0, r1)     // Catch:{ Exception -> 0x001e }
            org.bouncycastle.asn1.ASN1Integer r2 = org.bouncycastle.asn1.ASN1Integer.getInstance(r0)     // Catch:{ Exception -> 0x001e }
            if (r2 == 0) goto L_0x001d
            int r2 = r2.intValueExact()
            if (r2 >= r4) goto L_0x001d
            return r2
        L_0x001d:
            return r4
        L_0x001e:
            r4 = move-exception
            org.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r1 = "Inhibit any-policy extension cannot be decoded."
            r0.<init>(r1, r4, r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.RFC3280CertPathUtilities.prepareNextCertJ(java.security.cert.CertPath, int, int):int");
    }

    protected static void prepareNextCertK(CertPath certPath, int i10) throws CertPathValidatorException {
        try {
            BasicConstraints instance = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i10), BASIC_CONSTRAINTS));
            if (instance == null) {
                throw new CertPathValidatorException("Intermediate certificate lacks BasicConstraints", (Throwable) null, certPath, i10);
            } else if (!instance.isCA()) {
                throw new CertPathValidatorException("Not a CA certificate", (Throwable) null, certPath, i10);
            }
        } catch (Exception e10) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e10, certPath, i10);
        }
    }

    protected static int prepareNextCertL(CertPath certPath, int i10, int i11) throws CertPathValidatorException {
        if (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i10))) {
            return i11;
        }
        if (i11 > 0) {
            return i11 - 1;
        }
        throw new ExtCertPathValidatorException("Max path length not greater than zero", (Throwable) null, certPath, i10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        r2 = (r2 = r2.getPathLenConstraint()).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static int prepareNextCertM(java.security.cert.CertPath r2, int r3, int r4) throws java.security.cert.CertPathValidatorException {
        /*
            java.util.List r0 = r2.getCertificates()
            java.lang.Object r0 = r0.get(r3)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.lang.String r1 = BASIC_CONSTRAINTS     // Catch:{ Exception -> 0x0024 }
            org.bouncycastle.asn1.ASN1Primitive r0 = org.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r0, r1)     // Catch:{ Exception -> 0x0024 }
            org.bouncycastle.asn1.x509.BasicConstraints r2 = org.bouncycastle.asn1.x509.BasicConstraints.getInstance(r0)     // Catch:{ Exception -> 0x0024 }
            if (r2 == 0) goto L_0x0023
            java.math.BigInteger r2 = r2.getPathLenConstraint()
            if (r2 == 0) goto L_0x0023
            int r2 = r2.intValue()
            if (r2 >= r4) goto L_0x0023
            return r2
        L_0x0023:
            return r4
        L_0x0024:
            r4 = move-exception
            org.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r1 = "Basic constraints extension cannot be decoded."
            r0.<init>(r1, r4, r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.RFC3280CertPathUtilities.prepareNextCertM(java.security.cert.CertPath, int, int):int");
    }

    protected static void prepareNextCertN(CertPath certPath, int i10) throws CertPathValidatorException {
        boolean[] keyUsage = ((X509Certificate) certPath.getCertificates().get(i10)).getKeyUsage();
        if (keyUsage == null) {
            return;
        }
        if (keyUsage.length <= 5 || !keyUsage[5]) {
            throw new ExtCertPathValidatorException("Issuer certificate keyusage extension is critical and does not permit key signing.", (Throwable) null, certPath, i10);
        }
    }

    protected static void prepareNextCertO(CertPath certPath, int i10, Set set, List list) throws CertPathValidatorException {
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i10);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((PKIXCertPathChecker) it.next()).check(x509Certificate, set);
            } catch (CertPathValidatorException e10) {
                throw new CertPathValidatorException(e10.getMessage(), e10.getCause(), certPath, i10);
            }
        }
        if (!set.isEmpty()) {
            throw new ExtCertPathValidatorException("Certificate has unsupported critical extension: " + set, (Throwable) null, certPath, i10);
        }
    }

    protected static void processCRLB1(DistributionPoint distributionPoint, Object obj, X509CRL x509crl) throws AnnotatedException {
        ASN1Primitive extensionValue = CertPathValidatorUtilities.getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT);
        int i10 = 0;
        boolean z10 = extensionValue != null && IssuingDistributionPoint.getInstance(extensionValue).isIndirectCRL();
        try {
            byte[] encoded = PrincipalUtils.getIssuerPrincipal(x509crl).getEncoded();
            if (distributionPoint.getCRLIssuer() != null) {
                GeneralName[] names = distributionPoint.getCRLIssuer().getNames();
                int i11 = 0;
                while (i10 < names.length) {
                    if (names[i10].getTagNo() == 4) {
                        try {
                            if (Arrays.areEqual(names[i10].getName().toASN1Primitive().getEncoded(), encoded)) {
                                i11 = 1;
                            }
                        } catch (IOException e10) {
                            throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e10);
                        }
                    }
                    i10++;
                }
                if (i11 != 0 && !z10) {
                    throw new AnnotatedException("Distribution point contains cRLIssuer field but CRL is not indirect.");
                } else if (i11 != 0) {
                    i10 = i11;
                } else {
                    throw new AnnotatedException("CRL issuer of CRL does not match CRL issuer of distribution point.");
                }
            } else if (PrincipalUtils.getIssuerPrincipal(x509crl).equals(PrincipalUtils.getEncodedIssuerPrincipal(obj))) {
                i10 = 1;
            }
            if (i10 == 0) {
                throw new AnnotatedException("Cannot find matching CRL issuer for certificate.");
            }
        } catch (IOException e11) {
            throw new AnnotatedException("Exception encoding CRL issuer: " + e11.getMessage(), e11);
        }
    }

    protected static void processCRLB2(DistributionPoint distributionPoint, Object obj, X509CRL x509crl) throws AnnotatedException {
        GeneralName[] generalNameArr;
        try {
            IssuingDistributionPoint instance = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT));
            if (instance != null) {
                if (instance.getDistributionPoint() != null) {
                    DistributionPointName distributionPoint2 = IssuingDistributionPoint.getInstance(instance).getDistributionPoint();
                    ArrayList arrayList = new ArrayList();
                    boolean z10 = false;
                    if (distributionPoint2.getType() == 0) {
                        GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                        for (GeneralName add : names) {
                            arrayList.add(add);
                        }
                    }
                    if (distributionPoint2.getType() == 1) {
                        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                        try {
                            Enumeration objects = ASN1Sequence.getInstance(PrincipalUtils.getIssuerPrincipal(x509crl)).getObjects();
                            while (objects.hasMoreElements()) {
                                aSN1EncodableVector.add((ASN1Encodable) objects.nextElement());
                            }
                            aSN1EncodableVector.add(distributionPoint2.getName());
                            arrayList.add(new GeneralName(X500Name.getInstance(new DERSequence(aSN1EncodableVector))));
                        } catch (Exception e10) {
                            throw new AnnotatedException("Could not read CRL issuer.", e10);
                        }
                    }
                    if (distributionPoint.getDistributionPoint() != null) {
                        DistributionPointName distributionPoint3 = distributionPoint.getDistributionPoint();
                        GeneralName[] generalNameArr2 = null;
                        if (distributionPoint3.getType() == 0) {
                            generalNameArr2 = GeneralNames.getInstance(distributionPoint3.getName()).getNames();
                        }
                        if (distributionPoint3.getType() == 1) {
                            if (distributionPoint.getCRLIssuer() != null) {
                                generalNameArr = distributionPoint.getCRLIssuer().getNames();
                            } else {
                                generalNameArr = new GeneralName[1];
                                try {
                                    generalNameArr[0] = new GeneralName(PrincipalUtils.getEncodedIssuerPrincipal(obj));
                                } catch (Exception e11) {
                                    throw new AnnotatedException("Could not read certificate issuer.", e11);
                                }
                            }
                            generalNameArr2 = generalNameArr;
                            for (int i10 = 0; i10 < generalNameArr2.length; i10++) {
                                Enumeration objects2 = ASN1Sequence.getInstance(generalNameArr2[i10].getName().toASN1Primitive()).getObjects();
                                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                                while (objects2.hasMoreElements()) {
                                    aSN1EncodableVector2.add((ASN1Encodable) objects2.nextElement());
                                }
                                aSN1EncodableVector2.add(distributionPoint3.getName());
                                generalNameArr2[i10] = new GeneralName(X500Name.getInstance(new DERSequence(aSN1EncodableVector2)));
                            }
                        }
                        if (generalNameArr2 != null) {
                            int i11 = 0;
                            while (true) {
                                if (i11 >= generalNameArr2.length) {
                                    break;
                                } else if (arrayList.contains(generalNameArr2[i11])) {
                                    z10 = true;
                                    break;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        if (!z10) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                        }
                    } else if (distributionPoint.getCRLIssuer() != null) {
                        GeneralName[] names2 = distributionPoint.getCRLIssuer().getNames();
                        int i12 = 0;
                        while (true) {
                            if (i12 >= names2.length) {
                                break;
                            } else if (arrayList.contains(names2[i12])) {
                                z10 = true;
                                break;
                            } else {
                                i12++;
                            }
                        }
                        if (!z10) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                        }
                    } else {
                        throw new AnnotatedException("Either the cRLIssuer or the distributionPoint field must be contained in DistributionPoint.");
                    }
                }
                try {
                    BasicConstraints instance2 = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension) obj, BASIC_CONSTRAINTS));
                    if (obj instanceof X509Certificate) {
                        if (instance.onlyContainsUserCerts() && instance2 != null && instance2.isCA()) {
                            throw new AnnotatedException("CA Cert CRL only contains user certificates.");
                        } else if (instance.onlyContainsCACerts() && (instance2 == null || !instance2.isCA())) {
                            throw new AnnotatedException("End CRL only contains CA certificates.");
                        }
                    }
                    if (instance.onlyContainsAttributeCerts()) {
                        throw new AnnotatedException("onlyContainsAttributeCerts boolean is asserted.");
                    }
                } catch (Exception e12) {
                    throw new AnnotatedException("Basic constraints extension could not be decoded.", e12);
                }
            }
        } catch (Exception e13) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e13);
        }
    }

    protected static void processCRLC(X509CRL x509crl, X509CRL x509crl2, PKIXExtendedParameters pKIXExtendedParameters) throws AnnotatedException {
        if (x509crl != null) {
            if (!x509crl.hasUnsupportedCriticalExtension()) {
                try {
                    String str = ISSUING_DISTRIBUTION_POINT;
                    IssuingDistributionPoint instance = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509crl2, str));
                    if (!pKIXExtendedParameters.isUseDeltasEnabled()) {
                        return;
                    }
                    if (PrincipalUtils.getIssuerPrincipal(x509crl).equals(PrincipalUtils.getIssuerPrincipal(x509crl2))) {
                        try {
                            IssuingDistributionPoint instance2 = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509crl, str));
                            boolean z10 = false;
                            if (instance != null ? instance.equals(instance2) : instance2 == null) {
                                z10 = true;
                            }
                            if (z10) {
                                try {
                                    String str2 = AUTHORITY_KEY_IDENTIFIER;
                                    ASN1Primitive extensionValue = CertPathValidatorUtilities.getExtensionValue(x509crl2, str2);
                                    try {
                                        ASN1Primitive extensionValue2 = CertPathValidatorUtilities.getExtensionValue(x509crl, str2);
                                        if (extensionValue == null) {
                                            throw new AnnotatedException("CRL authority key identifier is null.");
                                        } else if (extensionValue2 == null) {
                                            throw new AnnotatedException("Delta CRL authority key identifier is null.");
                                        } else if (!extensionValue.equals(extensionValue2)) {
                                            throw new AnnotatedException("Delta CRL authority key identifier does not match complete CRL authority key identifier.");
                                        }
                                    } catch (AnnotatedException e10) {
                                        throw new AnnotatedException("Authority key identifier extension could not be extracted from delta CRL.", e10);
                                    }
                                } catch (AnnotatedException e11) {
                                    throw new AnnotatedException("Authority key identifier extension could not be extracted from complete CRL.", e11);
                                }
                            } else {
                                throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.");
                            }
                        } catch (Exception e12) {
                            throw new AnnotatedException("Issuing distribution point extension from delta CRL could not be decoded.", e12);
                        }
                    } else {
                        throw new AnnotatedException("Complete CRL issuer does not match delta CRL issuer.");
                    }
                } catch (Exception e13) {
                    throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e13);
                }
            } else {
                throw new AnnotatedException("delta CRL has unsupported critical extensions");
            }
        }
    }

    protected static ReasonsMask processCRLD(X509CRL x509crl, DistributionPoint distributionPoint) throws AnnotatedException {
        try {
            IssuingDistributionPoint instance = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT));
            if (instance != null && instance.getOnlySomeReasons() != null && distributionPoint.getReasons() != null) {
                return new ReasonsMask(distributionPoint.getReasons()).intersect(new ReasonsMask(instance.getOnlySomeReasons()));
            }
            if ((instance == null || instance.getOnlySomeReasons() == null) && distributionPoint.getReasons() == null) {
                return ReasonsMask.allReasons;
            }
            return (distributionPoint.getReasons() == null ? ReasonsMask.allReasons : new ReasonsMask(distributionPoint.getReasons())).intersect(instance == null ? ReasonsMask.allReasons : new ReasonsMask(instance.getOnlySomeReasons()));
        } catch (Exception e10) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e10);
        }
    }

    protected static Set processCRLF(X509CRL x509crl, Object obj, X509Certificate x509Certificate, PublicKey publicKey, PKIXExtendedParameters pKIXExtendedParameters, List list, JcaJceHelper jcaJceHelper) throws AnnotatedException {
        int i10;
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(PrincipalUtils.getIssuerPrincipal(x509crl).getEncoded());
            PKIXCertStoreSelector<? extends Certificate> build = new PKIXCertStoreSelector.Builder(x509CertSelector).build();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            try {
                CertPathValidatorUtilities.findCertificates(linkedHashSet, build, pKIXExtendedParameters.getCertificateStores());
                CertPathValidatorUtilities.findCertificates(linkedHashSet, build, pKIXExtendedParameters.getCertStores());
                linkedHashSet.add(x509Certificate);
                Iterator it = linkedHashSet.iterator();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (x509Certificate2.equals(x509Certificate)) {
                        arrayList.add(x509Certificate2);
                        arrayList2.add(publicKey);
                    } else {
                        try {
                            CertPathBuilderSpi pKIXCertPathBuilderSpi_8 = revChkClass != null ? new PKIXCertPathBuilderSpi_8(true) : new PKIXCertPathBuilderSpi(true);
                            X509CertSelector x509CertSelector2 = new X509CertSelector();
                            x509CertSelector2.setCertificate(x509Certificate2);
                            PKIXExtendedParameters.Builder targetConstraints = new PKIXExtendedParameters.Builder(pKIXExtendedParameters).setTargetConstraints(new PKIXCertStoreSelector.Builder(x509CertSelector2).build());
                            if (list.contains(x509Certificate2)) {
                                targetConstraints.setRevocationEnabled(false);
                            } else {
                                targetConstraints.setRevocationEnabled(true);
                            }
                            List<? extends Certificate> certificates = pKIXCertPathBuilderSpi_8.engineBuild(new PKIXExtendedBuilderParameters.Builder(targetConstraints.build()).build()).getCertPath().getCertificates();
                            arrayList.add(x509Certificate2);
                            arrayList2.add(CertPathValidatorUtilities.getNextWorkingKey(certificates, 0, jcaJceHelper));
                        } catch (CertPathBuilderException e10) {
                            throw new AnnotatedException("CertPath for CRL signer failed to validate.", e10);
                        } catch (CertPathValidatorException e11) {
                            throw new AnnotatedException("Public key of issuer certificate of CRL could not be retrieved.", e11);
                        } catch (Exception e12) {
                            throw new AnnotatedException(e12.getMessage());
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                AnnotatedException annotatedException = null;
                for (i10 = 0; i10 < arrayList.size(); i10++) {
                    boolean[] keyUsage = ((X509Certificate) arrayList.get(i10)).getKeyUsage();
                    if (keyUsage == null || (keyUsage.length > 6 && keyUsage[6])) {
                        hashSet.add(arrayList2.get(i10));
                    } else {
                        annotatedException = new AnnotatedException("Issuer certificate key usage extension does not permit CRL signing.");
                    }
                }
                if (hashSet.isEmpty() && annotatedException == null) {
                    throw new AnnotatedException("Cannot find a valid issuer certificate.");
                } else if (!hashSet.isEmpty() || annotatedException == null) {
                    return hashSet;
                } else {
                    throw annotatedException;
                }
            } catch (AnnotatedException e13) {
                throw new AnnotatedException("Issuer certificate for CRL cannot be searched.", e13);
            }
        } catch (IOException e14) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate for CRL could not be set.", e14);
        }
    }

    protected static PublicKey processCRLG(X509CRL x509crl, Set set) throws AnnotatedException {
        Iterator it = set.iterator();
        Exception e10 = null;
        while (it.hasNext()) {
            PublicKey publicKey = (PublicKey) it.next();
            try {
                x509crl.verify(publicKey);
                return publicKey;
            } catch (Exception e11) {
                e10 = e11;
            }
        }
        throw new AnnotatedException("Cannot verify CRL.", e10);
    }

    protected static X509CRL processCRLH(Set set, PublicKey publicKey) throws AnnotatedException {
        Iterator it = set.iterator();
        Exception e10 = null;
        while (it.hasNext()) {
            X509CRL x509crl = (X509CRL) it.next();
            try {
                x509crl.verify(publicKey);
                return x509crl;
            } catch (Exception e11) {
                e10 = e11;
            }
        }
        if (e10 == null) {
            return null;
        }
        throw new AnnotatedException("Cannot verify delta CRL.", e10);
    }

    protected static void processCRLI(Date date, X509CRL x509crl, Object obj, CertStatus certStatus, PKIXExtendedParameters pKIXExtendedParameters) throws AnnotatedException {
        if (pKIXExtendedParameters.isUseDeltasEnabled() && x509crl != null) {
            CertPathValidatorUtilities.getCertStatus(date, x509crl, obj, certStatus);
        }
    }

    protected static void processCRLJ(Date date, X509CRL x509crl, Object obj, CertStatus certStatus) throws AnnotatedException {
        if (certStatus.getCertStatus() == 11) {
            CertPathValidatorUtilities.getCertStatus(date, x509crl, obj, certStatus);
        }
    }

    protected static void processCertA(CertPath certPath, PKIXExtendedParameters pKIXExtendedParameters, Date date, PKIXCertRevocationChecker pKIXCertRevocationChecker, int i10, PublicKey publicKey, boolean z10, X500Name x500Name, X509Certificate x509Certificate) throws CertPathValidatorException {
        CertPath certPath2 = certPath;
        PKIXCertRevocationChecker pKIXCertRevocationChecker2 = pKIXCertRevocationChecker;
        int i11 = i10;
        X500Name x500Name2 = x500Name;
        X509Certificate x509Certificate2 = (X509Certificate) certPath.getCertificates().get(i11);
        if (!z10) {
            try {
                CertPathValidatorUtilities.verifyX509Certificate(x509Certificate2, publicKey, pKIXExtendedParameters.getSigProvider());
            } catch (GeneralSecurityException e10) {
                throw new ExtCertPathValidatorException("Could not validate certificate signature.", e10, certPath, i11);
            }
        } else {
            PublicKey publicKey2 = publicKey;
        }
        try {
            Date date2 = date;
            Date validCertDateFromValidityModel = CertPathValidatorUtilities.getValidCertDateFromValidityModel(date, pKIXExtendedParameters.getValidityModel(), certPath, i11);
            try {
                x509Certificate2.checkValidity(validCertDateFromValidityModel);
                if (pKIXCertRevocationChecker2 != null) {
                    pKIXCertRevocationChecker2.initialize(new PKIXCertRevocationCheckerParameters(pKIXExtendedParameters, validCertDateFromValidityModel, certPath, i10, x509Certificate, publicKey));
                    pKIXCertRevocationChecker2.check(x509Certificate2);
                }
                X500Name issuerPrincipal = PrincipalUtils.getIssuerPrincipal(x509Certificate2);
                if (!issuerPrincipal.equals(x500Name2)) {
                    throw new ExtCertPathValidatorException("IssuerName(" + issuerPrincipal + ") does not match SubjectName(" + x500Name2 + ") of signing certificate.", (Throwable) null, certPath, i11);
                }
            } catch (CertificateExpiredException e11) {
                CertificateExpiredException certificateExpiredException = e11;
                throw new ExtCertPathValidatorException("Could not validate certificate: " + certificateExpiredException.getMessage(), certificateExpiredException, certPath, i11);
            } catch (CertificateNotYetValidException e12) {
                CertificateNotYetValidException certificateNotYetValidException = e12;
                throw new ExtCertPathValidatorException("Could not validate certificate: " + certificateNotYetValidException.getMessage(), certificateNotYetValidException, certPath, i11);
            }
        } catch (AnnotatedException e13) {
            throw new ExtCertPathValidatorException("Could not validate time of certificate.", e13, certPath, i11);
        }
    }

    protected static void processCertBC(CertPath certPath, int i10, PKIXNameConstraintValidator pKIXNameConstraintValidator, boolean z10) throws CertPathValidatorException {
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate = (X509Certificate) certificates.get(i10);
        int size = certificates.size();
        int i11 = size - i10;
        if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate) || (i11 >= size && !z10)) {
            try {
                ASN1Sequence instance = ASN1Sequence.getInstance(PrincipalUtils.getSubjectPrincipal(x509Certificate));
                try {
                    pKIXNameConstraintValidator.checkPermittedDN(instance);
                    pKIXNameConstraintValidator.checkExcludedDN(instance);
                    try {
                        GeneralNames instance2 = GeneralNames.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, SUBJECT_ALTERNATIVE_NAME));
                        RDN[] rDNs = X500Name.getInstance(instance).getRDNs(BCStyle.EmailAddress);
                        int i12 = 0;
                        int i13 = 0;
                        while (i13 != rDNs.length) {
                            GeneralName generalName = new GeneralName(1, ((ASN1String) rDNs[i13].getFirst().getValue()).getString());
                            try {
                                pKIXNameConstraintValidator.checkPermitted(generalName);
                                pKIXNameConstraintValidator.checkExcluded(generalName);
                                i13++;
                            } catch (PKIXNameConstraintValidatorException e10) {
                                throw new CertPathValidatorException("Subtree check for certificate subject alternative email failed.", e10, certPath, i10);
                            }
                        }
                        if (instance2 != null) {
                            try {
                                GeneralName[] names = instance2.getNames();
                                while (i12 < names.length) {
                                    try {
                                        pKIXNameConstraintValidator.checkPermitted(names[i12]);
                                        pKIXNameConstraintValidator.checkExcluded(names[i12]);
                                        i12++;
                                    } catch (PKIXNameConstraintValidatorException e11) {
                                        throw new CertPathValidatorException("Subtree check for certificate subject alternative name failed.", e11, certPath, i10);
                                    }
                                }
                            } catch (Exception e12) {
                                throw new CertPathValidatorException("Subject alternative name contents could not be decoded.", e12, certPath, i10);
                            }
                        }
                    } catch (Exception e13) {
                        throw new CertPathValidatorException("Subject alternative name extension could not be decoded.", e13, certPath, i10);
                    }
                } catch (PKIXNameConstraintValidatorException e14) {
                    throw new CertPathValidatorException("Subtree check for certificate subject failed.", e14, certPath, i10);
                }
            } catch (Exception e15) {
                throw new CertPathValidatorException("Exception extracting subject name when checking subtrees.", e15, certPath, i10);
            }
        }
    }

    protected static PKIXPolicyNode processCertD(CertPath certPath, int i10, Set set, PKIXPolicyNode pKIXPolicyNode, List[] listArr, int i11, boolean z10) throws CertPathValidatorException {
        String id2;
        CertPath certPath2 = certPath;
        int i12 = i10;
        Set set2 = set;
        List[] listArr2 = listArr;
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate = (X509Certificate) certificates.get(i12);
        int size = certificates.size();
        int i13 = size - i12;
        try {
            ASN1Sequence instance = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, CERTIFICATE_POLICIES));
            if (instance == null || pKIXPolicyNode == null) {
                return null;
            }
            Enumeration objects = instance.getObjects();
            HashSet hashSet = new HashSet();
            while (objects.hasMoreElements()) {
                PolicyInformation instance2 = PolicyInformation.getInstance(objects.nextElement());
                ASN1ObjectIdentifier policyIdentifier = instance2.getPolicyIdentifier();
                hashSet.add(policyIdentifier.getId());
                if (!ANY_POLICY.equals(policyIdentifier.getId())) {
                    try {
                        Set qualifierSet = CertPathValidatorUtilities.getQualifierSet(instance2.getPolicyQualifiers());
                        if (!CertPathValidatorUtilities.processCertD1i(i13, listArr2, policyIdentifier, qualifierSet)) {
                            CertPathValidatorUtilities.processCertD1ii(i13, listArr2, policyIdentifier, qualifierSet);
                        }
                    } catch (CertPathValidatorException e10) {
                        throw new ExtCertPathValidatorException("Policy qualifier info set could not be build.", e10, certPath2, i12);
                    }
                }
            }
            if (set.isEmpty() || set2.contains(ANY_POLICY)) {
                set.clear();
                set2.addAll(hashSet);
            } else {
                HashSet hashSet2 = new HashSet();
                for (Object next : set) {
                    if (hashSet.contains(next)) {
                        hashSet2.add(next);
                    }
                }
                set.clear();
                set2.addAll(hashSet2);
            }
            if (i11 > 0 || ((i13 < size || z10) && CertPathValidatorUtilities.isSelfIssued(x509Certificate))) {
                Enumeration objects2 = instance.getObjects();
                while (true) {
                    if (!objects2.hasMoreElements()) {
                        break;
                    }
                    PolicyInformation instance3 = PolicyInformation.getInstance(objects2.nextElement());
                    if (ANY_POLICY.equals(instance3.getPolicyIdentifier().getId())) {
                        Set qualifierSet2 = CertPathValidatorUtilities.getQualifierSet(instance3.getPolicyQualifiers());
                        List list = listArr2[i13 - 1];
                        for (int i14 = 0; i14 < list.size(); i14++) {
                            PKIXPolicyNode pKIXPolicyNode2 = (PKIXPolicyNode) list.get(i14);
                            for (Object next2 : pKIXPolicyNode2.getExpectedPolicies()) {
                                if (next2 instanceof String) {
                                    id2 = (String) next2;
                                } else if (next2 instanceof ASN1ObjectIdentifier) {
                                    id2 = ((ASN1ObjectIdentifier) next2).getId();
                                }
                                String str = id2;
                                Iterator children = pKIXPolicyNode2.getChildren();
                                boolean z11 = false;
                                while (children.hasNext()) {
                                    if (str.equals(((PKIXPolicyNode) children.next()).getValidPolicy())) {
                                        z11 = true;
                                    }
                                }
                                if (!z11) {
                                    HashSet hashSet3 = new HashSet();
                                    hashSet3.add(str);
                                    PKIXPolicyNode pKIXPolicyNode3 = r6;
                                    PKIXPolicyNode pKIXPolicyNode4 = new PKIXPolicyNode(new ArrayList(), i13, hashSet3, pKIXPolicyNode2, qualifierSet2, str, false);
                                    pKIXPolicyNode2.addChild(pKIXPolicyNode3);
                                    listArr2[i13].add(pKIXPolicyNode3);
                                }
                            }
                        }
                    }
                }
            }
            PKIXPolicyNode pKIXPolicyNode5 = pKIXPolicyNode;
            for (int i15 = i13 - 1; i15 >= 0; i15--) {
                List list2 = listArr2[i15];
                for (int i16 = 0; i16 < list2.size(); i16++) {
                    PKIXPolicyNode pKIXPolicyNode6 = (PKIXPolicyNode) list2.get(i16);
                    if (!pKIXPolicyNode6.hasChildren() && (pKIXPolicyNode5 = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNode5, listArr2, pKIXPolicyNode6)) == null) {
                        break;
                    }
                }
            }
            Set<String> criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
            if (criticalExtensionOIDs != null) {
                boolean contains = criticalExtensionOIDs.contains(CERTIFICATE_POLICIES);
                List list3 = listArr2[i13];
                for (int i17 = 0; i17 < list3.size(); i17++) {
                    ((PKIXPolicyNode) list3.get(i17)).setCritical(contains);
                }
            }
            return pKIXPolicyNode5;
        } catch (AnnotatedException e11) {
            throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", e11, certPath2, i12);
        }
    }

    protected static PKIXPolicyNode processCertE(CertPath certPath, int i10, PKIXPolicyNode pKIXPolicyNode) throws CertPathValidatorException {
        try {
            if (ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i10), CERTIFICATE_POLICIES)) == null) {
                return null;
            }
            return pKIXPolicyNode;
        } catch (AnnotatedException e10) {
            throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", e10, certPath, i10);
        }
    }

    protected static void processCertF(CertPath certPath, int i10, PKIXPolicyNode pKIXPolicyNode, int i11) throws CertPathValidatorException {
        if (i11 <= 0 && pKIXPolicyNode == null) {
            throw new ExtCertPathValidatorException("No valid policy tree found when one expected.", (Throwable) null, certPath, i10);
        }
    }

    protected static int wrapupCertA(int i10, X509Certificate x509Certificate) {
        return (CertPathValidatorUtilities.isSelfIssued(x509Certificate) || i10 == 0) ? i10 : i10 - 1;
    }

    protected static int wrapupCertB(CertPath certPath, int i10, int i11) throws CertPathValidatorException {
        try {
            ASN1Sequence instance = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i10), POLICY_CONSTRAINTS));
            if (instance != null) {
                Enumeration objects = instance.getObjects();
                while (objects.hasMoreElements()) {
                    ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
                    if (aSN1TaggedObject.getTagNo() == 0) {
                        try {
                            if (ASN1Integer.getInstance(aSN1TaggedObject, false).intValueExact() == 0) {
                                return 0;
                            }
                        } catch (Exception e10) {
                            throw new ExtCertPathValidatorException("Policy constraints requireExplicitPolicy field could not be decoded.", e10, certPath, i10);
                        }
                    }
                }
            }
            return i11;
        } catch (AnnotatedException e11) {
            throw new ExtCertPathValidatorException("Policy constraints could not be decoded.", e11, certPath, i10);
        }
    }

    protected static void wrapupCertF(CertPath certPath, int i10, List list, Set set) throws CertPathValidatorException {
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i10);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((PKIXCertPathChecker) it.next()).check(x509Certificate, set);
            } catch (CertPathValidatorException e10) {
                throw new ExtCertPathValidatorException(e10.getMessage(), e10, certPath, i10);
            } catch (Exception e11) {
                throw new CertPathValidatorException("Additional certificate path checker failed.", e11, certPath, i10);
            }
        }
        if (!set.isEmpty()) {
            throw new ExtCertPathValidatorException("Certificate has unsupported critical extension: " + set, (Throwable) null, certPath, i10);
        }
    }

    protected static PKIXPolicyNode wrapupCertG(CertPath certPath, PKIXExtendedParameters pKIXExtendedParameters, Set set, int i10, List[] listArr, PKIXPolicyNode pKIXPolicyNode, Set set2) throws CertPathValidatorException {
        int size = certPath.getCertificates().size();
        if (pKIXPolicyNode != null) {
            if (!CertPathValidatorUtilities.isAnyPolicy(set)) {
                HashSet<PKIXPolicyNode> hashSet = new HashSet<>();
                for (List list : listArr) {
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        PKIXPolicyNode pKIXPolicyNode2 = (PKIXPolicyNode) list.get(i11);
                        if (ANY_POLICY.equals(pKIXPolicyNode2.getValidPolicy())) {
                            Iterator children = pKIXPolicyNode2.getChildren();
                            while (children.hasNext()) {
                                PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) children.next();
                                if (!ANY_POLICY.equals(pKIXPolicyNode3.getValidPolicy())) {
                                    hashSet.add(pKIXPolicyNode3);
                                }
                            }
                        }
                    }
                }
                for (PKIXPolicyNode pKIXPolicyNode4 : hashSet) {
                    if (!set.contains(pKIXPolicyNode4.getValidPolicy())) {
                        pKIXPolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNode, listArr, pKIXPolicyNode4);
                    }
                }
                if (pKIXPolicyNode != null) {
                    for (int i12 = size - 1; i12 >= 0; i12--) {
                        List list2 = listArr[i12];
                        for (int i13 = 0; i13 < list2.size(); i13++) {
                            PKIXPolicyNode pKIXPolicyNode5 = (PKIXPolicyNode) list2.get(i13);
                            if (!pKIXPolicyNode5.hasChildren()) {
                                pKIXPolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNode, listArr, pKIXPolicyNode5);
                            }
                        }
                    }
                }
            } else if (pKIXExtendedParameters.isExplicitPolicyRequired()) {
                if (!set2.isEmpty()) {
                    HashSet<PKIXPolicyNode> hashSet2 = new HashSet<>();
                    for (List list3 : listArr) {
                        for (int i14 = 0; i14 < list3.size(); i14++) {
                            PKIXPolicyNode pKIXPolicyNode6 = (PKIXPolicyNode) list3.get(i14);
                            if (ANY_POLICY.equals(pKIXPolicyNode6.getValidPolicy())) {
                                Iterator children2 = pKIXPolicyNode6.getChildren();
                                while (children2.hasNext()) {
                                    hashSet2.add(children2.next());
                                }
                            }
                        }
                    }
                    for (PKIXPolicyNode validPolicy : hashSet2) {
                        set2.contains(validPolicy.getValidPolicy());
                    }
                    for (int i15 = size - 1; i15 >= 0; i15--) {
                        List list4 = listArr[i15];
                        for (int i16 = 0; i16 < list4.size(); i16++) {
                            PKIXPolicyNode pKIXPolicyNode7 = (PKIXPolicyNode) list4.get(i16);
                            if (!pKIXPolicyNode7.hasChildren()) {
                                pKIXPolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNode, listArr, pKIXPolicyNode7);
                            }
                        }
                    }
                } else {
                    throw new ExtCertPathValidatorException("Explicit policy requested but none available.", (Throwable) null, certPath, i10);
                }
            }
            return pKIXPolicyNode;
        } else if (!pKIXExtendedParameters.isExplicitPolicyRequired()) {
            return null;
        } else {
            throw new ExtCertPathValidatorException("Explicit policy requested but none available.", (Throwable) null, certPath, i10);
        }
    }
}
