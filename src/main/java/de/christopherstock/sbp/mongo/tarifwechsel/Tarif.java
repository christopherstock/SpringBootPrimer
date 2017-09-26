
    package de.christopherstock.sbp.mongo.tarifwechsel;

    public enum Tarif
    {
        ZZP( "Zahn-Zuschuss-Plus"  ),
        ZAB( "Zahn-Ersatz"         ),
        ZBB( "Zahn-Erhalt"         ),
        ZEZ( "Zahn-Ersatz-Sofort"  ),
        ZEF( "Dental-Zuschuss"     ),
        ZAE( "Zahn-Ersatz-Premium" ),
        ZBE( "Zahn-Erhalt-Premium" );

        private String bezeichnung;

        private Tarif( final String bezeichnung )
        {
            this.bezeichnung = bezeichnung;
        }

        public String getBezeichnung()
        {
            return bezeichnung;
        }
    }
