package com.coffeemeetsbagel.transport;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.coffeemeetsbagel.models.CmbErrorCode;
import jc.b;

public class OperationResultReceiver extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    private b f37550a;

    public OperationResultReceiver(b bVar) {
        super(new Handler(Looper.getMainLooper()));
        this.f37550a = bVar;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i10, Bundle bundle) {
        b bVar = this.f37550a;
        if (bVar == null) {
            return;
        }
        if (i10 == 0) {
            bVar.a(bundle.getSerializable("RESULT_SUCCESS"), (SuccessStatus) bundle.getSerializable("RESULT_STATUS_SUCCESS"));
        } else if (i10 == 1) {
            bVar.b((CmbErrorCode) bundle.getSerializable("RESULT_STATUS_ERROR"));
        }
    }
}
