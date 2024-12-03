package org.jivesoftware.smack.provider;

import com.leanplum.internal.Constants;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.validator.Var;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

public class IntrospectionProvider {

    /* renamed from: org.jivesoftware.smack.provider.IntrospectionProvider$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.xml.XmlPullParser$Event[] r0 = org.jivesoftware.smack.xml.XmlPullParser.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = r0
                org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.START_ELEMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.xml.XmlPullParser$Event r1 = org.jivesoftware.smack.xml.XmlPullParser.Event.END_ELEMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.provider.IntrospectionProvider.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class IQIntrospectionProvider<I extends IQ> extends IQProvider<I> {
        private final Class<I> elementClass;

        protected IQIntrospectionProvider(Class<I> cls) {
            this.elementClass = cls;
        }

        public I parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            try {
                return (IQ) IntrospectionProvider.parseWithIntrospection(this.elementClass, xmlPullParser, i10);
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e10) {
                throw new IOException(e10);
            }
        }
    }

    public static abstract class PacketExtensionIntrospectionProvider<PE extends ExtensionElement> extends ExtensionElementProvider<PE> {
        private final Class<PE> elementClass;

        protected PacketExtensionIntrospectionProvider(Class<PE> cls) {
            this.elementClass = cls;
        }

        public PE parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            try {
                return (ExtensionElement) IntrospectionProvider.parseWithIntrospection(this.elementClass, xmlPullParser, i10);
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e10) {
                throw new IOException(e10);
            }
        }
    }

    private static Object decode(Class<?> cls, String str) throws ClassNotFoundException {
        String name = cls.getName();
        if (name.equals("double")) {
            return Double.valueOf(str);
        }
        if (name.equals("java.lang.Class")) {
            return Class.forName(str);
        }
        if (name.equals(Var.JSTYPE_INT)) {
            return Integer.valueOf(str);
        }
        if (name.equals("byte")) {
            return Byte.valueOf(str);
        }
        if (name.equals("long")) {
            return Long.valueOf(str);
        }
        if (name.equals("boolean")) {
            return Boolean.valueOf(str);
        }
        if (name.equals(Constants.Kinds.FLOAT)) {
            return Float.valueOf(str);
        }
        if (name.equals("short")) {
            return Short.valueOf(str);
        }
        if (!name.equals("java.lang.String")) {
            return null;
        }
        return str;
    }

    public static Object parseWithIntrospection(Class<?> cls, XmlPullParser xmlPullParser, int i10) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, XmlPullParserException, IOException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
        ParserUtils.assertAtStartTag(xmlPullParser);
        Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        while (true) {
            int i11 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i11 == 1) {
                String name = xmlPullParser.getName();
                String nextText = xmlPullParser.nextText();
                Class<?> cls2 = newInstance.getClass();
                Class<?> returnType = cls2.getMethod("get" + Character.toUpperCase(name.charAt(0)) + name.substring(1), new Class[0]).getReturnType();
                Object decode = decode(returnType, nextText);
                Class<?> cls3 = newInstance.getClass();
                cls3.getMethod("set" + Character.toUpperCase(name.charAt(0)) + name.substring(1), new Class[]{returnType}).invoke(newInstance, new Object[]{decode});
            } else if (i11 == 2 && xmlPullParser.getDepth() == i10) {
                ParserUtils.assertAtEndTag(xmlPullParser);
                return newInstance;
            }
        }
    }
}
