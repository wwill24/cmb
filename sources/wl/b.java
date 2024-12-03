package wl;

import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

public interface b {

    public static final class a {
        private static List<String> a(b bVar, Object obj) {
            List<Object> list;
            if (obj instanceof List) {
                list = (List) obj;
            } else {
                list = null;
            }
            if (list == null) {
                return p.e(b(bVar, obj));
            }
            ArrayList arrayList = new ArrayList();
            for (Object a10 : list) {
                boolean unused = v.x(arrayList, a(bVar, a10));
            }
            return arrayList;
        }

        private static String b(b bVar, Object obj) {
            boolean z10;
            if (obj instanceof Number) {
                Number number = (Number) obj;
                if (number.doubleValue() == ((double) number.intValue())) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    return String.valueOf(number.intValue());
                }
            }
            return p004do.a.h(obj);
        }

        private static String c(b bVar, Object obj) {
            List<Object> list;
            if (obj instanceof List) {
                list = (List) obj;
            } else {
                list = null;
            }
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (Object a10 : list) {
                    boolean unused = v.x(arrayList, a(bVar, a10));
                }
                String W = CollectionsKt___CollectionsKt.W(arrayList, AppsFlyerKit.COMMA, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                if (W != null) {
                    return W;
                }
            }
            return b(bVar, obj);
        }

        public static List<String> d(b bVar, Object obj) {
            List<Object> c10 = p004do.a.c(obj);
            ArrayList arrayList = new ArrayList(r.t(c10, 10));
            Iterator<T> it = c10.iterator();
            while (it.hasNext()) {
                arrayList.add(c(bVar, it.next()));
            }
            return arrayList;
        }
    }
}
