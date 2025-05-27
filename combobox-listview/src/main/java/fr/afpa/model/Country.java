package fr.afpa.model;

public class Country {
    private String name;
    private String codeIso;

    public Country(String name, String codeIso) {
        this.name = name;
        this.codeIso = codeIso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeIso() {
        return codeIso;
    }

    public void setCodeIso(String codeIso) {
        this.codeIso = codeIso;
    }

}
