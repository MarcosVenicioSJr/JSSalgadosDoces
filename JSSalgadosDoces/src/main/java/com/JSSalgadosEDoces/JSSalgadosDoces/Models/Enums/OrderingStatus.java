package com.JSSalgadosEDoces.JSSalgadosDoces.Models.Enums;

public enum OrderingStatus {
    AwaitingAccept("AwaitingAccept"),
    Accept("Accept"),
    Denied("Denied"),
    InTransit("InTransit"),
    Delivered("Delivered");

    private String description;
    OrderingStatus(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
