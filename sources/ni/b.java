package ni;

import com.squareup.workflow1.ui.d;
import kotlin.jvm.internal.j;

public final class b implements d {

    /* renamed from: b  reason: collision with root package name */
    private final Object f32806b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f32807c;

    /* renamed from: d  reason: collision with root package name */
    private final String f32808d;

    public b(Object obj, boolean z10, String str) {
        j.g(obj, "screen");
        j.g(str, "name");
        this.f32806b = obj;
        this.f32807c = z10;
        this.f32808d = str;
    }

    public final Object a() {
        return this.f32806b;
    }

    public final boolean b() {
        return this.f32807c;
    }

    public String c() {
        return this.f32808d;
    }
}
