package g6;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.entities.GenderType;
import kotlin.jvm.internal.j;

public final class c {
    public final String a(GenderType genderType) {
        j.g(genderType, "genderType");
        return genderType.getApiKey();
    }

    public final GenderType b(String str) {
        j.g(str, ProfileConstants.Field.GENDER);
        int hashCode = str.hashCode();
        if (hashCode != 98) {
            if (hashCode != 102) {
                if (hashCode == 109 && str.equals(NetworkProfile.MALE)) {
                    return GenderType.MALE;
                }
            } else if (str.equals(NetworkProfile.FEMALE)) {
                return GenderType.FEMALE;
            }
        } else if (str.equals(NetworkProfile.BISEXUAL)) {
            return GenderType.BISEXUAL;
        }
        return GenderType.UNSPECIFIED;
    }
}
