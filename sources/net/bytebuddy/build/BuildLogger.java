package net.bytebuddy.build;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface BuildLogger {

    public static abstract class Adapter implements BuildLogger {
        public void debug(String str) {
        }

        public void debug(String str, Throwable th2) {
        }

        public void error(String str) {
        }

        public void error(String str, Throwable th2) {
        }

        public void info(String str) {
        }

        public void info(String str, Throwable th2) {
        }

        public boolean isDebugEnabled() {
            return false;
        }

        public boolean isErrorEnabled() {
            return false;
        }

        public boolean isInfoEnabled() {
            return false;
        }

        public boolean isWarnEnabled() {
            return false;
        }

        public void warn(String str) {
        }

        public void warn(String str, Throwable th2) {
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements BuildLogger {
        private final List<BuildLogger> buildLoggers;

        public Compound(BuildLogger... buildLoggerArr) {
            this((List<? extends BuildLogger>) Arrays.asList(buildLoggerArr));
        }

        public void debug(String str) {
            for (BuildLogger next : this.buildLoggers) {
                if (next.isDebugEnabled()) {
                    next.debug(str);
                }
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.buildLoggers.equals(((Compound) obj).buildLoggers);
        }

        public void error(String str) {
            for (BuildLogger next : this.buildLoggers) {
                if (next.isErrorEnabled()) {
                    next.error(str);
                }
            }
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.buildLoggers.hashCode();
        }

        public void info(String str) {
            for (BuildLogger next : this.buildLoggers) {
                if (next.isInfoEnabled()) {
                    next.info(str);
                }
            }
        }

        public boolean isDebugEnabled() {
            for (BuildLogger isDebugEnabled : this.buildLoggers) {
                if (isDebugEnabled.isDebugEnabled()) {
                    return true;
                }
            }
            return false;
        }

        public boolean isErrorEnabled() {
            for (BuildLogger isErrorEnabled : this.buildLoggers) {
                if (isErrorEnabled.isErrorEnabled()) {
                    return true;
                }
            }
            return false;
        }

        public boolean isInfoEnabled() {
            for (BuildLogger isInfoEnabled : this.buildLoggers) {
                if (isInfoEnabled.isInfoEnabled()) {
                    return true;
                }
            }
            return false;
        }

        public boolean isWarnEnabled() {
            for (BuildLogger isWarnEnabled : this.buildLoggers) {
                if (isWarnEnabled.isWarnEnabled()) {
                    return true;
                }
            }
            return false;
        }

        public void warn(String str) {
            for (BuildLogger next : this.buildLoggers) {
                if (next.isWarnEnabled()) {
                    next.warn(str);
                }
            }
        }

        public Compound(List<? extends BuildLogger> list) {
            this.buildLoggers = new ArrayList();
            for (BuildLogger buildLogger : list) {
                if (buildLogger instanceof Compound) {
                    this.buildLoggers.addAll(((Compound) buildLogger).buildLoggers);
                } else if (!(buildLogger instanceof NoOp)) {
                    this.buildLoggers.add(buildLogger);
                }
            }
        }

        public void debug(String str, Throwable th2) {
            for (BuildLogger next : this.buildLoggers) {
                if (next.isDebugEnabled()) {
                    next.debug(str, th2);
                }
            }
        }

        public void error(String str, Throwable th2) {
            for (BuildLogger next : this.buildLoggers) {
                if (next.isErrorEnabled()) {
                    next.error(str, th2);
                }
            }
        }

        public void info(String str, Throwable th2) {
            for (BuildLogger next : this.buildLoggers) {
                if (next.isInfoEnabled()) {
                    next.info(str, th2);
                }
            }
        }

        public void warn(String str, Throwable th2) {
            for (BuildLogger next : this.buildLoggers) {
                if (next.isWarnEnabled()) {
                    next.warn(str, th2);
                }
            }
        }
    }

    public enum NoOp implements BuildLogger {
        INSTANCE;

        public void debug(String str) {
        }

        public void debug(String str, Throwable th2) {
        }

        public void error(String str) {
        }

        public void error(String str, Throwable th2) {
        }

        public void info(String str) {
        }

        public void info(String str, Throwable th2) {
        }

        public boolean isDebugEnabled() {
            return false;
        }

        public boolean isErrorEnabled() {
            return false;
        }

        public boolean isInfoEnabled() {
            return false;
        }

        public boolean isWarnEnabled() {
            return false;
        }

        public void warn(String str) {
        }

        public void warn(String str, Throwable th2) {
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class StreamWriting implements BuildLogger {
        private final PrintStream printStream;

        public StreamWriting(PrintStream printStream2) {
            this.printStream = printStream2;
        }

        public static BuildLogger toSystemError() {
            return new StreamWriting(System.err);
        }

        public static BuildLogger toSystemOut() {
            return new StreamWriting(System.out);
        }

        public void debug(String str) {
            this.printStream.print(str);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.printStream.equals(((StreamWriting) obj).printStream);
        }

        public void error(String str) {
            this.printStream.print(str);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.printStream.hashCode();
        }

        public void info(String str) {
            this.printStream.print(str);
        }

        public boolean isDebugEnabled() {
            return true;
        }

        public boolean isErrorEnabled() {
            return true;
        }

        public boolean isInfoEnabled() {
            return true;
        }

        public boolean isWarnEnabled() {
            return true;
        }

        public void warn(String str) {
            this.printStream.print(str);
        }

        public void debug(String str, Throwable th2) {
            synchronized (this.printStream) {
                this.printStream.print(str);
                th2.printStackTrace(this.printStream);
            }
        }

        public void error(String str, Throwable th2) {
            synchronized (this.printStream) {
                this.printStream.print(str);
                th2.printStackTrace(this.printStream);
            }
        }

        public void info(String str, Throwable th2) {
            synchronized (this.printStream) {
                this.printStream.print(str);
                th2.printStackTrace(this.printStream);
            }
        }

        public void warn(String str, Throwable th2) {
            synchronized (this.printStream) {
                this.printStream.print(str);
                th2.printStackTrace(this.printStream);
            }
        }
    }

    void debug(String str);

    void debug(String str, Throwable th2);

    void error(String str);

    void error(String str, Throwable th2);

    void info(String str);

    void info(String str, Throwable th2);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isWarnEnabled();

    void warn(String str);

    void warn(String str, Throwable th2);
}
