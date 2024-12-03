package lc;

import com.coffeemeetsbagel.logging.CmbBuildConfig;
import h5.e;

public class g {
    public static CmbBuildConfig a() {
        if (e.f15351c) {
            return CmbBuildConfig.RELEASE;
        }
        if (e.f15350b) {
            return CmbBuildConfig.SUPERUSER;
        }
        return CmbBuildConfig.DEBUG;
    }

    public static boolean b() {
        return e.f15351c;
    }

    public static boolean c() {
        return e.f15350b;
    }
}
