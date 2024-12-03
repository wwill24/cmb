package org.minidns.dane;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import net.bytebuddy.utility.JavaConstant;
import org.minidns.dane.DaneCertificateException;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsname.DnsName;
import org.minidns.dnssec.b;
import org.minidns.dnssec.c;
import org.minidns.record.Record;
import org.minidns.record.TLSA;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f33571b = Logger.getLogger(a.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final org.minidns.dnssec.a f33572a;

    /* renamed from: org.minidns.dane.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0389a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33573a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f33574b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f33575c;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|(2:15|16)|17|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0068 */
        static {
            /*
                org.minidns.record.TLSA$MatchingType[] r0 = org.minidns.record.TLSA.MatchingType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33575c = r0
                r1 = 1
                org.minidns.record.TLSA$MatchingType r2 = org.minidns.record.TLSA.MatchingType.noHash     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f33575c     // Catch:{ NoSuchFieldError -> 0x001d }
                org.minidns.record.TLSA$MatchingType r3 = org.minidns.record.TLSA.MatchingType.f41649b     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f33575c     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.minidns.record.TLSA$MatchingType r4 = org.minidns.record.TLSA.MatchingType.sha512     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                org.minidns.record.TLSA$Selector[] r3 = org.minidns.record.TLSA.Selector.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f33574b = r3
                org.minidns.record.TLSA$Selector r4 = org.minidns.record.TLSA.Selector.fullCertificate     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = f33574b     // Catch:{ NoSuchFieldError -> 0x0043 }
                org.minidns.record.TLSA$Selector r4 = org.minidns.record.TLSA.Selector.subjectPublicKeyInfo     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                org.minidns.record.TLSA$CertUsage[] r3 = org.minidns.record.TLSA.CertUsage.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f33573a = r3
                org.minidns.record.TLSA$CertUsage r4 = org.minidns.record.TLSA.CertUsage.serviceCertificateConstraint     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r1 = f33573a     // Catch:{ NoSuchFieldError -> 0x005e }
                org.minidns.record.TLSA$CertUsage r3 = org.minidns.record.TLSA.CertUsage.domainIssuedCertificate     // Catch:{ NoSuchFieldError -> 0x005e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r0 = f33573a     // Catch:{ NoSuchFieldError -> 0x0068 }
                org.minidns.record.TLSA$CertUsage r1 = org.minidns.record.TLSA.CertUsage.caConstraint     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r0 = f33573a     // Catch:{ NoSuchFieldError -> 0x0073 }
                org.minidns.record.TLSA$CertUsage r1 = org.minidns.record.TLSA.CertUsage.trustAnchorAssertion     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.minidns.dane.a.C0389a.<clinit>():void");
        }
    }

    public a() {
        this(new org.minidns.dnssec.a());
    }

    private static boolean a(X509Certificate x509Certificate, TLSA tlsa, String str) throws CertificateException {
        byte[] bArr;
        TLSA.CertUsage certUsage = tlsa.f41637d;
        if (certUsage == null) {
            Logger logger = f33571b;
            logger.warning("TLSA certificate usage byte " + tlsa.f41636c + " is not supported while verifying " + str);
            return false;
        }
        int i10 = C0389a.f33573a[certUsage.ordinal()];
        if (i10 == 1 || i10 == 2) {
            TLSA.Selector selector = tlsa.f41639f;
            if (selector == null) {
                Logger logger2 = f33571b;
                logger2.warning("TLSA selector byte " + tlsa.f41638e + " is not supported while verifying " + str);
                return false;
            }
            int i11 = C0389a.f33574b[selector.ordinal()];
            if (i11 == 1) {
                bArr = x509Certificate.getEncoded();
            } else if (i11 != 2) {
                Logger logger3 = f33571b;
                logger3.warning("TLSA selector " + tlsa.f41639f + " (" + tlsa.f41638e + ") not supported while verifying " + str);
                return false;
            } else {
                bArr = x509Certificate.getPublicKey().getEncoded();
            }
            TLSA.MatchingType matchingType = tlsa.f41641h;
            if (matchingType == null) {
                Logger logger4 = f33571b;
                logger4.warning("TLSA matching type byte " + tlsa.f41640g + " is not supported while verifying " + str);
                return false;
            }
            int i12 = C0389a.f33575c[matchingType.ordinal()];
            if (i12 != 1) {
                if (i12 == 2) {
                    try {
                        bArr = MessageDigest.getInstance("SHA-256").digest(bArr);
                    } catch (NoSuchAlgorithmException e10) {
                        throw new CertificateException("Verification using TLSA failed: could not SHA-256 for matching", e10);
                    }
                } else if (i12 != 3) {
                    Logger logger5 = f33571b;
                    logger5.warning("TLSA matching type " + tlsa.f41641h + " not supported while verifying " + str);
                    return false;
                } else {
                    try {
                        bArr = MessageDigest.getInstance("SHA-512").digest(bArr);
                    } catch (NoSuchAlgorithmException e11) {
                        throw new CertificateException("Verification using TLSA failed: could not SHA-512 for matching", e11);
                    }
                }
            }
            if (!tlsa.l(bArr)) {
                throw new DaneCertificateException.CertificateMismatch(tlsa, bArr);
            } else if (tlsa.f41637d == TLSA.CertUsage.domainIssuedCertificate) {
                return true;
            } else {
                return false;
            }
        } else {
            Logger logger6 = f33571b;
            logger6.warning("TLSA certificate usage " + tlsa.f41637d + " (" + tlsa.f41636c + ") not supported while verifying " + str);
            return false;
        }
    }

    private static X509Certificate[] b(Certificate[] certificateArr) {
        ArrayList arrayList = new ArrayList();
        for (X509Certificate x509Certificate : certificateArr) {
            if (x509Certificate instanceof X509Certificate) {
                arrayList.add(x509Certificate);
            }
        }
        return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
    }

    public boolean c(SSLSession sSLSession) throws CertificateException {
        try {
            return d(b(sSLSession.getPeerCertificates()), sSLSession.getPeerHost(), sSLSession.getPeerPort());
        } catch (SSLPeerUnverifiedException e10) {
            throw new CertificateException("Peer not verified", e10);
        }
    }

    public boolean d(X509Certificate[] x509CertificateArr, String str, int i10) throws CertificateException {
        DnsName c10 = DnsName.c(JavaConstant.Dynamic.DEFAULT_NAME + i10 + "._tcp." + str);
        try {
            b v10 = this.f33572a.v(c10, Record.TYPE.TLSA);
            DnsMessage dnsMessage = v10.f33692b.f33670c;
            if (!v10.b()) {
                String str2 = "Got TLSA response from DNS server, but was not signed properly." + " Reasons:";
                for (c cVar : v10.a()) {
                    str2 = str2 + " " + cVar;
                }
                f33571b.info(str2);
                return false;
            }
            LinkedList linkedList = new LinkedList();
            boolean z10 = false;
            for (Record next : dnsMessage.f33593l) {
                if (next.f41571b == Record.TYPE.TLSA && next.f41570a.equals(c10)) {
                    try {
                        z10 |= a(x509CertificateArr[0], (TLSA) next.f41575f, str);
                    } catch (DaneCertificateException.CertificateMismatch e10) {
                        linkedList.add(e10);
                    }
                    if (z10) {
                        break;
                    }
                }
            }
            if (z10 || linkedList.isEmpty()) {
                return z10;
            }
            throw new DaneCertificateException.MultipleCertificateMismatchExceptions(linkedList);
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }

    public a(org.minidns.dnssec.a aVar) {
        this.f33572a = aVar;
    }
}
