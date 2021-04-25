import java.util.ArrayList;

abstract class A
{
    public String ma, ten;
    public ArrayList<String> BB;

    public A(){}

    public A(String Ma, String Ten)
    {
        ma = Ma;
        ten = Ten;
        BB = new ArrayList<String>();
    }

    public void Xuat()
    {
        System.out.println("Ma: " + ma);
        System.out.println("Ten: " + ten);
        System.out.println("Bai bao: ");
        for(String bb : BB)
        {
            System.out.println(bb);
        }
    }

    public double tinhTB()
    {
        double diemTB = 0;
        for(int i = 0; i < BB.size(); i++)
        {
            if(BB.get(i).equals("Loai A"))
                diemTB += 10;
            else if(BB.get(i).equals("Loai B"))
                diemTB += 8;
            else
                diemTB += 6;
        }
        return diemTB /= BB.size();
    }

    public abstract boolean KT();
}

class SV extends A
{
    public SV(){}
    public SV(String Ma, String Ten)
    {
        super(Ma, Ten);
    }

    public double tinhTB()
    {
        return super.tinhTB();
    }

    public boolean KT()
    {
        if(tinhTB() > 7)
            return true;
        return false;
    }
}

class GV extends A
{

    public String khoa, hhhv;
    public GV()
    {

    }

    public GV(String Ma, String Ten, String Khoa, String HHHV)
    {
        super(Ma, Ten);
        khoa = Khoa;
        hhhv = HHHV;
    }

    public double tinhTB()
    {
        double diemTB = super.tinhTB();
        if(hhhv.equals("GS"))
            return diemTB * 0.1;
        else if(hhhv.equals("PGS"))
            return diemTB * 0.15;
        else 
            return diemTB * 0.3;
    }

    public void Xuat()
    {
        super.Xuat();
        System.out.println("Khoa: " + khoa);
        System.out.println("HHHV: " + hhhv);
    }

    public boolean KT()
    {
        return (tinhTB() > 8.5);    
    }
}

public class De1
{
    public static void themBBLoaiA(ArrayList<A> ds , String Ten, String Ma)
    {
        for(A sv: ds)
        {
            if(sv.ten.equals(Ten))
                sv.BB.add("Loai A");
        }
        
    }
    public static void main(String[] args)
    {
        ArrayList<A> ds = new ArrayList<A>();
        //Test
        SV sv = new SV("Le D", "SV026");
        ds.add(sv);
        sv.BB.add("Loai B");
        themBBLoaiA(ds, "Le D", "SV026");
        for(A obj : ds)
        {
            if(obj.KT())
                obj.Xuat();
        }
    }
}
