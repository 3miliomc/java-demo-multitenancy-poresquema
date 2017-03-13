package com.demo.multitenancy.tenant.process.instance;

public class InstanceProcessContext {

	  final public static String DEFAULT_TENANT = "p1";

	  private static ThreadLocal<String> currentInstance = new ThreadLocal<String>()
	  {
	    @Override
	    protected String initialValue() {
	      return DEFAULT_TENANT;
	    }
	  };

	  public static void setCurrentInstance(String tenant) {
		  currentInstance.set(tenant);
	  }

	  public static String getCurrentInstance() {
	    return currentInstance.get();
	  }

	  public static void clear() {
		  currentInstance.remove();
	  }

	}