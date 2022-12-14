package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.DBUtils.getConn;
import pojos.Candidate;

public class CandidateDaoImpl implements CandidateDao {
	private Connection cn;
	private PreparedStatement pst1,pst2;
	private PreparedStatement stmtgetTopTwo;
	private PreparedStatement stmtGetAnalysis;

	public CandidateDaoImpl() throws SQLException {
		// get cn form db utils
		cn = getConn();
		// create pst1
		pst1 = cn.prepareStatement("select * from candidates");
		pst2=cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		stmtgetTopTwo = cn.prepareStatement(" select * from candidates order by votes desc limit 2");
		stmtGetAnalysis = cn.prepareStatement("select party, sum(votes) from candidates group by party");
		System.out.println("candidate dao created!");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		List<Candidate> candidates = new ArrayList<>();
		// exec query --rst
		try (ResultSet rst = pst1.executeQuery()) {
			// candidateId, String name, String partyName, int votes) {
			while (rst.next())
				candidates.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return candidates;
	}
	

	@Override
	public String incrementVotes(int candidateId) throws SQLException {
		pst2.setInt(1, candidateId);
		//exec update --> updated rwo count
		int rowCount=pst2.executeUpdate();
		if(rowCount == 1)
			return "Votes incremented!";
		return "Incrementing Votes failed !!!!!!!!!";
	}
	
	
	@Override
	public List<Candidate> showTopTwo() throws SQLException {
		List<Candidate> list = new ArrayList<>();
		try(ResultSet rs = stmtgetTopTwo.executeQuery()){
			while(rs.next()) {
//				| id | name | party | votes
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String party = rs.getString(3);
				int votes = rs.getInt(4);
				list.add(new Candidate(id, name, party, votes));
			}
			
		}
		return list;
	}
	

	// clean up
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		System.out.println("candidate dao cleaned up !");
	}

	@Override
	public Map<String, Integer> getVotesAnalysis() throws SQLException {
		HashMap<String, Integer> map = new HashMap<>();
		try(ResultSet rs = stmtGetAnalysis.executeQuery()){
			while(rs.next()) {
				String party = rs.getString(1);
				int totalVotes = rs.getInt(2);
				map.put(party, totalVotes);
			}
		}
		return map;
	}

}
