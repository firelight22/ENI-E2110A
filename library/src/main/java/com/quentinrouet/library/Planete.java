package com.quentinrouet.library;

/**
 * Created by quentin for Androkado on 22/03/2022.
 */
public class Planete {
   String name;
   String climate;

   public Planete(String name, String climate) {
      this.name = name;
      this.climate = climate;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getClimate() {
      return climate;
   }

   public void setClimate(String climate) {
      this.climate = climate;
   }
}
