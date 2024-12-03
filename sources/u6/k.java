package u6;

import com.coffeemeetsbagel.models.dto.ProfileDataContract;
import com.coffeemeetsbagel.models.entities.PhotoEntity;
import com.coffeemeetsbagel.models.entities.ProfileEntity;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import kotlin.Pair;
import qj.h;

public interface k {
    h<Optional<ProfileEntity>> a(String str);

    int c(List<ProfileEntity> list);

    h<List<ProfileDataContract>> f(List<String> list);

    h<Map<ProfileEntity, List<PhotoEntity>>> g(List<String> list);

    h<Pair<ProfileEntity, List<PhotoEntity>>> i(String str);
}
