package kotlin.jvm.internal;

import java.util.List;
import kotlin.reflect.KTypeProjection;
import wk.c;
import wk.e;
import wk.f;
import wk.g;
import wk.h;
import wk.i;
import wk.j;
import wk.k;

public class m {
    public g a(FunctionReference functionReference) {
        return functionReference;
    }

    public c b(Class cls) {
        return new d(cls);
    }

    public f c(Class cls, String str) {
        return new k(cls, str);
    }

    public h d(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public i e(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public j f(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public k g(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    public String h(g gVar) {
        String obj = gVar.getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            return obj.substring(21);
        }
        return obj;
    }

    public String i(Lambda lambda) {
        return h(lambda);
    }

    public wk.m j(e eVar, List<KTypeProjection> list, boolean z10) {
        return new TypeReference(eVar, list, z10);
    }
}
