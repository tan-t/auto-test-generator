package autotest.proxy;

public class TestBean {
private long id;
private String name;
private boolean safe;
public boolean isSafe() {
	return safe;
}
public void setSafe(boolean safe) {
	this.safe = safe;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
