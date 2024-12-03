package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.a;
import ig.o;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class f<P> {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentMap<c, List<b<P>>> f20564a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private b<P> f20565b;

    /* renamed from: c  reason: collision with root package name */
    private final Class<P> f20566c;

    public static final class b<P> {

        /* renamed from: a  reason: collision with root package name */
        private final P f20567a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f20568b;

        /* renamed from: c  reason: collision with root package name */
        private final KeyStatusType f20569c;

        /* renamed from: d  reason: collision with root package name */
        private final OutputPrefixType f20570d;

        /* renamed from: e  reason: collision with root package name */
        private final int f20571e;

        b(P p10, byte[] bArr, KeyStatusType keyStatusType, OutputPrefixType outputPrefixType, int i10) {
            this.f20567a = p10;
            this.f20568b = Arrays.copyOf(bArr, bArr.length);
            this.f20569c = keyStatusType;
            this.f20570d = outputPrefixType;
            this.f20571e = i10;
        }

        public final byte[] a() {
            byte[] bArr = this.f20568b;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }

        public OutputPrefixType b() {
            return this.f20570d;
        }

        public P c() {
            return this.f20567a;
        }

        public KeyStatusType d() {
            return this.f20569c;
        }
    }

    private static class c implements Comparable<c> {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f20572a;

        /* renamed from: a */
        public int compareTo(c cVar) {
            byte[] bArr = this.f20572a;
            int length = bArr.length;
            byte[] bArr2 = cVar.f20572a;
            if (length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            int i10 = 0;
            while (true) {
                byte[] bArr3 = this.f20572a;
                if (i10 >= bArr3.length) {
                    return 0;
                }
                byte b10 = bArr3[i10];
                byte b11 = cVar.f20572a[i10];
                if (b10 != b11) {
                    return b10 - b11;
                }
                i10++;
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            return Arrays.equals(this.f20572a, ((c) obj).f20572a);
        }

        public int hashCode() {
            return Arrays.hashCode(this.f20572a);
        }

        public String toString() {
            return o.b(this.f20572a);
        }

        private c(byte[] bArr) {
            this.f20572a = Arrays.copyOf(bArr, bArr.length);
        }
    }

    private f(Class<P> cls) {
        this.f20566c = cls;
    }

    public static <P> f<P> f(Class<P> cls) {
        return new f<>(cls);
    }

    public b<P> a(P p10, a.c cVar) throws GeneralSecurityException {
        if (cVar.K() == KeyStatusType.ENABLED) {
            b bVar = new b(p10, ag.b.a(cVar), cVar.K(), cVar.J(), cVar.I());
            ArrayList arrayList = new ArrayList();
            arrayList.add(bVar);
            c cVar2 = new c(bVar.a());
            List put = this.f20564a.put(cVar2, Collections.unmodifiableList(arrayList));
            if (put != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(put);
                arrayList2.add(bVar);
                this.f20564a.put(cVar2, Collections.unmodifiableList(arrayList2));
            }
            return bVar;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }

    public b<P> b() {
        return this.f20565b;
    }

    public List<b<P>> c(byte[] bArr) {
        List<b<P>> list = this.f20564a.get(new c(bArr));
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    public Class<P> d() {
        return this.f20566c;
    }

    public List<b<P>> e() {
        return c(ag.b.f18841a);
    }

    public void g(b<P> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        } else if (bVar.d() != KeyStatusType.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        } else if (!c(bVar.a()).isEmpty()) {
            this.f20565b = bVar;
        } else {
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
    }
}
