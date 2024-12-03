package androidx.datastore.preferences.protobuf;

final class h0 {

    /* renamed from: a  reason: collision with root package name */
    private static final f0 f5284a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final f0 f5285b = new g0();

    static f0 a() {
        return f5284a;
    }

    static f0 b() {
        return f5285b;
    }

    private static f0 c() {
        try {
            return (f0) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
