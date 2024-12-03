package h5;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import jc.b;

public final /* synthetic */ class k implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f15364a;

    public /* synthetic */ k(b bVar) {
        this.f15364a = bVar;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        l.m(this.f15364a, graphResponse);
    }
}
