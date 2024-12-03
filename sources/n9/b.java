package n9;

import com.coffeemeetsbagel.models.util.DateUtils;

public class b implements a {
    public long a() {
        return DateUtils.getTimestampForNextNoon();
    }

    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
