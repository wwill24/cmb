package com.leanplum.internal;

import com.leanplum.callbacks.StartCallback;
import com.leanplum.internal.Request;
import org.json.b;

public class Registration {
    public static void registerDevice(String str, final StartCallback startCallback) {
        Request create = RequestBuilder.withRegisterForDevelopmentAction().andParam("email", str).andType(Request.RequestType.IMMEDIATE).create();
        create.onResponse(new Request.ResponseCallback() {
            public void response(b bVar) {
                try {
                    boolean isResponseSuccess = RequestUtil.isResponseSuccess(bVar);
                    StartCallback.this.setSuccess(isResponseSuccess);
                    if (!isResponseSuccess) {
                        Log.e(RequestUtil.getResponseError(bVar), new Object[0]);
                    }
                    OperationQueue.sharedInstance().addUiOperation(StartCallback.this);
                } catch (Throwable th2) {
                    Log.exception(th2);
                }
            }
        });
        create.onError(new Request.ErrorCallback() {
            public void error(Exception exc) {
                StartCallback.this.setSuccess(false);
                OperationQueue.sharedInstance().addUiOperation(StartCallback.this);
            }
        });
        RequestSender.getInstance().send(create);
    }
}
