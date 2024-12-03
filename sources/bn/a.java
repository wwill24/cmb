package bn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.HashAlgorithm;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;

public class a {

    /* renamed from: d  reason: collision with root package name */
    private static a f34041d = new a(Arrays.asList(new SymmetricKeyAlgorithm[]{SymmetricKeyAlgorithm.AES_256, SymmetricKeyAlgorithm.AES_192, SymmetricKeyAlgorithm.AES_128}), Arrays.asList(new HashAlgorithm[]{HashAlgorithm.SHA512, HashAlgorithm.SHA384, HashAlgorithm.SHA256, HashAlgorithm.SHA224}), Arrays.asList(new CompressionAlgorithm[]{CompressionAlgorithm.ZLIB, CompressionAlgorithm.BZIP2, CompressionAlgorithm.ZIP, CompressionAlgorithm.UNCOMPRESSED}));

    /* renamed from: a  reason: collision with root package name */
    private List<SymmetricKeyAlgorithm> f34042a;

    /* renamed from: b  reason: collision with root package name */
    private List<HashAlgorithm> f34043b;

    /* renamed from: c  reason: collision with root package name */
    private List<CompressionAlgorithm> f34044c;

    public a(List<SymmetricKeyAlgorithm> list, List<HashAlgorithm> list2, List<CompressionAlgorithm> list3) {
        this.f34042a = Collections.unmodifiableList(list);
        this.f34043b = Collections.unmodifiableList(list2);
        this.f34044c = Collections.unmodifiableList(list3);
    }

    public static a b() {
        return f34041d;
    }

    public int[] a() {
        int size = this.f34044c.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = this.f34044c.get(i10).b();
        }
        return iArr;
    }

    public int[] c() {
        int size = this.f34043b.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = this.f34043b.get(i10).a();
        }
        return iArr;
    }

    public int[] d() {
        int size = this.f34042a.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = this.f34042a.get(i10).b();
        }
        return iArr;
    }
}
