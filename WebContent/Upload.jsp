<%@include file="Header.jsp" %>


<div class="container-login100" >
        <div class="wrap-login1001 p-l-555 p-r-555 p-t-800 p-b-300" style="padding-left: 30px">
      
          <fieldset>
          <legend>upload into db for Shop</legend>
			<form action="UploadControllerShop" method="post" enctype="multipart/form-data">
								id<input type="text" name="id1">
					doc_data<input type="file" name="file_Name1">
					<input type="submit" value="uploadfile">
				</form>
				
		</fieldset>
				<!-- <fieldset><legend>Download from db</legend>
				<form action="download" method="get" >
					Enter Id<input type="text" name="id" value="">
					<input type="submit" value="download"> 
				</form> -->
			
		</div>
	</div>
	
	<div id="dropDownSelect1"></div>
	<div class="container-login100" >
        <div class="wrap-login1001 p-l-555 p-r-555 p-t-800 p-b-300" style="padding-left: 30px">
      
          <fieldset>
          <legend>upload into db for item</legend>
			<form action="UploadControllerItem" method="post" enctype="multipart/form-data">
								id<input type="text" name="id2">
					doc_data<input type="file" name="file_Name2">
					<input type="submit" value="uploadfile">
				</form>
				
		</fieldset>
				<!-- <fieldset><legend>Download from db</legend>
				<form action="download" method="get" >
					Enter Id<input type="text" name="id" value="">
					<input type="submit" value="download"> 
				</form> -->
			
		</div>
	</div>
	
	<div id="dropDownSelect1"></div>
<%@include file="Footer.jsp" %>