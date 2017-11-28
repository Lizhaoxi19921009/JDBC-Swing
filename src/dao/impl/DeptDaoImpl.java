package dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBCon;
import dao.IDeptDao;
import entity.Dept;

public class DeptDaoImpl implements IDeptDao{
	//util鏄暟鎹簱杩炴帴鐨勫疄渚嬪璞�
	DBCon util=new DBCon();
	@Override
	//queryAll鏄儴闂ㄨ〃瀹炵幇鐨勬柟娉曪紝杩欓噷鏄叿浣撳疄鐜�
	public List<Dept> queryAll() {
		// TODO Auto-generated method stub
		return _list(util.query("select * from dept"));
	}
	private List<Dept> _list(ResultSet rs){
		List<Dept> _list=new ArrayList<Dept>();
		//鎶婁粠鏁版嵁搴撹鍒扮殑淇℃伅璁剧疆鍒版瘡涓璞★紝杩斿洖涓�釜_list闆嗗悎锛岄儴闂ㄨ〃鐨勪俊鎭�
		try {
			while(rs.next()){
				Dept dept=new Dept();
				dept.setDeptid(rs.getInt("deptid"));
				dept.setDeptname(rs.getString("deptname"));
				_list.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeAll();
		}
		return _list;
	}

}