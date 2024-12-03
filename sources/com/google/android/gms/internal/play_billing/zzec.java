package com.google.android.gms.internal.play_billing;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzec extends AbstractMap {
    private final int zza;
    /* access modifiers changed from: private */
    public List zzb = Collections.emptyList();
    /* access modifiers changed from: private */
    public Map zzc = Collections.emptyMap();
    private boolean zzd;
    private volatile zzea zze;
    private Map zzf = Collections.emptyMap();

    /* synthetic */ zzec(int i10, zzeb zzeb) {
        this.zza = i10;
    }

    private final int zzk(Comparable comparable) {
        int size = this.zzb.size() - 1;
        int i10 = 0;
        if (size >= 0) {
            int compareTo = comparable.compareTo(((zzdw) this.zzb.get(size)).zza());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i10 <= size) {
            int i11 = (i10 + size) / 2;
            int compareTo2 = comparable.compareTo(((zzdw) this.zzb.get(i11)).zza());
            if (compareTo2 < 0) {
                size = i11 - 1;
            } else if (compareTo2 <= 0) {
                return i11;
            } else {
                i10 = i11 + 1;
            }
        }
        return -(i10 + 1);
    }

    /* access modifiers changed from: private */
    public final Object zzl(int i10) {
        zzn();
        Object value = ((zzdw) this.zzb.remove(i10)).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator it = zzm().entrySet().iterator();
            List list = this.zzb;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new zzdw(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final SortedMap zzm() {
        zzn();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            TreeMap treeMap2 = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* access modifiers changed from: private */
    public final void zzn() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzn();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (zzk(comparable) >= 0 || this.zzc.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    public final Set entrySet() {
        if (this.zze == null) {
            this.zze = new zzea(this, (zzdz) null);
        }
        return this.zze;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzec)) {
            return super.equals(obj);
        }
        zzec zzec = (zzec) obj;
        int size = size();
        if (size != zzec.size()) {
            return false;
        }
        int zzb2 = zzb();
        if (zzb2 != zzec.zzb()) {
            return entrySet().equals(zzec.entrySet());
        }
        for (int i10 = 0; i10 < zzb2; i10++) {
            if (!zzg(i10).equals(zzec.zzg(i10))) {
                return false;
            }
        }
        if (zzb2 != size) {
            return this.zzc.equals(zzec.zzc);
        }
        return true;
    }

    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return ((zzdw) this.zzb.get(zzk)).getValue();
        }
        return this.zzc.get(comparable);
    }

    public final int hashCode() {
        int zzb2 = zzb();
        int i10 = 0;
        for (int i11 = 0; i11 < zzb2; i11++) {
            i10 += ((zzdw) this.zzb.get(i11)).hashCode();
        }
        if (this.zzc.size() > 0) {
            return i10 + this.zzc.hashCode();
        }
        return i10;
    }

    public final Object remove(Object obj) {
        zzn();
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return zzl(zzk);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    public final int size() {
        return this.zzb.size() + this.zzc.size();
    }

    public void zza() {
        Map map;
        Map map2;
        if (!this.zzd) {
            if (this.zzc.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzc);
            }
            this.zzc = map;
            if (this.zzf.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzf);
            }
            this.zzf = map2;
            this.zzd = true;
        }
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final Iterable zzc() {
        if (this.zzc.isEmpty()) {
            return zzdv.zza();
        }
        return this.zzc.entrySet();
    }

    /* renamed from: zze */
    public final Object put(Comparable comparable, Object obj) {
        zzn();
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return ((zzdw) this.zzb.get(zzk)).setValue(obj);
        }
        zzn();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i10 = -(zzk + 1);
        if (i10 >= this.zza) {
            return zzm().put(comparable, obj);
        }
        int size = this.zzb.size();
        int i11 = this.zza;
        if (size == i11) {
            zzdw zzdw = (zzdw) this.zzb.remove(i11 - 1);
            zzm().put(zzdw.zza(), zzdw.getValue());
        }
        this.zzb.add(i10, new zzdw(this, comparable, obj));
        return null;
    }

    public final Map.Entry zzg(int i10) {
        return (Map.Entry) this.zzb.get(i10);
    }

    public final boolean zzj() {
        return this.zzd;
    }
}
