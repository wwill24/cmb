package y6;

import com.coffeemeetsbagel.models.responses.ResponseActivityReports;
import qj.w;
import vn.f;
import vn.t;

public interface m {
    @f("/activity_reports")
    w<ResponseActivityReports> a(@t("id") String str);
}
