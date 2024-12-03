package jc;

import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.transport.SuccessStatus;

public interface b<Result> {
    void a(Result result, SuccessStatus successStatus);

    void b(CmbErrorCode cmbErrorCode);
}
