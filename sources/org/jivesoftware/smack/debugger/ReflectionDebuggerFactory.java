package org.jivesoftware.smack.debugger;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.XMPPConnection;

public final class ReflectionDebuggerFactory implements SmackDebuggerFactory {
    private static final String DEBUGGER_CLASS_PROPERTY_NAME = "smack.debuggerClass";
    private static final String[] DEFAULT_DEBUGGERS = {"org.jivesoftware.smackx.debugger.EnhancedDebugger", "org.jivesoftware.smackx.debugger.android.AndroidDebugger", "org.jivesoftware.smack.debugger.ConsoleDebugger", "org.jivesoftware.smack.debugger.LiteDebugger", "org.jivesoftware.smack.debugger.JulDebugger"};
    public static final ReflectionDebuggerFactory INSTANCE = new ReflectionDebuggerFactory();
    private static final Logger LOGGER = Logger.getLogger(ReflectionDebuggerFactory.class.getName());

    private ReflectionDebuggerFactory() {
    }

    private static String getCustomDebuggerClassName() {
        try {
            return System.getProperty(DEBUGGER_CLASS_PROPERTY_NAME);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<SmackDebugger> getDebuggerClass() {
        String customDebuggerClassName = getCustomDebuggerClassName();
        if (customDebuggerClassName == null) {
            return getOneOfDefaultDebuggerClasses();
        }
        try {
            return Class.forName(customDebuggerClassName);
        } catch (Exception e10) {
            Logger logger = LOGGER;
            Level level = Level.WARNING;
            logger.log(level, "Unable to instantiate debugger class " + customDebuggerClassName, e10);
            return null;
        }
    }

    private static Class<SmackDebugger> getOneOfDefaultDebuggerClasses() {
        for (String str : DEFAULT_DEBUGGERS) {
            if (!SmackConfiguration.isDisabledSmackClass(str)) {
                try {
                    return Class.forName(str);
                } catch (ClassNotFoundException unused) {
                    LOGGER.fine("Did not find debugger class '" + str + "'");
                } catch (ClassCastException unused2) {
                    LOGGER.warning("Found debugger class that does not appears to implement SmackDebugger interface");
                } catch (Exception unused3) {
                    LOGGER.warning("Unable to instantiate either Smack debugger class");
                }
            }
        }
        return null;
    }

    public static void setDebuggerClass(Class<? extends SmackDebugger> cls) {
        if (cls == null) {
            System.clearProperty(DEBUGGER_CLASS_PROPERTY_NAME);
        } else {
            System.setProperty(DEBUGGER_CLASS_PROPERTY_NAME, cls.getCanonicalName());
        }
    }

    public SmackDebugger create(XMPPConnection xMPPConnection) throws IllegalArgumentException {
        Class<SmackDebugger> debuggerClass = getDebuggerClass();
        if (debuggerClass == null) {
            return null;
        }
        try {
            return debuggerClass.getConstructor(new Class[]{XMPPConnection.class}).newInstance(new Object[]{xMPPConnection});
        } catch (Exception e10) {
            throw new IllegalArgumentException("Can't initialize the configured debugger!", e10);
        }
    }
}
