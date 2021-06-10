package GUI;

import BUS.ThanhToan_BUS;
import DTO.BenhNhan_DTO;
import DTO.KhamBenh_DTO;
import DTO.ThuPhi_DTO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ThanhToan_GUI extends javax.swing.JFrame 
{
    ThanhToan_BUS busThanhToan = new ThanhToan_BUS();
    
    public ThanhToan_GUI() 
    {
        initComponents();
        setTitle("Thanh toán khám bệnh");
        setLocationRelativeTo(null);
        setSize(720, 400);
        
        Date date = new Date();
        datNgKham.setDate(date);
        
        txtTenBN.setEditable(false);
        txtKetLuan.setEditable(false);
        txtYeuCauKham.setEditable(false);
        txtTongTien.setEditable(false);
        tblDV.setEnabled(false);
        btnThanhToan.setEnabled(false);
        loadTableDV();
        
        setVisible(true);
    }
    
    DefaultTableModel tblModelDV;
    public void loadTableDV()
    {
        tblModelDV = new DefaultTableModel();
        String title[] = {"Mã DV", "Tên DV", "Số lượng", "Thành tiền"};
        tblModelDV.setColumnIdentifiers(title);
        tblDV.setModel(tblModelDV);
        setVisible(true);
    }
    
    KhamBenh_DTO dtoKhamBenh = null;
    public void loadData()
    {
        if(txtMaBN.getText().equals("") || datNgKham.getDate().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã bệnh nhân!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            loadTableDV();
            txtYeuCauKham.setText("");
            txtKetLuan.setText("");
            txtTongTien.setText("0");
            ckbThanhToan.setEnabled(true);
            ckbThanhToan.setSelected(false);
            btnThanhToan.setEnabled(false);
            
            dtoKhamBenh = busThanhToan.getMedicalExaminationInfo(txtMaBN.getText(), datNgKham.getDate());
            if(dtoKhamBenh == null)
            {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                JOptionPane.showMessageDialog(null, "Bệnh nhân này không có thông tin khám vào ngày " + df.format(datNgKham.getDate()).toString(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                txtYeuCauKham.setText(dtoKhamBenh.getRequest());
                txtKetLuan.setText(dtoKhamBenh.getConclusion());
                int payment = dtoKhamBenh.getPayment();
                if(payment == 1)
                {
                    ckbThanhToan.setEnabled(false);
                    btnThanhToan.setEnabled(false);
                }
                else
                    btnThanhToan.setEnabled(true);

                int TongTien = 0;
                ArrayList<ThuPhi_DTO> thuPhiList = busThanhToan.getFeeList(dtoKhamBenh);
                TreeMap<String, String> serviceName = busThanhToan.getServiceName();
                for(ThuPhi_DTO tp : thuPhiList)
                {
                    String[] row = new String[4];
                    row[0] = tp.getServiceId();
                    row[1] = serviceName.get(tp.getServiceId());
                    row[2] = String.valueOf(tp.getNumber());
                    row[3] = String.valueOf(tp.getAmount());
                    tblModelDV.addRow(row);
                    TongTien += tp.getAmount();
                }
                txtTongTien.setText(String.valueOf(TongTien));
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMaBN = new javax.swing.JLabel();
        txtMaBN = new javax.swing.JTextField();
        lblTenBN = new javax.swing.JLabel();
        txtTenBN = new javax.swing.JTextField();
        txtKetLuan = new javax.swing.JTextField();
        lblKetLuan = new javax.swing.JLabel();
        lblYeuCauKham = new javax.swing.JLabel();
        txtYeuCauKham = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        lblTongTien = new javax.swing.JLabel();
        datNgKham = new com.toedter.calendar.JDateChooser();
        lblNgKham = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDV = new javax.swing.JTable();
        lblTenBS5 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        ckbThanhToan = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMaBN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaBN.setText("Mã bệnh nhân");

        txtMaBN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaBNActionPerformed(evt);
            }
        });

        lblTenBN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenBN.setText("Tên bệnh nhân");

        txtTenBN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtKetLuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblKetLuan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKetLuan.setText("Kết luận");

        lblYeuCauKham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblYeuCauKham.setText("Yêu cầu khám");

        txtYeuCauKham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTongTien.setText("Tổng tiền");

        datNgKham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        datNgKham.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datNgKhamPropertyChange(evt);
            }
        });

        lblNgKham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNgKham.setText("Ngày khám");

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
        jScrollPane1.setViewportView(tblDV);

        lblTenBS5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenBS5.setText("Danh sách dịch vụ đã chọn");

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        ckbThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ckbThanhToan.setText("Đã thanh toán");
        ckbThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMaBN, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaBN))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblKetLuan, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKetLuan))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTenBN, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenBN, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblYeuCauKham, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(ckbThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtYeuCauKham, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNgKham, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datNgKham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenBS5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan)
                .addGap(284, 284, 284))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaBN)
                            .addComponent(txtMaBN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNgKham)
                            .addComponent(datNgKham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTenBN)
                                .addComponent(txtTenBN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblKetLuan)
                                .addComponent(txtKetLuan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblYeuCauKham)
                            .addComponent(txtYeuCauKham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTongTien)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenBS5)
                    .addComponent(ckbThanhToan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThanhToan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datNgKhamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datNgKhamPropertyChange
        if(txtMaBN.getText().equals("") == false)
        {
            try{
                BenhNhan_DTO dtoBenhNhan = busThanhToan.getPatientInfo(txtMaBN.getText());
                if(dtoBenhNhan == null)
                {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh nhân!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    txtTenBN.setText("");
                    txtMaBN.setText("");
                    loadTableDV();
                    txtYeuCauKham.setText("");
                    txtKetLuan.setText("");
                    txtTongTien.setText("0");
                }
                else{
                    txtTenBN.setText(dtoBenhNhan.getName());
                    loadData();
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_datNgKhamPropertyChange

    private void ckbThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbThanhToanActionPerformed

    private void txtMaBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaBNActionPerformed
        try{
            BenhNhan_DTO dtoBenhNhan = busThanhToan.getPatientInfo(txtMaBN.getText());
            if(dtoBenhNhan == null)
            {
                JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh nhân!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                txtTenBN.setText("");
                txtMaBN.setText("");
                loadTableDV();
                txtYeuCauKham.setText("");
                txtKetLuan.setText("");
                txtTongTien.setText("0");
            }
            else{
                txtTenBN.setText(dtoBenhNhan.getName());
                loadData();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
    }//GEN-LAST:event_txtMaBNActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        try{
            int result = busThanhToan.update(dtoKhamBenh);
            if(result != 0)
            {
                JOptionPane.showMessageDialog(null, "Cập nhật dữ liệu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadData();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cập nhật dữ liệu không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
                
    }//GEN-LAST:event_btnThanhToanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JCheckBox ckbThanhToan;
    private com.toedter.calendar.JDateChooser datNgKham;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKetLuan;
    private javax.swing.JLabel lblMaBN;
    private javax.swing.JLabel lblNgKham;
    private javax.swing.JLabel lblTenBN;
    private javax.swing.JLabel lblTenBS5;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblYeuCauKham;
    private javax.swing.JTable tblDV;
    private javax.swing.JTextField txtKetLuan;
    private javax.swing.JTextField txtMaBN;
    private javax.swing.JTextField txtTenBN;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtYeuCauKham;
    // End of variables declaration//GEN-END:variables
}
