package com.google.protobuf;

import com.google.protobuf.WireFormat;
import java.io.IOException;

public class f0<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f21795a;

    /* renamed from: b  reason: collision with root package name */
    private final K f21796b;

    /* renamed from: c  reason: collision with root package name */
    private final V f21797c;

    static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final WireFormat.FieldType f21798a;

        /* renamed from: b  reason: collision with root package name */
        public final K f21799b;

        /* renamed from: c  reason: collision with root package name */
        public final WireFormat.FieldType f21800c;

        /* renamed from: d  reason: collision with root package name */
        public final V f21801d;

        public a(WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
            this.f21798a = fieldType;
            this.f21799b = k10;
            this.f21800c = fieldType2;
            this.f21801d = v10;
        }
    }

    private f0(WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
        this.f21795a = new a<>(fieldType, k10, fieldType2, v10);
        this.f21796b = k10;
        this.f21797c = v10;
    }

    static <K, V> int b(a<K, V> aVar, K k10, V v10) {
        return s.d(aVar.f21798a, 1, k10) + s.d(aVar.f21800c, 2, v10);
    }

    public static <K, V> f0<K, V> d(WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
        return new f0<>(fieldType, k10, fieldType2, v10);
    }

    static <K, V> void e(CodedOutputStream codedOutputStream, a<K, V> aVar, K k10, V v10) throws IOException {
        s.A(codedOutputStream, aVar.f21798a, 1, k10);
        s.A(codedOutputStream, aVar.f21800c, 2, v10);
    }

    public int a(int i10, K k10, V v10) {
        return CodedOutputStream.V(i10) + CodedOutputStream.D(b(this.f21795a, k10, v10));
    }

    /* access modifiers changed from: package-private */
    public a<K, V> c() {
        return this.f21795a;
    }
}
