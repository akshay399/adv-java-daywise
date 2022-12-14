package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static utils.DbUtil.getConnection;
import pojos.Candidate;

public class candidateDaoImp implements candidateDao {
	private Connection con;
	private PreparedStatement stmtGetAllCan;
	private PreparedStatement stmtIncrVotes;
	
	public candidateDaoImp() throws SQLException {
		con = getConnection();
		String sqlGetAllCan = "Select * from candidates";
		stmtGetAllCan = con.prepareStatement(sqlGetAllCan);
		String sqlIncrVotes = "update candidates set votes = votes+1 where id=?";
		stmtIncrVotes = con.prepareStatement(sqlIncrVotes);
	}
	
	public String incrVotes(int cId) throws SQLException {
		stmtIncrVotes.setInt(1, cId);
		int res = stmtIncrVotes.executeUpdate();
		if(res==1) 
			return "Votes incremented!";
		return "Incrementing Votes failed !!!!!!!!!";
	}
	
	public List<Candidate> getAllCandidates() throws SQLException{
		// id | name    | party    | votes
		List<Candidate> candidates = new ArrayList<>();
		try(ResultSet rs = stmtGetAllCan.executeQuery()){
			while(rs.next()) {
				candidates.add(new Candidate( rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		}
		return candidates;
	}
}
