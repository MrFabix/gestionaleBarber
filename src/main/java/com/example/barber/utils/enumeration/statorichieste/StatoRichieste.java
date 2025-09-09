package com.example.barber.utils.enumeration.statorichieste;

public enum StatoRichieste {
        ACCETTATA("ACCETTATA"),
        RIFIUTATA("RIFIUTATA"),
        PENDENTE("PENDENTE"),
        TERMINATA("TERMINATA");

        private final String id;

        StatoRichieste(String id) {this.id = id;}

        public static StatoRichieste fromString(String input) {
            for (StatoRichieste stato : StatoRichieste.values()) {
                if(stato.getId().equals(input)) { return stato; }
            }
            return null;
        }

        public String getId() {return id;}

}
