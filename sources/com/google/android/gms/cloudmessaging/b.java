package com.google.android.gms.cloudmessaging;

import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import androidx.annotation.NonNull;

interface b extends IInterface {
    void L(@NonNull Message message) throws RemoteException;
}
