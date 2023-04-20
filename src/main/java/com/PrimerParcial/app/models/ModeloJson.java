package com.PrimerParcial.app.models;

import java.util.ArrayList;

public class ModeloJson {

        private float id;
        private String name;
        private String status;
        private String species;
        private String type;
        private String gender;
        Origin OriginObject;
        Location LocationObject;
        private String image;
        ArrayList< Object > episode = new ArrayList < Object > ();
        private String url;
        private String created;


        // Getter Methods

        public float getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getStatus() {
            return status;
        }

        public String getSpecies() {
            return species;
        }

        public String getType() {
            return type;
        }

        public String getGender() {
            return gender;
        }

        public Origin getOrigin() {
            return OriginObject;
        }

        public Location getLocation() {
            return LocationObject;
        }

        public String getImage() {
            return image;
        }

        public String getUrl() {
            return url;
        }

        public String getCreated() {
            return created;
        }

        // Setter Methods

        public void setId(float id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setSpecies(String species) {
            this.species = species;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setOrigin(Origin originObject) {
            this.OriginObject = originObject;
        }

        public void setLocation(Location locationObject) {
            this.LocationObject = locationObject;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setCreated(String created) {
            this.created = created;
        }
    }

