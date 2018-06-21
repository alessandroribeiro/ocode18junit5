package net.integritas.oraclecode18.junit5.ex12_dynamictests;

import java.beans.BeanInfo;
import java.beans.Expression;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;



class AllJavaBeansTest {
		  
		
    @TestFactory
    Collection<DynamicTest> employeeBeanTests() throws IntrospectionException {
    	return JavaBeanTestUtil.dynamicPropertyTestsFromJavaBean(new Employee());
    }

    
    @TestFactory
    Collection<DynamicTest> departmentBeanTests() throws IntrospectionException {
    	return JavaBeanTestUtil.dynamicPropertyTestsFromJavaBean(new Department());
    }

}
