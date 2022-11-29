package pojos;

public class Candidate {
//| id | name    | party    | votes
	
	private int id;
	private String name;
	private String party;
	private int vote;
	public Candidate(int id, String name, String party, int vote) {
		super();
		this.id = id;
		this.name = name;
		this.party = party;
		this.vote = vote;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", party=" + party + ", vote=" + vote + "]";
	}
	
}
