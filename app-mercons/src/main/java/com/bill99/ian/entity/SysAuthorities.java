package com.bill99.ian.entity;

import java.io.Serializable;
import java.util.Set;

public class SysAuthorities implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4855189180166416129L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_authorities.AUTHORITY_ID
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    private String authorityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_authorities.AUTHORITY_NAME
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    private String authorityName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_authorities.AUTHORITY_DESC
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    private String authorityDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_authorities.ENABLED
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    private Integer enabled;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_authorities.ISSYS
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    private Integer issys;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_authorities.MODULE
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    private String module;

    private Set<SysRolesAuthorities> sysRolesAuthoritieses;  
    private Set<SysAuthoritiesResources> sysAuthoritiesResourceses;
    
    public SysAuthorities() {  
    }  
  
    public SysAuthorities(String authorityId) {  
        this.authorityId = authorityId;  
    }  
  
    public SysAuthorities(String authorityId, String authorityName,  
            String authorityDesc, Integer enabled, Integer issys, String module,  
            Set<SysRolesAuthorities> sysRolesAuthoritieses, Set<SysAuthoritiesResources> sysAuthoritiesResourceses) {  
        this.authorityId = authorityId;  
        this.authorityName = authorityName;  
        this.authorityDesc = authorityDesc;  
        this.enabled = enabled;  
        this.issys = issys;  
        this.module = module;  
        this.sysRolesAuthoritieses = sysRolesAuthoritieses;  
        this.sysAuthoritiesResourceses = sysAuthoritiesResourceses;  
    }
    
    public Set<SysRolesAuthorities> getSysRolesAuthoritieses() {
		return sysRolesAuthoritieses;
	}

	public void setSysRolesAuthoritieses(
			Set<SysRolesAuthorities> sysRolesAuthoritieses) {
		this.sysRolesAuthoritieses = sysRolesAuthoritieses;
	}

	public Set<SysAuthoritiesResources> getSysAuthoritiesResourceses() {
		return sysAuthoritiesResourceses;
	}

	public void setSysAuthoritiesResourceses(
			Set<SysAuthoritiesResources> sysAuthoritiesResourceses) {
		this.sysAuthoritiesResourceses = sysAuthoritiesResourceses;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_authorities.AUTHORITY_ID
     *
     * @return the value of sys_authorities.AUTHORITY_ID
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    public String getAuthorityId() {
        return authorityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_authorities.AUTHORITY_ID
     *
     * @param authorityId the value for sys_authorities.AUTHORITY_ID
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_authorities.AUTHORITY_NAME
     *
     * @return the value of sys_authorities.AUTHORITY_NAME
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_authorities.AUTHORITY_NAME
     *
     * @param authorityName the value for sys_authorities.AUTHORITY_NAME
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_authorities.AUTHORITY_DESC
     *
     * @return the value of sys_authorities.AUTHORITY_DESC
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    public String getAuthorityDesc() {
        return authorityDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_authorities.AUTHORITY_DESC
     *
     * @param authorityDesc the value for sys_authorities.AUTHORITY_DESC
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    public void setAuthorityDesc(String authorityDesc) {
        this.authorityDesc = authorityDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_authorities.ENABLED
     *
     * @return the value of sys_authorities.ENABLED
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    public Integer getEnabled() {
        return enabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_authorities.ENABLED
     *
     * @param enabled the value for sys_authorities.ENABLED
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_authorities.ISSYS
     *
     * @return the value of sys_authorities.ISSYS
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    public Integer getIssys() {
        return issys;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_authorities.ISSYS
     *
     * @param issys the value for sys_authorities.ISSYS
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    public void setIssys(Integer issys) {
        this.issys = issys;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_authorities.MODULE
     *
     * @return the value of sys_authorities.MODULE
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    public String getModule() {
        return module;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_authorities.MODULE
     *
     * @param module the value for sys_authorities.MODULE
     *
     * @mbggenerated Fri Dec 18 17:19:16 CST 2015
     */
    public void setModule(String module) {
        this.module = module;
    }
}