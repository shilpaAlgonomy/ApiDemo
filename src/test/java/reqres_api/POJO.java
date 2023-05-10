package reqres_api;

public class POJO {
	
	String name;
	String phone;
	String location;
	String courses[];

	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setLocation(String location)
	{
		this.location=location;
	}
	public String getLocation()
	{
		return location;
	}
	public void setCourses(String[] courses)
	{
		this.courses=courses;
	}
}
