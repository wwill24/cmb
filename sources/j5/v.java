package j5;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.transport.OperationResultReceiver;
import com.coffeemeetsbagel.transport.SuccessStatus;
import java.io.Serializable;

public class v {
    public v(Context context) {
    }

    /* access modifiers changed from: protected */
    public void a(ResultReceiver resultReceiver, CmbErrorCode cmbErrorCode) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("RESULT_STATUS_ERROR", cmbErrorCode);
        if (resultReceiver != null) {
            resultReceiver.send(1, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void b(OperationResultReceiver operationResultReceiver, SuccessStatus successStatus, Serializable serializable) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("RESULT_STATUS_SUCCESS", successStatus);
        bundle.putSerializable("RESULT_SUCCESS", serializable);
        operationResultReceiver.send(0, bundle);
    }
}
