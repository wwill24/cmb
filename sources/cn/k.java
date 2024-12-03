package cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.openpgp.PGPSignature;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Long> f34102a;

    /* renamed from: b  reason: collision with root package name */
    private final en.a f34103b;

    /* renamed from: c  reason: collision with root package name */
    private final List<j> f34104c;

    /* renamed from: d  reason: collision with root package name */
    private final List<h> f34105d;

    /* renamed from: e  reason: collision with root package name */
    private final SymmetricKeyAlgorithm f34106e;

    /* renamed from: f  reason: collision with root package name */
    private final CompressionAlgorithm f34107f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f34108g;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Long> f34109a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        private en.a f34110b;

        /* renamed from: c  reason: collision with root package name */
        private final List<h> f34111c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private final List<j> f34112d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private SymmetricKeyAlgorithm f34113e = SymmetricKeyAlgorithm.NULL;

        /* renamed from: f  reason: collision with root package name */
        private CompressionAlgorithm f34114f = CompressionAlgorithm.UNCOMPRESSED;

        /* renamed from: g  reason: collision with root package name */
        private boolean f34115g = false;

        public void a(h hVar) {
            this.f34111c.add(hVar);
        }

        public void b(j jVar) {
            this.f34112d.add(jVar);
        }

        public a c(Long l10) {
            this.f34109a.add(l10);
            return this;
        }

        public k d() {
            return new k(this.f34109a, this.f34110b, this.f34113e, this.f34114f, this.f34115g, this.f34112d, this.f34111c);
        }

        public List<h> e() {
            return this.f34111c;
        }

        public a f(CompressionAlgorithm compressionAlgorithm) {
            this.f34114f = compressionAlgorithm;
            return this;
        }

        public a g(en.a aVar) {
            this.f34110b = aVar;
            return this;
        }

        public a h(boolean z10) {
            this.f34115g = z10;
            return this;
        }

        public a i(SymmetricKeyAlgorithm symmetricKeyAlgorithm) {
            this.f34113e = symmetricKeyAlgorithm;
            return this;
        }
    }

    public k(Set<Long> set, en.a aVar, SymmetricKeyAlgorithm symmetricKeyAlgorithm, CompressionAlgorithm compressionAlgorithm, boolean z10, List<j> list, List<h> list2) {
        this.f34102a = Collections.unmodifiableSet(set);
        this.f34103b = aVar;
        this.f34106e = symmetricKeyAlgorithm;
        this.f34107f = compressionAlgorithm;
        this.f34108g = z10;
        this.f34105d = Collections.unmodifiableList(list2);
        this.f34104c = Collections.unmodifiableList(list);
    }

    public static a a() {
        return new a();
    }

    public Set<Long> b() {
        return this.f34102a;
    }

    public Set<PGPSignature> c() {
        HashSet hashSet = new HashSet();
        for (h b10 : this.f34105d) {
            hashSet.add(b10.b());
        }
        for (j b11 : this.f34104c) {
            hashSet.add(b11.b());
        }
        return hashSet;
    }

    public boolean d() {
        return !b().isEmpty();
    }

    public boolean e() {
        return !c().isEmpty();
    }
}
