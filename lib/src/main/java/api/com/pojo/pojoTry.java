package api.com.pojo;

import java.util.List;

public class pojoTry {
private String name;
private String job;
private List<String>jobs;
public List<String> getJobs() {
	return jobs;
}
public void setJobs(List<String> jobs) {
	this.jobs = jobs;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
private List<citymodel> citymodels;
public List<citymodel> getCitymodels() {
	return citymodels;
}
public void setCitymodels(List<citymodel> citymodels) {
	this.citymodels = citymodels;
}

}
