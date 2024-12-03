package org.apache.commons.cli;

import java.util.ArrayList;

public class GnuParser extends Parser {
    /* access modifiers changed from: protected */
    public String[] flatten(Options options, String[] strArr, boolean z10) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        boolean z11 = false;
        while (i10 < strArr.length) {
            String str = strArr[i10];
            if (HelpFormatter.DEFAULT_LONG_OPT_PREFIX.equals(str)) {
                arrayList.add(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
                z11 = true;
            } else if (HelpFormatter.DEFAULT_OPT_PREFIX.equals(str)) {
                arrayList.add(HelpFormatter.DEFAULT_OPT_PREFIX);
            } else if (str.startsWith(HelpFormatter.DEFAULT_OPT_PREFIX)) {
                String stripLeadingHyphens = Util.stripLeadingHyphens(str);
                if (options.hasOption(stripLeadingHyphens)) {
                    arrayList.add(str);
                } else if (stripLeadingHyphens.indexOf(61) != -1 && options.hasOption(stripLeadingHyphens.substring(0, stripLeadingHyphens.indexOf(61)))) {
                    arrayList.add(str.substring(0, str.indexOf(61)));
                    arrayList.add(str.substring(str.indexOf(61) + 1));
                } else if (options.hasOption(str.substring(0, 2))) {
                    arrayList.add(str.substring(0, 2));
                    arrayList.add(str.substring(2));
                } else {
                    arrayList.add(str);
                    z11 = z10;
                }
            } else {
                arrayList.add(str);
            }
            if (z11) {
                while (true) {
                    i10++;
                    if (i10 >= strArr.length) {
                        break;
                    }
                    arrayList.add(strArr[i10]);
                }
            }
            i10++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
