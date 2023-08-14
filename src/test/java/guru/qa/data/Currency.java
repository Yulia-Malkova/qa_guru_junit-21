package guru.qa.data;


public enum Currency {
    RUB("Российский рубль"),
    BYN("Белорусский рубль"),
    KZT("Казахстанский тенге"),
    AMD("Армянский драм"),
    KGS("Киргизский сом"),
    UZS("Узбекский сум");

    private final String name;

    Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
