
    package de.christopherstock.sbp.mongo;

    public enum Zahlweise
    {
        MONATLICH(        "monatlich"       ),
        SAISONVERTRAG(    "saisonal"        ),
        VIERTELJAEHRLICH( "vierteljährlich" ),
        HALBJAEHRLICH(    "halbjährlich"    ),
        JAEHRLICH(        "jährlich"        ),
        EINMALZAHLUNG(    "einmalich"       );

        private String bezeichnung;

        private Zahlweise( final String bezeichnung )
        {
            this.bezeichnung = bezeichnung;
        }

        public String getBezeichnung()
        {
            return bezeichnung;
        }
    }
