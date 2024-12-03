package pn;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Date;
import on.b;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.operator.jcajce.JcePBEKeyEncryptionMethodGenerator;
import org.bouncycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;
import qn.c;

public class a {
    private static byte[] a(byte[] bArr, int i10) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PGPCompressedDataGenerator pGPCompressedDataGenerator = new PGPCompressedDataGenerator(i10);
        OutputStream open = new PGPLiteralDataGenerator().open(pGPCompressedDataGenerator.open(byteArrayOutputStream), 'b', "_CONSOLE", (long) bArr.length, new Date());
        open.write(bArr);
        open.close();
        pGPCompressedDataGenerator.close();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: org.bouncycastle.openpgp.PGPEncryptedDataList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0096 A[SYNTHETIC, Splitter:B:31:0x0096] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(byte[] r3, qn.c r4) throws java.io.IOException, org.bouncycastle.openpgp.PGPException {
        /*
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r3)
            r0.<init>(r1)
            java.io.InputStream r3 = org.bouncycastle.openpgp.PGPUtil.getDecoderStream(r0)
            org.bouncycastle.openpgp.bc.BcPGPObjectFactory r0 = new org.bouncycastle.openpgp.bc.BcPGPObjectFactory     // Catch:{ all -> 0x009a }
            r0.<init>(r3)     // Catch:{ all -> 0x009a }
            java.lang.Object r1 = r0.nextObject()     // Catch:{ all -> 0x009a }
            boolean r2 = r1 instanceof org.bouncycastle.openpgp.PGPEncryptedDataList     // Catch:{ all -> 0x009a }
            if (r2 == 0) goto L_0x001e
            org.bouncycastle.openpgp.PGPEncryptedDataList r1 = (org.bouncycastle.openpgp.PGPEncryptedDataList) r1     // Catch:{ all -> 0x009a }
            goto L_0x0025
        L_0x001e:
            java.lang.Object r0 = r0.nextObject()     // Catch:{ all -> 0x009a }
            r1 = r0
            org.bouncycastle.openpgp.PGPEncryptedDataList r1 = (org.bouncycastle.openpgp.PGPEncryptedDataList) r1     // Catch:{ all -> 0x009a }
        L_0x0025:
            r0 = 0
            org.bouncycastle.openpgp.PGPEncryptedData r0 = r1.get(r0)     // Catch:{ all -> 0x009a }
            org.bouncycastle.openpgp.PGPPBEEncryptedData r0 = (org.bouncycastle.openpgp.PGPPBEEncryptedData) r0     // Catch:{ all -> 0x009a }
            org.bouncycastle.openpgp.operator.bc.BcPBEDataDecryptorFactory r1 = new org.bouncycastle.openpgp.operator.bc.BcPBEDataDecryptorFactory     // Catch:{ all -> 0x009a }
            char[] r4 = r4.b()     // Catch:{ all -> 0x009a }
            org.bouncycastle.openpgp.operator.bc.BcPGPDigestCalculatorProvider r2 = new org.bouncycastle.openpgp.operator.bc.BcPGPDigestCalculatorProvider     // Catch:{ all -> 0x009a }
            r2.<init>()     // Catch:{ all -> 0x009a }
            r1.<init>(r4, r2)     // Catch:{ all -> 0x009a }
            java.io.InputStream r4 = r0.getDataStream(r1)     // Catch:{ all -> 0x009a }
            org.bouncycastle.openpgp.bc.BcPGPObjectFactory r1 = new org.bouncycastle.openpgp.bc.BcPGPObjectFactory     // Catch:{ all -> 0x009a }
            r1.<init>(r4)     // Catch:{ all -> 0x009a }
            java.lang.Object r4 = r1.nextObject()     // Catch:{ all -> 0x009a }
            boolean r1 = r4 instanceof org.bouncycastle.openpgp.PGPCompressedData     // Catch:{ all -> 0x009a }
            if (r1 == 0) goto L_0x005a
            org.bouncycastle.openpgp.PGPCompressedData r4 = (org.bouncycastle.openpgp.PGPCompressedData) r4     // Catch:{ all -> 0x009a }
            org.bouncycastle.openpgp.bc.BcPGPObjectFactory r1 = new org.bouncycastle.openpgp.bc.BcPGPObjectFactory     // Catch:{ all -> 0x009a }
            java.io.InputStream r4 = r4.getDataStream()     // Catch:{ all -> 0x009a }
            r1.<init>(r4)     // Catch:{ all -> 0x009a }
            java.lang.Object r4 = r1.nextObject()     // Catch:{ all -> 0x009a }
        L_0x005a:
            org.bouncycastle.openpgp.PGPLiteralData r4 = (org.bouncycastle.openpgp.PGPLiteralData) r4     // Catch:{ all -> 0x009a }
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x009a }
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0093 }
            r2.<init>()     // Catch:{ all -> 0x0093 }
            org.bouncycastle.util.io.Streams.pipeAll(r4, r2)     // Catch:{ all -> 0x0090 }
            r2.close()     // Catch:{ all -> 0x009a }
            r3.close()
            boolean r3 = r0.isIntegrityProtected()
            if (r3 == 0) goto L_0x0088
            boolean r3 = r0.verify()
            if (r3 == 0) goto L_0x0080
            byte[] r3 = r2.toByteArray()
            return r3
        L_0x0080:
            org.bouncycastle.openpgp.PGPException r3 = new org.bouncycastle.openpgp.PGPException
            java.lang.String r4 = "Integrity check failed."
            r3.<init>(r4)
            throw r3
        L_0x0088:
            org.bouncycastle.openpgp.PGPException r3 = new org.bouncycastle.openpgp.PGPException
            java.lang.String r4 = "Symmetrically encrypted data is not integrity protected."
            r3.<init>(r4)
            throw r3
        L_0x0090:
            r4 = move-exception
            r1 = r2
            goto L_0x0094
        L_0x0093:
            r4 = move-exception
        L_0x0094:
            if (r1 == 0) goto L_0x0099
            r1.close()     // Catch:{ all -> 0x009a }
        L_0x0099:
            throw r4     // Catch:{ all -> 0x009a }
        L_0x009a:
            r4 = move-exception
            r3.close()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: pn.a.b(byte[], qn.c):byte[]");
    }

    public static byte[] c(byte[] bArr, c cVar, SymmetricKeyAlgorithm symmetricKeyAlgorithm, CompressionAlgorithm compressionAlgorithm) throws IOException, PGPException {
        byte[] a10 = a(bArr, compressionAlgorithm.b());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PGPEncryptedDataGenerator pGPEncryptedDataGenerator = new PGPEncryptedDataGenerator(new JcePGPDataEncryptorBuilder(symmetricKeyAlgorithm.b()).setWithIntegrityPacket(true).setSecureRandom(new SecureRandom()).setProvider(b.b()));
        pGPEncryptedDataGenerator.addMethod(new JcePBEKeyEncryptionMethodGenerator(cVar.b()).setProvider(b.b()));
        OutputStream open = pGPEncryptedDataGenerator.open(byteArrayOutputStream, (long) a10.length);
        open.write(a10);
        open.close();
        return byteArrayOutputStream.toByteArray();
    }
}
