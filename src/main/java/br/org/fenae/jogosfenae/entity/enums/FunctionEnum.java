package br.org.fenae.jogosfenae.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FunctionEnum {
    PRESIDENTE ("Presidente"),
    DIRETOR_ESPORTE ("Diretor de esporte"),
    ATLETA ("Atleta"),
    PARATLETA ("Paratrela"),
    TECNICO("Técnico");

    private String functionEnum;

    FunctionEnum(String functionEnum) {
        this.functionEnum = functionEnum;
    }

    public String getFunctionEnum() {
        return functionEnum;
    }

    @JsonCreator
    public static String toString(String name){
        if(name == null)
            return null;

        for (FunctionEnum locatedFunction : FunctionEnum.values()){
            if(name.equals(locatedFunction.getFunctionEnum()))
                return locatedFunction.functionEnum;
        }

        throw new IllegalArgumentException("Tipo não encontrado: " + name);
    }
}
