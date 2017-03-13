package com.demo.multitenancy.tenant;

public class TenantContext {

	  final public static String DEFAULT_TENANT = "mysql";

	  private static ThreadLocal<String> currentTenant = new ThreadLocal<String>()
	  {
	    @Override
	    protected String initialValue() {
	      return DEFAULT_TENANT;
	    }
	  };

	  public static void setCurrentTenant(String tenant) {
	    currentTenant.set(tenant);
	  }

	  public static String getCurrentTenant() {
	    return currentTenant.get();
	  }

	  public static void clear() {
	    currentTenant.remove();
	  }

	}