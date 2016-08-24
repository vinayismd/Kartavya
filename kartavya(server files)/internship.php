<?php
    include_once("config.inc.php");
	
	if(isset($_POST['name']) &&isset($_POST['email']) &&isset($_POST['phone']) &&
       isset($_POST['know']) &&isset($_POST['why'])){
	   
	     $name = $_POST['name'];
	     $email = $_POST['email'];
	     $phone = $_POST['phone'];
	     $know = $_POST['know'];
	     $why = $_POST['why'];
		 $to = 'vinay.27071994@gmail.com';
		 $msg = $name ."\n". $phone."\n". $know ."\n".$why;
		 
		 mail($to,'Application For Internship', $msg ,$email);
		  
		 
		 $query = "INSERT INTO `internship`(`name`, `email`, `phone`, `know`, `why`) 
		           VALUES ('$name','$email','$phone','$know','$why')";
	    
		 $result = $conn->query($query);
		 
		 if($result >0){
		    echo "success";
		    }else{
			echo "Error";
			}
			
			
		
		}
 
?>