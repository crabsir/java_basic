package error;

public class Main {

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        try {
            throw new Exception("Some exception");
        } catch (Exception e) {
            StackTraceElement[] s = e.getStackTrace();
            if (s.length > 2) return s[2].getClassName() + "#" + s[2].getMethodName();
            return null;
        }

    }
}
