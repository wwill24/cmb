package cj;

import android.content.Context;
import android.view.View;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.steps.ui.network.JsonLogicBoolean;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponentAttributes;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class c extends View implements a {

    /* renamed from: a  reason: collision with root package name */
    private final List<WeakReference<UiComponent>> f24941a = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    public void a(Map<String, ? extends Object> map, boolean z10) {
        boolean z11;
        UiComponentAttributes uiComponentAttributes;
        com.withpersona.sdk2.inquiry.steps.ui.network.c cVar;
        Boolean d10;
        j.g(map, "componentParams");
        int i10 = 8;
        if (z10) {
            setVisibility(8);
            return;
        }
        loop0:
        while (true) {
            z11 = false;
            for (WeakReference weakReference : this.f24941a) {
                UiComponent uiComponent = (UiComponent) weakReference.get();
                JsonLogicBoolean jsonLogicBoolean = null;
                if (uiComponent != null) {
                    uiComponentAttributes = uiComponent.z();
                } else {
                    uiComponentAttributes = null;
                }
                if (uiComponentAttributes instanceof com.withpersona.sdk2.inquiry.steps.ui.network.c) {
                    cVar = (com.withpersona.sdk2.inquiry.steps.ui.network.c) uiComponentAttributes;
                } else {
                    cVar = null;
                }
                if (cVar != null) {
                    jsonLogicBoolean = cVar.c();
                }
                if (jsonLogicBoolean != null && (d10 = jsonLogicBoolean.d(map, uiComponent)) != null) {
                    z11 = d10.booleanValue();
                }
            }
            break loop0;
        }
        if (!z11) {
            i10 = 0;
        }
        setVisibility(i10);
    }

    public final List<WeakReference<UiComponent>> getAssociatedComponents() {
        return this.f24941a;
    }
}
