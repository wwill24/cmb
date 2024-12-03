package we;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.measurement.internal.zzq;
import java.util.List;

public interface d extends IInterface {
    void B(zzq zzq) throws RemoteException;

    void H(zzq zzq) throws RemoteException;

    void I(zzau zzau, String str, String str2) throws RemoteException;

    void J(Bundle bundle, zzq zzq) throws RemoteException;

    List K(String str, String str2, String str3, boolean z10) throws RemoteException;

    String M(zzq zzq) throws RemoteException;

    void O(zzau zzau, zzq zzq) throws RemoteException;

    List P(String str, String str2, String str3) throws RemoteException;

    List Z(String str, String str2, zzq zzq) throws RemoteException;

    void i(zzac zzac) throws RemoteException;

    List j(zzq zzq, boolean z10) throws RemoteException;

    void j0(zzac zzac, zzq zzq) throws RemoteException;

    byte[] r0(zzau zzau, String str) throws RemoteException;

    void s(zzq zzq) throws RemoteException;

    void t0(zzlk zzlk, zzq zzq) throws RemoteException;

    void v(long j10, String str, String str2, String str3) throws RemoteException;

    void y(zzq zzq) throws RemoteException;

    List z(String str, String str2, boolean z10, zzq zzq) throws RemoteException;
}
