package zm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import org.minidns.dnsname.DnsName;
import org.minidns.record.s;

public class g {
    private static int a(int[] iArr, double d10) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length && d10 >= ((double) iArr[i10])) {
            i11++;
            i10++;
        }
        return i11;
    }

    public static List<s> b(Collection<s> collection) {
        int i10;
        int i11;
        int i12;
        if (collection.size() == 1 && collection.iterator().next().f41709f.equals(DnsName.f33658g)) {
            return Collections.emptyList();
        }
        TreeMap treeMap = new TreeMap();
        for (s next : collection) {
            Integer valueOf = Integer.valueOf(next.f41706c);
            List list = (List) treeMap.get(valueOf);
            if (list == null) {
                list = new LinkedList();
                treeMap.put(valueOf, list);
            }
            list.add(next);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<s> list2 : treeMap.values()) {
            while (true) {
                int size = list2.size();
                if (size > 0) {
                    int[] iArr = new int[size];
                    Iterator it = list2.iterator();
                    while (true) {
                        i10 = 0;
                        if (it.hasNext()) {
                            if (((s) it.next()).f41707d > 0) {
                                i11 = 0;
                                break;
                            }
                        } else {
                            i11 = 1;
                            break;
                        }
                    }
                    int i13 = 0;
                    for (s sVar : list2) {
                        i10 += sVar.f41707d + i11;
                        iArr[i13] = i10;
                        i13++;
                    }
                    if (i10 == 0) {
                        i12 = (int) (Math.random() * ((double) size));
                    } else {
                        i12 = a(iArr, Math.random() * ((double) i10));
                    }
                    arrayList.add((s) list2.remove(i12));
                }
            }
        }
        return arrayList;
    }
}
