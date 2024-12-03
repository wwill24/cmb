package com.facebook;

import com.facebook.GraphRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.json.a;
import org.json.b;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/facebook/GraphRequest$Companion$newMyFriendsRequest$wrapper$1", "Lcom/facebook/GraphRequest$Callback;", "onCompleted", "", "response", "Lcom/facebook/GraphResponse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GraphRequest$Companion$newMyFriendsRequest$wrapper$1 implements GraphRequest.Callback {
    final /* synthetic */ GraphRequest.GraphJSONArrayCallback $callback;

    GraphRequest$Companion$newMyFriendsRequest$wrapper$1(GraphRequest.GraphJSONArrayCallback graphJSONArrayCallback) {
        this.$callback = graphJSONArrayCallback;
    }

    public void onCompleted(GraphResponse graphResponse) {
        a aVar;
        j.g(graphResponse, "response");
        if (this.$callback != null) {
            b jSONObject = graphResponse.getJSONObject();
            if (jSONObject == null) {
                aVar = null;
            } else {
                aVar = jSONObject.optJSONArray("data");
            }
            this.$callback.onCompleted(aVar, graphResponse);
        }
    }
}
