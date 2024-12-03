package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IInterface;
import android.os.RemoteException;

public interface g extends IInterface {
    void C(boolean z10) throws RemoteException;

    void l0(d dVar, String str) throws RemoteException;

    void m0(d dVar, Account account) throws RemoteException;
}
