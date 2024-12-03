package bb;

import android.content.res.Resources;
import java.util.Arrays;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f34033a;

    public a(Resources resources) {
        j.g(resources, "resources");
        this.f34033a = resources;
    }

    public final String a(int i10, Object... objArr) {
        j.g(objArr, "formatArgs");
        String string = this.f34033a.getString(i10, Arrays.copyOf(objArr, objArr.length));
        j.f(string, "resources.getString(resId, *formatArgs)");
        return string;
    }

    public final String[] b(int i10) {
        String[] stringArray = this.f34033a.getStringArray(i10);
        j.f(stringArray, "resources.getStringArray(resId)");
        return stringArray;
    }
}
