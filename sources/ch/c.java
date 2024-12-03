package ch;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.i;
import com.google.mlkit.vision.face.internal.d;

public final /* synthetic */ class c implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ c f19004a = new c();

    private /* synthetic */ c() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new d((i) componentContainer.get(i.class));
    }
}
