package br.org.fenae.jogosfenae.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FunctionEnum {
    ATLETA ("ATLETA"), PRESIDENTE ("PRESIDENTE"), DIRETOR_ESPORTE ("Diretor de esporte");

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

        throw new IllegalArgumentException("Apcef ou Fenae inválido: " + name);
    }
}
