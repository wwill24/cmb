package androidx.camera.core.impl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;

public class MetadataHolderService extends Service {
    private MetadataHolderService() {
    }

    public IBinder onBind(@NonNull Intent intent) {
        throw new UnsupportedOperationException();
    }
}
