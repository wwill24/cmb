package org.apache.commons.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PosixParser extends Parser {
    private Option currentOption;
    private boolean eatTheRest;
    private Options options;
    private List tokens = new ArrayList();

    private void gobble(Iterator it) {
        if (this.eatTheRest) {
            while (it.hasNext()) {
                this.tokens.add(it.next());
            }
        }
    }

    private void init() {
        this.eatTheRest = false;
        this.tokens.clear();
    }

    private void processNonOptionToken(String str, boolean z10) {
        Option option;
        if (z10 && ((option = this.currentOption) == null || !option.hasArg())) {
            this.eatTheRest = true;
            this.tokens.add(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
        }
        this.tokens.add(str);
    }

    private void processOptionToken(String str, boolean z10) {
        if (z10 && !this.options.hasOption(str)) {
            this.eatTheRest = true;
        }
        if (this.options.hasOption(str)) {
            this.currentOption = this.options.getOption(str);
        }
        this.tokens.add(str);
    }

    /* access modifiers changed from: protected */
    public void burstToken(String str, boolean z10) {
        int i10;
        int i11 = 1;
        while (i11 < str.length()) {
            String valueOf = String.valueOf(str.charAt(i11));
            if (this.options.hasOption(valueOf)) {
                List list = this.tokens;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(HelpFormatter.DEFAULT_OPT_PREFIX);
                stringBuffer.append(valueOf);
                list.add(stringBuffer.toString());
                Option option = this.options.getOption(valueOf);
                this.currentOption = option;
                if (!option.hasArg() || str.length() == (i10 = i11 + 1)) {
                    i11++;
                } else {
                    this.tokens.add(str.substring(i10));
                    return;
                }
            } else if (z10) {
                processNonOptionToken(str.substring(i11), true);
                return;
            } else {
                this.tokens.add(str);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public String[] flatten(Options options2, String[] strArr, boolean z10) {
        String str;
        init();
        this.options = options2;
        Iterator it = Arrays.asList(strArr).iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (str2.startsWith(HelpFormatter.DEFAULT_LONG_OPT_PREFIX)) {
                int indexOf = str2.indexOf(61);
                if (indexOf == -1) {
                    str = str2;
                } else {
                    str = str2.substring(0, indexOf);
                }
                if (!options2.hasOption(str)) {
                    processNonOptionToken(str2, z10);
                } else {
                    this.currentOption = options2.getOption(str);
                    this.tokens.add(str);
                    if (indexOf != -1) {
                        this.tokens.add(str2.substring(indexOf + 1));
                    }
                }
            } else if (HelpFormatter.DEFAULT_OPT_PREFIX.equals(str2)) {
                this.tokens.add(str2);
            } else if (!str2.startsWith(HelpFormatter.DEFAULT_OPT_PREFIX)) {
                processNonOptionToken(str2, z10);
            } else if (str2.length() == 2 || options2.hasOption(str2)) {
                processOptionToken(str2, z10);
            } else {
                burstToken(str2, z10);
            }
            gobble(it);
        }
        List list = this.tokens;
        return (String[]) list.toArray(new String[list.size()]);
    }
}
