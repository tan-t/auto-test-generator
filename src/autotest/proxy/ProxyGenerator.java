package autotest.proxy;

import java.lang.reflect.Field;
import java.util.Objects;

public class ProxyGenerator<T> {
	
	private final Class<T> clazz;
	private static final String LINE_SEPARATOR =System.lineSeparator();
	public ProxyGenerator(Class<T> clazz){
		this.clazz = clazz;
	}
	
	public String createShallow(){
		Field[] fields = this.clazz.getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		for(Field field : fields){
			sb.append(makeUpAsMethod(field.getName(),field.getType()));
		}
		return sb.toString();
	}
	
	private static String toGetter(String field,boolean isBoolean){
		StringBuilder sb = new StringBuilder();
		sb.append(isBoolean ? "is" : "get");
		Character first = Character.toUpperCase(field.charAt(0));
		sb.append(first);
		sb.append(field.substring(1));
		return sb.toString();
	}
	
	private static String toSetter(String field){
		StringBuilder sb = new StringBuilder();
		sb.append("set");
		Character first = Character.toUpperCase(field.charAt(0));
		sb.append(first);
		sb.append(field.substring(1));
		return sb.toString();
	}
	
	private static String makeUpAsMethod(String fieldName,Class<?> returnType){
		String setter = toSetter(fieldName);
		String getter = toGetter(fieldName, returnType.getSimpleName().contains("oolean"));
		StringBuilder sb = new StringBuilder();
		sb.append(LINE_SEPARATOR);
		sb.append("@Override");
		sb.append(LINE_SEPARATOR);
		sb.append("public ");
		sb.append("void");
		sb.append(" ");
		sb.append(setter);
		sb.append(" (");
		sb.append(returnType.getSimpleName() + " " + fieldName);
		sb.append(" ){");
		sb.append(LINE_SEPARATOR);
			sb.append("System.out.println(\"");
			sb.append(setter);
			sb.append(" has invoked.before:");
			sb.append(" \" + String.valueOf(this.");
			sb.append(getter);
			sb.append("()) + \" after:");
			sb.append(" \" + String.valueOf(");
			sb.append(fieldName);
			sb.append("))");
			sb.append(";");
			sb.append(LINE_SEPARATOR);
			sb.append("super.");
			sb.append(setter);
			sb.append("(");
			sb.append(fieldName);
			sb.append(")");
		sb.append(";");
		sb.append(LINE_SEPARATOR);
		sb.append("}");
		return sb.toString();
	}
	
	
}
