/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Forms;
import Service.ChambreService;
import Service.CategorieService;
import Entities.Chambre;
import Entities.Categorie;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author hasna
 */
public class ChambreByCategorie extends javax.swing.JInternalFrame {
    private CategorieService categorieService;
    private ChambreService chambreService;
    /**
     * Creates new form ChambreByCategorie
     */
    public ChambreByCategorie() {
        initComponents();
        categorieService = new CategorieService(); // Initialize the service
        chambreService = new ChambreService(); // Initialize the ChambreService
        loadCategories();
    }
    private void loadCategories(){
       for(Categorie c:categorieService.findAll()) {
           categorie.addItem(c);
       }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        categorie = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        findchambre = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chambresTable = new javax.swing.JTable();

        jLabel3.setText("jLabel3");

        setBackground(new java.awt.Color(204, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("Trouvé Chambre par Categorie");

        categorie.setBackground(new java.awt.Color(204, 204, 255));
        categorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorieActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setText("Les catégories disponibles");

        findchambre.setBackground(new java.awt.Color(153, 153, 255));
        findchambre.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        findchambre.setForeground(new java.awt.Color(255, 255, 255));
        findchambre.setText("Find Chambre");
        findchambre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findchambreActionPerformed(evt);
            }
        });

        chambresTable.setBackground(new java.awt.Color(204, 204, 255));
        chambresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Telephone", "Categorie"
            }
        ));
        chambresTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chambresTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(chambresTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(65, 65, 65)
                                .addComponent(categorie, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(findchambre))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categorie, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addComponent(findchambre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorieActionPerformed
            
    }//GEN-LAST:event_categorieActionPerformed

    private void findchambreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findchambreActionPerformed
        Categorie selectedCategorie = (Categorie) categorie.getSelectedItem();
        List<Chambre> chambres = chambreService.findChambreByCategorie(selectedCategorie);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Téléphone");
        model.addColumn("Catégorie");

        // Add rooms to the table model
        for (Chambre chambre : chambres) {
            model.addRow(new Object[] {
                chambre.getId(),
                chambre.getTelephone(),
                chambre.getCat().getLibelle()
            });
        }
        chambresTable.setModel(model);
        
    }//GEN-LAST:event_findchambreActionPerformed

    
    private void chambresTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chambresTableMouseClicked
        
    }//GEN-LAST:event_chambresTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox categorie;
    private javax.swing.JTable chambresTable;
    private javax.swing.JButton findchambre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
