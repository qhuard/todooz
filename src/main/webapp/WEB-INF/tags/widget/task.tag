<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ attribute name="task" required="true" type="fr.todooz.domain.Task" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<div>
		<p><fmt:formatDate value="${task.date}" pattern="dd MMM yyyy"/></p>
			<span class="lead">${task.title}</span> 
			<span class="badge badge-info">${task.tags}</span> 
			<span class="badge badge-info">${task.tags}</span>
		<p>${task.text}</p>
	</div>