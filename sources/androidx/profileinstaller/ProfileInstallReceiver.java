package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.profileinstaller.h;

public class ProfileInstallReceiver extends BroadcastReceiver {

    class a implements h.c {
        a() {
        }

        public void a(int i10, Object obj) {
            h.f6169b.a(i10, obj);
            ProfileInstallReceiver.this.setResultCode(i10);
        }

        public void b(int i10, Object obj) {
            h.f6169b.b(i10, obj);
        }
    }

    static void a(@NonNull h.c cVar) {
        Process.sendSignal(Process.myPid(), 10);
        cVar.a(12, (Object) null);
    }

    public void onReceive(@NonNull Context context, Intent intent) {
        Bundle extras;
        if (intent != null) {
            String action = intent.getAction();
            if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
                h.k(context, new f(), new a(), true);
            } else if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
                Bundle extras2 = intent.getExtras();
                if (extras2 != null) {
                    String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                    if ("WRITE_SKIP_FILE".equals(string)) {
                        h.l(context, new f(), new a());
                    } else if ("DELETE_SKIP_FILE".equals(string)) {
                        h.c(context, new f(), new a());
                    }
                }
            } else if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
                a(new a());
            } else if ("androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) && (extras = intent.getExtras()) != null) {
                String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
                a aVar = new a();
                if ("DROP_SHADER_CACHE".equals(string2)) {
                    a.b(context, aVar);
                } else {
                    aVar.a(16, (Object) null);
                }
            }
        }
    }
}
