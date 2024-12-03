package org.apache.commons.cli;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class HelpFormatter {
    public static final String DEFAULT_ARG_NAME = "arg";
    public static final int DEFAULT_DESC_PAD = 3;
    public static final int DEFAULT_LEFT_PAD = 1;
    public static final String DEFAULT_LONG_OPT_PREFIX = "--";
    public static final String DEFAULT_OPT_PREFIX = "-";
    public static final String DEFAULT_SYNTAX_PREFIX = "usage: ";
    public static final int DEFAULT_WIDTH = 74;
    public String defaultArgName = "arg";
    public int defaultDescPad = 3;
    public int defaultLeftPad = 1;
    public String defaultLongOptPrefix = DEFAULT_LONG_OPT_PREFIX;
    public String defaultNewLine = System.getProperty("line.separator");
    public String defaultOptPrefix = DEFAULT_OPT_PREFIX;
    public String defaultSyntaxPrefix = DEFAULT_SYNTAX_PREFIX;
    public int defaultWidth = 74;
    protected Comparator optionComparator = new OptionComparator();

    private static class OptionComparator implements Comparator {
        private OptionComparator() {
        }

        public int compare(Object obj, Object obj2) {
            return ((Option) obj).getKey().compareToIgnoreCase(((Option) obj2).getKey());
        }
    }

    private static void appendOption(StringBuffer stringBuffer, Option option, boolean z10) {
        if (!z10) {
            stringBuffer.append("[");
        }
        if (option.getOpt() != null) {
            stringBuffer.append(DEFAULT_OPT_PREFIX);
            stringBuffer.append(option.getOpt());
        } else {
            stringBuffer.append(DEFAULT_LONG_OPT_PREFIX);
            stringBuffer.append(option.getLongOpt());
        }
        if (option.hasArg() && option.hasArgName()) {
            stringBuffer.append(" <");
            stringBuffer.append(option.getArgName());
            stringBuffer.append(">");
        }
        if (!z10) {
            stringBuffer.append("]");
        }
    }

    private void appendOptionGroup(StringBuffer stringBuffer, OptionGroup optionGroup) {
        if (!optionGroup.isRequired()) {
            stringBuffer.append("[");
        }
        ArrayList arrayList = new ArrayList(optionGroup.getOptions());
        Collections.sort(arrayList, getOptionComparator());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            appendOption(stringBuffer, (Option) it.next(), true);
            if (it.hasNext()) {
                stringBuffer.append(" | ");
            }
        }
        if (!optionGroup.isRequired()) {
            stringBuffer.append("]");
        }
    }

    /* access modifiers changed from: protected */
    public String createPadding(int i10) {
        StringBuffer stringBuffer = new StringBuffer(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public int findWrapPos(String str, int i10, int i11) {
        int indexOf = str.indexOf(10, i11);
        if ((indexOf != -1 && indexOf <= i10) || ((indexOf = str.indexOf(9, i11)) != -1 && indexOf <= i10)) {
            return indexOf + 1;
        }
        int i12 = i10 + i11;
        if (i12 >= str.length()) {
            return -1;
        }
        int i13 = i12;
        while (i13 >= i11 && (r5 = str.charAt(i13)) != ' ' && r5 != 10 && r5 != 13) {
            i13--;
        }
        if (i13 > i11) {
            return i13;
        }
        while (i12 <= str.length() && (r9 = str.charAt(i12)) != ' ' && r9 != 10 && r9 != 13) {
            i12++;
        }
        if (i12 == str.length()) {
            return -1;
        }
        return i12;
    }

    public String getArgName() {
        return this.defaultArgName;
    }

    public int getDescPadding() {
        return this.defaultDescPad;
    }

    public int getLeftPadding() {
        return this.defaultLeftPad;
    }

    public String getLongOptPrefix() {
        return this.defaultLongOptPrefix;
    }

    public String getNewLine() {
        return this.defaultNewLine;
    }

    public String getOptPrefix() {
        return this.defaultOptPrefix;
    }

    public Comparator getOptionComparator() {
        return this.optionComparator;
    }

    public String getSyntaxPrefix() {
        return this.defaultSyntaxPrefix;
    }

    public int getWidth() {
        return this.defaultWidth;
    }

    public void printHelp(String str, Options options) {
        printHelp(this.defaultWidth, str, (String) null, options, (String) null, false);
    }

    public void printOptions(PrintWriter printWriter, int i10, Options options, int i11, int i12) {
        StringBuffer stringBuffer = new StringBuffer();
        renderOptions(stringBuffer, i10, options, i11, i12);
        printWriter.println(stringBuffer.toString());
    }

    public void printUsage(PrintWriter printWriter, int i10, String str, Options options) {
        StringBuffer stringBuffer = new StringBuffer(this.defaultSyntaxPrefix);
        stringBuffer.append(str);
        stringBuffer.append(" ");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(options.getOptions());
        Collections.sort(arrayList2, getOptionComparator());
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Option option = (Option) it.next();
            OptionGroup optionGroup = options.getOptionGroup(option);
            if (optionGroup == null) {
                appendOption(stringBuffer, option, option.isRequired());
            } else if (!arrayList.contains(optionGroup)) {
                arrayList.add(optionGroup);
                appendOptionGroup(stringBuffer, optionGroup);
            }
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        printWrapped(printWriter, i10, stringBuffer.toString().indexOf(32) + 1, stringBuffer.toString());
    }

    public void printWrapped(PrintWriter printWriter, int i10, String str) {
        printWrapped(printWriter, i10, 0, str);
    }

    /* access modifiers changed from: protected */
    public StringBuffer renderOptions(StringBuffer stringBuffer, int i10, Options options, int i11, int i12) {
        String createPadding = createPadding(i11);
        String createPadding2 = createPadding(i12);
        ArrayList arrayList = new ArrayList();
        List<Option> helpOptions = options.helpOptions();
        Collections.sort(helpOptions, getOptionComparator());
        int i13 = 0;
        int i14 = 0;
        for (Option option : helpOptions) {
            StringBuffer stringBuffer2 = new StringBuffer(8);
            if (option.getOpt() == null) {
                stringBuffer2.append(createPadding);
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("   ");
                stringBuffer3.append(this.defaultLongOptPrefix);
                stringBuffer2.append(stringBuffer3.toString());
                stringBuffer2.append(option.getLongOpt());
            } else {
                stringBuffer2.append(createPadding);
                stringBuffer2.append(this.defaultOptPrefix);
                stringBuffer2.append(option.getOpt());
                if (option.hasLongOpt()) {
                    stringBuffer2.append(',');
                    stringBuffer2.append(this.defaultLongOptPrefix);
                    stringBuffer2.append(option.getLongOpt());
                }
            }
            if (option.hasArg()) {
                if (option.hasArgName()) {
                    stringBuffer2.append(" <");
                    stringBuffer2.append(option.getArgName());
                    stringBuffer2.append(">");
                } else {
                    stringBuffer2.append(' ');
                }
            }
            arrayList.add(stringBuffer2);
            if (stringBuffer2.length() > i14) {
                i14 = stringBuffer2.length();
            }
        }
        Iterator it = helpOptions.iterator();
        while (it.hasNext()) {
            Option option2 = (Option) it.next();
            int i15 = i13 + 1;
            StringBuffer stringBuffer4 = new StringBuffer(arrayList.get(i13).toString());
            if (stringBuffer4.length() < i14) {
                stringBuffer4.append(createPadding(i14 - stringBuffer4.length()));
            }
            stringBuffer4.append(createPadding2);
            int i16 = i14 + i12;
            if (option2.getDescription() != null) {
                stringBuffer4.append(option2.getDescription());
            }
            renderWrappedText(stringBuffer, i10, i16, stringBuffer4.toString());
            if (it.hasNext()) {
                stringBuffer.append(this.defaultNewLine);
            }
            i13 = i15;
        }
        return stringBuffer;
    }

    /* access modifiers changed from: protected */
    public StringBuffer renderWrappedText(StringBuffer stringBuffer, int i10, int i11, String str) {
        int findWrapPos = findWrapPos(str, i10, 0);
        if (findWrapPos == -1) {
            stringBuffer.append(rtrim(str));
            return stringBuffer;
        }
        stringBuffer.append(rtrim(str.substring(0, findWrapPos)));
        stringBuffer.append(this.defaultNewLine);
        if (i11 >= i10) {
            i11 = 1;
        }
        String createPadding = createPadding(i11);
        while (true) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(createPadding);
            stringBuffer2.append(str.substring(findWrapPos).trim());
            str = stringBuffer2.toString();
            findWrapPos = findWrapPos(str, i10, 0);
            if (findWrapPos == -1) {
                stringBuffer.append(str);
                return stringBuffer;
            }
            if (str.length() > i10 && findWrapPos == i11 - 1) {
                findWrapPos = i10;
            }
            stringBuffer.append(rtrim(str.substring(0, findWrapPos)));
            stringBuffer.append(this.defaultNewLine);
        }
    }

    /* access modifiers changed from: protected */
    public String rtrim(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return str.substring(0, length);
    }

    public void setArgName(String str) {
        this.defaultArgName = str;
    }

    public void setDescPadding(int i10) {
        this.defaultDescPad = i10;
    }

    public void setLeftPadding(int i10) {
        this.defaultLeftPad = i10;
    }

    public void setLongOptPrefix(String str) {
        this.defaultLongOptPrefix = str;
    }

    public void setNewLine(String str) {
        this.defaultNewLine = str;
    }

    public void setOptPrefix(String str) {
        this.defaultOptPrefix = str;
    }

    public void setOptionComparator(Comparator comparator) {
        if (comparator == null) {
            this.optionComparator = new OptionComparator();
        } else {
            this.optionComparator = comparator;
        }
    }

    public void setSyntaxPrefix(String str) {
        this.defaultSyntaxPrefix = str;
    }

    public void setWidth(int i10) {
        this.defaultWidth = i10;
    }

    public void printHelp(String str, Options options, boolean z10) {
        printHelp(this.defaultWidth, str, (String) null, options, (String) null, z10);
    }

    public void printWrapped(PrintWriter printWriter, int i10, int i11, String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        renderWrappedText(stringBuffer, i10, i11, str);
        printWriter.println(stringBuffer.toString());
    }

    public void printHelp(String str, String str2, Options options, String str3) {
        printHelp(str, str2, options, str3, false);
    }

    public void printHelp(String str, String str2, Options options, String str3, boolean z10) {
        printHelp(this.defaultWidth, str, str2, options, str3, z10);
    }

    public void printHelp(int i10, String str, String str2, Options options, String str3) {
        printHelp(i10, str, str2, options, str3, false);
    }

    public void printHelp(int i10, String str, String str2, Options options, String str3, boolean z10) {
        PrintWriter printWriter = new PrintWriter(System.out);
        printHelp(printWriter, i10, str, str2, options, this.defaultLeftPad, this.defaultDescPad, str3, z10);
        printWriter.flush();
    }

    public void printHelp(PrintWriter printWriter, int i10, String str, String str2, Options options, int i11, int i12, String str3) {
        printHelp(printWriter, i10, str, str2, options, i11, i12, str3, false);
    }

    public void printHelp(PrintWriter printWriter, int i10, String str, String str2, Options options, int i11, int i12, String str3, boolean z10) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("cmdLineSyntax not provided");
        }
        if (z10) {
            printUsage(printWriter, i10, str, options);
        } else {
            printUsage(printWriter, i10, str);
        }
        if (str2 != null && str2.trim().length() > 0) {
            printWrapped(printWriter, i10, str2);
        }
        printOptions(printWriter, i10, options, i11, i12);
        if (str3 != null && str3.trim().length() > 0) {
            printWrapped(printWriter, i10, str3);
        }
    }

    public void printUsage(PrintWriter printWriter, int i10, String str) {
        int length = this.defaultSyntaxPrefix.length() + str.indexOf(32) + 1;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.defaultSyntaxPrefix);
        stringBuffer.append(str);
        printWrapped(printWriter, i10, length, stringBuffer.toString());
    }
}
