package we;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbn;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzlk;
import com.google.android.gms.measurement.internal.zzq;
import java.util.List;

public abstract class c extends zzbn implements d {
    public c() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        switch (i10) {
            case 1:
                zzbo.zzc(parcel);
                O((zzau) zzbo.zza(parcel, zzau.CREATOR), (zzq) zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                zzbo.zzc(parcel);
                t0((zzlk) zzbo.zza(parcel, zzlk.CREATOR), (zzq) zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                zzbo.zzc(parcel);
                s((zzq) zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                zzbo.zzc(parcel);
                I((zzau) zzbo.zza(parcel, zzau.CREATOR), readString, readString2);
                parcel2.writeNoException();
                return true;
            case 6:
                zzbo.zzc(parcel);
                H((zzq) zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                boolean zzf = zzbo.zzf(parcel);
                zzbo.zzc(parcel);
                List j10 = j((zzq) zzbo.zza(parcel, zzq.CREATOR), zzf);
                parcel2.writeNoException();
                parcel2.writeTypedList(j10);
                return true;
            case 9:
                String readString3 = parcel.readString();
                zzbo.zzc(parcel);
                byte[] r02 = r0((zzau) zzbo.zza(parcel, zzau.CREATOR), readString3);
                parcel2.writeNoException();
                parcel2.writeByteArray(r02);
                return true;
            case 10:
                long readLong = parcel.readLong();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                zzbo.zzc(parcel);
                v(readLong, readString4, readString5, readString6);
                parcel2.writeNoException();
                return true;
            case 11:
                zzbo.zzc(parcel);
                String M = M((zzq) zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(M);
                return true;
            case 12:
                zzbo.zzc(parcel);
                j0((zzac) zzbo.zza(parcel, zzac.CREATOR), (zzq) zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                zzbo.zzc(parcel);
                i((zzac) zzbo.zza(parcel, zzac.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zzbo.zzc(parcel);
                List z10 = z(parcel.readString(), parcel.readString(), zzbo.zzf(parcel), (zzq) zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(z10);
                return true;
            case 15:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                boolean zzf2 = zzbo.zzf(parcel);
                zzbo.zzc(parcel);
                List K = K(readString7, readString8, readString9, zzf2);
                parcel2.writeNoException();
                parcel2.writeTypedList(K);
                return true;
            case 16:
                zzbo.zzc(parcel);
                List Z = Z(parcel.readString(), parcel.readString(), (zzq) zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(Z);
                return true;
            case 17:
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                zzbo.zzc(parcel);
                List P = P(readString10, readString11, readString12);
                parcel2.writeNoException();
                parcel2.writeTypedList(P);
                return true;
            case 18:
                zzbo.zzc(parcel);
                B((zzq) zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 19:
                zzbo.zzc(parcel);
                J((Bundle) zzbo.zza(parcel, Bundle.CREATOR), (zzq) zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 20:
                zzbo.zzc(parcel);
                y((zzq) zzbo.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
