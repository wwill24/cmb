package org.apache.commons.cli;

import java.util.Iterator;
import java.util.List;

public class MissingOptionException extends ParseException {
    private List missingOptions;

    public MissingOptionException(String str) {
        super(str);
    }

    private static String createMessage(List list) {
        String str;
        StringBuffer stringBuffer = new StringBuffer("Missing required option");
        if (list.size() == 1) {
            str = "";
        } else {
            str = "s";
        }
        stringBuffer.append(str);
        stringBuffer.append(": ");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            if (it.hasNext()) {
                stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    }

    public List getMissingOptions() {
        return this.missingOptions;
    }

    public MissingOptionException(List list) {
        this(createMessage(list));
        this.missingOptions = list;
    }
}
