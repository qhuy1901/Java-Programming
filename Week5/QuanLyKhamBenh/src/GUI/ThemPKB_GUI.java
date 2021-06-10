package GUI;

import BUS.ThemPKN_BUS;
import DTO.BacSi_DTO;
import DTO.BenhNhan_DTO;
import DTO.KhamBenh_DTO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ThemPKB_GUI extends javax.swing.JFrame 
{
    ThemPKN_BUS busThemPKN = new ThemPKN_BUS();
    
    public ThemPKB_GUI() 
    {
        initComponents();
        setTitle("Đặt lịch khám");
        setLocationRelativeTo(null);
        setSize(400, 340);
        Date date = new Date();
        datNgKham.setDate(date);
        txtTenBN.setEditable(false);
        loadCbbTenBS();
        setVisible(true);
    }

    public void loadCbbTenBS()
    {
        cbbTenBS.removeAllItems();
        ArrayList<BacSi_DTO> doctorList = busThemPKN.getDoctorList();
        for(BacSi_DTO doctor : doctorList)
        {
            cbbTenBS.addItem(doctor.getName());
        }
    }
    
    public String createAutomaticId()
    {
        return busThemPKN.createAutomaticId();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMaBN = new javax.swing.JLabel();
        txtMaBN = new javax.swing.JTextField();
        lblMaBN1 = new javax.swing.JLabel();
        txtTenBN = new javax.swing.JTextField();
        lblMaBN2 = new javax.swing.JLabel();
        datNgKham = new com.toedter.calendar.JDateChooser();
        lblMaBN3 = new javax.swing.JLabel();
        txtYeuCauKham = new javax.swing.JTextField();
        lblMaBN4 = new javax.swing.JLabel();
        cbbTenBS = new javax.swing.JComboBox<>();
        btnDatLichKham = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMaBN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaBN.setText("Mã bệnh nhân");

        txtMaBN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaBNActionPerformed(evt);
            }
        });

        lblMaBN1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaBN1.setText("Ngày khám");

        txtTenBN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblMaBN2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaBN2.setText("Tên bệnh nhân");

        datNgKham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblMaBN3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaBN3.setText("Yêu cầu khám");

        txtYeuCauKham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblMaBN4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaBN4.setText("Bác sĩ khám");

        cbbTenBS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbTenBS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDatLichKham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDatLichKham.setText("Đặt lịch khám");
        btnDatLichKham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatLichKhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaBN, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaBN2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaBN1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMaBN4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaBN3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDatLichKham, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtYeuCauKham)
                            .addComponent(txtMaBN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(txtTenBN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datNgKham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbTenBS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaBN)
                    .addComponent(txtMaBN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenBN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaBN2))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaBN1)
                    .addComponent(datNgKham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtYeuCauKham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaBN3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaBN4)
                    .addComponent(cbbTenBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnDatLichKham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatLichKhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatLichKhamActionPerformed
        if(txtMaBN.getText().equals("") || txtYeuCauKham.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        else
        {
            Date nowDate = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            if(df.format(nowDate).compareTo(df.format(datNgKham.getDate()))> 0)
            {
                JOptionPane.showMessageDialog(this, "Ngày khám phải > = Ngày hiện tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                
            }
            else
            {
                String doctorId = busThemPKN.getDoctorInfo(cbbTenBS.getSelectedItem().toString()).getId();
                KhamBenh_DTO dtoBenhNhan = new KhamBenh_DTO(createAutomaticId(), txtMaBN.getText(), doctorId , datNgKham.getDate(), txtYeuCauKham.getText(), "", 0);
     
                try{
                   int result = busThemPKN.insert(dtoBenhNhan);
                   if(result != 0)
                   {
                        JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                   }
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Thêm dữ liệu không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnDatLichKhamActionPerformed

    private void txtMaBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaBNActionPerformed
        BenhNhan_DTO dtoBenhNhan = busThemPKN.getPatientInfo(txtMaBN.getText());
        
        if(dtoBenhNhan == null)
        {
            JOptionPane.showMessageDialog(this, "Không tìm thấy bệnh nhân!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            txtTenBN.setText("");
            txtMaBN.setText("");
        }
        else
            txtTenBN.setText(dtoBenhNhan.getName());
    }//GEN-LAST:event_txtMaBNActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatLichKham;
    private javax.swing.JComboBox<String> cbbTenBS;
    private com.toedter.calendar.JDateChooser datNgKham;
    private javax.swing.JLabel lblMaBN;
    private javax.swing.JLabel lblMaBN1;
    private javax.swing.JLabel lblMaBN2;
    private javax.swing.JLabel lblMaBN3;
    private javax.swing.JLabel lblMaBN4;
    private javax.swing.JTextField txtMaBN;
    private javax.swing.JTextField txtTenBN;
    private javax.swing.JTextField txtYeuCauKham;
    // End of variables declaration//GEN-END:variables
}
