package com.quentinrouet.listener;

/**
 * Created by quentin for Androkado on 17/03/2022.
 */
public class Oiseau {
   String imageUrl, genre, famille;

   public Oiseau(String imageUrl, String genre, String famille) {
      this.imageUrl = imageUrl;
      this.genre = genre;
      this.famille = famille;
   }

   public String getImageUrl() {
      return imageUrl;
   }

   public void setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
   }

   public String getGenre() {
      return genre;
   }

   public void setGenre(String genre) {
      this.genre = genre;
   }

   public String getFamille() {
      return famille;
   }

   public void setFamille(String famille) {
      this.famille = famille;
   }
}
