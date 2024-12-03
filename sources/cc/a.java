package cc;

import com.coffeemeetsbagel.models.EmptyBodyObject;
import com.coffeemeetsbagel.models.responses.ResponseBoostReport;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import qj.w;
import vn.f;
import vn.o;
import vn.s;

public interface a {
    @o("boost_report/{boost_report_id}/viewed/")
    w<ResponseGeneric> a(@s("boost_report_id") String str, @vn.a EmptyBodyObject emptyBodyObject);

    @f("boost_report/{boost_report_id}/")
    w<ResponseBoostReport> b(@s("boost_report_id") String str);
}
