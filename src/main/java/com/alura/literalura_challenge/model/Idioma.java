package com.alura.literalura_challenge.model;

public enum Idioma {
    es("Español"),
    en("Inglés"),
    fr("Francés"),
    pt("Portugués"),
    nd("No disponible"),
    ;

    private String idiomaGtdx;

    Idioma(String idiomaCompleto){
        this.idiomaGtdx=idiomaCompleto;
    }

    public static Idioma stringAEnum(String idioma){
        for(Idioma item:Idioma.values()){
            if(item.name().equalsIgnoreCase(idioma)){
                return item;
            }
        }
        return nd;
    }

    public String getIdiomaCompleto() {
        return idiomaGtdx;
    }
}



