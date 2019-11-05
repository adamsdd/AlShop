package pl.adamsdd.AlShop.domain.alcohol;

public enum BeerType {

    BROWN_ALE("Brown ALE"),
    PALE_ALE("Pale ALE"),
    INDIA_PALE_ALE("India Pale ALE"),
    PORTER("Porter"),
    STOUT("Stout"),
    LAGER("Lager"),
    AMERICAN_SOUR("American Sour");

    public String name;

    BeerType(String name) {
        this.name = name;
    }
}
