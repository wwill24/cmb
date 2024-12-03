package com.mparticle.internal.listeners;

import android.os.Message;
import androidx.annotation.NonNull;

interface GraphListener {
    void onCompositeObjects(Object obj, Object obj2);

    void onThreadMessage(@NonNull String str, Message message, boolean z10, StackTraceElement[] stackTraceElementArr);
}
