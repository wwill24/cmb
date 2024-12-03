package org.bouncycastle.util.test;

import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.util.Arrays;

public abstract class SimpleTest implements Test {
    public static void runTest(Test test) {
        runTest(test, System.out);
    }

    public static void runTest(Test test, PrintStream printStream) {
        TestResult perform = test.perform();
        if (perform.getException() != null) {
            perform.getException().printStackTrace(printStream);
        }
        printStream.println(perform);
    }

    public static void runTests(Test[] testArr) {
        runTests(testArr, System.out);
    }

    public static void runTests(Test[] testArr, PrintStream printStream) {
        Vector vector = new Vector();
        for (int i10 = 0; i10 != testArr.length; i10++) {
            TestResult perform = testArr[i10].perform();
            if (!perform.isSuccessful()) {
                vector.addElement(perform);
            }
            if (perform.getException() != null) {
                perform.getException().printStackTrace(printStream);
            }
            printStream.println(perform);
        }
        printStream.println("-----");
        if (vector.isEmpty()) {
            printStream.println("All tests successful.");
            return;
        }
        printStream.println("Completed with " + vector.size() + " FAILURES:");
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            PrintStream printStream2 = System.out;
            printStream2.println("=>  " + ((TestResult) elements.nextElement()));
        }
    }

    private TestResult success() {
        return SimpleTestResult.successful(this, "Okay");
    }

    /* access modifiers changed from: protected */
    public boolean areEqual(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13) {
        return Arrays.areEqual(bArr, i10, i11, bArr2, i12, i13);
    }

    /* access modifiers changed from: protected */
    public boolean areEqual(byte[] bArr, byte[] bArr2) {
        return Arrays.areEqual(bArr, bArr2);
    }

    /* access modifiers changed from: protected */
    public boolean areEqual(byte[][] bArr, byte[][] bArr2) {
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (!areEqual(bArr[i10], bArr2[i10])) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void fail(String str) {
        throw new TestFailedException(SimpleTestResult.failed(this, str));
    }

    /* access modifiers changed from: protected */
    public void fail(String str, Object obj, Object obj2) {
        throw new TestFailedException(SimpleTestResult.failed(this, str, obj, obj2));
    }

    /* access modifiers changed from: protected */
    public void fail(String str, Throwable th2) {
        throw new TestFailedException(SimpleTestResult.failed(this, str, th2));
    }

    public abstract String getName();

    /* access modifiers changed from: protected */
    public void isEquals(int i10, int i11) {
        if (i10 != i11) {
            throw new TestFailedException(SimpleTestResult.failed(this, "no message"));
        }
    }

    /* access modifiers changed from: protected */
    public void isEquals(long j10, long j11) {
        if (j10 != j11) {
            throw new TestFailedException(SimpleTestResult.failed(this, "no message"));
        }
    }

    /* access modifiers changed from: protected */
    public void isEquals(Object obj, Object obj2) {
        if (!obj.equals(obj2)) {
            throw new TestFailedException(SimpleTestResult.failed(this, "no message"));
        }
    }

    /* access modifiers changed from: protected */
    public void isEquals(String str, long j10, long j11) {
        if (j10 != j11) {
            throw new TestFailedException(SimpleTestResult.failed(this, str));
        }
    }

    /* access modifiers changed from: protected */
    public void isEquals(String str, Object obj, Object obj2) {
        if (obj != null || obj2 != null) {
            if (obj == null) {
                throw new TestFailedException(SimpleTestResult.failed(this, str));
            } else if (obj2 == null) {
                throw new TestFailedException(SimpleTestResult.failed(this, str));
            } else if (!obj.equals(obj2)) {
                throw new TestFailedException(SimpleTestResult.failed(this, str));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void isEquals(String str, boolean z10, boolean z11) {
        if (z10 != z11) {
            throw new TestFailedException(SimpleTestResult.failed(this, str));
        }
    }

    /* access modifiers changed from: protected */
    public void isTrue(String str, boolean z10) {
        if (!z10) {
            throw new TestFailedException(SimpleTestResult.failed(this, str));
        }
    }

    /* access modifiers changed from: protected */
    public void isTrue(boolean z10) {
        if (!z10) {
            throw new TestFailedException(SimpleTestResult.failed(this, "no message"));
        }
    }

    public TestResult perform() {
        try {
            performTest();
            return success();
        } catch (TestFailedException e10) {
            return e10.getResult();
        } catch (Exception e11) {
            return SimpleTestResult.failed(this, "Exception: " + e11, e11);
        }
    }

    public abstract void performTest() throws Exception;
}
