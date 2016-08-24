<?php
    include_once("config.inc.php");
	
	$admno = $_POST['admno'];
	
	$query = "SELECT * FROM reg_student where admno='$admno' ";
	
	$result = mysqli_query($conn , $query);
	
	if(mysqli_num_rows($result) >0)
	{
	   
	   $row = mysqli_fetch_assoc($result);
	   
	   echo json_encode(array( "year"=>$row['year'],"name"=>$row['name'],"admno"=>$row['admno'] ,"pass"=>$row['pass'],
	                    "branch"=>$row['branch'] ,"centre"=>$row['centr'],
						"wrkun"=>$row['wrkun'],"team"=>$row['team'] ,"phnno"=>$row['phnno'],"email"=>$row['email']));
	   
	 }  

?>