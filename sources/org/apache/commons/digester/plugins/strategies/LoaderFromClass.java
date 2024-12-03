package org.apache.commons.digester.plugins.strategies;

import java.lang.reflect.Method;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.plugins.PluginException;
import org.apache.commons.digester.plugins.RuleLoader;
import org.apache.commons.logging.Log;

public class LoaderFromClass extends RuleLoader {
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$apache$commons$digester$Digester;
    private Class rulesClass;
    private Method rulesMethod;

    public LoaderFromClass(Class cls, Method method) {
        this.rulesClass = cls;
        this.rulesMethod = method;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    public static Method locateMethod(Class cls, String str) throws PluginException {
        Class[] clsArr = new Class[2];
        Class cls2 = class$org$apache$commons$digester$Digester;
        if (cls2 == null) {
            cls2 = class$("org.apache.commons.digester.Digester");
            class$org$apache$commons$digester$Digester = cls2;
        }
        clsArr[0] = cls2;
        Class cls3 = class$java$lang$String;
        if (cls3 == null) {
            cls3 = class$("java.lang.String");
            class$java$lang$String = cls3;
        }
        clsArr[1] = cls3;
        return MethodUtils.getAccessibleMethod((Class<?>) cls, str, (Class<?>[]) clsArr);
    }

    public void addRules(Digester digester, String str) throws PluginException {
        Log logger = digester.getLogger();
        if (logger.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("LoaderFromClass loading rules for plugin at path [");
            stringBuffer.append(str);
            stringBuffer.append("]");
            logger.debug(stringBuffer.toString());
        }
        try {
            this.rulesMethod.invoke((Object) null, new Object[]{digester, str});
        } catch (Exception e10) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Unable to invoke rules method ");
            stringBuffer2.append(this.rulesMethod);
            stringBuffer2.append(" on rules class ");
            stringBuffer2.append(this.rulesClass);
            throw new PluginException(stringBuffer2.toString(), e10);
        }
    }

    public LoaderFromClass(Class cls, String str) throws PluginException {
        Method locateMethod = locateMethod(cls, str);
        if (locateMethod != null) {
            this.rulesClass = cls;
            this.rulesMethod = locateMethod;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rule class ");
        stringBuffer.append(cls.getName());
        stringBuffer.append(" does not have method ");
        stringBuffer.append(str);
        stringBuffer.append(" or that method has an invalid signature.");
        throw new PluginException(stringBuffer.toString());
    }
}
