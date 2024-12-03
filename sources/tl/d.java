package tl;

import java.util.Collection;
import kotlin.jvm.internal.j;
import org.apache.commons.validator.Field;

public interface d {

    public static final class a {
        public static boolean a(d dVar, Object obj) {
            boolean z10;
            boolean z11;
            boolean z12;
            if (obj != null) {
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
                if (obj instanceof Number) {
                    if (((Number) obj).doubleValue() == 0.0d) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!z12) {
                        return true;
                    }
                } else if (obj instanceof String) {
                    if (((CharSequence) obj).length() > 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11 && !j.b(obj, Field.TOKEN_INDEXED) && !j.b(obj, "null")) {
                        return true;
                    }
                } else if (obj instanceof Collection) {
                    if (!((Collection) obj).isEmpty()) {
                        return true;
                    }
                } else if (!(obj instanceof Object[])) {
                    return true;
                } else {
                    if (((Object[]) obj).length == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
