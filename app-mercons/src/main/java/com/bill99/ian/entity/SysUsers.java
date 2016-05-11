package com.bill99.ian.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import com.bill99.ian.security.MyUserDetails;

public class SysUsers implements MyUserDetails, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4149486650733876188L;
	
	//用户id
    private String userId;
    
    //用户账号 与 用户id相同，具有唯一性。
    private String userAccount;
    
    //中文用户名。
    private String userName;
    
    //密码原文 ＋ 用户名作为盐值 的字串经过Md5加密后形成的密文。
    private String userPassword;

    //用户备注
    private String userDesc;
    
    //是否能用。
    private Integer enabled;

    //是否是超级用户。
    private Integer isSys;

    //用户所在单位
    private String userDept;

    //用户所在部门职能
    private String userDuty;

    //该用户所负责的子系统 
    private String subSystem;

    //实现了UserDetails之后的相关变量  
    private  String password;
    private  String username;
    private  Set<GrantedAuthority> authorities;
    private  boolean accountNonExpired;
    private  boolean accountNonLocked;
    private  boolean credentialsNonExpired;
    
    public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	public void setIssys(Integer isSys) {
		this.isSys = isSys;
	}
	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}
	public void setUserDuty(String userDuty) {
		this.userDuty = userDuty;
	}
	public void setSubSystem(String subSystem) {
		this.subSystem = subSystem;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public SysUsers(){
    	
    }
    public SysUsers(String userName, String userAccount, String userPassword, Integer enabled, boolean accountNonExpired, boolean accountNonLocked,  
            boolean credentialsNonExpired,Collection<GrantedAuthority> authorities){
    	if (((userAccount == null) || "".equals(userAccount)) || (userPassword == null)) {  
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");  
        } 
        this.userName = userName;
        this.userPassword = userPassword;
        this.username = userName;
        this.password = userPassword;
        this.enabled = enabled;
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
    }
    
    //~ Methods ========================================================================================================  
    public boolean equals(Object rhs) {
        if (!(rhs instanceof SysUsers) || (rhs == null)) {  
            return false;  
        }  

        SysUsers user = (SysUsers) rhs;  
  
        //具有的权限。  
        if (!authorities.equals(user.authorities)) {  
            return false;  
        }  
  
        // 通过Spring Security构建一个用户时，用户名和密码不能为空。  
        return (this.getPassword().equals(user.getPassword()) && this.getUsername().equals(user.getUsername())  
                && (this.isAccountNonExpired() == user.isAccountNonExpired())  
                && (this.isAccountNonLocked() == user.isAccountNonLocked())  
                && (this.isCredentialsNonExpired() == user.isCredentialsNonExpired())  
                && (this.isEnabled() == user.isEnabled()));  
    }
    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<GrantedAuthority> authorities) {  
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");  
        // Ensure array iteration order is predictable (as per UserDetails.getAuthorities() contract and SEC-717)  
        SortedSet<GrantedAuthority> sortedAuthorities =  
            new TreeSet<GrantedAuthority>(new AuthorityComparator());  
  
        for (GrantedAuthority grantedAuthority : authorities) {  
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");  
            sortedAuthorities.add(grantedAuthority);  
        }  
  
        return sortedAuthorities;  
    }
    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {  
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {  
            // Neither should ever be null as each entry is checked before adding it to the set.  
            // If the authority is null, it is a custom authority and should precede others.  
            if (g2.getAuthority() == null) {  
                return -1;  
            }  
  
            if (g1.getAuthority() == null) {  
                return 1;  
            }  
            return g1.getAuthority().compareTo(g2.getAuthority());  
        }  
    }
    public int hashCode() {  
        int code = 9792;  
  
        //若该用户不是登录人员，则可以允许没有authorities。  
        if (null != getUsername() && null != getAuthorities()) {  
            for (GrantedAuthority authority : getAuthorities()) {  
  
                code = code * (authority.hashCode() % 7);  
            }  
        }  
  
        if (this.getPassword() != null) {  
            code = code * (this.getPassword().hashCode() % 7);  
        }  
  
        if (this.getUsername() != null) {  
            code = code * (this.getUsername().hashCode() % 7);  
        }  
  
        if (this.isAccountNonExpired()) {  
            code = code * -2;  
        }  
  
        if (this.isAccountNonLocked()) {  
            code = code * -3;  
        }  
  
        if (this.isCredentialsNonExpired()) {  
            code = code * -5;  
        }  
  
        if (this.isEnabled()) {  
            code = code * -7;  
        }  
  
        return code;  
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();  
        sb.append(super.toString()).append(": ");  
        sb.append("Username: ").append(this.username).append("; ");  
        sb.append("" +  
                "" +  
                ": [PROTECTED]; ");  
        sb.append("UserAccount: ").append(this.userAccount).append("; ");  
        sb.append("UserDept: ").append(this.userDept).append("; ");  
        sb.append("UserDuty: ").append(this.userDuty).append("; ");  
        sb.append("UserDesc: ").append(this.userDesc).append("; ");  
        sb.append("UserSubSystem: ").append(this.subSystem).append("; ");  
        sb.append("UserIsSys: ").append(this.isSys).append("; ");  
        sb.append("Enabled: ").append(this.enabled).append("; ");  
        sb.append("AccountNonExpired: ").append(this.accountNonExpired).append("; ");  
        sb.append("credentialsNonExpired: ").append(this.credentialsNonExpired).append("; ");  
        sb.append("AccountNonLocked: ").append(this.accountNonLocked).append("; ");  
  
        if ( null !=authorities  && !authorities.isEmpty()) {  
            sb.append("Granted Authorities: ");  
  
            boolean first = true;  
            for (GrantedAuthority auth : authorities) {  
                if (!first) {  
                    sb.append(",");  
                }  
                first = false;  
  
                sb.append(auth);  
            }  
        } else {  
            sb.append("Not granted any authorities");  
        }  
  
        return sb.toString();  
    }
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		if (1==enabled) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getUserId() {
		return userId;
	}

	@Override
	public String getUserAccount() {
		return userAccount;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public String getUserPassword() {
		return userPassword;
	}

	@Override
	public String getUserDesc() {
		return userDesc;
	}

	@Override
	public boolean getEnabled() {
		if (1==enabled) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean getIssys() {
		if (1==isSys) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getUserDept() {
		return userDept;
	}

	@Override
	public String getUserDuty() {
		return userDuty;
	}

	@Override
	public String getSubSystem() {
		return subSystem;
	}
}