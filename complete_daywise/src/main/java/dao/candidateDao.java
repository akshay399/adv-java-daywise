package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;

public interface candidateDao {
	List<Candidate> getAllCandidates() throws SQLException;
	String incrVotes(int cId) throws SQLException;
}
