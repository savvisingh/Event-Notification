package com.example.sikhi_calender3;

public class List_item {

     private String title;
     private int icon;

     public List_item(String title, int icon) {
             this.title = title;
            this.icon = icon;

        }

      public String getTitle() {
           return title;
       }

     public void setTitle(String title) {
          this.title = title;
     }

     public int getIcon() {
         return icon;
   }

     public void setIcon(int icon) {
      this.icon = icon;
    }

}