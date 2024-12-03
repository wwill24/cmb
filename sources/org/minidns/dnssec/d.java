package org.minidns.dnssec;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.minidns.dnslabel.DnsLabel;
import org.minidns.dnsname.DnsName;
import org.minidns.dnssec.c;
import org.minidns.record.NSEC3;
import org.minidns.record.Record;
import org.minidns.record.f;
import org.minidns.record.h;
import org.minidns.record.i;
import org.minidns.record.m;
import org.minidns.record.q;
import rm.b;

class d {

    /* renamed from: a  reason: collision with root package name */
    private static final sm.a f33710a = sm.a.f33852e;

    class a implements Comparator<byte[]> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f33711a;

        a(int i10) {
            this.f33711a = i10;
        }

        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            int length;
            int length2;
            int i10 = this.f33711a;
            while (true) {
                if (i10 >= bArr.length || i10 >= bArr2.length) {
                    length = bArr.length;
                    length2 = bArr2.length;
                } else {
                    byte b10 = bArr[i10];
                    byte b11 = bArr2[i10];
                    if (b10 != b11) {
                        length = b10 & 255;
                        length2 = b11 & 255;
                        break;
                    }
                    i10++;
                }
            }
            return length - length2;
        }
    }

    static byte[] a(q qVar, List<Record<? extends h>> list) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            qVar.o(dataOutputStream);
            DnsName dnsName = list.get(0).f41570a;
            if (!dnsName.s()) {
                if (dnsName.l() >= qVar.f41691f) {
                    int l10 = dnsName.l();
                    byte b10 = qVar.f41691f;
                    if (l10 > b10) {
                        dnsName = DnsName.e(DnsLabel.f33576d, dnsName.B(b10));
                    }
                } else {
                    throw new DnssecValidationFailedException("Invalid RRsig record");
                }
            }
            DnsName dnsName2 = dnsName;
            ArrayList<byte[]> arrayList = new ArrayList<>(list.size());
            for (Record next : list) {
                arrayList.add(new Record(dnsName2, next.f41571b, next.f41573d, qVar.f41692g, next.f41575f).h());
            }
            Collections.sort(arrayList, new a(dnsName2.A() + 10));
            for (byte[] write : arrayList) {
                dataOutputStream.write(write);
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    static byte[] b(rm.a aVar, NSEC3 nsec3, DnsName dnsName, int i10) {
        return c(aVar, nsec3.k(), dnsName.i(), i10);
    }

    static byte[] c(rm.a aVar, byte[] bArr, byte[] bArr2, int i10) {
        while (true) {
            int i11 = i10 - 1;
            if (i10 < 0) {
                return bArr2;
            }
            byte[] bArr3 = new byte[(bArr2.length + bArr.length)];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, 0, bArr3, bArr2.length, bArr.length);
            bArr2 = aVar.a(bArr3);
            i10 = i11;
        }
    }

    static boolean d(String str, String str2, String str3) {
        return e(DnsName.c(str), DnsName.c(str2), DnsName.c(str3));
    }

    static boolean e(DnsName dnsName, DnsName dnsName2, DnsName dnsName3) {
        int l10 = dnsName2.l();
        int l11 = dnsName3.l();
        int l12 = dnsName.l();
        if (l12 > l10 && !dnsName.r(dnsName2) && dnsName.B(l10).compareTo(dnsName2) < 0) {
            return false;
        }
        if (l12 <= l10 && dnsName.compareTo(dnsName2.B(l12)) < 0) {
            return false;
        }
        if (l12 > l11 && !dnsName.r(dnsName3) && dnsName.B(l11).compareTo(dnsName3) > 0) {
            return false;
        }
        if (l12 > l11 || dnsName.compareTo(dnsName3.B(l12)) < 0) {
            return true;
        }
        return false;
    }

    public static c f(List<Record<? extends h>> list, q qVar, f fVar) throws IOException {
        b c10 = f33710a.c(qVar.f41689d);
        if (c10 == null) {
            return new c.b(qVar.f41690e, qVar.a(), list.get(0));
        }
        if (c10.a(a(qVar, list), qVar, fVar)) {
            return null;
        }
        throw new DnssecValidationFailedException(list, "Signature is invalid.");
    }

    public static c g(Record<f> record, i iVar) throws DnssecValidationFailedException {
        f fVar = (f) record.f41575f;
        rm.a a10 = f33710a.a(iVar.f41666f);
        if (a10 == null) {
            return new c.b(iVar.f41667g, iVar.a(), record);
        }
        byte[] e10 = fVar.e();
        byte[] i10 = record.f41570a.i();
        byte[] bArr = new byte[(i10.length + e10.length)];
        System.arraycopy(i10, 0, bArr, 0, i10.length);
        System.arraycopy(e10, 0, bArr, i10.length, e10.length);
        try {
            if (iVar.i(a10.a(bArr))) {
                return null;
            }
            throw new DnssecValidationFailedException((Record<? extends h>) record, "SEP is not properly signed by parent DS!");
        } catch (Exception e11) {
            return new c.a(iVar.f41666f, "DS", record, e11);
        }
    }

    public static c h(Record<m> record, org.minidns.dnsmessage.a aVar) {
        m mVar = (m) record.f41575f;
        if ((!record.f41570a.equals(aVar.f33653a) || mVar.f41684e.contains(aVar.f33654b)) && !e(aVar.f33653a, record.f41570a, mVar.f41682c)) {
            return new c.d(aVar, record);
        }
        return null;
    }

    public static c i(DnsName dnsName, Record<NSEC3> record, org.minidns.dnsmessage.a aVar) {
        NSEC3 nsec3 = (NSEC3) record.f41575f;
        rm.a b10 = f33710a.b(nsec3.f41559c);
        if (b10 == null) {
            return new c.b(nsec3.f41560d, nsec3.a(), record);
        }
        String a10 = zm.a.a(b(b10, nsec3, aVar.f33653a, nsec3.f41562f));
        if (record.f41570a.equals(DnsName.c(a10 + "." + dnsName))) {
            if (nsec3.f41566k.contains(aVar.f33654b)) {
                return new c.d(aVar, record);
            }
            return null;
        } else if (d(a10, record.f41570a.j(), zm.a.a(nsec3.j()))) {
            return null;
        } else {
            return new c.d(aVar, record);
        }
    }
}
