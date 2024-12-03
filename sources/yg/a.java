package yg;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.i;
import com.google.mlkit.vision.barcode.internal.e;

public final /* synthetic */ class a implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ a f24783a = new a();

    private /* synthetic */ a() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new e((i) componentContainer.get(i.class));
    }
}
