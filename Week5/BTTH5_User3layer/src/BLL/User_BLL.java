package BLL;
import DAL.User_DAL;
import DTO.User_DTO;
import java.util.ArrayList;

public class User_BLL 
{
    User_DAL userDAL = new User_DAL();
    
    public ArrayList<User_DTO> getAllUser()
    {
        return userDAL.getAllUser();
    }
    
    public int insertUser(User_DTO User)
    {
        int result = userDAL.insertUser(User);
        return result;
    }
    
    public int updateUser(User_DTO User)
    {
        int result = userDAL.updateUser(User);
        return result;
    }
    
    public int deleteUser(User_DTO User)
    {
        int result = userDAL.deleteUser(User);
        return result;
    }
}
