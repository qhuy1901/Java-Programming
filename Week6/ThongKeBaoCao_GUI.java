package GUI;

import Utils.DBUtils;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Document;
import org.jfree.chart.ui.TextAnchor;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ThongKeBaoCao_GUI extends javax.swing.JFrame 
{
    public ThongKeBaoCao_GUI() 
    {
        initComponents();
        setSize(470, 280); 
        setResizable(false);
        setTitle("Thống kê báo cáo"); 
        setLocationRelativeTo(null);
        setVisible(true); 
        
        loadCbbLoaiBaoCao();
    }

    public void loadCbbLoaiBaoCao()
    {
        cbbLoaiBaoCao.removeAllItems();
        cbbLoaiBaoCao.setModel(new DefaultComboBoxModel<>(new String[]
        {"Báo cáo doanh thu dịch vụ", "Báo cáo doanh thu theo từng ngày"}));
    }
    
    public BufferedImage createPieChart(DefaultPieDataset dataset)
    {
        BufferedImage bufferedImage = null;
        try
        {
            JFreeChart chart = ChartFactory.createPieChart("Doanh thu dịch vụ", dataset, false, true, false);
            chart.getTitle().setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 120));
            PiePlot piePlot = (PiePlot) chart.getPlot();
            piePlot.setShadowPaint(null);
            piePlot.setBackgroundPaint(Color.white);
            piePlot.setOutlinePaint(null);
            piePlot.setLabelBackgroundPaint(Color.white);
            piePlot.setLabelOutlinePaint(Color.white);
            piePlot.setLabelShadowPaint(null);
            piePlot.setLabelFont(new java.awt.Font("Tahoma", java.awt.Font.ITALIC, 80));
            PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} - {2}");
            piePlot.setLabelGenerator(labelGenerator);
            bufferedImage = chart.createBufferedImage(4000, 4000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bufferedImage;
    }
    
    
    public void XuatBCDoanhThuDichVu()
    {
        Document document = new Document(PageSize.A4);
        String filename = "BCDoanhThuDichVu";
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\NetBeans\\QuanLyKhamBenh\\src\\reports\\"+ filename + ".pdf"));
            document.open();
            File filefontTieuDe = new File("D:\\NetBeans\\QuanLyKhamBenh\\src\\fonts\\vuArialBold.ttf");
            BaseFont bfTieuDe = BaseFont.createFont(filefontTieuDe.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontTieuDe1 = new Font(bfTieuDe, 16);
            fontTieuDe1.setColor(BaseColor.BLUE);
            Font fontTieuDe2 = new Font(bfTieuDe, 13);
            fontTieuDe2.setColor(BaseColor.BLUE);
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

            Paragraph prgTieuDe = new Paragraph("BÁO CÁO DOANH THU DỊCH VỤ", fontTieuDe1);
            prgTieuDe.setAlignment(Element.ALIGN_CENTER);
            prgTieuDe.setSpacingBefore(10);
            //prgTieuDe.setSpacingAfter(10);
            document.add(prgTieuDe);
            
            String tuNgay = df.format(datTuNgay.getDate());
            String denNgay = df.format(datDenNgay.getDate());
            Paragraph prgNgay = new Paragraph("Từ ngày " + tuNgay + " đến ngày " + denNgay, fontTieuDe3);
            prgNgay.setAlignment(Element.ALIGN_CENTER);
            prgNgay.setSpacingAfter(10);
            document.add(prgNgay);
            
            Paragraph prgTieuDe1 = new Paragraph("I. Doanh thu của các dịch vụ:", fontTieuDe2);
            prgTieuDe1.setAlignment(Element.ALIGN_LEFT);
            prgTieuDe1.setSpacingAfter(10);
            document.add(prgTieuDe1);
            
            // Tạo bảng
            PdfPTable tableDV = new PdfPTable(5);
            tableDV.setWidthPercentage(80);
            tableDV.setSpacingBefore(10);
            tableDV.setSpacingAfter(10);

            float[] tableDV_columnWidths = {50, 120, 150, 100, 100};
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
            
            PdfPCell cellTDSoTien = new PdfPCell(new Paragraph("Số tiền", fontTieuDe3));
            cellTDSoTien.setBorderColor(BaseColor.BLACK);
            cellTDSoTien.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellTDSoTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableDV.addCell(cellTDSoTien);
            
            PdfPCell cellTDGhiChu = new PdfPCell(new Paragraph("Ghi chú", fontTieuDe3));
            cellTDGhiChu.setBorderColor(BaseColor.BLACK);
            cellTDGhiChu.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellTDGhiChu.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableDV.addCell(cellTDGhiChu);
            
            DBUtils dbu = new DBUtils();
            DefaultPieDataset dataset = new DefaultPieDataset();
            try
            {
                Connection con = dbu.createConn();
                String strSQL = "select  dv.madv, tendv , sum(thanhtien) "
                        + "from (thuphi tp join khambenh kb on kb.makb = tp.makb) "
                        + "     join dichvu dv on dv.madv = tp.madv "
                        + "where ngaykham >= ? and ngaykham <= ? group by dv.madv, tendv;";
                PreparedStatement pres = con.prepareStatement(strSQL);
                pres.setString(1, df2.format(datTuNgay.getDate()));
                pres.setString(2, df2.format(datDenNgay.getDate()));
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

                    PdfPCell cellMaDV = new PdfPCell(new Paragraph(rs.getString(1), fontNoiDung3));
                    cellMaDV.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellMaDV.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tableDV.addCell(cellMaDV);

                    PdfPCell cellTenDV = new PdfPCell(new Paragraph(rs.getString(2), fontNoiDung3));
                    cellTenDV.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellTenDV.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tableDV.addCell(cellTenDV);

                    PdfPCell cellSoTien = new PdfPCell(new Paragraph(String.format("%,d",rs.getInt(3)), fontNoiDung3));
                    cellSoTien.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellSoTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tableDV.addCell(cellSoTien);

                    PdfPCell cellGhiChu = new PdfPCell(new Paragraph("", fontNoiDung3));
                    tableDV.addCell(cellGhiChu);
                    
                    TongTien += rs.getInt(3);
                    TT++;
                    
                    dataset.setValue(rs.getString(2), rs.getInt(3));
                }
                PdfPCell cellTongCong = new PdfPCell(new Paragraph("TỔNG CỘNG:", fontTieuDe3));
                cellTongCong.setColspan(3);
                cellTongCong.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTongCong.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cellTongCong.setMinimumHeight(20);
                tableDV.addCell(cellTongCong);
                
                PdfPCell cellTongTien = new PdfPCell(new Paragraph(String.format("%,d", TongTien), fontTieuDe3));
                //cellTongCong.setColspan(5);
                cellTongTien.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTongTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableDV.addCell(cellTongTien);
                
                PdfPCell cellCotTrong = new PdfPCell(new Paragraph("", fontTieuDe3));
                cellCotTrong.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellCotTrong.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableDV.addCell(cellCotTrong);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            document.add(tableDV);
            
            Paragraph prgTieuDe2 = new Paragraph("II. Biểu đồ phần trăm Doanh thu của các dịch vụ:", fontTieuDe2);
            prgTieuDe2.setAlignment(Element.ALIGN_LEFT);
            prgTieuDe2.setSpacingBefore(10);
            document.add(prgTieuDe2);
            
            BufferedImage bufferedImage = createPieChart(dataset);
            Image image = Image.getInstance(writer, bufferedImage, 1.0f);
            image.setAlignment(Element.ALIGN_CENTER);
            image.scaleAbsolute(400, 400);
            document.add(image);
            
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
    
    public BufferedImage createBarChart(DefaultCategoryDataset dataset, String tuNgay, String denNgay)
    {
        BufferedImage bufferedImage = null;
        try{
            JFreeChart chart = ChartFactory.createBarChart("Doanh thu từ ngày " + tuNgay + " đến ngày " + denNgay, "Ngày", "Doanh thu", dataset, PlotOrientation.VERTICAL, false, false, false);
            java.awt.Font fontTieuDe = new java.awt.Font("Tahoma", java.awt.Font.BOLD, 120);
            java.awt.Font fontNoiDung1 = new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 80);
            java.awt.Font fontNoiDung2 = new java.awt.Font("Tahoma", java.awt.Font.ITALIC, 80);
            
            chart.getTitle().setFont(fontTieuDe);
            
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            ((BarRenderer) plot.getRenderer()).setBarPainter(new StandardBarPainter());
            plot.setBackgroundPaint(Color.white);
            plot.setOutlinePaint(null);
            
            CategoryItemRenderer renderer = ((CategoryPlot) chart.getPlot()).getRenderer();
            renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            renderer.setDefaultItemLabelsVisible(true);
            ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
            renderer.setDefaultPositiveItemLabelPosition(position);
            renderer.setDefaultItemLabelFont(fontNoiDung1);
            
            CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setTickLabelFont(fontNoiDung1);
            domainAxis.setLabelFont(fontNoiDung2);
            
            ValueAxis rangeAxis = plot.getRangeAxis();
            rangeAxis.setTickLabelFont(fontNoiDung1);
            rangeAxis.setLabelFont(fontNoiDung2);
            
            bufferedImage = chart.createBufferedImage(5000, 3000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return bufferedImage;
    }
    
    public void XuatBCDoanhThuTungNgay()
    {
        Document document = new Document(PageSize.A4);
        String filename = "BCDoanhThuTungNgay";
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\NetBeans\\QuanLyKhamBenh\\src\\reports\\"+ filename + ".pdf"));
            document.open();
            File filefontTieuDe = new File("D:\\NetBeans\\QuanLyKhamBenh\\src\\fonts\\vuArialBold.ttf");
            BaseFont bfTieuDe = BaseFont.createFont(filefontTieuDe.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font fontTieuDe1 = new Font(bfTieuDe, 16);
            fontTieuDe1.setColor(BaseColor.BLUE);
            Font fontTieuDe2 = new Font(bfTieuDe, 13);
            fontTieuDe2.setColor(BaseColor.BLUE);
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

            Paragraph prgTieuDe = new Paragraph("BÁO CÁO DOANH THU THEO NGÀY", fontTieuDe1);
            prgTieuDe.setAlignment(Element.ALIGN_CENTER);
            prgTieuDe.setSpacingBefore(10);
            document.add(prgTieuDe);
            
            String tuNgay = df.format(datTuNgay.getDate());
            String denNgay = df.format(datDenNgay.getDate());
            Paragraph prgNgay = new Paragraph("Từ ngày " + tuNgay + " đến ngày " + denNgay, fontTieuDe3);
            prgNgay.setAlignment(Element.ALIGN_CENTER);
            prgNgay.setSpacingAfter(10);
            document.add(prgNgay);
            
            Paragraph prgTieuDe1 = new Paragraph("I. Doanh thu từng ngày:", fontTieuDe2);
            prgTieuDe1.setAlignment(Element.ALIGN_LEFT);
            prgTieuDe1.setSpacingAfter(10);
            document.add(prgTieuDe1);
            
            // Tạo bảng
            PdfPTable tableDoanhThuNgay = new PdfPTable(4);
            tableDoanhThuNgay.setWidthPercentage(80);
            tableDoanhThuNgay.setSpacingBefore(10);
            tableDoanhThuNgay.setSpacingAfter(10);

            float[] tableDoanhThuNgay_columnWidths = {50, 120, 150, 100};
            tableDoanhThuNgay.setWidths(tableDoanhThuNgay_columnWidths);

            PdfPCell cellTDTT = new PdfPCell(new Paragraph("STT", fontTieuDe3));
            cellTDTT.setBorderColor(BaseColor.BLACK);
            cellTDTT.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellTDTT.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellTDTT.setMinimumHeight(30);
            tableDoanhThuNgay.addCell(cellTDTT);
            
            PdfPCell cellTDMaDV = new PdfPCell(new Paragraph("Ngày", fontTieuDe3));
            cellTDMaDV.setBorderColor(BaseColor.BLACK);
            cellTDMaDV.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellTDMaDV.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableDoanhThuNgay.addCell(cellTDMaDV);

            
            PdfPCell cellTDSoTien = new PdfPCell(new Paragraph("Số tiền", fontTieuDe3));
            cellTDSoTien.setBorderColor(BaseColor.BLACK);
            cellTDSoTien.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellTDSoTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableDoanhThuNgay.addCell(cellTDSoTien);
            
            PdfPCell cellTDGhiChu = new PdfPCell(new Paragraph("Ghi chú", fontTieuDe3));
            cellTDGhiChu.setBorderColor(BaseColor.BLACK);
            cellTDGhiChu.setHorizontalAlignment(Element.ALIGN_CENTER);
            cellTDGhiChu.setVerticalAlignment(Element.ALIGN_MIDDLE);
            tableDoanhThuNgay.addCell(cellTDGhiChu);
            
            DBUtils dbu = new DBUtils();
            try
            {
                Connection con = dbu.createConn();
                String strSQL = "select ngaykham, sum(thanhtien) "
                        + "from khambenh kb join thuphi tp on kb.makb = tp.makb "
                        + "where ngaykham >= ? and ngaykham <= ? group by ngaykham;";
                PreparedStatement pres = con.prepareStatement(strSQL);
                pres.setString(1, df2.format(datTuNgay.getDate()));
                pres.setString(2, df2.format(datDenNgay.getDate()));
                ResultSet rs = pres.executeQuery();
                int TongTien = 0;
                int TT = 1;
                while(rs.next())
                {
                    PdfPCell cellTT = new PdfPCell(new Paragraph(String.valueOf(TT), fontNoiDung3));
                    cellTT.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellTT.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cellTT.setMinimumHeight(20);
                    tableDoanhThuNgay.addCell(cellTT);

                    PdfPCell cellNgay = new PdfPCell(new Paragraph(df.format(rs.getDate(1)), fontNoiDung3));
                    cellNgay.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellNgay.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tableDoanhThuNgay.addCell(cellNgay);
                    
                    PdfPCell cellSoTien = new PdfPCell(new Paragraph(String.format("%,d",rs.getInt(2)), fontNoiDung3));
                    cellSoTien.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cellSoTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tableDoanhThuNgay.addCell(cellSoTien);

                    PdfPCell cellGhiChu = new PdfPCell(new Paragraph("", fontNoiDung3));
                    tableDoanhThuNgay.addCell(cellGhiChu);
                    
                    TongTien += rs.getInt(2);
                    TT++;
                    
                    dataset.setValue(rs.getInt(2),"DoanhThu", df.format(rs.getDate(1)));
                }
                PdfPCell cellTongCong = new PdfPCell(new Paragraph("TỔNG CỘNG:", fontTieuDe3));
                cellTongCong.setColspan(2);
                cellTongCong.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTongCong.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cellTongCong.setMinimumHeight(20);
                tableDoanhThuNgay.addCell(cellTongCong);
                
                PdfPCell cellTongTien = new PdfPCell(new Paragraph(String.format("%,d", TongTien), fontTieuDe3));
                cellTongTien.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellTongTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableDoanhThuNgay.addCell(cellTongTien);
                
                PdfPCell cellCotTrong = new PdfPCell(new Paragraph("", fontTieuDe3));
                cellCotTrong.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellCotTrong.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableDoanhThuNgay.addCell(cellCotTrong);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            document.add(tableDoanhThuNgay);
            
            Paragraph prgTieuDe2 = new Paragraph("II. Biểu đồ Doanh thu theo ngày:", fontTieuDe2);
            prgTieuDe2.setAlignment(Element.ALIGN_LEFT);
            prgTieuDe2.setSpacingBefore(10);
            document.add(prgTieuDe2);
            
            BufferedImage bufferedImageBDDT = createBarChart(dataset, tuNgay, denNgay);
            Image image = Image.getInstance(writer, bufferedImageBDDT, 1.0f);
            image.setAlignment(Element.ALIGN_CENTER);
            image.scaleAbsolute(500, 300);
            
            document.add(image);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnXuatFile = new javax.swing.JButton();
        cbbLoaiBaoCao = new javax.swing.JComboBox<>();
        datTuNgay = new com.toedter.calendar.JDateChooser();
        datDenNgay = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("THỐNG KÊ BÁO CÁO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Loại báo cáo:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Đến ngày:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Từ ngày:");

        btnXuatFile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXuatFile.setText("Xuất file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        cbbLoaiBaoCao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbLoaiBaoCao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        datTuNgay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        datDenNgay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(datDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbbLoaiBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)))))))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLoaiBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(datTuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(datDenNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        if(cbbLoaiBaoCao.getSelectedItem() == null || datTuNgay.getDate() == null || datDenNgay.getDate() == null)
        {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if(datTuNgay.getDate().compareTo(datDenNgay.getDate()) == 1)
            {
                JOptionPane.showMessageDialog(this, "Ngày thống kê báo cáo không hợp lệ. Xin vui lòng chọn lại.", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                datTuNgay.setDate(null);
                datDenNgay.setDate(null);
            }
            else
            {
                if(cbbLoaiBaoCao.getSelectedItem().toString().equals("Báo cáo doanh thu dịch vụ"))
                {
                    XuatBCDoanhThuDichVu();
                }
                if(cbbLoaiBaoCao.getSelectedItem().toString().equals("Báo cáo doanh thu theo từng ngày"))
                {
                    XuatBCDoanhThuTungNgay();
                }
                
            }
        } 
    }//GEN-LAST:event_btnXuatFileActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JComboBox<String> cbbLoaiBaoCao;
    private com.toedter.calendar.JDateChooser datDenNgay;
    private com.toedter.calendar.JDateChooser datTuNgay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
