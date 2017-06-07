package autotest.proxy;

public class TestBeanProxy extends TestBean{

@Override
public void setId (long id ){
System.out.println("setId has invoked.before: " + String.valueOf(this.getId()) + " after: " + String.valueOf(id));
super.setId(id);
}
@Override
public void setName (java.lang.String name ){
System.out.println("setName has invoked.before: " + String.valueOf(this.getName()) + " after: " + String.valueOf(name));
super.setName(name);
}

}