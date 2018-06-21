package net.integritas.oraclecode18.junit5.ex12_dynamictests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DynamicTest;

public class JavaBeanTestUtil {

    public static Collection<DynamicTest> dynamicPropertyTestsFromJavaBean(Object o) throws IntrospectionException {
    	List<DynamicTest> testList = new ArrayList<>();
    	
    	BeanUtil bu = new BeanUtil();
    	List<String> properties = bu.listOfProperties(o);
    	properties.forEach((propertyName)-> {
    		testList.add(dynamicTest(o.getClass().getSimpleName()+"."+propertyName, () -> {
    			bu.setStringProperty(o, propertyName, "abc");
    			String value = bu.getStringProperty(o, propertyName);
    			assertEquals("abc", value);
    		}));
    	});
    	
        return testList;
    }
    
	
}
