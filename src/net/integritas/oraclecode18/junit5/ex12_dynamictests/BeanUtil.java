package net.integritas.oraclecode18.junit5.ex12_dynamictests;

import java.beans.BeanInfo;
import java.beans.Expression;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

public class BeanUtil {

	public List<String> listOfProperties(Object javaBean) throws IntrospectionException {
        BeanInfo bi = Introspector.getBeanInfo(javaBean.getClass());
        PropertyDescriptor[] pds = bi.getPropertyDescriptors();
        List<String> propertyNames = new ArrayList<>();
        for (PropertyDescriptor prop:pds) {
        	if (!prop.getName().equals("class")) {
            	propertyNames.add(prop.getName());        		
        	}
        }
        return propertyNames;
	}
	
	public String capitalizeFirstLetter(String input) {
		String output = input.substring(0, 1).toUpperCase() + input.substring(1);
		return output;
	}

	
	public void setStringProperty(Object o, String propertyName, String propertyValue) throws Exception {
        Expression expr = new Expression(o, "set" + capitalizeFirstLetter(propertyName), new Object[] {propertyValue});
        expr.execute();
        String s = (String)expr.getValue();            	
	}
	

	public String getStringProperty(Object o, String propertyName) throws Exception {
        Expression expr = new Expression(o, "get" + capitalizeFirstLetter(propertyName), new Object[0]);
        expr.execute();
        String s = (String)expr.getValue();            	
        
        return s;
	}

	
	public static void main(String[] args) throws Exception {
		System.out.println("BeanUtil");
		BeanUtil bu = new BeanUtil();
		Employee e = new Employee();
		
		System.out.println(bu.listOfProperties(e));
		bu.setStringProperty(e, "name", "abc");
		String value = bu.getStringProperty(e, "name");
		System.out.println(value);
		
	}
	
	
}
