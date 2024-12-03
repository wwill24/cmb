package org.bouncycastle.i18n;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TimeZone;
import org.bouncycastle.i18n.filter.Filter;
import org.bouncycastle.i18n.filter.TrustedInput;
import org.bouncycastle.i18n.filter.UntrustedInput;
import org.bouncycastle.i18n.filter.UntrustedUrlInput;

public class LocalizedMessage {
    public static final String DEFAULT_ENCODING = "ISO-8859-1";
    protected FilteredArguments arguments;
    protected String encoding = DEFAULT_ENCODING;
    protected FilteredArguments extraArgs = null;
    protected Filter filter = null;

    /* renamed from: id  reason: collision with root package name */
    protected final String f41557id;
    protected ClassLoader loader = null;
    protected final String resource;

    protected class FilteredArguments {
        protected static final int FILTER = 1;
        protected static final int FILTER_URL = 2;
        protected static final int NO_FILTER = 0;
        protected int[] argFilterType;
        protected Object[] arguments;
        protected Filter filter;
        protected Object[] filteredArgs;
        protected boolean[] isLocaleSpecific;
        protected Object[] unpackedArgs;

        FilteredArguments(LocalizedMessage localizedMessage) {
            this(new Object[0]);
        }

        FilteredArguments(Object[] objArr) {
            this.filter = null;
            this.arguments = objArr;
            this.unpackedArgs = new Object[objArr.length];
            this.filteredArgs = new Object[objArr.length];
            this.isLocaleSpecific = new boolean[objArr.length];
            this.argFilterType = new int[objArr.length];
            for (int i10 = 0; i10 < objArr.length; i10++) {
                TrustedInput trustedInput = objArr[i10];
                if (trustedInput instanceof TrustedInput) {
                    this.unpackedArgs[i10] = trustedInput.getInput();
                    this.argFilterType[i10] = 0;
                } else if (trustedInput instanceof UntrustedInput) {
                    this.unpackedArgs[i10] = ((UntrustedInput) trustedInput).getInput();
                    if (objArr[i10] instanceof UntrustedUrlInput) {
                        this.argFilterType[i10] = 2;
                    } else {
                        this.argFilterType[i10] = 1;
                    }
                } else {
                    this.unpackedArgs[i10] = trustedInput;
                    this.argFilterType[i10] = 1;
                }
                this.isLocaleSpecific[i10] = this.unpackedArgs[i10] instanceof LocaleString;
            }
        }

        private Object filter(int i10, Object obj) {
            Filter filter2 = this.filter;
            if (filter2 != null) {
                if (obj == null) {
                    obj = "null";
                }
                if (i10 != 0) {
                    if (i10 == 1) {
                        return filter2.doFilter(obj.toString());
                    }
                    if (i10 != 2) {
                        return null;
                    }
                    return filter2.doFilterUrl(obj.toString());
                }
            }
            return obj;
        }

        public Object[] getArguments() {
            return this.arguments;
        }

        public Filter getFilter() {
            return this.filter;
        }

        public Object[] getFilteredArgs(Locale locale) {
            Object[] objArr = new Object[this.unpackedArgs.length];
            int i10 = 0;
            while (true) {
                Object[] objArr2 = this.unpackedArgs;
                if (i10 >= objArr2.length) {
                    return objArr;
                }
                Object obj = this.filteredArgs[i10];
                if (obj == null) {
                    Object obj2 = objArr2[i10];
                    if (this.isLocaleSpecific[i10]) {
                        obj = filter(this.argFilterType[i10], ((LocaleString) obj2).getLocaleString(locale));
                    } else {
                        obj = filter(this.argFilterType[i10], obj2);
                        this.filteredArgs[i10] = obj;
                    }
                }
                objArr[i10] = obj;
                i10++;
            }
        }

        public boolean isEmpty() {
            return this.unpackedArgs.length == 0;
        }

        public void setFilter(Filter filter2) {
            if (filter2 != this.filter) {
                for (int i10 = 0; i10 < this.unpackedArgs.length; i10++) {
                    this.filteredArgs[i10] = null;
                }
            }
            this.filter = filter2;
        }
    }

    public LocalizedMessage(String str, String str2) throws NullPointerException {
        if (str == null || str2 == null) {
            throw null;
        }
        this.f41557id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments(this);
    }

    public LocalizedMessage(String str, String str2, String str3) throws NullPointerException, UnsupportedEncodingException {
        if (str == null || str2 == null) {
            throw null;
        }
        this.f41557id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments(this);
        if (Charset.isSupported(str3)) {
            this.encoding = str3;
            return;
        }
        throw new UnsupportedEncodingException("The encoding \"" + str3 + "\" is not supported.");
    }

    public LocalizedMessage(String str, String str2, String str3, Object[] objArr) throws NullPointerException, UnsupportedEncodingException {
        if (str == null || str2 == null || objArr == null) {
            throw null;
        }
        this.f41557id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments(objArr);
        if (Charset.isSupported(str3)) {
            this.encoding = str3;
            return;
        }
        throw new UnsupportedEncodingException("The encoding \"" + str3 + "\" is not supported.");
    }

    public LocalizedMessage(String str, String str2, Object[] objArr) throws NullPointerException {
        if (str == null || str2 == null || objArr == null) {
            throw null;
        }
        this.f41557id = str2;
        this.resource = str;
        this.arguments = new FilteredArguments(objArr);
    }

    /* access modifiers changed from: protected */
    public String addExtraArgs(String str, Locale locale) {
        if (this.extraArgs == null) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        Object[] filteredArgs = this.extraArgs.getFilteredArgs(locale);
        for (Object append : filteredArgs) {
            stringBuffer.append(append);
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public String formatWithTimeZone(String str, Object[] objArr, Locale locale, TimeZone timeZone) {
        MessageFormat messageFormat = new MessageFormat(" ");
        messageFormat.setLocale(locale);
        messageFormat.applyPattern(str);
        if (!timeZone.equals(TimeZone.getDefault())) {
            Format[] formats = messageFormat.getFormats();
            for (int i10 = 0; i10 < formats.length; i10++) {
                Format format2 = formats[i10];
                if (format2 instanceof DateFormat) {
                    DateFormat dateFormat = (DateFormat) format2;
                    dateFormat.setTimeZone(timeZone);
                    messageFormat.setFormat(i10, dateFormat);
                }
            }
        }
        return messageFormat.format(objArr);
    }

    public Object[] getArguments() {
        return this.arguments.getArguments();
    }

    public ClassLoader getClassLoader() {
        return this.loader;
    }

    public String getEntry(String str, Locale locale, TimeZone timeZone) throws MissingEntryException {
        String str2 = this.f41557id;
        if (str != null) {
            str2 = str2 + "." + str;
        }
        String str3 = str2;
        try {
            ClassLoader classLoader = this.loader;
            String string = (classLoader == null ? ResourceBundle.getBundle(this.resource, locale) : ResourceBundle.getBundle(this.resource, locale, classLoader)).getString(str3);
            if (!this.encoding.equals(DEFAULT_ENCODING)) {
                string = new String(string.getBytes(DEFAULT_ENCODING), this.encoding);
            }
            if (!this.arguments.isEmpty()) {
                string = formatWithTimeZone(string, this.arguments.getFilteredArgs(locale), locale, timeZone);
            }
            return addExtraArgs(string, locale);
        } catch (MissingResourceException unused) {
            String str4 = "Can't find entry " + str3 + " in resource file " + this.resource + ".";
            String str5 = this.resource;
            ClassLoader classLoader2 = this.loader;
            if (classLoader2 == null) {
                classLoader2 = getClassLoader();
            }
            throw new MissingEntryException(str4, str5, str3, locale, classLoader2);
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    public Object[] getExtraArgs() {
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments == null) {
            return null;
        }
        return filteredArguments.getArguments();
    }

    public Filter getFilter() {
        return this.filter;
    }

    public String getId() {
        return this.f41557id;
    }

    public String getResource() {
        return this.resource;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.loader = classLoader;
    }

    public void setExtraArgument(Object obj) {
        setExtraArguments(new Object[]{obj});
    }

    public void setExtraArguments(Object[] objArr) {
        if (objArr != null) {
            FilteredArguments filteredArguments = new FilteredArguments(objArr);
            this.extraArgs = filteredArguments;
            filteredArguments.setFilter(this.filter);
            return;
        }
        this.extraArgs = null;
    }

    public void setFilter(Filter filter2) {
        this.arguments.setFilter(filter2);
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments != null) {
            filteredArguments.setFilter(filter2);
        }
        this.filter = filter2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Resource: \"");
        stringBuffer.append(this.resource);
        stringBuffer.append("\" Id: \"");
        stringBuffer.append(this.f41557id);
        stringBuffer.append("\"");
        stringBuffer.append(" Arguments: ");
        stringBuffer.append(this.arguments.getArguments().length);
        stringBuffer.append(" normal");
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments != null && filteredArguments.getArguments().length > 0) {
            stringBuffer.append(", ");
            stringBuffer.append(this.extraArgs.getArguments().length);
            stringBuffer.append(" extra");
        }
        stringBuffer.append(" Encoding: ");
        stringBuffer.append(this.encoding);
        stringBuffer.append(" ClassLoader: ");
        stringBuffer.append(this.loader);
        return stringBuffer.toString();
    }
}
