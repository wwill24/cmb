package ma;

import com.coffeemeetsbagel.models.BeansPurchaseRequest;
import com.coffeemeetsbagel.models.responses.ResponseBeansVerification;
import retrofit2.b;
import vn.a;
import vn.o;

public interface c {
    @o("/beans")
    b<ResponseBeansVerification> a(@a BeansPurchaseRequest beansPurchaseRequest);
}
