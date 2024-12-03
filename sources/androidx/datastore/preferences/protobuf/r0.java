package androidx.datastore.preferences.protobuf;

final class r0 {

    /* renamed from: a  reason: collision with root package name */
    private static final p0 f5361a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final p0 f5362b = new q0();

    static p0 a() {
        return f5361a;
    }

    static p0 b() {
        return f5362b;
    }

    private static p0 c() {
        try {
            return (p0) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
