package androidx.datastore.preferences.protobuf;

final class q {

    /* renamed from: a  reason: collision with root package name */
    private static final o<?> f5359a = new p();

    /* renamed from: b  reason: collision with root package name */
    private static final o<?> f5360b = c();

    static o<?> a() {
        o<?> oVar = f5360b;
        if (oVar != null) {
            return oVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static o<?> b() {
        return f5359a;
    }

    private static o<?> c() {
        try {
            return (o) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
