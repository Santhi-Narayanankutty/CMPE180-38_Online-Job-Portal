/**
 * 
 */
package job;

/**
 * @author Ramanathan
 *
 */
public class Skill {
	private int job_Id;
	private String job_skill;
	private String job_exp;
	public int getJob_Id() {
		return job_Id;
	}
	public void setJob_Id(int job_Id) {
		this.job_Id = job_Id;
	}
	public String getJob_skill() {
		return job_skill;
	}
	public void setJob_skill(String job_skill) {
		this.job_skill = job_skill;
	}
	public String getJob_exp() {
		return job_exp;
	}
	public void setJob_exp(String job_exp) {
		this.job_exp = job_exp;
	}
	/**
	 * 
	 */
	public Skill() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Skill [job_Id=" + job_Id + ", job_skill=" + job_skill
				+ ", job_exp=" + job_exp + "]";
	}
	/**
	 * @param job_Id
	 * @param job_skill
	 * @param job_exp
	 */
	public Skill(int job_Id, String job_skill, String job_exp) {
		super();
		this.job_Id = job_Id;
		this.job_skill = job_skill;
		this.job_exp = job_exp;
	}
}
