package btvn_sach;

import btvn_sach.DSSach;
import btvn_sach.Sach;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FormThongTinSach extends javax.swing.JFrame {

    DSSach ds = new DSSach();
    
    public FormThongTinSach() {
        initComponents();
        setSize(900, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        
        Sach s1 = new Sach(1, "Giải tích", "NVA", "NXB ĐHQG", 20000);
        Sach s2 = new Sach(2, "Đại số tuyến tính", "NVA", "NXB ĐHQG", 50000);
        Sach s3 = new Sach(3, "Xác xuất thống kê", "NVA", "NXB ĐHQG", 40000);
        
        ds.ThemSach(s1);
        ds.ThemSach(s2);
        ds.ThemSach(s3);
        
        TaoTable(ds);
        tblSachSelectRow();
    }
    
    DefaultTableModel tblModelTT;
    public void TaoTable(DSSach ds)
    {
        tblModelTT = new DefaultTableModel();
        String tieuDe[] = {"Mã sách", "Tên sách", "Tác giả", "Nhà xuất bản", "Giá"};
        tblModelTT.setColumnIdentifiers(tieuDe);
        tblModelTT.setRowCount(0); // vì ban đầu ko có gì cả set = 0
        for(int i = 0; i < ds.SLSach(); i++)
        {
            Sach s = ds.LayThongTin(i);
            String[] rows = {String.valueOf(s.getMaSach()), s.getTenSach(), s.getTacGia(),  s.getNhaXuatBan(), String.valueOf(s.getGia())};
            tblModelTT.addRow(rows);
        }
        tblThongTinSach.setModel(tblModelTT);
        setVisible(true);
    }
    
    public void tblSachSelectRow()
    {
        tblThongTinSach.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if(!lse.getValueIsAdjusting())
                {
                    int row = tblThongTinSach.getSelectedRow();
                    if(row >= 0)
                    {
                        txtMaSach.setText(tblThongTinSach.getModel().getValueAt(row, 0).toString());
                        txtTenSach.setText(tblThongTinSach.getModel().getValueAt(row, 1).toString());
                        txtTacGia.setText(tblThongTinSach.getModel().getValueAt(row, 2).toString());
                        txtNhaXuatBan.setText(tblThongTinSach.getModel().getValueAt(row, 3).toString());
                        txtGia.setText(tblThongTinSach.getModel().getValueAt(row, 4).toString());
                    }
                }
            }
        });
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lbTenSach = new javax.swing.JLabel();
        lblThongTinSach = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        lblMaSach = new javax.swing.JLabel();
        lblTacGia = new javax.swing.JLabel();
        lblNhaXuatBan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongTinSach = new javax.swing.JTable();
        txtGia = new javax.swing.JTextField();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtTacGia = new javax.swing.JTextField();
        txtNhaXuatBan = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTenSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTenSach.setText("Tên sách");

        lblThongTinSach.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblThongTinSach.setText("Thông tin sách");

        lblGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGia.setText("Giá");

        lblMaSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaSach.setText("Mã sách");

        lblTacGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTacGia.setText("Tác giả");

        lblNhaXuatBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNhaXuatBan.setText("Nhà xuất bản");

        tblThongTinSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblThongTinSach);

        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });

        txtMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSachActionPerformed(evt);
            }
        });

        txtTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSachActionPerformed(evt);
            }
        });

        txtTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTacGiaActionPerformed(evt);
            }
        });

        txtNhaXuatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhaXuatBanActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnTim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(lblThongTinSach, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(71, 71, 71)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblThongTinSach, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaActionPerformed

    private void txtMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSachActionPerformed

    private void txtTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSachActionPerformed

    private void txtTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTacGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTacGiaActionPerformed

    private void txtNhaXuatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhaXuatBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhaXuatBanActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if(ds.TimSach(Integer.parseInt(txtMaSach.getText())) != -1 || txtMaSach.getText().equals(""))
        {
            int ret = JOptionPane.showConfirmDialog(null, "Bạn có chắn chắn muốn xóa hay không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if(ret == JOptionPane.YES_OPTION)
            {
                int index = tblThongTinSach.getSelectedRow();
                if(index == -1)
                {
                    index = ds.LayViTriSach(ds.TimSachTheoMaSach(Integer.parseInt(txtMaSach.getText())));
                }
                ds.XoaSach(Integer.parseInt(txtMaSach.getText()));
                tblModelTT.removeRow(index);
                JOptionPane.showConfirmDialog(null, "Xóa thông tin sách thành công", "Thành công", JOptionPane.CLOSED_OPTION);
                btnClearActionPerformed(evt);
            }
        }
        else
            JOptionPane.showConfirmDialog(null, "Không tìm thấy sách cần xóa", "Lỗi", JOptionPane.CLOSED_OPTION);     
    }//GEN-LAST:event_btnXoaActionPerformed
    
    public static boolean isNumberic(String str)
    {
        try
        {
            Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
                
    }
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(txtMaSach.getText().equals("") || txtTenSach.getText().equals("") || txtTacGia.getText().equals("") || txtNhaXuatBan.getText().equals("") || txtGia.getText().equals(""))
        {   
            JOptionPane.showConfirmDialog(null, "Vui lòng nhập đầy đủ thông tin", "OK", JOptionPane.CLOSED_OPTION);
        }
        else
        {
            //Cách khác: chỉ cho người dùng nhập số thôi ko đc chữ, mã sách tự sin hra 
            if(isNumberic(txtGia.getText()) == false || isNumberic(txtMaSach.getText()) == false)
            {
                JOptionPane.showConfirmDialog(null, "Vui lòng nhập mã sách, giá là số nguyên", "OK", JOptionPane.CLOSED_OPTION);
            }
            else
            {
                Sach s = new Sach();
                s.setMaSach(Integer.parseInt(txtMaSach.getText()));
                s.setTenSach(txtTenSach.getText());
                s.setNhaXuatBan(txtNhaXuatBan.getText());
                s.setTacGia(txtTacGia.getText());
                s.setGia(Integer.parseInt(txtGia.getText()));

                ds.ThemSach(s);
                TaoTable(ds);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if(txtMaSach.getText().equals("") || txtTenSach.getText().equals("") || txtTacGia.getText().equals("") || txtNhaXuatBan.getText().equals("") || txtGia.getText().equals(""))
        {   
            JOptionPane.showConfirmDialog(null, "Vui lòng chọn sách trước khi sửa thông tin", "OK", JOptionPane.CLOSED_OPTION);
        }
        else
        {
                int index = tblThongTinSach.getSelectedRow();
                if(index == -1)
                {
                    index = ds.LayViTriSach(ds.TimSachTheoMaSach(Integer.parseInt(txtMaSach.getText())));
                }
                Sach S = ds.LayThongTin(index);
                if(S.getMaSach() == Integer.parseInt(txtMaSach.getText()))
                {
                    int ret = JOptionPane.showConfirmDialog(null, "Bạn có chắn chắn muốn sửa hay không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if(ret == JOptionPane.YES_OPTION)
                    {
                        S.setTenSach(txtTenSach.getText());
                        S.setNhaXuatBan(txtNhaXuatBan.getText());
                        S.setTacGia(txtTacGia.getText());
                        S.setGia(Integer.parseInt(txtGia.getText()));
                        TaoTable(ds);
                        JOptionPane.showConfirmDialog(null, "Sửa thông tin sách thành công", "Thành công", JOptionPane.CLOSED_OPTION);
                        btnClearActionPerformed(evt);
                    }
                }
                else
                    JOptionPane.showConfirmDialog(null, "Không được thay đổi mã sách", "Sửa thông tin sách thất bại", JOptionPane.CLOSED_OPTION);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        if(!txtMaSach.getText().equals(""))
        {
            if(ds.TimSach(Integer.parseInt(txtMaSach.getText())) != -1)
            {
                Sach s = ds.TimSachTheoMaSach(Integer.parseInt(txtMaSach.getText()));
                txtMaSach.setText(String.valueOf(s.getMaSach()));
                txtTenSach.setText(s.getTenSach());
                txtTacGia.setText(s.getTacGia());
                txtNhaXuatBan.setText(s.getNhaXuatBan());
                txtGia.setText(String.valueOf(s.getGia()));
            }
            else 
                JOptionPane.showConfirmDialog(null , "Không tìm được sách", "Lỗi", JOptionPane.CLOSED_OPTION);
        }
        else
            JOptionPane.showConfirmDialog(null, "Vui lòng nhập mã sách", "Lỗi", JOptionPane.CLOSED_OPTION);
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtMaSach.setText("");
        txtTenSach.setText("");
        txtTacGia.setText("");
        txtNhaXuatBan.setText("");
        txtGia.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int ret = JOptionPane.showConfirmDialog(null , "Bạn có muốn thoát", "Thoát", JOptionPane.YES_NO_OPTION);
        if(ret == JOptionPane.YES_OPTION)
            System.exit(0);
                
    }//GEN-LAST:event_btnThoatActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTenSach;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblMaSach;
    private javax.swing.JLabel lblNhaXuatBan;
    private javax.swing.JLabel lblTacGia;
    private javax.swing.JLabel lblThongTinSach;
    private javax.swing.JTable tblThongTinSach;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNhaXuatBan;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}
