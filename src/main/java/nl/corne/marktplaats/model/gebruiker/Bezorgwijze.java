package nl.corne.marktplaats.model.gebruiker;

public enum Bezorgwijze {

        THUISAFHALEN("Thuis afhalen"),
        VERSTUREN("Versturen"),
        MAGAZIJNBELASTINGDIENST("Magazijn Belastingdienst");

        private String description;

        Bezorgwijze(String description){
                this.description = description;
        }
        public String getDescription(){
                return description;
        }

        @Override
        public String toString() {
                return description;
        }
}
