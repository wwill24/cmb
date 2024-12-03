package yi;

import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import wk.c;

public final class b {
    public static final <T extends UiComponent> T a(List<? extends UiComponent> list, c<T> cVar) {
        T t10;
        j.g(list, "<this>");
        j.g(cVar, "type");
        Iterator<? extends UiComponent> it = list.iterator();
        while (true) {
            t10 = null;
            if (!it.hasNext()) {
                break;
            }
            T t11 = (UiComponent) it.next();
            if (cVar.isInstance(t11)) {
                if (t11 instanceof UiComponent) {
                    return t11;
                }
                return null;
            } else if (t11 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.b) {
                List<UiComponent> children = ((com.withpersona.sdk2.inquiry.steps.ui.network.b) t11).getChildren();
                if (children != null) {
                    t10 = a(children, cVar);
                }
                if (t10 != null) {
                    break;
                }
            }
        }
        return t10;
    }
}
