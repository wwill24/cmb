package ie;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.tasks.Task;

public interface c {
    @NonNull
    Task<ModuleInstallResponse> b(@NonNull d dVar);

    @NonNull
    Task<ModuleAvailabilityResponse> c(@NonNull e... eVarArr);
}
