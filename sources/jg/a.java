package jg;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import ed.u;

public final /* synthetic */ class a implements ComponentFactory {
    public final Object create(ComponentContainer componentContainer) {
        return u.f((Context) componentContainer.get(Context.class));
    }
}
