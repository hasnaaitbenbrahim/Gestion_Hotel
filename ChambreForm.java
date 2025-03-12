package Forms;
import Connexion.Connexion;
import Entities.Categorie;
import Entities.Chambre;
import Service.CategorieService;
import Service.ChambreService;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hasna
 */
public class ChambreForm extends javax.swing.JInternalFrame {
      private ChambreService cb;
      private DefaultTableModel model;
      private CategorieService Cts;
      private static int id;   
    /**
     * Creates new form ChambreForm
     */
     public ChambreForm() {
        initComponents();
        this.setTitle("Gestion des Chambres");
        Cts=new CategorieService();
        cb=new ChambreService();
        model = (DefaultTableModel) ListeChambres.getModel();
        loadCategories();
        load();
    }
     private void load(){
         model.setRowCount(0);
         for (Chambre C: cb.findAll()){
         model.addRow(new Object[]{
             C.getId(),
             C.getTelephone(),
             C.getCat(),
             
         });
         }
     }

     private void loadCategories(){
       for(Categorie c:Cts.findAll()) {
           listecategories.addItem(c);
       }
    }
    
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeChambres = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Telephone = new javax.swing.JTextField();
        supprimer = new javax.swing.JButton();
        addChambre = new javax.swing.JButton();
        listecategories = new javax.swing.JComboBox();
        modifier = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton1.setText("Modifier");
        jButton1.setPreferredSize(new java.awt.Dimension(90, 31));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(725, 831));

        jLabel1.setFont(new java.awt.Font("Khmer MN", 1, 48)); // NOI18N
        jLabel1.setText("Gestion Chambres");

        ListeChambres.setBackground(new java.awt.Color(204, 204, 255));
        ListeChambres.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ListeChambres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Telephone", "Categorie"
            }
        ));
        ListeChambres.setPreferredSize(new java.awt.Dimension(300, 80));
        ListeChambres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListeChambresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListeChambres);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel4.setText("Liste Chambres");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel5.setText("Telephone");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel6.setText("Categorie");

        supprimer.setBackground(new java.awt.Color(255, 102, 102));
        supprimer.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        supprimer.setText("Supprimer");
        supprimer.setMaximumSize(new java.awt.Dimension(108, 31));
        supprimer.setPreferredSize(new java.awt.Dimension(108, 31));
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        addChambre.setBackground(new java.awt.Color(0, 153, 51));
        addChambre.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        addChambre.setText("Enregistrer");
        addChambre.setPreferredSize(new java.awt.Dimension(114, 31));
        addChambre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addChambreActionPerformed(evt);
            }
        });

        listecategories.setMinimumSize(new java.awt.Dimension(64, 23));
        listecategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listecategoriesActionPerformed(evt);
            }
        });

        modifier.setBackground(new java.awt.Color(255, 153, 51));
        modifier.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        modifier.setText("Modifier");
        modifier.setPreferredSize(new java.awt.Dimension(108, 31));
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(addChambre, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(listecategories, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(Telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(listecategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addChambre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/room.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(148, 148, 148))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addChambreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addChambreActionPerformed
        String Tel=Telephone.getText();
        Categorie cat=(Categorie) listecategories.getSelectedItem();
        
        Chambre chambre = new Chambre(Tel, cat);
        boolean result = cb.create(chambre);
        if (result) {
                JOptionPane.showMessageDialog(this, "Chambre ajoutée avec succès !");
                load(); // Actualisation de l'interface
            } else {
                JOptionPane.showMessageDialog(this, "Cette chambre est déjà existe !");
            }
       load();
    }//GEN-LAST:event_addChambreActionPerformed

    private void listecategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listecategoriesActionPerformed
    
 
    }//GEN-LAST:event_listecategoriesActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        int selectedRow = ListeChambres.getSelectedRow();
       if (selectedRow != -1) {
        int id = (int) model.getValueAt(selectedRow, 0);
        Chambre ch = cb.findById(id);
        if (cb.delete(ch)) {
            JOptionPane.showMessageDialog(this, "Chambre supprimé avec succès.");
        } else {
            JOptionPane.showMessageDialog(this, "Erreur lors de la suppression du Chambre.");
        }
    }

   load();

    }//GEN-LAST:event_supprimerActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
                    int selectedRow = ListeChambres.getSelectedRow();
        if (selectedRow != -1) {
        // Récupérer l'ID du Chambre à partir de la ligne sélectionnée
        int ChambreId = (int) model.getValueAt(selectedRow, 0);  // Supposons que l'ID est dans la première colonne
        
        // Rechercher le Chambre dans la base de données (ou le service)
        Chambre ch = cb.findById(ChambreId);
        
        if (ch != null) {
            // Mettre à jour les informations du Chambre à partir des champs de texte
            ch.setTelephone(Telephone.getText());
            ch.setCat((Categorie) listecategories.getSelectedItem());
           
            
            // Effectuer l'opération de mise à jour dans la base de données via le service
            boolean isUpdated = cb.update(ch);
            
            if (isUpdated) {
                JOptionPane.showMessageDialog(this, "Chambre mis à jour avec succès");
                load();  // Recharger la liste des Chambre pour afficher les modifications
            } else {
                JOptionPane.showMessageDialog(this, "Erreur lors de la mise à jour du Chambre", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chambre introuvable", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Veuillez sélectionner une Chambre à mettre à jour", "Erreur", JOptionPane.ERROR_MESSAGE);
    }
        load();


    }//GEN-LAST:event_modifierActionPerformed

    private void ListeChambresMouseClicked(java.awt.event.MouseEvent evt) {
        int row = ListeChambres.getSelectedRow();
        if (row >= 0) {
            try {
                // Récupérer l'ID et le téléphone
                id = Integer.parseInt(ListeChambres.getValueAt(row, 0).toString());
                Telephone.setText(ListeChambres.getValueAt(row, 1).toString());
                
                // Récupérer la catégorie depuis la base de données
                Connection conn = Connexion.getCnx();
                String query = "SELECT c.id, c.code, c.libelle " +
                             "FROM categorie c " +
                             "JOIN chambre ch ON ch.categorie_id = c.id " +
                             "WHERE ch.id = ?";
                
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                
                if (rs.next()) {
                    int catId = rs.getInt("id");
                    String catCode = rs.getString("code");
                    String catLibelle = rs.getString("libelle");
                    
                    // Créer un objet Categorie avec toutes les informations
                    Categorie cat = new Categorie(catId, catCode, catLibelle);
                    
                    // Sélectionner la catégorie dans le ComboBox
                    for (int i = 0; i < listecategories.getItemCount(); i++) {
                        Categorie comboCategorie = (Categorie) listecategories.getItemAt(i);
                        if (comboCategorie.getId() == catId) {
                            listecategories.setSelectedIndex(i);
                            break;
                        }
                    }
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, 
                    "Erreur lors de la récupération de la catégorie: " + ex.getMessage());
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListeChambres;
    private javax.swing.JTextField Telephone;
    private javax.swing.JButton addChambre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox listecategories;
    private javax.swing.JButton modifier;
    private javax.swing.JButton supprimer;
    // End of variables declaration//GEN-END:variables
}
