public class VDM {

    public static void preTest(boolean condition) {
        if (!condition) {
            throw new RuntimeException("Precondition violated");
        }
    }

    public static void postTest(boolean condition) {
        if (!condition) {
            throw new RuntimeException("Postcondition violated");
        }
    }

    public static void invTest(InvariantCheck object) {
        if (!object.inv()) {
            throw new RuntimeException("Invariant violated");
        }
    }
}

