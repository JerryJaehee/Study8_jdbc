package com.iu.s1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.s1.util.DBConnector;

public class LocationDAO {
	
	private DBConnector dbConnector;
	
	public LocationDAO() {
		dbConnector = new DBConnector();
	}
	public List<LocationDTO> getList() throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList();
		
		// 1. DB에 로그인
		Connection connection = dbConnector.getConnect();

		// 2. Sql Query문 작성
		String sql = "SELECT * FROM LOCATIONS";
		
		// 3. Query 미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		
		// 4. ? 셋팅은 통과

		// 5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		// 6. View에 값 넘겨주기
		//한 줄 읽고 데이터 꺼내기
		while(rs.next()) { 
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
			locationDTO.setCity(rs.getString("city"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
			
			ar.add(locationDTO);
		}
		
		// 7. 자원 해제
		rs.close();
		st.close();
		connection.close();
		
		return ar;
	}
}
