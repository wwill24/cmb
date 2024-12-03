package tb;

import android.content.Context;
import fa.a;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f41941a;

    /* renamed from: b  reason: collision with root package name */
    private final a f41942b;

    public b(Context context, a aVar) {
        this.f41941a = context;
        this.f41942b = aVar;
        try {
            aVar.b("CMB_SECURE_STORAGE");
        } catch (Exception e10) {
            a.g("CmbSecureStorage", "Failed to generate keys.", e10);
        }
    }
}
