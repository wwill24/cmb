package androidx.core.content;

import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.core.util.a;

public interface e {
    void addOnConfigurationChangedListener(@NonNull a<Configuration> aVar);

    void removeOnConfigurationChangedListener(@NonNull a<Configuration> aVar);
}
