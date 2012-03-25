<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<s:layout-render name="/WEB-INF/jsp/common/layout.jsp"
	title="Login page">
  
	<s:layout-component name="body">
       

	<div id="loginbox">
	<h2>Enter your credentials</h2>
	<center>
		<br/>
		<s:form beanclass="com.gitent_scm.web.users.LoginActionBean" focus="">
			<s:errors /><s:messages />
			<table >
				<tr>
					<td>Username:</td>
					<td align="right"><s:text id="username" name="username" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td align="right"><s:password id="password" name="password" /></td>
				</tr>
				<tr>
					<td colspan="2" class="button">
					<br/>	
					<s:submit name="login" value="Login" /></td>
				</tr>
			</table>
		</s:form>
		
		<br/>
		
		<c:if test="${!actionBean.privateInstance}">
			<span><img src="${contextPath}/images/arrow_right.png"/>If you don't have an account yet you can <s:link
				beanclass="com.gitent_scm.web.users.SignUpActionBean">signup</s:link>!  </span>
			<br/><br/>
		</c:if>
		
		<span><img src="${contextPath}/images/arrow_right.png"/>If you don't remember your password you may 
		<s:link beanclass="com.gitent_scm.web.users.PasswordForgotActionBean">recover it</s:link>!</span>
		<br/><br/>
		</center>			
	</div>
	<br/>
  </s:layout-component>
</s:layout-render>
