package by.nhryshalevich.SemiGemstone;

public enum SemiGemstonesNames {
    Alexandrite("Alexandrite"),
    Agate("Agate"),
    Amethyst("Amethyst"),
    Aquamarine("Aquamarine"),
    Garnet("Garnet"),
    LapisLazuli("LapisLazuli"),
    Moonstone("Moonstone"),
    Opal("Opal"),
    Pearl("Pearl"),
    Peridot("Peridot"),
    RoseQuartz("RoseQuartz"),
    Spinel("Spinel"),
    Tanzanite("Tanzanite"),
    Tourmaline("Tourmaline"),
    Turquoise("Turquoise"),
    Zircon("Zircon");

    String name;

    SemiGemstonesNames(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
