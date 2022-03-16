package com.quentinrouet.androkado.bo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by quentin for Androkado on 16/03/2022.
 */
public class Article implements Parcelable {
   String nom, url, description;
   float prix, note;
   boolean isAchete;

   public Article(String nom, String url, String description, float prix, float note, boolean isAchete) {
      this.nom = nom;
      this.url = url;
      this.description = description;
      this.prix = prix;
      this.note = note;
      this.isAchete = isAchete;
   }

   public Article() { }

   protected Article(Parcel in) {
      nom = in.readString();
      url = in.readString();
      description = in.readString();
      prix = in.readFloat();
      note = in.readFloat();
      isAchete = in.readByte() != 0;
   }

   @Override
   public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(nom);
      dest.writeString(url);
      dest.writeString(description);
      dest.writeFloat(prix);
      dest.writeFloat(note);
      dest.writeByte((byte) (isAchete ? 1 : 0));
   }

   @Override
   public int describeContents() {
      return 0;
   }

   public static final Creator<Article> CREATOR = new Creator<Article>() {
      @Override
      public Article createFromParcel(Parcel in) {
         return new Article(in);
      }

      @Override
      public Article[] newArray(int size) {
         return new Article[size];
      }
   };

   public String getNom() {
      return nom;
   }

   public void setNom(String nom) {
      this.nom = nom;
   }

   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   public String getDescription() {
      return description;
   }

   public float getPrix() {
      return prix;
   }

   public void setPrix(float prix) {
      this.prix = prix;
   }

   public float getNote() {
      return note;
   }

   public void setNote(float note) {
      this.note = note;
   }

   public boolean isAchete() {
      return isAchete;
   }

   public void setAchete(boolean achete) {
      isAchete = achete;
   }
}
