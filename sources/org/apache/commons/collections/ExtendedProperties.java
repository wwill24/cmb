package org.apache.commons.collections;

import com.facebook.internal.ServerProtocol;
import com.mparticle.kits.AppsFlyerKit;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

public class ExtendedProperties extends Hashtable {
    protected static final String END_TOKEN = "}";
    protected static final String START_TOKEN = "${";
    protected static String include = "include";
    protected String basePath;
    private ExtendedProperties defaults;
    protected String file;
    protected String fileSeparator;
    protected boolean isInitialized;
    protected ArrayList keysAsListed;

    static class PropertiesReader extends LineNumberReader {
        public PropertiesReader(Reader reader) {
            super(reader);
        }

        public String readProperty() throws IOException {
            StringBuffer stringBuffer = new StringBuffer();
            String readLine = readLine();
            while (readLine != null) {
                String trim = readLine.trim();
                if (!(trim.length() == 0 || trim.charAt(0) == '#')) {
                    if (ExtendedProperties.endsWithSlash(trim)) {
                        stringBuffer.append(trim.substring(0, trim.length() - 1));
                    } else {
                        stringBuffer.append(trim);
                        return stringBuffer.toString();
                    }
                }
                readLine = readLine();
            }
            return null;
        }
    }

    static class PropertiesTokenizer extends StringTokenizer {
        static final String DELIMITER = ",";

        public PropertiesTokenizer(String str) {
            super(str, ",");
        }

        public boolean hasMoreTokens() {
            return super.hasMoreTokens();
        }

        public String nextToken() {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                if (!hasMoreTokens()) {
                    break;
                }
                String nextToken = super.nextToken();
                if (!ExtendedProperties.endsWithSlash(nextToken)) {
                    stringBuffer.append(nextToken);
                    break;
                }
                stringBuffer.append(nextToken.substring(0, nextToken.length() - 1));
                stringBuffer.append(",");
            }
            return stringBuffer.toString().trim();
        }
    }

    public ExtendedProperties() {
        try {
            this.fileSeparator = (String) AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    return System.getProperty("file.separator");
                }
            });
        } catch (SecurityException unused) {
            this.fileSeparator = File.separator;
        }
        this.isInitialized = false;
        this.keysAsListed = new ArrayList();
    }

    private void addPropertyDirect(String str, Object obj) {
        if (!containsKey(str)) {
            this.keysAsListed.add(str);
        }
        put(str, obj);
    }

    private void addPropertyInternal(String str, Object obj) {
        Object obj2 = get(str);
        if (obj2 instanceof String) {
            Vector vector = new Vector(2);
            vector.add(obj2);
            vector.add(obj);
            put(str, vector);
        } else if (obj2 instanceof List) {
            ((List) obj2).add(obj);
        } else {
            if (!containsKey(str)) {
                this.keysAsListed.add(str);
            }
            put(str, obj);
        }
    }

    public static ExtendedProperties convertProperties(Properties properties) {
        ExtendedProperties extendedProperties = new ExtendedProperties();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            extendedProperties.setProperty(str, properties.getProperty(str));
        }
        return extendedProperties;
    }

    private static int countPreceding(String str, int i10, char c10) {
        int i11 = i10 - 1;
        int i12 = i11;
        while (i12 >= 0 && str.charAt(i12) == c10) {
            i12--;
        }
        return i11 - i12;
    }

    /* access modifiers changed from: private */
    public static boolean endsWithSlash(String str) {
        if (str.endsWith("\\") && countPreceding(str, str.length() - 1, '\\') % 2 == 0) {
            return true;
        }
        return false;
    }

    private static String escape(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i10 = 0;
        while (i10 < stringBuffer.length()) {
            char charAt = stringBuffer.charAt(i10);
            if (charAt == ',' || charAt == '\\') {
                stringBuffer.insert(i10, '\\');
                i10++;
            }
            i10++;
        }
        return stringBuffer.toString();
    }

    private static String unescape(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i10 = 0;
        while (i10 < stringBuffer.length() - 1) {
            char charAt = stringBuffer.charAt(i10);
            int i11 = i10 + 1;
            char charAt2 = stringBuffer.charAt(i11);
            if (charAt == '\\' && charAt2 == '\\') {
                stringBuffer.deleteCharAt(i10);
            }
            i10 = i11;
        }
        return stringBuffer.toString();
    }

    public void addProperty(String str, Object obj) {
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.indexOf(AppsFlyerKit.COMMA) > 0) {
                PropertiesTokenizer propertiesTokenizer = new PropertiesTokenizer(str2);
                while (propertiesTokenizer.hasMoreTokens()) {
                    addPropertyInternal(str, unescape(propertiesTokenizer.nextToken()));
                }
            } else {
                addPropertyInternal(str, unescape(str2));
            }
        } else {
            addPropertyInternal(str, obj);
        }
        this.isInitialized = true;
    }

    public void clearProperty(String str) {
        if (containsKey(str)) {
            int i10 = 0;
            while (true) {
                if (i10 >= this.keysAsListed.size()) {
                    break;
                } else if (this.keysAsListed.get(i10).equals(str)) {
                    this.keysAsListed.remove(i10);
                    break;
                } else {
                    i10++;
                }
            }
            remove(str);
        }
    }

    public void combine(ExtendedProperties extendedProperties) {
        Iterator keys = extendedProperties.getKeys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            setProperty(str, extendedProperties.get(str));
        }
    }

    public void display() {
        Iterator keys = getKeys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = get(str);
            PrintStream printStream = System.out;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(" => ");
            stringBuffer.append(obj);
            printStream.println(stringBuffer.toString());
        }
    }

    public boolean getBoolean(String str) {
        Boolean bool = getBoolean(str, (Boolean) null);
        if (bool != null) {
            return bool.booleanValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('\'');
        stringBuffer.append(str);
        stringBuffer.append("' doesn't map to an existing object");
        throw new NoSuchElementException(stringBuffer.toString());
    }

    public byte getByte(String str) {
        Byte b10 = getByte(str, (Byte) null);
        if (b10 != null) {
            return b10.byteValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('\'');
        stringBuffer.append(str);
        stringBuffer.append(" doesn't map to an existing object");
        throw new NoSuchElementException(stringBuffer.toString());
    }

    public double getDouble(String str) {
        Double d10 = getDouble(str, (Double) null);
        if (d10 != null) {
            return d10.doubleValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('\'');
        stringBuffer.append(str);
        stringBuffer.append("' doesn't map to an existing object");
        throw new NoSuchElementException(stringBuffer.toString());
    }

    public float getFloat(String str) {
        Float f10 = getFloat(str, (Float) null);
        if (f10 != null) {
            return f10.floatValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('\'');
        stringBuffer.append(str);
        stringBuffer.append("' doesn't map to an existing object");
        throw new NoSuchElementException(stringBuffer.toString());
    }

    public String getInclude() {
        return include;
    }

    public int getInt(String str) {
        return getInteger(str);
    }

    public int getInteger(String str) {
        Integer integer = getInteger(str, (Integer) null);
        if (integer != null) {
            return integer.intValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('\'');
        stringBuffer.append(str);
        stringBuffer.append("' doesn't map to an existing object");
        throw new NoSuchElementException(stringBuffer.toString());
    }

    public Iterator getKeys() {
        return this.keysAsListed.iterator();
    }

    public List getList(String str) {
        return getList(str, (List) null);
    }

    public long getLong(String str) {
        Long l10 = getLong(str, (Long) null);
        if (l10 != null) {
            return l10.longValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('\'');
        stringBuffer.append(str);
        stringBuffer.append("' doesn't map to an existing object");
        throw new NoSuchElementException(stringBuffer.toString());
    }

    public Properties getProperties(String str) {
        return getProperties(str, new Properties());
    }

    public Object getProperty(String str) {
        ExtendedProperties extendedProperties;
        Object obj = get(str);
        if (obj != null || (extendedProperties = this.defaults) == null) {
            return obj;
        }
        return extendedProperties.get(str);
    }

    public short getShort(String str) {
        Short sh2 = getShort(str, (Short) null);
        if (sh2 != null) {
            return sh2.shortValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('\'');
        stringBuffer.append(str);
        stringBuffer.append("' doesn't map to an existing object");
        throw new NoSuchElementException(stringBuffer.toString());
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String[] getStringArray(String str) {
        List list;
        Object obj = get(str);
        if (obj instanceof String) {
            list = new Vector(1);
            list.add(obj);
        } else if (obj instanceof List) {
            list = (List) obj;
        } else if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            if (extendedProperties != null) {
                return extendedProperties.getStringArray(str);
            }
            return new String[0];
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('\'');
            stringBuffer.append(str);
            stringBuffer.append("' doesn't map to a String/List object");
            throw new ClassCastException(stringBuffer.toString());
        }
        int size = list.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = (String) list.get(i10);
        }
        return strArr;
    }

    public Vector getVector(String str) {
        return getVector(str, (Vector) null);
    }

    /* access modifiers changed from: protected */
    public String interpolate(String str) {
        return interpolateHelper(str, (List) null);
    }

    /* access modifiers changed from: protected */
    public String interpolateHelper(String str, List list) {
        int i10;
        int indexOf;
        if (str == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList();
            list.add(str);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i11 = -1;
        while (true) {
            i10 = i11 + 1;
            int indexOf2 = str.indexOf(START_TOKEN, i10);
            if (indexOf2 <= -1 || (indexOf = str.indexOf(END_TOKEN, indexOf2)) <= -1) {
                stringBuffer.append(str.substring(i10, str.length()));
            } else {
                stringBuffer.append(str.substring(i10, indexOf2));
                String substring = str.substring(indexOf2 + 2, indexOf);
                if (list.contains(substring)) {
                    String obj = list.remove(0).toString();
                    list.add(substring);
                    StringBuffer stringBuffer2 = new StringBuffer();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        stringBuffer2.append(it.next());
                        if (it.hasNext()) {
                            stringBuffer2.append("->");
                        }
                    }
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("infinite loop in property interpolation of ");
                    stringBuffer3.append(obj);
                    stringBuffer3.append(": ");
                    stringBuffer3.append(stringBuffer2.toString());
                    throw new IllegalStateException(stringBuffer3.toString());
                }
                list.add(substring);
                Object property = getProperty(substring);
                if (property != null) {
                    stringBuffer.append(interpolateHelper(property.toString(), list));
                    list.remove(list.size() - 1);
                } else {
                    ExtendedProperties extendedProperties = this.defaults;
                    if (extendedProperties == null || extendedProperties.getString(substring, (String) null) == null) {
                        stringBuffer.append(START_TOKEN);
                        stringBuffer.append(substring);
                        stringBuffer.append(END_TOKEN);
                    } else {
                        stringBuffer.append(this.defaults.getString(substring));
                    }
                }
                i11 = indexOf;
            }
        }
        stringBuffer.append(str.substring(i10, str.length()));
        return stringBuffer.toString();
    }

    public boolean isInitialized() {
        return this.isInitialized;
    }

    public void load(InputStream inputStream) throws IOException {
        load(inputStream, (String) null);
    }

    public synchronized void save(OutputStream outputStream, String str) throws IOException {
        if (outputStream != null) {
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (str != null) {
                printWriter.println(str);
            }
            Enumeration keys = keys();
            while (keys.hasMoreElements()) {
                String str2 = (String) keys.nextElement();
                Object obj = get(str2);
                if (obj != null) {
                    if (obj instanceof String) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(str2);
                        stringBuffer.append("=");
                        stringBuffer.append(escape((String) obj));
                        printWriter.println(stringBuffer.toString());
                    } else if (obj instanceof List) {
                        for (String escape : (List) obj) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(str2);
                            stringBuffer2.append("=");
                            stringBuffer2.append(escape(escape));
                            printWriter.println(stringBuffer2.toString());
                        }
                    }
                }
                printWriter.println();
                printWriter.flush();
            }
        }
    }

    public void setInclude(String str) {
        include = str;
    }

    public void setProperty(String str, Object obj) {
        clearProperty(str);
        addProperty(str, obj);
    }

    public ExtendedProperties subset(String str) {
        String str2;
        ExtendedProperties extendedProperties = new ExtendedProperties();
        Iterator keys = getKeys();
        boolean z10 = false;
        while (keys.hasNext()) {
            Object next = keys.next();
            if (next instanceof String) {
                String str3 = (String) next;
                if (str3.startsWith(str)) {
                    if (!z10) {
                        z10 = true;
                    }
                    if (str3.length() == str.length()) {
                        str2 = str;
                    } else {
                        str2 = str3.substring(str.length() + 1);
                    }
                    extendedProperties.addPropertyDirect(str2, get(next));
                }
            }
        }
        if (z10) {
            return extendedProperties;
        }
        return null;
    }

    public String testBoolean(String str) {
        String lowerCase = str.toLowerCase();
        String str2 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        if (!lowerCase.equals(str2) && !lowerCase.equals("on") && !lowerCase.equals("yes")) {
            str2 = "false";
            if (lowerCase.equals(str2) || lowerCase.equals("off") || lowerCase.equals("no")) {
                return str2;
            }
            return null;
        }
        return str2;
    }

    public int getInt(String str, int i10) {
        return getInteger(str, i10);
    }

    public Iterator getKeys(String str) {
        Iterator keys = getKeys();
        ArrayList arrayList = new ArrayList();
        while (keys.hasNext()) {
            Object next = keys.next();
            if ((next instanceof String) && ((String) next).startsWith(str)) {
                arrayList.add(next);
            }
        }
        return arrayList.iterator();
    }

    public List getList(String str, List list) {
        Object obj = get(str);
        if (obj instanceof List) {
            return new ArrayList((List) obj);
        }
        if (obj instanceof String) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(obj);
            put(str, arrayList);
            return arrayList;
        } else if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            if (extendedProperties != null) {
                return extendedProperties.getList(str, list);
            }
            return list == null ? new ArrayList() : list;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('\'');
            stringBuffer.append(str);
            stringBuffer.append("' doesn't map to a List object");
            throw new ClassCastException(stringBuffer.toString());
        }
    }

    public Properties getProperties(String str, Properties properties) {
        String[] stringArray = getStringArray(str);
        Properties properties2 = new Properties(properties);
        int i10 = 0;
        while (i10 < stringArray.length) {
            String str2 = stringArray[i10];
            int indexOf = str2.indexOf(61);
            if (indexOf > 0) {
                properties2.put(str2.substring(0, indexOf).trim(), str2.substring(indexOf + 1).trim());
                i10++;
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append('\'');
                stringBuffer.append(str2);
                stringBuffer.append("' does not contain ");
                stringBuffer.append("an equals sign");
                throw new IllegalArgumentException(stringBuffer.toString());
            }
        }
        return properties2;
    }

    public String getString(String str, String str2) {
        Object obj = get(str);
        if (obj instanceof String) {
            return interpolate((String) obj);
        }
        if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            if (extendedProperties != null) {
                return interpolate(extendedProperties.getString(str, str2));
            }
            return interpolate(str2);
        } else if (obj instanceof List) {
            return interpolate((String) ((List) obj).get(0));
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('\'');
            stringBuffer.append(str);
            stringBuffer.append("' doesn't map to a String object");
            throw new ClassCastException(stringBuffer.toString());
        }
    }

    public Vector getVector(String str, Vector vector) {
        Object obj = get(str);
        if (obj instanceof List) {
            return new Vector((List) obj);
        }
        if (obj instanceof String) {
            Vector vector2 = new Vector(1);
            vector2.add(obj);
            put(str, vector2);
            return vector2;
        } else if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            if (extendedProperties != null) {
                return extendedProperties.getVector(str, vector);
            }
            return vector == null ? new Vector() : vector;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('\'');
            stringBuffer.append(str);
            stringBuffer.append("' doesn't map to a Vector object");
            throw new ClassCastException(stringBuffer.toString());
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0021 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032 A[SYNTHETIC, Splitter:B:16:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0014 A[SYNTHETIC, Splitter:B:8:0x0014] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void load(java.io.InputStream r5, java.lang.String r6) throws java.io.IOException {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 == 0) goto L_0x0011
            org.apache.commons.collections.ExtendedProperties$PropertiesReader r0 = new org.apache.commons.collections.ExtendedProperties$PropertiesReader     // Catch:{ UnsupportedEncodingException -> 0x0011 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ UnsupportedEncodingException -> 0x0011 }
            r1.<init>(r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x0011 }
            r0.<init>(r1)     // Catch:{ UnsupportedEncodingException -> 0x0011 }
            goto L_0x0012
        L_0x000e:
            r5 = move-exception
            goto L_0x00cb
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x002b
            org.apache.commons.collections.ExtendedProperties$PropertiesReader r0 = new org.apache.commons.collections.ExtendedProperties$PropertiesReader     // Catch:{ UnsupportedEncodingException -> 0x0021 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ UnsupportedEncodingException -> 0x0021 }
            java.lang.String r1 = "8859_1"
            r6.<init>(r5, r1)     // Catch:{ UnsupportedEncodingException -> 0x0021 }
            r0.<init>(r6)     // Catch:{ UnsupportedEncodingException -> 0x0021 }
            goto L_0x002b
        L_0x0021:
            org.apache.commons.collections.ExtendedProperties$PropertiesReader r0 = new org.apache.commons.collections.ExtendedProperties$PropertiesReader     // Catch:{ all -> 0x000e }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ all -> 0x000e }
            r6.<init>(r5)     // Catch:{ all -> 0x000e }
            r0.<init>(r6)     // Catch:{ all -> 0x000e }
        L_0x002b:
            r5 = 1
            java.lang.String r6 = r0.readProperty()     // Catch:{ all -> 0x00c7 }
            if (r6 != 0) goto L_0x0036
            r4.isInitialized = r5     // Catch:{ all -> 0x000e }
            monitor-exit(r4)
            return
        L_0x0036:
            r1 = 61
            int r1 = r6.indexOf(r1)     // Catch:{ all -> 0x00c7 }
            if (r1 <= 0) goto L_0x002b
            r2 = 0
            java.lang.String r2 = r6.substring(r2, r1)     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = r2.trim()     // Catch:{ all -> 0x00c7 }
            int r1 = r1 + 1
            java.lang.String r6 = r6.substring(r1)     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = r6.trim()     // Catch:{ all -> 0x00c7 }
            java.lang.String r1 = ""
            boolean r1 = r1.equals(r6)     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x005a
            goto L_0x002b
        L_0x005a:
            java.lang.String r1 = r4.getInclude()     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x00c2
            java.lang.String r1 = r4.getInclude()     // Catch:{ all -> 0x00c7 }
            boolean r1 = r2.equalsIgnoreCase(r1)     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x00c2
            java.lang.String r1 = r4.fileSeparator     // Catch:{ all -> 0x00c7 }
            boolean r1 = r6.startsWith(r1)     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x0078
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x00c7 }
            r1.<init>(r6)     // Catch:{ all -> 0x00c7 }
            goto L_0x00ac
        L_0x0078:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ all -> 0x00c7 }
            r1.<init>()     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = "."
            r1.append(r2)     // Catch:{ all -> 0x00c7 }
            java.lang.String r2 = r4.fileSeparator     // Catch:{ all -> 0x00c7 }
            r1.append(r2)     // Catch:{ all -> 0x00c7 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00c7 }
            boolean r1 = r6.startsWith(r1)     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x0096
            r1 = 2
            java.lang.String r6 = r6.substring(r1)     // Catch:{ all -> 0x00c7 }
        L_0x0096:
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x00c7 }
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch:{ all -> 0x00c7 }
            r2.<init>()     // Catch:{ all -> 0x00c7 }
            java.lang.String r3 = r4.basePath     // Catch:{ all -> 0x00c7 }
            r2.append(r3)     // Catch:{ all -> 0x00c7 }
            r2.append(r6)     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x00c7 }
            r1.<init>(r6)     // Catch:{ all -> 0x00c7 }
        L_0x00ac:
            boolean r6 = r1.exists()     // Catch:{ all -> 0x00c7 }
            if (r6 == 0) goto L_0x002b
            boolean r6 = r1.canRead()     // Catch:{ all -> 0x00c7 }
            if (r6 == 0) goto L_0x002b
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ all -> 0x00c7 }
            r6.<init>(r1)     // Catch:{ all -> 0x00c7 }
            r4.load(r6)     // Catch:{ all -> 0x00c7 }
            goto L_0x002b
        L_0x00c2:
            r4.addProperty(r2, r6)     // Catch:{ all -> 0x00c7 }
            goto L_0x002b
        L_0x00c7:
            r6 = move-exception
            r4.isInitialized = r5     // Catch:{ all -> 0x000e }
            throw r6     // Catch:{ all -> 0x000e }
        L_0x00cb:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.ExtendedProperties.load(java.io.InputStream, java.lang.String):void");
    }

    public boolean getBoolean(String str, boolean z10) {
        return getBoolean(str, new Boolean(z10)).booleanValue();
    }

    public byte getByte(String str, byte b10) {
        return getByte(str, new Byte(b10)).byteValue();
    }

    public double getDouble(String str, double d10) {
        return getDouble(str, new Double(d10)).doubleValue();
    }

    public float getFloat(String str, float f10) {
        return getFloat(str, new Float(f10)).floatValue();
    }

    public int getInteger(String str, int i10) {
        Integer integer = getInteger(str, (Integer) null);
        if (integer == null) {
            return i10;
        }
        return integer.intValue();
    }

    public long getLong(String str, long j10) {
        return getLong(str, new Long(j10)).longValue();
    }

    public short getShort(String str, short s10) {
        return getShort(str, new Short(s10)).shortValue();
    }

    public Boolean getBoolean(String str, Boolean bool) {
        Object obj = get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            Boolean bool2 = new Boolean(testBoolean((String) obj));
            put(str, bool2);
            return bool2;
        } else if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getBoolean(str, bool) : bool;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('\'');
            stringBuffer.append(str);
            stringBuffer.append("' doesn't map to a Boolean object");
            throw new ClassCastException(stringBuffer.toString());
        }
    }

    public Byte getByte(String str, Byte b10) {
        Object obj = get(str);
        if (obj instanceof Byte) {
            return (Byte) obj;
        }
        if (obj instanceof String) {
            Byte b11 = new Byte((String) obj);
            put(str, b11);
            return b11;
        } else if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getByte(str, b10) : b10;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('\'');
            stringBuffer.append(str);
            stringBuffer.append("' doesn't map to a Byte object");
            throw new ClassCastException(stringBuffer.toString());
        }
    }

    public Double getDouble(String str, Double d10) {
        Object obj = get(str);
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof String) {
            Double d11 = new Double((String) obj);
            put(str, d11);
            return d11;
        } else if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getDouble(str, d10) : d10;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('\'');
            stringBuffer.append(str);
            stringBuffer.append("' doesn't map to a Double object");
            throw new ClassCastException(stringBuffer.toString());
        }
    }

    public Float getFloat(String str, Float f10) {
        Object obj = get(str);
        if (obj instanceof Float) {
            return (Float) obj;
        }
        if (obj instanceof String) {
            Float f11 = new Float((String) obj);
            put(str, f11);
            return f11;
        } else if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getFloat(str, f10) : f10;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('\'');
            stringBuffer.append(str);
            stringBuffer.append("' doesn't map to a Float object");
            throw new ClassCastException(stringBuffer.toString());
        }
    }

    public Long getLong(String str, Long l10) {
        Object obj = get(str);
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            Long l11 = new Long((String) obj);
            put(str, l11);
            return l11;
        } else if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getLong(str, l10) : l10;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('\'');
            stringBuffer.append(str);
            stringBuffer.append("' doesn't map to a Long object");
            throw new ClassCastException(stringBuffer.toString());
        }
    }

    public Short getShort(String str, Short sh2) {
        Object obj = get(str);
        if (obj instanceof Short) {
            return (Short) obj;
        }
        if (obj instanceof String) {
            Short sh3 = new Short((String) obj);
            put(str, sh3);
            return sh3;
        } else if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getShort(str, sh2) : sh2;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('\'');
            stringBuffer.append(str);
            stringBuffer.append("' doesn't map to a Short object");
            throw new ClassCastException(stringBuffer.toString());
        }
    }

    public ExtendedProperties(String str) throws IOException {
        this(str, (String) null);
    }

    public Integer getInteger(String str, Integer num) {
        Object obj = get(str);
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof String) {
            Integer num2 = new Integer((String) obj);
            put(str, num2);
            return num2;
        } else if (obj == null) {
            ExtendedProperties extendedProperties = this.defaults;
            return extendedProperties != null ? extendedProperties.getInteger(str, num) : num;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('\'');
            stringBuffer.append(str);
            stringBuffer.append("' doesn't map to a Integer object");
            throw new ClassCastException(stringBuffer.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056 A[SYNTHETIC, Splitter:B:19:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExtendedProperties(java.lang.String r4, java.lang.String r5) throws java.io.IOException {
        /*
            r3 = this;
            r3.<init>()
            org.apache.commons.collections.ExtendedProperties$1 r0 = new org.apache.commons.collections.ExtendedProperties$1     // Catch:{ SecurityException -> 0x0011 }
            r0.<init>()     // Catch:{ SecurityException -> 0x0011 }
            java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)     // Catch:{ SecurityException -> 0x0011 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ SecurityException -> 0x0011 }
            r3.fileSeparator = r0     // Catch:{ SecurityException -> 0x0011 }
            goto L_0x0015
        L_0x0011:
            java.lang.String r0 = java.io.File.separator
            r3.fileSeparator = r0
        L_0x0015:
            r0 = 0
            r3.isInitialized = r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r3.keysAsListed = r1
            r3.file = r4
            java.io.File r1 = new java.io.File
            r1.<init>(r4)
            java.lang.String r1 = r1.getAbsolutePath()
            r3.basePath = r1
            java.lang.String r2 = r3.fileSeparator
            int r2 = r1.lastIndexOf(r2)
            int r2 = r2 + 1
            java.lang.String r0 = r1.substring(r0, r2)
            r3.basePath = r0
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0053 }
            r1.<init>(r4)     // Catch:{ all -> 0x0053 }
            r3.load(r1)     // Catch:{ all -> 0x0050 }
            r1.close()     // Catch:{ IOException -> 0x0046 }
        L_0x0046:
            if (r5 == 0) goto L_0x004f
            org.apache.commons.collections.ExtendedProperties r4 = new org.apache.commons.collections.ExtendedProperties
            r4.<init>(r5)
            r3.defaults = r4
        L_0x004f:
            return
        L_0x0050:
            r4 = move-exception
            r0 = r1
            goto L_0x0054
        L_0x0053:
            r4 = move-exception
        L_0x0054:
            if (r0 == 0) goto L_0x0059
            r0.close()     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.ExtendedProperties.<init>(java.lang.String, java.lang.String):void");
    }
}
