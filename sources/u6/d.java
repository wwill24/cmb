package u6;

import com.coffeemeetsbagel.models.dto.Capability;
import com.coffeemeetsbagel.models.entities.CapabilityEntity;
import com.coffeemeetsbagel.models.entities.CapabilityType;
import java.util.List;
import qj.h;

public interface d {
    List<Long> a(List<CapabilityEntity> list);

    h<Boolean> c(CapabilityType capabilityType);

    h<List<Capability>> f();
}
