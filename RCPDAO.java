package RCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;



public class RCPDAO {

	public List<RCPDTO> selectAll() throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		List<RCPDTO> list = new ArrayList<>();
		try {
			con = RCPDB.getConnection();
			
			String sql = "select rownum, rcpName, fdName, calorie from tbrecipe order by rcpname";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
                          
				String rcpName = rs.getString("rcpName");
				String fdName = rs.getString("fdName");
				int calorie = rs.getInt("calorie");		
				
				RCPDTO dto = new RCPDTO(rcpName, fdName, calorie);
				
				list.add(dto);
			}
			
			System.out.println("상품 전체 조회 결과 , list.size() = " + list.size());
			return list;
		} finally {
			RCPDB.dbClose(rs, ps, con);
		}
	}
        
        
        public List<RCPDTO> selectByName(String rcpName) throws SQLException{
        
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            RCPDTO dto = null;
            List<RCPDTO> list = new ArrayList<>();
            
        try {
            //
            con = RCPDB.getConnection();
            
            //2.
            String sql = "select rcpname, fdname, calorie from tbrecipe where rcpname like '%' || ? || '%' order by rcpname";
            ps = con.prepareStatement(sql);
            ps.setString(1, rcpName);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                rcpName = rs.getString("rcpName");
                String fdName = rs.getString("fdName");
                int calorie = rs.getInt("calorie");
                
                dto = new RCPDTO(rcpName, fdName, calorie);
                
                list.add(dto);
                
            }
          
            return list;
            
        } finally{
           RCPDB.dbClose(rs, ps, con);
        }
        
    }

    public RCPDTO allbyName() throws SQLException {
       
        String rcpName = "";
        
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        RCPDTO dto=new RCPDTO();
        try {
            //1,2
            con=RCPDB.getConnection();
            
            //3
            String sql="select * from tbRecipe where rcpName = ? order by rcpname";
            ps=con.prepareStatement(sql);
            ps.setString(1, rcpName);
            
            //4.
            rs=ps.executeQuery();
            if(rs.next()) {
                rcpName=rs.getString("rcpName");
                int calorie =rs.getInt("calorie");
                String isAllergy = rs.getString("isallergy");
                int time = rs.getInt("time");
                String rcpView = rs.getString("rcpView");
                
                String fdName = rs.getString("fdName");
                String[] fdArr = fdName.split(", ");
                HashMap<String, String> fdNameMap = new HashMap<>();

                for (int i = 0; i < fdArr.length; i += 2) {
                    fdNameMap.put(fdArr[i], fdArr[i + 1]);
                }

//                Iterator<String> key = fdNameMap.keySet().iterator();

//                while (key.hasNext()) {
//                    String keys = key.next();
//                    String value = fdNameMap.get(keys);
//                    System.out.println(keys + ": " + value);
//                }
                
                //레코드 하나는 하나의 DTO
                //하나의 레코드를 DTO로 묶어서 리턴한다
                dto.setRcpName(rcpName);
                dto.setCalorie(calorie);
                dto.setIsAllergy(isAllergy);
                dto.setTime(time);
                dto.setRcpView(rcpView);
                dto.setFdMap(fdNameMap);
            }
         
            return dto;
        }finally {
            RCPDB.dbClose(rs, ps, con);
        }
    }

    
    public String clickName() throws SQLException{
        
            String rcpName = "";
            
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            RCPDTO dto = null;
         
        try {
            //
            con = RCPDB.getConnection();
            
            //2.
            String sql = "select rcpname from tbrecipe where rcpname like  ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, rcpName);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                rcpName = rs.getString("rcpName");
             
                
            }
          
            return rcpName;
            
        } finally{
           RCPDB.dbClose(rs, ps, con);
        }
        
    }
}
