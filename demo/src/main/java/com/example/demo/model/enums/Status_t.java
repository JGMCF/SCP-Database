package com.example.demo.model.enums;                      
import com.fasterxml.jackson.annotation.JsonValue;       


// Enum avancado para lidar com um nome que possue hifen
// Licao aprendida: evitar nomear com hifens para nao causar
// erros de compatibilidade.

// representa o enum status_t no DB


public enum Status_t {                                     
    PLANNED("planned"),
    ON_GOING("on-going"),
    FAILURE("failure"),
    SUCESS("sucess");

    private final String value;

    Status_t(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}