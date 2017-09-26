
    package de.christopherstock.sbp.mongo.tarifwechsel;

    import  com.fasterxml.jackson.annotation.*;
    import  org.springframework.data.annotation.*;
    import  java.math.*;
    import  java.util.*;

    @JsonIgnoreProperties( ignoreUnknown = true )
    public class TarifwechselEntity
    {
        @Id
        private String id;

        private String anrede;

        private String vorname;

        private String nachname;

        private Tarif tarifAlt;

        private Tarif tarifNeu;

        private BigDecimal preisNeu;

        private Zahlweise zahlweiseNeu;

        private BigInteger kdnr;

        private BigInteger vsnr;

        private Date createDate;

        private boolean ordered;

        @PersistenceConstructor
        public TarifwechselEntity(
            String anrede, String vorname, String nachname, Tarif tarifAlt, Tarif tarifNeu,
            BigDecimal preisNeu, Zahlweise zahlweiseNeu, BigInteger kdnr,
            BigInteger vsnr, Date createDate, boolean ordered
        ) {
            this.anrede = anrede;
            this.vorname = vorname;
            this.nachname = nachname;
            this.tarifAlt = tarifAlt;
            this.tarifNeu = tarifNeu;
            this.preisNeu = preisNeu;
            this.zahlweiseNeu = zahlweiseNeu;
            this.kdnr = kdnr;
            this.vsnr = vsnr;
            this.createDate = createDate;
            this.ordered = ordered;
        }

        public String getId() {
            return id;
        }

        public String getAnrede() {
            return anrede;
        }

        public String getVorname() {
            return vorname;
        }

        public String getNachname() {
            return nachname;
        }

        public Tarif getTarifAlt() {
            return tarifAlt;
        }

        public Tarif getTarifNeu() {
            return tarifNeu;
        }

        public BigDecimal getPreisNeu() {
            return preisNeu;
        }

        public Zahlweise getZahlweiseNeu() {
            return zahlweiseNeu;
        }

        public BigInteger getKdnr() {
            return kdnr;
        }

        public BigInteger getVsnr() {
            return vsnr;
        }

        public Date getCreateDate() {
            return createDate;
        }

        public boolean isOrdered() {
            return ordered;
        }

        public void setOrdered(boolean ordered) {
            this.ordered = ordered;
        }
    }
