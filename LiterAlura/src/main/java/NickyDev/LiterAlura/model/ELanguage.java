package NickyDev.LiterAlura.model;

public enum ELanguage {
    SPANISH("es", "SPANISH"),
    ENGLISH("en", "ENGLISH"),
    PORTUGUESE("pt", "PORTUGUESE"),
    FRENCH("fr", "FRENCH");

    private String APICategory;
    private String categorySpanish;

    ELanguage(String APICategory, String categorySpanish) {
        this.APICategory = APICategory;
        this.categorySpanish = categorySpanish;
    }

    public static ELanguage fromString(String text) {
        for (ELanguage cat : ELanguage.values()) {
            if (cat.APICategory.equalsIgnoreCase(text)) {
                return cat;
            }
        }
        throw new IllegalArgumentException("No category found: " + text);
    }

    public static ELanguage fromSpanish(String text) {
        for (ELanguage cat : ELanguage.values()) {
            if (cat.categorySpanish.equalsIgnoreCase(text)) {
                return cat;
            }
        }
        throw new IllegalArgumentException("No category found: " + text);
    }

    public String getAPICategory() {
        return APICategory;
    }

    public String getcategorySpanish() {
        return categorySpanish;
    }
}
