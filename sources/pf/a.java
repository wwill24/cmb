package pf;

import android.content.ContentResolver;
import android.provider.Settings;
import androidx.annotation.NonNull;

public class a {
    public float a(@NonNull ContentResolver contentResolver) {
        return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}
