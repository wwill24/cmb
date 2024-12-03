package com.google.crypto.tink.shaded.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class a0 extends c<String> implements b0, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    private static final a0 f20739c;

    /* renamed from: d  reason: collision with root package name */
    public static final b0 f20740d;

    /* renamed from: b  reason: collision with root package name */
    private final List<Object> f20741b;

    static {
        a0 a0Var = new a0();
        f20739c = a0Var;
        a0Var.c();
        f20740d = a0Var;
    }

    public a0() {
        this(10);
    }

    private static String f(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).C();
        }
        return x.j((byte[]) obj);
    }

    public void F1(ByteString byteString) {
        b();
        this.f20741b.add(byteString);
        this.modCount++;
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public void clear() {
        b();
        this.f20741b.clear();
        this.modCount++;
    }

    /* renamed from: d */
    public void add(int i10, String str) {
        b();
        this.f20741b.add(i10, str);
        this.modCount++;
    }

    public List<?> e() {
        return Collections.unmodifiableList(this.f20741b);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: g */
    public a0 a(int i10) {
        if (i10 >= size()) {
            ArrayList arrayList = new ArrayList(i10);
            arrayList.addAll(this.f20741b);
            return new a0((ArrayList<Object>) arrayList);
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
        Object remove = this.f20741b.remove(i10);
        this.modCount++;
        return f(remove);
    }

    /* renamed from: j */
    public String set(int i10, String str) {
        b();
        return f(this.f20741b.set(i10, str));
    }

    public b0 k() {
        if (h()) {
            return new i1(this);
        }
        return this;
    }

    public Object l(int i10) {
        return this.f20741b.get(i10);
    }

    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public int size() {
        return this.f20741b.size();
    }

    public a0(int i10) {
        this((ArrayList<Object>) new ArrayList(i10));
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    public boolean addAll(int i10, Collection<? extends String> collection) {
        b();
        if (collection instanceof b0) {
            collection = ((b0) collection).e();
        }
        boolean addAll = this.f20741b.addAll(i10, collection);
        this.modCount++;
        return addAll;
    }

    public String get(int i10) {
        Object obj = this.f20741b.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String C = byteString.C();
            if (byteString.p()) {
                this.f20741b.set(i10, C);
            }
            return C;
        }
        byte[] bArr = (byte[]) obj;
        String j10 = x.j(bArr);
        if (x.g(bArr)) {
            this.f20741b.set(i10, j10);
        }
        return j10;
    }

    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    private a0(ArrayList<Object> arrayList) {
        this.f20741b = arrayList;
    }
}
