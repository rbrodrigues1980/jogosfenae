package br.org.fenae.jogosfenae.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum GenderEnum {

    MALE ("Masculino"), FEMALE ("Feminino");

    private String gender;

    GenderEnum(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    @JsonCreator
    public static String toString(String name){
        if(name == null)
            return null;

        for (GenderEnum locatedGender : GenderEnum.values()){
            if(name.equals(locatedGender.getGender()))
                return locatedGender.gender;
        }

        throw new IllegalArgumentException("Sexo inválido: " + name);
    }

}
