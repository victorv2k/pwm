<%--
  ~ Password Management Servlets (PWM)
  ~ http://code.google.com/p/pwm/
  ~
  ~ Copyright (c) 2006-2009 Novell, Inc.
  ~ Copyright (c) 2009-2010 The PWM Project
  ~
  ~ This program is free software; you can redistribute it and/or modify
  ~ it under the terms of the GNU General Public License as published by
  ~ the Free Software Foundation; either version 2 of the License, or
  ~ (at your option) any later version.
  ~
  ~ This program is distributed in the hope that it will be useful,
  ~ but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~ MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  ~ GNU General Public License for more details.
  ~
  ~ You should have received a copy of the GNU General Public License
  ~ along with this program; if not, write to the Free Software
  ~ Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
  --%>

<%@ page import="password.pwm.ContextManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" session="true" isThreadSafe="true"
         contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="pwm" prefix="pwm" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<%@ include file="header.jsp" %>
<body onload="pwmPageLoadHandler();document.forms.activateUser.elements[0].focus();">
<div id="wrapper">
    <jsp:include page="header-body.jsp"><jsp:param name="pwm.PageName" value="Title_ActivateUser"/></jsp:include>
    <div id="centerbody">
        <p><pwm:Display key="Display_ActivateUser"/></p>
        <form action="<pwm:url url='ActivateUser'/>" method="post" name="activateUser"
              enctype="application/x-www-form-urlencoded" onsubmit="handleFormSubmit('submitBtn');" onreset="handleFormClear();">
            <%  //check to see if there is an error
                if (PwmSession.getSessionStateBean(session).getSessionError() != null) {
            %>
            <span id="error_msg" class="msg-error">
                <pwm:ErrorMessage/>
            </span>
            <% } %>

            <%  //check to see if any locations are configured.
                if (!ContextManager.getContextManager(this.getServletConfig().getServletContext()).getConfig().getLoginContexts().isEmpty()) {
            %>
            <h2><pwm:Display key="Field_Location"/></h2>
            <select name="context">
                <pwm:DisplayLocationOptions name="context"/>
            </select>
            <% } %>


            <pwm:ParameterForm formName="activateuser"/>

            <div id="buttonbar">
                <input type="submit" name="button" class="btn"
                       value="     <pwm:Display key="Button_Activate"/>     "
                       id="submitBtn"/>
                <input type="reset" name="reset" class="btn"
                       value="     <pwm:Display key="Button_Reset"/>     "/>
                <input type="hidden"
                       name="processAction"
                       value="activate"/>
                <input type="hidden" name="formID" value="<pwm:FormID/>"/>
            </div>
        </form>
    </div>
    <br class="clear"/>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>