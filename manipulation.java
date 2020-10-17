 package projet;
 import java.util.*;
 public class manipulation{
   private int i,j;
   public static ArrayList<Integer> occ = new ArrayList<Integer>();  
      
   //données membres
   String monTexte, maChaine;
   //constructeurs
   public manipulation(){ monTexte = "" ; maChaine = ""; }
   public manipulation(String _monTexte, String _maChaine){
      monTexte = _monTexte;
      maChaine = _maChaine;
   }
   //fonction qui retourne si la sous chaine existe dans le texte
   public boolean presence(String monTexte, String maChaine,int i){
      boolean misy;
      j = 0;
      misy = true;
      while ( j < maChaine.length() && misy == true){
          if ( monTexte.charAt(i+j) != maChaine.charAt(j) ) misy = false;
          j+=1;  
      }
      return misy;     
   }
  
   //fonction qui cherche les positions possibles de la sous chaine dans le texte,calcule le nombre de repetition de la sous-chaine  dans le texte
   public int cherche(String monTexte, String maChaine){
      int compteur,rang;
      compteur = 0;
      rang = 1;
      for(i = 0 ; i < monTexte.length(); i++){
         if ( i != monTexte.length() - 1){
            if (monTexte.charAt(i) == ' ')  { 
                  rang += 1;
            }
         }
         else{
            rang = rang;
         }
         if ( presence(monTexte , maChaine , i) ) {
              occ.add(rang);
         }
      }
      for (i = 0; i < occ.size(); i++) {
         occ.get(i);
         compteur += 1;
      }
      return compteur;
   }
}