package kg;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.tracing.ComponentMonitor;

public final /* synthetic */ class a implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f23606a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Component f23607b;

    public /* synthetic */ a(String str, Component component) {
        this.f23606a = str;
        this.f23607b = component;
    }

    public final Object create(ComponentContainer componentContainer) {
        return ComponentMonitor.lambda$processRegistrar$0(this.f23606a, this.f23607b, componentContainer);
    }
}
