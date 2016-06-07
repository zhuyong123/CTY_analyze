<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>  
<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>

	<form method="POST" action="uploadFile" enctype="multipart/form-data">
		File to upload: <input type="file" name="file"><br /> 
		Name:    <input type="text" name="name"><br /> 
		Session: <input type="text" name="session" value="MTt0ZWFnZXI7MTQxMjkyMDI3OTUwNw"><br />
		Suffix:  <input type="text" name="suffix" value="jpg"><br />
		<input type="submit" value="Upload"> Press here to upload the file!
	</form>
	
</body>
</html>