class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature is used");
    }

    public void newFeature() {
        System.out.println("New feature is used");
    }
}

public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
