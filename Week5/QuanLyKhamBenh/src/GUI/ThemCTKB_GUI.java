package GUI;

import BUS.ThemCTKB_BUS;
import DTO.BacSi_DTO;
import DTO.BenhNhan_DTO;
import DTO.DichVu_DTO;
import DTO.KhamBenh_DTO;
import DTO.ThuPhi_DTO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ThemCTKB_GUI extends javax.swing.JFrame 
{
    ThemCTKB_BUS busThemCTKB = new ThemCTKB_BUS();
    ArrayList<BenhNhan_DTO> patientList = null;
    ArrayList<BacSi_DTO> doctorList = null;
    KhamBenh_DTO dtoKhamBenh = null;
    ArrayList<DichVu_DTO> serviceList = null;
    ArrayList<DichVu_DTO> DSDVBSChon = new ArrayList<DichVu_DTO>(); 
    
    public ThemCTKB_GUI() 
    {
        initComponents();
        setSize(660, 450);
        setLocationRelativeTo(null);
        Date date = new Date();
        datNgKham.setDate(date);
        txtYeuCauKham.setEditable(false);
        setTitle("Khám bệnh");
        createServiceTable();
        loadtblDVBSChon();
        txtYeuCauKham.setEditable(false);
        loadCbbTenBS();
        loadCbbTenBN();
        setVisible(true);
    }

    public void loadCbbTenBS()
    {
        cbbTenBS.removeAllItems();
        doctorList = busThemCTKB.getDoctorList();
        for(BacSi_DTO doctor : doctorList)
        {
            cbbTenBS.addItem(doctor.getName());
        }
    }
    
    DefaultTableModel tblModelService = null;
    public void createServiceTable()
    {
        tblModelService = new DefaultTableModel();
        String tilte[] = {"Tên dịch vụ"};
        tblModelService.setColumnIdentifiers(tilte);
        
        serviceList = busThemCTKB.getServiceList();
        
        for(DichVu_DTO service : serviceList)
        {
            Object[] row = {service.getName()};
            tblModelService.addRow(row);
        }
        
        tblDV.setModel(tblModelService);
        setVisible(true);
    }

    DefaultTableModel tblModelDVBSChon = null;
    public void loadtblDVBSChon()
    {
        tblModelDVBSChon = new DefaultTableModel();
        String tilte[] = {"Tên dịch vụ", "Số lượng"};
        tblModelDVBSChon.setColumnIdentifiers(tilte);
        tblDVBSChon.setModel(tblModelDVBSChon);
        setVisible(true);
    }
    
    public void loadCbbTenBN()
    {
        cbbTenBN.removeAllItems();
        
        String doctorId = doctorList.get(cbbTenBS.getSelectedIndex()).getId(); 
        patientList = busThemCTKB.getPatientList(doctorId, datNgKham.getDate());
        for(BenhNhan_DTO patient : patientList)
        {
            cbbTenBN.addItem(patient.getName());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTenBS = new javax.swing.JLabel();
        txtKetLuan = new javax.swing.JTextField();
        cbbTenBS = new javax.swing.JComboBox<>();
        lblTenBN = new javax.swing.JLabel();
        cbbTenBN = new javax.swing.JComboBox<>();
        lblKetLuan = new javax.swing.JLabel();
        lblYeuCauKham = new javax.swing.JLabel();
        txtYeuCauKham = new javax.swing.JTextField();
        datNgKham = new com.toedter.calendar.JDateChooser();
        lblNgKham = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDVBSChon = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDV = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        lblDV = new javax.swing.JLabel();
        lblDVBSChon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTenBS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenBS.setText("Bác sĩ khám");

        txtKetLuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbTenBS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbTenBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTenBSActionPerformed(evt);
            }
        });

        lblTenBN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenBN.setText("Tên bệnh nhân");

        cbbTenBN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbTenBN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTenBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTenBNActionPerformed(evt);
            }
        });

        lblKetLuan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKetLuan.setText("Kết luận");

        lblYeuCauKham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblYeuCauKham.setText("Yêu cầu khám");

        txtYeuCauKham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        datNgKham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        datNgKham.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datNgKhamPropertyChange(evt);
            }
        });

        lblNgKham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNgKham.setText("Ngày khám");

        tblDVBSChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDVBSChon);

        tblDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDV);

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        lblDV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDV.setText("Danh sách dịch vụ");

        lblDVBSChon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDVBSChon.setText("Danh sách dịch vụ bác sĩ chọn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblKetLuan, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                        .addComponent(lblTenBN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(cbbTenBS, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lblNgKham, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(cbbTenBN, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(lblYeuCauKham, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(datNgKham, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                                .addComponent(txtYeuCauKham)))
                                        .addComponent(txtKetLuan, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(lblTenBS, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDV, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDVBSChon, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbTenBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTenBS)
                        .addComponent(lblNgKham))
                    .addComponent(datNgKham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTenBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenBN)
                    .addComponent(lblYeuCauKham)
                    .addComponent(txtYeuCauKham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKetLuan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKetLuan))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDV)
                    .addComponent(lblDVBSChon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(dtoKhamBenh == null || txtKetLuan.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân, nhập kết luận", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            
        }
        else
        {
            if(tblModelDVBSChon.getRowCount() == 0)
                JOptionPane.showMessageDialog(null, "Vui lòng chọn dịch vụ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            else
            {
                for(int i = 0; i < tblModelDVBSChon.getRowCount(); i++)
                {
                    try{
                        String medicalExaminationId = dtoKhamBenh.getMedicalExaminationId();
                        String serviceId = DSDVBSChon.get(i).getId();
                        int number = Integer.parseInt(tblModelDVBSChon.getValueAt(i, 1).toString());
                        int amount = DSDVBSChon.get(i).getUnitPrice() * number;
                        ThuPhi_DTO dtoThuPhi = new ThuPhi_DTO(medicalExaminationId, serviceId , number, amount);
                        int insertResult = busThemCTKB.insert(dtoThuPhi);
                    }
                    catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
                try{
                    dtoKhamBenh.setConclusion(txtKetLuan.getText());
                    int updateResult = busThemCTKB.updateRequest(dtoKhamBenh);
                    if(updateResult != 0)
                    {
                         JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                    createServiceTable();
                    loadtblDVBSChon();
                    txtKetLuan.setText("");
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Thêm dữ liệu không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    ex.printStackTrace();
                }
                
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void cbbTenBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTenBSActionPerformed
        loadCbbTenBN();
        dtoKhamBenh = null;
    }//GEN-LAST:event_cbbTenBSActionPerformed

    private void datNgKhamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datNgKhamPropertyChange
        if(cbbTenBS.getItemCount() > 0)
            loadCbbTenBN();
    }//GEN-LAST:event_datNgKhamPropertyChange

    private void tblDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDVMouseClicked
        int indexTB = tblDV.getSelectedRow();
        if(indexTB >= 0 && indexTB <= tblModelService.getRowCount())
        {
            DSDVBSChon.add(serviceList.get(indexTB));
            
            String row[] = new String[4];
            row[0] = tblModelService.getValueAt(indexTB, 0).toString();
            row[1] = "1";
            tblModelDVBSChon.addRow(row);
            tblModelService.removeRow(indexTB);
        }
    }//GEN-LAST:event_tblDVMouseClicked
    
    private void cbbTenBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTenBNActionPerformed
        txtYeuCauKham.setText("");
        if(cbbTenBN.getSelectedIndex() >= 0)
        {
            String doctorId = doctorList.get(cbbTenBS.getSelectedIndex()).getId(); 
            String patientId = patientList.get(cbbTenBN.getSelectedIndex()).getId(); 
            dtoKhamBenh = busThemCTKB.getMedicalExaminationInfo(patientId, doctorId, datNgKham.getDate());
            txtYeuCauKham.setText(dtoKhamBenh.getRequest());
            txtKetLuan.setText(dtoKhamBenh.getConclusion());
        }
    }//GEN-LAST:event_cbbTenBNActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbbTenBN;
    private javax.swing.JComboBox<String> cbbTenBS;
    private com.toedter.calendar.JDateChooser datNgKham;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDV;
    private javax.swing.JLabel lblDVBSChon;
    private javax.swing.JLabel lblKetLuan;
    private javax.swing.JLabel lblNgKham;
    private javax.swing.JLabel lblTenBN;
    private javax.swing.JLabel lblTenBS;
    private javax.swing.JLabel lblYeuCauKham;
    private javax.swing.JTable tblDV;
    private javax.swing.JTable tblDVBSChon;
    private javax.swing.JTextField txtKetLuan;
    private javax.swing.JTextField txtYeuCauKham;
    // End of variables declaration//GEN-END:variables
}
