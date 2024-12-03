package org.apache.commons.beanutils;

import com.google.firebase.crashlytics.internal.common.IdManager;
import java.io.File;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import org.apache.commons.beanutils.converters.ArrayConverter;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.BigIntegerConverter;
import org.apache.commons.beanutils.converters.BooleanConverter;
import org.apache.commons.beanutils.converters.ByteConverter;
import org.apache.commons.beanutils.converters.CalendarConverter;
import org.apache.commons.beanutils.converters.CharacterConverter;
import org.apache.commons.beanutils.converters.ClassConverter;
import org.apache.commons.beanutils.converters.ConverterFacade;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FileConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.beanutils.converters.SqlTimeConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;
import org.apache.commons.beanutils.converters.StringConverter;
import org.apache.commons.beanutils.converters.URLConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConvertUtilsBean {
    private static final Character SPACE = new Character(' ');
    private static final Integer ZERO = new Integer(0);
    @Deprecated
    private static Short defaultShort = new Short(0);
    private final WeakFastHashMap<Class<?>, Converter> converters;
    @Deprecated
    private Boolean defaultBoolean = Boolean.FALSE;
    @Deprecated
    private Byte defaultByte = new Byte((byte) 0);
    @Deprecated
    private Character defaultCharacter = new Character(' ');
    @Deprecated
    private Double defaultDouble = new Double(0.0d);
    @Deprecated
    private Float defaultFloat = new Float(0.0f);
    @Deprecated
    private Integer defaultInteger = new Integer(0);
    @Deprecated
    private Long defaultLong = new Long(0);
    private final Log log = LogFactory.getLog(ConvertUtils.class);

    public ConvertUtilsBean() {
        WeakFastHashMap<Class<?>, Converter> weakFastHashMap = new WeakFastHashMap<>();
        this.converters = weakFastHashMap;
        weakFastHashMap.setFast(false);
        deregister();
        weakFastHashMap.setFast(true);
    }

    protected static ConvertUtilsBean getInstance() {
        return BeanUtilsBean.getInstance().getConvertUtils();
    }

    private void registerArrayConverter(Class<?> cls, Converter converter, boolean z10, int i10) {
        ArrayConverter arrayConverter;
        Class<?> cls2 = Array.newInstance(cls, 0).getClass();
        if (z10) {
            arrayConverter = new ArrayConverter(cls2, converter);
        } else {
            arrayConverter = new ArrayConverter(cls2, converter, i10);
        }
        register(cls2, (Converter) arrayConverter);
    }

    private void registerArrays(boolean z10, int i10) {
        registerArrayConverter(Boolean.TYPE, new BooleanConverter(), z10, i10);
        registerArrayConverter(Byte.TYPE, new ByteConverter(), z10, i10);
        registerArrayConverter(Character.TYPE, new CharacterConverter(), z10, i10);
        registerArrayConverter(Double.TYPE, new DoubleConverter(), z10, i10);
        registerArrayConverter(Float.TYPE, new FloatConverter(), z10, i10);
        registerArrayConverter(Integer.TYPE, new IntegerConverter(), z10, i10);
        registerArrayConverter(Long.TYPE, new LongConverter(), z10, i10);
        registerArrayConverter(Short.TYPE, new ShortConverter(), z10, i10);
        registerArrayConverter(BigDecimal.class, new BigDecimalConverter(), z10, i10);
        registerArrayConverter(BigInteger.class, new BigIntegerConverter(), z10, i10);
        registerArrayConverter(Boolean.class, new BooleanConverter(), z10, i10);
        registerArrayConverter(Byte.class, new ByteConverter(), z10, i10);
        registerArrayConverter(Character.class, new CharacterConverter(), z10, i10);
        registerArrayConverter(Double.class, new DoubleConverter(), z10, i10);
        registerArrayConverter(Float.class, new FloatConverter(), z10, i10);
        registerArrayConverter(Integer.class, new IntegerConverter(), z10, i10);
        registerArrayConverter(Long.class, new LongConverter(), z10, i10);
        registerArrayConverter(Short.class, new ShortConverter(), z10, i10);
        registerArrayConverter(String.class, new StringConverter(), z10, i10);
        registerArrayConverter(Class.class, new ClassConverter(), z10, i10);
        registerArrayConverter(Date.class, new DateConverter(), z10, i10);
        registerArrayConverter(Calendar.class, new DateConverter(), z10, i10);
        registerArrayConverter(File.class, new FileConverter(), z10, i10);
        registerArrayConverter(java.sql.Date.class, new SqlDateConverter(), z10, i10);
        registerArrayConverter(Time.class, new SqlTimeConverter(), z10, i10);
        registerArrayConverter(Timestamp.class, new SqlTimestampConverter(), z10, i10);
        registerArrayConverter(URL.class, new URLConverter(), z10, i10);
    }

    private void registerOther(boolean z10) {
        ClassConverter classConverter;
        DateConverter dateConverter;
        CalendarConverter calendarConverter;
        FileConverter fileConverter;
        SqlDateConverter sqlDateConverter;
        SqlTimeConverter sqlTimeConverter;
        SqlTimestampConverter sqlTimestampConverter;
        URLConverter uRLConverter;
        Class<Class> cls = Class.class;
        if (!z10) {
            classConverter = new ClassConverter((Object) null);
        }
        register((Class<?>) cls, (Converter) classConverter);
        Class<Date> cls2 = Date.class;
        if (!z10) {
            dateConverter = new DateConverter((Object) null);
        }
        register((Class<?>) cls2, (Converter) dateConverter);
        Class<Calendar> cls3 = Calendar.class;
        if (!z10) {
            calendarConverter = new CalendarConverter((Object) null);
        }
        register((Class<?>) cls3, (Converter) calendarConverter);
        Class<File> cls4 = File.class;
        if (!z10) {
            fileConverter = new FileConverter((Object) null);
        }
        register((Class<?>) cls4, (Converter) fileConverter);
        Class<java.sql.Date> cls5 = java.sql.Date.class;
        if (!z10) {
            sqlDateConverter = new SqlDateConverter((Object) null);
        }
        register((Class<?>) cls5, (Converter) sqlDateConverter);
        Class<Time> cls6 = Time.class;
        if (!z10) {
            sqlTimeConverter = new SqlTimeConverter((Object) null);
        }
        register((Class<?>) cls6, (Converter) sqlTimeConverter);
        Class<Timestamp> cls7 = Timestamp.class;
        if (!z10) {
            sqlTimestampConverter = new SqlTimestampConverter((Object) null);
        }
        register((Class<?>) cls7, (Converter) sqlTimestampConverter);
        Class<URL> cls8 = URL.class;
        if (z10) {
            uRLConverter = new URLConverter();
        } else {
            uRLConverter = new URLConverter((Object) null);
        }
        register((Class<?>) cls8, (Converter) uRLConverter);
    }

    private void registerPrimitives(boolean z10) {
        BooleanConverter booleanConverter;
        ByteConverter byteConverter;
        CharacterConverter characterConverter;
        DoubleConverter doubleConverter;
        FloatConverter floatConverter;
        IntegerConverter integerConverter;
        LongConverter longConverter;
        ShortConverter shortConverter;
        Class cls = Boolean.TYPE;
        if (!z10) {
            booleanConverter = new BooleanConverter(Boolean.FALSE);
        }
        register((Class<?>) cls, (Converter) booleanConverter);
        Class cls2 = Byte.TYPE;
        if (!z10) {
            byteConverter = new ByteConverter(ZERO);
        }
        register((Class<?>) cls2, (Converter) byteConverter);
        Class cls3 = Character.TYPE;
        if (!z10) {
            characterConverter = new CharacterConverter(SPACE);
        }
        register((Class<?>) cls3, (Converter) characterConverter);
        Class cls4 = Double.TYPE;
        if (!z10) {
            doubleConverter = new DoubleConverter(ZERO);
        }
        register((Class<?>) cls4, (Converter) doubleConverter);
        Class cls5 = Float.TYPE;
        if (!z10) {
            floatConverter = new FloatConverter(ZERO);
        }
        register((Class<?>) cls5, (Converter) floatConverter);
        Class cls6 = Integer.TYPE;
        if (!z10) {
            integerConverter = new IntegerConverter(ZERO);
        }
        register((Class<?>) cls6, (Converter) integerConverter);
        Class cls7 = Long.TYPE;
        if (!z10) {
            longConverter = new LongConverter(ZERO);
        }
        register((Class<?>) cls7, (Converter) longConverter);
        Class cls8 = Short.TYPE;
        if (z10) {
            shortConverter = new ShortConverter();
        } else {
            shortConverter = new ShortConverter(ZERO);
        }
        register((Class<?>) cls8, (Converter) shortConverter);
    }

    private void registerStandard(boolean z10, boolean z11) {
        Integer num;
        BigDecimal bigDecimal;
        BigInteger bigInteger;
        Boolean bool;
        Character ch2;
        BigDecimalConverter bigDecimalConverter;
        BigIntegerConverter bigIntegerConverter;
        BooleanConverter booleanConverter;
        ByteConverter byteConverter;
        CharacterConverter characterConverter;
        DoubleConverter doubleConverter;
        FloatConverter floatConverter;
        IntegerConverter integerConverter;
        LongConverter longConverter;
        ShortConverter shortConverter;
        StringConverter stringConverter;
        String str = null;
        if (z11) {
            num = null;
        } else {
            num = ZERO;
        }
        if (z11) {
            bigDecimal = null;
        } else {
            bigDecimal = new BigDecimal(IdManager.DEFAULT_VERSION_NAME);
        }
        if (z11) {
            bigInteger = null;
        } else {
            bigInteger = new BigInteger("0");
        }
        if (z11) {
            bool = null;
        } else {
            bool = Boolean.FALSE;
        }
        if (z11) {
            ch2 = null;
        } else {
            ch2 = SPACE;
        }
        if (!z11) {
            str = "";
        }
        Class<BigDecimal> cls = BigDecimal.class;
        if (z10) {
            bigDecimalConverter = new BigDecimalConverter();
        } else {
            bigDecimalConverter = new BigDecimalConverter(bigDecimal);
        }
        register((Class<?>) cls, (Converter) bigDecimalConverter);
        Class<BigInteger> cls2 = BigInteger.class;
        if (!z10) {
            bigIntegerConverter = new BigIntegerConverter(bigInteger);
        }
        register((Class<?>) cls2, (Converter) bigIntegerConverter);
        Class<Boolean> cls3 = Boolean.class;
        if (!z10) {
            booleanConverter = new BooleanConverter(bool);
        }
        register((Class<?>) cls3, (Converter) booleanConverter);
        Class<Byte> cls4 = Byte.class;
        if (!z10) {
            byteConverter = new ByteConverter(num);
        }
        register((Class<?>) cls4, (Converter) byteConverter);
        Class<Character> cls5 = Character.class;
        if (!z10) {
            characterConverter = new CharacterConverter(ch2);
        }
        register((Class<?>) cls5, (Converter) characterConverter);
        Class<Double> cls6 = Double.class;
        if (!z10) {
            doubleConverter = new DoubleConverter(num);
        }
        register((Class<?>) cls6, (Converter) doubleConverter);
        Class<Float> cls7 = Float.class;
        if (!z10) {
            floatConverter = new FloatConverter(num);
        }
        register((Class<?>) cls7, (Converter) floatConverter);
        Class<Integer> cls8 = Integer.class;
        if (!z10) {
            integerConverter = new IntegerConverter(num);
        }
        register((Class<?>) cls8, (Converter) integerConverter);
        Class<Long> cls9 = Long.class;
        if (!z10) {
            longConverter = new LongConverter(num);
        }
        register((Class<?>) cls9, (Converter) longConverter);
        Class<Short> cls10 = Short.class;
        if (z10) {
            shortConverter = new ShortConverter();
        } else {
            shortConverter = new ShortConverter(num);
        }
        register((Class<?>) cls10, (Converter) shortConverter);
        Class<String> cls11 = String.class;
        if (z10) {
            stringConverter = new StringConverter();
        } else {
            stringConverter = new StringConverter(str);
        }
        register((Class<?>) cls11, (Converter) stringConverter);
    }

    public String convert(Object obj) {
        Object obj2;
        Class cls = String.class;
        if (obj == null) {
            return null;
        }
        if (!obj.getClass().isArray()) {
            return (String) lookup(cls).convert(cls, obj);
        }
        if (Array.getLength(obj) >= 1 && (obj2 = Array.get(obj, 0)) != null) {
            return (String) lookup(cls).convert(cls, obj2);
        }
        return null;
    }

    public void deregister() {
        this.converters.clear();
        registerPrimitives(false);
        registerStandard(false, false);
        registerOther(true);
        registerArrays(false, 0);
        register((Class<?>) BigDecimal.class, (Converter) new BigDecimalConverter());
        register((Class<?>) BigInteger.class, (Converter) new BigIntegerConverter());
    }

    @Deprecated
    public boolean getDefaultBoolean() {
        return this.defaultBoolean.booleanValue();
    }

    @Deprecated
    public byte getDefaultByte() {
        return this.defaultByte.byteValue();
    }

    @Deprecated
    public char getDefaultCharacter() {
        return this.defaultCharacter.charValue();
    }

    @Deprecated
    public double getDefaultDouble() {
        return this.defaultDouble.doubleValue();
    }

    @Deprecated
    public float getDefaultFloat() {
        return this.defaultFloat.floatValue();
    }

    @Deprecated
    public int getDefaultInteger() {
        return this.defaultInteger.intValue();
    }

    @Deprecated
    public long getDefaultLong() {
        return this.defaultLong.longValue();
    }

    @Deprecated
    public short getDefaultShort() {
        return defaultShort.shortValue();
    }

    public Converter lookup(Class<?> cls) {
        return this.converters.get(cls);
    }

    public void register(boolean z10, boolean z11, int i10) {
        registerPrimitives(z10);
        registerStandard(z10, z11);
        registerOther(z10);
        registerArrays(z10, i10);
    }

    @Deprecated
    public void setDefaultBoolean(boolean z10) {
        Boolean bool;
        if (z10) {
            bool = Boolean.TRUE;
        } else {
            bool = Boolean.FALSE;
        }
        this.defaultBoolean = bool;
        register((Converter) new BooleanConverter(this.defaultBoolean), (Class<?>) Boolean.TYPE);
        register((Converter) new BooleanConverter(this.defaultBoolean), (Class<?>) Boolean.class);
    }

    @Deprecated
    public void setDefaultByte(byte b10) {
        this.defaultByte = new Byte(b10);
        register((Converter) new ByteConverter(this.defaultByte), (Class<?>) Byte.TYPE);
        register((Converter) new ByteConverter(this.defaultByte), (Class<?>) Byte.class);
    }

    @Deprecated
    public void setDefaultCharacter(char c10) {
        Character ch2 = new Character(c10);
        this.defaultCharacter = ch2;
        register((Converter) new CharacterConverter(ch2), (Class<?>) Character.TYPE);
        register((Converter) new CharacterConverter(this.defaultCharacter), (Class<?>) Character.class);
    }

    @Deprecated
    public void setDefaultDouble(double d10) {
        this.defaultDouble = new Double(d10);
        register((Converter) new DoubleConverter(this.defaultDouble), (Class<?>) Double.TYPE);
        register((Converter) new DoubleConverter(this.defaultDouble), (Class<?>) Double.class);
    }

    @Deprecated
    public void setDefaultFloat(float f10) {
        this.defaultFloat = new Float(f10);
        register((Converter) new FloatConverter(this.defaultFloat), (Class<?>) Float.TYPE);
        register((Converter) new FloatConverter(this.defaultFloat), (Class<?>) Float.class);
    }

    @Deprecated
    public void setDefaultInteger(int i10) {
        this.defaultInteger = new Integer(i10);
        register((Converter) new IntegerConverter(this.defaultInteger), (Class<?>) Integer.TYPE);
        register((Converter) new IntegerConverter(this.defaultInteger), (Class<?>) Integer.class);
    }

    @Deprecated
    public void setDefaultLong(long j10) {
        this.defaultLong = new Long(j10);
        register((Converter) new LongConverter(this.defaultLong), (Class<?>) Long.TYPE);
        register((Converter) new LongConverter(this.defaultLong), (Class<?>) Long.class);
    }

    @Deprecated
    public void setDefaultShort(short s10) {
        defaultShort = new Short(s10);
        register((Converter) new ShortConverter(defaultShort), (Class<?>) Short.TYPE);
        register((Converter) new ShortConverter(defaultShort), (Class<?>) Short.class);
    }

    public Converter lookup(Class<?> cls, Class<?> cls2) {
        Class<String> cls3 = String.class;
        Class<String[]> cls4 = String[].class;
        if (cls2 == null) {
            throw new IllegalArgumentException("Target type is missing");
        } else if (cls == null) {
            return lookup(cls2);
        } else {
            Converter converter = null;
            if (cls2 == cls3) {
                Converter lookup = lookup(cls);
                if (lookup == null && (cls.isArray() || Collection.class.isAssignableFrom(cls))) {
                    lookup = lookup(cls4);
                }
                return lookup == null ? lookup(cls3) : lookup;
            } else if (cls2 != cls4) {
                return lookup(cls2);
            } else {
                if (cls.isArray() || Collection.class.isAssignableFrom(cls)) {
                    converter = lookup(cls);
                }
                return converter == null ? lookup(cls4) : converter;
            }
        }
    }

    private void register(Class<?> cls, Converter converter) {
        register((Converter) new ConverterFacade(converter), cls);
    }

    public void register(Converter converter, Class<?> cls) {
        this.converters.put(cls, converter);
    }

    public void deregister(Class<?> cls) {
        this.converters.remove(cls);
    }

    public Object convert(String str, Class<?> cls) {
        if (this.log.isDebugEnabled()) {
            Log log2 = this.log;
            log2.debug("Convert string '" + str + "' to class '" + cls.getName() + "'");
        }
        Converter lookup = lookup(cls);
        if (lookup == null) {
            lookup = lookup(String.class);
        }
        if (this.log.isTraceEnabled()) {
            Log log3 = this.log;
            log3.trace("  Using converter " + lookup);
        }
        return lookup.convert(cls, str);
    }

    public Object convert(String[] strArr, Class<?> cls) {
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        if (this.log.isDebugEnabled()) {
            Log log2 = this.log;
            log2.debug("Convert String[" + strArr.length + "] to class '" + cls.getName() + "[]'");
        }
        Converter lookup = lookup(cls);
        if (lookup == null) {
            lookup = lookup(String.class);
        }
        if (this.log.isTraceEnabled()) {
            Log log3 = this.log;
            log3.trace("  Using converter " + lookup);
        }
        Object newInstance = Array.newInstance(cls, strArr.length);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            Array.set(newInstance, i10, lookup.convert(cls, strArr[i10]));
        }
        return newInstance;
    }

    public Object convert(Object obj, Class<?> cls) {
        Class cls2 = String.class;
        Class<?> cls3 = obj == null ? null : obj.getClass();
        if (this.log.isDebugEnabled()) {
            if (obj == null) {
                Log log2 = this.log;
                log2.debug("Convert null value to type '" + cls.getName() + "'");
            } else {
                Log log3 = this.log;
                log3.debug("Convert type '" + cls3.getName() + "' value '" + obj + "' to type '" + cls.getName() + "'");
            }
        }
        Converter lookup = lookup(cls3, cls);
        if (lookup != null) {
            if (this.log.isTraceEnabled()) {
                Log log4 = this.log;
                log4.trace("  Using converter " + lookup);
            }
            obj = lookup.convert(cls, obj);
        }
        if (!cls2.equals(cls) || obj == null || (obj instanceof String)) {
            return obj;
        }
        Converter lookup2 = lookup(cls2);
        if (lookup2 != null) {
            if (this.log.isTraceEnabled()) {
                Log log5 = this.log;
                log5.trace("  Using converter " + lookup2);
            }
            obj = lookup2.convert(cls2, obj);
        }
        return (obj == null || (obj instanceof String)) ? obj : obj.toString();
    }
}
