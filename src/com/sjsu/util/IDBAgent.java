package com.sjsu.util;

import java.util.LinkedList;
import java.util.List;

import com.sjsu.model.Job_Seeker;
import com.sjsu.model.Jobs;

public interface IDBAgent {
public  LinkedList<Jobs> getJobs();
public LinkedList<Job_Seeker> getCandidates(int jobid);

}
