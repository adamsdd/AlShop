package pl.adamsdd.AlShop.domain.alcohol;

public enum WineType {

    RIESLING("Riesling"),
    CHARDONNAY("Chardonnay"),
    SYRAH("Syrah"),
    MERLOT("Merlot"),
    PINOT_NOIR("Pinot Noir");

    public String name;

    WineType(String name) {
        this.name = name;
    }
}
