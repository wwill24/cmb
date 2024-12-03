package j6;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.d;
import com.google.gson.e;
import java.lang.reflect.Type;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private static d f15629a = new d();

    public static String b(Object obj) {
        if (obj == null) {
            return null;
        }
        return f15629a.u(obj);
    }

    public T a(String str, Type type) {
        return new e().c(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).b().l(str, type);
    }
}
