package androidx.core.os;

import android.content.Context;
import android.os.UserManager;
import androidx.annotation.NonNull;

public class n {

    static class a {
        static boolean a(Context context) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    public static boolean a(@NonNull Context context) {
        return a.a(context);
    }
}
