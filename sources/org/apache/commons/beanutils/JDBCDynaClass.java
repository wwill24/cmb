package org.apache.commons.beanutils;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class JDBCDynaClass implements DynaClass, Serializable {
    private Map<String, String> columnNameXref;
    protected boolean lowerCase = true;
    protected DynaProperty[] properties = null;
    protected Map<String, DynaProperty> propertiesMap = new HashMap();
    private boolean useColumnLabel;

    JDBCDynaClass() {
    }

    /* access modifiers changed from: protected */
    public DynaProperty createDynaProperty(ResultSetMetaData resultSetMetaData, int i10) throws SQLException {
        String str;
        String str2;
        String str3 = null;
        if (this.useColumnLabel) {
            str = resultSetMetaData.getColumnLabel(i10);
        } else {
            str = null;
        }
        if (str == null || str.trim().length() == 0) {
            str = resultSetMetaData.getColumnName(i10);
        }
        if (this.lowerCase) {
            str2 = str.toLowerCase();
        } else {
            str2 = str;
        }
        if (!str2.equals(str)) {
            if (this.columnNameXref == null) {
                this.columnNameXref = new HashMap();
            }
            this.columnNameXref.put(str2, str);
        }
        try {
            switch (resultSetMetaData.getColumnType(i10)) {
                case 91:
                    return new DynaProperty(str2, Date.class);
                case 92:
                    return new DynaProperty(str2, Time.class);
                case 93:
                    return new DynaProperty(str2, Timestamp.class);
                default:
                    str3 = resultSetMetaData.getColumnClassName(i10);
                    break;
            }
        } catch (SQLException unused) {
        }
        Class cls = Object.class;
        if (str3 != null) {
            cls = loadClass(str3);
        }
        return new DynaProperty(str2, cls);
    }

    /* access modifiers changed from: protected */
    public String getColumnName(String str) {
        Map<String, String> map = this.columnNameXref;
        if (map == null || !map.containsKey(str)) {
            return str;
        }
        return this.columnNameXref.get(str);
    }

    public DynaProperty[] getDynaProperties() {
        return this.properties;
    }

    public DynaProperty getDynaProperty(String str) {
        if (str != null) {
            return this.propertiesMap.get(str);
        }
        throw new IllegalArgumentException("No property name specified");
    }

    public String getName() {
        return getClass().getName();
    }

    /* access modifiers changed from: protected */
    public Object getObject(ResultSet resultSet, String str) throws SQLException {
        DynaProperty dynaProperty = getDynaProperty(str);
        if (dynaProperty != null) {
            String columnName = getColumnName(str);
            Class<?> type = dynaProperty.getType();
            if (type.equals(Date.class)) {
                return resultSet.getDate(columnName);
            }
            if (type.equals(Timestamp.class)) {
                return resultSet.getTimestamp(columnName);
            }
            if (type.equals(Time.class)) {
                return resultSet.getTime(columnName);
            }
            return resultSet.getObject(columnName);
        }
        throw new IllegalArgumentException("Invalid name '" + str + "'");
    }

    /* access modifiers changed from: protected */
    public void introspect(ResultSet resultSet) throws SQLException {
        ArrayList arrayList = new ArrayList();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i10 = 1; i10 <= columnCount; i10++) {
            DynaProperty createDynaProperty = createDynaProperty(metaData, i10);
            if (createDynaProperty != null) {
                arrayList.add(createDynaProperty);
            }
        }
        this.properties = (DynaProperty[]) arrayList.toArray(new DynaProperty[arrayList.size()]);
        int i11 = 0;
        while (true) {
            DynaProperty[] dynaPropertyArr = this.properties;
            if (i11 < dynaPropertyArr.length) {
                this.propertiesMap.put(dynaPropertyArr[i11].getName(), this.properties[i11]);
                i11++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public Class<?> loadClass(String str) throws SQLException {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            return Class.forName(str, false, contextClassLoader);
        } catch (Exception e10) {
            throw new SQLException("Cannot load column class '" + str + "': " + e10);
        }
    }

    public DynaBean newInstance() throws IllegalAccessException, InstantiationException {
        throw new UnsupportedOperationException("newInstance() not supported");
    }

    public void setUseColumnLabel(boolean z10) {
        this.useColumnLabel = z10;
    }
}
