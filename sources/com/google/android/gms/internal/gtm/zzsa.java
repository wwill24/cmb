package com.google.android.gms.internal.gtm;

import com.google.android.gms.tagmanager.zzdh;
import com.google.android.gms.tagmanager.zzfv;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

public final class zzsa {
    public static zzak zza(zzak zzak) {
        zzal zzg = zzak.zzg();
        zzg.zzt(1);
        zzg.zzt(zzak.zzO());
        zzg.zzi();
        zzg.zza(zzak.zzq());
        zzg.zzo(zzak.zzN());
        return (zzak) zzg.zzC();
    }

    public static zzrs zzb(zzaa zzaa) throws zzrz {
        zzak[] zzakArr = new zzak[zzaa.zzf()];
        for (int i10 = 0; i10 < zzaa.zzf(); i10++) {
            zze(i10, zzaa, zzakArr, new HashSet(0));
        }
        zzru zzru = new zzru((zzrt) null);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < zzaa.zze(); i11++) {
            arrayList.add(zzf(zzaa.zzi(i11), zzaa, zzakArr, i11));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i12 = 0; i12 < zzaa.zzc(); i12++) {
            arrayList2.add(zzf(zzaa.zzh(i12), zzaa, zzakArr, i12));
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i13 = 0; i13 < zzaa.zza(); i13++) {
            zzro zzf = zzf(zzaa.zzg(i13), zzaa, zzakArr, i13);
            zzru.zzb(zzf);
            arrayList3.add(zzf);
        }
        for (zzac next : zzaa.zzr()) {
            zzry zzry = new zzry((zzrx) null);
            for (Integer intValue : next.zzh()) {
                zzry.zzg((zzro) arrayList2.get(intValue.intValue()));
            }
            for (Integer intValue2 : next.zzg()) {
                zzry.zzf((zzro) arrayList2.get(intValue2.intValue()));
            }
            for (Integer intValue3 : next.zze()) {
                zzry.zzd((zzro) arrayList.get(intValue3.intValue()));
            }
            for (Integer intValue4 : next.zzf()) {
                zzry.zze(zzaa.zzn(intValue4.intValue()).zzp());
            }
            for (Integer intValue5 : next.zzk()) {
                zzry.zzj((zzro) arrayList.get(intValue5.intValue()));
            }
            for (Integer intValue6 : next.zzl()) {
                zzry.zzk(zzaa.zzn(intValue6.intValue()).zzp());
            }
            for (Integer intValue7 : next.zzc()) {
                zzry.zzb((zzro) arrayList3.get(intValue7.intValue()));
            }
            for (Integer intValue8 : next.zzd()) {
                zzry.zzc(zzaa.zzn(intValue8.intValue()).zzp());
            }
            for (Integer intValue9 : next.zzi()) {
                zzry.zzh((zzro) arrayList3.get(intValue9.intValue()));
            }
            for (Integer intValue10 : next.zzj()) {
                zzry.zzi(zzaa.zzn(intValue10.intValue()).zzp());
            }
            zzru.zzc(zzry.zza());
        }
        zzru.zze(zzaa.zzo());
        zzru.zzd(zzaa.zzd());
        return zzru.zza();
    }

    public static void zzc(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static zzae zzd(zzak zzak) throws zzrz {
        zzux zzux = zzae.zza;
        if (!zzak.zzW(zzux)) {
            String valueOf = String.valueOf(zzak);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 54);
            sb2.append("Expected a ServingValue and didn't get one. Value is: ");
            sb2.append(valueOf);
            zzh(sb2.toString());
        }
        return (zzae) zzak.zzV(zzux);
    }

    private static zzak zze(int i10, zzaa zzaa, zzak[] zzakArr, Set<Integer> set) throws zzrz {
        zzal zzal;
        Integer valueOf = Integer.valueOf(i10);
        if (set.contains(valueOf)) {
            String valueOf2 = String.valueOf(set);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 90);
            sb2.append("Value cycle detected.  Current value reference: ");
            sb2.append(i10);
            sb2.append(".  Previous value references: ");
            sb2.append(valueOf2);
            sb2.append(".");
            zzh(sb2.toString());
        }
        zzal zzal2 = (zzal) ((zzak) zzg(zzaa.zzs(), i10, "values")).zzZ();
        zzak zzak = zzakArr[i10];
        if (zzak != null) {
            return zzak;
        }
        set.add(valueOf);
        int zzu = zzal2.zzu();
        if (zzu != 2) {
            if (zzu == 3) {
                zzal = (zzal) zza((zzak) zzal2.zzC()).zzZ();
                zzae zzd = zzd((zzak) zzal2.zzC());
                if (zzd.zzc() != zzd.zzd()) {
                    int zzc = zzd.zzc();
                    int zzd2 = zzd.zzd();
                    StringBuilder sb3 = new StringBuilder(58);
                    sb3.append("Uneven map keys (");
                    sb3.append(zzc);
                    sb3.append(") and map values (");
                    sb3.append(zzd2);
                    sb3.append(")");
                    zzh(sb3.toString());
                }
                zzal.zzk();
                zzal.zzl();
                for (Integer intValue : zzd.zzg()) {
                    zzal.zzf(zze(intValue.intValue(), zzaa, zzakArr, set));
                }
                for (Integer intValue2 : zzd.zzh()) {
                    zzal.zzg(zze(intValue2.intValue(), zzaa, zzakArr, set));
                }
            } else if (zzu == 4) {
                zzal = (zzal) zza((zzak) zzal2.zzC()).zzZ();
                zzal.zzr(zzfv.zzn(zzfv.zzl(zze(zzd((zzak) zzal2.zzC()).zza(), zzaa, zzakArr, set))));
            } else if (zzu == 7) {
                zzal = (zzal) zza((zzak) zzal2.zzC()).zzZ();
                zzae zzd3 = zzd((zzak) zzal2.zzC());
                zzal.zzm();
                for (Integer intValue3 : zzd3.zzi()) {
                    zzal.zzh(zze(intValue3.intValue(), zzaa, zzakArr, set));
                }
            }
            zzal2 = zzal;
        } else {
            zzae zzd4 = zzd((zzak) zzal2.zzC());
            zzal2 = (zzal) zza((zzak) zzal2.zzC()).zzZ();
            zzal2.zzj();
            for (Integer intValue4 : zzd4.zzf()) {
                zzal2.zze(zze(intValue4.intValue(), zzaa, zzakArr, set));
            }
        }
        zzakArr[i10] = (zzak) zzal2.zzC();
        set.remove(Integer.valueOf(i10));
        return (zzak) zzal2.zzC();
    }

    private static zzro zzf(zzs zzs, zzaa zzaa, zzak[] zzakArr, int i10) throws zzrz {
        zzrq zzrq = new zzrq((zzrp) null);
        for (Integer intValue : zzs.zzc()) {
            zzy zzy = (zzy) zzg(zzaa.zzq(), intValue.intValue(), JivePropertiesExtension.ELEMENT);
            String str = (String) zzg(zzaa.zzp(), zzy.zza(), UserMetadata.KEYDATA_FILENAME);
            int zzc = zzy.zzc();
            if (zzc < 0 || zzc >= zzakArr.length) {
                StringBuilder sb2 = new StringBuilder(51);
                sb2.append("Index out of bounds detected: ");
                sb2.append(zzc);
                sb2.append(" in values");
                zzh(sb2.toString());
            }
            zzak zzak = zzakArr[zzc];
            if (zzb.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzrq.zzc(zzak);
            } else {
                zzrq.zzb(str, zzak);
            }
        }
        return zzrq.zza();
    }

    private static <T> T zzg(List<T> list, int i10, String str) throws zzrz {
        if (i10 < 0 || i10 >= list.size()) {
            StringBuilder sb2 = new StringBuilder(str.length() + 45);
            sb2.append("Index out of bounds detected: ");
            sb2.append(i10);
            sb2.append(" in ");
            sb2.append(str);
            zzh(sb2.toString());
        }
        return list.get(i10);
    }

    private static void zzh(String str) throws zzrz {
        zzdh.zza(str);
        throw new zzrz(str);
    }
}
