package u7;

import com.coffeemeetsbagel.models.util.DateUtils;
import nc.b;

public class a implements b {
    public long a() {
        return DateUtils.getTimestampForNextNoon();
    }

    public long getCurrentTimeMillis() {
        return DateUtils.getCurrentTimestamp();
    }
}
