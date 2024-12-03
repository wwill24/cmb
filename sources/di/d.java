package di;

import android.view.View;
import com.squareup.workflow1.ui.WorkflowViewState;
import com.squareup.workflow1.ui.h;
import com.squareup.workflow1.ui.v;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\"\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00008BX\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Landroid/view/View;", "", "b", "(Landroid/view/View;)Ljava/lang/String;", "getNamedKey$annotations", "(Landroid/view/View;)V", "namedKey", "wf1-container-android"}, k = 2, mv = {1, 6, 0})
public final class d {
    /* access modifiers changed from: private */
    public static final String b(View view) {
        Object obj;
        h hVar;
        WorkflowViewState<?> d10 = v.d(view);
        String str = null;
        if (d10 == null) {
            obj = null;
        } else {
            obj = d10.c();
        }
        if (obj == null) {
            hVar = null;
        } else {
            hVar = (h) obj;
        }
        if (hVar != null) {
            str = hVar.c();
        }
        if (str != null) {
            return str;
        }
        throw new IllegalStateException(("Expected " + view + " to be showing a " + h.class.getSimpleName() + "<*> rendering, found " + hVar).toString());
    }
}
