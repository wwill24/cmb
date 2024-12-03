package gb;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.core.app.i;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.d;
import com.google.gson.e;
import java.io.Serializable;
import lc.r;
import okhttp3.x;
import org.json.b;

public abstract class a extends i {

    /* renamed from: a  reason: collision with root package name */
    protected d f40850a = new e().c(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).b();

    /* renamed from: b  reason: collision with root package name */
    protected x f40851b = r.d();

    /* renamed from: c  reason: collision with root package name */
    protected b f40852c = new b();

    /* renamed from: d  reason: collision with root package name */
    protected Handler f40853d = new Handler();

    /* access modifiers changed from: protected */
    public void a(ResultReceiver resultReceiver, CmbErrorCode cmbErrorCode) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("RESULT_STATUS_ERROR", cmbErrorCode);
        if (resultReceiver != null) {
            resultReceiver.send(1, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void b(ResultReceiver resultReceiver, SuccessStatus successStatus, Serializable serializable) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("RESULT_STATUS_SUCCESS", successStatus);
        bundle.putSerializable("RESULT_SUCCESS", serializable);
        resultReceiver.send(0, bundle);
    }
}
