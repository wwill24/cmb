package e7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.reflect.Field;

public class j extends e {
    j(Context context, ComponentName componentName) {
        super(context, componentName);
    }

    public void a(int i10) {
        Object obj;
        Object obj2 = "";
        try {
            Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = newInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            if (i10 == 0) {
                obj = obj2;
            } else {
                obj = Integer.valueOf(i10);
            }
            declaredField.set(newInstance, String.valueOf(obj));
        } catch (Exception unused) {
            Intent intent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
            intent.putExtra("android.intent.extra.update_application_component_name", this.f14588b.getPackageName() + RemoteSettings.FORWARD_SLASH_STRING + this.f14588b.getClassName());
            if (i10 != 0) {
                obj2 = Integer.valueOf(i10);
            }
            intent.putExtra("android.intent.extra.update_application_message_text", String.valueOf(obj2));
            this.f14587a.sendBroadcast(intent);
        }
    }

    public void clear() {
        a(0);
    }
}
