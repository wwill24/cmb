package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

public final /* synthetic */ class x implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ x f38478a = new x();

    private /* synthetic */ x() {
    }

    public final Object then(Task task) {
        if (task.isSuccessful()) {
            return (Bundle) task.getResult();
        }
        if (Log.isLoggable("Rpc", 3)) {
            String valueOf = String.valueOf(task.getException());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 22);
            sb2.append("Error making request: ");
            sb2.append(valueOf);
        }
        throw new IOException("SERVICE_NOT_AVAILABLE", task.getException());
    }
}
