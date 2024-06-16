
// Student class is a pojo class and  it  has a id ,name, gpa, city,university all the instance variable 
class Student
{
	private int id;
	private String name;
	private double gpa;
	private String city;
	private String university;

	public Student(int id , String name , double gpa  , String university,String city)
	{
	this.id = id;
	this.name = name;
	this.gpa = gpa;
	this.city = city;
	this.university= university;
	}
	public String getName()
	{
	return this.name;
	}
	public int getId()
	{
	return this.id;
	}
	public double getGpa()
	{
	return this.gpa;
	}
	public String getUniversity()
	{
	return this.university;
	}
  public String getCity()
  {
    return this.city;
  }

/* Setters */
	public void setName(String name)
	{
    this.name = name;
	}

    public void setId(int id)
    {
    this.id = id;
    }

    public void setGpa(double gpa)
    {
    this.gpa = gpa;
    }

    public void setCity(String city)
    {
    this.city = city;
    }

    public void setUniversity(String university)
    {
    this.university = university;
    }

    @Override
    public String toString()
    {
    return " " + this.name  +" "+ this.gpa + " " + this.gpa + " " +this.city+" " + this.university +" ";
    }


}