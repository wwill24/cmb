package androidx.datastore.preferences.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class z extends c<String> implements a0, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    private static final z f5399c;

    /* renamed from: d  reason: collision with root package name */
    public static final a0 f5400d;

    /* renamed from: b  reason: collision with root package name */
    private final List<Object> f5401b;

    static {
        z zVar = new z();
        f5399c = zVar;
        zVar.c();
        f5400d = zVar;
    }

    public z() {
        this(10);
    }

    private static String f(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).C();
        }
        return w.j((byte[]) obj);
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public void b1(ByteString byteString) {
        b();
        this.f5401b.add(byteString);
        this.modCount++;
    }

    public void clear() {
        b();
        this.f5401b.clear();
        this.modCount++;
    }

    /* renamed from: d */
    public void add(int i10, String str) {
        b();
        this.f5401b.add(i10, str);
        this.modCount++;
    }

    public List<?> e() {
        return Collections.unmodifiableList(this.f5401b);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: g */
    public z a(int i10) {
        if (i10 >= size()) {
            ArrayList arrayList = new ArrayList(i10);
            arrayList.addAll(this.f5401b);
            return new z((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public /* bridge */ /* synthetic */ boolean h() {
        return super.h();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i */
    public String remove(int i10) {
        b();
        Object remove = this.f5401b.remove(i10);
        this.modCount++;
        return f(remove);
    }

    /* renamed from: j */
    public String set(int i10, String str) {
        b();
        return f(this.f5401b.set(i10, str));
    }

    public a0 k() {
        if (h()) {
            return new h1(this);
        }
        return this;
    }

    public Object l(int i10) {
        return this.f5401b.get(i10);
    }

    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public int size() {
        return this.f5401b.size();
    }

    public z(int i10) {
        this((ArrayList<Object>) new ArrayList(i10));
    }

    public boolean addAll(int i10, Collection<? extends String> collection) {
        b();
        if (collection instanceof a0) {
            collection = ((a0) collection).e();
        }
        boolean addAll = this.f5401b.addAll(i10, collection);
        this.modCount++;
        return addAll;
    }

    public String get(int i10) {
        Object obj = this.f5401b.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String C = byteString.C();
            if (byteString.p()) {
                this.f5401b.set(i10, C);
            }
            return C;
        }
        byte[] bArr = (byte[]) obj;
        String j10 = w.j(bArr);
        if (w.g(bArr)) {
            this.f5401b.set(i10, j10);
        }
        return j10;
    }

    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    private z(ArrayList<Object> arrayList) {
        this.f5401b = arrayList;
    }
}
