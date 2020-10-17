package projet;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class interface_graph extends JFrame{
            //creation de la fenetre
      public interface_graph(){
         setSize(new Dimension(500,500));
         JPanel jpannel = new JPanel(); 
          //création d'un label
         JLabel jlabel1 = new JLabel("Votre texte ");
         jpannel.add(jlabel1);
         
          //création d'un textarea
         JTextArea jTextArea = new JTextArea();
         JScrollPane jscrollpane = new JScrollPane(jTextArea);
         jscrollpane.setPreferredSize(new Dimension(400,70));  
         jpannel.add(jscrollpane);
         
         //deuxieme label
         JLabel jlabel2 = new JLabel("La sous-chaine à rechercher");
         jpannel.add(jlabel2);
      
         //création d'un textfield
         JTextField  jTextField = new JTextField ("");
         jTextField.setPreferredSize(new Dimension(200, 70));
         jpannel.add(jTextField);
      
         //création d'un bouton
         JButton jbutton = new JButton("Rechercher");
         jpannel.add(jbutton);
      
         //liste des resultats
         JLabel jlabel3 = new JLabel("Résultat:");
         jpannel.add(jlabel3);
         JLabel jlabel4 = new JLabel();
         jpannel.add(jlabel4);
         JLabel jlabel5 = new JLabel();
         jpannel.add(jlabel5);
         JLabel jlabel6 = new JLabel();
         jpannel.add(jlabel6);
         getContentPane().add(jpannel);
     
         setVisible(true);
         
        
         jbutton.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e) {
                  DefaultListModel<Integer> dataModel = new DefaultListModel<>();
                  JList<Integer> maliste = new JList<>(dataModel);

                  String texte = jTextArea.getText();
                  String chaine = jTextField.getText();
                  int cp,i;
                  
                  if (texte.equals("") || chaine.equals("")) JOptionPane.showMessageDialog(null, "Ne laisse pas la zone de texte vide"); 
                  else{
                     manipulation algo = new manipulation(texte,chaine);
                     cp = algo.cherche(texte,chaine);
                     jlabel4.setText("Nombre de repebtition : " + cp);
                     jlabel5.setText("Longueur du texte : " + texte.length());
                     jlabel6.setText("Present dans les rangs(des mots) suivants:" );
                     for(i = 0 ; i < algo.occ.size();i++){
                         dataModel.addElement(algo.occ.get(i));
                     };
                     jpannel.add(maliste);
                  }  
        
               }
          });
      }

}