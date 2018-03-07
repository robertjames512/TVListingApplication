<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>TV Listing Application</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#207de5;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Television Show
</h1>

<c:url var="addAction" value="/tvshow/add" ></c:url>

<form:form action="${addAction}" commandName="tvshow">
<table>
	<c:if test="${!empty tvshow.title}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="title">
				<spring:message text="Title"/>
			</form:label>
		</td>
		<td>
			<form:input path="title" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="description">
				<spring:message text="Description"/>
			</form:label>
		</td>
		<td>
			<form:input path="description" />
		</td>
	</tr>
<tr>
		<td>
			<form:label path="duration">
				<spring:message text="Duration"/>
			</form:label>
		</td>
		<td>
			<form:input path="duration" />
		</td> 
	</tr>
		<tr>
		<td>
			<form:label path="originalAirDate">
				<spring:message text="Original Air Date"/>
			</form:label>
		</td>
		<td>
			<form:input path="originalAirDate" />
		</td> 
	</tr>
		<tr>
		<td>
			<form:label path="rating">
				<spring:message text="Rating"/>
			</form:label>
		</td>
		<td>
			<form:input path="Rating" />
		</td> 
	</tr>
		<tr>
		<td>
			<form:label path="keywords">
				<spring:message text="Keywords"/>
			</form:label>
		</td>
		<td>
			<form:input path="keywords" />
		</td> 
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty tvshow.title}">
				<input type="submit"
					value="<spring:message text="Edit TV Show"/>" />
			</c:if>
			<c:if test="${empty tvshow.title}">
				<input type="submit"
					value="<spring:message text="Add TV Show"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Television Listings</h3>
<c:if test="${!empty listTvShows}">
	<table class="tg">
	<tr>
		<th width="80">TV Show ID</th>
		<th width="120">Title</th>
		<th width="120">Description</th>
		<th width="120">Duration</th>
		<th width="120">Original Air Date</th>
		<th width="120">Rating</th>
		<th width="120">Keywords</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listTvShows}" var="tvshow">
		<tr>
			<td>${tvshow.id}</td>
			<td>${tvshow.title}</td>
			<td>${tvshow.description}</td>
			<td>${tvshow.duration}</td>
			<td>${tvshow.originalAirDate}</td>
			<td>${tvshow.rating}</td>
			<td>${tvshow.keywords}</td>
			<td><a href="<c:url value='/edit/${tvshow.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${tvshow.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
