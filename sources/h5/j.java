package h5;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import jc.b;

public final /* synthetic */ class j implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f15361a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f15362b;

    public /* synthetic */ j(b bVar, String str) {
        this.f15361a = bVar;
        this.f15362b = str;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        l.n(this.f15361a, this.f15362b, graphResponse);
    }
}
