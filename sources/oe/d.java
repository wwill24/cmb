package oe;

import android.content.Context;
import androidx.annotation.NonNull;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static d f41335b = new d();

    /* renamed from: a  reason: collision with root package name */
    private c f41336a = null;

    @NonNull
    public static c a(@NonNull Context context) {
        return f41335b.b(context);
    }

    @NonNull
    public final synchronized c b(@NonNull Context context) {
        if (this.f41336a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f41336a = new c(context);
        }
        return this.f41336a;
    }
}
