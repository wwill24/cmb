package eh;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.i;
import com.google.mlkit.vision.text.internal.k;

public final /* synthetic */ class e implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ e f23399a = new e();

    private /* synthetic */ e() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new k((i) componentContainer.get(i.class));
    }
}
