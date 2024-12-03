package com.appsflyer;

import com.appsflyer.internal.AFc1mSDK;
import java.util.concurrent.ExecutorService;

@Deprecated
public final class CreateOneLinkHttpTask {
    public final ExecutorService AFInAppEventParameterName;
    public final AFc1mSDK AFInAppEventType;

    @Deprecated
    public interface ResponseListener {
        void onResponse(String str);

        void onResponseError(String str);
    }

    public CreateOneLinkHttpTask() {
    }

    public CreateOneLinkHttpTask(AFc1mSDK aFc1mSDK, ExecutorService executorService) {
        this.AFInAppEventType = aFc1mSDK;
        this.AFInAppEventParameterName = executorService;
    }
}
