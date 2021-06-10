package GUI;

import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Document;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.Desktop;
import BUS.ThanhToan_BUS;
import DTO.BenhNhan_DTO;
import DTO.KhamBenh_DTO;
import DTO.ThuPhi_DTO;
import Utils.DBUtils;
import java.sql.*;
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
    BenhNhan_DTO dtoBenhNhan = null;
    KhamBenh_DTO dtoKhamBenh = null;
    
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
        btnInHoaDon = new javax.swing.JButton();

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

        btnInHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(btnThanhToan)
                .addGap(38, 38, 38)
                .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datNgKhamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datNgKhamPropertyChange
        if(txtMaBN.getText().equals("") == false)
        {
            try{
                dtoBenhNhan = busThanhToan.getPatientInfo(txtMaBN.getText());
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

    private void txtMaBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaBNActionPerformed
        try{
            dtoBenhNhan = busThanhToan.getPatientInfo(txtMaBN.getText());
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
    public String DinhDangTienTe(int SoTien)
    {
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        String str = en.format(SoTien);
        return str;
    }
    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        if(dtoKhamBenh.getMedicalExaminationId() == null)
            JOptionPane.showMessageDialog(null, "Vui lòng chọn MaBN và ngày khám!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        else
        {
            Document document = new Document(PageSize.A4);
            String filename = "HD" + dtoKhamBenh.getMedicalExaminationId();
            
            try
            {
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\NetBeans\\QuanLyKhamBenh\\src\\reports\\"+ filename + ".pdf"));
                document.open();
                File filefontTieuDe = new File("D:\\NetBeans\\QuanLyKhamBenh\\src\\fonts\\vuArialBold.ttf");
                BaseFont bfTieuDe = BaseFont.createFont(filefontTieuDe.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                Font fontTieuDe1 = new Font(bfTieuDe, 16);
                fontTieuDe1.setColor(BaseColor.BLUE);
                Font fontTieuDe2 = new Font(bfTieuDe, 13);
                fontTieuDe1.setColor(BaseColor.BLUE);
                Font fontTieuDe3 = new Font(bfTieuDe, 13);
                Font fontTieuDe4 = new Font(bfTieuDe, 12);
                    
                File filefontNoiDung = new File("D:\\NetBeans\\QuanLyKhamBenh\\src\\fonts\\vuArial.ttf");
                BaseFont bfNoiDung = BaseFont.createFont(filefontNoiDung.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                Font fontNoiDung1 = new Font(bfNoiDung, 13);
                Font fontNoiDung2 = new Font(bfNoiDung, 12);
                Font fontNoiDung3 = new Font(bfNoiDung, 11);
                
                Image logo = Image.getInstance("D:\\NetBeans\\QuanLyKhamBenh\\src\\image\\hospital.png");
                logo.setAbsolutePosition(80, 750);
                logo.scaleAbsolute(50, 50);
                document.add(logo);
                
                Paragraph prgTenPK = new Paragraph("PHÒNG KHÁM ĐA KHOA ABC", fontTieuDe2);
                prgTenPK.setIndentationLeft(100);
                document.add(prgTenPK);
                
                Paragraph prgDiaChiPK = new Paragraph("Khu phố 6, phường Bình Thọ, Tp.Thủ Đức, Tp. Hồ Chí Minh", fontNoiDung2);
                prgDiaChiPK.setIndentationLeft(100);
                document.add(prgDiaChiPK);
                
                Paragraph prgSoDTPK = new Paragraph("Số điện thoại: 208 3456 7890", fontNoiDung2);
                prgSoDTPK.setIndentationLeft(100);
                document.add(prgSoDTPK);
                
                Paragraph prgTieuDe = new Paragraph("HÓA ĐƠN DỊCH VỤ", fontTieuDe1);
                prgTieuDe.setAlignment(Element.ALIGN_CENTER);
                prgTieuDe.setSpacingBefore(10);
                prgTieuDe.setSpacingAfter(10);
                document.add(prgTieuDe);
                
                String NgKham = "";
                String TenBS = "";
                DBUtils dbu = new DBUtils();
                try{
                    Connection con = dbu.createConn();
                    String strSQL = "SELECT * "
                            + "FROM BENHNHAN BN, KHAMBENH KB, BACSI BS "
                            + "WHERE BN.MABN = KB.MABN AND KB.MABS = BS.MABS AND MAKB = ?";
                    PreparedStatement pres = con.prepareStatement(strSQL);
                    pres.setString(1, dtoKhamBenh.getMedicalExaminationId());
                    ResultSet rs = pres.executeQuery();
                    if(rs.first())
                    {
                        List listTTKH = new List(List.UNORDERED);
                        listTTKH.add(new ListItem("Họ tên bệnh nhân: " + rs.getString("TenBN").toUpperCase(), fontTieuDe3));
                        listTTKH.add(new ListItem("Mã bệnh nhân: " + rs.getString("BN.MABN"), fontNoiDung1));
                        if(rs.getBoolean("GioiTinh") == true)
                            listTTKH.add(new ListItem("Giới tính: Nam", fontNoiDung1));
                        else
                            listTTKH.add(new ListItem("Giới tính: Nữ", fontNoiDung1));
                        
                        String[] arrayNgSinh = rs.getString("NgSinh").split("-");
                        String ngay = arrayNgSinh[2];
                        String thang = arrayNgSinh[1];
                        String nam = arrayNgSinh[0];
                        listTTKH.add(new ListItem("Ngày sinh: " + ngay + "/" + thang + "/" + nam, fontNoiDung1));
                        listTTKH.add(new ListItem("Địa chỉ: " + rs.getString("DChi"), fontNoiDung1));
                        listTTKH.add(new ListItem("Điện thoại: " + rs.getString("DThoai"), fontNoiDung1));
                        listTTKH.add(new ListItem("Yêu cầu khám: " + rs.getString("YeuCauKham"), fontNoiDung1));
                        listTTKH.add(new ListItem("Kết luận: " + rs.getString("KetLuan"), fontTieuDe3));
                        document.add(listTTKH);
                        
                        NgKham = rs.getString("NgayKham");
                        TenBS = rs.getString("TenBS");
                    }  
                }
                catch(SQLException e)
                {
                    System.out.print(e);
                }
                Paragraph prgDichVu = new Paragraph("Các dịch vụ đã sử dung: ", fontTieuDe3);
                prgDichVu.setSpacingBefore(10);
                //prgDichVu.setSpacingAfter(10);
                document.add(prgDichVu);
                
                PdfPTable tableDV = new PdfPTable(6);
                tableDV.setWidthPercentage(80);
                tableDV.setSpacingBefore(10);
                tableDV.setSpacingAfter(10);
                
                float[] tableDV_columnWidths = {50, 120, 150, 100, 80, 100};
                tableDV.setWidths(tableDV_columnWidths);
                
                PdfPCell cellTDTT = new PdfPCell(new Paragraph("STT", fontTieuDe3));
                cellTDTT.setBorderColor(BaseColor.BLACK);
                cellTDTT.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTDTT.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cellTDTT.setMinimumHeight(30);
                tableDV.addCell(cellTDTT);
                
                PdfPCell cellTDMaDV = new PdfPCell(new Paragraph("Mã Dịch vụ", fontTieuDe3));
                cellTDMaDV.setBorderColor(BaseColor.BLACK);
                cellTDMaDV.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTDMaDV.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableDV.addCell(cellTDMaDV);
                
                PdfPCell cellTDTenDV = new PdfPCell(new Paragraph("Tên Dịch vụ", fontTieuDe3));
                cellTDTenDV.setBorderColor(BaseColor.BLACK);
                cellTDTenDV.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTDTenDV.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableDV.addCell(cellTDTenDV);
                
                PdfPCell cellTDDonGia = new PdfPCell(new Paragraph("Đơn giá", fontTieuDe3));
                cellTDDonGia.setBorderColor(BaseColor.BLACK);
                cellTDDonGia.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTDDonGia.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableDV.addCell(cellTDDonGia);
                
                PdfPCell cellTDSL = new PdfPCell(new Paragraph("Số lượng", fontTieuDe3));
                cellTDSL.setBorderColor(BaseColor.BLACK);
                cellTDSL.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTDSL.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableDV.addCell(cellTDSL);
                
                PdfPCell cellTDThanhTien = new PdfPCell(new Paragraph("Thành tiền", fontTieuDe3));
                cellTDThanhTien.setBorderColor(BaseColor.BLACK);
                cellTDThanhTien.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTDThanhTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableDV.addCell(cellTDThanhTien);
                
                try{
                    Connection con = dbu.createConn();
                    String strSQL = "SELECT * FROM THUPHI, DICHVU WHERE THUPHI.MADV = DICHVU.MADV AND MAKB = ?";
                    PreparedStatement pres = con.prepareStatement(strSQL);
                    pres.setString(1, dtoKhamBenh.getMedicalExaminationId());
                    
                    ResultSet rs = pres.executeQuery();
                    int TongTien = 0;
                    int TT = 1;
                    
                    while(rs.next())
                    {
                        PdfPCell cellTT = new PdfPCell(new Paragraph(String.valueOf(TT), fontNoiDung3));
                        cellTT.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellTT.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cellTT.setMinimumHeight(20);
                        tableDV.addCell(cellTT);
                        
                        PdfPCell cellMaDV = new PdfPCell(new Paragraph(rs.getString("THUPHI.MaDV"), fontNoiDung3));
                        cellMaDV.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellMaDV.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tableDV.addCell(cellMaDV);
                        
                        PdfPCell cellTenDV = new PdfPCell(new Paragraph(rs.getString("TenDV"), fontNoiDung3));
                        cellTenDV.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellTenDV.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tableDV.addCell(cellTenDV);
                        
                        int DonGia = rs.getInt("ThanhTien") / rs.getInt("SoLuong");
                        PdfPCell cellDonGia = new PdfPCell(new Paragraph(DinhDangTienTe(DonGia), fontNoiDung3));
                        cellDonGia.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellDonGia.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tableDV.addCell(cellDonGia);
                        
                        PdfPCell cellSoLuong = new PdfPCell(new Paragraph(rs.getString("SoLuong"), fontNoiDung3));
                        cellSoLuong.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellSoLuong.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tableDV.addCell(cellSoLuong);
                        
                        PdfPCell cellThanhTien = new PdfPCell(new Paragraph(DinhDangTienTe(rs.getInt("ThanhTien")), fontNoiDung3));
                        cellThanhTien.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellThanhTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tableDV.addCell(cellThanhTien);
                        
                        TongTien += rs.getInt("ThanhTien");
                        TT++;
                    }
                    PdfPCell cellTongCong = new PdfPCell(new Paragraph("TỔNG CỘNG:", fontTieuDe3));
                    cellTongCong.setColspan(5);
                    cellTongCong.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellTongCong.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cellTongCong.setMinimumHeight(20);
                    tableDV.addCell(cellTongCong);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                document.add(tableDV);
                
                PdfPTable tableTTBS = new PdfPTable(2);
                tableTTBS.setWidthPercentage(90);
                tableTTBS.setSpacingBefore(10);
                tableTTBS.setSpacingAfter(10);
                
                float[] tableTTBS_columnWidths = {300, 200};
                tableTTBS.setWidths(tableTTBS_columnWidths);
                
                PdfPCell cellGhiChu = new PdfPCell(new Paragraph("Ghi chú: ", fontNoiDung3));
                cellGhiChu.setBorder(0);
                cellGhiChu.setRowspan(3);
                cellGhiChu.setHorizontalAlignment(Element.ALIGN_LEFT);
                cellGhiChu.setVerticalAlignment(Element.ALIGN_TOP);
                tableTTBS.addCell(cellGhiChu);
                
                String[] arrayNgKham = NgKham.split("-");
                String ngay = arrayNgKham[2];
                String thang = arrayNgKham[1];
                String nam = arrayNgKham[0];
                
                Paragraph prgNgKham = new Paragraph("Ngày " + ngay + " tháng " + thang + " năm " + nam + ".", fontNoiDung1);
                PdfPCell cellNgKham = new PdfPCell(prgNgKham);
                cellNgKham.setBorder(0);
                cellNgKham.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellNgKham.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableTTBS.addCell(cellNgKham);
                
                PdfPCell cellBS = new PdfPCell(new Paragraph("Bác sĩ chẩn đoán \n \n \n \n \n \n ", fontTieuDe4));
                cellBS.setBorder(0);
                cellBS.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellBS.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableTTBS.addCell(cellBS);
                
                PdfPCell cellTenBS = new PdfPCell(new Paragraph(TenBS, fontTieuDe4));
                cellTenBS.setBorder(0);
                cellTenBS.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTenBS.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableTTBS.addCell(cellTenBS);
                
                document.add(tableTTBS);
                document.close();
                writer.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            try
            {
                File file = new File("D:\\NetBeans\\QuanLyKhamBenh\\src\\reports\\"+ filename + ".pdf");
                if(!Desktop.isDesktopSupported())
                {
                    System.out.println("Not supported");
                    return;
                }
                Desktop desktop = Desktop.getDesktop();
                if(file.exists())
                    desktop.open(file);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnInHoaDonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInHoaDon;
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
