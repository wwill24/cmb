package org.minidns.record;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;

public class m extends h {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f41681f = Logger.getLogger(m.class.getName());

    /* renamed from: c  reason: collision with root package name */
    public final DnsName f41682c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f41683d;

    /* renamed from: e  reason: collision with root package name */
    public final List<Record.TYPE> f41684e;

    public m(DnsName dnsName, List<Record.TYPE> list) {
        this.f41682c = dnsName;
        this.f41684e = Collections.unmodifiableList(list);
        this.f41683d = i(list);
    }

    static byte[] i(List<Record.TYPE> list) {
        ArrayList<Integer> arrayList = new ArrayList<>(list.size());
        for (Record.TYPE d10 : list) {
            arrayList.add(Integer.valueOf(d10.d()));
        }
        Collections.sort(arrayList);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        byte[] bArr = null;
        try {
            int i10 = -1;
            for (Integer num : arrayList) {
                if (i10 == -1 || (num.intValue() >> 8) != i10) {
                    if (i10 != -1) {
                        l(bArr, dataOutputStream);
                    }
                    i10 = num.intValue() >> 8;
                    dataOutputStream.writeByte(i10);
                    bArr = new byte[32];
                }
                int intValue = (num.intValue() >> 3) % 32;
                bArr[intValue] = (byte) ((128 >> (num.intValue() % 8)) | bArr[intValue]);
            }
            if (i10 != -1) {
                l(bArr, dataOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static m j(DataInputStream dataInputStream, byte[] bArr, int i10) throws IOException {
        DnsName v10 = DnsName.v(dataInputStream, bArr);
        int A = i10 - v10.A();
        byte[] bArr2 = new byte[A];
        if (dataInputStream.read(bArr2) == A) {
            return new m(v10, k(bArr2));
        }
        throw new IOException();
    }

    static List<Record.TYPE> k(byte[] bArr) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (bArr.length > i10) {
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            int readUnsignedByte2 = dataInputStream.readUnsignedByte();
            for (int i11 = 0; i11 < readUnsignedByte2; i11++) {
                int readUnsignedByte3 = dataInputStream.readUnsignedByte();
                for (int i12 = 0; i12 < 8; i12++) {
                    if (((readUnsignedByte3 >> i12) & 1) > 0) {
                        int i13 = (readUnsignedByte << 8) + (i11 * 8) + (7 - i12);
                        Record.TYPE b10 = Record.TYPE.b(i13);
                        if (b10 == Record.TYPE.f41586a) {
                            f41681f.warning("Skipping unknown type in type bitmap: " + i13);
                        } else {
                            arrayList.add(b10);
                        }
                    }
                }
            }
            i10 += readUnsignedByte2 + 2;
        }
        return arrayList;
    }

    private static void l(byte[] bArr, DataOutputStream dataOutputStream) throws IOException {
        int i10 = 0;
        for (int i11 = 0; i11 < bArr.length; i11++) {
            if (bArr[i11] != 0) {
                i10 = i11 + 1;
            }
        }
        dataOutputStream.writeByte(i10);
        for (int i12 = 0; i12 < i10; i12++) {
            dataOutputStream.writeByte(bArr[i12]);
        }
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        this.f41682c.G(dataOutputStream);
        dataOutputStream.write(this.f41683d);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f41682c);
        sb2.append('.');
        for (Record.TYPE append : this.f41684e) {
            sb2.append(' ');
            sb2.append(append);
        }
        return sb2.toString();
    }
}
