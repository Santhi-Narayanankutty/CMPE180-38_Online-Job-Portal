/**
 * 
 */
package job;

/**
 * @author Ramanathan
 *
 */
public class Qualification {
private int JOB_ID;
private String JS_educational_Qualification;

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Qualification [JOB_ID=" + JOB_ID
			+ ", JS_educational_Qualification=" + JS_educational_Qualification
			+ "]";
}
/**
 * @param jOB_ID
 * @param jS_educational_Qualification
 */
public Qualification(int jOB_ID, String jS_educational_Qualification) {
	super();
	JOB_ID = jOB_ID;
	JS_educational_Qualification = jS_educational_Qualification;
}

public int getJOB_ID() {
	return JOB_ID;
}
/**
 * @param jOB_ID the jOB_ID to set
 */
public void setJOB_ID(int jOB_ID) {
	JOB_ID = jOB_ID;
}
/**
 * @return the jS_educational_Qualification
 */
public String getJS_educational_Qualification() {
	return JS_educational_Qualification;
}
/**
 * @param jS_educational_Qualification the jS_educational_Qualification to set
 */
public void setJS_educational_Qualification(String jS_educational_Qualification) {
	JS_educational_Qualification = jS_educational_Qualification;
}
/**
 * 
 */
public Qualification() {
	super();
}


}
