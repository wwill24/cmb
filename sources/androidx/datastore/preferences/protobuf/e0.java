package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;

public class e0<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f5245a;

    /* renamed from: b  reason: collision with root package name */
    private final K f5246b;

    /* renamed from: c  reason: collision with root package name */
    private final V f5247c;

    static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final WireFormat.FieldType f5248a;

        /* renamed from: b  reason: collision with root package name */
        public final K f5249b;

        /* renamed from: c  reason: collision with root package name */
        public final WireFormat.FieldType f5250c;

        /* renamed from: d  reason: collision with root package name */
        public final V f5251d;

        public a(WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
            this.f5248a = fieldType;
            this.f5249b = k10;
            this.f5250c = fieldType2;
            this.f5251d = v10;
        }
    }

    private e0(WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
        this.f5245a = new a<>(fieldType, k10, fieldType2, v10);
        this.f5246b = k10;
        this.f5247c = v10;
    }

    static <K, V> int b(a<K, V> aVar, K k10, V v10) {
        return s.d(aVar.f5248a, 1, k10) + s.d(aVar.f5250c, 2, v10);
    }

    public static <K, V> e0<K, V> d(WireFormat.FieldType fieldType, K k10, WireFormat.FieldType fieldType2, V v10) {
        return new e0<>(fieldType, k10, fieldType2, v10);
    }

    static <K, V> void e(CodedOutputStream codedOutputStream, a<K, V> aVar, K k10, V v10) throws IOException {
        s.z(codedOutputStream, aVar.f5248a, 1, k10);
        s.z(codedOutputStream, aVar.f5250c, 2, v10);
    }

    public int a(int i10, K k10, V v10) {
        return CodedOutputStream.V(i10) + CodedOutputStream.C(b(this.f5245a, k10, v10));
    }

    /* access modifiers changed from: package-private */
    public a<K, V> c() {
        return this.f5245a;
    }
}
