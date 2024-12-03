package g6;

import com.coffeemeetsbagel.models.entities.ReligionType;

public final class n {
    public final String a(ReligionType religionType) {
        if (religionType == null) {
            return null;
        }
        return religionType.getApiKey();
    }

    public final ReligionType b(String str) {
        return ReligionType.Companion.fromApiKey(str);
    }
}
