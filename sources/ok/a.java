package ok;

import com.leanplum.internal.Constants;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import org.apache.commons.validator.Var;
import wk.c;

public final class a {
    public static final <T> Class<T> a(c<T> cVar) {
        j.g(cVar, "<this>");
        Class<?> c10 = ((kotlin.jvm.internal.c) cVar).c();
        j.e(c10, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return c10;
    }

    public static final <T> Class<T> b(c<T> cVar) {
        j.g(cVar, "<this>");
        Class c10 = ((kotlin.jvm.internal.c) cVar).c();
        if (!c10.isPrimitive()) {
            j.e(c10, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return c10;
        }
        String name = c10.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    c10 = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals(Var.JSTYPE_INT)) {
                    c10 = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    c10 = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    c10 = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    c10 = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    c10 = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    c10 = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals(Constants.Kinds.FLOAT)) {
                    c10 = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    c10 = Short.class;
                    break;
                }
                break;
        }
        j.e(c10, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return c10;
    }

    public static final <T> c<T> c(Class<T> cls) {
        j.g(cls, "<this>");
        return l.b(cls);
    }
}
