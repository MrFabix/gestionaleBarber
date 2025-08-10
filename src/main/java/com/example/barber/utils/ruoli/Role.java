package com.example.barber.utils.ruoli;

public enum Role {
    CLIENTE("CLIENTE"),
    BARBER("BARBIERE"),
    MODERATORE("MODERATORE");

    private final String id;

    Role(String id) {this.id = id;}

   public static Role fromString(String input) {
        for (Role role : Role.values()) {
            if(role.getId().equals(input)) { return role; }
        }
       return null;
   }

    public String getId() {return id;}

}
