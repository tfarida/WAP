package wap.guessme.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import wap.guessme.models.*;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DataService {	
	private DatabaseConnection dbConn; // = null;
	private Connection conn;
	private Statement stmt;
	private String QUERY;
	
	public DataService() throws SQLException {
		dbConn = DatabaseConnection.getInstance();
		conn = dbConn.getConnection();
	}	
	/**
	 * 
	 * @param emailAddressorGamerName
	 * @return
	 */
	public Gamer getGamer(String emailAddressorGamerName) {
		Gamer gamer = null;
		try {
			//System.out.println("before call conn.createStatement();");
			stmt = conn.createStatement();
			//System.out.println("after call conn.createStatement();");
			QUERY = "select * from tb_user where emailAddress = '"+emailAddressorGamerName+"' OR gamerName = '"+emailAddressorGamerName+"'";			
			ResultSet rs = stmt.executeQuery(QUERY);
			if(rs.next()){
				int id = rs.getInt("id");
				String gamerName = rs.getString("gamerName");
				String emailAddress = rs.getString("emailAddress");
				String password = rs.getString("password");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				Date createdAt = rs.getDate("createdAt");				
				gamer = new Gamer(gamerName, emailAddress, password, fullName, gender, createdAt);
				gamer.setId(id);				
				//System.out.println("Records found");				
			}
			else {
				//System.out.println("No records found");
			}
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return gamer;		
	}	
	
	public List<GamerLog> getOnlineGamers() {
		List<GamerLog> onlineGamers = new ArrayList<GamerLog>();
		try {
			//System.out.println("before call conn.createStatement();");
			stmt = conn.createStatement();
			//System.out.println("after call conn.createStatement();");
			QUERY = "SELECT L.id, L.sessionId, L.loginAt, L.logoutAt, L.activeStatus " + 
					", L.userId, U.gamerName, U.emailAddress, U.password, U.fullName, U.gender, U.createdAt " + 
					"FROM db_wap.tb_user_login L " + 
					"left join db_wap.tb_user U " + 
					"on L.userId = U.id " + 
					"where L.activeStatus = 1";
			
			ResultSet rs = stmt.executeQuery(QUERY);
			
			while(rs.next()){
				Gamer gamer;
				GamerLog gamerLog;
				int id = rs.getInt("userId");
				String gamerName = rs.getString("gamerName");
				String emailAddress = rs.getString("emailAddress");
				String password = rs.getString("password");
				String fullName = rs.getString("fullName");
				String gender = rs.getString("gender");
				Date createdAt = rs.getDate("createdAt");				
				gamer = new Gamer(gamerName, emailAddress, password, fullName, gender, createdAt);
				gamer.setId(id);
				
				id = rs.getInt("id");
				String sessionId = rs.getString("sessionId");
				Date loginAt = rs.getDate("loginAt");
				Date logoutAt = rs.getDate("logoutAt");
				boolean activeStatus = rs.getBoolean("activeStatus");
				
				gamerLog = new GamerLog();
				gamerLog.setGamer(gamer);
				gamerLog.setId(id);
				gamerLog.setSessionId(sessionId);
				gamerLog.setLoginAt(loginAt);
				gamerLog.setLogouAt(logoutAt);
				gamerLog.setActiveStatus(activeStatus);		
				
				onlineGamers.add(gamerLog);
				System.out.println("Record found");
			}

			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return onlineGamers;		
	}	
	
	
	public int insertGamerLog(Gamer gamer, String sessionId) {
		
		int retInt = 0;
		try {
			stmt = conn.createStatement();
			
			SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			
			QUERY = "INSERT INTO tb_user_login(userId, sessionId, loginAt, activeStatus)"
					+ "values ('"+gamer.getId()+"', '"+sessionId+"', '"+f.format(new Date())+"', '1') ";
			
			retInt = stmt.executeUpdate(QUERY,  Statement.RETURN_GENERATED_KEYS);
			stmt.close();
			
					
		} 
		catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}
		
		return retInt;
	}
	
	
	
	

}
