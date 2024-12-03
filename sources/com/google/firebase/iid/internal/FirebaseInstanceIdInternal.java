package com.google.firebase.iid.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

public interface FirebaseInstanceIdInternal {

    public interface NewTokenListener {
        void onNewToken(String str);
    }

    void addNewTokenListener(NewTokenListener newTokenListener);

    void deleteToken(@NonNull String str, @NonNull String str2) throws IOException;

    String getId();

    String getToken();

    @NonNull
    Task<String> getTokenTask();
}
