<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<form method="post" action="AddProductController" class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>PRODUCTS</legend>

<!-- Text input
<div class="form-group">
  <label class="col-md-4 control-label">PRODUCT ID</label>  
  <div class="col-md-4">
  <input type="text" name="productid" placeholder="PRODUCT ID" class="form-control input-md">
  </div>
</div> -->
    

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label">PRODUCT NAME</label>  
  <div class="col-md-4">
  <input type="text" name="productname" placeholder="PRODUCT NAME" class="form-control input-md" >
  </div>
</div>
    
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" >QUANTITY</label>  
  <div class="col-md-4">
  <input type="text" name="qty" placeholder="QUANTITY" class="form-control input-md">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label">Price</label>  
  <div class="col-md-4">
  <input type="text" name="price" placeholder="Price" class="form-control input-md">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label">IMG URL</label>  
  <div class="col-md-4">
  <input type="text" name="imgUrl" placeholder="URL" class="form-control input-md">
  </div>
</div>

 <!-- File Button 
<div class="form-group">
  <label class="col-md-4 control-label">Select Image</label>
  <div class="col-md-4">
    <input id="filebutton" name="filebutton" class="input-file" type="file">
  </div>
</div>
--> 
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label">Submit Details</label>
  <div class="col-md-4">
    <button type="submit" class="btn btn-primary">Submit</button>
    ${msg}
  </div>
  </div>
  

</fieldset>
</form>
</body>
</html>






    
